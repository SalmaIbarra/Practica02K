package com.example.practica02k

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val txtCmc = findViewById<EditText>(R.id.txtcm) as EditText;
        val txtKg=findViewById<EditText>(R.id.txtkg) as EditText;
        val txtImc=findViewById<EditText>(R.id.txtimc)as EditText;
        val btnCalcular=findViewById<Button>(R.id.btnCalcular) as Button;
        val btnCerrar=findViewById<Button>(R.id.btnCerar) as Button;
        val btnLimpiar=findViewById<Button>(R.id.btnLimpiar) as Button;

        var cm=0.0;
        var kg=0.0;
        var imc=0.0;

        btnLimpiar.setOnClickListener(View.OnClickListener {
            txtKg.setText("");
            txtImc.setText("");
            txtCmc.setText("");
        })


        btnCalcular.setOnClickListener(View.OnClickListener {
            if(txtCmc.text.toString().equals("") && txtKg.text.toString().equals(""))
            {
                Toast.makeText(this@MainActivity,"Hay campos vacios", Toast.LENGTH_SHORT).show();
            }
            else{
                cm=txtCmc.text.toString().toDouble();
                kg=txtKg.text.toString().toDouble();
                cm=cm/100;
                val formato = DecimalFormat("#.##")
                imc=kg/(cm*cm);
                txtImc.setText((formato.format(imc)));

            }

        });



        btnCerrar.setOnClickListener(View.OnClickListener {

            finish();
        })
    }

}