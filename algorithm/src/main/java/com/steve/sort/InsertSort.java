package com.steve.sort;

/**
 * Created by steveyan on 4/7/17.
 */
public class InsertSort {


    private static void insertSort(int[] numbers) {

        // 第一层循环遍历
        for (int i = 0; i < numbers.length; i++) {

            int n1 = numbers[i];

            // 默认前 i-1 个已经是有序的,遍历有序部分,需要插入位置
            for (int j = 0; j < i; j++) {
                int n2 = numbers[j];

                if (n1 < n2) {
                    // 进行插入位置及其之后的内容后移
                    for (int m = i; m > j; m--) {
                        numbers[m] = numbers[m - 1];
                    }
                    numbers[j] = n1;
                    break;

                }

            }

        }

    }

    /**
     * 插入排序
     *
     * 从第一个元素开始，该元素可以认为已经被排序 取出下一个元素，在已经排序的元素序列中从后向前扫描 如果该元素（已排序）大于新元素，将该元素移到下一位置 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置 将新元素插入到该位置中 重复步骤2
     *
     * @param numbers 待排序数组
     */
    private static void insertSort2(int[] numbers) {

        int j = 0;
        // 遍历
        for (int i = 0; i < numbers.length; i++) {

            int n = numbers[i];

            // 从当前位置开始往前挨个比较,如若需要调换位置就直接调换位置
            j = i;
            for (; j > 0 && numbers[j - 1] > n; j--) {
                numbers[j] = numbers[j - 1];
            }
            // 确定当前元素的正确位置
            numbers[j] = n;

        }


    }


    public static void main(String[] args) {

        int[] num = new int[]{7, 1, 2, 4, 8, 9, 5, 3, 6, 0};

        insertSort(num);

        for (int i : num) {
            System.out.println(i);
        }

    }

}
