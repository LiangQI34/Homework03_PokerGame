public class Cards {
    String type;
    String[] content;

    Cards(String[] content) {
        this.content = content;
    }

    public String getCardNumber(int index) {
        return content[index].substring(0, 1);
    }

    public String getCardSuit(int index) {
        return content[index].substring(1,2);
    }
}
