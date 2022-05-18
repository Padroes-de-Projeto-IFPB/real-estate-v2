package br.edu.ifpb.padroes.realstatev2.payment;

import br.edu.ifpb.padroes.realstatev2.domain.Apartment;
import br.edu.ifpb.padroes.realstatev2.payment.processors.GovernmentTaxesPayment;
import br.edu.ifpb.padroes.realstatev2.payment.processors.PropertyPayment;
import br.edu.ifpb.padroes.realstatev2.payment.processors.RealEstatePayment;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.math.BigDecimal;

import static org.mockito.Mockito.inOrder;

@SpringBootTest
public class PaymentServiceTest {

    @SpyBean
    private PaymentService paymentService;

    @SpyBean
    private GovernmentTaxesPayment governmentTaxesPayment;
    @SpyBean
    private RealEstatePayment realEstatePayment;
    @SpyBean
    private PropertyPayment propertyPayment;

    @Test
    public void testPay() {
        Apartment property = new Apartment();
        property.setAddress("Rua primeiro de maio");
        property.setBuilder("ABC Construtora");
        property.setPrice(BigDecimal.valueOf(200_000));

        paymentService.pay(property);

        InOrder inOrder = inOrder(governmentTaxesPayment, realEstatePayment, propertyPayment);
        inOrder.verify(governmentTaxesPayment).process(property);
        inOrder.verify(realEstatePayment).process(property);
        inOrder.verify(propertyPayment).process(property);
    }

}
