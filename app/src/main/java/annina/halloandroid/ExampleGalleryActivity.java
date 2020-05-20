package annina.halloandroid;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class ExampleGalleryActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.example_gallery);

        ArrayList<ExampleItem> exampleList = new ArrayList<>();
//        exampleList.add(new ExampleItem(CamaraActivity.getOutputMediaFile(1));
//        exampleList.add(new ExampleItem();

        exampleList.add(new ExampleItem(R.drawable.ic_logo, "Title / Filename", "Location", "Date & Time"));
        exampleList.add(new ExampleItem(R.drawable.ic_android, "Title / Filename", "Location", "Date & Time"));
        exampleList.add(new ExampleItem(R.drawable.ic_logo, "Title / Filename", "Location", "Date & Time"));
        exampleList.add(new ExampleItem(R.drawable.ic_android, "Title / Filename", "Location", "Date & Time"));
        exampleList.add(new ExampleItem(R.drawable.ic_logo, "Title / Filename", "Location", "Date & Time"));
        exampleList.add(new ExampleItem(R.drawable.ic_android, "Title / Filename", "Location", "Date & Time"));

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(exampleList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);


    }
}
