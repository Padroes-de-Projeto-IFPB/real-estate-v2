package br.edu.ifpb.padroes.realstatev2.payment;

import br.edu.ifpb.padroes.realstatev2.domain.Apartment;
import br.edu.ifpb.padroes.realstatev2.domain.Bungalow;
import br.edu.ifpb.padroes.realstatev2.domain.CompoundProperty;
import br.edu.ifpb.padroes.realstatev2.domain.Tenement;
import br.edu.ifpb.padroes.realstatev2.payment.processors.GovernmentTaxesPayment;
import br.edu.ifpb.padroes.realstatev2.payment.processors.PropertyPayment;
import br.edu.ifpb.padroes.realstatev2.payment.processors.RealEstatePayment;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import javax.swing.*;
import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.inOrder;

@SpringBootTest
public class PropertiesServiceTest {

    @SpyBean
    private PropertiesService propertiesService;

    @SpyBean
    private PaymentService paymentService;

    @Test
    void testPay() {
        propertiesService.payProperties();

        InOrder inOrder = inOrder(paymentService);
        inOrder.verify(paymentService).pay(any(Apartment.class));
        inOrder.verify(paymentService).pay(any(Bungalow.class));
        inOrder.verify(paymentService).pay(any(Tenement.class));
    }

}
