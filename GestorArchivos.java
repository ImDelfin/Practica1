import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class GestorArchivos {
    public GestorArchivos(String historialtxt) {
    }
    private static final String NOMBRE_ARCHIVO = "historial_calculadora.txt";
    public static void guardarOperacion(String operacion) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO, true))) {
            writer.write(operacion);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar la operación: " + e.getMessage());
        }
    }
    public static List<String> leerHistorial() {
        List<String> historial = new ArrayList<>();
        File archivo = new File(NOMBRE_ARCHIVO);
        if (!archivo.exists()) {
            System.out.println("No hay historial registrado.");
            return historial;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(NOMBRE_ARCHIVO))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                historial.add(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el historial: " + e.getMessage());
        }
        return historial;
    }
    public static void borrarHistorial() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(NOMBRE_ARCHIVO))) {
            writer.print("");
            System.out.println("Historial borrado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al borrar el historial: " + e.getMessage());
        }
    }
}