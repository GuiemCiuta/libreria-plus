import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.function.Consumer;

import menuplus.MenuPlus;
import scannerplus.ScannerPlus;

public class Test {
    public static void main(String[] args) {
        LinkedHashMap<String, Consumer<Scanner>> opciones = new LinkedHashMap<>();
        List<String> strings = new ArrayList<>();

        opciones.put("Saludar", e -> System.out.println("Hola"));
        opciones.put("Añadir string", e -> strings.add("Adios"));
        opciones.put("Mostrar strings", e -> strings.stream().forEach(System.out::println));

        MenuPlus menuPlus = new MenuPlus("Menu de prueba", opciones, new Scanner(System.in));

    }
}
