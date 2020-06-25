import org.junit.Test;

public class PokerGameTest {
    @Test
    public void shouldReturnWhiteWinsInCase1() {
        String input = "Black: `2H 3D 5S 9C KD` White: `2C 3H 4S 8C AH`";
        PokerGame game = new PokerGame();
        String expectedResult = game.judge(input);
        assert expectedResult.equals("White wins");
    }

    @Test
    public void shouldReturnWhiteWinsInCase2() {
        String input = "Black: `2H 4S 4C 2D 4H` White: `2S 8S AS QS 3S`";
        PokerGame game = new PokerGame();
        String expectedResult = game.judge(input);
        assert expectedResult.equals("White wins");
    }

    @Test
    public void shouldReturnBlackWinsInCase3() {
        // passed without change before case 2.
        String input = "Black: `2H 3H 5H 9H KH` White: `2C 3H 4S 5C 6H`";
        PokerGame game = new PokerGame();
        String expectedResult = game.judge(input);
        assert expectedResult.equals("Black wins");
    }

    @Test
    public void shouldReturnTieInCase4() {
        // passed without change before case 2.
        String input = "Black: `2H 3D 5S 9C KD` White: `2D 3H 5C 9S KH`";
        PokerGame game = new PokerGame();
        String expectedResult = game.judge(input);
        assert expectedResult.equals("Tie");
    }

    @Test
    public void shouldReturnBlackWinsInCase5() {
        // judge between one pair and two pairs
        String input = "Black: `2C 3H 3S 6C 6H` White: `2C 2S 3C 6D KH`";
        PokerGame game = new PokerGame();
        String expectedResult = game.judge(input);
        assert expectedResult.equals("Black wins");
    }

    @Test
    public void shouldReturnWhiteWinsInCase6() {
        // judge between flush and straight flush
        String input = "Black: `2C KC 3C 5C 6C` White: `3D 5D 7D 4D 6D`";
        PokerGame game = new PokerGame();
        String expectedResult = game.judge(input);
        assert expectedResult.equals("White wins");
    }

    @Test
    public void shouldReturnWhiteWinsInCase7() {
        // judge when both are one pair
        String input = "Black: `2C KD 2H 5C AS` White: `KS 5H 7D 4C KD`";
        PokerGame game = new PokerGame();
        String expectedResult = game.judge(input);
        assert expectedResult.equals("White wins");
    }

    @Test
    public void shouldReturnBlackWinsInCase8() {
        // judge when both are two pairs.
        // pass without change before case 7.
        String input = "Black: `2C KD 2H AC AS` White: `KS 7H 7D 4C KD`";
        PokerGame game = new PokerGame();
        String expectedResult = game.judge(input);
        assert expectedResult.equals("Black wins");
    }


}
