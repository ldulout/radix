package org.lioda.radix;

import java.util.*;

/**
 * Set of characters.
 */
public class CharacterSet implements Iterable<Character> {
    public static final CharacterSet HEXADECIMAL = fromRange('0','9').addRange('a','f');
    public static final CharacterSet BINARY = fromRange('0','1');
    public static final CharacterSet BASE_64 = fromRange('A','Z').addRange('a','z').addRange('0','9').addCharacters('+','/');

    public static CharacterSet fromCharacters(char... chars) {
        return new CharacterSet(listFromChars(chars));
    }

    public static CharacterSet fromRange(char first, char last) {
        if (last < first) throw new IllegalArgumentException("first char must be least than last");
        return new CharacterSet(listFromRange(first, last));
    }

    private static List<Character> listFromRange(char first, char last) {
        ArrayList<Character> characters = new ArrayList<Character>();
        for (char c = first ; c <= last ; ++c) {
            characters.add(c);
        }
        return characters;
    }

    private static List<Character> listFromChars(char... chars) {
        List<Character> characters = new ArrayList<Character>(chars.length);
        for (char c : chars) {
            characters.add(c);
        }
        return characters;
    }

    //////////// End of constructors

    private final List<Character> list;
    private CharacterSet(List<Character> chars) {
        list = Collections.unmodifiableList(chars);
    }

    @Override
    public Iterator<Character> iterator() {
        return list.iterator();
    }

    public CharacterSet addRange(char first, char last) {
        return new CharacterSet(addToList(listFromRange(first,last)));
    }

    public CharacterSet addCharacters(char... chars) {
        return new CharacterSet(addToList(listFromChars(chars)));
    }

    private List<Character> addToList(List<Character> other) {
        List<Character> result = new ArrayList<Character>();
        result.addAll(list);
        result.addAll(other);
        return result;
    }

    public char get(int i) {
        return list.get(i);
    }

    public int size() {
        return list.size();
    }

    public String toString() {
        return list.toString();
    }
}
