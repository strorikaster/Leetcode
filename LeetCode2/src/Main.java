import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        int[] nums = {3, 6, 7, 8, 10};
        int[] digits = {9};

        //Begin Test generics and PECS
        List<? extends A> list1 = new ArrayList<>();
        List<? super B> list2 = new ArrayList<>();

        B b = new B();
        A a = new A();
        C c = new C();
        D d = new D();
        Object o = new Object();


        list1.add(null);//<? extends A> producer ничего нельзя положить кроме null
        //list1.add(d);<? extends A> producer ничего нельзя положить кроме null
        list2.add(b);
        list2.add(c);
        //end generic test



        //System.out.println(removeElement(nums, 3));
        //System.out.println(searchInsert(nums, 5));
        //System.out.println(plusOne(digits).toString());
        // System.out.println(getDuplicatedWordsInString("Java i like this programming language java"));
        String str = "Иванов Иван Иванович";
        //System.out.println(reverseString(str));
        //System.out.println(exchangeSymbols(str,  'а', 'т'));
        //System.out.println(stringToInt("-23"));
        //outputNumbers();
        //System.out.println(stringToDouble("23"));
//        int[] nums1 = {1,2,3,5,7};
//        int[] nums2 = {2,3,4,6,8};
//        printNonRepeatElementsInFirstArray(nums1, nums2);

        int[] nums3 = {1,2,3,4,3,5};
        System.out.println(containsDubl(nums3));

        //System.out.println(findFirstNonRepeatLetter("aaaabccccdggg"));

    }

    public static int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }

    public static int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target || target < nums[i]) return i;
        }

        return nums.length;
    }

    public static int searchInsertByBinarySearch(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (target < nums[mid]) hi = mid - 1;
            else if (target > nums[mid]) lo = mid + 1;
            else return mid;
        }

        return lo;
    }

    //сам решил
    public int lengthOfLastWord(String s) {
        String[] strMas = s.split(" ");
        return (strMas[strMas.length - 1]).length();
    }

    public static int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;

//        for (int i = digits.length - 1; i >= 0; i--) {
//            if (digits[i] < 9) {
//                digits[i]++;
//                return digits;
        // starting from extreme right--> if array[i] is less than 9 means can be added with 1
        // i.e. [ 5,8 ]-->[ 5,9 ] or
        //      [ 9,4 ]-->[ 9,5 ] or
        //      [ 6,0 ]-->[ 6,1 ]
        // and will directly return array
//            }
//            digits[i] = 0;
        // if array[i] is not less than 9, means it have to be 9 only then digit is changed to 0,
        // and we again revolve around loop to check for number if less than 9 or not
        // i.e. [ 5,9 ]-->[ 5,0 ]-loop->[ 6,0 ] or
        //      [ 1,9,9 ]-->[ 1,9,0 ]-loop->[ 1,0,0 ]-loop->[ 2,0,0 ]
        // and will directly return array
//        }

// if all number inside array are 9
// i.e. [ 9,9,9,9 ] than according to above loop it will become [ 0,0,0,0 ]
// but we have to make it like this [ 9,9,9,9 ]-->[ 1,0,0,0,0 ]


// to make like above we need to make new array of length--> n+1
// by default new array values are set to -->0 only
// thus just changed first value of array to 1 and return the array
    }

//    public String addBinary(String a, String b) {
//
//    }

    public static String getDuplicatedWordsInString(String str) {
        String[] strmas = str.toLowerCase().split(" ");
        Map<String, Integer> testMap = new HashMap<>();
        for (String st : strmas) {
            //before java8
//            if(testMap.containsKey(st)) {
//                testMap.put(st, testMap.get(st) + 1);
//            }else {
//                testMap.put(st, 1);
//            }
            //java8
            testMap.compute(st, (key, value) -> value == null ? value = 1 : value + 1);
        }
        return (testMap.keySet().stream().map(key -> key + " " + testMap.get(key) + " ").collect(Collectors.joining()));
    }

    public static String reverseString(String str) {
        StringBuilder sb = new StringBuilder(str);
        String str2 = sb.reverse().substring(0, str.length()).toLowerCase();
        String[] arr = str2.split(" ");
        StringBuffer strBuf = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            strBuf.append(Character.toUpperCase(arr[i].charAt(0)))
                    .append(arr[i].substring(1)).append(" ");
        }
        return strBuf.toString();
    }

    public static String exchangeSymbols(String str, char replacedChar, char charToReplace) {
        char[] charStr = str.toCharArray();
        String resString = "";
        for (int i = 0; i < charStr.length; i++) {
            if (charStr[i] == replacedChar) {
                charStr[i] = charToReplace;
            }
            resString += charStr[i];
        }
        return resString;
    }

    public static int stringToInt(String str) {
        var result = 0;
        int isNegative = 1;

        if (str.charAt(0) == '-') {
            isNegative = -1;
            str = str.substring(1);
        }

        for (int i = 0; i < str.length(); i++) {
                result = result * 10 + ((str.charAt(i))) - '0';
        }
        return result * isNegative;
    }

    public static void outputNumbers() {
        for (int i = 0; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }


    //Generics and PECS
    public static class D{}
    public static class A extends D{}
    public static class B extends A{}
    public static class C extends B{}

    public static Double stringToDouble(String str) {
        Double result = 0.0;
        int isNegative = 1;
        int pow = 0;
        if (str.charAt(0) == '-') {
            isNegative = -1;
            str = str.substring(1);
        }
        for (int i = 0; i < str.length(); i++) {

                if(str.charAt(i) == ',') {
                    ++i;
                    pow = str.length() - i;
                }
            result = result * 10 + ((str.charAt(i))) - '0';
            }
        result = isNegative*result/Math.pow(10, pow);
        return result;
    }

    public static void printNonRepeatElementsInFirstArray(int[] nums1, int[] nums2) {
       int k = 0;
       int l = 0;

       while (k < nums1.length) {
           if(nums1[k] != nums2[l]) {
               System.out.println(nums1[k]);
           } else {
               l++;
           }
           k++;
       }
    }

        public static boolean containsDubl(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                if(!map.containsKey(nums[i])) {
                    map.put(nums[i], 1);
                } else if(map.containsKey(nums[i])) {
                    map.computeIfPresent(nums[i], (key, val) -> val + 1);
//
                }
            }
            return map
                   .entrySet()
                   .stream()
                   .anyMatch(entry -> entry.getValue() > 1);



        }

        public static Character findFirstNonRepeatLetter(String str) {
         Map<Character, Integer> map = new HashMap<>();

            char[] charArr = str.toCharArray();
            for (int i = 0; i < str.length(); i++) {
                if(!map.containsKey(charArr[i])) {
                    map.put(charArr[i], 1);
                } else if(map.containsKey(charArr[i])) {
                    map.computeIfPresent(charArr[i], (key, val) -> val + 1);
                }
            }
            //System.out.println(map.toString());
            return map
                    .entrySet()
                    .stream()
                    .filter(entry -> entry.getValue().equals(1))
                    .map(Map.Entry::getKey)
                    .findFirst().get();
        }

}


