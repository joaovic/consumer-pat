package br.com.alelo.consumer.pat.entity;


import br.com.alelo.consumer.pat.payload.CreateConsumerPayload;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Consumer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String documentNumber;
    private LocalDate birthDate;

    //contacts
    private String mobilePhoneNumber;
    private String residencePhoneNumber;
    private String phoneNumber;
    private String email;

    //Address
    private String street;
    private Integer number;
    private String city;
    private String country;
    private Integer portalCode;

    //cards
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "consumer_id")
    private List<Card> cards = new ArrayList<>();

    public static Consumer from(CreateConsumerPayload consumer) {
        return Consumer.builder()
            .name(consumer.getName())
            .documentNumber(consumer.getDocumentNumber())
            .birthDate(consumer.getBirthDate())
            .mobilePhoneNumber(consumer.getMobilePhoneNumber())
            .residencePhoneNumber(consumer.getResidencePhoneNumber())
            .phoneNumber(consumer.getPhoneNumber())
            .email(consumer.getEmail())
            .street(consumer.getStreet())
            .number(consumer.getNumber())
            .city(consumer.getCity())
            .country(consumer.getCountry())
            .portalCode(consumer.getPortalCode())
            .build();
    }

}
