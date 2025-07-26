package test;

import java.util.Random;

public class Test1 {
    public static void main(String[] args) {
        int[] tempArr = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        Random random = new Random();
        for(int i = 0; i < tempArr.length; i++){
            int temp = tempArr[i];
            int randomIndex = random.nextInt(tempArr.length);
            tempArr[i] = tempArr[randomIndex];
            tempArr[randomIndex] = temp;
        }
        int[][] tempArr2 = new int[4][4];
        for(int i = 0; i < tempArr.length; i++){
            tempArr2[i / 4][i % 4] = tempArr[i];
        }
        for (int[] ints : tempArr2) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
        }
    }
}
