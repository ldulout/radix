package org.lioda.radix;

import org.junit.Test;

import java.math.BigInteger;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class DigitTest {
    private static final Coefficient COEFF_2_POW_3 = new Coefficient(2,3);
    /** 4*2^3 = 32 */
    @Test
    public void digitIsAMultiplication() {
        assertThat(new Digit(4, COEFF_2_POW_3).value(), is(new BigInteger("32")));
    }

    @Test
    public void constructorBasedUponBigInteger() {
        assertThat(new Digit(new BigInteger("4"), COEFF_2_POW_3).value(), is(new BigInteger("32")));
    }

    @Test
    public void toStringReturnsAHumanReadableFormula() {
        assertThat(new Digit(56, COEFF_2_POW_3).toString(), is("56*2^3"));
    }

    @Test
    public void equalityBetweenToDigits() {
        assertThat(new Digit(new BigInteger("4"), COEFF_2_POW_3), is(new Digit(new BigInteger("100", 2), COEFF_2_POW_3)));
    }

    @Test
    public void toCharFromCharacterSet() {
        CharacterSet characterSet = CharacterSet.fromRange('a', 'z');
        assertThat(new Digit(new BigInteger("0"), COEFF_2_POW_3).toChar(characterSet), is('a'));
        assertThat(new Digit(new BigInteger("11"), COEFF_2_POW_3).toChar(characterSet), is('l'));
    }

}
