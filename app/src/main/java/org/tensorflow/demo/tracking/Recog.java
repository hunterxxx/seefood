package org.tensorflow.demo.tracking;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

import org.tensorflow.demo.Classifier;
import org.tensorflow.demo.R;
import android.widget.ImageView;
import android.view.View;

import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by mrrobot on 21.05.17.
 */

public class Recog extends View{
    private List<Classifier.Recognition> results;

    public Recog(final Context context, final AttributeSet set) {
        super(context, set);
    }

    public void setResults(final List<Classifier.Recognition> results) {
        this.results = results;
        postInvalidate();
    }
    public void setImageView(List<Classifier.Recognition> results){
        ImageView hotdog = (ImageView) findViewById(R.id.hotdog);
        ImageView nothotdog = (ImageView) findViewById(R.id.nothotdog);
        hotdog.setVisibility(ImageView.INVISIBLE);
        nothotdog.setVisibility(ImageView.INVISIBLE);

        Log.d(TAG, "running man");
        if (results != null) {
            for (final Classifier.Recognition recog : results) {
                if (recog.getTitle().equals("hotdogs") && recog.getConfidence() > 0.6 ) {
                    hotdog.setVisibility(ImageView.VISIBLE);
                    Log.d(TAG, "running hotdog");

                } else {
                    //hotdog.setVisibility(View.INVISIBLE);
                    nothotdog.setVisibility(ImageView.VISIBLE);
                    Log.d(TAG, "running nothotdog");
                }
            }
        }
    }

}
