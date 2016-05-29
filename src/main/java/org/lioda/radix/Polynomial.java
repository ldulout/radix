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
        int i = 0;
        for (;q.compareTo(BigInteger.ZERO) == 1;++i) {
            BigInteger r = q.mod(rad);
            q = q.divide(rad);
            result.add(r.intValue());
        }
        Collections.reverse(result);
        return result;
    }

    public String toString(int radix, List<Character> chars) {
        StringBuilder result = new StringBuilder();
        for (int digit : toDigits(radix)) {
            result.append(chars.get(digit));
        }
        return result.toString();
    }
}
