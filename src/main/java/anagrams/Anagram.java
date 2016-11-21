package anagrams;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by ippon on 17/11/16.
 */
public class Anagram {
    public static Boolean isAnagram(String word1, String word2){
        if(word1.length() != word2.length()){
            return false;
        }
        return isAllLettersInWord(word1, word2);
    }


    private static Map<Character, Integer > getLetterRepetitions(String word){
        Map<Character, Integer> letterRepetitions = new HashMap<Character, Integer>();

        for (char c : word.toCharArray()) {
            Character letter = new Character(c);
            if(letterRepetitions.containsKey(letter)){
               letterRepetitions.put(letter, letterRepetitions.get(letter)+1);
            }else{
                letterRepetitions.put(letter, 1);
            }
        }

        return letterRepetitions;
    }

    private static Boolean isAllLettersInWord(String word1, String word2){
        char[] strChar = word2.toCharArray();

        for( int i = strChar.length - 1 ; i >= 0 ; i-- ){
            if(!isLetterInWord(strChar[i], word1)){
                return false;
            }
        }
        return true;
    }

    private static Boolean isLetterInWord(char letter, String word){
        char[] strChar = word.toCharArray();

        for( int i = strChar.length - 1 ; i >= 0 ; i-- ){
            if(strChar[i] == letter){
                return true;
            }
        }
        return false;
    }
}
