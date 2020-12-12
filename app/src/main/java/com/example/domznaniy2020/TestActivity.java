package com.example.domznaniy2020;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.domznaniy2020.adapter.AdapterForViewPager;
import com.example.domznaniy2020.model.MyModel;

import java.util.ArrayList;
import java.util.List;

public class TestActivity extends AppCompatActivity {

    ActionBar actionBar;
    private List<MyModel> myModelList;
    private AdapterForViewPager adapterForViewPager;
    private ViewPager viewPager;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_test );

        // Установка заголовка actionBar
        setActionBar ();

        viewPager = findViewById ( R.id.viewPager );
        loadCard ();

        viewPager.addOnPageChangeListener ( new ViewPager.OnPageChangeListener () {
            @Override
            public void onPageScrolled( int position, float positionOffset, int positionOffsetPixels ) {

            }

            @Override
            public void onPageSelected( int position ) {

            }

            @Override
            public void onPageScrollStateChanged( int state ) {

            }
        } );

    }

    private void loadCard(){
        myModelList = new ArrayList<> ();
        myModelList.add ( new MyModel ( "Русский язык", "Глаголы, существительные)", R.drawable.ic_launcher_background ) );
        myModelList.add ( new MyModel ( "Математика", "Реши задачи)", R.drawable.ic_launcher_background ) );
        myModelList.add ( new MyModel ( "История", "Петр I и другие...", R.drawable.ic_launcher_background ) );
        myModelList.add ( new MyModel ( "Обществознание", "Имеешь право", R.drawable.ic_launcher_background ) );

        adapterForViewPager = new AdapterForViewPager ( this, myModelList );
        viewPager.setAdapter ( adapterForViewPager );
        viewPager.setPadding ( 100,0,100,0 );

    }

    private void setActionBar(){
        actionBar = getSupportActionBar ();
        actionBar.setTitle ( "Тестирование" );
    }

}