package edu.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultDTO {
    private Long id;
    private Long submissionId;
    private Long userId;
    private String userName;
    private Long examId;
    private String examTitle;
    private LocalDateTime submittedAt;
    private Integer marksObtained;
    private Integer totalMarks;
    private Float percentage;
    private Boolean passed;
    private Map<Long, Integer> questionMarks = new HashMap<>();
    private String feedback;
}

