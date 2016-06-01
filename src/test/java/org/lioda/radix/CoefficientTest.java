package org.lioda.radix;

import org.junit.Test;

import java.math.BigInteger;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;


public class CoefficientTest {

    @Test
    public void coefficientIsAPower() {
        assertThat(new Coefficient(2,4).value(), is(new BigInteger("16")));
    }
    @Test
    public void constructorBasedUponBigInteger() {
        assertThat(new Coefficient(new BigInteger("2"),4).value(), is(new BigInteger("16")));
    }

    @Test
    public void toStringReturnsAHumanReadableFormula() {
        assertThat(new Coefficient(4, 6).toString(), is("4^6"));
    }

    @Test
    public void equalityBetweenToCoefficients() {
        assertThat(new Coefficient(new BigInteger("2"), 4), is(new Coefficient(new BigInteger("10", 2), 4)));
    }
}
