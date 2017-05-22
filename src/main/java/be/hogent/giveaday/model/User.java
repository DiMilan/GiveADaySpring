package be.hogent.giveaday.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
        @NamedQuery(name = "User.findByName", query = "SELECT u FROM User u WHERE u.username = :name")
})
public class User {

    @Id
    @Column(name = "user_id")
    private String id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "username")
    private String username;
    @Column(name = "family_name")
    private String familyName;

    @Column(name = "PasswordHash")
    private String passwordHash;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Invitation> invitations;
    //@ManyToOne
    //@JoinColumn(name = "OrganizationOrgId")
    //private GbOrganization organization;
    @ManyToOne
    @JoinColumn(name = "LectorUserId")
    private User lectorUser;
    @OneToMany(mappedBy = "lectorUser")
    private List<User> students;

    @OneToMany(mappedBy = "sourceUser")
    private List<Assessment> assessments;

    //constructor because hibernate
    public User() {
    }

    //@ManyToMany(mappedBy = "users")
    //@JoinTable(name = "ActivityTaskUser")
    //@JoinColumn(name = "Id")
    //private List<Task> tasks;

    public String getId() {
        return id;
    }

    public String getUserName() {
        return this.username;
    }

    public Group getGroup() {
        return invitations.stream()
               .filter(Invitation::isAccepted)
                .map(Invitation::getGroup)
                .findFirst()
                .orElse(null);
    }

    //public GbOrganization getOrganization() {
    //    return organization;
    //}

    String getPasswordHash() {
        return passwordHash;
    }

    List<User> getStudents() {
        return students;
    }

    public String getName() {
        return String.format("%s %s", firstName, familyName);
    }

    public User(String firstName, String familyName) {
        this.firstName = firstName;
        this.familyName = familyName;
    }


    public List<Assessment> getAssessments() {
        return assessments;
    }

    public void addAssessments(Assessment assessment){

        assessment.setSourceUser(this);
        assessments.add(assessment);

    }


}
