package com.mylifeserver.service;

import com.mylifeserver.pojo.Note;
import com.mylifeserver.pojo.request.NotesRequest;

import java.util.List;

public interface NoteServcie {
    int insertNote(Note note);

    int updateNote(Note note);

    int deleteNote(NotesRequest notesRequest);

    List<Note> getNotesByAccount(String account);
}
