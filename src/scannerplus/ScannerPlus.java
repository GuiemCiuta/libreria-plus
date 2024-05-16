package scannerplus;

import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Predicate;

public class ScannerPlus {
    // Fuerza al usuario a escribir un int
    public static int getInt(Scanner sc, String mensajeError) {
        int resultado;

        while (true) {
            try {
                resultado = sc.nextInt();
                // Para comernos el intro final
                sc.nextLine();

                return resultado;

            } catch (Exception e) {
                System.out.println(mensajeError);
                sc.nextLine();

            }
        }
    }

    public static int getInt(Scanner sc) {
        String mensajePorDefecto = "El valor introducido no es un número...";
        return ScannerPlus.getInt(sc, mensajePorDefecto);
    }

    // Fuerza al usuario a escribir un número que cumpla una condición
    public static int getInt(Scanner sc, Predicate<Integer> predicate, String mensajeError) {
        Integer resultado = ScannerPlus.getInt(sc);

        while (!predicate.test(resultado)) {
            System.out.println(mensajeError);
            resultado = ScannerPlus.getInt(sc);
        }

        return resultado;
    }

    // Fuerza al usuario a escribir un número que cumpla una condición
    public static int getInt(Scanner sc, Predicate<Integer> predicate) {
        return ScannerPlus.getInt(sc, predicate, "Número incorrecto");
    }

    // Fuerza al usuario a escribir un double
    public static double getDouble(Scanner sc, String mensajeError) {
        double resultado;

        while (true) {
            try {
                resultado = sc.nextDouble();
                // Para comernos el intro final
                sc.nextLine();

                return resultado;

            } catch (Exception e) {
                System.out.println(mensajeError);
                sc.nextLine();

            }
        }
    }

    public static double getDouble(Scanner sc) {
        String mensajePorDefecto = "El valor introducido no es un número...";
        return ScannerPlus.getDouble(sc, mensajePorDefecto);
    }

    // Fuerza al usuario a escribir un número que cumpla una condición
    public static double getDouble(Scanner sc, Predicate<Double> predicate, String mensajeError) {
        Double resultado = ScannerPlus.getDouble(sc);

        while (!predicate.test(resultado)) {
            System.out.println(mensajeError);
            resultado = ScannerPlus.getDouble(sc);
        }

        return resultado;
    }

    // Fuerza al usuario a escribir un número que cumpla una condición
    public static double getDouble(Scanner sc, Predicate<Double> predicate) {
        return ScannerPlus.getDouble(sc, predicate, "Número incorrecto");
    }

    // Fuerza al usuario a escribir una cadena que cumpla una condición
    public static String getString(Scanner sc, Predicate<String> predicate, String mensajeError) {
        String resultado = sc.nextLine();

        while (!predicate.test(resultado)) {
            System.out.println(mensajeError);
            resultado = sc.nextLine();
        }

        return resultado;
    }

    // Fuerza al usuario a escribir una cadena que cumpla una condición
    public static String getString(Scanner sc, Predicate<String> predicate) {
        return ScannerPlus.getString(sc, predicate, "Cadena incorrecta");
    }

    // Convierte una entrada humana del usuario en un booleano
    // Valores soportados: si, sí, s, y, yes | no, n
    public static boolean pedirConfirmacion(Scanner sc, String mensaje) {
        String inputUsuario;
        // Para identificar qué nos quiere decir el usuario con cada input, para pedir
        // confirmaciones
        // El problema es que se repite el proceso cada vez que se llama al método
        HashMap<String, Boolean> respuestasBooleanas = new HashMap<>();

        // Respuestas positivas
        respuestasBooleanas.put("si", true);
        respuestasBooleanas.put("sí", true);
        respuestasBooleanas.put("s", true);
        respuestasBooleanas.put("y", true);
        respuestasBooleanas.put("yes", true);

        // Respuestas negativas
        respuestasBooleanas.put("no", false);
        respuestasBooleanas.put("n", false);

        System.out.println(mensaje);
        inputUsuario = sc.nextLine();
        inputUsuario = inputUsuario.toLowerCase();

        while (respuestasBooleanas.get(inputUsuario) == null) {
            System.out.println("No es una respuesta válida, escribe si o no. Vuelve a probarlo...");
            inputUsuario = sc.nextLine();
            inputUsuario = inputUsuario.toLowerCase();
        }

        return respuestasBooleanas.get(inputUsuario);

    }
}
