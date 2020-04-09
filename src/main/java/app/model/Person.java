package app.model;



import java.util.Date;



public class Person {
    private int personId;
    private String fullName;
    private String role;
    private String bio;
    private Date birthdate;
    private Image photo;




    public Person(int personId, String fullName, String role, Date birthDate, String bio) {
        this.personId = personId;
        this.fullName = fullName;
        this.role = role;
        this.birthdate = birthDate;
        this.bio = bio;
        this.photo = new Image(personId, true);
    }



    public String getRole() {
        return role;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public String getFullName() {
        return fullName;
    }

    public int getPersonId() {
        return personId;
    }

    public String getBio() {
        return bio;
    }

    public Image getPhoto() {
    	return photo;
    }
}