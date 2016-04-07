package dice;

import java.util.Random;

/**
 * Creates Die object that will returned rolled values.
 */
public class Die {
    private Random rand;

    /**
     * Creates a new random number generator
     */
    public Die() {
        rand = new Random();
    }

    /**
     * Function that will provide a "roll" value for a die
     * @return int -> value provided by roll function (number randomly chosen between 1 & 6)
     */
    public int roll() {
        return rand.nextInt(6) + 1;
    }
}
