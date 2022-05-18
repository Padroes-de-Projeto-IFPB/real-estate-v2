package br.edu.ifpb.padroes.realstatev2.domain;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public class ComposeProperty implements Property {
    protected List<Property> children = new ArrayList<>();

    public void add(Property component) {
        getChildren().add(component);
    }

    public void add(Property... components) {
        getChildren().addAll(Arrays.asList(components));
    }

    public void remove(Property child) {
        getChildren().remove(child);
    }

    public void remove(Property... components) {
        getChildren().removeAll(Arrays.asList(components));
    }

    public void clear() {
        getChildren().clear();
    }


    @Override
    public BigDecimal getPrice() {
        BigDecimal total = new BigDecimal(0);

        if(this.children.size() == 0) {
            return total;
        }

        for(Property c: this.children) {
            total.add(c.getPrice());
        }

        return total;
    }
}
