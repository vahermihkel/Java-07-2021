package ee.mihkel.webshopbackend.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Item {
    @Id
    @GeneratedValue
    private Long id;
    @ApiModelProperty(value = "Link from web to display item image")
    private String imgSrc;
    private String title;
    private double price;
    @MeieAnnotation(key="itemCategory", value="brochures")
    private String category;
}
