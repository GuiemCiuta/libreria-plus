package menuplus;

import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.function.Consumer;

// Esta clase me la hice para el ejercicio de recetas
// Es una forma de crear un menú más rápidamente

public class MenuPlus {
    private LinkedHashMap<String, Consumer<Scanner>> opciones;
    private Scanner sc;
    private String titulo;

    public MenuPlus(String titulo, LinkedHashMap<String, Consumer<Scanner>> opciones, Scanner sc) {
        this.sc = sc;
        this.titulo = titulo;
        this.opciones = opciones;

        this.clearScreen();
        this.ejecutarMenu();
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void volverAlMenu() {
        try {
            sc.nextLine();
            this.clearScreen();
            this.ejecutarMenu();
        } catch (NoSuchElementException e) {
            System.out.println(e);
        }
    }

    private void finEjecucionOpcion() {
        System.out.println("Pulsa cualquier tecla para volver al menú...");
        this.volverAlMenu();
    }

    private void dibujarMenu() {
        System.out.println(this.titulo);

        // Mostramos cada título (la clave) de cada opción
        for (int i = 0; i < opciones.size(); i++) {
            String titulo = opciones.keySet().toArray(String[]::new)[i];
            System.out.println((i + 1) + ". " + titulo);
        }
    }

    private int obtenerOpcionMenu() {

        int respuestaInt = -1;

        // Usamos un bucle while para forzar al usuario a escribir un número de opción
        // que exista
        while (true) {
            try {

                // Siempre me gusta usar nextLine, porque no saltan errores nunca
                // Prefiero validarlo por mi cuenta y invocar el error yo solo
                String respuesta = this.sc.nextLine();

                respuestaInt = Integer.parseInt(respuesta);

                // Comprobamos que la opción elegida exista
                if (respuestaInt < 1 || respuestaInt > this.opciones.size()) {
                    throw new Exception();
                }

                break;

            } catch (NumberFormatException e) {
                System.out.println("Lo introducido no parece un número. Por favor, vuelve a intentarlo...");

            } catch (Exception e) {
                System.out.println(
                        "Esta opción no está disponible. Por favor, vuelve a probarlo poniendo un número del "
                                + 1 + " al " + this.opciones.size() + "...");

            }
        }

        // Cuando llegue aquí, ya tendrá la respuesta introducida por el usuario
        return respuestaInt;
    }

    private Consumer<Scanner> obtenerOpcion(int opcionMenu) {
        Consumer<Scanner> resultado = null;

        int contador = 0;
        for (Consumer<Scanner> consumer : this.opciones.values()) {
            if (contador == opcionMenu - 1) {
                return consumer;
            }

            contador++;
        }

        return resultado;
    }

    private void ejecutarOpcionMenu(int opcionMenu) {
        this.clearScreen();

        Consumer<Scanner> consumer = this.obtenerOpcion(opcionMenu);

        if (consumer != null) {
            consumer.accept(sc);
        } else {
            System.out.println("No existe la opción");
        }

        this.finEjecucionOpcion();
    }

    private void ejecutarMenu() {
        this.dibujarMenu();
        int opcionMenu = obtenerOpcionMenu();
        this.ejecutarOpcionMenu(opcionMenu);
    }
}
