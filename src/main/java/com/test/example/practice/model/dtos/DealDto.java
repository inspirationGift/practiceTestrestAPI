package com.test.example.practice.model.dtos;

import com.test.example.practice.model.Client;
import com.test.example.practice.model.Invoice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DealDto {
    private int id;
    private float volume;
    private LocalDateTime dateCreate;
    private String type;
    private Set<Client> client;
    private List<Invoice> invoice;


    @Data
    public static class DealsWrapper {
        List<DealDto> records;
        Long totalElements;
        Long totalPages;

        public DealsWrapper() {
            this.records = new ArrayList<>();
        }

        public void setRecord(DealDto record) {
            this.records.add(record);
        }
    }
}
