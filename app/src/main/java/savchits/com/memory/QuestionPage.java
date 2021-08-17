package savchits.com.memory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class QuestionPage extends AppCompatActivity {
    ImageView back;
    @Override
    protected
    void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.question_activity);
        back = findViewById ( R.id.backIcon);
        back.setOnClickListener ( new View.OnClickListener () {
            @Override
            public
            void onClick(View v) {
                Intent intent = new Intent (QuestionPage.this,LevelPage.class);
                startActivity ( intent );
            }
        } );
    }
}
