package edu.icet.repository;

import edu.icet.model.Exam;
import edu.icet.model.Submission;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission, Long> {
    List<Submission> findByUser(User user);
    List<Submission> findByExam(Exam exam);
    Optional<Submission> findByUserAndExam(User user, Exam exam);
    List<Submission> findByUserAndCompleted(User user, Boolean completed);
}

