package com.abnuj.targetiascoachinggovermentjobpreperationapp.Models;

public class SubjectModel {
    int image;
    String subjectName;

    public SubjectModel() {
    }

    public SubjectModel(int image, String subjectName) {
        this.image = image;
        this.subjectName = subjectName;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
