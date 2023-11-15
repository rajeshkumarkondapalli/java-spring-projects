
//S1: 
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // int[] x = { 14, 27, 1, 4, 2, 50, 3, 1 };
        // int[] y = { 2, 4, -4, 3, 1, 1, 14, 27, 50 };

        int[] x = { 13, 5, 6, 2, 5 };
        int[] y = { 5, 2, 5, 13 };

        System.out.println(solution.compare(x, y));
    }

    public static int compare(int[] x, int[] y) {
        java.util.List<Integer> result = new java.util.ArrayList<>();

        java.util.List<Integer> list1 = java.util.stream.IntStream.of(x).boxed().collect(java.util.stream.Collectors.toList());
        java.util.List<Integer> list2 = java.util.stream.IntStream.of(y).boxed().collect(java.util.stream.Collectors.toList());

        if (x.length > y.length) {// compare each element of x against y array
            result = list1.stream().filter(item -> !list2.contains(item)).collect(java.util.stream.Collectors.toList());
        }
        else{
            result = list2.stream().filter(item -> !list1.contains(item)).collect(java.util.stream.Collectors.toList());
        }

        return result.get(0);

    }



//S2: 
import java.util.Arrays;

public class Sum03 {
    
    public static void main(String[] args) {
        int[] arr = {10, 4, 1, 1, 1, 1};
        int output = getHigestNumDivisibleByThree(arr);
        System.out.println(output);
    }

    private static int getHigestNumDivisibleByThree(int[] arr) {

		int sum = 0;
		StringBuilder str = new StringBuilder();
		Arrays.sort(arr);

		for (int i = arr.length; i > 0; i--) {
			sum = sum + arr[i - 1];
			str.append(arr[i - 1]);
		}

		int remainder = sum % 3;
		if (remainder == 0)
			return Integer.parseInt(str.toString());

		str = new StringBuilder();

		boolean condition = true;
		int removeNum = 0;
		while (condition && remainder <= 9) {
			if (contains(arr, remainder)) {
				removeNum = remainder;
				break;
			}
			remainder = remainder + 3;
		}
		if (removeNum == 0)
			return 0;
		for (int i = arr.length; i > 0; i--) {
			if (removeNum == arr[i - 1]) {
				continue;
			}
			str.append(arr[i - 1]);
		}
		return Integer.parseInt(str.toString());
	}

	private static boolean contains(int[] arr, int num) {
		for (int i : arr)
			if (i == num)
				return true;
		return false;
	}
}
