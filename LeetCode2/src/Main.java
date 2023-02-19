import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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


        list1.add(null);//<? extends A> producer ������ ������ �������� ����� null
        //list1.add(d);<? extends A> producer ������ ������ �������� ����� null
        list2.add(b);
        list2.add(c);
        //end generic test


        //System.out.println(removeElement(nums, 3));
        //System.out.println(searchInsert(nums, 5));
        //System.out.println(plusOne(digits).toString());
        // System.out.println(getDuplicatedWordsInString("Java i like this programming language java"));
        String str = "Иванов Иван Иванович";
        //System.out.println(reverseString(str));
        //System.out.println(exchangeSymbols(str,  '�', '�'));
        //System.out.println(stringToInt("-23"));
        //outputNumbers();
        //System.out.println(stringToDouble("23"));
//        int[] nums1 = {1,2,3,5,7};
//        int[] nums2 = {2,3,4,6,8};
//        printNonRepeatElementsInFirstArray(nums1, nums2);
        //System.out.println(reverseString2(str));
       // System.out.println(elm("MQNAAAAzzzBBCCCvvvvvvDDDDEBBBBBBBBBBvvv"));

        int[] nums3 = {1, 2, 3, 4, 3, 5};
        // System.out.println(containsDubl(nums3));

        //System.out.println(findFirstNonRepeatLetter("aaaabccccdggg"));
        String[] strArr = {"sdffgg", "fgdfg", "aaaahjfhj", "dfdfd", "aaa", "tyttyty"};
        //fiterTripleA(strArr);
        //int[] sourceArray = {2,6,4,8,9,5,7};
        //System.out.println(Arrays.toString(sort(sourceArray)));
        double[] sourceDoubleArray = {/*2.7,6.0,4.5,8.3,9.4,5.9,7.0*/0.0};
//        System.out.println(foo(sourceDoubleArray));
        Person person1 = new Person("Alex", "Zotov", 41);
        Person person2 = new Person();
        person2.setAge(41);
        person2.setLastName("Zotov");
        person2.setFirstName("Alex");

        //System.out.println(person1.equals(person2));

        int[] nums1 = {2, 9, 3, 8, 4, 7, 5, 6, 1};
        int[] nums2 = {6, 5, 4, 9, 8, 1, 0, 3, 4};
//        int[] nums1 = {1,2,3,5,7};
//        int[] nums2 = {2,3,4,6,8};
        //System.out.println("Repeated value array " + Arrays.toString(repeatedValueArray(nums1, nums2)));

        int[] arr1 = {1,3,4,6,78,23,56,78};
        int[] arr2 = {1,2,5,6,67,89,90};
        //System.out.println(Arrays.toString(mergeSortedArraysWithStreamApi(arr1, arr2)));

        String s = "ayuasdvvvfhjkkk";
        //System.out.println("removeRepeatedCharsFromStringPlusSort " + removeRepeatedCharsFromStringPlusSort(s));

        int[] array1 = {-10, -20, 5, 2, 2, -10, 6};
        int[] array2 = {-20, 1, 3, 3, 7, 6, 0, 0};

        symmetricSubstract(array1, array2);


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

    //��� �����
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
    public static class D {
    }

    public static class A extends D {
    }

    public static class B extends A {
    }

    public static class C extends B {
    }

    public static Double stringToDouble(String str) {
        Double result = 0.0;
        int isNegative = 1;
        int pow = 0;
        if (str.charAt(0) == '-') {
            isNegative = -1;
            str = str.substring(1);
        }
        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == ',') {
                ++i;
                pow = str.length() - i;
            }
            result = result * 10 + ((str.charAt(i))) - '0';
        }
        result = isNegative * result / Math.pow(10, pow);
        return result;
    }

    public static void printNonRepeatElementsInFirstArray(int[] nums1, int[] nums2) {
        int k = 0;
        int l = 0;

        while (k < nums1.length) {
            if (nums1[k] != nums2[l]) {
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
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else if (map.containsKey(nums[i])) {
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
            if (!map.containsKey(charArr[i])) {
                map.put(charArr[i], 1);
            } else if (map.containsKey(charArr[i])) {
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
        /*String[] filetredStringArray  =*/
        Arrays.stream(stringCollection).filter(s -> !s.startsWith("aaa")).forEach(s -> System.out.println(s));
    }

    //Make bubble sort method with exception, if incoming array is empty
    public static int[] sort(int[] sourceArray) throws MyException {
    if (sourceArray.length == 0) throw new MyException("The length of sourceArray not be equals 0");//int temp = 0;
        for (int i = 0; i < sourceArray.length; i++) {

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

    public static int[] repeatedValueArray(int[] nums1, int[] nums2) {
        int[] nums3 = new int[nums1.length];
        int k = 0;

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    //System.out.println(nums1[i]);
                    nums3[k] = nums1[i];
                    k++;
                    break;
                }
            }
        }
        int[] nums4 = new int[k];
        System.arraycopy(nums3, 0, nums4, 0, k);
        return nums4;
    }

    public static String elm(String str) {
        int count = 1;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length() - 1; i++) {
            char ch;
            if (str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                ch = str.charAt(i);
                sb.append(ch).append(count);
                count = 1;
            }

            if(i + 1 == str.length() - 1) {
                ch = str.charAt(i + 1);
                sb.append(ch).append(count);
            }
        }
        return sb.toString();
    }

    public static int[] mergeSortedArraysWithStreamApi(int[] arr1, int[] arr2) {
       return IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).sorted().toArray();
    }

    public static String removeRepeatedCharsFromStringPlusSort(String s) {
        StringBuilder sb = new StringBuilder();
        if(!s.isEmpty()) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            sb.append(chars[0]);
            for (int i = 1; i < chars.length; i++) {
                if(chars[i] != chars[i - 1]) {
                    sb.append(chars[i]);
                }

            }
        }
        return sb.toString();
    }

    public static int findNumberInArrayWhatMeetOddNumberTimes(int[] a) {
        int result = 0;
        Map<Integer, Integer> oddMap = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            //Before java8
//            if(oddMap.containsKey(a[i])) {
//                oddMap.put(a[i], oddMap.get(a[i]) + 1);
//            } else {
//                oddMap.put(a[i], 1);
            //java8
            oddMap.compute(a[i], (key, val) -> val == null ? 1: val + 1);
        }


        for (Map.Entry<Integer, Integer> entry : oddMap.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                result = entry.getKey();
            }
        }
        return result;
    }

//    int[] array1 = {-10, -20, 5, 2, 2, -10, 6};
//    int[] array2 = {-20, 1, 3, 3, 7, 6, 0, 0};
    //result -10 5 2 2 -10 1 3 3 7 0 0 not work
    public static void symmetricSubstract(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {

                if(arr1[i] != arr2[j]) {
                    System.out.print(arr1[i] + " ");
                }
            }

        }

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

    public Person(String firstName, int age) {
        this.firstName = firstName;
        //this.lastName = lastName;
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


