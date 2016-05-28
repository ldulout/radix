package org.lioda.radix;

import java.math.BigInteger;

public class Polynomial {

    private final BigInteger number;

    public Polynomial(String number, int radix) {
        this.number = new BigInteger(number, radix);
    }

    public String toString(int radix) {
        return number.toString(radix);
    }
}
