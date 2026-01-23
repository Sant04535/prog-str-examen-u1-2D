public class Main {

    public static void main(String[] args) {
        int cantidad = 3;

        double total = Factura.calcularTotal(cantidad);

        System.out.println("Version: " + Factura.VERSION_OBJETIVO);
        System.out.println("Total: " + total);
    }
}