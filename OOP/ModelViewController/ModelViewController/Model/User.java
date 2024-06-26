package ModelViewController.Model;

public abstract class User {
    protected String fullName;
    protected int birthYear;

    // Abstract class representing a user with basic information like full name and birth year
    // This class follows the Single Responsibility Principle by focusing on user information
    
    // Base class for User with common attributes
    public User(String fullName, int birthYear) {
        this.fullName = fullName;
        this.birthYear = birthYear;
    }

    // Getters and setters for fullName and birthYear
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    // Override toString method to display user information
    @Override
    public String toString() {
        return " Name: " + fullName + "(" + birthYear + " year)";
    }
}