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
}
