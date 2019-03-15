package bittech2;

public class SortThree {
    public static void main(String[] args) {
        int[] data = new int[]{3,5,1,2,4,7,6};
//        quickSort(data);
        twoQuickSort(data);
        for(int i:data){
            System.out.print(i+"、");
        }
    }
    public static void quickSort(int[] arr){
        int n = arr.length;
        if(n<=1){
            return;
        }
        quickSortInternal(arr,0,n-1);
    }
    private static void quickSortInternal(int[] arr,int l,int r){
        if(l>=r){
            return;
        }
        int q = chooseIndex(arr,l,r);
        quickSortInternal(arr,l,q-1);
        quickSortInternal(arr,q+1,r);
    }
    private static int chooseIndex(int[] arr,int l,int r){
        //int value = arr[l]; //默认第一个元素为基准值
        int randomIndex = (int)(Math.random()*(r-l+1)+l);//返回下标为l...r的任意一个数
        swap(arr,randomIndex,l);//把这个随机生成的基准值与第一个元素交换
        int value = arr[l];
        int j = l;
        int i = l+1;
        for(;i<=r;i++){
            if(arr[i]<value){
                swap(arr,j+1,i);
                j++;
            }
        }
        swap(arr,j,l);
        return j;
    }
    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void twoQuickSort(int[] arr){
        int n = arr.length;
        if(n<=1){
            return;
        }
        quickSortInternal(arr,0,n-1);
    }
    private static void twoQuickInternal(int[] arr,int l,int r){
        if(l>=r){
            return;
        }
        int q = chooseIndex2(arr,l,r);
        twoQuickInternal(arr,l,q-1);
        twoQuickInternal(arr,q+1,r);
    }
    private static int chooseIndex2(int[] arr,int l,int r){
        int randomIndex = (int)(Math.random()*(r-l+1)+l);
        swap(arr,l,randomIndex);
        int value = arr[l];
        int i = l+1;//从前往后遍历的指针
        int j = r;//从后往前遍历的指针
        while(true){ //扫描区间：j+1...r
            while(i<=r&&arr[i]<value){
                i++;
            }
            while(j>=l+1&&arr[j]>value){//从后往前扫描
                j--;
            }
            if(i>j){
                break;
            }
            swap(arr,i,j);
            i++;
            j--;
        }
        swap(arr,l,j); //j指向小于当前元素区域的最后一个元素！！！
        return j;
    }
}
