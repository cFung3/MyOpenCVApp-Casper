package com.casper.myopencvapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.opencv.android.Utils;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

//This is Casper's project~~~
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] r = getArray3d(2, 1);
                Log.d("zencher", "" + r[1]);
                Toast.makeText(MainActivity.this, "Hello It's Me", Toast.LENGTH_SHORT).show();
                String message = "I Had Been Wonder...";
                try{
                    Mat img = Utils.loadResource(MainActivity.this,R.drawable.comrawpixel582996, CvType.CV_8UC4);
                    message = "b:"+img.get(50,50)[0]+"g:"+img.get(50,50)[1]+"r:"+img. get(50,50)[2];
                    Log.d("zencher", "channel"+img.channels());
                }catch(Exception e){
                    Log.d("zencher", ""+e);
                }
            }

        });

    }

    int[] getArray3d(int x, int y) {
        int[][][] array3d = new int[5][5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    array3d[i][j][k] = i + j + k;
                }
            }
        }
        return array3d[x][y];
    }
}