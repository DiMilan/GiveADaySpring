package be.hogent.giveaday.data;

import be.hogent.giveaday.model.Assessment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

/**
 * Created by kryptoxx on 23/05/17.
 */
@Repository
public class AssessmentRepository extends SimpleJpaRepository<Assessment, Integer> {

    @Autowired
    public AssessmentRepository(EntityManager em) {
        super(Assessment.class, em);
    }
}
