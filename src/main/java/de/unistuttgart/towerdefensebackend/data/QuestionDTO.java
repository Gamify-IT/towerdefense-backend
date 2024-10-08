package de.unistuttgart.towerdefensebackend.data;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.lang.Nullable;
import org.springframework.validation.annotation.Validated;

/**
 * The QuestionDTO class contains the question related information.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Validated
public class QuestionDTO {

    /**
     * A unique identifier for the question.
     */
    @Nullable
    UUID id;

    /**
     * The question text.
     */
    @NotNull(message = "question text cannot be null")
    @NotBlank(message = "question text cannot be blank")
    String text;

    /**
     * The correct answer.
     */
    @NotNull(message = "right answer text cannot be null")
    @NotBlank(message = "right answer text cannot be blank")
    String correctAnswer;

    /**
     * A set of wrong answers.
     */
    Set<String> wrongAnswers;

    public QuestionDTO(final String text, final String correctAnswer, final Set<String> wrongAnswers) {
        this.text = text;
        this.correctAnswer = correctAnswer;
        this.wrongAnswers = wrongAnswers;
    }

    public boolean equalsContent(final QuestionDTO other) {
        if (this == other) return true;
        if (other == null) return false;
        return (
                Objects.equals(text, other.text) &&
                        Objects.equals(correctAnswer, other.correctAnswer) &&
                        Objects.equals(wrongAnswers, other.wrongAnswers)
        );
    }
}
