package Homework_Homework_Modul14_SpringBoot.testapp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService implements INoteDaoService {
    private final List<Note> notes = new ArrayList<>();

    @Override
    public List<Note> listAll() {
        return notes;
    }

    @Override
    public Note add(Note note) {
        notes.add(note);
        return note;
    }

    @Override
    public void deleteById(long id) {
        Note noteToDelete = getById(id);
        if (noteToDelete != null) {
            notes.remove(noteToDelete);
        } else {
            throw new IllegalArgumentException("Note with id " + id + " not found");
        }
    }

    @Override
    public void update(Note note) {
        Note existingNote = getById(note.getId());
        if (existingNote != null) {
            existingNote.setTitle(note.getTitle());
            existingNote.setContent(note.getContent());
        } else {
            throw new IllegalArgumentException("Note with id " + note.getId() + " not found");
        }
    }

    @Override
    public Note getById(long id) {
        for (Note note : notes) {
            if (note.getId() == id) {
                return note;
            }
        }
        throw new IllegalArgumentException("Note with id " + id + " not found");
    }
}
