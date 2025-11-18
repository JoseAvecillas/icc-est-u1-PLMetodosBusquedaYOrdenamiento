package controllers;

import models.Person;

public class SortingMethods {
    
    public void sortByNameWithBubble(Person[] people) {
        boolean swapped;
        for (int i = 0; i < people.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < people.length - 1 - i; j++) {
                if (people[j].getName().compareToIgnoreCase(people[j + 1].getName()) > 0) {
                    Person temp = people[j];
                    people[j] = people[j + 1];
                    people[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public void sortByNameWithSelectionDes(Person[] people) {
        for (int i = 0; i < people.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < people.length; j++) {
                if (people[j].getName().compareToIgnoreCase(people[minIndex].getName()) < 0) {
                    minIndex = j;
                }
            }
            Person temp = people[i];
            people[i] = people[minIndex];
            people[minIndex] = temp;
        }
    }

    public void sortByNameWithInsertion(Person[] people) {
        for (int i = 1; i < people.length; i++) {
            Person key = people[i];
            int j = i - 1;
            while (j >= 0 && people[j].getName().compareToIgnoreCase(key.getName()) > 0) {
                people[j + 1] = people[j];
                j--;
            }
            people[j + 1] = key;
        }
    }

    public void sortByAgeWithInsertion(Person[] people) {
        for (int i = 1; i < people.length; i++) {
            Person key = people[i];
            int j = i - 1;
            while (j >= 0 && people[j].getAge() > key.getAge()) {
                people[j + 1] = people[j];
                j--;
            }
            people[j + 1] = key;
        }
    }

}
