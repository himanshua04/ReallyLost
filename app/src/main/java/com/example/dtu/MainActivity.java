package com.example.dtu;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int [][] Path= new int[20][20];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        touchLisner();
    }


    private void touchLisner(){
       final RelativeLayout l1=(RelativeLayout) findViewById(R.id.touch);
        l1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int  x=(int) motionEvent.getX();
                int y=(int)motionEvent.getY();

                TextView t1=(TextView)findViewById(R.id.value);
                String s="x:"+x+"y:"+y;
                display(x,y);

                t1.setText(s);
                return false;
            }
        });
    }

    private void display(int x,int y){
        RelativeLayout linearview=(RelativeLayout) findViewById(R.id.touch);
        EditText imageView=new EditText(this);
        imageView.setLayoutParams(new android.view.ViewGroup.LayoutParams(50,50));
        //imageView.setImageResource(R.drawable.greyimage);


        imageView.setBackgroundColor(Color.YELLOW);

        imageView.setTextColor(Color.BLUE);
        int p=x%50;
        x=x-p;
        p=y%50;
        y=y-p;


        //call to change the matrix
        updateMatrix(x,y);

        imageView.setX(x);
        imageView.setY(y);
        linearview.addView(imageView);

    }
    void updateMatrix(int x,int y){
        x=x/50;
        y=y/50;
        Path[x][y]=1;

    }

}
