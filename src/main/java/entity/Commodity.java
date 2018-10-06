package entity;

import javax.persistence.*;

/**
 * @Author: ky
 * @Date: 2018/10/2 16:04
 */
@Entity
@Table(name = "commodity")
public class Commodity {
    private long commodityId;
    private String commodityName;
    private double commodityPrice;
    private String commodityDescription;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(long commodityId) {
        this.commodityId = commodityId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public double getCommodityPrice() {
        return commodityPrice;
    }

    public void setCommodityPrice(double commodityPrice) {
        this.commodityPrice = commodityPrice;
    }

    public String getCommodityDescription() {
        return commodityDescription;
    }

    public void setCommodityDescription(String commodityDescription) {
        this.commodityDescription = commodityDescription;
    }
}
