package de.htw.foodnet.register;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class RegisterControllerTest {
    MockMvc mockMvc;
    private RegisterService registerService;

    @BeforeEach
    void setUp() {
        registerService = mock(RegisterService.class);
        RegisterController registerController = new RegisterController(registerService);
        mockMvc = MockMvcBuilders.standaloneSetup(registerController).build();
    }
    @Test
    void getRegisterPage() throws Exception {
        mockMvc.perform(get("/register")).andExpect(status().is2xxSuccessful());
    }

    @Test
    void postRegister() throws Exception {
        when(registerService.registerUser(null,null)).thenReturn(true);
        mockMvc.perform(post("/register")).andExpect(status().is3xxRedirection());
        verify(registerService).registerUser(any(),any());
    }
}