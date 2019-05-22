package bittech.test;
import java.util.*;

public class Finder {
    public int findKth(int[] a, int n, int K) {
        if(a==null||n==0||n<K){
            throw new IllegalArgumentException("参数不合法！");
        }
        return findPart(a,0,n-1,K);
    }

    public int findPart(int[] a,int l,int r,int K){
        int mid = partition(a,l,r);
        if(K-1>mid){
            return findPart(a,mid+1,r,K);
        }else if(K-1<mid){
            return findPart(a,l,mid-1,K);
        }else {
            return a[mid];
        }
    }

    public int partition(int[] a,int l,int r){
        int temp = a[r];
        int more = l-1;
        int less = r+1;
        while(l<less){
            if(a[l]>temp){
                swap(a,++more,l++);
            }else if(a[l]<temp){
                swap(a,--less,l);
            }else{
                l++;
            }
        }
        return more+1;
    }

    public void swap(int[] a,int l,int r){
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,3,5,2,2};
        Finder finder = new Finder();
        System.out.println(finder.findKth(a,a.length,2));
    }
}
