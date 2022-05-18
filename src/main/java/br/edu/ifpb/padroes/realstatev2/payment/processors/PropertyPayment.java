package br.edu.ifpb.padroes.realstatev2.payment.processors;

import br.edu.ifpb.padroes.realstatev2.domain.Property;
import br.edu.ifpb.padroes.realstatev2.payment.BasePaymentProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service
public class PropertyPayment extends BasePaymentProcessor {
    @Override
    public void process(Property property) {
        log.info(String.format("Pay %f for the property taxes", property.getPrice()));

        processNext(property);
    }
}
