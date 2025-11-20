package controllers;

import models.Person;

public class SearchMethods {
    

    public Person binarySearchByAge(Person[] persons, int age){
        int bajo = 0;
        int alto = persons.length -1;

        while (bajo <= alto) {
            int medio = bajo + (alto - bajo) / 2;
            int mediobusq = persons[medio].getAge();

            if (mediobusq == age) {
                return persons[medio];
            } else if (mediobusq < age) {
                bajo = medio +1;
            }else{
                alto = medio -1;
            }
        }
        return null;
    }

    public Person binarySearchByName(Person[] persons, String name){
        int izquierda = 0;
        int derecha= persons.length -1 ;

        while (izquierda<= derecha) {
            int medio = izquierda + (derecha - izquierda ) / 2;
            int comparename = persons[medio].getName().compareTo(name);
            if (comparename == 0) {
                return persons[medio];
            } else if (comparename < 0) {
                izquierda = medio +1;
            } else{
                derecha = medio -1;
            }
        }
        return null;
    }

    public boolean isSortedByAge(Person[] persons) {
        for (int i = 0; i < persons.length - 1; i++) {
            if (persons[i].getAge() > persons[i + 1].getAge()) {
                return false;
            }
        }
        return true;
    }

        public boolean isSortedByName(Person[] persons) {
        for (int i = 0; i < persons.length - 1; i++) {
            if (persons[i].getName().compareToIgnoreCase(persons[i + 1].getName()) > 0) {
                return false;
            }
        }
        return true;
    }

}
