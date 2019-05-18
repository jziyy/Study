package com.example.demo.test.demo.io.File;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Dingzhi {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\admin\\Desktop\\JPEGImages");
        File[] files = file.listFiles();
        for (File file2 : files) {
            System.out.println(file2.getAbsolutePath());
        }
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<files.length; i++) {
            for(int j=0;j<files.length;j++) {
                if(i==j) {
                    continue;

                }
                if((files[i].getName().replaceAll(".jpg", "").replaceAll(".xml", "")).equals(files[j].getName().replaceAll(".jpg", "").replaceAll(".xml", ""))) {
                    list.add(i);
                    break;
                }
            }
        }

        for(int i=0; i<files.length;i++) {
            if(list.contains(i)) {
                continue;
            }
            files[i].delete();
        }


    }

    public static void groupFolder(String folderPath,String resultFolderPath){
        String resultPath1 = resultFolderPath + "";
        String resultPath2 = resultFolderPath + "";

    }
}
