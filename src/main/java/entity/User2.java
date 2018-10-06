package entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @Author: ky
 * @Date: 2018/10/2 17:01
 */
@JsonIgnoreProperties(value = {"password"})
public class User2 extends User {
}
