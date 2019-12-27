package com.practise.googlenewspractiseusingmvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.practise.googlenewspractiseusingmvvm.Model.Articles;
import com.practise.googlenewspractiseusingmvvm.Model.NewsResponse;
import com.practise.googlenewspractiseusingmvvm.Model.source;
import com.practise.googlenewspractiseusingmvvm.ViewModels.MainActiviteViewModel;
import com.practise.googlenewspractiseusingmvvm.adapter.newsAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    MainActiviteViewModel viewModel;
    newsAdapter adapter;
RecyclerView recyclerView;
FloatingActionButton fab;
    private boolean fabExpanded = false;
    private FloatingActionButton fabSettings;
    private LinearLayout layoutFabSave;
    private LinearLayout layoutFabEdit;
    private LinearLayout layoutFabPhoto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recylarview);


        fabSettings = findViewById(R.id.fabSetting);

        layoutFabSave = findViewById(R.id.layoutFabSave);
        layoutFabEdit =findViewById(R.id.layoutFabEdit);
        layoutFabPhoto = findViewById(R.id.layoutFabPhoto);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        layoutFabEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //"business", "8a72ef51ea9c463bbce9eb97955b8283"
//                viewModel.getNewsresponse();
                viewModel.loadNews("business");

            }
        });
        layoutFabPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        viewModel.loadNews("health");
            }
        });

        fabSettings.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if (fabExpanded == true){
            closeSubMenusFab();
        } else {
            openSubMenusFab();
        }
    }
});
        viewModel = ViewModelProviders.of(this).get(MainActiviteViewModel.class);
     viewModel.getNewsresponse().observe(this, new Observer<NewsResponse>() {

    @Override
    public void onChanged(NewsResponse newsResponse) {
//        List<Articles> list=;
        updateRecyclarview(newsResponse.getArticles());

    }
});




    }

    private void updateRecyclarview(List<Articles> articles) {
        adapter=new newsAdapter(articles, this);
        recyclerView.setAdapter(adapter);
    }
    private void closeSubMenusFab(){
        layoutFabSave.setVisibility(View.INVISIBLE);
        layoutFabEdit.setVisibility(View.INVISIBLE);
        layoutFabPhoto.setVisibility(View.INVISIBLE);
        fabSettings.setImageResource(R.drawable.ic_settings_black_24dp);
        fabExpanded = false;
    }

    //Opens FAB submenus
    private void openSubMenusFab(){
        layoutFabSave.setVisibility(View.VISIBLE);
        layoutFabEdit.setVisibility(View.VISIBLE);
        layoutFabPhoto.setVisibility(View.VISIBLE);
        //Change settings icon to 'X' icon
        fabExpanded = true;
    }
}
