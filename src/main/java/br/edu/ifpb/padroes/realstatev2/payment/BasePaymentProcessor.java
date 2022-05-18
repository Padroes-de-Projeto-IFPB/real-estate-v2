package br.edu.ifpb.padroes.realstatev2.payment;

import br.edu.ifpb.padroes.realstatev2.domain.Property;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BasePaymentProcessor implements PaymentProcessor{
    protected PaymentProcessor next;

    @Override
    public PaymentProcessor linkWith(PaymentProcessor paymentProcessor) {
        this.next = paymentProcessor;
        return next;
    }

    public abstract void process(Property property);

    protected void processNext(Property property){
        if(next != null) {
            next.process(property);
        }
    }
}
