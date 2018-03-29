package ro.gabriel.oarga.Model;

public class BoardElement {
    private String value;
    private int x;
    private int y;

    BoardElement(int x, int y) {
        this.value = "?";
        this.x = x;
        this.y = y;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
