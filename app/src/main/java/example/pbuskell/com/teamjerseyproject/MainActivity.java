package example.pbuskell.com.teamjerseyproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private RadioButton rbtnBasketball;
    private RadioButton rbtnVolleyball;
    private RadioButton rbtnSoccer;
    private RadioButton rbtnBaseball;
    private RadioButton rbtnFootball;
    private RadioButton rbtnTennis;
    private RadioButton rbtnHockey;
    private RadioButton rbtnBadminton;
    private RadioButton rbtnGolf;
    private RadioButton rbtnDodgeball;
    private TextView txtvwOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rbtnBasketball = (RadioButton)findViewById(R.id.rbtnBasketball);
        rbtnVolleyball = (RadioButton)findViewById(R.id.rbtnVolleyball);
        rbtnSoccer = (RadioButton)findViewById(R.id.rbtnSoccer);
        rbtnBaseball = (RadioButton)findViewById(R.id.rbtnBaseball);
        rbtnFootball = (RadioButton)findViewById(R.id.rbtnFootball);
        rbtnTennis = (RadioButton)findViewById(R.id.rbtnTennis);
        rbtnHockey = (RadioButton)findViewById(R.id.rbtnHockey);
        rbtnBadminton = (RadioButton)findViewById(R.id.rbtnBadminton);
        rbtnGolf = (RadioButton)findViewById(R.id.rbtnGolf);
        rbtnDodgeball = (RadioButton)findViewById(R.id.rbtnDodgeball);
        txtvwOutput = (TextView)findViewById(R.id.txtvwOutput);
    }
    public void onClick(View vw) {
        Intent jerseyInfo = new Intent(this, JerseyInformation.class);
        if (!rbtnBasketball.isChecked() && !rbtnVolleyball.isChecked() && !rbtnSoccer.isChecked()
                && !rbtnBaseball.isChecked() && !rbtnFootball.isChecked() && !rbtnTennis.isChecked()
                && !rbtnHockey.isChecked() && !rbtnBadminton.isChecked() && !rbtnGolf.isChecked()
                && !rbtnDodgeball.isChecked()) {
            txtvwOutput.setText("You must select a sport!");
        } else {
            if (rbtnBasketball.isChecked()) {
                jerseyInfo.putExtra("SPORT", "BASKETBALL");
            } else if (rbtnVolleyball.isChecked()) {
                jerseyInfo.putExtra("SPORT", "VOLLEYBALL");
            } else if (rbtnSoccer.isChecked()) {
                jerseyInfo.putExtra("SPORT", "SOCCER");
            } else if (rbtnBaseball.isChecked()) {
                jerseyInfo.putExtra("SPORT", "BASEBALL");
            } else if (rbtnFootball.isChecked()) {
                jerseyInfo.putExtra("SPORT", "FOOTBALL");
            } else if (rbtnTennis.isChecked()) {
                jerseyInfo.putExtra("SPORT", "TENNIS");
            } else if (rbtnHockey.isChecked()) {
                jerseyInfo.putExtra("SPORT", "HOCKEY");
            } else if (rbtnBadminton.isChecked()) {
                jerseyInfo.putExtra("SPORT", "BADMINTON");
            } else if (rbtnGolf.isChecked()) {
                jerseyInfo.putExtra("SPORT", "GOLF");
            } else {
                jerseyInfo.putExtra("SPORT", "DODGEBALL");
            }
            startActivityForResult(jerseyInfo, 0);
        }
    }
}
