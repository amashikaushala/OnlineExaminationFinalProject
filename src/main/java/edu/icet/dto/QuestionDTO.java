package edu.icet.dto;

import edu.icet.model.QuestionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDTO {
    private Long id;
    private String content;
    private QuestionType type;
    private Integer marks;
    private Long examId;
    private List<OptionDTO> options = new ArrayList<>();

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OptionDTO {
        private Long id;
        private String content;
        private boolean correct;
    }
}

