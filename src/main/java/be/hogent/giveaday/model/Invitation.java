package be.hogent.giveaday.model;

import javax.persistence.*;

@Entity
@Table(name = "user_groups")
@IdClass(InvitationId.class)
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

    @Column(name = "Status")
    private InvitationStatus status;

    public Invitation() {
    }

    public User getUser() {
        return user;
    }

    public Group getGroup() {
        return group;
    }

    public InvitationStatus getStatus() {
        return status;
    }

    boolean isPending() {
        return InvitationStatus.PENDING.equals(status);
    }

    boolean isAccepted() {
        return InvitationStatus.ACCEPTED.equals(status);
    }

    boolean isDeclined() {
        return InvitationStatus.DECLINED.equals(status);
    }
}
