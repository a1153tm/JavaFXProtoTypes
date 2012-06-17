package jp.ac.aiit.apbl6.javafxprototypes.sample.questionnaire;

import jp.ac.aiit.apbl6.javafxprototypes.model.Entity;

public class ResultsEntry extends Entity
{
    private String course;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String answer5;

    public ResultsEntry() {}

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public String getAnswer5() {
        return answer5;
    }

    public void setAnswer5(String answer5) {
        this.answer5 = answer5;
    }

}
