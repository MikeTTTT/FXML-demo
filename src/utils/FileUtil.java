package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * @author M.T.
 */
public class FileUtil {

    public static String txt2String(File file){
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result.append(System.lineSeparator()+s);
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result.toString();
    }


    public static String getFileType(Object file){
        if (!(file instanceof File)){
            System.out.println("Wrong type");
            return  null;
        }else{
            String fileName = ((File) file).getName();
            String fileType = fileName.substring(fileName.lastIndexOf("."));
            System.out.println("File name: " + fileName + "\n" + "File type: " + fileType );
            return fileType;
        }
    }
}
