package be.hogent.giveaday.model;

import java.io.Serializable;

/**
 * Key for invitation (since it is a combination of 2 ids)
 */
class InvitationId implements Serializable {
    private String userId;
    private String groupId;
}
