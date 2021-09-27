package xyz.mingliao.algorithms.a1;

/**
 * 计算两个非负整数p和q的最大公约数
 */
public class GcdAlgorithms {

    public static int gcd(int p,int q){
        if(q==0){
            return p;
        }
        int r = p % q;
        return gcd(q,r);
    }

    public static void main(String[] args) {
        System.out.println(gcd(99,33));
    }
}
