package br.edu.ifpb.padroes.realstatev2.payment;

import br.edu.ifpb.padroes.realstatev2.domain.Property;

public abstract class PaymentProcessor {
    private PaymentProcessor next;

    public PaymentProcessor next(PaymentProcessor next) {
        this.next = next;
        return next;
    }

    public abstract void process(Property property);

    protected void checkProx(Property property) {
        if (this.next != null) {
            next.process(property);
        }
    }

}
