package core;

/*
 * Concept: Shallow Copy vs Deep Copy in Java
 * Demonstrates the difference between shallow and deep cloning.
 *
 * Shallow Copy: Copies references, both objects share same nested objects
 * Deep Copy: Creates new instances of nested objects
 *
 * This example implements DEEP COPY:
 * - Student.clone() creates new Student AND new Course
 * - Changing s2.course doesn't affect s1.course
 *
 * Key Points:
 * - Implement Cloneable interface
 * - Override clone() method
 * - For deep copy, clone nested objects too
 */
class Course implements Cloneable {
    String course1;
    String course2;
    String course3;

    public Course(String course1, String course2, String course3) {
        this.course1 = course1;
        this.course2 = course2;
        this.course3 = course3;
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();

    }
}

class Student implements Cloneable {
    int id;
    String name;
    Course course;

    public Student(int id, String name, Course course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    protected Object clone() throws CloneNotSupportedException {
        Student student = (Student) super.clone();
        student.course = (Course) course.clone();
        return student;

    }
    /*protected Object clone() throws CloneNotSupportedException{
        return super.clone();

    }*/
}

public class ShallowDeepCopy {
    public static void main(String[] args) {
        Course c1 = new Course("English", "Kannada", "Hindi");
        Student s1 = new Student(1, "vna", c1);
        Student s2 = null;
        System.out.println("Student1 Course1 before clone::" + s1.course.course1);
        try {
            s2 = (Student) s1.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        s2.course.course1 = "science";
        System.out.println("Student1 Course1 after clone::" + s1.course.course1);
        System.out.println("Student2 Course1 after clone::" + s2.course.course1);
    }
}
