package project.bmigenerator.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String surname;

    private Double weigth;
    private Double heigth;
    private String sex;

    private String bmi;
    private String comment;

    public User(String name, String surname,
                Double weigth, Double heigth) {
        this.name = name;
        this.surname = surname;
        this.weigth = weigth;
        this.heigth = heigth;
    }

    public void bmiCounter(){
        Double bmi=weigth/heigth/heigth*10000;
        if(bmi<16) comment="wygłodzenie";
        else if(bmi<16.99) comment="wychudzenie";
        else if(bmi<18.49) comment="niedowaga";
        else if(bmi<24.99) comment="wartość prawidłowa";
        else if(bmi<29.99) comment="nadwaga";
        else if(bmi<34.99) comment="I stopień otyłości";
        else if(bmi<39.99) comment="II stopień otyłości";
        else if(bmi>=40) comment="otyłości skrajna";
        this.bmi = String.format("%.2f",bmi);
    }

    public static List<User> getList(Iterable<User> users){ //na potrzeby testów
        List<User> usersList = new ArrayList<>();
        for (User user : users) {
            usersList.add(user);
        }
        return usersList;
    }

}