package com.notSmartCoder.tools;

public class CharManager {
    public static void printSongLyrics(Character[] characterArray) {
        for (int i = 0; i < characterArray.length; i++)
            System.out.print(characterArray[i]);
        System.out.println();
    }

    public static char[] characterToChar(Character[] character) {
        char[] result = new char[character.length];
        for (int i = 0; i < result.length; i++)
            result[i] = character[i];

        return result;
    }

    public static Character[] stringToCharacter(String string) {
        char[] charArray = string.toCharArray();
        Character[] result = new Character[charArray.length];
        for (int i = 0; i < result.length; i++)
            result[i] = Character.valueOf(charArray[i]);

        return result;
    }
}
