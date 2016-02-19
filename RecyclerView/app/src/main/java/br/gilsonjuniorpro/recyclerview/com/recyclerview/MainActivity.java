package br.gilsonjuniorpro.recyclerview.com.recyclerview;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.gilsonjuniorpro.recyclerview.com.recyclerview.adapter.Adapter;
import br.gilsonjuniorpro.recyclerview.com.recyclerview.dto.MovieDTO;

public class MainActivity extends AppCompatActivity {

    private List<MovieDTO> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                MovieDTO movie = movieList.get(position);
                Toast.makeText(getApplicationContext(), movie.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        mAdapter = new Adapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareMovieData();
    }



    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }



    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private MainActivity.ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final MainActivity.ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }





    private void prepareMovieData() {
        MovieDTO movie = new MovieDTO("Mad Max: Fury Road", "Action & Adventure", "2015");
        movieList.add(movie);

        movie = new MovieDTO("Inside Out", "Animation, Kids & Family", "2015");
        movieList.add(movie);

        movie = new MovieDTO("Star Wars: Episode VII - The Force Awakens", "Action", "2015");
        movieList.add(movie);

        movie = new MovieDTO("Shaun the Sheep", "Animation", "2015");
        movieList.add(movie);

        movie = new MovieDTO("The Martian", "Science Fiction & Fantasy", "2015");
        movieList.add(movie);

        movie = new MovieDTO("Mission: Impossible Rogue Nation", "Action", "2015");
        movieList.add(movie);

        movie = new MovieDTO("Up", "Animation", "2009");
        movieList.add(movie);

        movie = new MovieDTO("Star Trek", "Science Fiction", "2009");
        movieList.add(movie);

        movie = new MovieDTO("The LEGO Movie", "Animation", "2014");
        movieList.add(movie);

        movie = new MovieDTO("Iron Man", "Action & Adventure", "2008");
        movieList.add(movie);

        movie = new MovieDTO("Aliens", "Science Fiction", "1986");
        movieList.add(movie);

        movie = new MovieDTO("Chicken Run", "Animation", "2000");
        movieList.add(movie);

        movie = new MovieDTO("Back to the Future", "Science Fiction", "1985");
        movieList.add(movie);

        movie = new MovieDTO("Raiders of the Lost Ark", "Action & Adventure", "1981");
        movieList.add(movie);

        movie = new MovieDTO("Goldfinger", "Action & Adventure", "1965");
        movieList.add(movie);

        movie = new MovieDTO("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
        movieList.add(movie);

        mAdapter.notifyDataSetChanged();
    }

}
