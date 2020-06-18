package cn.tjrac.sytstem.controler;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author Rui3g
 * @date 2020/5/27 16:09
 */
public class Test {
    /*把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
12345-32145-34125-
*/
    public static void main(String[] args){
        TreeSet set = new TreeSet();
        set.add(1);
        set.add(2);
        set.add(6);
        set.add(3);
        Iterator treeit=set.iterator();
        while(treeit.hasNext())
        {

            System.out.println(treeit.next());
        }
        /*Scanner sc = new Scanner(System.in);
        System.out.println("请输入数组：");
        int[] a= new int[10];
        for (int i = 0;i<a.length;i++){
            int s= sc.nextInt();
            a[i] = s;
        }
        rotate(a,5);*/
        /*int[] a = {1,2,3,4,5,6,7,8,9};
        minNumberInRotateArray(a);*/
    }

    public static void rotate(int[] nums,int k) {
        k=k%nums.length;

        if(nums.length!=0 && nums.length!=1){
            int[] newarray=new int[nums.length];
            for(int i=0;i<nums.length;i++){
                if(i+k<=nums.length-1){
                    newarray[i+k]=nums[i];
                }
                else if(i+k>nums.length-1){
                    newarray[i+k-nums.length]=nums[i];
                }
            }

            for(int i=0;i<nums.length;i++){
                nums[i]=newarray[i];
            }
            System.out.println("==输出旋转数组==");
            for (int e: nums){
                System.out.print(e);
            }
        }
        else if(nums.length==1){
            return;
        }
    }

    public static int minNumberInRotateArray(int [] array) {
        if(array.length==0){
            return 0;
        }
        if(array.length==1){
            return array[0];
        }
        for(int i=0;i<array.length-1;i++){
            if(array[i]>array[i+1]){
                return array[i+1];
            }else{
                if(i==array.length-2){
                    return array[0];
                }
            }
        }
        return 0;
    }


}
