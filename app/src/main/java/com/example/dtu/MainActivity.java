package com.example.dtu;
import java.util.ArrayDeque;
import java.util.Queue;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int row=20;
    int column=20;
    int [][] Path= new int[row][column];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(int i=0;i<row;++i){
            for(int j=0;j<column;++j){
                Path[i][j]=1;
            }
        }
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
        EditText editText=new EditText(this);
        editText.setLayoutParams(new android.view.ViewGroup.LayoutParams(50,50));
        //editText.setImageResource(R.drawable.greyimage);


        editText.setBackgroundColor(Color.YELLOW);

        editText.setTextColor(Color.BLUE);
        int p=x%50;
        x=x-p;
        p=y%50;
        y=y-p;


        //call to change the matrix
        updateMatrix(x,y);

        editText.setX(x);
        editText.setY(y);
        linearview.addView(editText);

    }
    void updateMatrix(int x,int y){
        x=x/50;
        y=y/50;
        Path[x][y]=0;

    }
    void find(){
        SearchMazeBFS smbfs = new SearchMazeBFS();


        SearchMazeBFS.Point source = new SearchMazeBFS.Point(0, 0);
        SearchMazeBFS.Point dest = new SearchMazeBFS.Point(10, 9);

        int dist = smbfs.BFS(Path, source, dest);
        TextView t1=(TextView)findViewById(R.id.value);
        String s="hey buddy";


        if (dist == Integer.MAX_VALUE)
            t1.setText(s);
        else
            t1.setText(s);


    }

}
