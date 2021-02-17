package trius.springframework.commands;


import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class ProductForm {
    private String id;
    @NotEmpty(message = "Please Enter Name.")
    @Size(max = 255, message = "Please Enter Maximum 255 Characters.")
    //@Pattern(regexp = "[\\p{L}{3,}]", message = "Name Sadece Harflerden Oluşabilir")
    private String name;
    @NotEmpty(message = "Please Enter Description.") //String değişkene notnull yazınca boş olsa da sorun olmuyordu.
    @Size(max = 255, message = "Please Enter Maximum 255 Characters.")
    //@Pattern(regexp = "[\\p{L}{3,}]", message = "Description Sadece Harflerden Oluşabilir")
    private String description;
    @NotNull(message = "Please Enter Price.")
    @Range(min = 0, max = 99999, message = "Please Enter Maximum 5 Digits.")
    private BigDecimal price;
    @NotNull(message = "Please Enter Stock.")
    @Range(min = 0, max = 99999, message = "Please Enter Maximum 5 Digits.")
    private BigDecimal stock;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getStock() {
        return stock;
    }

    public void setStock(BigDecimal stock) {
        this.stock = stock;
    }

}
