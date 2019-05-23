package bittech.test;

import java.util.*;

//找出逆序对
public class AntiOrder {
    public int count(int[] A, int n) {
        if(A==null||n==0){
            return 0;
        }
        return mergeCount(A,0,n-1);
    }

    public static int mergeCount(int[] a,int l,int r){
        if(l==r){
            return 0;
        }
        int mid = (l+r)/2;
        return mergeCount(a,l,mid)+mergeCount(a,mid+1,r)+merge(a,l,mid,r);
    }

    public static int merge(int[] a,int l,int mid,int r){
        int temp[] = new int[r-l+1];
        int i = l;
        int j = mid+1;
        int k = 0;
        int count = 0;
        while(i<=mid && j<=r){
            if(a[i]<=a[j]){
                temp[k++] = a[i++];
            }else{
                count += mid-i+1;
                temp[k++] = a[j++];
            }
        }
        while(i<=mid){
            temp[k++] = a[i++];
        }
        while(j<=r){
            temp[k++] = a[j++];
        }
        for(int n =0;n<temp.length;n++){
            a[l++] = temp[n];
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5,6,7,0};
        AntiOrder antiOrder = new AntiOrder();
        System.out.println(antiOrder.count(a,a.length));
    }
}
