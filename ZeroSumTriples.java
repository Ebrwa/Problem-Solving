import java.util.*;

public class ZeroSumTriples {

    public static List<List<Integer>> threeSum(int[] numbers) {

        List<List<Integer>> answers = new ArrayList<>();

        Arrays.sort(numbers);

        for (int i = 0; i < numbers.length - 2; i++) {

            if (i > 0 && numbers[i] == numbers[i - 1])
                continue;

            int start = i + 1;
            int end = numbers.length - 1;

            while (start < end) {

                int total = numbers[i] + numbers[start] + numbers[end];

                if (total == 0) {

                    answers.add(Arrays.asList(numbers[i], numbers[start], numbers[end]));

                    start++;
                    end--;

                    while (start < end && numbers[start] == numbers[start - 1])
                        start++;

                    while (start < end && numbers[end] == numbers[end + 1])
                        end--;

                } else if (total < 0) {

                    start++;

                } else {

                    end--;
                }
            }
        }

        return answers;
    }
}