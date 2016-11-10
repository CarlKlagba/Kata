package karateChop;

import java.util.List;

/**
 * Created by Travail on 29/10/2016.
 */
public class Aikido implements Karate {
    @Override
    public int chop(int number, List<Integer> sortedArray) {
        boolean done =false;
        int offset =0;
        while(!done){
            int index = -1;
            if(sortedArray == null || sortedArray.isEmpty())
                return -1;

            int midIndex = sortedArray.size() /2;
            if(sortedArray.get(midIndex) == number)
                return midIndex + offset;
            if(sortedArray.get(midIndex) > number ){
                sortedArray = sortedArray.subList(0, midIndex);
            }else if(sortedArray.get(midIndex) < number){
                sortedArray = sortedArray.subList(midIndex+1, sortedArray.size());
                offset += (midIndex+1);
            }

        };

        return 0;
    }
}
