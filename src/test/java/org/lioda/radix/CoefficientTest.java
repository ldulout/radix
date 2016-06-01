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
}
