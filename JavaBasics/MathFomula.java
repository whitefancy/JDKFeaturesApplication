package JavaBasics;

public class MathFomula {

    public void test(){
        System.out.println(combination(5, 3));
    }
    //组合数 C(n,m)=n!/(m!*(n-m)!)
    public int combination(int n,int m){
        long temp = 1;
        for (int i = m+1; i <= n; i++) {
            temp*=i;
        }
        for (int i =2; i <= n - m; i++) {
            temp/=i;
        }
        return (int)temp;
    }
    //排列数 A(n,m)=n!/(n-m)!
    public int arrangement(int n,int m){
        long temp = 1;
        for (int i = m+1; i <= n; i++) {
            temp*=i;
        }
        return (int)temp;
    }
}
