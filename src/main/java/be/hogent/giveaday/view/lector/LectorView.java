package be.hogent.giveaday.view.lector;


import be.hogent.giveaday.component.ScoreLabel;
import be.hogent.giveaday.model.Assessment;
import be.hogent.giveaday.model.DomainController;
import be.hogent.giveaday.model.Group;
import be.hogent.giveaday.model.User;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

//import org.springframework.security.core.userdetails.User;


@SpringView(name = LectorView.VIEW_NAME)
public class LectorView extends VerticalLayout implements View {

    public static final String VIEW_NAME = "lector";


    @Autowired
    private DomainController domainController;


    @PostConstruct
    private void init() {
        // Init UI here

        setWidth(100, Unit.PERCENTAGE);
        setSpacing(true);
        User currentUser = domainController.getCurrentUser();
        List<User> studenten = currentUser.getStudents();
        Set<Group> lectorGroups = studenten.stream().map(user -> user.getGroup()).distinct().filter(group -> group != null).collect(Collectors.toSet());


        Button cancel = new Button("Cancel");
        HorizontalLayout actions = new HorizontalLayout(cancel);

        VerticalLayout layout = new VerticalLayout();

        if (lectorGroups.size() == 0) {
            addComponent(new Label ("No groups found!"));
        }
        else {

            for (Group lectorGroup : lectorGroups) {
                Set<List<Assessment>> currentAssessments = lectorGroup.getUsers().stream().map(user -> user.getAssessments()).collect(Collectors.toSet());
                Set<Assessment> currentAssessmentsFlat = currentAssessments.stream().flatMap(List::stream).collect(Collectors.toSet());
                Set<User> currentUsers = lectorGroup.getUsers().stream().collect(Collectors.toSet());

                //System.out.println(Arrays.toString(lectorGroups.toArray()));

                addComponent(new Label(lectorGroup.getGroupName()));

                for(User assessedUser : currentUsers) {
                    Set<Assessment> currentUserAssessments = currentAssessmentsFlat.stream()
                            .filter(assessment -> assessment.getTargetUser() == assessedUser)
                            .filter(assessment -> assessment != null).collect(Collectors.toSet());
                    if (currentUserAssessments.size() == 0) {
                        //System.out.println("No assessments for this user");
                        //System.out.println(assessedUser.getGroup().toString());
                        addComponent(new ScoreLabel(assessedUser.getName()+": No assessments yet."));
                    } else {
                        Double g1Score = currentUserAssessments.stream().mapToDouble(assessment -> assessment.getVraag1()).average().getAsDouble();
                        Double g2Score = currentUserAssessments.stream().mapToDouble(assessment -> assessment.getVraag2()).average().getAsDouble();
                        Double g3Score = currentUserAssessments.stream().mapToDouble(assessment -> assessment.getVraag3()).average().getAsDouble();
                        Double g4Score = currentUserAssessments.stream().mapToDouble(assessment -> assessment.getVraag4()).average().getAsDouble();
                        Double g5Score = currentUserAssessments.stream().mapToDouble(assessment -> assessment.getVraag5()).average().getAsDouble();
                        Double g6Score = currentUserAssessments.stream().mapToDouble(assessment -> assessment.getVraag6()).average().getAsDouble();
                        addComponent(new ScoreLabel("--> Enthousiasme en participatie: "+g1Score));
                        addComponent(new ScoreLabel("--> Ideeën aanbrengen: "+g2Score));
                        addComponent(new ScoreLabel("--> Inhouden correct en duidelijk kunnen uitleggen: "+g3Score));
                        addComponent(new ScoreLabel("--> Groep organiseren en sturen: "+g4Score));
                        addComponent(new ScoreLabel("--> Precisie en nauwkeurigheid: "+g5Score));
                        addComponent(new ScoreLabel("--> Afspraken respecteren: "+g6Score));
                    }
                }
            }
        }


        actions.setSpacing(true);

        HorizontalLayout footer = new HorizontalLayout(actions);

        footer.setWidth(100, Unit.PERCENTAGE);
        footer.setComponentAlignment(actions, Alignment.MIDDLE_RIGHT);

        addComponent(layout);
        addComponent(footer);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        // Called when view is opened
    }
}
