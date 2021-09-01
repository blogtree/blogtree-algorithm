package idea;

import java.util.ArrayList;
import java.util.List;

public class HotKey {

    /**
     * itar + Tab
     * 注意：在数组下方输入命令，能达到效果
     * 注意：变量名后缀为s，才能达到最佳效果
     */
    public void itar1() {
        int[] numArr = new int[]{1, 2, 3};
        for (int i = 0; i < numArr.length; i++) {
            int i1 = numArr[i];

        }

        int[] nums = new int[]{1, 2, 3};
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

        }
    }

    /**
     * itar + Tab
     * 注意：在列表下方输入itar，效果不佳
     */
    public void itar2() {
        List<Integer> nums = new ArrayList<>();
        // for (int i = 0; i < array.length; i++) {
        //      = array[i];
        //
        // }
    }

    /**
     * iter + Tab
     * 注意：在数组下方输入命令，能达到效果
     * 注意：变量名后缀为s，才能达到最佳效果
     */
    public void iter1() {
        int[] nums = new int[]{1, 2, 3};
        for (int num : nums) {

        }
    }

    /**
     * iter + Tab
     * 注意：在数组或列表下方输入命令，能达到效果
     * 注意：变量名后缀为List 或 s，才能达到最佳效果
     */
    public void iter2() {
        List<Integer> numList = new ArrayList<>();
        for (Integer integer : numList) {

        }

        List<Integer> nums = new ArrayList<>();
        for (Integer num : nums) {

        }
    }

    /**
     * itli + Tab
     * itli 对列表比较友好
     */
    public void itli() {
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < numList.size(); i++) {
            Integer integer = numList.get(i);

        }
    }

    /**
     * fori + Tab
     * fori 就是生成一个普通的for循环
     */
    public void fori() {
        // for (int i = 0; i < ; i++) {
        //
        // }
        //
        // int[] numArr = new int[]{1, 2, 3};
        // for (int i = 0; i < ; i++) {
        //
        // }

        // int[] nums = new int[]{1, 2, 3};
        // for (int i = 0; i < ; i++) {
        //
        // }
    }
}
