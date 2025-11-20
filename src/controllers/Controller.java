package controllers;

import models.Person;
import view.View;

public class Controller {

    private View view;
    private Person[] persons;
    private SortingMethods sortingMethods;
    private SearchMethods searchMethods;

    public Controller(View view, SortingMethods sortingMethods, SearchMethods searchMethods) {
        this.view = view;
        this.sortingMethods = sortingMethods;
        this.searchMethods = searchMethods;
        this.persons = new Person[0];
    }

    public void start() {
        int option;

        do {
            option = view.showMenu();

            switch (option) {
                case 1 -> inputPersons();
                case 2 -> view.displayPersons(persons);
                case 3 -> sortPersons();
                case 4 -> searchPerson();
                case 5 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción incorrecta");
            }

        } while (option != 5);
    }

    public void inputPersons() {
        System.out.print("¿Cuántas personas desea ingresar?: ");
        int n = new java.util.Scanner(System.in).nextInt();

        persons = new Person[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Persona " + (i + 1));
            persons[i] = view.inputPerson();
        }
    }

    public void sortPersons() {
        int method = view.selectSortingMethod();

        switch (method) {
            case 1 -> sortingMethods.sortByNameWithBubble(persons);
            case 2 -> sortingMethods.sortByNameWithSelectionDes(persons);
            case 3 -> sortingMethods.sortByAgeWithInsertion(persons);
            case 4 -> sortingMethods.sortByNameWithInsertion(persons);
            default -> System.out.println("Método no válido");
        }

        System.out.println("Personas ordenadas.");
    }

    public void searchPerson() {
        int criterion = view.selectSearchCriterion();
        Person result = null;

        switch (criterion) {
            case 1 -> {
                int age = view.inputAge();
                if (!searchMethods.isSortedByAge(persons)) {
                    System.out.println("El arreglo no está ordenado por edad.");
                    return;
                }
                result = searchMethods.binarySearchByAge(persons, age);
            }
            case 2 -> {
                String name = view.inputName();
                if (!searchMethods.isSortedByName(persons)) {
                    System.out.println("El arreglo no está ordenado por nombre.");
                    return;
                }
                result = searchMethods.binarySearchByName(persons, name);
            }
            default -> System.out.println("Opción inválida.");
        }

        view.displaySearchResult(result);
    }
}