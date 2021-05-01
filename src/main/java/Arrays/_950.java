package main.java.Arrays;

import java.util.Arrays;

/**
 * In a deck of cards, every card has a unique integer.  You can order the deck in any order you want.
 * <p>
 * Initially, all the cards start face down (unrevealed) in one deck.
 * <p>
 * Now, you do the following steps repeatedly, until all cards are revealed:
 * <p>
 * Take the top card of the deck, reveal it, and take it out of the deck.
 * If there are still cards in the deck, put the next top card of the deck at the bottom of the deck.
 * If there are still unrevealed cards, go back to step 1.  Otherwise, stop.
 * Return an ordering of the deck that would reveal the cards in increasing order.
 * <p>
 * The first entry in the answer is considered to be the top of the deck.
 */
public class _950 {

    public static void main(String[] args) {
        _950 test = new _950();
        test.deckRevealedIncreasing(new int[]{17, 13, 11, 2, 3, 5, 7});
    }

    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int len = deck.length;
        int[] result = new int[len];
        int loopTill = 0;
        loopTill = len % 2 != 0 ? (len / 2) + 1 : len / 2;
        result[0] = deck[0];
        for (int i = 2, j = 1; j < loopTill && i < len; i += 2, j++) {
            result[i] = deck[j];
        }

        for (int i = loopTill, j = 1; i < len && j < len; i++, j += 2) {
            result[j] = deck[i];
        }

        for (int i = 1; i < len && i + 2 < len; i += 4) {
            swap(result, i, i + 2);

        }
        return result;
    }

    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
