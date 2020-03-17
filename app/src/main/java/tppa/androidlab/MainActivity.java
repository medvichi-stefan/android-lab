package tppa.androidlab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;

public class MainActivity extends AppCompatActivity {

    protected int dataToSave;
    final String LOGTAG = "Main Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int currentOrientation = getResources().getConfiguration().orientation;

        super.onCreate(savedInstanceState);
        // recovering the instance state
        if (savedInstanceState != null) {
            dataToSave = savedInstanceState.getInt("dataToSave");
        }

        setContentView(R.layout.activity_main);
        Log.i(LOGTAG, "onCreate");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt("dataToSave", dataToSave);

        // call superclass to save any view hierarchy
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(LOGTAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(LOGTAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(LOGTAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(LOGTAG, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(LOGTAG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(LOGTAG, "onDestroy");
    }
}
