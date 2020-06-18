package javacore;

import OJSolution.application.maths.WitchDay;

import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        WitchDay witchDay = new WitchDay();
        System.out.println(witchDay.ordinalOfDate("2003-03-01"));
        System.out.println(witchDay.ordinalOfDate("2004-03-01"));
        System.out.println(witchDay.ordinalOfDate("2010-02-10"));
    }

    private static int minN(int[] A) {
        Queue queue = new PriorityQueue();
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) {

                queue.add(A[i]);
            }
        }
        int min = (Integer) queue.remove();
        for (int i = 1; i < A.length; i++) {
            if (i == min) {
                if (!queue.isEmpty()) {
                    min = (Integer) queue.remove();
                } else {
                    return i + 1;
                }
            } else if (i < min) {
                return i;
            } else if (i > min) {
                return i;
            }
        }
        return 1;
    }
}
