package bittech2;

public class SortOne {
    public static void main(String[] args) {
        int[] data = new int[]{4,5,6,1,2,3};
//        bubbleSort(data);
//        print(data);
        insertSort(data);
        print(data);
    }
    public static void bubbleSort(int[] arr){
        int n = arr.length;
        if(n<=1){
            return;
        }else{
            for(int i = 0;i<n;i++){
                boolean flag = false;
                for(int j = 0;j<n-i-1;j++){
                    if(arr[j]>arr[j+1]){
                        flag = true;
                        int temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                    }
                }
                if(!flag){
                    System.out.println("已经有序！");
                    break;  // 有序之后跳出此循环
                }
            }
        }
    }
    public static void print(int[] arr){
        for(int i : arr){
            System.out.print(i+" ");
        }
    }
    public static void insertSort(int[] arr){
        int n = arr.length;
        if(n<=1){
            return;
        }else{
            for(int i = 1;i<n;i++){  //i为无序数组的第一位
                int value = arr[i];
                int j = i-1;   //j为有序数组的最后一位
                for(;j>=0;j--){
                    if(value<arr[j]){
                        arr[j+1] = arr[j];  //把j往后挪一位，给此元素找插入位置
                    }else{
                        break;
                    }
                }
                arr[j+1] = value;  //当前最小元素的下一位为插入位置（比后面小，比前面大）
            }
        }
    }
}
