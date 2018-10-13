package entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
    private int version;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getCommodityId() {
        return commodityId;
    }
    @Version
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public void setCommodityId(long commodityId) {
        this.commodityId = commodityId;
    }
    @NotEmpty(message = "用户名不能为空")
    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }
    @Digits(integer = 8,fraction = 2,message = "数字超出范围了！")
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
