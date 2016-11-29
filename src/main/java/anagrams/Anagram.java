package anagrams;

import java.util.Objects;

/**
 * Created by ippon on 22/11/16.
 * http://codekata.com/kata/kata06-anagrams/
 */
public class Anagram {
    private String word;

    public Anagram(String word){
        this.word = word;
    }

    @Override
    public boolean equals(Object object){
        if(object == null) return false;
        if( !(object instanceof Anagram)) return false;
        return AnagramUtils.isAnagram(this, (Anagram) object);
    }

    @Override
    public int hashCode() {
        return AnagramUtils.calculateHashCode(this);
    }

    @Override
    public String toString(){
        return this.word;
    }

    public String getWord(){
        return this.word;
    }
}
