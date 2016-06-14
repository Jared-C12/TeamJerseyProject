package example.pbuskell.com.teamjerseyproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CreditActivity extends AppCompatActivity {
private TextView txtvwShowCredits;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit);
        txtvwShowCredits = (TextView)findViewById(R.id.txtvwShowCredits);
        txtvwShowCredits.setText("Credits:" + "\nhttps://github.com/Jared-C12/EmployeeDatabase/blob/master/app/src/main/java/commrhardman23/httpsgithub/employeedatabase/EmployeeDatabaseHelper.java"
                + "\nhttps://github.com/Jared-C12/EmployeeDatabase/blob/master/app/src/main/java/commrhardman23/httpsgithub/employeedatabase/EmployeeDatabaseInterface.java"
        + "https://github.com/Jared-C12/PizzaSelector/blob/master/app/src/main/java/commrhardman23/httpsgithub/pizzaselector/CostCalculator.java");
    }
    public void backToMenu(View vw){
        Intent makeNewJersey = new Intent(getApplicationContext(),MainActivity.class);
        makeNewJersey.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(makeNewJersey);

    }
}
