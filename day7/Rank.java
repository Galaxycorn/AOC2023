package day7;

import java.util.EnumMap;

public enum Rank {
    FIVE_OF_A_KIND,
    FOUR_OF_A_KIND,
    FULL_HOUSE,
    THREE_OF_A_KIND,
    TWO_PAIR,
    ONE_PAIR,
    HIGH_CARD;

    public static Rank determine(Card[] cards) {
        EnumMap<Card, Integer> map = new EnumMap<>(Card.class);
        map.put(Card.JOKER, 0);
        for (Card card : cards) {
            if (!map.containsKey(card)) {
                map.put(card, 1);
            } else {
                map.put(card, map.get(card) + 1);
            }
        }
        int joker = map.remove(Card.JOKER);
        if (joker == 5) {
            return FIVE_OF_A_KIND;
        }
        int counterPair = 0;
        boolean threeCards = false;
        for (var value : map.values()) {
            if (value + joker == 5) {
                return FIVE_OF_A_KIND;
            }
            if (value + joker == 4) {
                return FOUR_OF_A_KIND;
            }
            if (value == 3) {
                threeCards = true;
            }
            if (value == 2) {
                counterPair++;
            }
        }
        if ((counterPair == 1 && threeCards) || (counterPair == 1 && joker == 2)
                || joker == 1 && counterPair == 2) {
            return FULL_HOUSE;
        }
        if (threeCards || counterPair == 1 && joker == 1 || joker == 2) {
            return THREE_OF_A_KIND;
        }
        if (counterPair == 2) {
            return TWO_PAIR;
        }
        if (counterPair == 1 || joker == 1) {
            return ONE_PAIR;
        }
        return HIGH_CARD;
    }

}
