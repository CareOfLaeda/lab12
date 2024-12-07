/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab12;

/// @author VALERIAN
class Main {

    public static double function(double x) {
        return x * x * x - x - 2;
    }

    public static double bisectionMethod(double a, double b, double epsilon) {
        if (function(a) * function(b) >= 0) {
            System.out.println("Метод бисекции не применим на этом интервале.");
            return Double.NaN;
        }

        double c = a;
        int maxIterations = 1000; // Ограничение на количество итераций
        for (int i = 0; i < maxIterations; i++) {
            c = (a + b) / 2; // Найти середину

            if (Math.abs(function(c)) < epsilon) {
                break; // Найден корень с заданной точностью
            } else if (function(c) * function(a) < 0) {
                b = c; // Корень находится в левой половине интервала
            } else {
                a = c; // Корень находится в правой половине интервала
            }
        }
        return c;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


        double a = 1.0; // Левая граница интервала
        double b = 2.0; // Правая граница интервала
        double epsilon = 0.0001; // Точность

        double root = bisectionMethod(a, b, epsilon);

        if (!Double.isNaN(root)) {
            System.out.println("Найден корень: " + root);
        }
    }

}
