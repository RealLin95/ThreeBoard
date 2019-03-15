package bittech2;

public class SortFour {
    public static void main(String[] args) {
        int[] data = new int[]{5,3,2,1,4,6,0,8,6,};
        quickSort3(data);
        for(int i:data){
            System.out.print(i+"、");
        }
    }
    public static void quickSort3(int[] arr){
        int n = arr.length;
        if(n<=1){
            return;
        }
        quickSortInternal(arr,0,n-1);
    }
    private static void quickSortInternal(int[] arr,int l,int r){
//        if(l>=r){
//            return;
//        }
        //优化：
        if(r-l<=15){
            insertSort(arr,l,r);
            return;
        }
        int randomIndex = (int)(Math.random()*(r-l+1))+l;
        swap(arr,l,randomIndex);
        int value = arr[l];
        int lt = l;//小于域的最后一个元素
        int gt = r+1;//大于域的第一个元素
        int i = l+1;//要开始遍历的元素
        while(i<gt){ //要扫描的元素不能超过最大索引
            if(arr[i]<value){
                swap(arr,lt+1,i);
                lt++;
                i++;
            }else if(arr[i]>value){
                swap(arr,gt-1,i);//将大的加在大于域，此时arr[i]为原来的arr[gt-1]，就是现在将要比较的下一个元素
                gt--;
            }else{
                i++;
            }
        }
        swap(arr,lt,l);
        quickSortInternal(arr,l,lt-1);
        quickSortInternal(arr,gt,r);
    }
    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private static void insertSort(int[] arr,int l,int r){
        for(int i = l+1;i<=r;i++){
            int value = arr[i];
            int j = i-1;
            for(;j>=0;j--){
                if(value<arr[j]){
                    arr[j+1] = arr[j];
                }else{
                    break;
                }
            }
            arr[j+1] = value;
        }
    }
}