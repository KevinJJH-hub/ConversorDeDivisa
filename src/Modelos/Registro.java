package Modelos;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Registro {
    private double cantidadACambiar;
    private String codigoDeMoneda;
    private double resultado;
    private String codigoDeMonedaCambio;
    private LocalDateTime fechaCreacion;

    public Registro(double cantidadACambiar, String codigoDeMoneda, double resultado, String codigoDeMonedaCambio) {
        this.cantidadACambiar = cantidadACambiar;
        this.codigoDeMoneda = codigoDeMoneda;
        this.resultado = resultado;
        this.codigoDeMonedaCambio = codigoDeMonedaCambio;
        this.fechaCreacion = LocalDateTime.now();
    }
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        DecimalFormat df = new DecimalFormat("#.##");
        return "──────────────────────────────────────────────────────────────────────────────────────────────────────────\n"+
                "El valor de " + cantidadACambiar + ' ' + codigoDeMoneda
                + " Corresponde al valor final de ==> " + df.format(resultado)+ " " + codigoDeMonedaCambio
                +" Fecha de convercion " + fechaCreacion.format(formatter)+"\n"
                +"──────────────────────────────────────────────────────────────────────────────────────────────────────────";
    }
}
