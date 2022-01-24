package co.jobsearch.Demolms.Adapter;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MainDataRespose {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("content_id")
    @Expose
    private String contentId;
    @SerializedName("course_order")
    @Expose
    private String courseOrder;
    @SerializedName("expiry_date")
    @Expose
    private String expiryDate;
    @SerializedName("upload_video")
    @Expose
    private String uploadVideo;
    @SerializedName("upload_image")
    @Expose
    private String uploadImage;
    @SerializedName("upload_screen")
    @Expose
    private String uploadScreen;
    @SerializedName("duration")
    @Expose
    private String duration;
    @SerializedName("size")
    @Expose
    private String size;
    @SerializedName("sort")
    @Expose
    private String sort;
    @SerializedName("video")
    @Expose
    private String video;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("screen")
    @Expose
    private String screen;
    @SerializedName("view")
    @Expose
    private String view;
    @SerializedName("free")
    @Expose
    private String free;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("server")
    @Expose
    private String server;
    @SerializedName("quize_id")
    @Expose
    private String quizeId;
    @SerializedName("heading")
    @Expose
    private String heading;
    @SerializedName("heading_id")
    @Expose
    private String headingId;
    @SerializedName("sub_heading_id")
    @Expose
    private String subHeadingId;
    @SerializedName("fixed_dates")
    @Expose
    private String fixedDates;
    @SerializedName("enrollment_wise")
    @Expose
    private String enrollmentWise;
    @SerializedName("mode")
    @Expose
    private String mode;
    @SerializedName("request")
    @Expose
    private String request;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("heading_data")
    @Expose
    private ArrayList<HeadingDatum> headingData = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getCourseOrder() {
        return courseOrder;
    }

    public void setCourseOrder(String courseOrder) {
        this.courseOrder = courseOrder;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getUploadVideo() {
        return uploadVideo;
    }

    public void setUploadVideo(String uploadVideo) {
        this.uploadVideo = uploadVideo;
    }

    public String getUploadImage() {
        return uploadImage;
    }

    public void setUploadImage(String uploadImage) {
        this.uploadImage = uploadImage;
    }

    public String getUploadScreen() {
        return uploadScreen;
    }

    public void setUploadScreen(String uploadScreen) {
        this.uploadScreen = uploadScreen;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getFree() {
        return free;
    }

    public void setFree(String free) {
        this.free = free;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getQuizeId() {
        return quizeId;
    }

    public void setQuizeId(String quizeId) {
        this.quizeId = quizeId;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getHeadingId() {
        return headingId;
    }

    public void setHeadingId(String headingId) {
        this.headingId = headingId;
    }

    public String getSubHeadingId() {
        return subHeadingId;
    }

    public void setSubHeadingId(String subHeadingId) {
        this.subHeadingId = subHeadingId;
    }

    public String getFixedDates() {
        return fixedDates;
    }

    public void setFixedDates(String fixedDates) {
        this.fixedDates = fixedDates;
    }

    public String getEnrollmentWise() {
        return enrollmentWise;
    }

    public void setEnrollmentWise(String enrollmentWise) {
        this.enrollmentWise = enrollmentWise;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public ArrayList<HeadingDatum> getHeadingData() {
        return headingData;
    }

    public void setHeadingData(ArrayList<HeadingDatum> headingData) {
        this.headingData = headingData;
    }





}
