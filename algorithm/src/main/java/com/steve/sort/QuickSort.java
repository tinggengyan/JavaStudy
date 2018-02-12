package com.steve.sort;

/**
 * Created by steveyan on 4/7/17.
 */
public class QuickSort {

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    private static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int lowerIndex = start;// 记录比标兵小的，最近一个需要替换的位置
        for (int i = start; i < end; i++) {
            if (array[i] < pivot) {
                swap(array, i, lowerIndex);
                lowerIndex++;
            }
        }
        swap(array, lowerIndex, end);
        return lowerIndex;
    }


    private static void qs(int[] array, int start, int end){
        if (start < end) {
            int PIndex = partition(array, start, end);
            qs(array, start, PIndex - 1);
            qs(array, PIndex + 1, end);
        }
    }

    public static void main(String[] args) {

        int[] num = new int[]{7, 1, 2, 4, 8, 9, 5, 3, 6, 0};

        int start = 0;
        int end = num.length - 1;

        qs(num,start,end);


        for (int i : num) {
            System.out.println(i);
        }

    }

}
