package dice;

import java.util.ArrayList;

public class RollResult {
    private ArrayList<Integer> rolls;

    public RollResult() {
        rolls = new ArrayList<Integer>();
    }

    public void addRoll(int rollValue) {
        rolls.add(rollValue);
    }

    public int sum() {
        int sum = 0;

        for (int rollIndex = 0; rollIndex < rolls.size(); rollIndex++) {
            sum += rolls.get(rollIndex);
        }

        return sum;
    }

    public int rollCount() {
        return rolls.size();
    }

    public int[] rollsArray() {
        int[] array = new int[rolls.size()];
        int index = 0;
        for (Integer n : rolls) {
            array[index] = n;
            index++;
        }
        return array;
    }
}
