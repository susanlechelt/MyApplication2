package com.example.susanlechett.myapplication2w;

import android.media.Image;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {




    public MainActivityFragment() {
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        LinearLayout linearLayout1 = (LinearLayout) rootView.findViewById(R.id.linearLayout1);

        //SET IMAGEVIEWS PROGRAMMATICALLY DEPENDING ON # CONNECTED DEVICES
        ImageView iv_0 = new ImageView(getActivity());
        ImageView iv_1 = new ImageView(getActivity());
        ImageView iv_2 = new ImageView(getActivity());
        //code change
        Button reset = new Button(getActivity());
        reset.setText(R.string.reset);

        ImageView[] images = new ImageView[] { iv_0, iv_1, iv_2 };
        int drawables[] = new int[] { R.drawable.codemecube, R.drawable.codemecubeblue, R.drawable.codemecubered };

        //PARAMETERS FOR IMAGE VIEWS
        final float scale = getContext().getResources().getDisplayMetrics().density;
        int imageviewsize = (int) (200*scale*0.5f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(imageviewsize, imageviewsize);
        layoutParams.gravity= Gravity.END;
        LinearLayout.LayoutParams evenParams = new LinearLayout.LayoutParams(imageviewsize,imageviewsize);

        int i = 0;
        while (i < images.length) {
            images[i].setBackgroundResource(drawables[i]);
            images[i].setScaleType(ImageView.ScaleType.FIT_CENTER);
            if ((i%2) == 0) images[i].setLayoutParams(evenParams);
            else images[i].setLayoutParams(layoutParams);
            linearLayout1.addView(images[i]);


            //TEST
            images[i].setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    String coords = "coordinates: " + String.valueOf(event.getX()) + "x" + String.valueOf(event.getY());
                    Toast.makeText(getActivity(), coords, Toast.LENGTH_SHORT).show();
                    //v.setBackgroundResource(R.drawable.codemecubeblue);
                    return true;
                   //return (v, event.getX(), event.getY());
                }
            });
            i++;
        }
        linearLayout1.addView(reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //reset.setText("clicked");
                //clearScreen();
             //   getDoodleFragment().getDoodleView().clear(); // clear image

            }
        });


        return rootView;
    }


}


