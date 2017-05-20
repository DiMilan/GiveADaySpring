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
    @ManyToOne
    @JoinColumn(name = "GbOrganizationOrgId")
    private GbOrganization gbOrganization;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ExternalOrganizationOrgId")
    private ExternalOrganization externalOrganization;

    @OneToMany(mappedBy = "group", cascade = CascadeType.PERSIST)
    private List<Invitation> invitations;

    @OneToMany(mappedBy = "group", cascade = CascadeType.PERSIST)
    private List<Activity> activities;

    @OneToMany(mappedBy = "group", cascade = CascadeType.PERSIST)
    private List<Task> taskList;

    @OneToMany(mappedBy = "group", cascade = CascadeType.PERSIST)
    private List<History> history;
    //mapping om events op te halen
    @OneToMany(mappedBy = "group", cascade = CascadeType.PERSIST)
    private List<Event> events;


    @Column(name = "Feedback")
    private String feedback;

    public GroupState getGroupState() {
        switch (stateType) {
            case 0:
                return new MotivationOpenState(this);
            case 1:
                return new MotivationSubmittedState(this);
            case 2:
                return new MotivationDeclinedState(this);
            case 3:
                return new MotivationApprovedState(this);
            case 4:
                return new GBLabelAccepted(this);
            case 5:
                return new MotivationApprovedState(this);
            case 6:
                return new EventsApprovedState(this);
            default:
                return null;
        }
    }

    public void setGroupState(GroupState groupState) throws GroupStateException {
        if (groupState.getClass() == MotivationOpenState.class) {
            setStateType(0);
        } else if (groupState.getClass() == MotivationSubmittedState.class) {
            setStateType(1);
        } else if (groupState.getClass() == MotivationDeclinedState.class) {
            setStateType(2);
        } else if (groupState.getClass() == MotivationApprovedState.class) {
            setStateType(3);
        } else if (groupState.getClass() == GBLabelAccepted.class) {
            setStateType(4);
        } else if (groupState.getClass() == MotivationApprovedState.class) {
            setStateType(5);
        } else if (groupState.getClass() == EventsApprovedState.class) {
            setStateType(6);
        } else {
            throw new GroupStateException("Could not map state");
        }
    }

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

    public GbOrganization getGbOrganization() {
        return gbOrganization;
    }

    void setGbOrganization(GbOrganization gbOrganization) {
        this.gbOrganization = gbOrganization;
    }

    public ExternalOrganization getExternalOrganization() {
        return externalOrganization;
    }

    void setExternalOrganization(ExternalOrganization externalOrganization) {
        this.externalOrganization = externalOrganization;
    }

    public List<Invitation> getInvitations() {
        return invitations;
    }

    void setInvitations(List<Invitation> invitations) {
        this.invitations = invitations;
    }

    private List<User> getUsers() {
        return invitations.stream()
                .filter(Invitation::isAccepted)
                .map(Invitation::getUser)
                .collect(Collectors.toList());
    }

    public List<Activity> getActivities() {
        return activities;
    }

    void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    // getter om de history van een groep op te halen
    public List<History> getHistory() {
        return history;
    }
    // getter om events op te halen
    public List<Event> getEvents() {
        return events;
    }
    public List<Task> getTaskList() {
        return taskList;
    }

    void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public String getFeedback() {
        return feedback;
    }

    void setFeedback(FeedbackDecision decision, String feedback) throws Exception {
        if (decision != null) {
            switch (decision) {
                case APPROVED:
                    getGroupState().approve();
                    break;
                case DECLINED:
                    getGroupState().decline();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid decision " + decision);
            }
        }

        this.feedback = feedback;

        //Milan stukje history
        History newHistory = new History();
        newHistory.setGroup(this);
        newHistory.setFeedback(feedback);
        newHistory.setTimestamp(new Date());

        if (decision != null) {
            switch (decision) {
                case APPROVED:
                    newHistory.setDecision(1);
                    break;
                case DECLINED:
                    newHistory.setDecision(0);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid decision " + decision);
            }
        } else {
            newHistory.setDecision(-1);
        }

        String contentString = "Motivation: "+ motivation
                + "\n" + " Events: "  +  events+toString()
                + "\n" + " Activities: "  +  activities+toString();

        newHistory.setContent(contentString);
        history.add(newHistory);
    }

    @Override
    public String toString() {
        return "Group [name=" + groupName + "]";
    }

    public String getDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append("GroupName: ").append(groupName);
        sb.append("\nGroup Members: ");
        if (getUsers().isEmpty()) {
            sb.append("no members assigned");
        } else {
            for (User member : getUsers()) {
                sb.append(member.getUserName()).append(" ");
            }
        }
        sb.append("\nGroup Motivation: ");
        sb.append(motivation);
        sb.append("\nState: ");
        sb.append(getGroupState().getClass().getSimpleName());
        return sb.toString();
    }

    public boolean IsEventListApproved() {
        return this.getGroupState().IsEventListApproved();
    }

    public boolean IsMotivationClosed() {
        return this.getGroupState().IsMotivationClosed();
    }
}
