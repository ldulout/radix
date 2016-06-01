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

    public Coefficient(BigInteger radix, int power) {
        this.radix = radix;
        this.power = power;
    }

    public String toString() {
        return radix + "^"+power;
    }

    public BigInteger value() {
        return radix.pow(power);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coefficient that = (Coefficient) o;

        if (power != that.power) return false;
        return !(radix != null ? !radix.equals(that.radix) : that.radix != null);

    }

    @Override
    public int hashCode() {
        int result = radix != null ? radix.hashCode() : 0;
        result = 31 * result + power;
        return result;
    }
}
