package com.mehersupreeth.AgSchool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AgSchool {

    public List<Float> calculateTotalMarks(List<Student> stList){
        List<Float> toReturn = new ArrayList<>();
        for(Student s:stList){
            s.setTotalMarks(s.getEnglishMarks()+s.getLanguageMarks()+s.getMathMarks()+s.getScienceMarks()+s.getSocialStudiesMarks());
            toReturn.add(s.getTotalMarks());
        }
        return toReturn;
    }
    public String calculateTopper(List<Student> stList){
        List<Float> totalMarksList = new ArrayList<>();
        stList.forEach(s -> totalMarksList.add(s.getTotalMarks()));
//        float max = totalMarksList.stream().max(Float::compare).get();
//        int maxIndex = totalMarksList.indexOf(totalMarksList.stream().max(Float::compare).get());
        Student topper = stList.get(totalMarksList.indexOf(totalMarksList.stream().max(Float::compare).get()));
        String toReturn = topper.getStudentName()+","+topper.getRollNumber();
        return toReturn;
    }
    public List<Float> averageMarksInEachSubject(List<Student> stList){
        List<Float> avgMarksList = new ArrayList<>();
        float avgMath = 0f, avgScience = 0f, avgEnglish = 0f, avgLanguage = 0f, avgSocialStudies = 0f;
        for(Student s:stList){
            avgMath = avgMath+s.getMathMarks();
            avgScience = avgScience+s.getScienceMarks();
            avgEnglish = avgEnglish+s.getEnglishMarks();
            avgLanguage = avgLanguage+s.getLanguageMarks();
            avgSocialStudies = avgSocialStudies+s.getSocialStudiesMarks();
        }
        avgMarksList.add(avgMath/stList.size());
        avgMarksList.add(avgScience/stList.size());
        avgMarksList.add(avgEnglish/stList.size());
        avgMarksList.add(avgLanguage/stList.size());
        avgMarksList.add(avgSocialStudies/stList.size());
        return avgMarksList;
    }
    public List<Character> assignGrades(List<Student> stList){
        List<Character> toReturn = new ArrayList<>();
        for(Student s:stList){
            float tempAvgMarks = s.getTotalMarks()/5;
            if(tempAvgMarks >= 95)
                toReturn.add('A');
            else if(tempAvgMarks >= 80)
                toReturn.add('B');
            else if(tempAvgMarks >= 70)
                toReturn.add('C');
            else if (tempAvgMarks >= 60)
                toReturn.add('D');
            else if (tempAvgMarks >= 50)
                toReturn.add('E');
            else
                toReturn.add('F');
        }
        return toReturn;
    }
}
