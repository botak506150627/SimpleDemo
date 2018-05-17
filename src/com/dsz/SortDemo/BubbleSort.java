package com.dsz.SortDemo;



public class BubbleSort {
    public static int[] bubble(int[] arr){
        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] =temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int a[] = {2,6,7,1,5,3,8,4,9};
        int b[] = bubble(a);
        for (int i = 0;i<a.length;i++){
            System.out.println(b[i]);
        }
    }
}
