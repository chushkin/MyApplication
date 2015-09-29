package keys.pazzle.myapplication;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.io.IOException;
import java.io.InputStream;


public class MainActivity extends Activity implements View.OnTouchListener{


    protected RelativeLayout generalLayout;
    protected ImageView[] bool = new ImageView[4];
    protected TranslateAnimation a;
    protected ObjectAnimator propertyA;
    long timeout;
    int i_d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generalLayout = new RelativeLayout(this);

        Log.d("Location",""+this.getResources().getConfiguration().locale.getLanguage());

        Log.d("Location",""+this.getResources().getConfiguration().locale.getLanguage());
        Log.d("Location",""+this.getResources().getConfiguration().locale.toString());
        Log.d("Location",""+this.getResources().getConfiguration().toString());
        try {

            bool[0] = new ImageView(this);
            bool[1] = new ImageView(this);
            bool[2] = new ImageView(this);
            bool[3] = new ImageView(this);
            InputStream istream = getAssets().open("img/bool.png");
            Drawable d = Drawable.createFromStream(istream, null);
            int index = 1500;
            for(ImageView v : bool){
                index +=index;
                v.setImageDrawable(d);
                generalLayout.addView(v);
                propertyA = ObjectAnimator.ofFloat(v, View.TRANSLATION_Y, 2000);
                propertyA.setRepeatCount(1);
                propertyA.setRepeatMode(ValueAnimator.REVERSE);
                propertyA.setDuration(index);
                propertyA.setInterpolator( new LinearInterpolator());
                v.setOnTouchListener(this);
                propertyA.start();
                v.getLayoutParams().height = 300;
                v.getLayoutParams().width = 300;
            }

            setContentView(generalLayout);
            generalLayout.setOnTouchListener(this);
        }catch(IOException e){
            Log.d("png", e.toString());
        }


      //  timeout= System.currentTimeMillis();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:{

                break;
            }
        }
        Log.d("View", "ID: " + v.getId() + " --- " + v.toString());
        if(v.toString().contains("ImageView")) {
            v.setVisibility(View.GONE);
        }
        return true;

    }

}
