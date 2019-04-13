package com.example.demo.arithmetic.demo1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        int [] Arrays = {10,12,13,321,3,1,13,21,32};
        int [][] Arrays1 = {
                {1,1,1,1,1,1,1},
                {1,0,0,0,1,1,0},
                {1,1,1,1,1,0,0},
                {1,1,0,0,0,1,1},
                {1,1,1,1,1,1,1}
        };
        System.out.println(getCount(Arrays1));
        for (int i = 0; i < Arrays1.length; i++) {
            for (int j = 0; j < Arrays1 [i].length; j++) {
                System.out.print(Arrays1[i][j] + " ");
            }
            System.out.println();
        }
    }
    //得到第二大小岛
    public static int getCount(int [][] arrays){
        List<Integer> countList = new ArrayList<>();
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[0].length; j++) {
                int value = 0;
                if (arrays[i][j] == 0){
                  countList.add(getCount(arrays,i,j));
                }
            }
        }
        countList.removeIf((s) ->s==0);
        if (countList.size() >=2){
            Collections.sort(countList);
            return countList.get(1);
        }
        if (countList.size() ==1){
            return countList.get(0);
        }
        return 0;
    }
    //得到小岛的面积
    public static int getCount(int [][] arrays,int i,int j){
        if (i ==1&&j==1) {
            System.out.println("");
        }
        int count =1;
        if (!check(arrays,i,j)){
            return 0;
        }
        if (arrays[i+1][j] == 0){
            if (check(arrays,i+1,j)){
                count+=getCount(arrays,i+1,j);
            } else {
                return 0;
            }
        }
        if (arrays[i-1][j] == 0){
            if (check(arrays,i-1,j)){
                count+=getCount(arrays,i-1,j);
            } else {
                return 0;
            }
        }
        if (arrays[i][j+1] == 0){
            if (check(arrays,i,j+1)){
                count+=getCount(arrays,i,j+1);
            } else {
                return 0;
            }
        }
        if (arrays[i][j-1] == 0){
            if (check(arrays,i,j-1)){
                count+=getCount(arrays,i,j-1);
            } else {
                return 0;
            }
        }
        return count;

    }
    //检查是否是边界
    public static boolean check(int [][] arrays,int i,int j){
        arrays[i][j] = 2;
        if (i -1 >= 0 && i + 1 < arrays.length && j - 1 >= 0 && j + 1 < arrays [0].length){
            return true;
        }
         return false;
    }

}
