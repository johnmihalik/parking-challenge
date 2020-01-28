import java.util.Arrays;
import java.util.HashMap;

/**
 * Parking Lot implementation
 */
public class Parking {


    /**
     * Print directions for moving cars from initial space to the aret spaces.
     *
     * @param initial Initial int[] cars in spaces
     * @param target Target int[] of where cars should be parked
     */
    public void PrintDirections(int[] initial, int[] target) {

        System.out.println("Initial: " + Arrays.toString(initial) + "  Target: " + Arrays.toString(target));

        // Map to contain the positions of each car, key = car, could be done with an int array too
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

        // Initialize a map to hold car positions
        for (int i=0; i<initial.length; i++) {
            map.put(initial[i], i);
        }

        // Loop through each position on the initial array
        for (int current_pos=0; current_pos<initial.length; current_pos++) {

            int current_car = initial[current_pos];
            int target_car = target[current_pos];

            // Check if a swap is needed
            if (current_car != target_car) {

                // Swap is require, locate empty position and the target postion
                int empty_pos = map.get(0);
                int target_pos = map.get(target_car);

                // If the current car is the empty spot
                if (current_car == 0) {
                    // Just swap the target car with the empty spot
                    initial[current_pos] = target_car;
                    initial[target_pos] = 0;
                    map.put(0,target_pos);
                    System.out.println("Move car from space " + target_pos + " to space " + empty_pos);
                } else if (target_car == 0) {
                    // Just move current to empty
                    map.put(current_car,empty_pos);
                    map.put(0, current_pos);
                    initial[empty_pos] = current_car;
                    initial[current_pos] = 0;
                    System.out.println("Move car from space " + current_pos + " to space " + empty_pos);
                }
                else {
                    // Swap empty with current position
                    initial[empty_pos] = current_car;
                    map.put(current_car, empty_pos);
                    System.out.println("Move car from space " + current_pos + " to space " + empty_pos);

                    empty_pos = current_pos;

                    initial[current_pos] = target_car;
                    initial[target_pos] = 0;
                    map.put(0,target_pos);
                    System.out.println("Move car from space " + target_pos + " to space " + empty_pos);
                }

            }
            //System.out.println("Current Spots: " + Arrays.toString(initial));
        }

        System.out.println("Final Spots: " + Arrays.toString(initial));

        System.out.println("=======================================");
    }


    public static void main(String[] args) {

        Parking parking = new Parking();

        parking.PrintDirections( new int[] {1,3,0,4}, new int[] {3,1,0,4});
        parking.PrintDirections( new int[] {0,3,2,1}, new int[] {1,2,0,3});
        parking.PrintDirections( new int[] {1,2,3,0}, new int[] {0,1,2,3});
        parking.PrintDirections( new int[] {0,4,2,5,1,3}, new int[] {0,1,5,3,2,4});
        parking.PrintDirections( new int[] {0,1}, new int[] {1,0});
        parking.PrintDirections( new int[] {1,0}, new int[] {0,1});

    }


}
