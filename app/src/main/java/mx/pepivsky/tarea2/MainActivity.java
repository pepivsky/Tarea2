package mx.pepivsky.tarea2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button = (Button) findViewById(R.id.btnSiguiente);

        final EditText nombre = (EditText) findViewById(R.id.editTextNombre);
        final DatePicker fecha = (DatePicker) findViewById(R.id.datePicker2);
        final EditText telefono = (EditText) findViewById(R.id.editTextTelefono);
        final EditText email = (EditText) findViewById(R.id.editTextEmail);
        final EditText descripcion = (EditText) findViewById(R.id.editTextDescripcion);

        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            nombre.setText(extras.getString("nombre"));
            telefono.setText(extras.getString("telefono"));
            email.setText(extras.getString("email"));
            descripcion.setText(extras.getString("descripcion"));
        }

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), confirmar_datos.class);
                intent.putExtra("nombre",nombre.getText().toString());
                String sFecha= fecha.getDayOfMonth()+"/"+fecha.getMonth()+"/"+fecha.getYear();
                intent.putExtra("fecha",sFecha);
                intent.putExtra("telefono",telefono.getText().toString());
                intent.putExtra("email",email.getText().toString());
                intent.putExtra("descripcion",descripcion.getText().toString());
                startActivity(intent);
            }
        });
    }
}