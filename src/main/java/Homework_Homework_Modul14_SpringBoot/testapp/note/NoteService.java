package Homework_Homework_Modul14_SpringBoot.testapp.note;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class NoteService {
    private final NoteRepository noteRepository;

    public List<Note> listAll() {
        return noteRepository.findAll();
    }
    public Note add(Note note) {
        noteRepository.save(note);
        return note;
    }

    public void deleteById(long id) {
        if (noteRepository.existsById(id)) {
            noteRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Note with id " + id + " not found");
        }
    }

    public void update(Note note) {
        if (noteRepository.existsById(note.getId())) {
            noteRepository.save(note);
        } else {
            throw new IllegalArgumentException("Note with id " + note.getId() + " not found");
        }
    }

    public Note getById(long id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Note with id " + id + " not found"));
    }
}
