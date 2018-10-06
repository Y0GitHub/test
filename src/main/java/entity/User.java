package entity;

import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * @Author: ky
 * @Date: 2018/10/2 13:08
 */
@Entity
@Table(name="user")
public class User {

    private long QQ;



    private String password;


    @Id
    @Column(columnDefinition="bigint")
    public long getQQ() {
        return QQ;
    }

    public void setQQ(long QQ) {
        this.QQ = QQ;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
