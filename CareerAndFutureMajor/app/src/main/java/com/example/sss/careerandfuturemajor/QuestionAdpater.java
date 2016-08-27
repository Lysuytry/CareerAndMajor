package com.example.sss.careerandfuturemajor;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Ly Suytry on 8/25/2016.
 */
public class QuestionAdpater extends AppCompatActivity {
    private TextView txtQuestion,txtpages;
    private ImageButton btNext;
    private RadioGroup radioG;
    private RadioButton radioB;
    private ProgressDialog progress;

    private int position=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_layout);
        ActionBar ac=getSupportActionBar();
        ac.setDisplayHomeAsUpEnabled(true);
        txtQuestion=(TextView) findViewById(R.id.txtQuestion);
        txtpages=(TextView)findViewById(R.id.pageNumber);
        btNext=(ImageButton)findViewById(R.id.btNext);
        radioG=(RadioGroup)findViewById(R.id.radioGroup);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.dialog_message).setTitle(R.string.dialog_title).setPositiveButton("OK",new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        final AlertDialog dialog = builder.create();
        final ArrayList<Question> q=new ArrayList<>();
        q.add(new Question("Do you love me ?",0));
        q.add(new Question("Do you hate me ?",0));
        q.add(new Question("Do you want to fuck me ?",0));
        q.add(new Question("Do you boo me ?",0));
        q.add(new Question("Do you look at me ?",0));
        onBind(q);
        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int select=radioG.getCheckedRadioButtonId();
                if(select!=-1){
                    int point=0;
                    point=getPoint(select);
                    if(position<q.size()-1) {
                        position++;
                        onBind(q, select);
                    }else{
                        dialog.show();
                        //setContentView(R.layout.activity_main);
                    }
                }
            }
        });
    }
    private void onBind(ArrayList<Question> q){
        txtQuestion.setText(q.get(position).getQuestion());
        txtpages.setText(position+"/65");
    }
    private void onBind(ArrayList<Question> q,int selected){
        txtQuestion.setText(q.get(position).getQuestion());
        txtpages.setText((position+1)+"/65");
        radioG.clearCheck();
    }
    private int getPoint(int selected){
        switch(selected){
            case R.id.btInteresting:
                return 3;
            case R.id.btInterest:
                return 2;
            case R.id.btNormal:
                return 1;
            case R.id.btNotInteresting:
                return 0;

        }
        return 0;
    }
    private final int totalProgressTime = 100;
    Runnable r=new Runnable() {
        @Override
        public void run() {
            int jumpTime = 0;
            while(jumpTime < totalProgressTime) {
                try {
                    Thread.sleep(100);
                    jumpTime += 5;
                    progress.setProgress(jumpTime);
                }
                catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    };
    public void showProgressDialog(View view){
        progress=new ProgressDialog(this);
        progress.setMessage("Please Wait for a few minute");
        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progress.setIndeterminate(true);
        progress.setProgress(0);
        progress.show();
        Thread t=new Thread(r);
        t.start();
    }
}
