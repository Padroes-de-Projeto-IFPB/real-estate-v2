package br.edu.ifpb.padroes.realstatev2.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompoundProperty implements Property{
    protected List<Property> children = new ArrayList<>();

    public CompoundProperty(Property... components) {
        add(components);
    }

    public void add(Property component) {
        children.add(component);
    }

    public void add(Property... components) {
        children.addAll(Arrays.asList(components));
    }

    public void remove(Property child) {
        children.remove(child);
    }

    public void remove(Property... components) {
        children.removeAll(Arrays.asList(components));
    }

    public void clear() {
        children.clear();
    }

    @Override
    public BigDecimal getPrice() {
        BigDecimal total =  new BigDecimal(0.00);

        if(children.isEmpty()){
            return total;
        }

        for (Property child : children){
            total.add(child.getPrice());
        }

        return total;
    }
}
