package medium;

import java.util.Arrays;

public class Solution881 {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int i = 0;
        int j = people.length - 1;
        int count = 0;

        while (i <= j) {
            count++;
            if (people[i] + people[j] <= limit)
                i++;
            j--;
        }

        return count;
    }
}
