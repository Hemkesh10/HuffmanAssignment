public class HuffmanObjects {


    int freq;
    char symbol;

    // constructor
    public HuffmanObjects(int f, char sym) {
        freq = f;
        symbol = sym;
    }

    // getters and setters
    public int getFreq() {
        return freq;
    }


    public void setFreq(int freq) {
        this.freq = freq;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
}
