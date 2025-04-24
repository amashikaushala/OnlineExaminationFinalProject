package edu.icet.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "submission_id")
    private Submission submission;

    private Integer marksObtained;
    private Float percentage;
    private Boolean passed;

    @ElementCollection
    @CollectionTable(name = "question_marks",
            joinColumns = @JoinColumn(name = "result_id"))
    @MapKeyColumn(name = "question_id")
    @Column(name = "marks")
    private Map<Long, Integer> questionMarks = new HashMap<>();

    @Column(columnDefinition = "TEXT")
    private String feedback;

}
