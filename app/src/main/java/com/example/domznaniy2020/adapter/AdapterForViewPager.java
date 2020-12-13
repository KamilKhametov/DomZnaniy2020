package com.example.domznaniy2020.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.domznaniy2020.HistoryActivity;
import com.example.domznaniy2020.MathActivity;
import com.example.domznaniy2020.R;
import com.example.domznaniy2020.RusActivity;
import com.example.domznaniy2020.SocietyActivity;
import com.example.domznaniy2020.model.MyModel;

import java.util.List;

public class AdapterForViewPager extends PagerAdapter {

    Context context;
    List<MyModel> myModelList;

    public AdapterForViewPager( Context context, List<MyModel> myModelList ) {
        this.context=context;
        this.myModelList=myModelList;
    }

    @Override
    public int getCount() {
        return myModelList.size ();
    }

    @Override
    public boolean isViewFromObject( @NonNull View view, @NonNull Object object ) {
        return view.equals ( object );
    }

    @NonNull
    @Override
    public Object instantiateItem( @NonNull ViewGroup container, int position ) {
        View view=LayoutInflater.from ( context ).inflate ( R.layout.card_item, container, false );

        ImageView imageThing=view.findViewById ( R.id.imageThing );
        TextView titleThing=view.findViewById ( R.id.titleThing );
        TextView descThing=view.findViewById ( R.id.descThing );

        MyModel myModel=myModelList.get ( position );
        int image=myModel.getImage ();
        final String title=myModel.getTitle ();
        final String desc=myModel.getDesc ();

        imageThing.setImageResource ( image );
        titleThing.setText ( title );
        descThing.setText ( desc );

        view.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick( View v ) {
                switch (position) {
                    case 0:
                        context.startActivity ( new Intent ( context, RusActivity.class ) );
                        break;
                    case 1:
                        context.startActivity ( new Intent (context, MathActivity.class ));
                        break;
                    case 2:
                        context.startActivity ( new Intent ( context, HistoryActivity.class ) );
                        break;
                    case 3:
                        context.startActivity (new Intent ( context, SocietyActivity.class ));
                        break;
                    default: break;
                }

            }
        } );

        container.addView ( view, position );
        return view;
    }

    @Override
    public void destroyItem( @NonNull ViewGroup container, int position, @NonNull Object object ) {
        container.removeView ( (View) object );
    }
}
