package EncapsulationLab.ValidationData;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setSalary(salary);
    }

    public String getFirstName() {
        return firstName;
    }
    private void validName(boolean name, String text) {
        if (name) {
            throw new IllegalArgumentException(text);
        }
    }

   public void setFirstName(String firstName) {
       validName(firstName.length() < 3, "First name cannot be less than 3 symbols");
       this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        validName(lastName.length() < 3, "Last name cannot be less than 3 symbols");
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        validName(age <= 0, "Age cannot be zero or negative integer");
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        validName(salary < 460, "Salary cannot be less than 460 leva");
        this.salary = salary;
    }

    public void increaseSalary(double percentage) {
        if (this.getAge() < 30) {
            this.setSalary(this.getSalary() + (this.getSalary() * percentage / 200));
        } else {
            this.setSalary(this.getSalary() + (this.getSalary() * percentage / 100));
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %f leva", firstName, lastName, salary);
    }
}
