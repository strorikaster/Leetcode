import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws MyException, MyDoubleException {

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


        list1.add(null);//<? extends A> producer nothing add allow exept null
        //list1.add(d);<? extends A> producer nothing add allow exept null
        list2.add(b);
        list2.add(c);
        //end generic test



        //System.out.println(removeElement(nums, 3));
        //System.out.println(searchInsert(nums, 5));
        //System.out.println(plusOne(digits).toString());
        // System.out.println(getDuplicatedWordsInString("Java i like this programming language java"));
        String str = "Иванов Иван Иванович";
        //System.out.println(reverseString1(str));
        //System.out.println(exchangeSymbols(str,  'а', 'т'));
        //System.out.println(stringToInt("-23"));
        //outputNumbers();
        //System.out.println(stringToDouble("23"));
//        int[] nums1 = {1,2,3,5,7};
//        int[] nums2 = {2,3,4,6,8};
//        printNonRepeatElementsInFirstArray(nums1, nums2);
        //System.out.println(reverseString2(str));

        int[] nums3 = {1,2,3,4,3,5};
       // System.out.println(containsDubl(nums3));

        //System.out.println(findFirstNonRepeatLetter("aaaabccccdggg"));
        String[] strArr = {"sdffgg", "fgdfg", "aaaahjfhj", "dfdfd", "aaa", "tyttyty"};
        //fiterTripleA(strArr);
        //int[] sourceArray = {2,6,4,8,9,5,7};
        //System.out.println(Arrays.toString(sort(sourceArray)));
        double[] sourceDoubleArray = {/*2.7,6.0,4.5,8.3,9.4,5.9,7.0*/0.0};
//        System.out.println(foo(sourceDoubleArray));
        String str5 = "AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBB";
        //System.out.println(rle(str5));
        //String s = "(()";
        //String s = ")()())";
        //String s = ")(()())";
        //String s = ")(";
        String s = "())(()())(}()";
        //System.out.println(searchValidBrakcetsInInputString(s));




        Person person1 = new Person("Alex", "Zotov", 41);
        Person person2 =  new Person();
        person2.setAge(41);
        person2.setLastName("Zotov");
        person2.setFirstName("Alex");

       // System.out.println(person1.equals(person2));

        //String s = "anagram";
        String t = "nagaram";
//        System.out.println(isAnagram(s, t));
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        //System.out.println(groupAnagrams(strs));

        int[] arr1 = {2,4,7,9,11,15,37,45,56};
        int[] arr2 = {1,3,5,7,8,9,12,16};

        //System.out.println(Arrays.toString(sortedArrayFromTwoSortedArray(arr1, arr2)));
        //System.out.println(Arrays.toString(mergeSortedArraysWithStreamApi(arr1, arr2)));

        System.out.println(makeTimeReadableHumanFormat(5));

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

//        public static String reverseString2(String str) {
//            String str1 = str.toLowerCase();
//            String str2 = "";
//            str2 += str1.replace(str.charAt(str.length() - 1), Character.toUpperCase(str.charAt(str.length() - 1)));
//            String str3 = "";
//            for (int i = str2.length() - 1 ; i >= 0; i--) {
//                if(" ".equals(str2.charAt(i))) {
//                   str3 += str3.replace(str2.charAt(i), Character.toUpperCase(str2.charAt(i +1)));
//                }
//                str3+=str2.charAt(i);
//            }
//            return str3;
//        }

    //Make Method filter strings "aaa", method get array of strings
    public static void fiterTripleA(String[] stringCollection) {
        /*String[] filetredStringArray  =*/ Arrays.stream(stringCollection).filter(s -> !s.startsWith("aaa")).forEach(s -> System.out.println(s));
    }

    //Make bubble sort method with exception, if incoming array is empty
    public static int[] sort(int[] sourceArray) throws MyException {
      if(sourceArray.length == 0) throw new MyException("The length of sourceArray not be equals 0");
        //int temp = 0;
        for (int i = 0; i < sourceArray.length ; i++) {

            for (int j = 0; j < sourceArray.length - 1; j++) {

                if (sourceArray[j] > sourceArray[j + 1]) {
                    int temp = sourceArray[j];
                    sourceArray[j] = sourceArray[j + 1];
                    sourceArray[j + 1] = temp;
                }
            }
        }
        return sourceArray;
        }

        public static double foo(double[] sourceDoubleArray) throws MyDoubleException {
            Arrays.sort(sourceDoubleArray);
            double sum = 0.0;
            Double result = 0.0;


            try {
            double min = sourceDoubleArray[0];
            double max = sourceDoubleArray[sourceDoubleArray.length - 1];

            for (int i = 0; i < sourceDoubleArray.length; i++) {
                sum += sourceDoubleArray[i];
            }

            double avg = sum / sourceDoubleArray.length;

            if (avg == 0) {
                throw new MyDoubleException("Divide by zero exception");
            }

            result = (max - min) / avg;

        } catch (ArrayIndexOutOfBoundsException ex) {
            if (ex instanceof ArrayIndexOutOfBoundsException) {
                throw new MyDoubleException("Empty input array");
            }
        }

            return result;
        }

        public static boolean isAnagram(String s, String t) {
            boolean result = false;
            char[] sArray = s.toCharArray();
            char[] tArray = t.toCharArray();
//            System.out.println(Arrays.toString(sArray));
//            System.out.println(Arrays.toString(tArray));

            Arrays.sort(sArray);
            Arrays.sort(tArray);

//            System.out.println(Arrays.toString(sArray));
//            System.out.println(Arrays.toString(tArray));

            if(Arrays.equals(sArray, tArray)) {
                result = true;
            }
            return result;
        }

        public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
            for (int i = 0; i < strs.length; i++) {
                char[] fArr = strs[i].toCharArray();
                Arrays.sort(fArr);
                List<String> list = new ArrayList<>();
                for (int j = i + 1; j < strs.length - 1; j++) {

                    char[] sArr = strs[j].toCharArray();

                    Arrays.sort(sArr);
                    if(Arrays.equals(fArr, sArr)) {
                        list.add(strs[i]);
                        list.add(strs[j]);
                    } else if (!Arrays.equals(fArr, sArr)){
                        list.add(strs[i]);
                    }
                }
                res.add(list);
            }
            return res;
        }

        public static int[] sortedArrayFromTwoSortedArray (int[] arr1, int[] arr2) {
            int[] mergedSortedArray = new int[arr1.length + arr2.length];
            int i = 0;
            int j = 0;
            int r = 0;
            //for (int i = 0; i < (arr1.length < arr2.length?arr1.length:arr2.length); i++) {
            while(i < arr1.length && j < arr2.length) {
                if (arr1[i] < arr2[j]) {
                    mergedSortedArray[r] = arr1[i];
                    i++;
                } else {
                    mergedSortedArray[r] = arr2[j];
                    j++;
                }
                r++;
            }
                if (i < arr1.length) {
                    System.arraycopy(arr1, i, mergedSortedArray, r, arr1.length - i);
                }
                if (j < arr2.length) {
                    System.arraycopy(arr2, j, mergedSortedArray, r, arr2.length - j);
                }
                return mergedSortedArray;
            }

    public static int[] mergeSortedArraysWithStreamApi(int[] arr1, int[] arr2) {
        return IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).sorted().toArray();
    }


        public static String rle(String input) {
            int count = 1;

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < input.length() - 1; i++) {
                char ch;
                if (input.charAt(i) == input.charAt(i + 1)) {
                    count++;
                } else {
                    ch = input.charAt(i);
                    sb.append(ch).append(count);
                    count = 1;
                }

                if(i + 1 == input.length() - 1) {
                    ch = input.charAt(i + 1);
                    sb.append(ch).append(count);
                }
            }
            return sb.toString();
        }

        //Checking string contains valid brackets
        public static boolean isValidBrackets(String input) {
        Map<Character, Character> brackets = new HashMap<>();
        Deque<Character> stack = new LinkedList<>();
        brackets.put(')', '(');
        brackets.put('}', '{');
        brackets.put(']', '[');

        for(char c : input.toCharArray()) {
            if(brackets.containsKey(c)) {
                stack.push(c);
            } else if (brackets.containsValue(c)) {
                if(stack.isEmpty() || stack.pop() !=brackets.get(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
        }

        public static String /*void*/ searchValidBrakcetsInInputString(String s) {
//            char[] symbols = input.toCharArray();
//            Deque<Character> stack = new LinkedList<>();
//           LinkedList<Integer> stackOfIndexes = new LinkedList<>();
//            int counter = 0;
//            StringBuilder sb = new StringBuilder();
//            System.out.println("Input string " + input);
////            for (char c : symbols) {
//            for (int i = 0; i < symbols.length; i++) {
//
//
//                //counter++;
//                char c = symbols[i];
//                if (c == '(' || c == '{' || c == '[') {
//                    //System.out.println("РАССМАТРИВАЕТСЯ открывающая, индекс " + counter);
//                    stack.push(c);
//                    stackOfIndexes.add(i);
//                    //System.out.println("На стек помещена открывающая");
//                }
//
//                if (c == ')' || c == '}' || c == ']') {
//                    //System.out.println("РАССМАТРИВАЕТСЯ закрывающая, индекс " + counter);
//                    if(i == 0) {
//                        stackOfIndexes.add(i);
//                    }
//                    if (!stack.isEmpty()) {
//                        //System.out.println("Стек непустой");
//                        char fromStack = stack.peek();
//                        if ((c == ')' && fromStack == '(') ||
//                                (c == '}' && fromStack == '{') ||
//                                (c == ']' && fromStack == '[')) {
//                            counter += 2;
//                            stack.pop();
//                            stackOfIndexes.removeLast();
//
//                        } else {
//                            stackOfIndexes.add(i);
//                        }
//
//                    } else if (i == symbols.length - 1) {
//                        stackOfIndexes.add(i);
//                    }
//
//                }
//
//            }
//            if (!stackOfIndexes.isEmpty()) {
//                for (int i = 0; i < symbols.length; i++) {
//                  if(i != stackOfIndexes.getFirst()) {
//                      sb.append(symbols[i]);
//                  } else {
//                      if(stackOfIndexes.size() != 0) {
//                          stackOfIndexes.removeFirst();
//                      } else {
//                          break;
//                      }
//                  }
//                }
//            }
//
//            if(counter == 0) {
//                System.out.println("0");
//            } else {
//                System.out.println(counter + " - " + sb);
//            }



                    Deque<Character> stack = new LinkedList<>();
                    //Deque<Integer> validParenthess = new LinkedList<>();
                    List<Integer> validParenthess = new ArrayList<>();
                    Map<Character,Character> map = new HashMap<>();

                    map.put(')','(');
                    map.put('}','{');
                    map.put(']','[');

                    StringBuilder sb = new StringBuilder();
                    int count = 0;
                    int j = 0;
                    for(int i = 0; i < s.length(); i++) {
                        if (map.containsValue(s.charAt(i))) {
                            stack.push(s.charAt(i));
                            validParenthess.add(i);
                        }

                        if (map.containsKey(s.charAt(i))) {
                            if (!stack.isEmpty() && stack.peek() == map.get(s.charAt(i))) {
                                count += 2;
                                stack.pop();
                                //validParenthess.push(i-1);
                                validParenthess.add(i);
                            }
//            } else {
//                validParenthess.removeLast();
                        }
                    }

//                    while (!stack.isEmpty()) {
//                        validParenthess.remove(mapCharIndex.get(stack.peek()));
//                    }
                    // validParenthess.removeLast();
                    return validParenthess.toString() + " " + count;
                }

    public static String makeTimeReadableHumanFormat(int seconds) {
        // Do something
        StringBuilder sb = new StringBuilder();

        int hours = seconds/3600;
        System.out.println(hours);
        int min = (seconds - hours*3600)/60;
        System.out.println(min);
        int sec = seconds - hours*3600 - min*60;
        System.out.println(sec);

        System.out.println(hours/10);
        System.out.println(min/10);
        System.out.println(sec/10);

        ((hours/10 < 1) ? sb.append('0').append(hours): sb.append(hours)).append(":");
        ((min/10 < 1) ? sb.append('0').append(min): sb.append(min)).append(":");
        ((sec /10 < 1) ? sb.append('0').append(sec): sb.append(sec)).append("");

        return sb.toString();
    }





}

//bubble sort method exception
class MyException extends Exception {

   public MyException (String message) {
       super(message);
   }
}

class MyDoubleException extends Exception {

    public MyDoubleException (String message) {
        super(message);
    }
}

class Person {

    String firstName;
    String lastName;
    Integer age;

    public Person() {}

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object person1) {
        Person person2 = new Person(firstName, lastName, age);
        //return  (person2.age == ((Person) person1).age && person2.firstName.equals(((Person) person1).firstName) && person2.lastName.equals(((Person) person1).lastName));
        return person1.hashCode() == person2.hashCode();
    }

    @Override
    public int hashCode() {
        return 31*age*firstName.length()*lastName.length();
    }
}

record Order (Long id, List<Long> productIds, LocalDate orderDate) {

    private static final int BIG_ORDER_SIZE = 10;

    /*1*/    public Order {
        if (productIds().isEmpty()) {
            throw new IllegalArgumentException("");
        }
    }

    /*2*/    public Order (Long id) {
        this(id, List.of(), LocalDate.now());
    }

    /*3*/    public static Order emptyOrder(Long id) {
        return new Order(id);
    }

    /*4*/    public List<Long> productIds() {
        return List.copyOf(productIds);
    }

    /*5    public void updateDate() {
        this.orderDate = LocalDate.now();
    }*/

    /*6    public static boolean isBigOrder() {
        return productIds.size() >= BIG_ORDER_SIZE;
    }*/
}


