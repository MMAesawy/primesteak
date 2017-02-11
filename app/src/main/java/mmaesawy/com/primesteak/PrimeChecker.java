package mmaesawy.com.primesteak;

import java.math.BigInteger;

/**
 * Created by MMAesawy on 2017-02-10.
 */

public abstract class PrimeChecker {
    public static boolean isPrime(BigInteger n){
        return n.isProbablePrime(6);
    }
    public static boolean isPrime(BigInteger n, double probability){
        int certainty = (int)Math.ceil(Math.log(1-probability) / Math.log(0.5));
        return n.isProbablePrime(certainty);
    }

}
