package org.lioda.radix;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class CharacterSetTest {
    @Test
    public void createFromCharacterList() {
        assertThat(CharacterSet.fromCharacters('a', 'b', 'c'), contains('a','b','c'));
    }

    @Test
    public void createFromRange() {
        assertThat(CharacterSet.fromRange('0', '9'), contains('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'));
    }

    @Test
    public void canAccessItemByIndex() {
        assertThat(CharacterSet.fromRange('0', '9').get(2), is('2'));
    }

    @Test
    public void hasSize() {
        assertThat(CharacterSet.fromRange('0', '9').size(), is(10));
    }

    @Test
    public void canAddRange() {
        assertThat(CharacterSet.fromRange('0', '2').addRange('a', 'c'), contains('0', '1', '2', 'a', 'b', 'c'));
    }

    @Test
    public void canAddCharacterList() {
        assertThat(CharacterSet.fromRange('0', '2').addCharacters('a', 'c'), contains('0', '1', '2', 'a', 'c'));
    }

    @Test
    public void characterSetIsImmutable() {
        CharacterSet set = CharacterSet.fromRange('0', '2');
        assertThat(set.addRange('a', 'c'), not(sameInstance(set)));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void cannotRemoveElement() {
        Iterator<Character> iterator = CharacterSet.fromRange('0', '2').iterator();
        iterator.next();
        iterator.remove();
    }

    @Test(expected = IllegalArgumentException.class)
    public void charactersInRangeHaveToBeSorted() {
        assertThat(CharacterSet.fromRange('2', '0'), contains('0', '1', '2'));
    }
}
