import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Calculadora {
    private List<Integer> resultados;
    public Calculadora() {
        resultados = new ArrayList<>();
    }
    public int sumar(int a, int b) {
        return a + b;
    }
    public int sumar(int a, int b, int c) {
        return a + b + c;
    }
    public double sumar(double a, double b) {
        return a + b;
    }
    public void dividir(int a, int b) {
        try {
            int resultado = a / b;
            System.out.println("Resultado de la división: " + resultado);
            resultados.add(resultado);
        } catch (ArithmeticException e) {
            System.out.println("Error: No se puede dividir entre cero.");
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
    public void mostrarResultados() {
        System.out.println("Resultados almacenados:");
        for (int r : resultados) {
            System.out.println(r);
        }
    }
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();

        // Mostrar operaciones de suma
        System.out.println("Probando sumas:");
        System.out.println("Suma de 2 números (5 + 3): " + calc.sumar(5, 3));
        System.out.println("Suma de 3 números (5 + 3 + 2): " + calc.sumar(5, 3, 2));
        System.out.println("Suma de 2 decimales (5.5 + 2.3): " + calc.sumar(5.5, 2.3));

        // Pedir datos para dividir
        try {
            String numStr = JOptionPane.showInputDialog("Ingrese el numerador:");
            String denStr = JOptionPane.showInputDialog("Ingrese el denominador:");

            int num = Integer.parseInt(numStr);
            int den = Integer.parseInt(denStr);

            calc.dividir(num, den);

        } catch (NumberFormatException e) {
            System.out.println("Error: Debes ingresar valores numéricos enteros.");
        }
        calc.mostrarResultados();
    }
}