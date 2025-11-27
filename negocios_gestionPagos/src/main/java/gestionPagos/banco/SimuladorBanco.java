/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionPagos.banco;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Abraham Coronel
 */
public class SimuladorBanco {

    private static SimuladorBanco instancia;

    private final Map<String, Double> tarjetasValidas;
    private final Map<String, String> cuentasDigitales;
    private final Map<String, Double> saldosDigitales;

    private SimuladorBanco() {
        tarjetasValidas = new HashMap<>();
        cuentasDigitales = new HashMap<>();
        saldosDigitales = new HashMap<>();

        // Tarjeta Valida
        tarjetasValidas.put("4000123456789010", 50000.00);
        tarjetasValidas.put("4000123456789000", 100.00);

        // Cuenta PayPal Valida
        cuentasDigitales.put("cliente@paypal.com", "1234");
        saldosDigitales.put("cliente@paypal.com", 10000.00);

        // Cuenta MercadoPago Valida
        cuentasDigitales.put("user@mercadopago.com", "mp123");
        saldosDigitales.put("user@mercadopago.com", 5000.00);
    }

    public static SimuladorBanco getInstancia() {
        if (instancia == null) {
            instancia = new SimuladorBanco();
        }
        return instancia;
    }

    public boolean autorizarPagoTarjeta(String numero, String cvv, double monto) {
        if (!tarjetasValidas.containsKey(numero)) {
            throw new RuntimeException("Tarjeta no existente o rechazada por el banco.");
        }

        if (!cvv.equals("123")) {
            throw new RuntimeException("CVV incorrecto.");
        }

        double saldo = tarjetasValidas.get(numero);
        if (saldo < monto) {
            throw new RuntimeException("Fondos insuficientes en la tarjeta.");
        }

        tarjetasValidas.put(numero, saldo - monto);
        return true;
    }

    public boolean autorizarPagoDigital(String correo, String contrasena, double monto) {
        if (!cuentasDigitales.containsKey(correo) || !cuentasDigitales.get(correo).equals(contrasena)) {
            throw new RuntimeException("Credenciales de cuenta digital incorrectas.");
        }

        double saldo = saldosDigitales.getOrDefault(correo, 0.0);
        if (saldo < monto) {
            throw new RuntimeException("Fondos insuficientes en la cuenta digital.");
        }

        saldosDigitales.put(correo, saldo - monto);
        return true;
    }
}
