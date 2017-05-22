package be.hogent.giveaday.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Key for invitation (since it is a combination of 2 ids)
 */
@Embeddable
class InvitationId implements Serializable {
    private String userId;
    private String groupId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InvitationId that = (InvitationId) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        return groupId != null ? groupId.equals(that.groupId) : that.groupId == null;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (groupId != null ? groupId.hashCode() : 0);
        return result;
    }
}
