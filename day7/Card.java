package day7;

public enum Card {

    A("A"), K("K"), Q("Q"), JACK("J"), TEN("T"), NINE("9"), EIGHT("8"), SEVEN("7"),
    SIX("6"), FIVE("5"), FOUR("4"), THREE("3"), TWO("2"), JOKER("*");

    private final String value;

    Card(String value) {
        this.value = value;
    }

    public static Card findByChar(String character) {
        for (Card card : values()) {
            if (card.value.equals(character)) {
                return card;
            }
        }
        return null;
    }

    public static Card findByCharJoker(String character) {
        if (character.equals("J")) {
            return JOKER;
        }
        return findByChar(character);
    }

    @Override
    public String toString() {
        return value;
    }

}
