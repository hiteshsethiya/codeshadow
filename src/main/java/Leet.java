import java.time.LocalDate;

public class Leet {

    public static int distanceBetweenBusStops(int[] distance, int start, int destination) {

        int cDist = 0, aDist = 0;

        for (int i = start; i != destination; i = (++i) % distance.length) {
            cDist += distance[i];
        }

        for (int i = destination; i != start; i = (++i) % distance.length) {
            aDist += distance[i];
        }

        return Math.min(cDist, aDist);

    }

    static final String[] DAYS = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    public static String dayOfTheWeek(int day, int month, int year) {
        return DAYS[
                LocalDate.of(year, month, day).getDayOfWeek().getValue() % 7
                ];
    }

    public static int maximumSum(int[] arr) {

        int max_so_far = Integer.MIN_VALUE;
        int max_ending_here = 0;
        int max_element = Integer.MIN_VALUE;

        boolean isDeleted = false;

        for (int i = 0; i < arr.length; i++) {

            max_element = Math.max(max_element, arr[i]);

            if (arr[i] == 0) continue;

            int temp_max_ending_here = max_ending_here + arr[i];

            if (temp_max_ending_here < 0 || temp_max_ending_here < max_ending_here) {

                if (isDeleted) {
                    isDeleted = false;
                    max_ending_here = 0;
                } else if (max_ending_here > 0) {
                    isDeleted = true;
                    continue;
                }
            } else {
                max_ending_here = temp_max_ending_here;
            }

            max_so_far = Math.max(max_ending_here, max_so_far);
        }

        if (max_so_far == 0 || max_so_far == Integer.MIN_VALUE)
            max_so_far = max_element;

        return max_so_far;
    }

    public static int maxSum(int[] arr) {

        int max_so_far = Integer.MIN_VALUE;
        int max_ending_here = 0;
        int max_element = Integer.MIN_VALUE;

        int deleted = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            max_element = Math.max(max_element, arr[i]);

            int mTemp = max_ending_here + arr[i];

            if (mTemp < max_ending_here) {

                if(deleted == Integer.MIN_VALUE) {
                    deleted = arr[i];
                } else if(mTemp < max_ending_here + deleted) {
                    max_ending_here += deleted;
                    max_so_far += deleted;
                    deleted = arr[i];
                } else if(mTemp < 0) {
                    deleted = Integer.MIN_VALUE;
                    max_ending_here = 0;
                }

            } else {
                max_ending_here = mTemp;
            }

            max_so_far = Math.max(max_ending_here, max_so_far);
        }

        if (max_so_far == 0 || max_so_far == Integer.MIN_VALUE)
            max_so_far = max_element;

        return max_so_far;
    }


    public static void main(String[] args) {
        System.out.println(maximumSum(new int[]{8, -1, 6, -7, -4, 5, -4, 7, -6}) == 17);
        System.out.println(maximumSum(new int[]{1, -4, -5, -2, 5, 0, -1, 2}) == 7);
        System.out.println(maximumSum(new int[]{-7, 6, 1, 2, 1, 4, -1}) == 14);
        System.out.println(maximumSum(new int[]{1, -2, 0, 3}) == 4);
        System.out.println(maximumSum(new int[]{1, -2, 0, 3, -5, 8, -2, 9}) == 17);
        System.out.println(maximumSum(new int[]{1, -2, -2, 3}) == 3);
        System.out.println(maximumSum(new int[]{-1, -1, -1, -1}) == -1);
        System.out.println(maximumSum(new int[]{-50}) == -50);
    }



}
