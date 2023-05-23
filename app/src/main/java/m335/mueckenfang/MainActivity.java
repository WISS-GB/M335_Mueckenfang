package m335.mueckenfang;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final int GAME_REQUESTCODE = 335;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnStart = findViewById(R.id.btnStart);
        btnStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent gameIntent = new Intent(this, GameActivity.class);
        startActivityForResult(gameIntent, GAME_REQUESTCODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GAME_REQUESTCODE && resultCode == Activity.RESULT_OK) {
            int punkte = data.getIntExtra("punkte", 0);
            Log.d("M335", "Der Kandidat hat " + punkte + " Punkte erreicht!");
        }
    }
}