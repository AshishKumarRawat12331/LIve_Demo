package co.jobsearch.Demolms.Utils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Data {



    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("company_id")
    @Expose
    private String companyId;
    @SerializedName("quiz_name")
    @Expose
    private String quizName;
    @SerializedName("quiz_time")
    @Expose
    private String quizTime;
    @SerializedName("job_skill_id")
    @Expose
    private String jobSkillId;
    @SerializedName("total_marks")
    @Expose
    private String totalMarks;
    @SerializedName("pass_mark")
    @Expose
    private String passMark;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("question")
    @Expose
    private ArrayList<Question> question = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public String getQuizTime() {
        return quizTime;
    }

    public void setQuizTime(String quizTime) {
        this.quizTime = quizTime;
    }

    public String getJobSkillId() {
        return jobSkillId;
    }

    public void setJobSkillId(String jobSkillId) {
        this.jobSkillId = jobSkillId;
    }

    public String getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(String totalMarks) {
        this.totalMarks = totalMarks;
    }

    public String getPassMark() {
        return passMark;
    }

    public void setPassMark(String passMark) {
        this.passMark = passMark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public ArrayList<Question> getQuestion() {
        return question;
    }

    public void setQuestion(ArrayList<Question> question) {
        this.question = question;
    }

}
