public class ArrayUtils{

    //1.计算数组中最大值
    public static int arrayMaxElement(int[] data){
        int max = data[0];
        for(int i=1; i<data.length; i++){
            if(data[i]>max){
                max = data[i];
            }
        }
        return max;
    }
    
    //2.计算数组中最小值
    public static int arrayMinElement(int[] data){
        int min = data[0];
        for(int i=1; i<data.length; i++){
            if(data[i]<min){
                min = data[i];
            }
        }
        return min;
    }
    
    
    //3.计算数组值之和
    public static int arrayElementSum(int[] data){
        int sum = data[0];
        for(int i=1; i<data.length; i++){
            sum += data[i];
        }
        return sum;
    }
    
    //4.数组拼接
    // A {1,3,5,7,9} B {2,4,6,8,10} -> {1,3,5,7,9,2,4,6,8,10}
    public static int[] arrayJoin(int[] a, int[] b){
        int[] data = new int[a.length+b.length];
        for(int i=0; i<a.length; i++){
            data[i] = a[i];
        }for(int i=0; i<b.length; i++){
            data[i+a.length] = b[i];
        }
        return data;
    }

    //5.数组截取
    //[start, end)
    // A {1,3,5,7,9} ->(A,1,3) > {3,5}
    public static int[] arraySub(int[] data, int start , int end){
        int[] x = new int[end-start];
        int flag = 0;
        for(int i = start; i<end; i++){
            x[flag]=data[i];
            flag++;
        }
        return x;
    }
    
    //6.数组打印
    public static void printArray(int[] data){
        for(int i:data){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    
    //7.数组反转
    // 比如：[1,2,3,4] => [4,3,2,1]
    public static void printReversal(int[] data){
        int mid = data.length/2;
        int end = data.length-1;
        for(int i=0; i<mid; i++){
            int temp = data[i];
            data[i] = data[end];
            data[end] = temp;
            end--;
        }
        printArray(data);
    }
    
    public static void main(String[] args){
        int[] A = new int[]{1,3,5,7,9};
        int[] B = new int[]{2,4,6,8,10};
        System.out.println("A中的最大值是："+arrayMaxElement(A));    
        System.out.println("B中的最大值是："+arrayMaxElement(B));    
        System.out.println("A中的最小值是："+arrayMinElement(A));    
        System.out.println("B中的最小值是："+arrayMinElement(B));    
        System.out.println("A的元素之和为："+arrayElementSum(A));    
        System.out.println("B的元素之和为："+arrayElementSum(B));    
        System.out.println("A与B数组拼接为：");
        printArray(arrayJoin(A,B));
        System.out.println("A数组截取为：");
        printArray(arraySub(A,1,3));
        System.out.println("B数组截取为：");
        printArray(arraySub(B,1,3));
        System.out.println("A数组：");
        printArray(A);
        System.out.println("B数组：");
        printArray(B);
        System.out.println("A数组逆置为：");
        printReversal(A);
        System.out.println("B数组逆置为：");
        printReversal(B);   
    }
}