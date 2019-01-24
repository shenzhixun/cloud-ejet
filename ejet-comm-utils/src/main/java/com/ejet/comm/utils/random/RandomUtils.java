package com.ejet.comm.utils.random;

import java.util.Random;

/**
 * Random Utils
 * <ul>
 * Shuffling algorithm
 * <li>{@link #shuffle(Object[])} Shuffling algorithm, Randomly permutes the specified array using a default source of
 * randomness</li>
 * <li>{@link #shuffle(Object[], int)} Shuffling algorithm, Randomly permutes the specified array</li>
 * <li>{@link #shuffle(int[])} Shuffling algorithm, Randomly permutes the specified int array using a default source of
 * randomness</li>
 * <li>{@link #shuffle(int[], int)} Shuffling algorithm, Randomly permutes the specified int array</li>
 * </ul>
 * <ul>
 * get random int
 * <li>{@link #getRandom(int)} get random int between 0 and max</li>
 * <li>{@link #getRandom(int, int)} get random int between min and max</li>
 * </ul>
 * <ul>
 * get random numbers or letters
 * <li>{@link #getRandomCapitalLetters(int)} get a fixed-length random string, its a mixture of uppercase letters</li>
 * <li>{@link #getRandomLetters(int)} get a fixed-length random string, its a mixture of uppercase and lowercase letters
 * </li>
 * <li>{@link #getRandomLowerCaseLetters(int)} get a fixed-length random string, its a mixture of lowercase letters</li>
 * <li>{@link #getRandomNumbers(int)} get a fixed-length random string, its a mixture of numbers</li>
 * letters and numbers</li>
 * <li>{@link #getRandom(String, int)} get a fixed-length random string, its a mixture of chars in source</li>
 * <li>{@link #getRandom(char[], int)} get a fixed-length random string, its a mixture of chars in sourceChar</li>
 * </ul>
 * 
 */
public class RandomUtils {

    public static final String NUMBERS_AND_LETTERS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String NUMBERS             = "0123456789";
    public static final String NUMBERS_AND_UP_LETTERS  = "0123456789_ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String NUMBERS_AND_LETTERS_LEGAL  = "0123456789abcdefghijklmnopqrstuvwxyz-_ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String LETTERS             = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String CAPITAL_LETTERS     = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String LOWER_CASE_LETTERS  = "abcdefghijklmnopqrstuvwxyz";

    private RandomUtils() {
        throw new AssertionError();
    }
    
    
    public static String getRandomLettersLegal(int length) {
        return getRandom(NUMBERS_AND_LETTERS_LEGAL, length);
    }

    /**
     * get a fixed-length random string, its a mixture of uppercase, lowercase letters and numbers
     * 
     * @param length
     * @return
     * @see RandomUtils#getRandom(String source, int length)
     */
    public static String getRandomNumbersAndUperLetters(int length) {
        return getRandom(NUMBERS_AND_UP_LETTERS, length);
    }

    /**
     * get a fixed-length random string, its a mixture of numbers
     * 
     * @param length
     * @return
     * @see RandomUtils#getRandom(String source, int length)
     */
    public static String getRandomNumbers(int length) {
        return getRandom(NUMBERS, length);
    }

    /**
     * get a fixed-length random string, its a mixture of uppercase and lowercase letters
     * 
     * @param length
     * @return
     * @see RandomUtils#getRandom(String source, int length)
     */
    public static String getRandomLetters(int length) {
        return getRandom(LETTERS, length);
    }

    /**
     * get a fixed-length random string, its a mixture of uppercase letters
     * 
     * @param length
     * @return
     * @see RandomUtils#getRandom(String source, int length)
     */
    public static String getRandomCapitalLetters(int length) {
        return getRandom(CAPITAL_LETTERS, length);
    }

    /**
     * get a fixed-length random string, its a mixture of lowercase letters
     * 
     * @param length
     * @return
     * @see RandomUtils#getRandom(String source, int length)
     */
    public static String getRandomLowerCaseLetters(int length) {
        return getRandom(LOWER_CASE_LETTERS, length);
    }

    /**
     * get a fixed-length random string, its a mixture of chars in source
     * 
     * @param source
     * @param length
     * @return <ul>
     *         <li>if source is null or empty, return null</li>
     *         <li>else see {@link RandomUtils#getRandom(char[] sourceChar, int length)}</li>
     *         </ul>
     */
    public static String getRandom(String source, int length) {
        return isEmpty(source) ? null : getRandom(source.toCharArray(), length);
    }
    /**
     * is null or its length is 0
     * 
     * <pre>
     * isEmpty(null) = true;
     * isEmpty(&quot;&quot;) = true;
     * isEmpty(&quot;  &quot;) = false;
     * </pre>
     * 
     * @param str
     * @return if string is null or its size is 0, return true, else return false.
     */
    public static boolean isEmpty(CharSequence str) {
        return (str == null || str.length() == 0);
    }
    
    /**
     * get a fixed-length random string, its a mixture of chars in sourceChar
     * 
     * @param sourceChar
     * @param length
     * @return <ul>
     *         <li>if sourceChar is null or empty, return null</li>
     *         <li>if length less than 0, return null</li>
     *         </ul>
     */
    public static String getRandom(char[] sourceChar, int length) {
        if (sourceChar == null || sourceChar.length == 0 || length < 0) {
            return null;
        }

        StringBuilder str = new StringBuilder(length);
        Random random = createRandom();
        for (int i = 0; i < length; i++) {
            str.append(sourceChar[random.nextInt(sourceChar.length)]);
        }
        return str.toString();
    }
    
    private static Random createRandom(){
    	
    	return new Random(System.nanoTime());
    }

    /**
     * get random int between 0 and max
     * 
     * @param max
     * @return <ul>
     *         <li>if max <= 0, return 0</li>
     *         <li>else return random int between 0 and max</li>
     *         </ul>
     */
    public static int getRandom(int max) {
        return getRandom(0, max);
    }

    /**
     * get random int between min and max
     * 
     * @param min
     * @param max
     * @return <ul>
     *         <li>if min > max, return 0</li>
     *         <li>if min == max, return min</li>
     *         <li>else return random int between min and max</li>
     *         </ul>
     */
    public static int getRandom(int min, int max) {
        if (min > max) {
            return 0;
        }
        if (min == max) {
            return min;
        }
        return min + createRandom().nextInt(max - min);
    }

    /**
     * Shuffling algorithm, Randomly permutes the specified array using a default source of randomness
     * 
     * @param objArray
     * @return
     */
    public static boolean shuffle(Object[] objArray) {
        if (objArray == null) {
            return false;
        }

        return shuffle(objArray, getRandom(objArray.length));
    }

    /**
     * Shuffling algorithm, Randomly permutes the specified array
     * 
     * @param objArray
     * @param shuffleCount
     * @return
     */
    public static boolean shuffle(Object[] objArray, int shuffleCount) {
        int length;
        if (objArray == null || shuffleCount < 0 || (length = objArray.length) < shuffleCount) {
            return false;
        }

        for (int i = 1; i <= shuffleCount; i++) {
            int random = getRandom(length - i);
            Object temp = objArray[length - i];
            objArray[length - i] = objArray[random];
            objArray[random] = temp;
        }
        return true;
    }

    /**
     * Shuffling algorithm, Randomly permutes the specified int array using a default source of randomness
     * 
     * @param intArray
     * @return
     */
    public static int[] shuffle(int[] intArray) {
        if (intArray == null) {
            return null;
        }

        return shuffle(intArray, getRandom(intArray.length));
    }

    /**
     * Shuffling algorithm, Randomly permutes the specified int array
     * 
     * @param intArray
     * @param shuffleCount
     * @return
     */
    public static int[] shuffle(int[] intArray, int shuffleCount) {
        int length;
        if (intArray == null || shuffleCount < 0 || (length = intArray.length) < shuffleCount) {
            return null;
        }

        int[] out = new int[shuffleCount];
        for (int i = 1; i <= shuffleCount; i++) {
            int random = getRandom(length - i);
            out[i - 1] = intArray[random];
            int temp = intArray[length - i];
            intArray[length - i] = intArray[random];
            intArray[random] = temp;
        }
        return out;
    }
    
    public static int[] shuffle(int start, int end, int shuffleCount) {
    	if(shuffleCount<=0 || end-start<shuffleCount) {
			return null;
		}
    	int[] arr = new int[end-start]; //可选择范围
		for(int i=0; i<arr.length; i++) {
			arr[i] = start + i;
		}
    	return shuffle(arr, shuffleCount);
    }
    
    public static Integer[] getRandomArray(Integer start, Integer end, int shuffleCount) {
		if(shuffleCount<=0 || end-start<shuffleCount) {
			return null;
		}
		Integer[] arr = new Integer[end-start]; //可选择范围
		for(int i=0; i<arr.length; i++) {
			arr[i] = start + i;
		}
		// System.out.println(ArrayUtils.toString(arr));
		Integer[] result = new Integer[shuffleCount];
		// System.out.println("目标长度:" + result.length);
		for(int j=0; j<shuffleCount; j++) {
			int max = arr.length-j-1;
			int random = getRandom(0, max);
			//System.out.println("随机数:" + random);
			Integer value = arr[random];
			Integer temp = arr[max];
			arr[random] = temp;
			arr[max] = value;
			result[j] = value;
		}
		return result;
	}
	
    
    
}
