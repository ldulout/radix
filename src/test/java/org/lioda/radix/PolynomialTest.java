package org.lioda.radix;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class PolynomialTest {
    private static List<Character> chars(char... chars) {
        List<Character> result = new ArrayList<Character>(chars.length);
        for (char c : chars) {
            result.add(c);
        }
        return result;
    }

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
    public void polynomialCanProduceWithAnyRadix() {
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
}
