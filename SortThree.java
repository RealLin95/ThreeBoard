package bittech2;

public class SortThree {
    public static void main(String[] args) {
        int[] data = new int[]{3,7,5,9,1};
        quickSort(data);
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
        int q = chooseNumber(arr,l,r);
        quickSortInternal(arr,l,q);
        quickSortInternal(arr,q+1,r);
    }
    private static int chooseNumber(int[] arr,int l,int r){
        int value = arr[l];
        int j = l;
        int i = l+1;
        for(;i<=r;i++){
            if(arr[i]<value){
                swap(arr,i,j+1);
                j++;
            }
        }
        swap(arr,l,j);
        return j;
    }
    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
