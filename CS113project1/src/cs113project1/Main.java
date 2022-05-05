/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs113project1;

/**
 *
 * @author mahigada
 */
public class Main {

    public static void main(String[] args) {

        Rational a = new Rational(2, 4);
        Rational b = new Rational(2, 6);

        System.out.println(a + " + " + b + " = " + a.add(b));
        System.out.println(a + " - " + b + " = " + a.sub(b));
        System.out.println(a + " * " + b + " = " + a.mul(b));
        System.out.println(a + " / " + b + " = " + a.div(b));

        Rational[] arr = {new Rational(7, 1), new Rational(6, 1),
                          new Rational(5, 1), new Rational(4, 1),
                          new Rational(3, 1), new Rational(2, 1),
                          new Rational(1, 1), new Rational(1, 2),
                          new Rational(1, 3), new Rational(1, 4),
                          new Rational(1, 5), new Rational(1, 6),
                          new Rational(1, 7), new Rational(1, 8),
                          new Rational(1, 9), new Rational(0, 1)};

        selectSort(arr);

        for (Rational r : arr) {
            System.out.println(r);
        }

        Number n = new Rational(3, 2);

        System.out.println(n.doubleValue());
        System.out.println(n.floatValue());
        System.out.println(n.intValue());
        System.out.println(n.longValue());
    }

    public static <T extends Comparable<? super T>> void selectSort(T[] array) {

        T temp;
        int mini;

        for (int i = 0; i < array.length - 1; ++i) {

            mini = i;

            for (int j = i + 1; j < array.length; ++j) {
	            if (array[j].compareTo(array[mini]) < 0) {
	                mini = j;
	            }
            }

            if (i != mini) {
	            temp = array[i];
	            array[i] = array[mini];
	            array[mini] = temp;
            }
        }
    }
}
