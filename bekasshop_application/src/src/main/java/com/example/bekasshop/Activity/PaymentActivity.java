package com.example.bekasshop.Activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;


import com.example.bekasshop.R;
import com.example.bekasshop.Util.Singleton;

public class PaymentActivity extends AppCompatActivity {

    private TextView textAddress, totalprice;
    private Button btLocation, OrderPayment;
    public int priceR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        //Initialize layout_app
        btLocation = findViewById(R.id.bt_location);
        textAddress = findViewById(R.id.textAddress);
        totalprice = findViewById(R.id.totalprice);
        OrderPayment = findViewById(R.id.OrderPayment);
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);

        //get total price
        priceR = Singleton.getInstance().price;
        totalprice.setText("Rp. " + priceR);
        textAddress.setText(Singleton.getInstance().address);

        btLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Check permission
                if (ActivityCompat.checkSelfPermission(PaymentActivity.this
                        , Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    Intent intent = new Intent(PaymentActivity.this, MapActivity.class);
                    startActivity(intent);

                } else {
                    //When permission denied
                    ActivityCompat.requestPermissions(PaymentActivity.this
                            , new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
                }
            }
        });

        OrderPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox.isChecked() && !textAddress.getText().toString().isEmpty()) {
                    Toast.makeText(PaymentActivity.this, "Order Success!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(PaymentActivity.this, HomeActivity.class));
                }
                // do something
                else {
                    Toast.makeText(PaymentActivity.this, "Must check agree license and have address!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}