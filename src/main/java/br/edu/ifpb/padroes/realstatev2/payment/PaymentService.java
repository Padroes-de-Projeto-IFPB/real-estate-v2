package br.edu.ifpb.padroes.realstatev2.payment;

import br.edu.ifpb.padroes.realstatev2.domain.CompoundProperty;
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

    private CompoundProperty allProperties = new CompoundProperty();

    public void pay(Property sale) {

        // TODO - implementar Chain of Responsibility para que ordem dos métodos de pagamento seja dinâmica (definida em tempo de execução)

        governmentTaxesPayment.linkWith(realEstatePayment);
        realEstatePayment.linkWith(propertyPayment);
        governmentTaxesPayment.process(sale);

    }

    public void payProperties(Property... properties) {
        allProperties.clear();
        allProperties.add(properties);
        for (Property property: properties){
            this.pay(property);
        }

    }



}
