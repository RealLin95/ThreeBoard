package bittech.test;

import java.util.ArrayList;
import java.util.Scanner;
public class Solution {
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        for(int i = 0;i<B.length;i++){
            int ret = 1;
            for(int j = 0;j<B.length;j++){
                if(j!=i){
                    ret *= A[j];
                }
            }
            B[i] = ret;
        }
        return B;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        while(scanner.hasNext()){
            list.add(scanner.nextInt());
            int[] a = new int[list.size()];
            for(int i = 0;i<list.size();i++){
                a[i] = list.get(i);
            }
            int[] b = solution.multiply(a);
            for(int i = 0;i<b.length;i++){
                System.out.print(b[i]+" ");
            }
        }
    }
}
