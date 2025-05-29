package com.mylifeserver.service.Impl;

import com.mylifeserver.dao.NoteMapper;
import com.mylifeserver.pojo.Note;
import com.mylifeserver.pojo.request.NotesRequest;
import com.mylifeserver.service.NoteServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteServcie {
    @Autowired
    NoteMapper noteMapper;

    @Override
    public int insertNote(Note note) {
        return noteMapper.insertNote(note);
    }

    @Override
    public int updateNote(Note note) {
        return noteMapper.updateNote(note);
    }

    @Override
    public int deleteNote(NotesRequest notesRequest) {
        return noteMapper.deleteNote(notesRequest);
    }

    @Override
    public List<Note> getNotesByAccount(String account) {
        return noteMapper.getNotesByAccount(account);
    }
}
