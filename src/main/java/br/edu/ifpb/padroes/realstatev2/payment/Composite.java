package br.edu.ifpb.padroes.realstatev2.payment;

import br.edu.ifpb.padroes.realstatev2.domain.Property;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class Composite implements Property {

    private List<Property> properties = new ArrayList<>();

    public void add(Property property) {
        this.properties.add(property);
    }

    public void add(Property ... property) {
        this.properties.addAll(Arrays.asList(property));
    }

    public void delete(Property property) {
        this.properties.remove(property);
    }

    @Override
    public BigDecimal getPrice() {
        BigDecimal total = BigDecimal.ZERO;

        for (Property property : this.properties) {
            total.add(property.getPrice());
        }

        return total;
    }

}
