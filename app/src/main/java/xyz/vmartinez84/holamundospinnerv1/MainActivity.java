package xyz.vmartinez84.holamundospinnerv1;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

import xyz.vmartinez84.holamundospinnerv1.models.EstadoModel;
import xyz.vmartinez84.holamundospinnerv1.services.ApiCallback;
import xyz.vmartinez84.holamundospinnerv1.services.CodigoPostalService;

public class MainActivity extends AppCompatActivity {

    //1.- Declarar el control o compnente
    Spinner spinner;
    CodigoPostalService service = new CodigoPostalService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 2.- Enlazarlo con la vista
        spinner = findViewById(R.id.spinner);
        cargarEstados();
    }

    public  void  cargarEstados(){
        service.obtenerTodosLosEstados(new ApiCallback<List<EstadoModel>>() {
            @Override
            public void onSuccess(List<EstadoModel> estados) {
                //Con esta instrucción recargamos la vista desde segundo plano
                runOnUiThread(()->{
                    llenarSpinner(estados);
                });
            }

            @Override
            public void onError(String errorMessage) {

            }
        });
    }

    public void llenarSpinner(List<EstadoModel> estados){
        estados.add(0, new EstadoModel(0, "Seleccione "));
        ArrayAdapter<EstadoModel> adapter = new ArrayAdapter<>(
          this,
                android.R.layout.simple_spinner_dropdown_item,
                estados
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}