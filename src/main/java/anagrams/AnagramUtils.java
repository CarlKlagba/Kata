package anagrams;


import java.util.*;

/**
 * Created by ippon on 17/11/16.
 * http://codekata.com/kata/kata06-anagrams/
 */
public class AnagramUtils {

    /**
     * We only check if the first element is an anagram to the rest,
     * because the 'isAnagram' operation is transitive
     * @param words
     * @return
     */
    public static Boolean areAllAnagrams(List<String> words){
        List<String> tail = words.subList(1, words.size());
        String head = words.get(0);
        return tail.stream().allMatch(word -> isAnagram(head, word));
    }

    public static Boolean isAnagram(Anagram word1, Anagram word2){
        return isAnagram(word1.toString(), word2.toString());
    }

    public static Boolean isAnagram(String word1, String word2){
        if(word1.length() != word2.length()){
            return false;
        }
        return isAllLettersInWord(word1, word2);
    }

    public static ArrayList<String> splitLine(String words){
        return new ArrayList<> (Arrays.asList(words.split(" ")));
    }

    public static int calculateHashCode(Anagram anagram){
        Map<Character, Integer > lr = getLetterRepetitions(anagram.getWord());

        int result = 1;
        for( Character c : lr.keySet()){
            result = 37 * result + c.hashCode();
        }
        return result;
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
        Map<Character, Integer > word1Repetitions = getLetterRepetitions(word1);
        Map<Character, Integer > word2Repetitions = getLetterRepetitions(word2);

        return word1Repetitions.entrySet().stream()
                .allMatch(entry -> word2Repetitions.get(entry.getKey()) != null &&
                        word2Repetitions.get(entry.getKey()).equals(entry.getValue()));
    }

}
