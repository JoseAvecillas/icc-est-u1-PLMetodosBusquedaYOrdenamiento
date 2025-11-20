package view;

import java.util.Scanner;
import models.Person;

public class View {

    private Scanner scanner = new Scanner(System.in);

    public int showMenu() {
        System.out.println("===== MENU =====");
        System.out.println("1. Ingresar personas");
        System.out.println("2. Mostrar personas");
        System.out.println("3. Ordenar personas");
        System.out.println("4. Buscar personas");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public Person inputPerson() {
        scanner.nextLine(); // limpiar
        System.out.print("Ingrese nombre: ");
        String name = scanner.nextLine();
        System.out.print("Ingrese edad: ");
        int age = scanner.nextInt();
        return new Person(name, age);
    }

    public int inputAge() {
        System.out.print("Ingrese la edad a buscar: ");
        return scanner.nextInt();
    }

    public String inputName() {
        scanner.nextLine();
        System.out.print("Ingrese el nombre a buscar: ");
        return scanner.nextLine();
    }

    public int selectSortingMethod() {
        System.out.println("==== MÉTODOS DE ORDENAMIENTO ====");
        System.out.println("1. Burbuja por nombre");
        System.out.println("2. Selección descendente por nombre");
        System.out.println("3. Inserción por edad");
        System.out.println("4. Inserción por nombre");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public int selectSearchCriterion() {
        System.out.println("==== CRITERIO DE BÚSQUEDA ====");
        System.out.println("1. Por edad (Binary Search)");
        System.out.println("2. Por nombre (Binary Search)");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public void displayPersons(Person[] persons) {
        System.out.println("===== LISTA DE PERSONAS =====");
        for (Person p : persons) {
            System.out.println(p);
        }
    }

    public void displaySearchResult(Person p) {
        if (p == null) {
            System.out.println("No se encontró la persona.");
        } else {
            System.out.println("Persona encontrada: " + p);
        }
    }
}