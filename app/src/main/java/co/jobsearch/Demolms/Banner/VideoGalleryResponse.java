package co.jobsearch.Demolms.Banner;

import java.util.ArrayList;

/**
 * Created by Microsoft on 01-09-2017.
 */

public class VideoGalleryResponse {

    private String status;
    private String mark_percentage;
    private String message;


    public String getMark_percentage() {
        return mark_percentage;
    }

    public void setMark_percentage(String mark_percentage) {
        this.mark_percentage = mark_percentage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private ArrayList<GalleryObject> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<GalleryObject> getData() {
        return data;
    }

    public void setData(ArrayList<GalleryObject> data) {
        this.data = data;
    }
}
