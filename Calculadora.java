import javax.swing.JOptionPane;
public class Calculadora {
    public static void main(String[] args) {
        GestorArchivos gestor = new GestorArchivos("historial.txt");
        boolean continuar = true;
        while (continuar) {
            String opcion = JOptionPane.showInputDialog("""
                                                        Selecciona una opci\u00f3n:
                                                        1. Suma
                                                        2. Resta
                                                        3. Multiplicaci\u00f3n
                                                        4. Divisi\u00f3n
                                                        5. Potencia
                                                        6. Ra\u00edz cuadrada
                                                        7. M\u00f3dulo
                                                        8. Promedio
                                                        9. Factorial
                                                        10. MCD
                                                        11. MCM
                                                        12. Grados a Radianes
                                                        13. Verificar n\u00famero primo
                                                        14. Ver historial
                                                        15. Borrar historial
                                                        16. Salir""");
            switch (opcion) {
                case "1" -> operarBinaria("Suma", (a, b) -> a + b, gestor);
                case "2" -> operarBinaria("Resta", (a, b) -> a - b, gestor);
                case "3" -> operarBinaria("Multiplicación", (a, b) -> a * b, gestor);
                case "4" -> operarBinaria("División", (a, b) -> a / b, gestor);
                case "5" ->  {
                    double base = Double.parseDouble(JOptionPane.showInputDialog("Ingresa la base"));
                    double exponente = Double.parseDouble(JOptionPane.showInputDialog("Ingresa el exponente"));
                    double resultado = Math.pow(base, exponente);
                    gestor.guardarOperacion("Potencia: " + base + "^" + exponente + " = " + resultado);
                }
                case "6" ->  {
                    double numero = Double.parseDouble(JOptionPane.showInputDialog("Ingresa el número"));
                    double resultado = Math.sqrt(numero);
                    gestor.guardarOperacion("Raíz cuadrada de " + numero + " = " + resultado);
                }
                case "7" -> operarBinaria("Módulo", (a, b) -> a % b, gestor);
                case "8" ->  {
                    int cantidad = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos números ingresarás?"));
                    double suma = 0;
                    for (int i = 0; i < cantidad; i++) {
                        suma += Double.parseDouble(JOptionPane.showInputDialog("Número " + (i + 1)));
                    }
                    double promedio = suma / cantidad;
                    gestor.guardarOperacion("Promedio de " + cantidad + " números = " + promedio);
                }
                case "9" ->  {
                    int n = Integer.parseInt(JOptionPane.showInputDialog("Ingresa un número entero"));
                    long factorial = 1;
                    for (int i = 2; i <= n; i++) factorial *= i;
                    gestor.guardarOperacion("Factorial de " + n + " = " + factorial);
                }
                case "10" ->  {
                    int a = Integer.parseInt(JOptionPane.showInputDialog("Primer número"));
                    int b = Integer.parseInt(JOptionPane.showInputDialog("Segundo número"));
                    int resultado = mcd(a, b);
                    gestor.guardarOperacion("MCD de " + a + " y " + b + " = " + resultado);
                }
                case "11" ->  {
                    int a = Integer.parseInt(JOptionPane.showInputDialog("Primer número"));
                    int b = Integer.parseInt(JOptionPane.showInputDialog("Segundo número"));
                    int resultado = (a * b) / mcd(a, b);
                    gestor.guardarOperacion("MCM de " + a + " y " + b + " = " + resultado);
                }
                case "12" ->  {
                    double grados = Double.parseDouble(JOptionPane.showInputDialog("Ingresa los grados"));
                    double radianes = Math.toRadians(grados);
                    gestor.guardarOperacion(grados + " grados = " + radianes + " radianes");
                }
                case "13" ->  {
                    int numero = Integer.parseInt(JOptionPane.showInputDialog("Ingresa un número entero"));
                    boolean esPrimo = true;
                    if (numero < 2) esPrimo = false;
                    for (int i = 2; i <= Math.sqrt(numero); i++) {
                        if (numero % i == 0) {
                            esPrimo = false;
                            break;
                        }
                    }
                    gestor.guardarOperacion("¿" + numero + " es primo? " + esPrimo);
                }
                case "14" -> gestor.leerHistorial();
                case "15" -> gestor.borrarHistorial();
                case "16" -> continuar = false;
                default -> System.out.println("Opción no válida");
            }
        }
    }
    interface Operacion {
        double aplicar(double a, double b);
    }
    public static void operarBinaria(String nombre, Operacion op, GestorArchivos gestor) {
        double a = Double.parseDouble(JOptionPane.showInputDialog("Primer número"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Segundo número"));
        double resultado = op.aplicar(a, b);
        gestor.guardarOperacion(nombre + ": " + a + " y " + b + " = " + resultado);
    }
    public static int mcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}