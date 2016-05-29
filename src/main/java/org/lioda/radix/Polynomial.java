package org.lioda.radix;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Plynomial representation of a number, with any radix. */
public class Polynomial {

    private final BigInteger number;

    public Polynomial(String number, int radix) {
        this.number = new BigInteger(number, radix);
    }

    public String toHexString() {
        return number.toString(16);
    }


    public Iterable<Integer> toDigits(int radix) {
        BigInteger rad = new BigInteger(String.valueOf(radix));
        List<Integer> result = new ArrayList<Integer>();
        BigInteger q = number;
        for (;q.compareTo(BigInteger.ZERO) == 1;) {
            result.add(q.mod(rad).intValue());
            q = q.divide(rad);
        }
        Collections.reverse(result);
        return result;
    }

    public String toString(int radix, List<Character> chars) {
        checkCharsSize(radix, chars);
        StringBuilder result = new StringBuilder();
        for (int digit : toDigits(radix)) {
            result.append(chars.get(digit));
        }
        return result.toString();
    }

    private void checkCharsSize(int radix, List<Character> chars) {
        if (chars == null) throw new IllegalArgumentException("The characters set must not be null");
        if (chars.size() != radix) throw new IllegalArgumentException("It needs "+radix+" characters but was "+chars);
    }
}
