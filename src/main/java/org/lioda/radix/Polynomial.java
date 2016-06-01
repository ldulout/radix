package org.lioda.radix;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Polynomial representation of a number, with any radix. Representation : d1 * radix ^ n + d2 * radix ^ (n-1) + ... + dn-1 * radix + dn.
 */
public class Polynomial {

    private final BigInteger number;

    public Polynomial(String number, int radix) {
        this.number = new BigInteger(number, radix);
    }

    public String toHexString() {
        return number.toString(16);
    }

    public List<Digit> toPolynomial(int radix) {
        BigInteger rad = new BigInteger(String.valueOf(radix));
        List<Digit> result = new ArrayList<Digit>();
        BigInteger q = number;
        for (int i = 0; q.compareTo(BigInteger.ZERO) == 1; ++i) {
            result.add(new Digit(q.mod(rad), new Coefficient(rad, i)));
            q = q.divide(rad);
        }
        Collections.reverse(result);
        return result;
    }

    public Iterable<Integer> toDigits(int radix) {
        List<Integer> result = new ArrayList<Integer>();
        for (Digit digit : toPolynomial(radix)) {
            result.add(digit.digitValue());
        }
        return result;
    }

    public String toString(int radix, CharacterSet characterSet) {
        checkCharsSize(radix, characterSet);
        StringBuilder result = new StringBuilder();
        for (Digit digit : toPolynomial(radix)) {
            result.append(digit.toChar(characterSet));
        }
        return result.toString();
    }

    private void checkCharsSize(int radix, CharacterSet characterSet) {
        if (characterSet == null) throw new IllegalArgumentException("The characters set must not be null");
        if (characterSet.size() != radix)
            throw new IllegalArgumentException("It needs " + radix + " characters but was " + characterSet);
    }


}
