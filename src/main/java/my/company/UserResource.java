package my.company;


import org.modelmapper.ModelMapper;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Path("users")
@RequestScoped
public class UserResource {

    @Inject
    private UserRepository repository;

    @Inject
    private ModelMapper mapper;

    @GET
    public List<UserDTO> findAll() {
        Stream<User> users = repository.findAll();
        return users
                .map(u -> mapper.map(u, UserDTO.class))
                .collect(Collectors.toList());
    }

    @GET
    @Path("one")
    public UserDTO one() {
        UserDTO dto = new UserDTO();
        dto.setNickname("otaviojava");
        dto.setSalary("USD 10000");
        dto.setBirthday(LocalDate.now().toString());
        dto.setLanguages(Collections.singletonList("Portuguese"));
        return dto;
    }
    @POST
    public UserDTO insert(UserDTO userDTO) {
        User user = mapper.map(userDTO, User.class);
        repository.save(user);
        return mapper.map(user, UserDTO.class);
    }

    @PUT
    @Path("{id}")
    public UserDTO insert(@PathParam("id") String id, UserDTO userDTO) {
        Optional<User> optional = repository.findById(id);

        User user = optional.orElseThrow(() -> new WebApplicationException(Response.Status.FOUND));
        User updatedUser = mapper.map(userDTO, User.class);
        updatedUser.update(user);
        repository.save(updatedUser);
        return mapper.map(updatedUser, UserDTO.class);
    }


    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") String id) {
        repository.deleteById(id);
    }


}
