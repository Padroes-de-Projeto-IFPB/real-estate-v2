package br.edu.ifpb.padroes.realstatev2.payment;

import br.edu.ifpb.padroes.realstatev2.domain.Property;

public interface PaymentProcessor {

    void process(Property property);

    PaymentProcessor linkWith(PaymentProcessor paymentProcessor);

}
