package Homework_Homework_Modul14_SpringBoot.testapp;

import java.util.List;

public interface INoteDaoService {
    List<Note> listAll();
    Note add(Note note);
    void deleteById(long id);
    void update(Note note);
    Note getById(long id);
}