package com.victorpinal.imdbapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Victor on 27/02/2015.
 */
public class NuevoItem extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nuevo_item);

        findViewById(R.id.btnGuardar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                guardarDatos();
                finish();
            }
        });
    }

    private void guardarDatos() {

    }

}
