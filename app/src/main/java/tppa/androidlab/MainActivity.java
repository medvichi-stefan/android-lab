package tppa.androidlab;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

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
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.main_menu_login:
                loginUser();
                return true;
            case R.id.main_menu_contact:
                showContact();
                return true;
            case R.id.main_menu_settings:
                showSettings();
                return true;
            case R.id.main_menu_save:
                saveInternalStorage();
            case R.id.main_menu_sensors:
                showSensors();
                return true;
            case R.id.main_menu_camera:
                showCamera();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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

    protected void loginUser() {
        // create an alert builder
        AlertDialog.Builder loginAlert = new AlertDialog.Builder(this);
        loginAlert.setTitle("Login");
        // set the custom layout
        final View loginAlertLayout = getLayoutInflater().inflate(R.layout.login_alert, null);
        loginAlert.setView(loginAlertLayout);
        // add a button
        loginAlert.setPositiveButton("Login", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // send data from the AlertDialog to the Activity
                /*EditText editText = loginAlertLayout.findViewById(R.id.editText);
                Toast.makeText(this, editText.getText().toString(), Toast.LENGTH_SHORT).show();*/
            }
        })
        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

            }
        });

        // create and show the alert dialog
        AlertDialog dialog = loginAlert.create();
        dialog.show();
    }

    protected void showContact() {
        Intent intent = new Intent(this, Contact.class);
        startActivity(intent);
    }

    protected void showSettings() {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }

    protected void saveInternalStorage() {
        String filename = "user_save";
        String fileContents = "Saved string";
        try {
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), filename);
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(fileContents.getBytes());
            fos.flush();
            fos.close();
        } catch (IOException e) {

        }
    }

    protected void showSensors() {
        Intent intent = new Intent(this, SensorActivity.class);
        startActivity(intent);
    }

    protected void showCamera() {
        Intent intent = new Intent(this, CameraActivity.class);
        startActivity(intent);
    }
}
