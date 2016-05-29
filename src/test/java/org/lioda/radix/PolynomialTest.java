package org.lioda.radix;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class PolynomialTest {

    @Test
    public void polynomialStringifyInAnyRadix() {
        Polynomial polynomial = new Polynomial("123",10);
        assertThat(polynomial.toString(16), is("7b"));
    }

    @Test
    public void polynomialToDigitsReturnsIterableOfDigits() {
        Polynomial polynomial = new Polynomial("123",10);
        assertThat(polynomial.toDigits(16), contains(7, 11));
    }

}
