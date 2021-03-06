//Convert a time from 12-hour to its 24-hour equivalent.

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String timeConversion(String s) {
        
        String substr="PM";
        
        //if the given time is PM:
        if (s.toLowerCase().contains(substr.toLowerCase())){
            if (s.substring(0,2).equals("12")){
                //return same time without the string "PM"
                return s.substring(0,8);
            } else{
                //add 12 hours by spliting s at the first occurence of the string ":"
                int militaryTime=Integer.parseInt(s.split(":")[0]);
                militaryTime+=12;
             
                //strings are immutable, but we can overwrite the first 2 characters
                String military=Integer.toString(militaryTime);
                s=military+s.substring(2,8);
                //must use index 8 not index 7 because STRING index = END IS EXCLUSIVE
                return s;
            }
        } else{
            //if given time is AM
            if (s.substring(0,2).equals("12")){ //**** == for primitive types like int, boolean, DOES NOT WORK FOR STRINGS
                //return 00:.... as hours
                return "00"+s.substring(2,8);
            } else{
                //return same time without the string "AM"
                return s.substring(0,8);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = timeConversion(s);
        System.out.println(result);
    }
}
