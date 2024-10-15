public class ConversorMoneda {

    public double convertirValorMoneda(String moneda1, String moneda2, double valor){
        double valorConvertido = 0;
        Moneda moneda = ConsultaTasaCambio.consultaMoneda(moneda1, moneda2);
        if (moneda != null){
            valorConvertido = valor * moneda.conversionRate();
        }else {
            throw new RuntimeException("No se pudo convertir el valor");
        }
        return valorConvertido;
    }
}
