package uz.wh.db.entities.documentation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;
import uz.wh.db.entities.base.DocumentEntity;

import javax.persistence.*;

@Entity
@Table(name = "document_items")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Item extends DocumentEntity {

    @Nullable
    @Column(name = "product_id")
    private int productId;

    @Nullable
    @Column(name = "document_id")
    private String documentId;

    @Nullable
    @Column(name = "cost")
    private double cost;

    @Nullable
    @Column(name = "price")
    private double price;

    @Nullable
    @Column(name = "quantity_income")
    private double quantityIncome;

    @Nullable
    @Column(name = "quantity_order")
    private double quantityOrder;

    @Nullable
    @Column(name = "quantity_outgo")
    private double quantityOutgo;

    @Nullable
    @Column(name = "quantity_return")
    private double quantityReturn;

}
