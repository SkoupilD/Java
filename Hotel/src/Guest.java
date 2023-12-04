import java.time.LocalDate;

public class Guest {
    String name;
    String surname;
    LocalDate dateOfBirth;

    public Guest(String name, String surname, LocalDate dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public String getDescription() {
        return "Guest: " + name + " " + surname + " (" + dateOfBirth.toString()+")";
    }
    public String getFullName(){
        return  name + " " + surname;
    }
}