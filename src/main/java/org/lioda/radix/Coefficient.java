package org.lioda.radix;

import java.math.BigInteger;

/**
 * A coefficient in a polynomial. Represents the radix and its power : radix ^ pow.
 */
public class Coefficient {
    private final BigInteger radix;
    private final int power;

    public Coefficient(int radix, int power) {
        this.radix = new BigInteger(String.valueOf(radix));
        this.power = power;
    }

    public String toString() {
        return radix + "^"+power;
    }

    public BigInteger value() {
        return radix.pow(power);
    }
}
