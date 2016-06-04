package adil.note.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import adil.note.R;

/**
 * Created by Moin Adil on 6/4/2016.
 */
public class NoteDetails extends AppCompatActivity{
    private Button mButton;
    private Button m2Button;
    private EditText mEditText;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_node_details);
        init();
    }

    private void init() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mButton          = (Button) findViewById(R.id.edit);
        mButton.setOnClickListener(new Listener());
        m2Button          = (Button) findViewById(R.id.done);
        m2Button.setOnClickListener(new Listener());
        mEditText        = (EditText) findViewById(R.id.edittxt2);
        mTextView        = (TextView) findViewById(R.id.txt1);
    }
    class Listener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            if (mButton.getId() == v.getId()) {
                //startActivity(new Intent(NoteDetails.this, NoteDetails.class));
                mTextView.setVisibility(View.GONE);
                mEditText.setVisibility(View.VISIBLE);
                m2Button.setVisibility(View.VISIBLE);
            }
            if (m2Button.getId() == v.getId()) {
                startActivity(new Intent(NoteDetails.this, MainActivity.class));
            }
        }
    }

}