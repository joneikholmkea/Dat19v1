package repo;

import model.Note;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NoteRepo {

    private static List<Note> notes = new ArrayList<>();

    public static void init(){
        lavDataListe();
        sortNotes();
    }

    private static void sortNotes(){
        Collections.sort(notes);
    }

    private static void lavDataListe() {
        notes.add(new Note(11, "dagbog", "dagbog..."));
        notes.add(new Note(2, "to-do", "to-do..."));
        notes.add(new Note(1, "gode film", "gode film..."));
        notes.add(new Note(3, "koncerter", "koncerter..."));
        notes.add(new Note(0, "opskrifter", "opskrifter..."));
    }

    public static int getSize(){
        return notes.size();
    }

    public static Note getNoteAt(int index){
        if(index < notes.size()){
            return notes.get(index);
        }
        return new Note(0,"tom", "tom");
    }

    public static void updateNoteAt(int index, Note newNote){
        notes.set(index, newNote);
        sortNotes(); // fordi der er kommet et nyt tidspunkt
        System.out.println(notes);
    }
}
