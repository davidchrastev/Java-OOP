package WorkingWithAbstractionLab.StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> repo;

    public StudentSystem() {
        this.repo = new HashMap<>();
    }

    public Map<String, Student> getRepo() {
        return this.repo;
    }

    public void parseCommand(String[] data) {
        String firstArgument = data[0];
        String name = data[1];

        if (firstArgument.equals("Create")) {
            int age = Integer.parseInt(data[2]);
            double grade = Double.parseDouble(data[3]);
            if (!repo.containsKey(name)) {
                Student student = new Student(name, age, grade);
                repo.put(name, student);
            }
        } else if (firstArgument.equals("Show")) {
            if (repo.containsKey(name)) {
                Student student = repo.get(name);
                StringBuilder toPrint = new StringBuilder();
                toPrint.append(String.format("%s is %s years old.", student.getName(), student.getAge()));

                if (student.getGrade() >= 5.00) {
                    toPrint.append(" Excellent student.");
                } else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
                    toPrint.append(" Average student.");
                } else {
                    toPrint.append(" Very nice person.");
                }

                System.out.println(toPrint.toString());
            }
        }
    }
}
