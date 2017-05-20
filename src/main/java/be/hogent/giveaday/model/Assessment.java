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
    @Column(name = "Group")
    private String groupName;
    @Column(name = "SourceUser")
    private String sourceUser;
    @Column(name = "TargetUser")
    private String targetUser;
    @Column(name = "Assessment")
    private String assessmentContent;

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

    public String getAssessmentContent() {
        return assessmentContent;
    }
    private void setAssessmentContent(String assessmentContent){ this.assessmentContent = assessmentContent;}


}
