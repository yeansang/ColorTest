package com.example.nemus.colortest;

import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SeekBar redSeek;
    private SeekBar greenSeek;
    private SeekBar blueSeek;
    private TextView redText;
    private TextView greenText;
    private TextView blueText;

    private ImageView imageView;

    float[] mat = new float[]
            {
                    1f, 0f, 0f, 0, 0,
                    0f, 1f, 0f, 0, 0,
                    0f, 0f, 1f, 0, 0,
                    0f, 0f, 0f, 1, 0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        redSeek = (SeekBar)findViewById(R.id.red_seek);
        greenSeek = (SeekBar)findViewById(R.id.green_seek);
        blueSeek = (SeekBar)findViewById(R.id.blue_seek);
        redText = (TextView)findViewById(R.id.red_text);
        greenText = (TextView)findViewById(R.id.green_text);
        blueText = (TextView)findViewById(R.id.blue_text);

        imageView = (ImageView)findViewById(R.id.image);

        float[] mat1 = new float[]
                {
                        1.5f, -0.25f, -0.25f, 0, 0,
                        -0.250f, 1.5f, -0.25f, 0, 0,
                        -0.25f, -0.25f, 1.5f, 0, 0,
                        0f, 0f, 0f, 1, 0};
        ColorFilter cff = imageView.getColorFilter();
        ColorMatrixColorFilter cf = new ColorMatrixColorFilter(mat1);
        imageView.setColorFilter(cf);

        redSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                float val = (float)i/100;
                float val2 = (1f-val)/2;
                redText.setText(val+"");
                mat[0] = val;
                mat[1] = val2;
                mat[2] = val2;
                /*float[] mat = new float[]
                        {
                                val, val2, val2, 0, 0,
                                0f, 1f, 0f, 0, 0,
                                0f, 0f, 1f, 0, 0,
                                0f, 0f, 0f, 1, 0};*/
                ColorFilter cff = imageView.getColorFilter();
                ColorMatrixColorFilter cf = new ColorMatrixColorFilter(mat);
                imageView.setColorFilter(cf);
                //imageView.clearColorFilter();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        greenSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                greenText.setText(i+"");
                float val = (float)i/100;
                float val2 = (1f-val)/2;
                mat[5] = val2;
                mat[6] = val;
                mat[7] = val2;
                /*float[] mat = new float[]
                        {
                                1f, 0f, 0f, 0, 0,
                                val2, val, val2, 0, 0,
                                0f, 0f, 1f, 0, 0,
                                0f, 0f, 0f, 1, 0};*/
                ColorFilter cff = imageView.getColorFilter();
                ColorMatrixColorFilter cf = new ColorMatrixColorFilter(mat);
                imageView.setColorFilter(cf);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        blueSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                blueText.setText(i+"");
                float val = (float)i/100;
                float val2 = (1f-val)/2;
                mat[10] = val2;
                mat[11] = val2;
                mat[12] = val;
                /*float[] mat = new float[]
                        {
                                1f, 0f, 0f, 0, 0,
                                0f, 1f, 0f, 0, 0,
                                val2, val2, val, 0, 0,
                                0f, 0f, 0f, 1, 0};*/
                ColorMatrixColorFilter cf = new ColorMatrixColorFilter(mat);
                imageView.setColorFilter(cf);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

}
