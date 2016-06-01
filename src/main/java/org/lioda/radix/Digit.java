package org.lioda.radix;

import java.math.BigInteger;

/**
 * A digit representation in a polynomial : d * radix ^ pow.
 */
public class Digit {
    private BigInteger value;
    private Coefficient coeff;

    public Digit(int value, Coefficient coef) {
        this.value = new BigInteger(String.valueOf(value));
        this.coeff = coef;
    }

    public Digit(BigInteger value, Coefficient coef) {
        this.value = value;
        this.coeff = coef;
    }

    public String toString() {
        return value + "*" + coeff;
    }

    public BigInteger value() {
        return value.multiply(coeff.value());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Digit digit = (Digit) o;

        if (value != null ? !value.equals(digit.value) : digit.value != null) return false;
        return !(coeff != null ? !coeff.equals(digit.coeff) : digit.coeff != null);

    }

    @Override
    public int hashCode() {
        int result = value != null ? value.hashCode() : 0;
        result = 31 * result + (coeff != null ? coeff.hashCode() : 0);
        return result;
    }

    public int digitValue() {
        return value.intValue();
    }

    public char toChar(CharacterSet characterSet) {
        return characterSet.get(value.intValue());
    }
}
