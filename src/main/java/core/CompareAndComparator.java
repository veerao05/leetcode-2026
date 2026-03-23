package core;

/*
 * Concept: Comparable vs Comparator in Java
 * Demonstrates two ways to sort custom objects.
 *
 * Comparable (Natural Ordering):
 * - Implemented by the class itself
 * - Provides single default sorting logic
 * - Uses compareTo() method
 *
 * Comparator (Custom Ordering):
 * - External class implements sorting logic
 * - Allows multiple sorting strategies
 * - Uses compare() method
 *
 * Example:
 *   Movie sorted by year (Comparable) and by name (Comparator)
 */
import javax.xml.namespace.QName;
import java.util.*;

class Movie implements Comparable<Movie> {
    String name;
    int rating;
    int year;

    public Movie(String name, int rating, int year) {
        this.name = name;
        this.rating = rating;
        this.year = year;
    }

    @Override
    public int compareTo(Movie m) {
        return this.year - m.year;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public int getYear() {
        return year;
    }
}

class NameComparator implements Comparator<Movie> {

    @Override
    public int compare(Movie m1, Movie m2) {
        return m1.name.compareTo(m2.name);
    }
}

class YearComparator implements Comparator<Movie> {

    @Override
    public int compare(Movie m1, Movie m2) {
        if (m1.getRating() < m2.getRating())
            return -1;
        else if (m1.getRating() > m2.getRating())
            return 1;
        else return 0;

    }
}

public class CompareAndComparator {
    public static void main(String[] args) {
        List<Movie> list = new ArrayList<>();
        Movie movie1 = new Movie("Kgf", 7, 2021);
        Movie movie2 = new Movie("Kantara", 8, 2022);
        Movie movie3 = new Movie("Bahubali", 9, 2018);
        Movie movie4 = new Movie("Dhurandhar", 9, 2026);
        Movie movie5 = new Movie("Kerala Files", 10, 2024);
        list.add(movie1);
        list.add(movie2);
        list.add(movie3);
        list.add(movie4);
        list.add(movie5);
        Collections.sort(list);
        System.out.println("After sorting::");
        for (Movie movie : list) {
            System.out.println(movie.name + "  " + movie.rating + "  " + movie.year + "\n");
        }

        NameComparator nameComparator = new NameComparator();
        System.out.println("Sort by name::");
        Collections.sort(list,nameComparator);
        for (Movie movie : list) {
            System.out.println(movie.name + "  " + movie.rating + "  " + movie.year + "\n");
        }

    }
}
