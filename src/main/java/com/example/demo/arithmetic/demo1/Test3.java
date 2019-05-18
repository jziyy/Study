package com.example.demo.arithmetic.demo1;

public class Test3 {
    public static void main(String[] args) {
        //当本金为1时
        int [] Arrays = {10,12,13,321,3,1,13,21,32};
        int min = Arrays[0];
        int max =0;
        //找到左侧部分的最小值 依次与右侧相减得到最大的数
        for (int i = 1; i < Arrays.length; i++) {
            if (Arrays[i] < min){
                min = Arrays[i];
            }
            if (max < Arrays[i] - min){
                max = Arrays[i] - min;
            }

        }
        System.out.println(max);



    }




    public static int [] sort(int[] arrays){
        int [] array1 =arrays;
        sort(array1,0,arrays.length -1);
        return array1;
    }
    public static void sort(int [] arrays,int left,int right){
        int x = left;
        int y = right;
        if (x>y){
            return;
        }
        int temp = arrays[left];
        int value = 0;


        while(x<y){
            while (arrays[y] >= temp && x < y){
                y--;
            }
            while (arrays[x] <= temp && x < y){
                x++;
            }
            value =arrays[y];
            arrays[y] = arrays [x];
            arrays[x] = value;

        }

        arrays[left] = arrays [y];
        arrays[y] = temp;
        sort(arrays,left,x-1);
        sort(arrays,x + 1,right);

    }
}
