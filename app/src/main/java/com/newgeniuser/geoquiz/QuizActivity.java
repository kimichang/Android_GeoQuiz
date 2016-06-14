package com.newgeniuser.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private Button mPrevButton;
    private TextView mQuestionTextView;
    private Question[] mQuestionBank=new Question[]{
            new Question(R.string.question_oceans,true),
            new Question(R.string.question_africa,false),
            new Question(R.string.question_mideast,false),
            new Question(R.string.question_americas,true),
            new Question(R.string.question_asia,true)
    };
    private int mCurrentIndex=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        mQuestionTextView=(TextView)findViewById(R.id.question_text_view);
        mNextButton=(Button)findViewById(R.id.mext_button);
        mPrevButton=(Button)findViewById(R.id.pre_button);
     //   int question=mQuestionBank[mCurrentIndex].getTextResId();
      //  mQuestionTextView.setText(question);
        mTrueButton=(Button)findViewById(R.id.true_button);
        mFalseButton=(Button)findViewById(R.id.false_button);
        mTrueButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
         //       Toast.makeText(QuizActivity.this,"true_button clicked!",Toast.LENGTH_SHORT).show();
                checkAnswer(true);
            }
        });
        mFalseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
            //    Toast.makeText(QuizActivity.this,"false_button clicked!",Toast.LENGTH_LONG).show();
                checkAnswer(false);
            }
        });

        mNextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // Toast.makeText(QuizActivity.this,R.string.correct_toast,Toast.LENGTH_SHORT).show();
                mCurrentIndex=(mCurrentIndex+1)%mQuestionBank.length;
                //      int question=mQuestionBank[mCurrentIndex].getTextResId();
                //      mQuestionTextView.setText(question);
                updateQuestion();
            }
        });

        mPrevButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // Toast.makeText(QuizActivity.this,R.string.correct_toast,Toast.LENGTH_SHORT).show();
                if(mCurrentIndex!=0)
                mCurrentIndex=(mCurrentIndex-1)%mQuestionBank.length;
                else
                    mCurrentIndex=(mCurrentIndex+mQuestionBank.length-1)%mQuestionBank.length;
                //      int question=mQuestionBank[mCurrentIndex].getTextResId();
                //      mQuestionTextView.setText(question);
                updateQuestion();
            }
        });
       updateQuestion();
    }

    private void updateQuestion(){
        int question=mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
    }

    private void checkAnswer(boolean userPressedTrue){
        boolean answerIsTrue=mQuestionBank[mCurrentIndex].isAnswerTrue();
        int messageResId;
        if(userPressedTrue==answerIsTrue){
            messageResId=R.string.correct_toast;
        }
        else{
            messageResId=R.string.incorrect_toast;
        }
        Toast.makeText(this,messageResId,Toast.LENGTH_LONG).show();
    }

   /* @Override
    public boolean onCreateOptionMenu(Menu menu){
        getMenuInflater().inflate(R.menu)
    }*/
}
