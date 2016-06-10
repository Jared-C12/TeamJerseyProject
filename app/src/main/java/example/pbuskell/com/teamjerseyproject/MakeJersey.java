package example.pbuskell.com.teamjerseyproject;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MakeJersey extends AppCompatActivity {
    private String userName;
    private int userNumber;
    private String teamName;
    private String typeJersey;
    private String colorJersey;
    private ImageView imgvwtTypeJersey;
    private TextView txtvwName;
    private TextView txtvwNumber;
    private TextView txtvwTeamName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_jersey);
        userName = getIntent().getStringExtra("USERNAME");
        teamName = getIntent().getStringExtra("TEAMNAME");
        typeJersey = getIntent().getStringExtra("TYPEJERSEY");
        colorJersey = getIntent().getStringExtra("COLORJERSEY");
        userNumber = getIntent().getIntExtra("USER_NUM",0);
        imgvwtTypeJersey = (ImageView)findViewById(R.id.imgvwShirt);
        txtvwName = (TextView)findViewById(R.id.txtvwName);
        txtvwNumber = (TextView)findViewById(R.id.txtvwNumber);
        txtvwTeamName = (TextView)findViewById(R.id.txtvwTeamName);

        //checks which type and color of jersey the user selected
        if(typeJersey.equals("SHIRT")){
            if(colorJersey.equals("WHITE")) {
                imgvwtTypeJersey.setImageResource(getResources().getIdentifier("whitejerseyshirt", "drawable", MakeJersey.this.getPackageName()));
                txtvwName.setTextColor(Color.BLACK);
                txtvwTeamName.setTextColor(Color.BLACK);
                txtvwNumber.setTextColor(Color.BLACK);
            }else if(colorJersey.equals("RED")){
                imgvwtTypeJersey.setImageResource(getResources().getIdentifier("redjerseyshirt", "drawable", MakeJersey.this.getPackageName()));
                txtvwName.setTextColor(Color.BLACK);
                txtvwTeamName.setTextColor(Color.BLACK);
                txtvwNumber.setTextColor(Color.BLACK);
            }else{
                imgvwtTypeJersey.setImageResource(getResources().getIdentifier("blackjerseyshirt", "drawable", MakeJersey.this.getPackageName()));
                txtvwName.setTextColor(Color.WHITE);
                txtvwTeamName.setTextColor(Color.WHITE);
                txtvwNumber.setTextColor(Color.WHITE);
            }
        }else if(typeJersey.equals("SLEEVES")){
            if(colorJersey.equals("WHITE")) {
                imgvwtTypeJersey.setImageResource(getResources().getIdentifier("whitejerseysleeves", "drawable", MakeJersey.this.getPackageName()));
                txtvwName.setTextColor(Color.BLACK);
                txtvwTeamName.setTextColor(Color.BLACK);
                txtvwNumber.setTextColor(Color.BLACK);
            }else if(colorJersey.equals("RED")){
                imgvwtTypeJersey.setImageResource(getResources().getIdentifier("redjerseysleeves", "drawable", MakeJersey.this.getPackageName()));
                txtvwName.setTextColor(Color.BLACK);
                txtvwTeamName.setTextColor(Color.BLACK);
                txtvwNumber.setTextColor(Color.BLACK);
            }else{
                imgvwtTypeJersey.setImageResource(getResources().getIdentifier("blackjerseysleeves", "drawable", MakeJersey.this.getPackageName()));
                txtvwName.setTextColor(Color.WHITE);
                txtvwTeamName.setTextColor(Color.WHITE);
                txtvwNumber.setTextColor(Color.WHITE);
            }
        }
        else{

        }

        //puts the information to textviews
        txtvwName.setText(userName);
        txtvwTeamName.setText(teamName);
        txtvwNumber.setText(userNumber + "");

    }
}
