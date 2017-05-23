package be.hogent.giveaday.model;

import javax.persistence.*;

/**
 * Created by Milan on 18/05/2017.
 */

@Entity
@Table(name = "assessment")
public class Assessment {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name="id")
    private int id;

//    @Column(name = "GroupNaam")
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "GroupName", referencedColumnName = "GroupName")
    private Group groupName;

//    @Column(name = "SourceUser")
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="SourceUser", referencedColumnName = "user_id")
    private User sourceUser;

//    @Column(name = "TargetUser")
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="TargetUser", referencedColumnName = "user_id")
    private User targetUser;

    @Column(name = "Comment")
    private String comment;
    @Column(name = "Vraag1")
    private Integer vraag1;
    @Column(name = "Vraag2")
    private Integer vraag2;
    @Column(name = "Vraag3")
    private Integer vraag3;
    @Column(name = "Vraag4")
    private Integer vraag4;
    @Column(name = "Vraag5")
    private Integer vraag5;
    @Column(name = "Vraag6")
    private Integer vraag6;


    public Group getGroupName(){return groupName;}
    private void setGroupName(Group groupName){this.groupName = groupName;}

    public User getSourceUser() {
        return sourceUser;
    }
    public void setSourceUser(User sourceUser){ this.sourceUser = sourceUser;}

    public User getTargetUser() {
        return targetUser;
    }
    public void setTargetUser(User targetUser){ this.targetUser = targetUser;}

    public String getComment() {
        return comment;
    }
    public void setComment(String assessmentContent){ this.comment = assessmentContent;}

    public Integer getVraag1() {return vraag1;}
    public void setVraag1(Integer vraag1){ this.vraag1 = vraag1;}
    public Integer getVraag2() {return vraag2;}
    public void setVraag2(Integer vraag2){ this.vraag2 = vraag2;}
    public Integer getVraag3() {return vraag3;}
    public void setVraag3(Integer vraag3){ this.vraag3 = vraag3;}
    public Integer getVraag4() {return vraag4;}
    public void setVraag4(Integer vraag4){ this.vraag4 = vraag4;}
    public Integer getVraag5() {return vraag5;}
    public void setVraag5(Integer vraag5){ this.vraag5 = vraag5;}
    public Integer getVraag6() {return vraag6;}
    public void setVraag6(Integer vraag6){ this.vraag6 = vraag6;}

    public void setGroup(Group group) {
        this.groupName = group;
    }
}
