/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise2;

import exercise1.Exercise1;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asnorrason
 */
public class Exercise2 {

    public static void main(String[] args) {
        boolean tryBoolean = true;

        Even e = new Even();
        MyThread t1 = new MyThread(e);
        MyThread t2 = new MyThread(e);

        t1.start();
        t2.start();
        while (tryBoolean) {

            if (t1.evenNumber(e) % 2 != 0) {
                System.out.println("fejl");
                break;
            }

            if (t2.evenNumber(e) % 2 != 0) {
                System.out.println("fejl");
                break;

            }
        }

    }

    public static class Even {

        private int n = 0;

        public int next() {
            n++;
            n++;
            return n;
        }
    }

    public static class MyThread extends Thread {

        private Even e;

        public MyThread(Even e) {
            this.e = e;
        }

        @Override
        public void run() {

            evenNumber(e);

        }

        public int evenNumber(Even e) {
            return e.next();
        }

    }

}
