package core;

/*
 * Concept: Custom Exception in Java
 * Demonstrates how to create and use custom exceptions.
 *
 * Key Points:
 * - Extend Exception for checked exception
 * - Extend RuntimeException for unchecked exception
 * - Use throw to throw exception
 * - Use throws in method signature for checked exceptions
 *
 * Example:
 *   Input: age = -10
 *   Output: AgeInvalidException thrown and caught
 */
class AgeInvalidException extends Exception {
    public AgeInvalidException(String message) {
        super(message);
    }
}

public class CustomException {
    public static void main(String[] args) {

        int age = -10;
        try {
            validateAge(age);
        } catch (AgeInvalidException exp) {
            System.out.println("Invalid age::" + age);
        }


    }

    private static void validateAge(int age) throws AgeInvalidException {
        if (age < -1) {
            throw new AgeInvalidException("invalid age");
        }
    }
}
