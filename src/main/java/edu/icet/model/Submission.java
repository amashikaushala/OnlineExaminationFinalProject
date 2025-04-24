package edu.icet.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Submission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;

    private LocalDateTime startedAt;
    private LocalDateTime submittedAt;

    @ElementCollection
    @CollectionTable(name = "submission_answers",
            joinColumns = @JoinColumn(name = "submission_id"))
    @MapKeyColumn(name = "question_id")
    @Column(name = "answer", columnDefinition = "TEXT")
    private Map<Long, String> answers = new HashMap<>();

    // For MCQ questions, answer will contain option ids separated by commas

    private Boolean completed = false;

}
