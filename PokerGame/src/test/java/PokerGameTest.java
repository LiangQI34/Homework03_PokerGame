import org.junit.Test;

public class PokerGameTest {
    @Test
    public void shouldReturnWhiteWinsInCase1() {
        String input = "Black: `2H 3D 5S 9C KD` White: `2C 3H 4S 8C AH`";
        PokerGame game = new PokerGame();
        String expectedResult = game.judge(input);
        assert expectedResult.equals("White wins");
    }
}
