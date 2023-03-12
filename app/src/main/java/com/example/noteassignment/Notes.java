package com.example.noteassignment;

public class Notes {

    String id;
    String note;

    private  Notes(){}
    Notes(String id, String note) {
        this.id = id;
        this.note = note;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return note;

}
}
