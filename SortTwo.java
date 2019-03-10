package bittech2;

public class SortTwo {
    public static void main(String[] args) {
        int[] data = {4,5,6,1,2,3};
//        binarySort(data);
//        Shell(data);
//        choiceSort(data);
        mergeSort(data);
        for(int i:data){
            System.out.print(i+"、");
        }
    }
    public static void binarySort(int[] arr){
        int n = arr.length;
        if(n<=1){
            return;
        }else{
            for(int i = 1;i<n;i++){
                int value = arr[i];
                int j = i-1;
                int low = 0;
                int high = i-1;
                if(value<arr[j]){
                    while(high>=low){
                        int mid = low+(high-low)/2;
                        if(value>arr[mid]){
                            low = mid+1;
                        }else{
                            high = mid-1;
                        }
                    }
                    for(;j>=high+1;j--){
                        arr[j+1] = arr[j];
                    }
                    arr[j+1] = value;
                }
            }
        }
    }
    public static void Shell(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        int step = n / 2;
        while (step >= 1) {
            for (int i = step; i < n; i++) {
                int value = arr[i];
                int j = i - step;
                for (; j >= 0; j -= step) {
                    if (value < arr[j]) {
                        arr[j + step] = arr[j];
                    } else {
                        break;
                    }
                }
                arr[j + step] = value;
            }
            step = step / 2;
        }
    }
    public static void choiceSort(int[] arr){
        int n = arr.length;
        if(n<=1){
            return;
        }
        for(int i = 0;i<n-1;i++){
            int min = i;
            for(int j = i+1;j<n;j++){
                if(arr[j]<arr[min]){
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
    public static void mergeSort(int[] arr){
        int n = arr.length;
        if(n<=1){
            return;
        }
        mergeInternal(arr,0,n-1);
    }
    //拆分函数
    private static void mergeInternal(int[] arr,int low,int high){
        //递归出口！！！
        if(low>=high){
            return;
        }
        int mid = low+(high-low)/2;
        //左边小数组
        mergeInternal(arr,low,mid);
        //右边小数组
        mergeInternal(arr,mid+1,high);
        //分治结束，进行合并
        merge(arr,low,mid,high);
    }
    //合并函数
    private  static void merge(int[] arr,int left,int mid,int right){
        int i = left;
        int j = mid+1;
        int k = 0;
        int[] temp = new int[right-left+1];
        while(i<=mid && j<=right){
            if(arr[i]<=arr[j]){
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
            }
        }
        while(i<=mid){
            temp[k++] = arr[i++];
        }
        while(j<=right){
            temp[k++] = arr[j++];
        }
        for(int m = 0;m<temp.length;m++){
            arr[left+m] = temp[m];
        }
    }
}
