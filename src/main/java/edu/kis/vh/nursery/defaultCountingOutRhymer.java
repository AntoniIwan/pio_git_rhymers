package edu.kis.vh.nursery;

public class defaultCountingOutRhymer {

    private static final int NUMBERS_SIZE = 12;
    private static final int TOTAL_STARTING_NUMBER = -1;
    private static final int TOTAL_MAX_NUMBER = 11;
    private final int[] numbers = new int[NUMBERS_SIZE];

    public int getTotal() {
        return total;
    }

    private int total = TOTAL_STARTING_NUMBER;

    public void countIn(int in) {
        if (!isFull())
            numbers[++total] = in;
    }

    public boolean callCheck() {
        return total == TOTAL_STARTING_NUMBER;
    }

    public boolean isFull() {
        return total == TOTAL_MAX_NUMBER;
    }

    protected int peekaboo() {
        if (callCheck())
            return TOTAL_STARTING_NUMBER;
        return numbers[total];
    }

    public int countOut() {
        if (callCheck())
            return TOTAL_STARTING_NUMBER;
        return numbers[total--];
    }

}
