package co.jobsearch.Demolms.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import co.jobsearch.Demolms.Fragment.Course_Content_Fragment;
import co.jobsearch.Demolms.Fragment.Description_Content_Fragment;
import co.jobsearch.Demolms.Fragment.SubFragment.FreeEnrolledCourseFragment;
import co.jobsearch.Demolms.Fragment.SubFragment.FreeSubCourseFragment;
import co.jobsearch.Demolms.R;

public class Course_Content_Description_Activity extends AppCompatActivity implements View.OnClickListener{

    LinearLayout course,descriptioncourse;
    View v1,v2,v3;
    TextView Course_tv,Enrolled_tv,training_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_content_description);

        Toolbar toolBar = (Toolbar) findViewById(R.id.toolbar);
        toolBar.setTitle("Estimation & Planning");
        toolBar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolBar);
        toolBar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        changeFragment(new Course_Content_Fragment());

        Getid();

    }

    private void changeFragment(Fragment targetFragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment, targetFragment, "fragment")
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    private void Getid() {
        Course_tv=findViewById(R.id.Course_tv);
        Enrolled_tv=findViewById(R.id.Enrolled_tv);
        training_tv=findViewById(R.id.training_tv);

        descriptioncourse=findViewById(R.id.descriptioncourse);
        course=findViewById(R.id.course);

        v1=findViewById(R.id.v1);
        v2=findViewById(R.id.v2);
        v3=findViewById(R.id.v3);

        descriptioncourse.setOnClickListener(this);
        course.setOnClickListener(this);

        Course_tv.setTextColor(getApplicationContext().getResources().getColor(R.color.colorPrimary));
        v1.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorPrimary));

        Enrolled_tv.setTextColor(getApplicationContext().getResources().getColor(R.color.text_grey_light));
        v3.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.text_grey_light));

        training_tv.setTextColor(getApplicationContext().getResources().getColor(R.color.text_grey_light));
        v2.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.text_grey_light));

        v1.setVisibility(View.VISIBLE);
        v2.setVisibility(View.GONE);
        v3.setVisibility(View.INVISIBLE);
    }


    @Override
    public void onClick(View view) {

        if(view==course){
            Course_tv.setTextColor(getApplicationContext().getResources().getColor(R.color.colorPrimary));
            v1.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorPrimary));

            Enrolled_tv.setTextColor(getApplicationContext().getResources().getColor(R.color.text_grey_light));
            v3.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.text_grey_light));

            training_tv.setTextColor(getApplicationContext().getResources().getColor(R.color.text_grey_light));
            v2.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.text_grey_light));

            v1.setVisibility(View.VISIBLE);
            v2.setVisibility(View.GONE);
            v3.setVisibility(View.INVISIBLE);

            changeFragment(new Course_Content_Fragment());

        }

        if(view==descriptioncourse){

            Course_tv.setTextColor(getApplicationContext().getResources().getColor(R.color.text_grey_light));
            v1.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.text_grey_light));

            Enrolled_tv.setTextColor(getApplicationContext().getResources().getColor(R.color.colorPrimary));
            v3.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorPrimary));

            training_tv.setTextColor(getApplicationContext().getResources().getColor(R.color.text_grey_light));
            v2.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.text_grey_light));

            v1.setVisibility(View.INVISIBLE);
            v2.setVisibility(View.GONE);
            v3.setVisibility(View.VISIBLE);

            changeFragment(new Description_Content_Fragment());

        }
    }
}