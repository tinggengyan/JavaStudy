package com.steve.sort;

/**
 * 在要排序的一组数中，选出最小的一个数与第一个位置的数交换；
 * <p>
 * 然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止。
 * <p>
 * Created by steveyan on 4/7/17.
 */
public class SelectionSort {
    /**
     * 选择排序算法
     * 在未排序序列中找到最小元素，存放到排序序列的起始位置
     * 再从剩余未排序元素中继续寻找最小元素，然后放到排序序列末尾。
     * 以此类推，直到所有元素均排序完毕。
     */
    public static void selectSort(int[] numbers) {
        int size = numbers.length; //数组长度
        int temp = 0; //中间变量

        for (int i = 0; i < size; i++) {
            int k = i;   //待确定的位置
            //选择出应该在第i个位置的数
            for (int j = size - 1; j > i; j--) {
                if (numbers[j] < numbers[k]) {
                    k = j;
                }
            }
            //交换两个数
            temp = numbers[i];
            numbers[i] = numbers[k];
            numbers[k] = temp;
        }
    }

    public static void main(String[] args) {
        int[] num = new int[]{7, 2, 1, 4, 8, 9, 5, 3, 6};
        selectSort(num);
        for (int i : num) {
            System.out.println(i);
        }
    }

}
