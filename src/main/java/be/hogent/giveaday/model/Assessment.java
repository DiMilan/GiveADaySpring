package be.hogent.giveaday.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Milan on 18/05/2017.
 */

@Entity
@Table(name = "assessment")
public class Assessment {

    @Id
    @Column(name = "GroupNaam")
    private String groupName;
    @Column(name = "SourceUser")
    private String sourceUser;
    @Column(name = "TargetUser")
    private String targetUser;
    @Column(name = "Comment")
    private String comment;
    @Column(name = "Vraag1")
    private String vraag1;
    @Column(name = "Vraag2")
    private String vraag2;
    @Column(name = "Vraag3")
    private String vraag3;
    @Column(name = "Vraag4")
    private String vraag4;
    @Column(name = "Vraag5")
    private String vraag5;
    @Column(name = "Vraag6")
    private String vraag6;


    // KLasse en datamodel nog aan te passen naar model met vragen maar
    // waar vinden we de vragen?
    // ook kunnen we hiervoor geen typeform gebruiken?

    public String getSourceUser() {
        return sourceUser;
    }
    private void setSourceUser(String sourceUser){ this.sourceUser = sourceUser;}

    public String getTargetUser() {
        return targetUser;
    }
    private void setTargetUser(String targetUser){ this.targetUser = targetUser;}

    public String getComment() {
        return comment;
    }
    private void setComment(String assessmentContent){ this.comment = assessmentContent;}

    public String getVraag1() {return vraag1;}
    private void setVraag1(String vraag1){ this.vraag1 = vraag1;}
    public String getVraag2() {return vraag2;}
    private void setVraag2(String vraag2){ this.vraag2 = vraag2;}
    public String getVraag3() {return vraag3;}
    private void setVraag3(String vraag3){ this.vraag3 = vraag3;}
    public String getVraag4() {return vraag4;}
    private void setVraag4(String vraag4){ this.vraag4 = vraag4;}
    public String getVraag5() {return vraag5;}
    private void setVraag5(String vraag5){ this.vraag5 = vraag5;}
    public String getVraag6() {return vraag6;}
    private void setVraag6(String vraag6){ this.vraag6 = vraag6;}

}
