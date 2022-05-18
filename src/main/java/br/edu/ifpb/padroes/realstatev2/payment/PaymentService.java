package br.edu.ifpb.padroes.realstatev2.payment;

import br.edu.ifpb.padroes.realstatev2.domain.ComposeProperty;
import br.edu.ifpb.padroes.realstatev2.domain.Property;
import br.edu.ifpb.padroes.realstatev2.payment.processors.GovernmentTaxesPayment;
import br.edu.ifpb.padroes.realstatev2.payment.processors.PropertyPayment;
import br.edu.ifpb.padroes.realstatev2.payment.processors.RealEstatePayment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final GovernmentTaxesPayment governmentTaxesPayment;
    private final RealEstatePayment realEstatePayment;
    private final PropertyPayment propertyPayment;
    private final ComposeProperty property = new ComposeProperty();

    public void pay(Property sale) {

        governmentTaxesPayment.setNext(realEstatePayment);
        realEstatePayment.setNext(propertyPayment);

        governmentTaxesPayment.process(sale);

    }


    public void pay(Property... properties) {
        property.clear();
        property.add(properties);
        for (Property p: properties) {
            this.pay(p);
        }
    }

}
