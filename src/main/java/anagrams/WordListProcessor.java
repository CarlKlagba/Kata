package anagrams;

import org.mockito.internal.util.collections.Sets;

import java.util.*;

/**
 * Created by ippon on 23/11/16.
 */
public class WordListProcessor {
    private List<String> wordList;

    private Map<Anagram, Set<String>> anagramMap;

    public WordListProcessor(List<String> wordList){
        this.wordList = wordList;
    }

    public void process(){
        anagramMap = new HashMap<>();

        wordList.stream()
                .map(w -> new Anagram(w))
                .forEach(a -> {
                    if(anagramMap.keySet().contains(a)){
                        anagramMap.get(a).add(a.getWord());
                    }else{
                        anagramMap.put(a, new HashSet<>(Arrays.asList(a.getWord())));
                    }
                });
    }

    public  void writeResult(){
        for(Set<String> set : anagramMap.values()){

            System.out.println();
            for(String el : set){
                System.out.print(el + " ");
            }
        }
    }
}
