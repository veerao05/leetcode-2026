package leetcode.arrays;

public class PairCloseToSum {
    public static void main(String[] args) {
        int[] arr = { 10, 22, 28, 29, 30, 40 };
        int x = 54;
        int n = arr.length;
        printClosest(arr, n, x);

    }

    private static void printClosest(int[] arr, int n, int x) {
        int leftIndex =0;
        int rightIndex =0;
        int temp= Integer.MAX_VALUE;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n;j++){
                if(Math.abs(arr[i]+arr[j]-x)<temp){
                    leftIndex=i;
                    rightIndex=j;
                    temp=Math.abs(arr[i]+arr[j]-x);
                }
            }
        }
        System.out.println("The closest pair is "+ arr[leftIndex] + " and "+ arr[rightIndex]);
    }
}
