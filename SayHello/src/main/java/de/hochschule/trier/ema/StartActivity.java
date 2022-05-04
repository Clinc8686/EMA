package de.hochschule.trier.ema;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class StartActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {
    private TextToSpeech tts;
    private EditText TextZuSprechen;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitiy_start);
        TextZuSprechen = (EditText) findViewById(R.id.editTextZuSprechen);

        tts = new TextToSpeech(this, this);
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            tts.setLanguage(Locale.GERMAN);
        }
    }

    public void clicked(View view) {
        if (TextZuSprechen.getText().length() > 0) {
            tts.speak(TextZuSprechen.getText(), TextToSpeech.QUEUE_FLUSH, null, "Test");
        } else {
            tts.speak("Gib einen Text ein", TextToSpeech.QUEUE_FLUSH, null, "Test");
        }
    }

    public void changeLanguage(View view) {
        if (tts.getVoice().getLocale() == Locale.GERMAN) {
            tts.setLanguage(Locale.ENGLISH);
        } else {
            tts.setLanguage(Locale.GERMAN);
        }
    }
}
