package com.jkaru.microservice.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

//import javax.persistence.Id;
import org.springframework.data.annotation.Id;
import java.math.BigDecimal;

@Document(value = "product")
@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @Indexed
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
}
