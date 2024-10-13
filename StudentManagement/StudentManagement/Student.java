package StudentManagement;

public class Student {
    private String name;
    private String ID;
    private double marks;
    private String rank;

    // Constructor
    public Student(String ID, String name, double marks) {
        this.ID = ID;
        this.name = name;
        this.marks = marks;
        this.rank = AssignRank(marks);
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for ID
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    // Getter and Setter for marks
    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
        this.rank = AssignRank(marks); // Update rank when marks change
    }

    // Getter for rank
    public String getRank() {
        return rank;
    }

    // Method to assign rank based on marks
    private String AssignRank(double marks) {
        if (marks < 5.0) {
            return "Fail";
        } else if (marks < 6.5) {
            return "Medium";
        } else if (marks < 7.5) {
            return "Good";
        } else if (marks < 9.0) {
            return "Very Good";
        } else {
            return "Excellent";
        }
    }

    // Override toString method to display student details
    @Override
    public String toString() {
        return "Student ID: " + ID + "\tName: " + name + "\tMarks: " + marks + "\tRank: " + rank;
    }
}
