package br.edu.ifpb.padroes.realstatev2.payment;

import br.edu.ifpb.padroes.realstatev2.domain.Property;
import br.edu.ifpb.padroes.realstatev2.payment.processors.GovernmentTaxesPayment;
import br.edu.ifpb.padroes.realstatev2.payment.processors.PropertyPayment;
import br.edu.ifpb.padroes.realstatev2.payment.processors.RealEstatePayment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentService {

    private final GovernmentTaxesPayment governmentTaxesPayment;
    private final RealEstatePayment      realEstatePayment;
    private final PropertyPayment        propertyPayment;

    public void pay(Property sale) {
        this.governmentTaxesPayment.next(realEstatePayment)
                                   .next(propertyPayment);

        this.governmentTaxesPayment.process(sale);
    }

    public void pay(List<Property> sales) {
        for (Property property: sales) {
            this.pay(property);
        }
    }

}
