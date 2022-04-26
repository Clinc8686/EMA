package de.hochschule.trier.ema;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class StartActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {
    private TextToSpeech tts;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitiy_start);

        tts = new TextToSpeech(this, this);
        findViewById(R.id.btnVorlesen).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText TextZuSprechen = (EditText) findViewById(R.id.editTextZuSprechen);
                if (TextZuSprechen.getText().length() > 0) {
                    tts.speak(TextZuSprechen.getText(), TextToSpeech.QUEUE_FLUSH, null, "Test");
                } else {
                    tts.speak("Gib einen Text ein", TextToSpeech.QUEUE_FLUSH, null, "Test");
                }

            }
        });
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            tts.setLanguage(Locale.GERMAN);
        }
    }
}
