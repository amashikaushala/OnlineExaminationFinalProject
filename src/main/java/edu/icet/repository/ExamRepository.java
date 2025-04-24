package edu.icet.repository;

import edu.icet.model.Exam;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {
    List<Exam> findByCreatedBy(User user);
    List<Exam> findByPublishedTrue();
}

