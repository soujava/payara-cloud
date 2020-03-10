package my.company;

import javax.money.MonetaryAmount;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class UserDTO {

    private String nickname;

    private String salary;

    private List<String> languages;

    private String birthday;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "nickname='" + nickname + '\'' +
                ", salary='" + salary + '\'' +
                ", languages=" + languages +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
