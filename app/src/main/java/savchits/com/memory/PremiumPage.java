package savchits.com.memory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class PremiumPage extends AppCompatActivity {
    ImageView btn_back;
    @Override
    protected
    void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.premium_activity);
        btn_back = findViewById (R.id.back);
        btn_back.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (PremiumPage.this,LevelPage.class);
            }
        } );

    }
}
