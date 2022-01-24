package co.jobsearch.Demolms.Utils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OtherPut {


    @SerializedName("question_id")
    @Expose
    private String question_id;

    @SerializedName("select_option")
    @Expose
    private String select_option;


    public OtherPut(String question_id, String select_option) {
        this.question_id = question_id;
        this.select_option = select_option;
    }
}
