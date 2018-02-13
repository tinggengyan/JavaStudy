package com.steve.sort;

/**
 * 书本案例 <p> <p> Created by steveyan on 2/12/18.
 */
public class QuickSort2 {

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    private static void qs(int[] array, int start, int end) {
        if (start < end) {

            int middle = determine(array, start, end);

            qs(array, start, middle - 1);
            qs(array, middle + 1, end);
        }

    }

    private static int determine(int[] array, int start, int end) {

        int p = array[end];

        while (start < end) {

            while (start < end && array[start] < p) {
                start++;
            }
            array[end] = array[start];

            while (start < end && array[end] > p) {
                end--;
            }
            array[start] = array[end];

        }

        // 此时 start 和 end 是相等的.
        array[end] = p;
        return end;
    }


    public static void main(String[] args) {
        int[] ints = new int[]{7, 1, 2, 4, 8, 9, 5, 3, 6, 0};
        qs(ints, 0, ints.length - 1);

        for (int anInt : ints) {

            System.out.println(anInt);
        }

    }
}
