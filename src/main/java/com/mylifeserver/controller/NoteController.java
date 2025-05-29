package com.mylifeserver.controller;

import com.mylifeserver.pojo.Note;
import com.mylifeserver.pojo.request.NotesRequest;
import com.mylifeserver.service.NoteServcie;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/noteApi")
@MapperScan("com.mylifeserver.dao")
public class NoteController {
    @Autowired
    NoteServcie noteServcie;
    @PostMapping("/uploadNote")
    public ResponseEntity<String> insertNotes(@RequestBody Note note) {;
        int flag = noteServcie.insertNote(note);
        if(flag==0){
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("上传日记失败");
        }
        return ResponseEntity.ok("上传日记成功！");
    }

    @PostMapping("/updateNote")
    public ResponseEntity<String> updateNotes(@RequestBody Note note) {
        int flag = noteServcie.updateNote(note);
        if(flag==0){
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("日记更新失败");
        }
        return ResponseEntity.ok("日记更新成功！");
    }

    @PostMapping("/deleteNote")
    public ResponseEntity<String> deleteNotes(@RequestBody NotesRequest notesRequest) {
        System.out.println("deletNotesRequest.getAccount()"+notesRequest.getAccount());
        int flag = noteServcie.deleteNote(notesRequest);
        if(flag==0){
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("日记删除失败");
        }
        return ResponseEntity.ok("日记删除成功！");
    }

    @GetMapping("/downloadNotes")
    public ResponseEntity<List<Note>> selectNotes(@RequestParam String account) {
        List<Note> notes = noteServcie.getNotesByAccount(account);
        System.out.println("我到了");
        for(Note note : notes){
            System.out.println("====+"+note.getContent());
        }
        if (notes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        System.out.println("我返回值了");
        return ResponseEntity.ok(notes);
    }

}
