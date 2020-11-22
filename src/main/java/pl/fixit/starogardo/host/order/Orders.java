package pl.fixit.starogardo.host.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.hibernate.criterion.Order;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@Entity

public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private BigDecimal price;

    private String description;

    private String consumentName;

    private String consumentSurname;

    private String consumentAdress;

    private Date deliveryTime;

    private long restaurantId;

    public Orders() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getConsumentName() {
        return consumentName;
    }

    public void setConsumentName(String consumentName) {
        this.consumentName = consumentName;
    }

    public String getConsumentSurname() {
        return consumentSurname;
    }

    public void setConsumentSurname(String consumentSurname) {
        this.consumentSurname = consumentSurname;
    }

    public String getConsumentAdress() {
        return consumentAdress;
    }

    public void setConsumentAdress(String consumentAdress) {
        this.consumentAdress = consumentAdress;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }
}
