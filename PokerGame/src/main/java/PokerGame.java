import java.util.ArrayList;

public class PokerGame {
    static final String[] TYPE = {"high card", "one pair", "two pairs", "three of a kind", "straight", "flush", "straight flush"};
    static final String[] CARD_NUMBER = {"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"};

    public String judge(String input) {
        String[] raw = input.split("`");
        Cards black = new Cards( raw[1].split(" ") );
        Cards white = new Cards( raw[3].split(" ") );

        String result = "tie";

        sort(black);
        setCardsType(black);
        sortByType(black);
        sort(white);
        setCardsType(white);
        sortByType(white);

        if(getIndexInStringArray(white.type, TYPE) > getIndexInStringArray(black.type, TYPE)) {
            return "White wins";
        } else if (getIndexInStringArray(white.type, TYPE) < getIndexInStringArray(black.type, TYPE)) {
            return "Black wins";
        }

        for (int i = 0; i < black.content.length; i++) {
            int blackNumberIndex = getIndexInStringArray(black.getCardNumber(i), CARD_NUMBER);
            int whiteNumberIndex = getIndexInStringArray(white.getCardNumber(i), CARD_NUMBER);

            if (blackNumberIndex > whiteNumberIndex) {
                return "Black wins";
            } else if (whiteNumberIndex > blackNumberIndex) {
                return "White wins";
            }
        }

        return "Tie";
    }

    private void sort(Cards cards) {
        for (int i = 0; i < cards.content.length - 1; i++) {
            for (int j = 0; j < cards.content.length - 1; j++) {
                int currentIndex = getIndexInStringArray(cards.getCardNumber(j), CARD_NUMBER);
                int nextIndex = getIndexInStringArray(cards.getCardNumber(j + 1), CARD_NUMBER);

                if(currentIndex < nextIndex) {
                    String tmp = cards.content[j];
                    cards.content[j] = cards.content[j + 1];
                    cards.content[j + 1] = tmp;
                }
            }
        }

        /*for (int i = 0; i < cards.content.length; i++) {
            System.out.print(cards.content[i] + " ");
        }
        System.out.println();*/
    }

    private void setCardsType(Cards sortedCards) {
        // flush
        boolean isFlush = true;
        String suit = sortedCards.getCardSuit(0);
        for (int i = 1; i < sortedCards.content.length; i++) {
            if (!suit.equals(sortedCards.getCardSuit(i))){
                isFlush = false;
                break;
            }
        }

        // straight
        boolean isStraight = true;
        int firstCardNumberIndex = getIndexInStringArray(sortedCards.getCardNumber(0), CARD_NUMBER);
        for (int i = 1; i < sortedCards.content.length; i++) {
            if(getIndexInStringArray(sortedCards.getCardNumber(i), CARD_NUMBER) != firstCardNumberIndex - i) {
                isStraight = false;
                break;
            }
        }

        //pair or three of a kind
        boolean isOnePair = false;
        boolean isTwoPairs = false;
        boolean isThreeOfAKind = false;

        for (int i = 0; i < sortedCards.content.length; i++) {
            int j = i + 1;

            while (j < sortedCards.content.length && sortedCards.getCardNumber(j).equals(sortedCards.getCardNumber(i))) {
                j++;
            }

            if (j - i == 2) {

                if (isOnePair) {
                    isOnePair = false;
                    isTwoPairs = true;
                } else {
                    isOnePair = true;
                }

            } else if (j - i > 2) {

                isThreeOfAKind = true;
                isOnePair = false;

            }
            i = j - 1;
        }

        if (isFlush && isStraight) {
            sortedCards.type = "straight flush";
        } else if (isFlush) {
            sortedCards.type = "flush";
        } else if (isStraight) {
            sortedCards.type = "straight";
        } else if (isThreeOfAKind) {
            sortedCards.type = "three of a kind";
        } else if (isTwoPairs) {
            sortedCards.type = "two pairs";
        } else if (isOnePair) {
            sortedCards.type = "one pair";
        } else {
            sortedCards.type = "high card";
        }

        //System.out.println(sortedCards.type);
    }

    private void sortByType(Cards cards) {
        System.out.println(cards.type);
        if (cards.type.equals("three of a kind") || cards.type.equals("one pair") || cards.type.equals("two pairs")) {
            ArrayList<String> sortedList = new ArrayList<>();

            // add same card first.
            for (int i = 0; i < cards.content.length; i++) {
                int j = i + 1;
                while (j < cards.content.length && cards.getCardNumber(j).equals( cards.getCardNumber(i) )) {
                    sortedList.add(cards.content[j]);
                    cards.content[j] = null;
                    j++;
                    if (j - i == 3){
                        break;
                    }
                }
                if(j - i > 1) {
                    sortedList.add(cards.content[i]);
                    cards.content[i] = null;
                }
                i = j - 1;
            }

            // add others
            for (int i = 0; i < cards.content.length; i++) {
                if (cards.content[i] != null) {
                    sortedList.add(cards.content[i]);
                }
            }

            cards.content = sortedList.toArray(cards.content);

            for (int i = 0; i < cards.content.length; i++) {
                System.out.print(cards.content[i] + " ");
            }
            System.out.println();
        }
    }

    private int getIndexInStringArray(String source, String[] array) {
        for (int i = 0; i < array.length; i++) {
            if (source.equals(array[i]))
            {
                return i;
            }
        }
        return -1;
    }
}
