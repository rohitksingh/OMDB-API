package com.omdb.rohksin.omdb.LandingActivities;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Slide;
import android.util.Log;
import android.view.Gravity;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

import com.omdb.rohksin.omdb.Adaters.ActorsListAdapter;
import com.omdb.rohksin.omdb.BlankActivity;
import com.omdb.rohksin.omdb.NewSearch.POJO.Actor;
import com.omdb.rohksin.omdb.SerializableCarriers.SerializableObject;
import com.omdb.rohksin.omdb.R;

import java.util.List;

/**
 * Created by Illuminati on 6/21/2017.
 */
public class AllActorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setAnimation();
        setContentView(R.layout.image_landing_layout);

        getSupportActionBar().setTitle("Cast");

        SerializableObject object = (SerializableObject)getIntent().getSerializableExtra(BlankActivity.MOVIE_LIST);
        List<Actor> actorList = object.getObjectList();

        RecyclerView allActorRecyclerView = (RecyclerView)findViewById(R.id.image_list_landing);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        allActorRecyclerView.setLayoutManager(llm);
        Log.d("LIST EMPTY",(actorList==null)+"");
        ActorsListAdapter adapter = new ActorsListAdapter(actorList,this);
        allActorRecyclerView.setAdapter(adapter);
    }

    public void setAnimation()
    {
        if(Build.VERSION.SDK_INT>20) {
            Slide slide = new Slide();
            slide.setSlideEdge(Gravity.LEFT);
            slide.setDuration(400);
            slide.setInterpolator(new AccelerateDecelerateInterpolator());
            getWindow().setExitTransition(slide);
            getWindow().setEnterTransition(slide);
        }
    }
}
