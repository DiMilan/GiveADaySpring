package be.hogent.giveaday.model;

import javax.persistence.*;

/**
 * Created by Milan on 18/05/2017.
 */

@Entity
@Table(name = "assessment")
public class Assessment {

    @Id
    @Column(name="id")
    private int id;

    @Column(name = "GroupNaam")
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "GroupNaam", referencedColumnName = "GroupName")
    private Group groupName;

    @Column(name = "SourceUser")
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="SourceUser", referencedColumnName = "user_id")
    private User sourceUser;

    @Column(name = "TargetUser")
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="TargetUser", referencedColumnName = "user_id")
    private User targetUser;

    @Column(name = "Comment")
    private String comment;
    @Column(name = "Vraag1")
    private int vraag1;
    @Column(name = "Vraag2")
    private int vraag2;
    @Column(name = "Vraag3")
    private int vraag3;
    @Column(name = "Vraag4")
    private int vraag4;
    @Column(name = "Vraag5")
    private int vraag5;
    @Column(name = "Vraag6")
    private int vraag6;

    public User getSourceUser() {
        return sourceUser;
    }
    private void setSourceUser(User sourceUser){ this.sourceUser = sourceUser;}

    public User getTargetUser() {
        return targetUser;
    }
    private void setTargetUser(User targetUser){ this.targetUser = targetUser;}

    public String getComment() {
        return comment;
    }
    private void setComment(String assessmentContent){ this.comment = assessmentContent;}

    public int getVraag1() {return vraag1;}
    private void setVraag1(int vraag1){ this.vraag1 = vraag1;}
    public int getVraag2() {return vraag2;}
    private void setVraag2(int vraag2){ this.vraag2 = vraag2;}
    public int getVraag3() {return vraag3;}
    private void setVraag3(int vraag3){ this.vraag3 = vraag3;}
    public int getVraag4() {return vraag4;}
    private void setVraag4(int vraag4){ this.vraag4 = vraag4;}
    public int getVraag5() {return vraag5;}
    private void setVraag5(int vraag5){ this.vraag5 = vraag5;}
    public int getVraag6() {return vraag6;}
    private void setVraag6(int vraag6){ this.vraag6 = vraag6;}

}
