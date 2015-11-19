public class Student {
    /*By making the student class separate from the societyMembers it will be easy to add other fields such as GPA and other student information */
    String name, studentNumber, email, majors;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public Student(String name, String studentNumber, String email) {

        this.name = name;
        this.studentNumber = studentNumber;
        this.email = email;
    }
}
