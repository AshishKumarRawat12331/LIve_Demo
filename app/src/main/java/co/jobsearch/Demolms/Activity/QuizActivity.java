package co.jobsearch.Demolms.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

import co.jobsearch.Demolms.Adapter.QuizAdapter;
import co.jobsearch.Demolms.R;
import co.jobsearch.Demolms.Utils.Data;
import co.jobsearch.Demolms.Utils.FragmentActivityMessage;
import co.jobsearch.Demolms.Utils.GlobalBus;
import co.jobsearch.Demolms.Utils.Loader;
import co.jobsearch.Demolms.Utils.OtherPut;
import co.jobsearch.Demolms.Utils.Question;
import co.jobsearch.Demolms.Utils.UtilMethods;

public class QuizActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView recycler_view;
    Loader loader;
    String Quiz_id;
    TextView tv_Submit;
    ArrayList<OtherPut> OtherPuthit = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


        GetId();

    }

    private void GetId() {

        Quiz_id=getIntent().getStringExtra("Quiz_id");

        Toolbar toolBar = (Toolbar) findViewById(R.id.toolbar);
        toolBar.setTitle("Quiz");
        toolBar.setTitleTextColor(getResources().getColor(R.color.black));
        setSupportActionBar(toolBar);
        toolBar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        tv_Submit=findViewById(R.id.tv_Submit);
        tv_Submit.setOnClickListener(this);

        recycler_view=findViewById(R.id.recycler_view);
        loader = new Loader(this,android.R.style.Theme_Translucent_NoTitleBar);

        HitApi();

    }

    private void HitApi() {

        loader.show();
        loader.setCancelable(false);
        loader.setCanceledOnTouchOutside(false);

        UtilMethods.INSTANCE.QuizDetail(this,Quiz_id, loader);

    }


    QuizAdapter mAdapter;
    LinearLayoutManager mLayoutManager;
    ArrayList<Question> transactionsObjects = new ArrayList<>();
    Data transactions = new Data();

    @Override
    public void onStart() {
        super.onStart();
        if (!EventBus.getDefault().isRegistered(this)) {
            GlobalBus.getBus().register(this);
        }
    }


    public void ItemClick(String QuestionId,String id ) {


        OtherPuthit.add(new OtherPut( ""+QuestionId,""+id   ));

    }



    public void dataParse(String response) {

        Gson gson = new Gson();
        transactions = gson.fromJson(response, Data.class);
        transactionsObjects = transactions.getQuestion();

        if (transactionsObjects.size() > 0) {
            mAdapter = new QuizAdapter(transactionsObjects, this,"type");
            mLayoutManager = new GridLayoutManager(this,1);
            recycler_view.setLayoutManager(mLayoutManager);
            recycler_view.setItemAnimator(new DefaultItemAnimator());
            recycler_view.setAdapter(mAdapter);
            recycler_view.setNestedScrollingEnabled(false);
            recycler_view.setVisibility(View.VISIBLE);
        } else {
            recycler_view.setVisibility(View.GONE);
        }

    }

    @Subscribe
    public void onFragmentActivityMessage(FragmentActivityMessage activityFragmentMessage) {

        if (activityFragmentMessage.getFrom().equalsIgnoreCase("QuizDetail")) {

            dataParse(activityFragmentMessage.getMessage());

        }
    }

    @Override
    public void onClick(View view) {

        if(view==tv_Submit){


            if (UtilMethods.INSTANCE.isNetworkAvialable(this)) {

                loader.show();
                loader.setCancelable(false);
                loader.setCanceledOnTouchOutside(false);

                UtilMethods.INSTANCE.Quizresults(this,OtherPuthit ,loader, Quiz_id,this);

            } else {
                UtilMethods.INSTANCE.NetworkError(this, this.getResources().getString(R.string.network_error_title),
                        this.getResources().getString(R.string.network_error_message));
            }


        }
    }
}