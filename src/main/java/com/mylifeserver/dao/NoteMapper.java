package com.mylifeserver.dao;

import com.mylifeserver.pojo.Note;
import com.mylifeserver.pojo.request.NotesRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NoteMapper {

    @Insert("INSERT INTO notes(uuid, title, content,date,mood,weather,account) VALUES(#{uuid}, #{title}, #{content},#{date},#{mood},#{weather},#{account})")
    int insertNote(Note note);


    @Update("UPDATE notes SET title = #{title}, content = #{content}, date = #{date}, mood = #{mood}, weather = #{weather} WHERE uuid = #{uuid} AND account = #{account}")
    int updateNote(Note note);


    @Delete("DELETE FROM notes WHERE uuid=#{uuid} AND account=#{account}")
    int deleteNote(NotesRequest notesRequest);

    @Select("SELECT * FROM notes WHERE account=#{account} ")
    List<Note> getNotesByAccount(String account);
}
