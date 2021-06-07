package ex24;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnagramCheckTest {
    static AnagramCheck anagram = new AnagramCheck();

    @Test
    void returns_true_if_anagram_basic() {
        String string1 = "note";
        String string2 = "tone";
        assertTrue(anagram.isAnagram(string1, string2));
    }
    @Test
    void returns_true_if_anagram_same() {
        String string1 = "note";
        String string2 = "note";
        assertTrue(anagram.isAnagram(string1, string2));
    }
    @Test
    void returns_true_if_anagram_double_letters() {
        String string1 = "stressed";
        String string2 = "desserts";
        assertTrue(anagram.isAnagram(string1, string2));
    }
    @Test
    void returns_false_if_not_anagram_basic() {
        String string1 = "note";
        String string2 = "nate";
        assertFalse(anagram.isAnagram(string1, string2));
    }
    @Test
    void returns_false_if_not_anagram_basic2() {
        String string1 = "loud";
        String string2 = "silent";
        assertFalse(anagram.isAnagram(string1, string2));
    }
    @Test
    void returns_false_if_not_anagram_different_lengths() {
        String string1 = "chad";
        String string2 = "chads";
        assertFalse(anagram.isAnagram(string1, string2));
    }
}