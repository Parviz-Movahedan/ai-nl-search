package com.parviz.ai.search.dto.app;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Document
public class Patient extends Response{
    @Id
    String id;
    String firstName;
    String middleName;
    String lastName;
    List<PhoneNumber> phoneNumbers;
    List<Address> addresses;
    List<PaymentInfo> paymentInfos;
    List<String> currentSymptoms;
    @DBRef(lazy = true)
    List<Diagnosis> currentDiagnosed;
    String balanceTotal;
    @DBRef(lazy = true)
    List<Transaction> transactions;
}
