package com.mehersupreeth.AgSchool;

public class Student {
    private String studentName;
    private int rollNumber;
    private float mathMarks;
    private float scienceMarks;
    private float englishMarks;
    private float languageMarks;
    private float socialStudiesMarks;
    private float totalMarks;
    private char grade;

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    public float getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(float totalMarks) {
        this.totalMarks = totalMarks;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public float getMathMarks() {
        return mathMarks;
    }

    public void setMathMarks(float mathMarks) {
        this.mathMarks = mathMarks;
    }

    public float getScienceMarks() {
        return scienceMarks;
    }

    public void setScienceMarks(float scienceMarks) {
        this.scienceMarks = scienceMarks;
    }

    public float getEnglishMarks() {
        return englishMarks;
    }

    public void setEnglishMarks(float englishMarks) {
        this.englishMarks = englishMarks;
    }

    public float getLanguageMarks() {
        return languageMarks;
    }

    public void setLanguageMarks(float languageMarks) {
        this.languageMarks = languageMarks;
    }

    public float getSocialStudiesMarks() {
        return socialStudiesMarks;
    }

    public void setSocialStudiesMarks(float socialStudiesMarks) {
        this.socialStudiesMarks = socialStudiesMarks;
    }

    public Student(String studentName, int rollNumber, float mathMarks, float scienceMarks, float englishMarks, float languageMarks, float socialStudiesMarks) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.mathMarks = mathMarks;
        this.scienceMarks = scienceMarks;
        this.englishMarks = englishMarks;
        this.languageMarks = languageMarks;
        this.socialStudiesMarks = socialStudiesMarks;
    }
}
