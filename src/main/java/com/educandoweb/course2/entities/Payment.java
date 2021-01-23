package com.educandoweb.course2.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Jonas created 23/01/2021
 */
@Entity
@Table(name = "tb_payment")//Anotatio to put a new name to table 
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id //Declarando chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant moment;

    //Mapeando a class dependente
    @OneToOne
    @MapsId
    private Order order;

    //COSNTRUTOR
    public Payment() {
    }

    //CONSTRUCTOR SOBRECARREGADO
    public Payment(Long id, Instant moment, Order order) {
        super();
        this.id = id;
        this.moment = moment;
        this.order = order;
    }

    //EQUALS AND HASHCODE
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Payment other = (Payment) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    //GET AND SET
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
    
}
