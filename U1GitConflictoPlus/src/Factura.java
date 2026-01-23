public class Factura {

    public static final String VERSION_OBJETIVO = "PENDIENTE";

    private static final double IVA = 0.16;
    private static final double PRECIO_UNITARIO = 1200.0;

    public static double calcularTotal(int cantidad) {
        double subtotal = cantidad * PRECIO_UNITARIO;
        return subtotal + (subtotal * IVA);
    }
}