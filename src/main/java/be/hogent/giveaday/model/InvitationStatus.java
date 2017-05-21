/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.hogent.giveaday.model;

/**
 *
 * @author bart
 */
public enum InvitationStatus {
    PENDING(0), ACCEPTED(1), DECLINED(2);

    private final int id;

    InvitationStatus(int id) {
        this.id = id;
    }

    public int getValue() {
        return id;
    }
}
