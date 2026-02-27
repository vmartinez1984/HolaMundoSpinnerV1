package xyz.vmartinez84.holamundospinnerv1.services;

import java.util.ArrayList;
import java.util.List;

import xyz.vmartinez84.holamundospinnerv1.models.EstadoModel;

public class CodigoPostalService {
    public List<EstadoModel> obtenerTodosLosEstados(){
        List<EstadoModel> estados = new ArrayList<>();

        estados.add(new EstadoModel(1, "Ciudad de México"));
        estados.add(new EstadoModel(2, "Estado de México"));

        return estados;
    }
}
