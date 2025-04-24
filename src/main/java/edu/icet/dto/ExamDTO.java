package edu.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamDTO {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Integer duration;
    private Integer passingMarks;
    private Integer totalMarks;
    private Long createdBy;
    private List<QuestionDTO> questions = new ArrayList<>();
    private boolean published;
}

