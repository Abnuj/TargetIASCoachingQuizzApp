package com.abnuj.targetiascoachinggovermentjobpreperationapp.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.abnuj.targetiascoachinggovermentjobpreperationapp.Database.DatabaseAccess;
import com.abnuj.targetiascoachinggovermentjobpreperationapp.Models.DatabaseQuizesmodel;
import com.abnuj.targetiascoachinggovermentjobpreperationapp.R;
import com.abnuj.targetiascoachinggovermentjobpreperationapp.Util.Constants;

import java.util.ArrayList;
import java.util.List;

import ticker.views.com.ticker.widgets.circular.timer.callbacks.CircularViewCallback;
import ticker.views.com.ticker.widgets.circular.timer.view.CircularView;

public class QuizActivity extends AppCompatActivity implements View.OnClickListener {
    List<DatabaseQuizesmodel> databaseQuizesmodelList = new ArrayList<>();
    DatabaseQuizesmodel databaseQuizesmodel;
    ticker.views.com.ticker.widgets.circular.timer.view.CircularView CircularView;
    TextView questionnumbertv, totalquestionnumbertv, questiontv, option1, option2, option3, option4, correctanswertv;
    Button previousbtn, nextbtn;
    DatabaseQuizesmodel quizesmodel;
    String correctAnswerString;
    Toolbar quizToolbar;
    Bundle bundle;DatabaseAccess databaseAccess;


    // Extra Numbers Require for our logic
    int questionIndex = 1;
    List<String> correctAnswerlist = new ArrayList<>();
    int correctanswer, wronganswer, totalquestionNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        bundle = getIntent().getExtras();
        databaseQuizesmodel  = new DatabaseQuizesmodel();
        //circular timer in our layout
        CircularView = (ticker.views.com.ticker.widgets.circular.timer.view.CircularView) findViewById(R.id.circular_view);

        CircularView.OptionsBuilder builderWithTimer =
                new CircularView.OptionsBuilder()
                        .shouldDisplayText(true)
                        .setCounterInSeconds(30)
                        .setCircularViewCallback(new CircularViewCallback() {
                            @Override
                            public void onTimerFinish() {

                                // Will be called if times up of countdown timer
                                Toast.makeText(QuizActivity.this, "CircularCallback: Timer Finished ", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onTimerCancelled() {

                                // Will be called if stopTimer is called
                                Toast.makeText(QuizActivity.this, "CircularCallback: Timer Cancelled ", Toast.LENGTH_SHORT).show();
                            }
                        });
        CircularView.setOptions(builderWithTimer);
        CircularView.startTimer();

        // TODO: Our coding starts from here
        initView();
        dataAccess();

            setdataToView(questionIndex);
            option1.setOnClickListener(this);
            option2.setOnClickListener(this);
            option3.setOnClickListener(this);
            option4.setOnClickListener(this);



    }

    private void setdataToView(int questionIndex) {


//        option1.setText(databaseQuizesmodel.get(questionIndex).getOption1().trim());
//        option2.setText(databaseQuizesmodel.get(questionIndex).getOption2().trim());
//        option3.setText(databaseQuizesmodel.get(questionIndex).getOption3().trim());
//        option4.setText(databaseQuizesmodel.get(questionIndex).getOption4().trim());
//        correctanswertv.setText(databaseQuizesmodel.get(questionIndex).getCorrectAnswer().trim());
//        correctAnswerString = databaseQuizesmodel.get(questionIndex).getCorrectAnswer();
//        correctAnswerlist.add(questionIndex, correctanswertv.getText().toString());

        databaseQuizesmodel = databaseAccess.getsinglequestiondata(1);

        option1.setText(databaseQuizesmodel.getOption1().trim());
        option2.setText(databaseQuizesmodel.getOption2().trim());
        option3.setText(databaseQuizesmodel.getOption3().trim());
        option4.setText(databaseQuizesmodel.getOption4().trim());
        correctanswertv.setText(databaseQuizesmodel.getCorrectAnswer().trim());
//        correctAnswerString = databaseQuizesmodel.getCorrectAnswer();
        correctAnswerlist.add(questionIndex, correctanswertv.getText().toString());
        questiontv.setText(databaseQuizesmodel.getQuestion());
        questionnumbertv.setText(String.valueOf(questionIndex + 1));
        if (option3.getText().toString() == correctAnswerString) {
            Toast.makeText(this, "All is well don't take tension", Toast.LENGTH_LONG).show();
        }
    }

    private void dataAccess() {

        Constants.SELECTEDSUBCATEGORY = bundle.getString(Constants.SELECTEDSUBCATEGORY);
//        getSupportActionBar().setTitle(Constants.SELECTEDSUBCATEGORY);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//                ********* Here we start database access **************



        databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
        databaseAccess.open();

    }

    private void initView() {
        correctanswertv = findViewById(R.id.correctAnswertv);
        questionnumbertv = findViewById(R.id.questionnumbertv);
        totalquestionnumbertv = findViewById(R.id.totalquestion);
        questiontv = findViewById(R.id.questiontv);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        nextbtn = findViewById(R.id.Nextbtn);
        previousbtn = findViewById(R.id.previousbtn);
        quizToolbar = findViewById(R.id.quiztoolbar);
        setSupportActionBar(quizToolbar);
        quizToolbar.setTitle(Constants.SELECTEDSUBCATEGORY);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.option1:
                Toast.makeText(QuizActivity.this, "option1 selected", Toast.LENGTH_SHORT).show();
                if (option1.getText().toString().equalsIgnoreCase(correctAnswerlist.get(questionIndex).trim())) {
                    Toast.makeText(QuizActivity.this, "you are correct", Toast.LENGTH_SHORT).show();
                }
                questionIndex++;
                setdataToView(questionIndex);
                break;


            case R.id.option2:
                Toast.makeText(QuizActivity.this, "option2 selected", Toast.LENGTH_SHORT).show();
                if (option2.getText().toString().equalsIgnoreCase(correctAnswerlist.get(questionIndex).trim())) {
                    Toast.makeText(QuizActivity.this, "you are correct", Toast.LENGTH_SHORT).show();
                }
                questionIndex++;
                setdataToView(questionIndex);
                break;


            case R.id.option3:
                Toast.makeText(QuizActivity.this, "option3 selected", Toast.LENGTH_SHORT).show();
                if (option3.getText().toString().equalsIgnoreCase(correctAnswerlist.get(questionIndex).trim())) {
                    Toast.makeText(QuizActivity.this, "you are correct", Toast.LENGTH_SHORT).show();
                }
                questionIndex++;
                setdataToView(questionIndex);
                break;


            case R.id.option4:
                Toast.makeText(QuizActivity.this, "option4 selected", Toast.LENGTH_SHORT).show();
                if (option4.getText().toString().equalsIgnoreCase(correctAnswerlist.get(questionIndex).trim())) {
                    Toast.makeText(QuizActivity.this, "you are correct", Toast.LENGTH_SHORT).show();
                }
                questionIndex++;
                setdataToView(questionIndex);
                break;

            case R.id.Nextbtn:
                questionIndex++;
                setdataToView(questionIndex);
                break;
        }
    }
}