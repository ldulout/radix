package org.lioda.radix;

/**
 * A digit representation in a polynomial : d * radix ^ pow.
 */
public class Digit {
    private int value;
    private Coefficient coef;

    public Digit(int value, Coefficient coef) {
        this.value = value;
        this.coef = coef;
    }

    public String toString() {
        return value+"*"+coef;
    }
}
