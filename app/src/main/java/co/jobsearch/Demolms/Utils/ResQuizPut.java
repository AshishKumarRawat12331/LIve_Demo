package co.jobsearch.Demolms.Utils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResQuizPut {

    @SerializedName("user_id")
    @Expose
    private String user_id;

    @SerializedName("quiz_id")
    @Expose
    private String quiz_id;


    @SerializedName("other")
    @Expose
    private List<OtherPut> other = null;


    public ResQuizPut(String user_id ,String quiz_id,  List<OtherPut> other ) {

        this.user_id = user_id;
        this.quiz_id = quiz_id;
        this.other = other;

    }





}
