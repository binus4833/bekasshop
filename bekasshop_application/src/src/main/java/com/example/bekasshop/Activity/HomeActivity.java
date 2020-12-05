package com.example.bekasshop.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

import com.example.bekasshop.R;

public class HomeActivity extends AppCompatActivity {

    ViewFlipper ImageC;
    LinearLayout btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btn = (LinearLayout) findViewById(R.id.all_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { all(); }});

        btn = (LinearLayout) findViewById(R.id.electronic_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { electronic(); }});

        btn = (LinearLayout) findViewById(R.id.fashion_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { fashion(); }});

        btn = (LinearLayout) findViewById(R.id.furniture_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { furniture(); }});

        btn = (LinearLayout) findViewById(R.id.automotive_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { automotive(); }});

        btn = (LinearLayout) findViewById(R.id.toys_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { toys(); }});

        int images[] = {R.drawable.slide1,R.drawable.slide2,R.drawable.slide3};

        ImageC = findViewById(R.id.flipperimage);

        for (int image: images){
            imageflip(image);
        }
    }

    public void imageflip(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);
        ImageC.addView(imageView);
    }
    public void all(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void furniture(){
        Intent intent = new Intent(this, CategoryActivity.class);
        intent.putExtra("itemCategory", "furniture");
        startActivity(intent);
    }

    public void fashion(){
        Intent intent = new Intent(this, CategoryActivity.class);
        intent.putExtra("itemCategory", "fashion");
        startActivity(intent);
    }

    public void electronic(){
        Intent intent = new Intent(this, CategoryActivity.class);
        intent.putExtra("itemCategory", "electronic");
        startActivity(intent);
    }

    public void automotive(){
        Intent intent = new Intent(this, CategoryActivity.class);
        intent.putExtra("itemCategory", "automotive");
        startActivity(intent);
    }

    public void toys(){
        Intent intent = new Intent(this, CategoryActivity.class);
        intent.putExtra("itemCategory", "toys");
        startActivity(intent);
    }

}