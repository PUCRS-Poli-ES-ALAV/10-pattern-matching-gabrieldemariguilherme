public class Contador {
    private int counter;

    public Contador() {
        this.counter = 0;
    }

    public void add(int value) {
        this.counter += value;
    }

    public void add() {
        this.counter++;
    }

    public void reset() {
        this.counter = 0;
    }

    public int getCounter() {
        return this.counter;
    }

    public void print(String message) {
        System.out.println(message + " " + this.counter + "operations");
    }
}
