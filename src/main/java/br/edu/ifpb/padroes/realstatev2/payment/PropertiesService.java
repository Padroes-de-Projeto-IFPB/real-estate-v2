package br.edu.ifpb.padroes.realstatev2.payment;

import br.edu.ifpb.padroes.realstatev2.domain.Apartment;
import br.edu.ifpb.padroes.realstatev2.domain.Bungalow;
import br.edu.ifpb.padroes.realstatev2.domain.CompoundProperty;
import br.edu.ifpb.padroes.realstatev2.domain.Tenement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class PropertiesService {

    private final PaymentService paymentService;

    public void payProperties() {

        Apartment apartment = new Apartment();
        apartment.setAddress("Rua x");
        apartment.setBuilder("Apartamento construtura");
        apartment.setPrice(BigDecimal.valueOf(200000));

        Bungalow bungalow = new Bungalow();
        bungalow.setAddress("Rua y");
        bungalow.setBuilder("Bangalô construtura");
        bungalow.setPrice(BigDecimal.valueOf(150000));

        Tenement tenament = new Tenement();
        tenament.setAddress("Rua y");
        tenament.setBuilder("Cortiço construtura");
        tenament.setPrice(BigDecimal.valueOf(100000));

        // TODO - reduzir chamadas múltiplas para uma única chamada para o método pay() utilizando o padrão composite
        paymentService.payProperties(apartment, bungalow, tenament);

    }

}
