package savchits.com.memory;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import savchits.com.memory.databinding.ActivityCheckBinding;

public class CheckActivity extends AppCompatActivity {
    ActivityCheckBinding binding;
    int value1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCheckBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences sharedPreferences = getSharedPreferences ( "myKey", MODE_PRIVATE );
        value1 = sharedPreferences.getInt("life", 0);
        binding.imageButton.setText(value1 +"");
        binding.progressBar.setProgress(value1*20);

        binding.check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String word1 = binding.et1.getText().toString().trim().toLowerCase ();
                String word2 = binding.et2.getText().toString().trim().toLowerCase ();
                String word3 = binding.et3.getText().toString().trim().toLowerCase ();
                String word4 = binding.et4.getText().toString().trim().toLowerCase ();
                String word5 = binding.et5.getText().toString().trim().toLowerCase ();


                if(TextUtils.isEmpty(word1))
                {
                    binding.et1.setError("Пожалуйста, заполните все поля");
                    Toast.makeText(CheckActivity.this, "Пожалуйста, заполните все поля", Toast.LENGTH_SHORT).show();
                }
                if(TextUtils.isEmpty(word2)) {
                    binding.et2.setError("Пожалуйста, заполните все поля");
                    Toast.makeText(CheckActivity.this, "Пожалуйста, заполните все поля", Toast.LENGTH_SHORT).show();
                }
                if(TextUtils.isEmpty(word3)) {
                    binding.et3.setError("Пожалуйста, заполните все поля");
                    Toast.makeText(CheckActivity.this, "Пожалуйста, заполните все поля", Toast.LENGTH_SHORT).show();
                }
                if(TextUtils.isEmpty ( word4 )) {
                    binding.et4.setError("Пожалуйста, заполните все поля");
                    Toast.makeText(CheckActivity.this, "Пожалуйста, заполните все поля", Toast.LENGTH_SHORT).show();
                }
                if(TextUtils.isEmpty(word5)) {
                    binding.et5.setError("Пожалуйста, заполните все поля");
                    Toast.makeText ( CheckActivity.this, "Пожалуйста, заполните все поля", Toast.LENGTH_SHORT ).show ();
                }

                else {
                    Intent intent = new Intent ( CheckActivity.this, ResultActivity.class);
                    intent.putExtra("word1", word1);
                    intent.putExtra("word2", word2);
                    intent.putExtra("word3", word3);
                    intent.putExtra("word4", word4);
                    intent.putExtra("word5", word5);
                    startActivity(intent);

                }
            }
        });
    }

}