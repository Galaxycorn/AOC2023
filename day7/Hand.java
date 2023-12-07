package day7;

import java.util.List;
import java.util.ArrayList;

public class Hand implements Comparable<Hand> {

    long bid;
    Rank rank;
    Card[] cards;

    public Hand(String hand, String bid, boolean joker) {
        this.bid = Long.parseLong(bid);
        List<Card> cardList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            if (joker) {
                cardList.add(Card.findByCharJoker(hand.substring(i, i + 1)));
            } else {
                cardList.add(Card.findByChar(hand.substring(i, i + 1)));
            }
        }
        cards = cardList.toArray(new Card[5]);
        rank = Rank.determine(cards);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card c : cards) {
            sb.append(c);
        }
        sb.append(" ");
        sb.append(rank);
        sb.append(" ");
        sb.append(bid);
        return sb.toString();
    }

    @Override
    public int compareTo(Hand o) {
        int c = rank.compareTo(o.rank);
        if (c == 0) {
            for (int i = 0; i < 5; i++) {
                c = cards[i].compareTo(o.cards[i]);
                if (c != 0) {
                    return c;
                }
            }
        }
        return c;
    }

}
