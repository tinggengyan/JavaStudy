package com.steve.sort;

/**
 * Created by steveyan on 4/7/17.
 */
public class ShellSort {

    /**
     * 希尔排序的原理:根据需求，如果你想要结果从大到小排列，它会首先将数组进行分组，然后将较大值移到前面，
     *
     * 较小值移到后面，最后将整个数组进行插入排序，这样比起一开始就用插入排序减少了数据交换和移动的次数，
     *
     * 可以说希尔排序是加强版的插入排序拿数组5, 2, 8, 9, 1, 3，4来说，数组长度为7，当increment为3时，
     *
     * 数组分为两个序列5，2，8和9，1，3，4，第一次排序，9和5比较，1和2比较，3和8比较，4和比其下标值小increment的数组值相比较
     *
     * 此例子是按照从大到小排列，所以大的会排在前面，第一次排序后数组为9, 2, 8, 5, 1, 3，4 第一次后increment的值变为3/2=1,
     *
     * 此时对数组进行插入排序，实现数组从大到小排
     */

    private static void shellSort(int[] data) {

        // 步长作为遍历条件
        for (int tap = data.length / 2; tap > 0; tap /= 2) {

            for (int i = 0; i < data.length; i += tap) {

                int temp = data[i];
                int j = i;

                for (; j > tap && data[j - tap] > temp; j -= tap) {
                    data[j] = data[j - tap];
                }

                data[j] = temp;

            }

        }

    }


    public static void main(String[] args) {

        int[] num = new int[]{7, 1, 2, 4, 8, 9, 5, 3, 6, 0};

        shellSort(num);

        for (int i : num) {
            System.out.println(i);
        }

    }


}
