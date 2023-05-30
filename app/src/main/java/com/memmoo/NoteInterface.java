package com.memmoo;

import android.database.Cursor;
import com.memmoo.model.Note;
// 10120051
// Muhammad Bagas Adikara
// IF - 2
public interface NoteInterface {

    public Cursor read();
    public boolean create(Note note);
    public boolean update(Note note);
    public boolean delete(String id);

}
