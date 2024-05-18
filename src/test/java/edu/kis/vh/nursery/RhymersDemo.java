package edu.kis.vh.nursery;

import edu.kis.vh.nursery.factory.DefaultRhymersFactory;
import edu.kis.vh.nursery.factory.RhymersFactory;

/**
 * RhymersDemo: A class that
 * demonstrates the usage
 * of various rhymers created
 * by the RhymersFactory.
 */

class RhymersDemo {

    /**
     * The main method to run the demo.
     *
     * @param args command line arguments
     */

    public static void main(String[] args) {
        RhymersFactory factory = new DefaultRhymersFactory();
        testRhymers(factory);
    }

    /**
     * Tests the rhymers created by the given factory.
     * It initializes the rhymers, performs operations on them,
     * and prints their states.
     *
     * @param factory the factory used to create the rhymers
     */

    private static void testRhymers(RhymersFactory factory) {
        defaultCountingOutRhymer[] rhymers = { factory.GetStandardRhymer(), factory.GetFalseRhymer(),
                factory.GetFIFORhymer(), factory.GetHanoiRhymer()};

        // Pushes values into the first three rhymers
        for (int i = 1; i < 15; i++)
            for (int j = 0; j < 3; j++)
                rhymers[j].countIn(i);
        // Pushes random values into the Hanoi rhymer
        java.util.Random rn = new java.util.Random();
        for (int i = 1; i < 15; i++)
            rhymers[3].countIn(rn.nextInt(20));

        // Prints the values from the rhymers
        for (int i = 0; i < rhymers.length; i++) {
            while (!rhymers[i].callCheck())
                System.out.print(rhymers[i].countOut() + "  ");
            System.out.println();
        }

        // Prints the total number of rejected values in the Hanoi rhymer
        System.out.println("total rejected is "
                + ((HanoiRhymer) rhymers[3]).reportRejected());
    }
}