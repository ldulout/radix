package org.lioda.radix;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class PolynomialTest {

    @Test
    public void polynomialStringifyInAnyRadix() {
        Polynomial polynomial = new Polynomial("123",10);
        assertThat(polynomial.toHexString(), is("7b"));
    }

    @Test
    public void polynomialToDigitsReturnsIterableOfDigits() {
        Polynomial polynomial = new Polynomial("123",10);
        assertThat(polynomial.toDigits(16), contains(7, 11));
    }

    @Test
    public void polynomialCanProduceWithAnyRadix() {
        Polynomial polynomial = new Polynomial("123",10);
        assertThat(polynomial.toDigits(47), contains(2, 29));
    }

}
