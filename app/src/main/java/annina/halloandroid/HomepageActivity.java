package annina.halloandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class HomepageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        Button btn_camera = findViewById(R.id.btn_HomepageCamara);
        btn_camera.setOnClickListener(v -> {
            Intent intent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
            startActivity(intent);
        });

        Button btn_video = findViewById(R.id.btn_HomepageVideo);
        btn_video.setOnClickListener(v -> {
            Intent intent = new Intent(MediaStore.INTENT_ACTION_VIDEO_CAMERA);
            startActivity(intent);
        });

        Button btn_gallery = findViewById(R.id.btn_HomepageGallery);
        btn_gallery.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), ExampleActivity.class);
            startActivity(intent);
        });


    }
}
