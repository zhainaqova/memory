package savchits.com.memory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RulesPage extends AppCompatActivity {
    ImageView rightWords,leftWords;
    ImageView rightTime,leftTime;
    Button start;
    TextView quantity,time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.my_rules);

        rightWords = findViewById (R.id.rightWords);
        leftWords = findViewById (R.id.leftWords);
        rightTime = findViewById (R.id.rightTime);
        leftTime = findViewById (R.id.leftTime);

        start = findViewById (R.id.start);

        quantity = findViewById (R.id.quantity);
        time = findViewById (R.id.quantity1);

        // change quantity of words
        leftWords.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {

            }
        } );
        // start game, go to game
        start.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
              Intent intent = new Intent (RulesPage.this,MainActivity.class);
              startActivity (intent);
            }
        } );
    }
}
