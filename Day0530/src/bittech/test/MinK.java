package bittech.test;

import java.util.Scanner;

public class MinK {
    public static void quickSort(int[] arr,int l,int r){
        if(l>r){
            return;
        }
        int p = partition(arr,l,r);
        quickSort(arr,l,p-1);
        quickSort(arr,p+1,r);
    }
    public static int partition(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r + 1;
        int num = arr[r];
        while (l < more) {
            if (arr[l] > num) {
                swap(arr, l, --more);
            } else if (arr[l] < num) {
                swap(arr, l++, ++less);
            } else {
                l++;
            }
        }
        return less + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            String[] s = str.split(" ");
            int[] data = new int[s.length - 1];
            for (int i = 0; i < data.length; i++) {
                data[i] = Integer.valueOf(s[i]);
            }
            int k = Integer.valueOf(s[s.length - 1]);
            quickSort(data,0,data.length-1);
            for(int i = 0;i<k;i++){
                System.out.print(data[i]+" ");
            }
        }
    }
}