package br.edu.ifpb.padroes.realstatev2.payment;

import br.edu.ifpb.padroes.realstatev2.domain.Property;

public abstract class PaymentProcessor {
    private PaymentProcessor next;

    public abstract void process(Property property);

    public void setNext(PaymentProcessor next) {
        this.next = next;
    }

    protected void checkNext(Property property) {
        if (this.next != null) {
            next.process(property);
        }
    }
}
