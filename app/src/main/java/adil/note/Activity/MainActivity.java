package adil.note.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import adil.note.Adapter.MyNoteAdapter;
import adil.note.R;

public class MainActivity extends AppCompatActivity {
    private Context mContext;
    private MyNoteAdapter lMyNoteAdapter;
    private RecyclerView mMyNoteList;
    private Button mButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        init();
    }

    private void init() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mMyNoteList      = (RecyclerView) findViewById(R.id.my_note_list);
        mButton          = (Button) findViewById(R.id.create);
        mButton.setOnClickListener(new Listener());
        setMyNoteList();
    }
    private void setMyNoteList() {
        lMyNoteAdapter = new MyNoteAdapter(MainActivity.this);
        mMyNoteList.setLayoutManager(new LinearLayoutManager(this));
        mMyNoteList.setAdapter(lMyNoteAdapter);
    }
    class Listener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            if (mButton.getId() == v.getId()) {
                startActivity(new Intent(MainActivity.this, NoteDetails.class));
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
