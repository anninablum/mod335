package annina.halloandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

import annina.halloandroid.ui.login.LoginActivity;

public class HomepageActivity extends AppCompatActivity {

//    @Override
//    protected void onStart() {
//        super.onStart();
//        setContentView(R.layout.app_bar_main);
//    }

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

        Button btn_login = findViewById(R.id.btn_HomepageLogin);
        btn_login.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
        });

//        Button nav = findViewById(R.id.btn_nav);
//        btn_login.setOnClickListener(v -> {
//            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
//            startActivity(intent);
//        });



    }
}
