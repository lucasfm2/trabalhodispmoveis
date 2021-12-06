package com.ucsal.trabalhodispmoveis;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CloseActivity extends MainActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Button btn1 = (Button) findViewById(R.id.end);
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
                System.exit(0);
            }
        });
    }
}