package be.hogent.giveaday.model;

//import be.hogent.giveaday.model.GroupState.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "groups")
public class Group {

    @Id
    @Column(name = "GroupName")
    private String groupName;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CreationTime")
    private Date timestamp;
    @Column(name = "ClosedGroup")
    private boolean closedGroup;
    @Column(name = "Motivatie")
    private String motivation;
    @Column(name = "CompanyName")
    private String companyName;
    @Column(name = "CompanyAddress")
    private String companyAddress;
    @Column(name = "CompanyWebsite")
    private String companyWebsite;
    @Column(name = "CompanyEmail")
    private String companyEmail;
    @Column(name = "CompanyContactName")
    private String companyContactName;
    @Column(name = "CompanyContactSurname")
    private String companyContactSurname;
    @Column(name = "CompanyContactEmail")
    private String companyContactEmail;
    @Column(name = "CompanyContactTitle")
    private String companyContactTitle;

    @Column(name = "GroupState")
    private int stateType;

    @Column(name = "Feedback")
    private String feedback;




    public int getStateType() {
        return stateType;
    }

    private void setStateType(int stateType) {
        this.stateType = stateType;
    }

    public String getGroupName() {
        return groupName;
    }

    void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getCompanyName() {
        return companyName;
    }

    void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isClosedGroup() {
        return closedGroup;
    }

    void setClosedGroup(boolean closedGroup) {
        this.closedGroup = closedGroup;
    }

    public String getMotivation() {
        return motivation;
    }

    void setMotivation(String motivation) {
        this.motivation = motivation;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyWebsite() {
        return companyWebsite;
    }

    void setCompanyWebsite(String companyWebsite) {
        this.companyWebsite = companyWebsite;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getCompanyContactName() {
        return companyContactName;
    }

    void setCompanyContactName(String companyContactName) {
        this.companyContactName = companyContactName;
    }

    public String getCompanyContactSurname() {
        return companyContactSurname;
    }

    void setCompanyContactSurname(String companyContactSurname) {
        this.companyContactSurname = companyContactSurname;
    }

    public String getCompanyContactEmail() {
        return companyContactEmail;
    }

    void setCompanyContactEmail(String companyContactEmail) {
        this.companyContactEmail = companyContactEmail;
    }

    public String getCompanyContactTitle() {
        return companyContactTitle;
    }

    void setCompanyContactTitle(String companyContactTitle) {
        this.companyContactTitle = companyContactTitle;
    }

    public String getFeedback() {
        return feedback;
    }



    @Override
    public String toString() {
        return "Group [name=" + groupName + "]";
    }



   }
