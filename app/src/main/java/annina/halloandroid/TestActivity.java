package annina.halloandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TestActivity extends AppCompatActivity {

    private TextView nachricht;
    private Button weiterFertig;
    private EditText eingabe;
    private boolean ersterKlick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nachricht = findViewById(R.id.nachricht);
        weiterFertig = findViewById(R.id.weiter_fertig);
        eingabe = findViewById(R.id.eingabe);

        eingabe.setOnEditorActionListener((v, actionId, event) -> {
            if (weiterFertig.isEnabled()) {
                weiterFertig.performClick();
            }
            return true;
        });

        nachricht.setText(R.string.willkommen);
        weiterFertig.setText(R.string.weiter);

        ersterKlick = true;
        nachricht.setText((R.string.willkommen));
        weiterFertig.setText(R.string.weiter);

        weiterFertig.setOnClickListener(v -> {
            if (ersterKlick = true) {
                nachricht.setText(getString(R.string.hallo, eingabe.getText()));
                eingabe.setVisibility(View.INVISIBLE);
                weiterFertig.setVisibility(View.INVISIBLE);
                ersterKlick = false;
            } else {
                finish();
            }

        });
        eingabe.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                weiterFertig.setEnabled(s.length() > 0);
            }
        });
        weiterFertig.setEnabled(false);
    }

}
