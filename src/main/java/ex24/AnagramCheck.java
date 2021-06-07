package ex24;

import java.lang.reflect.Array;
import java.util.Arrays;

public class AnagramCheck {
    boolean isAnagram(String string1, String string2)
    {
        char[] string1array = string1.toCharArray();
        char[] string2array = string2.toCharArray();

        Arrays.sort(string1array);
        Arrays.sort(string2array);

        return Arrays.equals(string1array, string2array);
    }
}
