package my.company;

import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Convert;
import jakarta.nosql.mapping.Entity;
import jakarta.nosql.mapping.Id;
import my.company.infrastructure.MonetaryAmountAttributeConverter;

import javax.money.MonetaryAmount;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Entity
public class User {

    @Id
    private String nickname;

    @Column
    @Convert(MonetaryAmountAttributeConverter.class)
    private MonetaryAmount salary;

    @Column
    private List<String> languages;

    @Column
    private LocalDate birthday;

    public String getNickname() {
        return nickname;
    }

    public MonetaryAmount getSalary() {
        return salary;
    }

    public List<String> getLanguages() {
        if(languages == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(languages);
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void update(User update) {

    }
}
