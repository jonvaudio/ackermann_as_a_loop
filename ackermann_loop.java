package com.jon;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        System.out.println(ackerman_recurse(3, 3));
        System.out.println(ackerman_loop(3, 3));

        System.out.println(ackerman_recurse(3, 1));
        System.out.println(ackerman_loop(3, 1));

        System.out.println(ackerman_recurse(2, 4));
        System.out.println(ackerman_loop(2, 4));
    }

    public static long ackerman_recurse(long m, long n) {
        if (!(m >= 0 && n >= 0)) throw new IllegalArgumentException("m and n must be nonnegative");
        if (m == 0) return n + 1;
        else {
            // m > 0
            if (n == 0) return ackerman_recurse(m-1, 1);
            else return ackerman_recurse(m-1, ackerman_recurse(m, n-1)); // n > 0
        }
    }

    public static long ackerman_loop(long m, long n) {
        if (!(m >= 0 && n >= 0)) throw new IllegalArgumentException("m and n must be nonnegative");
        Stack<Long> ms = new Stack();
        while (true) {
            if (m == 0) {
                if (ms.isEmpty()) return n + 1;
                else {
                    m = ms.pop();
                    ++n;
                }
            } else {
                // m > 0
                if (n == 0) {
                    // tail call
                    --m;
                    n = 1;
                } else {
                    // n > 1
                    ms.push(m-1);
                    --n;
                }
            }
        }
    }
}
