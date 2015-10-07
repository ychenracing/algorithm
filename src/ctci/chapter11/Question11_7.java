package ctci.chapter11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 叠罗汉
 * @author racing
 * @version $Id: Question11_7.java, v 0.1 Oct 7, 2015 1:02:44 PM racing Exp $
 */
public class Question11_7 {

    static class Person implements Comparable<Person> {
        int height;
        int weight;

        Person(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        public boolean isBefore(Person other) {
            if (this.height < other.height && this.weight < other.weight)
                return true;
            return false;
        }

        @Override
        public int compareTo(Person o) {
            if (this.height != o.height)
                return ((Integer) this.height).compareTo(o.height);
            else
                return ((Integer) this.weight).compareTo(o.weight);
        }

        @Override
        public String toString() {
            return "<" + this.height + "," + this.weight + ">";
        }
    }

    public static void main(String[] args) {
        Person[] persons = new Person[8];
        persons[0] = new Person(65, 100);
        persons[1] = new Person(70, 150);
        persons[2] = new Person(56, 90);
        persons[3] = new Person(75, 190);
        persons[4] = new Person(60, 95);
        persons[5] = new Person(68, 110);
        persons[6] = new Person(30, 200);
        persons[7] = new Person(60, 110);

        ArrayList<Person> array = new ArrayList<Person>(Arrays.asList(persons));
        Collections.sort(array);

        ArrayList<Person>[] solutions = new ArrayList[array.size()];
        getLayers(array, solutions, 0);
        ArrayList<Person> bestSequence = null;
        for (int i = 0; i < persons.length; i++) {
            bestSequence = sequenceWithMaxLength(bestSequence, solutions[i]);
        }

        System.out.println(bestSequence);

    }

    public static void getLayers(ArrayList<Person> persons, ArrayList<Person>[] solutions,
                                 int currentIndex) {
        if (currentIndex >= persons.size() || currentIndex < 0)
            return;
        ArrayList<Person> bestSequence = null;
        for (int i = 0; i < currentIndex; i++) {
            if (persons.get(i).isBefore(persons.get(currentIndex)))
                bestSequence = sequenceWithMaxLength(bestSequence, solutions[i]);
        }

        ArrayList<Person> newSolution = new ArrayList<Person>();
        if (bestSequence != null)
            newSolution.addAll(bestSequence);
        newSolution.add(persons.get(currentIndex));

        solutions[currentIndex] = newSolution;
        getLayers(persons, solutions, currentIndex + 1);
    }

    public static ArrayList<Person> sequenceWithMaxLength(ArrayList<Person> seq1,
                                                          ArrayList<Person> seq2) {
        if (seq1 == null)
            return seq2;
        if (seq2 == null)
            return seq1;
        return seq1.size() > seq2.size() ? seq1 : seq2;
    }
}
