package cn.tjrac.sytstem.controler;

/**
 * @author Rui3g
 * @date 2020/6/3 9:37
 */
public class Test2 {
    /*给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
    其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
    不能使用除法。（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
     */
    public static void main(String[] args){
        int [] a = {0,1,2,3,4,5,6,7,8,9};
        int [] b = new int[10];
        int [] c = new int[10];
        int [] d = new int[10];
        c[0] = a[0];
        d[a.length-1] = a[a.length-1];
        for (int i = 1; i<b.length;i++){
            c[i] = c[i-1]*a[i];
        }
        for (int i = a.length-2; i>=0; i--){
            d[i]= d[i+1]*a[i];
        }
        b[0]= d[1];
        b[a.length-1] = d[d.length-2];
        for (int i = 1;i<a.length-2;i++){
            b[i]=c[i-1]*b[i+1];
        }
        for (int i = 0 ;i<b.length;i++){
            System.out.print(b[i]);
        }
//        byte a1=1,a2= 4,a3;
//        short s = 16;





    }
}
