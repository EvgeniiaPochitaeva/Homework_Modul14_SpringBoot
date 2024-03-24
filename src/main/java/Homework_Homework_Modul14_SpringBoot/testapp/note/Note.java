package Homework_Homework_Modul14_SpringBoot.testapp.note;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="TITLE", length = 200)
    private String title;

    @Column(name="CONTENT", length = 500)
    private String content;
}
