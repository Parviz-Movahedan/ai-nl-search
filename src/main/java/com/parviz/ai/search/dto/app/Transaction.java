package com.parviz.ai.search.dto.app;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
public class Transaction {
      BigDecimal total;
      String serviceDescription;
      String doctorName;
      String doctorProfession;
}
