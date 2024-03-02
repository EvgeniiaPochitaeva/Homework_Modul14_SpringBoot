package Homework_Homework_Modul14_SpringBoot.testapp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Note {

    private static Long idCounter = 0L;
    private Long id;
    private String title;
    private String content;

    public Note(String title, String content) {
        this.id = generateUniqueId();
        this.title = title;
        this.content = content;
    }

    private Long generateUniqueId() {
        return ++idCounter;
    }
}
