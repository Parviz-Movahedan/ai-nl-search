package com.parviz.ai.search.dto.app;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
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
    List<Diagnosis> currentDiagnosed;
    String balanceTotal;
    List<Transaction> transactions;
}
