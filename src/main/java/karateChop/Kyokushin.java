package karateChop;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Travail on 28/09/2016.
 */
public class Kyokushin implements Karate{
    @Override
    public int chop(int number, List<Integer> sortedArray) {
        return chop(number, sortedArray, 0);
    }

    public int chop(int number, List<Integer> sortedArray, int offset) {

        int index = -1;
        if(sortedArray == null || sortedArray.size() <= 0)
            return index;
        if (sortedArray.size() == 1){
            if(sortedArray.get(0)==number){
                return offset;
            }else {
                return index;
            }
        }


        int midIndex = sortedArray.size() / 2;
        System.out.println("****** " + sortedArray.size() + " / 2 = " +midIndex);
        System.out.println("       mid index value: " +sortedArray.get(midIndex));
        List<Integer> selectedSubArray;

        if(sortedArray.get(midIndex)== number)
            return midIndex + offset;
        else if(sortedArray.get(midIndex) > number){
            selectedSubArray = sortedArray.subList(0, midIndex);
        }else{ //< number
            selectedSubArray =sortedArray.subList(midIndex, sortedArray.size());
            offset += midIndex;
        }
        System.out.println("       selected Array " +selectedSubArray.toString());
        return chop(number, selectedSubArray, offset);
    }



}
