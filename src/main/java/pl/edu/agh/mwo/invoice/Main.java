package pl.edu.agh.mwo.invoice;

public class Main {
    public static void main(String[] args) {
        Invoice invoice = new Invoice();
        System.out.println(invoice.getInvoiceNumber());

        Invoice invoice2 = new Invoice();
        System.out.println(invoice2.getInvoiceNumber());

        Invoice invoice3 = new Invoice();
        System.out.println(invoice3.getInvoiceNumber());
    }
}
