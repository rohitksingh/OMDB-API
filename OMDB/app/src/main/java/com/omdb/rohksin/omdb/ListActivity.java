package com.omdb.rohksin.omdb;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Slide;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.omdb.rohksin.omdb.Adaters.ViewAllMoviesAdapter;
import com.omdb.rohksin.omdb.NewSearch.POJO.MovieRole;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Illuminati on 6/28/2017.
 */
public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.list_layout);

        //setAnimation();

        ArrayList<MovieRole> movieRoles = (ArrayList<MovieRole>)getIntent().getSerializableExtra("allMoviesListActivity");

        Log.d("TTTT",(movieRoles==null)+"");

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        LinearLayoutManager llm = new LinearLayoutManager(ListActivity.this);
        recyclerView.setLayoutManager(llm);

        Collections.sort(movieRoles);

        ViewAllMoviesAdapter adapter = new ViewAllMoviesAdapter(movieRoles,ListActivity.this);
        recyclerView.setAdapter(adapter);


    }

    public void setAnimation()
    {
        if(Build.VERSION.SDK_INT>20) {
            Slide slide = new Slide();
            slide.setDuration(1000);
            getWindow().setEnterTransition(slide);
        }
    }
}
