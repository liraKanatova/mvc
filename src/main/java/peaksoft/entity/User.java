package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_gen")
    @SequenceGenerator(name = "user_gen",sequenceName = "user_seq",allocationSize = 1)
    private Long id;
    private String fullName;
    private String email;
    private int age;
    private String photo;
    @OneToMany(cascade = {MERGE,REFRESH,DETACH})
    private List<House> houses;
    public void addHouse(House house) {
        if (house != null) {
            houses.add(house);
        } else {
            throw new NullPointerException();
        }
    }

    public User(String fullName, String email, int age,String photo) {
        this.fullName = fullName;
        this.email = email;
        this.age = age;
        this.photo = photo;
    }
}
