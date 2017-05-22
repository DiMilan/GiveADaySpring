package be.hogent.giveaday.model;

import javax.persistence.*;

@Entity
@Table(name = "user_groups")
public class Invitation {

    @EmbeddedId
    InvitationId id;

    @ManyToOne
    @JoinColumn(name = "UserId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "GroupId")
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
