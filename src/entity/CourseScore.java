package entity;

import java.time.LocalDate;

public class CourseScore {
    private Integer regularScore; // 平时成绩
    private LocalDate regularScoreDate; // 平时成绩录入日期
    private Integer midtermScore; // 期中成绩
    private LocalDate midtermScoreDate; // 期中成绩录入日期
    private Integer experimentScore; // 实验成绩
    private LocalDate experimentScoreDate; // 实验成绩录入日期
    private Integer finalScore; // 期末成绩
    private LocalDate finalScoreDate; // 期末成绩录入日期
    private Integer ComprehensiveScore; // 综合成绩


    public CourseScore(int regularScore, LocalDate regularScoreDate, int midtermScore, LocalDate midtermScoreDate, int experimentScore, LocalDate experimentScoreDate, int finalScore, LocalDate finalScoreDate, int ComprehensiveScore) {
        this.regularScore = regularScore;
        this.regularScoreDate = regularScoreDate;
        this.midtermScore = midtermScore;
        this.midtermScoreDate = midtermScoreDate;
        this.experimentScore = experimentScore;
        this.experimentScoreDate = experimentScoreDate;
        this.finalScore = finalScore;
        this.finalScoreDate = finalScoreDate;
        this.ComprehensiveScore = ComprehensiveScore;
    }

    @Override
    public String toString() {
        return  "平时成绩=" + regularScore +
                ", 期中成绩=" + midtermScore +
                ", 实验成绩=" + experimentScore +
                ", 期末成绩=" + finalScore +
                ", 综合成绩=" + ComprehensiveScore ;
    }

    public int getRegularScore() {
        return regularScore;
    }

    public void setRegularScore(int regularScore) {
        this.regularScore = regularScore;
    }

    public LocalDate getRegularScoreDate() {
        return regularScoreDate;
    }

    public void setRegularScoreDate(LocalDate regularScoreDate) {
        this.regularScoreDate = regularScoreDate;
    }

    public int getMidtermScore() {
        return midtermScore;
    }

    public void setMidtermScore(int midtermScore) {
        this.midtermScore = midtermScore;
    }

    public LocalDate getMidtermScoreDate() {
        return midtermScoreDate;
    }

    public void setMidtermScoreDate(LocalDate midtermScoreDate) {
        this.midtermScoreDate = midtermScoreDate;
    }

    public int getExperimentScore() {
        return experimentScore;
    }

    public void setExperimentScore(int experimentScore) {
        this.experimentScore = experimentScore;
    }

    public LocalDate getExperimentScoreDate() {
        return experimentScoreDate;
    }

    public void setExperimentScoreDate(LocalDate experimentScoreDate) {
        this.experimentScoreDate = experimentScoreDate;
    }

    public int getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(int finalScore) {
        this.finalScore = finalScore;
    }

    public LocalDate getFinalScoreDate() {
        return finalScoreDate;
    }

    public void setFinalScoreDate(LocalDate finalScoreDate) {
        this.finalScoreDate = finalScoreDate;
    }

    public int getComprehensiveScore() {
        return ComprehensiveScore;
    }

    public void setComprehensiveScore(int comprehensiveScore) {
        this.ComprehensiveScore = comprehensiveScore;
    }
}
