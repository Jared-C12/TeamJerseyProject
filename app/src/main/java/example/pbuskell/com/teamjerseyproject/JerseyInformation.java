package example.pbuskell.com.teamjerseyproject;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.AsyncTask;
import android.preference.EditTextPreference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.sql.SQLException;

public class JerseyInformation extends AppCompatActivity {
    private String sport;
    private TextView txtvwInput;
    private String selectedSport;
    private EditText edtxtUserName;
    private EditText edtxtUserNumber;
    private EditText edtxtTeamName;
    private RadioButton rbtnShirt;
    private RadioButton rbtnTankTop;
    private RadioButton rbtnSleeves;
    private RadioButton rbtnRed;
    private RadioButton rbtnWhite;
    private RadioButton rbtnBlack;
    private TextView txtvwOutput2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jersey_information);
        sport = getIntent().getStringExtra("SPORT");
        txtvwInput = (TextView)findViewById(R.id.txtvwInput);
        edtxtUserName = (EditText)findViewById(R.id.edtxtUserName);
        edtxtUserNumber = (EditText)findViewById(R.id.edtxtUserNumber);
        edtxtTeamName = (EditText)findViewById(R.id.edtxtTeamName);
        rbtnShirt = (RadioButton)findViewById(R.id.rbtnShirt);
        rbtnSleeves = (RadioButton)findViewById(R.id.rbtnSleeves);
        rbtnTankTop = (RadioButton)findViewById(R.id.rbtnTankTop);
        rbtnRed = (RadioButton)findViewById(R.id.rbtnRed);
        rbtnBlack = (RadioButton)findViewById(R.id.rbtnBlack);
        rbtnWhite = (RadioButton)findViewById(R.id.rbtnWhite);
        txtvwOutput2 = (TextView)findViewById(R.id.txtvwOutput2);

        // checks the sleceted sport
        if(sport.equals("BASKETBALL")){
            selectedSport = "Basketball";
        }
        else if (sport.equals("VOLLEYBALL")){
            selectedSport = "Volleyball";
        }
        else if(sport.equals("SOCCER")){
            selectedSport = "Soccer";
        }
        else if(sport.equals("BASEBALL")){
            selectedSport = "Baseball";
        }
        else if (sport.equals("FOOTBALL")){
            selectedSport = "Football";
        }
        else if (sport.equals("TENNIS")){
            selectedSport = "Tennis";
        }
        else if(sport.equals("HOCKEY")){
            selectedSport = "Hockey";
        }
        else if (sport.equals("BADMINTON")){
            selectedSport = "Badminton";
        }
        else if(sport.equals("GOLF")){
            selectedSport = "Golf";
        }
        else{
            selectedSport = "Dodgeball";
        }
        txtvwInput.setText("You selected " + selectedSport + ":");
    }

    public void makeJerseyClick(View vw)
    {
        if(edtxtUserName.getText().length()==0 || edtxtUserNumber.getText().length()==0
                || edtxtTeamName.getText().length() == 0 || (!rbtnShirt.isChecked()
                && !rbtnSleeves.isChecked() && !rbtnTankTop.isChecked())|| (!rbtnRed.isChecked()
                && !rbtnWhite.isChecked() && !rbtnBlack.isChecked())){

            txtvwOutput2.setText("You must enter all the values to add an element! ");

        }else{
            new JerseyTask().execute();
        }

    }

    public void makeJersey(){
        Intent makeJersey = new Intent(this,MakeJersey.class);
        JerseyDatabase jerseyDatabase = new JerseyDatabase(this,null,null,0);
        SQLiteDatabase db = null;
        String userName;
        int userNumber;
        String teamName;
        ContentValues jerseyValues = new ContentValues();

        userName = edtxtUserName.getText().toString();
        userNumber = Integer.parseInt(edtxtUserNumber.getText().toString());
        teamName = edtxtTeamName.getText().toString();
        //sends the information to MakeJersey activty
        makeJersey.putExtra("USERNAME", userName);
        makeJersey.putExtra("USER_NUM", userNumber);
        makeJersey.putExtra("TEAMNAME", teamName);
        // gets the information from the radiobuttons(Types of Jersey)
        if (rbtnShirt.isChecked()) {
            makeJersey.putExtra("TYPEJERSEY", "SHIRT");
        } else if (rbtnSleeves.isChecked()) {
            makeJersey.putExtra("TYPEJERSEY", "SLEEVES");
        } else {
            makeJersey.putExtra("TYPEJERSEY", "TANKTOP");
        }
        //gets the information from the radiobuttons(Color of Jersey)
        if(rbtnRed.isChecked()){
            makeJersey.putExtra("COLORJERSEY","RED");
        }
        else if(rbtnWhite.isChecked()){
            makeJersey.putExtra("COLORJERSEY","WHITE");
        }else{
            makeJersey.putExtra("COLORJERSEY","BLACK");
        }

        //sends the information to the database
        try {
            db = jerseyDatabase.getWritableDatabase();
            jerseyValues.put("USERNAME",userName);
            jerseyValues.put("USER_NUM",userNumber);
            jerseyValues.put("TEAMNAME",teamName);
            db.close();
        }catch(SQLiteException e){
        }
        startActivityForResult(makeJersey, 0);
    }
    private class JerseyTask extends AsyncTask<Void,Void,Void>
    {
        @Override
        protected Void doInBackground(Void... params) {
            makeJersey();
            return null;
        }
    }
}
