package org.lioda.radix;

import java.util.*;

/**
 * Set of characters.
 */
public class CharacterSet implements Iterable<Character> {
    public static CharacterSet fromCharacters(Character... chars) {
        return new CharacterSet(Arrays.asList(chars));
    }

    public static CharacterSet fromRange(char first, char last) {
        return new CharacterSet(listFromRange(first, last));
    }

    private static ArrayList<Character> listFromRange(char first, char last) {
        ArrayList<Character> characters = new ArrayList<Character>();
        for (char c = first ; c <= last ; ++c) {
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

    public CharacterSet addCharacters(Character... chars) {
        return new CharacterSet(addToList(Arrays.asList(chars)));
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
