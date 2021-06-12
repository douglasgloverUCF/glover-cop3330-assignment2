package ex37;

import java.util.List;

public class PasswordGenerator {
    static final PasswordGenerator pass = new PasswordGenerator();
    final List<Character> specials = List.of('!','@','#','$','%','^','&','*','?');
    final List<Character> numbers = List.of('0','1','2','3','4','5','6','7','8','9');
    final List<Character> letters = List.of('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
                                            'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z');
    int calcLength(int otherCount, int minLength)
    {
        int length = otherCount * 2;
        if(length < minLength)
            length = minLength;
        return length;
    }
    String generatePassword(int specialCount, int numberCount, int minLength)
    {
        int length = calcLength(specialCount + numberCount, minLength);
        int letterCount = length - (specialCount + numberCount);
        char[] password = new char[length];
        int rng;
        for(int i = 0; i < length; i++)
        {
            rng = (int) Math.floor(Math.random() * 3);
            if(rng == 0) //letter
            {
                if(letterCount > 0) {
                    password[i] = getRandomCharacter(letters);
                    letterCount--;
                    continue;
                }
                i--;
                continue;
            }
            if(rng == 1) //number
            {
                if(numberCount > 0) {
                    password[i] = pass.getRandomCharacter(numbers);
                    numberCount--;
                    continue;
                }
                i--;
                continue;
            }
            if(rng == 2) //special
            {
                if(specialCount > 0) {
                    password[i] = pass.getRandomCharacter(specials);
                    specialCount--;
                    continue;
                }
                i--;
            }
        }
        return String.copyValueOf(password);
    }
    char getRandomCharacter(List<Character> characters)
    {
        int rng = (int) (Math.floor(Math.random() * characters.size()));
        return characters.get(rng);
    }
}
