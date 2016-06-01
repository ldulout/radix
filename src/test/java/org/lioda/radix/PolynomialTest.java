package org.lioda.radix;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;

public class PolynomialTest {

    private final CharacterSet hexCharacters = CharacterSet.fromRange('0','9').addRange('A', 'F');

    @Test
    public void polynomialStringifyInHexadecimal() {
        Polynomial polynomial = new Polynomial("123",10);
        assertThat(polynomial.toHexString(), is("7b"));
        assertThat(polynomial.toString(16, hexCharacters), is("7B"));
    }

    @Test
    public void polynomialToDigitsReturnsIterableOfDigits() {
        Polynomial polynomial = new Polynomial("123",10);
        assertThat(polynomial.toDigits(16), contains(7, 11));
    }

    @Test
    public void polynomialCanProduceDigitsWithAnyRadix() {
        Polynomial polynomial = new Polynomial("123",10);
        assertThat(polynomial.toDigits(47), contains(2, 29));
    }

    @Test
    public void polynomialStringifyWithAnyCharacterList() {
        Polynomial polynomial = new Polynomial("11",10);
        assertThat(polynomial.toString(4, CharacterSet.fromCharacters('a', 'b', 'c', 'z')), is("cz"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void polynomialStringifyThrowsExceptionIfCharactersHasABadSize() {
        Polynomial polynomial = new Polynomial("11",10);
        assertThat(polynomial.toString(4, CharacterSet.fromCharacters('a', 'b', 'z')), is("cz"));
    }
    @Test(expected = IllegalArgumentException.class)
    public void polynomialStringifyThrowsExceptionIfCharactersIsNull() {
        Polynomial polynomial = new Polynomial("11",10);
        assertThat(polynomial.toString(4, null), is("cz"));
    }

    @Test
    public void polynomialCanProduceCoefficientsWithAnyRadix() {
        Polynomial polynomial = new Polynomial("123",10);
        assertThat(polynomial.toPolynomial(47), contains(new Digit(2, new Coefficient(47, 1)), new Digit(29, new Coefficient(47, 0))));
    }

    @Test
    public void binaryDisplay() {
        Polynomial polynomial = new Polynomial("123",10);
        assertThat(polynomial.toString(2, CharacterSet.BINARY), is("1111011"));
    }

    @Test
    public void bas64Display() {
        Polynomial polynomial = new Polynomial("123456",10);
        assertThat(polynomial.toDigits(64), contains(30,9,0));
        assertThat(polynomial.toString(64, CharacterSet.BASE_64), is("eJA"));
    }
}
