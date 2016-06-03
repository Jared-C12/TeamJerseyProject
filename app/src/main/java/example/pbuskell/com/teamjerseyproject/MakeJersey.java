package example.pbuskell.com.teamjerseyproject;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MakeJersey extends AppCompatActivity {
    private String userName;
    private String userNumber;
    private String teamName;
    private String typeJersey;
    private String colorJersey;
    private ImageView imgvwtTypeJersey;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_jersey);
        userName = getIntent().getStringExtra("USERNAME");
        userNumber = getIntent().getStringExtra("USERNUMBER");
        teamName = getIntent().getStringExtra("TEAMNAME");
        typeJersey = getIntent().getStringExtra("TYPEJERSEY");
        colorJersey = getIntent().getStringExtra("COLORJERSEY");
        imgvwtTypeJersey = (ImageView)findViewById(R.id.imgvwShirt);

        if(typeJersey.equals("SHIRT")){
            if(colorJersey.equals("WHITE")) {
                imgvwtTypeJersey.setImageResource(getResources().getIdentifier("whitejerseyshirt", "drawable", MakeJersey.this.getPackageName()));
            }else if(colorJersey.equals("RED")){
                imgvwtTypeJersey.setImageResource(getResources().getIdentifier("redjerseyshirt", "drawable", MakeJersey.this.getPackageName()));
            }else{
                imgvwtTypeJersey.setImageResource(getResources().getIdentifier("blackjerseyshirt", "drawable", MakeJersey.this.getPackageName()));
            }
        }else if(teamName.equals("SLEEVES")){

        }else{

        }
    }
}
