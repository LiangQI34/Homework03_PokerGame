public class PokerGame {
    static final String[] TYPE = {"high card", "one pair", "two pairs", "three of a kind", "straight", "flush", "straight flush"};
    static final String[] CARD_NUMBER = {"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"};

    public String judge(String input) {
        String[] raw = input.split("`");
        Cards black = new Cards( raw[1].split(" ") );
        Cards white = new Cards( raw[3].split(" ") );

        String result = "tie";

        sort(black);
        sort(white);

        for (int i = 0; i < black.content.length; i++) {
            int blackIndex = getIndexInStringArray(black.content[i].substring(0,1), CARD_NUMBER);
            int whiteIndex = getIndexInStringArray(white.content[i].substring(0,1), CARD_NUMBER);

            if (blackIndex > whiteIndex) {
                result = "Black wins";
                break;
            } else if (whiteIndex > blackIndex) {
                result = "White wins";
                break;
            }
        }

        return result;
    }

    private void sort(Cards cards) {
        for (int i = 0; i < cards.content.length - 1; i++) {
            for (int j = 0; j < cards.content.length - 1; j++) {
                int currentIndex = getIndexInStringArray(cards.content[j].substring(0,1), CARD_NUMBER);
                int nextIndex = getIndexInStringArray(cards.content[j + 1].substring(0,1), CARD_NUMBER);

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
