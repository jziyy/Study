package aaaa.work_picture;

import org.springframework.util.StringUtils;

import java.io.*;
import java.util.Arrays;

public class FindTimeAndCount {
    public static void main(String[] args){
        File file = new File(new String("E:\\work\\表格梳理"));

        File [] files = file.listFiles(File::isDirectory);
        System.out.println(file.getAbsolutePath());
        //                           ����
        Arrays.stream(files).forEach((file1)->{
            System.out.println("----"  + file1.getName());
            Arrays.stream(file1.listFiles()).forEach((file2)->{
                file2 = file2.listFiles()[0];
                Arrays.stream(file2.listFiles(File::isFile)).forEach((file3) ->{
                    if ( file3.getName().split("\\.")[1].equals("txt")){
                        search(file3,0);
                        System.out.println();

                    }
                });
            });
        });

    }

    public static boolean search(File file,int aa){
        if (file.getParentFile().getName().equals("smoking")){

        }else {

            System.out.println("-" + file.getParentFile().getName());
        }
        try {

            System.out.println(file.getParentFile().listFiles(File::isDirectory)[0].listFiles(File::isFile).length);
        }catch (NullPointerException | ArrayIndexOutOfBoundsException e){
            System.out.println();
        }

        try {
            BufferedReader bufferedReader =new BufferedReader(new FileReader(file));
            String secondEndLine = "";
            String endline = "";
            while(true){
                endline = bufferedReader.readLine();
                if (endline==null){
                    break;
                }
                secondEndLine = endline.trim();

            }
            // if (StringUtils.isEmpty(secondEndLine)){

            String [] strings = secondEndLine.split("[^0-9]");
            for (int i = 0; i < strings.length; i++) {
                if (StringUtils.isEmpty(strings[i])){
                    continue;
                }
                if (i==strings.length -1){
                    System.out.println(strings[i] + "ms");

                }else {
                    System.out.print (strings[i] + " ");
                }

            }


            File[] file1 = file.getParentFile().getParentFile().listFiles();

            if (aa > file1.length - 1){
                System.out.println("");
                return false;
            }
            File file3 = null;
            if (file1[aa]==null || file1[aa].listFiles(File::isFile) ==null){
                return false;
            }
            if (file1[aa].listFiles(File::isFile).length > 0) {
                file3 = file1[aa].listFiles(File::isFile)[0];
            }
            if (file3==null) {
                search(file, ++aa);
            }else {
                search(file3,++aa);
            }
            return true;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
