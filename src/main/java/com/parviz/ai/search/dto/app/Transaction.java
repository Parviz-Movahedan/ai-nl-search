package com.parviz.ai.search.dto.app;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@Document
public class Transaction {
      BigDecimal total;
      String serviceDescription;
      String doctorName;
      String doctorProfession;
}
