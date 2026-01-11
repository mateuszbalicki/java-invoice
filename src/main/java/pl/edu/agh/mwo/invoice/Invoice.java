package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
    private Collection<Product> products;

    public Invoice() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) throws  IllegalArgumentException {
        if (product == null || product.equals("")) {
            throw new IllegalArgumentException();
        } else
            this.products.add(product);
    }

    public void addProduct(Product product, Integer quantity) throws  IllegalArgumentException {
        if (product == null || product.equals("")) {
            throw new IllegalArgumentException();
        } else if (quantity == null || quantity.equals("") || quantity == 0 || quantity < 0) {
            throw new IllegalArgumentException();
        } else
            for (int i = 0; i < quantity; i++) {
                this.products.add(product);
            }
    }

    public BigDecimal getSubtotal() {
        BigDecimal subtotal = BigDecimal.ZERO;
        for (Product product : products) {
            subtotal = subtotal.add(product.getPrice());
        }
        return subtotal;
    }

    public BigDecimal getTax() {
        BigDecimal tax = BigDecimal.ZERO;
        for (Product product : products) {
            tax = tax.add(product.getPriceWithTax().subtract(product.getPrice()));
        }
        return tax;
    }

    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (Product product : products) {
            total = total.add(product.getPriceWithTax());
        }
        return total;
    }
}
