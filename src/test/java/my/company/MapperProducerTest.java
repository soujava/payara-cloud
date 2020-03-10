package my.company;

import my.company.infrastructure.mapper.MapperProducer;
import org.javamoney.moneta.Money;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapperProducerTest {

    private ModelMapper mapper;

    @BeforeEach
    public void init() {
        MapperProducer producer = new MapperProducer();
        producer.init();
        this.mapper = producer.get();
    }

    @Test
    public void shouldConvertDTO() {
        UserDTO dto = new UserDTO();
        dto.setNickname("otaviojava");
        dto.setSalary("USD 10000");
        dto.setBirthday(LocalDate.now().toString());
        dto.setLanguages(Collections.singletonList("Portuguese"));

        User user = mapper.map(dto, User.class);
        assertEquals("otaviojava", user.getNickname());
        assertEquals(LocalDate.now(), user.getBirthday());
        assertEquals(Money.parse("USD 10000"), user.getSalary());
        assertEquals(dto.getLanguages(), user.getLanguages());

    }

    @Test
    public void shouldConvertUser() {
        UserDTO dto = new UserDTO();
        dto.setNickname("otaviojava");
        dto.setSalary("USD 10000");
        dto.setBirthday(LocalDate.now().toString());
        dto.setLanguages(Collections.singletonList("Portuguese"));

        User user = mapper.map(dto, User.class);
        UserDTO userDTO = mapper.map(user, UserDTO.class);
        assertEquals("otaviojava", user.getNickname());
        assertEquals(LocalDate.now(), user.getBirthday());
        assertEquals(Money.parse("USD 10000"), user.getSalary());

    }
}
