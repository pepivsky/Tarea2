package mx.pepivsky.tarea2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class confirmar_datos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);
        final Button buttonEditar = (Button) findViewById(R.id.btnEditar);

        final TextView tvNombre = (TextView) findViewById(R.id.textNombre);
        final TextView tvFecha = (TextView) findViewById(R.id.textFecha);
        final TextView tvTelefono = (TextView) findViewById(R.id.textTelefono);
        final TextView tvEmail = (TextView) findViewById(R.id.textEmail);
        final TextView tvDescripcion = (TextView) findViewById(R.id.textDesc);

        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            tvNombre.setText(extras.getString("nombre"));
            tvFecha.setText(extras.getString("fecha"));
            tvTelefono.setText(extras.getString("telefono"));
            tvEmail.setText(extras.getString("email"));
            tvDescripcion.setText(extras.getString("descripcion"));
        }

        buttonEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("nombre",tvNombre.getText().toString());
                intent.putExtra("fecha",tvFecha.getText().toString());
                intent.putExtra("telefono",tvTelefono.getText().toString());
                intent.putExtra("email",tvEmail.getText().toString());
                intent.putExtra("descripcion",tvDescripcion.getText().toString());
                startActivity(intent);
            }
        });
    }
}
