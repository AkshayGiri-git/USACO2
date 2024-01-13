import java.util.*;
class numgame{
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int numdig = Integer.parseInt(s.nextLine());
        int[] digits = new int[numdig];
        int[] firstdig = new int[numdig];
        int[] length = new int[numdig];
        String[] line = s.nextLine().split(" ");
        boolean a = true;
        for (int i = 0; i < numdig; i++) {
            digits[i] = Integer.parseInt(line[i]);
            length[i] = line[i].length();
        }

        String[] nums = new String[6];
        for (int j = 0; j < numdig; j++) {
            if (length[j] == 1) {
                if (nums[0] == null) {
                    nums[0] = String.valueOf(digits[j]);
                } else if (digits[j] > Integer.parseInt(nums[0])) {
                    nums[0] = String.valueOf(digits[j]);
                }

            }
            if (length[j] == 2) {
                if (nums[1] == null) {
                    nums[1] = String.valueOf(digits[j]);
                } else if (digits[j] > Integer.parseInt(nums[1])) {
                    nums[1] = String.valueOf(digits[j]);
                }
            }
            if (length[j] == 3) {
                if (nums[2] == null) {
                    nums[2] = String.valueOf(digits[j]);
                } else if (digits[j] > Integer.parseInt(nums[2])) {
                    nums[2] = String.valueOf(digits[j]);
                }
            }
            if (length[j] == 5) {
                if (nums[3] == null) {
                    nums[3] = String.valueOf(digits[j]);
                } else if (digits[j] > Integer.parseInt(nums[3])) {
                    nums[3] = String.valueOf(digits[j]);
                }
            }
            if (length[j] == 7) {
                if (nums[4] == null) {
                    nums[4] = String.valueOf(digits[j]);
                } else if (digits[j] > Integer.parseInt(nums[4])) {
                    nums[4] = String.valueOf(digits[j]);
                }
            }
            if (length[j] == 9) {
                if (nums[5] == null) {
                    nums[5] = String.valueOf(digits[j]);
                } else if (digits[j] > Integer.parseInt(nums[5])) {
                    nums[5] = String.valueOf(digits[j]);
                }
            }
        }
        int nine = 0;
        if (nums[5] == null) {

        } else {
            nine = Integer.parseInt(nums[5]);
        }
        int seventwo = 0;
        if (nums[1] == null || nums[4] == null) {

        } else {
            String num1 = nums[4] + nums[1];
            String num2 = nums[1] + nums[4];

            if (Integer.parseInt(num1) >= Integer.parseInt(num2)) {
                seventwo = Integer.parseInt(num1);

            } else {
                seventwo = Integer.parseInt(num2);
            }
        }
        int best = 0;
        if (nums[3] == null || nums[2] == null || nums[0] == null) {

        } else {

            String num3 = nums[0] + nums[2] + nums[3];

            String num4 = nums[0] + nums[3] + nums[2];
            String num5 = nums[2] + nums[0] + nums[3];
            String num6 = nums[2] + nums[3] + nums[0];
            String num7 = nums[3] + nums[0] + nums[2];
            String num8 = nums[3] + nums[2] + nums[0];
            if (Integer.parseInt(num3) > Integer.parseInt(num4)) {
                best = Integer.parseInt(num3);
            } else {
                best = Integer.parseInt(num4);
            }
            if (Integer.parseInt(num5) > best) {
                best = Integer.parseInt(num5);
            }
            if (Integer.parseInt(num6) > best) {
                best = Integer.parseInt(num6);
            }
            if (Integer.parseInt(num7) > best) {
                best = Integer.parseInt(num7);
            }
            if (Integer.parseInt(num8) > best) {
                best = Integer.parseInt(num8);
            }


        }
        int best2 = 0;
        if (nine == 0 && seventwo == 0 && best == 0) {
            System.out.println("IMPOSSIBLE");
        } else {
            if (nine > seventwo) {
                best2 = nine;
            } else {
                best2 = seventwo;
            }
            if (best > best2) {
                best2 = best;
            }
            System.out.println(best2);
        }

    }
}
