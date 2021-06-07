package ex24;

import java.lang.reflect.Array;

public class AnagramCheck {
    boolean isAnagram(String str1, String str2)
    {
        int i, j;
        int length1 = str1.length();
        int length2 = str2.length();
        boolean[] usedChars = new boolean[length2];
        boolean valid = false;

        if(length1 != length2) return false;

        for (i = 0; i < length1; i++)
        {
            for (j = 0; j < length2; j++)
            {
                //prevents identical characters from being checked twice
                if (usedChars[j]) continue;

                if(str1.charAt(i) == str2.charAt(j))
                {
                    usedChars[j] = true;
                    valid = true;
                    break;
                }
            }
            if (valid)
                valid = false;
            else
                return false;
        }
        return true;
    }
}
