package CommonPatterns;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class KMostFrequent {

    public static void main(String[] args) {
        KMostFrequent kMostFrequent = new KMostFrequent();
        String[] arr =
                new String[]{"plpaboutit", "jnoqzdute", "sfvkdqf", "mjc", "nkpllqzjzp", "foqqenbey", "ssnanizsav",
                             "nkpllqzjzp",
                             "sfvkdqf", "isnjmy", "pnqsz", "hhqpvvt", "fvvdtpnzx", "jkqonvenhx", "cyxwlef", "hhqpvvt",
                             "fvvdtpnzx",
                             "plpaboutit", "sfvkdqf", "mjc", "fvvdtpnzx", "bwumsj", "foqqenbey", "isnjmy", "nkpllqzjzp",
                             "hhqpvvt"
                        , "foqqenbey", "fvvdtpnzx", "bwumsj", "hhqpvvt", "fvvdtpnzx", "jkqonvenhx", "jnoqzdute",
                             "foqqenbey", "jnoqzdute", "foqqenbey",
                             "hhqpvvt", "ssnanizsav", "mjc", "foqqenbey", "bwumsj", "ssnanizsav", "fvvdtpnzx",
                             "nkpllqzjzp", "jkqonvenhx",
                             "hhqpvvt", "mjc", "isnjmy", "bwumsj", "pnqsz",
                             "hhqpvvt", "nkpllqzjzp", "jnoqzdute", "pnqsz",
                             "nkpllqzjzp", "jnoqzdute", "foqqenbey", "nkpllqzjzp", "hhqpvvt",
                             "fvvdtpnzx", "plpaboutit", "jnoqzdute", "sfvkdqf", "fvvdtpnzx", "jkqonvenhx", "jnoqzdute"
                        , "nkpllqzjzp", "jnoqzdute", "fvvdtpnzx", "jkqonvenhx", "hhqpvvt", "isnjmy", "jkqonvenhx",
                             "ssnanizsav", "jnoqzdute",
                             "jkqonvenhx", "fvvdtpnzx", "hhqpvvt", "bwumsj", "nkpllqzjzp", "bwumsj", "jkqonvenhx",
                             "jnoqzdute",
                             "pnqsz", "foqqenbey", "sfvkdqf", "sfvkdqf"};
        int k = 4;
        System.out.println(kMostFrequent.sortWords(arr, k).toString());
    }

    public List<String> sortWords(final String[] input, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : input) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        /***
         *  Using Comparator
         */
        PriorityQueue<WordFrequency> priorityQueue = new PriorityQueue<>(new WordFrequencyComparator());
        for (String word : map.keySet()) {
            priorityQueue.add(new WordFrequency(word, map.get(word)));
        }

        List<String> result = new LinkedList<>();
        int i = 0;

        while (!priorityQueue.isEmpty() && i < k) {
            result.add(priorityQueue.poll().getWord());
            i++;
        }
        return result;
    }
}

class WordFrequency {

    private String word;
    private int frequency;

    WordFrequency(final String word, final int frequency) {
        this.word = word;
        this.frequency = frequency;
    }

    public String getWord() {
        return word;
    }

    public int getFrequency() {
        return frequency;
    }
}


class WordFrequencyComparator implements Comparator<WordFrequency> {

    @Override
    public int compare(WordFrequency w1, WordFrequency w2) {
        if (w1.getFrequency() < w2.getFrequency()) {
            return 1;
        } else if (w1.getFrequency() > w2.getFrequency()) {
            return -1;
        } else {
            return w1.getWord().compareTo(w2.getWord());
        }
    }

}