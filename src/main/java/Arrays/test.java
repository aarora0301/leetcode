package main.java.Arrays;

import java.util.ArrayList;
import java.util.List;

/***
 * Given a long make smaller strings of size 140 characters.
 * constraints:
 *    1. if a word is partially covered while making batch ignore that word
 *
 *  Follow up: Handle the case when string has millions of character
 */
public class test {

    public List<String> aggregator(String inpuStr, int limit) {
        String[] dummy = inpuStr.split(" ");
        List<String> result = new ArrayList<>();
        String processStr = "";
        int len = 0;

        for (String word : dummy) {
            if (len + word.length() + 1 < limit) {
                processStr += " " + word;
                len+= 1 + word.length();
            } else {
                result.add(processStr);
                processStr = word;
                len = word.length();
            }
        }
        result.add(processStr);
        return result;
    }

    public static void main(String[] args) {
        test a = new test();
        String input = "on Processor and Transaction Category No AcquiringBin Provided By VISA No acquirerCountryCode 840(USA) Routing Country , Transaction Category No Rule Change DA checkpoint For VISA OCT, we need to route the transaction to VISA DIRECT for Venmo and Paypal Transactions";
        List<String> result = a.aggregator(input, 140);
        for (String word : result) {
            System.out.println(word);
        }
    }
}
