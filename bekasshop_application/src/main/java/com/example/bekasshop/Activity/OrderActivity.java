package com.example.bekasshop.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bekasshop.Adapter.DataAdapter;
import com.example.bekasshop.Model.JSONResponse;
import com.example.bekasshop.R;
import com.example.bekasshop.Retrofit.LoginInterface;
import com.example.bekasshop.Retrofit.RequestInterface;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;


public class OrderActivity extends AppCompatActivity {

    ImageView itemImg;
    TextView itemName, itemPrice;
    EditText itemQty;
    Button orderBtn;
    int resId, jmlQty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Intent intent = getIntent();

        itemImg = findViewById(R.id.imageView);
        itemName = findViewById(R.id.nameItem);
        itemPrice = findViewById(R.id.priceItem);
        itemQty = findViewById(R.id.editTextQuantity);
        orderBtn = findViewById(R.id.btnOrder);

        itemName.setText(intent.getExtras().getString("itemName"));
        Picasso.get()
                .load("http://192.168.1.5/Latihan/"+ intent.getExtras().getString("itemImage"))
                .into(itemImg);
        final int price = intent.getExtras().getInt("itemPrice");
        itemPrice.setText("Rp. " + price);

        orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(itemQty.getText().toString()) || Integer.parseInt(itemQty.getText().toString()) < 1){
                    Toast.makeText(getApplicationContext(), "Empty field and 0 not allowed!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(OrderActivity.this, OrderDetailActivity.class);

                    intent.putExtra("OrderItemPrice", price);
                    intent.putExtra("OrderItemQty", Integer.parseInt(itemQty.getText().toString()));
                    startActivity(intent);

                }
            }
        });

    }

    public void plus(View view){
        jmlQty = jmlQty + 1;
        text(jmlQty);
    }

    public void minus(View view){
        if (jmlQty > 0){
            jmlQty = jmlQty - 1;
            text(jmlQty);
        }
    }

    private void text(int jumlah){
        itemQty = findViewById(R.id.editTextQuantity);
        itemQty.setText("" + jumlah);
    }


}