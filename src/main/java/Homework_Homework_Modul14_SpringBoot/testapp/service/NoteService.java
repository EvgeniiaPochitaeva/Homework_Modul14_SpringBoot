package Homework_Homework_Modul14_SpringBoot.testapp.service;

import Homework_Homework_Modul14_SpringBoot.testapp.entity.Note;
import Homework_Homework_Modul14_SpringBoot.testapp.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService implements INoteDaoService {
    private final NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public List<Note> listAll() {
        return noteRepository.findAll();
    }

    @Override
    public Note add(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public void deleteById(long id) {
        if (noteRepository.existsById(id)) {
            noteRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Note with id " + id + " not found");
        }
    }

    @Override
    public void update(Note note) {
        if (noteRepository.existsById(note.getId())) {
            noteRepository.save(note);
        } else {
            throw new IllegalArgumentException("Note with id " + note.getId() + " not found");
        }
    }

    @Override
    public Note getById(long id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Note with id " + id + " not found"));
    }
}
