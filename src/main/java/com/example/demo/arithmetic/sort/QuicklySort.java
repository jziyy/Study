package com.example.demo.arithmetic.sort;

public class QuicklySort {
    public static void main(String[] args) {
        int [] Arrays = {0,12,13,321,3,1,13,21,32};
        quickSort(Arrays);
        for (int i = 0; i < Arrays.length; i++) {
            System.out.println(Arrays[i]);
        }
    }
    public static void quickSort(int [] Arrays){
        quickSort(Arrays,0,Arrays.length -1);
    }
    public static void quickSort(int [] Arrays,int left,int right){

        if (left >= right){
            return;
        }
        int temp = Arrays[left];
        int i = left;
        int j = right;
        int value ;
        while (i!=j){
            while (j > i && Arrays[j] >= temp){
                j--;
            }
            while (i < j && Arrays[i] <= temp){
                i++;
            }
            if (i<j){
            value = Arrays[i];
            Arrays[i] = Arrays[j];
            Arrays[j] = value;
            }
        }
        Arrays[left] =Arrays[i];
        Arrays[i] = temp;
        quickSort(Arrays,left,i-1);
        quickSort(Arrays,i+1,right);
    }
}
