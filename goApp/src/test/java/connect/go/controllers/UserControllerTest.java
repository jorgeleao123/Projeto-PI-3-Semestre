package connect.go.controllers;

import connect.go.Repositories.AddressRepository;
import connect.go.Repositories.FavoriteAddressRepository;
import connect.go.Repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@ExtendWith(SpringExtension.class)
class UserControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private FavoriteAddressRepository favoriteAddressRepository;

//    @Test
//    void successCreateUser() throws Exception {
//        String validUserRegistration = "{User:}";
//        MockHttpServletResponse response = mvc.perform(post("/users")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(validUserRegistration))
//                .andReturn().getResponse();
//        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
//        assertNotNull(userRepository.findAll());
//        assertNotNull(addressRepository.findAll());
//        assertNotNull(favoriteAddressRepository.findAll());
//    }
}