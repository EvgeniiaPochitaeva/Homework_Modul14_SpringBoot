package Homework_Homework_Modul14_SpringBoot.testapp.repository;

import Homework_Homework_Modul14_SpringBoot.testapp.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}