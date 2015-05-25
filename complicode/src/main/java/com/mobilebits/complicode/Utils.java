package com.mobilebits.complicode;

/**
 * Created by iluretar on 03-Apr-15.
 */
public class Utils {

    public static final int REPEAT_TWO = 2;
    public static final int REPEAT_FIVE = 5;
    public static final int DEFAULT_ARRAY_LENGHT=5;

    public static int[] addToArray(int[] array, int value){
        int[] result = new int[array.length];
        for(int i=0; i< array.length; i++){
            result[i]= array[i] + value;
        }
        return result;
    }

    public static int arrayAdd(int[] array, int position){
        int result=0;
        for(int i=0; i< position; i++){
            result+= array[i];
        }
        return result;
    }

    public static int arrayAdd(char[] array, int position){
        int result=0;
        for(int i=0; i< position; i++){
            result+= (int)(array[i]);
        }
        return result;
    }

    public static String arrayConcat(int[] array, int position){
        String result="";
        for(int i=0; i< position; i++){
            result+= array[i];
        }
        return result;
    }

    static public int addAscii(String string, int start){
        int result = 0;
        char[] values = string.toCharArray();
        while(start < values.length){
            result += (int)(values[start]);
            start += 5;
        }

        return result;
    }

    static public String addDash(String string){
        StringBuilder buffer = new StringBuilder(string);
        int stepping=2;
        int dashes=0;
        for(int i=0; i<= string.length()/stepping; i+=stepping){
            string = buffer.insert(i+stepping+dashes, "-").toString();
            dashes++;
        }
        return string;
    }
}
