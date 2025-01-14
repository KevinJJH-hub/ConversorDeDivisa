package Principal;

import Modelos.ApiClient;
import Modelos.Archivo;
import Modelos.Registro;
import Modelos.TasaDeCambio;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura = new Scanner(System.in);
        int seleccionDeCambio = 0;
        Archivo archivo = new Archivo();
        while (seleccionDeCambio != 7) {
            System.out.println("""
                    ╔═══════════════════════════════════════════════╗
                    ║             Conversor de Divisas              ║
                    ║   Inserte el número de la opción requerida.   ║
                    ╠═══════════════════════════════════════════════╣
                    ║   1. Dólar a Peso Mexicano                    ║
                    ║   2. Peso Mexicano a Dólar                    ║
                    ║   3. Dólar a Peso colombiano                  ║
                    ║   4. Peso colombiano a Dólar                  ║
                    ║   5. Dólar a Corona sueca                     ║
                    ║   6. Corona sueca a Dólar                     ║
                    ║   7. Salir                                    ║
                    ║   8. Mostrar conversiones pasadas             ║
                    ╚═══════════════════════════════════════════════╝
                    """);
            try {
                seleccionDeCambio = lectura.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número de opcion:");
                lectura.nextLine();
            }
            if (seleccionDeCambio < 1 || seleccionDeCambio > 8) {
                seleccionDeCambio = 0;
                System.out.println("Seleccione una opcion valida");
            } else if (seleccionDeCambio == 7) {
                System.out.println("""
                        Hasta luego
                        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                        ⣿⣿⣿⣿⣿⣿⣿⡿⢿⣿⣿⣿⠀⣿⣿⣿⡿⠻⣿⣿⣿⣿⣿⣿⣿
                        ⣿⣿⣿⣿⣿⣿⣿⣷⡈⠻⣿⣿⠀⣿⣿⡟⢁⣾⣿⣿⣿⣿⣿⣿⣿
                        ⣿⣿⣿⡿⠏⠀⠙⣿⣿⣦⣿⣿⣿⣿⣿⣤⣿⣿⠋⠀⠹⢿⣿⣿⣿
                        ⣿⡿⠇⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠸⢿⣿
                        ⣿⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⣿
                        ⣿⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⣿
                        ⣿⠀⠀⠀⠀⠀⠀⠀⠸⠛⠉⠉⠿⠉⠉⠛⠇⠀⠀⠀⠀⠀⠀⠀⣿
                        ⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣴⣿⣦⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹
                        ⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿
                        ⣿⣧⠀⠀⠀⠀⠀⠀⣠⣾⣿⣿⣿⣿⣿⣷⣄⠀⠀⠀⠀⠀⠀⣼⣿
                        ⣿⣿⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⣿⣿
                        ⣿⣿⣀⣀⣀⣀⣀⣀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣀⣀⣀⣀⣀⣀⣿⣿""");
                break;
            } else if (seleccionDeCambio == 8) {
                if (archivo.getListaDeRegistros().size() == 0) {
                    System.out.println("Sin registros");
                } else {
                    System.out.println("Historial de converciones: ");
                    List<Registro> listaDeRegistros = archivo.getListaDeRegistros();
                    for (int i = 0; i < listaDeRegistros.size(); i++) {
                        System.out.println(listaDeRegistros.get(i));
                    }
                }
            } else {
                String codigoDeMoneda = "null";
                String codigoDeMonedaCambio = "null";
                switch (seleccionDeCambio) {
                    case 1:
                        codigoDeMoneda = "USD";
                        codigoDeMonedaCambio = "MXN";
                        break;
                    case 2:
                        codigoDeMoneda = "MXN";
                        codigoDeMonedaCambio = "USD";
                        break;
                    case 3:
                        codigoDeMoneda = "USD";
                        codigoDeMonedaCambio = "COP";
                        break;
                    case 4:
                        codigoDeMoneda = "COP";
                        codigoDeMonedaCambio = "USD";
                        break;
                    case 5:
                        codigoDeMoneda = "USD";
                        codigoDeMonedaCambio = "SEK";
                        break;
                    case 6:
                        codigoDeMoneda = "SEK";
                        codigoDeMonedaCambio = "USD";
                        break;
                    case 8:
                        if (archivo.getListaDeRegistros().size() == 0) {
                            System.out.println("Sin registros");
                        } else {
                            System.out.println(archivo.getListaDeRegistros());
                            break;
                        }
                }

                System.out.println("Ingresa el valor que seas convertir: ");
                double cantidadACambiar = lectura.nextDouble();

                String direccion = "https://v6.exchangerate-api.com/v6/cbe350f1bc3edebb53996dd6/latest/" + codigoDeMoneda;
                ApiClient apiClient = new ApiClient();
                TasaDeCambio tasaDeCambio = apiClient.ObtenerJsonObjeto(direccion);

                double tasaValorCambio = tasaDeCambio.getConversionRates().get(codigoDeMonedaCambio);
                double resultado = (cantidadACambiar * tasaValorCambio);

                Registro registro = new Registro(cantidadACambiar, codigoDeMoneda, resultado, codigoDeMonedaCambio);

                System.out.println(registro);
                archivo.agragarAlista(registro);
            }
        }
    }
}
