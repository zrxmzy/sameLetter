import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 1.读取文件
 * 2.单词排序，当成key放入map  value表示单词
 */
public class LetterImpl {
    public static ArrayList doSomething() {
        ArrayList list = new ArrayList();
        File file = new File("D:\\one\\project\\sameLetter\\out\\production\\sameLetter\\source.txt");
        if (!file.exists()){
            System.out.println("文件为空");
            return null;
        }
        HashMap<String,ArrayList> map = new HashMap<>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            while ( br.readLine() != null){
                String str = br.readLine();
                // str按照字母排序
                String key = sort(str);
                // 判断Map中是否有
                if (map.containsKey(key)) {
                    map.get(key).add(str);
                } else {
                    ArrayList mapList = new ArrayList();
                    mapList.add(str);
                    map.put(key,mapList);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        list.add(map);
        return list;
    }
    public static String sort(String str){
        char[] chars = str.toCharArray();
        char temp ;
        for (int i=0;i<str.length();i++){
            for (int j=str.length()-1;j>i;j--){
                if (chars[j]<=chars[j-1]){
                    temp = chars[j];
                    chars[j] = chars[j-1];
                    chars[j-1] = temp;
                }
            }
        }
        String result="";
        for (int i=0;i<chars.length;i++){
            result+=chars[i];
        }
        return result;
    }
    public static void main(String[] args) {
        ArrayList arrayList = doSomething();
        for (int i=0;i<arrayList.size();i++){
            HashMap<String,ArrayList> map = (HashMap) arrayList.get(i);
            for (String key:map.keySet()){
                if (map.get(key).size()<=1)
                    continue;
                System.out.println(map.get(key));
            }
        }
    }
}
