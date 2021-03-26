package model;

import java.util.regex.Pattern;

public class Customer {
    private final String firstName;
    private final String lastName;
    private final String email;
    /**
     *  final - keyword means that the value can’t be modified in the future
     *
     *  RegEx - Regular expressions are used to match or find strings based on a specialized syntax.
     *  The regEx package in Java contains three classes to support these operations:
     *     1. Pattern
     *         ^  start of the line
     *         () catch some input
     *         .  any character
     *         +  one or more character
     *         $  end of the line
     *   2. Matcher
     *   3. PatternSyntaxException.
     *
     * To use RegEx in Java, we have to do two main things:
     *     1. Create a Pattern based on a specialized syntax
     *     2. Use the Matcher to determine if the pattern exists in the String provided
     */

    public Customer(String firstName, String lastName, String email){
        final String emailRegex = "^(.+)@(.+).com$";
        final Pattern pattern =Pattern.compile(emailRegex);
        if (!pattern.matcher(email).matches())
            throw new IllegalArgumentException("Error, Invalid email");
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
