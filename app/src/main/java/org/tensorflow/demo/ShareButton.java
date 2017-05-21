package org.tensorflow.demo;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by mrrobot on 21.05.17.
 */

public class ShareButton extends Activity{

    public ShareButton(){
        Button button = (Button) findViewById(R.id.share);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            }
        });
    }


    public void onClickButton(View v){
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }
}
