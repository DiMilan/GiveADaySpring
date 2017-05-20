package be.hogent.giveaday.model;

import javax.persistence.*;

@Entity
@Table(name = "user_groups")
public class Invitation {

    @Id
    @Column(name = "UserId")
    private String userId;
    @Id
    @Column(name = "GroupId")
    private String groupId;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "UserId", referencedColumnName = "user_id")
    private User user;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "GroupId", referencedColumnName = "GroupName")
    private Group group;


    public Invitation() {
    }

    public User getUser() {
        return user;
    }

    public Group getGroup() {
        return group;
    }


}
