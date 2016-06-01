package org.lioda.radix;

import java.math.BigInteger;

/**
 * A coefficient in a polynomial. Represents the radix and its power : radix ^ pow.
 */
public class Coefficient {
    private final int radix;
    private final int power;

    public Coefficient(int radix, int power) {
        this.radix = radix;
        this.power = power;
    }
}
