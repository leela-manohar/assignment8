package assingment8;
import java.util.ArrayList;
import java.util.List;

class Project {
    private String name;
    private int daysTaken;

    public Project(String name, int daysTaken) {
        this.name = name;
        this.daysTaken = daysTaken;
    }

    public int getDaysTaken() {
        return daysTaken;
    }
}

class Student {
    private String name;
    private List<Project> projects;

    public Student(String name) {
        this.name = name;
        this.projects = new ArrayList<>();
    }

    public void addProject(Project project) {
        projects.add(project);
    }

    public List<Project> getProjects() {
        return projects;
    }

    public String getName() {
        return name;
    }
}

public class ProjectTracker {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        // Sample data
        Student student1 = new Student("Alice");
        student1.addProject(new Project("Project1", 10));
        student1.addProject(new Project("Project2", 8));
        students.add(student1);

        Student student2 = new Student("Bob");
        student2.addProject(new Project("Project3", 15));
        student2.addProject(new Project("Project4", 12));
        students.add(student2);

        // Calculate and display statistics
        for (Student student : students) {
            int onTime = 0, late = 0, early = 0;
            int totalDays = 0;
            List<Project> projects = student.getProjects();

            for (Project project : projects) {
                int daysTaken = project.getDaysTaken();
                totalDays += daysTaken;
                if (daysTaken <= 10) {
                    onTime++;
                } else if (daysTaken > 10) {
                    late++;
                } else {
                    early++;
                }
            }

            double averageDays = totalDays / (double) projects.size();

            System.out.println("Student: " + student.getName());
            System.out.println("Projects completed on time: " + onTime);
            System.out.println("Projects completed late: " + late);
            System.out.println("Projects completed early: " + early);
            System.out.println("Average time taken for projects: " + averageDays + " days");
            System.out.println();
        }
    }
}
