package com.jvr.movimientos;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jvr.movimientos.persistence.entity.Cliente;
import com.jvr.movimientos.service.ClienteService;
import com.jvr.movimientos.service.dto.ClienteDto;
import com.jvr.movimientos.service.mapper.ClienteMapper;
import com.jvr.movimientos.web.controller.ClienteController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import static org.mockito.BDDMockito.given;

@WebMvcTest(ClienteController.class)
@AutoConfigureMockMvc
@AutoConfigureRestDocs(outputDir = "target/snippets")
public class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClienteService clienteService;

    @MockBean
    private ClienteMapper clienteMapper; // Mockeo del mapper si se utiliza dentro del controlador

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCreateNuevoCliente() throws Exception {
        ClienteDto clienteDto = new ClienteDto();  // Asume que tienes un constructor adecuado o setters
        clienteDto.setNombre("John Doe");
        clienteDto.setDireccion("1234 Elm Street");
        clienteDto.setTelefono("555-1234");
        clienteDto.setEstado(true);

       // given(clienteService.createNuevoCliente(any(ClienteDto.class))).willReturn(clienteDto);
       // given(clienteMapper.toDto(any(Cliente.class))).willReturn(clienteDto);  // Solo necesario si se realiza mapeo en el controlador

       // this.mockMvc.perform(get("/"))
        //        .andDo(print()).andExpect(status().isOk())
         //       .andDo(document("list"));
    }
}