package bittech2;

public class Test {
    public static void main(String[] args) {
        int[] data = new int[]{2,4,5,3,1,8,6,7};
//        bubbleSort(data);
//        insertSort(data);
//        binarySort(data);
//        ShellSort(data);
//        selectSort(data);
        mergeSort(data);
        for(int i:data){
            System.out.print(i+"、");
        }
    }
    /* 1.冒泡排序：
       时间复杂度：O(n^2)
       空间复杂度：O(1)
       稳定性：是
    * */
    public static void bubbleSort(int[] arr){
        int n = arr.length;
        if(n<=1){
            return;
        }
        for(int i = 0;i<n;i++){
            boolean flag = false;//不进for循环说明此时已经有序
            for(int j = 0;j<n-1-i;j++){
                if(arr[j]>arr[j+1]){
                    flag = true; //此时还不是有序数组
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if(!flag){
                break;
            }
        }
    }
    /* 2.快速插入排序：
       时间复杂度：O(n^2)
       空间复杂度：O(1)
       稳定性：是
    * */
    public static void insertSort(int[] arr){
        int n = arr.length;
        if(n<=1){
            return;
        }
        for(int i =1;i<n;i++){
            int value = arr[i];//无序数组的第一个元素
            int j = i-1;//有序数组的最后一个元素
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
    /* 3.折半插入排序
       时间复杂度：O(n^2)
       空间复杂度：O(1)
       稳定性：是
       优化点：将快速插入排序的寻找插入位置使用二分查找进行优化
    * */
    public static void binarySort(int[] arr){
        int n = arr.length;
        for(int i = 1;i<n;i++){//i是无序数组的第一个
            int value = arr[i];
            int low = 0;
            int high = i-1;//high为有序数组的最后一个位置
            int j = i-1;//j是有序数组的最后一个
            if(value<arr[j]){
                while(low<=high){
                    int mid = low+(high-low)/2;
                    if(value>arr[mid]){
                        low = mid+1;
                    }else{
                        high = mid-1;
                    }
                }
                //while循环之后找到插入位置，进行直接插入排序
                for(;j>=high+1;j--){
                    arr[j+1] = arr[j];//high+1为插入位置
                }
                arr[j+1] = value;
            }
        }
    }
    /* 4.希尔排序：
       时间复杂度：...
       空间复杂度：O(1)
       稳定性：是
       优化点：找到位置之后插入数据时，可以优化为一次走多步
    * */
    public static void ShellSort(int[] arr){
        int n = arr.length;
        if(n<=1){
            return;
        }
        int step = n/2;
        while(step>=1){
            for(int i = step;i<n;i++){
                int value = arr[i];
                int j = i-step;
                for(;j>=0;j-=step){
                    if(value<arr[j]){
                        arr[j+step] = arr[j];
                    }else{
                        break;
                    }
                }
                arr[j+step] = value;
            }
            step = step/2;
        }
    }
    /* 5.选择排序：
       时间复杂度：O(n^2)
       空间复杂度：O(1)
       稳定性：不稳定，因为改变的是元素的索引（位置）
    * */
    public static void selectSort(int[] arr){
        int n = arr.length;
        if(n<=1){
            return;
        }
        for(int i = 0;i<n-1;i++){
            int min = i;
            for(int j = i+1;j<n;j++){
                if(arr[j]<arr[min]){
                    min = j;//索引为min的元素一定是当前的最小元素
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
    /* 6.归并排序：
       时间复杂度：O(nlogn)
       空间复杂度：O(n)
       稳定性：是
    * */
    public static void mergeSort(int[] arr){
        int n = arr.length;
        if(n<=1){
            return;
        }
        mergeInternal(arr,0,n-1);
    }
    private static void mergeInternal(int[] arr,int low,int high){
        if(low>=high){
            return;
        }
        int mid = low+(high-low)/2;
        mergeInternal(arr,low,mid);
        mergeInternal(arr,mid+1,high);
        merge(arr,low,mid,high);
    }
    private static void merge(int[]arr,int left,int mid,int right){
        int i = left;
        int j = mid+1; //设置要比较的节点的起始位置
        int m = 0;
        int temp[] = new int[right-left+1];//存放排序之后的数据
        while(i<=mid && j<=right){
            if(arr[i]<arr[j]){
                temp[m++] = arr[i++];
            }else{
                temp[m++] = arr[j++];
            }
        }
        //若左半边小数组还有剩余
        while(i<=mid){
            temp[m++] = arr[i++];
        }
        //若右半边小数组还有剩余
        while(j<=right){
            temp[m++] = arr[j++];
        }
        //将存放的值传给原来的数组
        for(int n = 0;n<temp.length;n++){
            arr[left+n] = temp[n];
        }
    }
}
