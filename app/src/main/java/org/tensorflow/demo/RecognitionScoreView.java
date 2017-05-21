/* Copyright 2015 The TensorFlow Authors. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
==============================================================================*/

package org.tensorflow.demo;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import android.view.View;


import org.tensorflow.demo.Classifier.Recognition;

import java.util.List;

import static android.content.ContentValues.TAG;

public class RecognitionScoreView extends View {
    ImageView hotdog = (ImageView) findViewById(R.id.hotdog);
    ImageView nothotdog = (ImageView) findViewById(R.id.nothotdog);
    private List<Recognition> results;

    public RecognitionScoreView(final Context context, final AttributeSet set) {
        super(context, set);
    }

    public void setResults(final List<Recognition> results) {
        this.results = results;

        setImageViews();
        //postInvalidate();
    }

    @Override
    public void onDraw(final Canvas canvas){

    }

    public synchronized void setImageViews(){
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

    public void onDraw11(final Canvas canvas) {
        Log.d(TAG, "lalala");

        ImageView hotdog = (ImageView) findViewById(R.id.hotdog);
        ImageView nothotdog = (ImageView) findViewById(R.id.nothotdog);
        hotdog.setVisibility(ImageView.INVISIBLE);
        nothotdog.setVisibility(ImageView.INVISIBLE);

        Log.d(TAG, "running man");

//        image.setVisibility(View.VISIBLE);
        if (results != null) {
            for (final Recognition recog : results) {
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
