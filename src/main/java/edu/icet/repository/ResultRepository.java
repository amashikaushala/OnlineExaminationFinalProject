package edu.icet.repository;

import edu.icet.model.Exam;
import edu.icet.model.Result;
import edu.icet.model.Submission;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {
    Optional<Result> findBySubmission(Submission submission);

    @Query("SELECT r FROM Result r WHERE r.submission.user = :user")
    List<Result> findByUser(User user);

    @Query("SELECT r FROM Result r WHERE r.submission.exam = :exam")
    List<Result> findByExam(Exam exam);

    @Query("SELECT r FROM Result r WHERE r.submission.user = :user AND r.submission.exam = :exam")
    Optional<Result> findByUserAndExam(User user, Exam exam);
}

