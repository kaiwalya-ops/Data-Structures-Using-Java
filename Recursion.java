public class Recursion {
    public static int fibonacci(int n){
        if (n<0) return -1;
        if(n == 0 || n ==1 ) return n;
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static int sumOfDigits(int n){
        if( n<0 ) return -1;
        if(n == 0) return 0;
        return n%10 + sumOfDigits(n/10);
    }

    public static int power(int base, int exp){
        if( exp<0 ) return -1;
        if( exp==0 ) return 1;
        return base*power(base,exp-1);
    }

    public static int gcd(int a, int b){
        if( a<0 || b<0 ) return -1;
        if ( b==0 ) return a;
        return gcd(b,a%b);
    }

    public static int decimalToBinary(int num){
        if( num == 0) return 0;
        return decimalToBinary(num/2)*10 + num%2;
    }
}
