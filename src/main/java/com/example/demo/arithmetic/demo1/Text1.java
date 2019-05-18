package com.example.demo.arithmetic.demo1;

public class Text1 {
    public static void main(String[] args) {

        int [] Arrays = {-15,-12,-9,-6,-3,0,3,6,9};
        sort(Arrays);
        int [][] matrix = new int[3][3];
        suduku(matrix,Arrays);


    }
    //判断是否符合，符合则输出有解不符合则输出无解
    public static void suduku(int [][] arrays,int [] array){
        arrays [0][1] = array[0];
        int x = 0;
        int y = 1;
        for (int i = 0; i < array.length; i++) {
            x=x+1;
            y=y-1;
            if (x>2){
                x=0;
            }
            if (y<0){
                y=2;
            }
            arrays[x][y] = array[i];
        }
        //计算九宫格中每一行，列，斜对角线上的值
        int row1 = arrays[0][0] + arrays[0][1] + arrays[0][2];
        int row2 = arrays[1][0] + arrays[1][1] + arrays[1][2];
        int row3 = arrays[2][0] + arrays[2][1] + arrays[2][2];
        int line1 = arrays[0][0] + arrays[1][0] + arrays[2][0];
        int line2 = arrays[0][1] + arrays[1][1] + arrays[2][1];
        int line3 = arrays[0][2] + arrays[1][2] + arrays[2][2];
        int  diagonal1 = arrays[0][0] + arrays[1][1] + arrays[2][2];
        int  diagonal2 = arrays[2][0] + arrays[1][1] + arrays[0][2];
        if (row1 == row2 && row2 == row3 && row3 == line1 && line1 == line2
                && line2 == line3 && line3 == diagonal1 && diagonal1 == diagonal2){
            System.out.println("有解");
        }else{
            System.out.println("无解");
        }

    }


    //将数组进行排序
    public static void sort(int [] arrays){
        sort(arrays,0,arrays.length -1);
    }
    public static void sort(int [] arrays,int left,int right){
        if (left >= right){
            return;
        }
        int temp = arrays[left];
        int i =left;
        int j =right;
        int value = 0;
        while (i < j){
            while (i<j && arrays[j] >= temp){
                j--;
            }
            while (i<j && arrays[i] <= temp) {
                i++;
            }
            value = arrays[j];
            arrays[j] = arrays[i];
            arrays[i] = value;
        }
        arrays[left] = arrays[j];
        arrays[j] =temp;
        sort(arrays,left,i-1);
        sort(arrays,i+1,right);
    }

}
