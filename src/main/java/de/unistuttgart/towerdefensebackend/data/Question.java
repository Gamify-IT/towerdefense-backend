package de.unistuttgart.towerdefensebackend.data;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.annotation.Validated;

/**
 * The Question class contains the question related information.
 */
@Entity
@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Validated
public class Question {

    /**
     * A unique identifier for the question.
     */
    @Id
    @GeneratedValue(generator = "uuid")
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
    @NotNull(message = "right answer cannot be null")
    @NotBlank(message = "right answer cannot be blank")
    String correctAnswer;

    /**
     * A set of wrong answers.
     */
    @ElementCollection
    Set<String> wrongAnswers;

    public Question(final String text, final String correctAnswer, final Set<String> wrongAnswers) {
        this.text = text;
        this.correctAnswer = correctAnswer;
        this.wrongAnswers = wrongAnswers;
    }

    @Override
    public Question clone() {
        return new Question(this.text, this.correctAnswer, new HashSet<>(this.wrongAnswers));
    }
}
