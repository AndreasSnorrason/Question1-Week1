/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asnorrason
 */
public class Exercise1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            Task1 t1 = new Task1();
            Task2 t2 = new Task2();
            Task3 t3 = new Task3();
            
            t1.start();
            t2.start();
            t3.start();
            Thread.sleep(10000);
            t3.tryBoolean = false;
        } catch (InterruptedException ex) {
            System.err.println("Fejl");
        }
        
    }

    public static class Task1 extends Thread {

        @Override
        public void run() {
            long counter = 0;
            for (int i = 1; i <= 1000000000; i++) {
                counter += i;
            }
            System.out.println("Total value Task1 " + counter);
        }
    }

    public static class Task2 extends Thread {

        @Override
        public void run() {
            for (int i = 0; i <= 5; i++) {
                try {
                    System.out.println("i's værdi i task 2 er " + i);
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Exercise1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    public static class Task3 extends Thread {

        volatile boolean tryBoolean = true;
        int count = 10;

        @Override
        public void run() {
            while (tryBoolean) {

                try {
                    System.out.println("Værdien i task3 er: " + count);
                    count++;
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Exercise1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

    }
}
