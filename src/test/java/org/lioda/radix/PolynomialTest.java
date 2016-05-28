package org.lioda.radix;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PolynomialTest {

    @Test
    public void polynomialStringifyInAnyRadix() {
        Polynomial polynomial = new Polynomial("123",10);
        assertThat(polynomial.toString(16), is("7b"));
    }

}
