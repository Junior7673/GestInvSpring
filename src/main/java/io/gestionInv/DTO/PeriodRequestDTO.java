package io.gestionInv.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PeriodRequestDTO {
    private LocalDate date1;
    private LocalDate date2;
}
