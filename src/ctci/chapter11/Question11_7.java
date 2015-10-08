package ctci.chapter11;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 叠罗汉 & 最长递增子序列
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
        //        ArrayList<Person> array = new ArrayList<Person>();
        //        array.add(new Person(65, 100));
        //        array.add(new Person(70, 150));
        //        array.add(new Person(56, 90));
        //        array.add(new Person(75, 190));
        //        array.add(new Person(60, 95));
        //        array.add(new Person(68, 110));
        //        array.add(new Person(30, 200));
        //        array.add(new Person(60, 110));
        //        Collections.sort(array);
        //
        //        ArrayList<Person>[] solutions = new ArrayList[array.size()];
        //        getLayers(array, solutions, 0);
        //        ArrayList<Person> bestSequence = null;
        //        for (int i = 0; i < array.size(); i++) {
        //            bestSequence = sequenceWithMaxLength(bestSequence, solutions[i]);
        //        }
        //
        //        System.out.println(bestSequence);

        int[] nums = { 5, 6, 7, 1, 2, 8 };
        int[][] result = new int[nums.length][];
        getMaxSubSequence(nums, result, 0);
        int[] maxLength = new int[0];
        for (int[] array : result) {
            maxLength = maxLength.length > array.length ? maxLength : array;
        }
        System.out.println(Arrays.toString(maxLength));

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

    public static void getMaxSubSequence(int[] nums, int[][] result, int currentIndex) {
        if (currentIndex >= nums.length)
            return;
        int[] preMax = new int[0];
        for (int i = 0; i < currentIndex; i++) {
            if (nums[i] < nums[currentIndex])
                preMax = preMax.length > result[i].length ? preMax : result[i];
        }

        int[] newMax = new int[preMax.length + 1];
        System.arraycopy(preMax, 0, newMax, 0, preMax.length);
        newMax[newMax.length - 1] = nums[currentIndex];
        result[currentIndex] = newMax;

        getMaxSubSequence(nums, result, currentIndex + 1);
    }
}
