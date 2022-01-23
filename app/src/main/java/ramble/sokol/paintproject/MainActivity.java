package ramble.sokol.paintproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener, View.OnClickListener {

    MyPaint myPaint;;
    private Button currPaint, reColor, seekButton;
    private ImageView sizePaint, lastPaint;
    private int colorClick = R.color.light;
    private Dialog dialog;
    private String black = "#FF000000";
    private String red = "#ff0000";
    private String blue = "#0000FF";
    private String green = "#00FF00";
    private String yellow = "#FFFF00";
    private String white = "#FFFFFF";
    private String purple = "#FF00FF";
    private String brown = "#653818";
    private String light_blue = "#42AAFF";
    private String orange = "#FFA500";
    private String sohTxt = "20";
    private TextView textSeek;
    private SeekBar seekBar;
    private int sizeSeek = 20, sohSeek = 20;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("MyTag", "Problem");
        myPaint = (MyPaint) findViewById(R.id.paint);
        LinearLayout linear1 = findViewById(R.id.linear1);
        currPaint = (Button) linear1.getChildAt(0);
        sizePaint = findViewById(R.id.sizePaint);
        lastPaint = findViewById(R.id.lastPaint);
        reColor = findViewById(R.id.reColor);
        sizePaint.setOnClickListener(this);
        lastPaint.setOnClickListener(this);


    }


    @SuppressLint("ResourceAsColor")
    public void buttonClick(View view) {
        if(lastPaint.isEnabled()){
            lastPaint.setBackground(getDrawable(R.drawable.top_not_click));
        }
        myPaint.setLast(false);
        if(view != currPaint){
            String color = view.getTag().toString();
            switch (color){
                case "1":
                    myPaint.setColor(black);
                    reColor.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.black));
                    break;
                case "2":
                    myPaint.setColor(red);
                    reColor.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.red));
                    break;
                case "3":
                    myPaint.setColor(blue);
                    reColor.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.blue));
                    break;
                case "4":
                    myPaint.setColor(green);
                    reColor.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.green));
                    break;
                case "5":
                    myPaint.setColor(yellow);
                    reColor.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.yellow));
                    break;
                case "6":
                    myPaint.setColor(white);
                    reColor.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.white));
                    break;
                case "7":
                    myPaint.setColor(purple);
                    reColor.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.purple));
                    break;
                case "8":
                    myPaint.setColor(brown);
                    reColor.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.brown));
                    break;
                case "9":
                    myPaint.setColor(light_blue);
                    reColor.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.light_blue));
                    break;
                case "10":
                    myPaint.setColor(orange);
                    reColor.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.orange));
                    break;
            }

            currPaint=(Button) view;
        }
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.sizePaint){
            sizePaint.setBackground(getDrawable(R.drawable.top_yes_click));
            dialog = new Dialog (this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.dialog);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.setCancelable(false);
            dialog.show();
            seekBar = dialog.findViewById(R.id.seekBar);
            textSeek = dialog.findViewById(R.id.textSeek);
            textSeek.setText(sohTxt);
            seekBar.setOnSeekBarChangeListener(this);
            seekBar.setProgress(sohSeek);
            seekButton = dialog.findViewById(R.id.buttonSeek);
            seekButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    myPaint.setBrushSize(sizeSeek);
                    sizePaint.setBackground(getDrawable(R.drawable.top_not_click));
                    sohSeek = sizeSeek;
                    dialog.dismiss();
                }
            });
        }else if(view.getId()==R.id.lastPaint){
            lastPaint.setBackground(getDrawable(R.drawable.top_yes_click));
            myPaint.setLast(true);
        }
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        textSeek.setText(String.valueOf(seekBar.getProgress()));
        sizeSeek = seekBar.getProgress();
        sohTxt = String.valueOf(seekBar.getProgress());
    }
}