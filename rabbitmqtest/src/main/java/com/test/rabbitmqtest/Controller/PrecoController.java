package com.test.rabbitmqtest.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.test.rabbitmqtest.Service.RabbitMQService;
import DTO.PrecoDTO;
import org.springframework.web.bind.annotation.PutMapping;
import com.test.rabbitmqtest.constantes.RabbitMQConstantes;



@RestController
@RequestMapping("/preco")
public class PrecoController {

    @Autowired 
    RabbitMQService rabbitMQService;

    @PutMapping
    private ResponseEntity alteraPreco(@RequestBody PrecoDTO precoDTO){
        this.rabbitMQService.enviaMensagem(RabbitMQConstantes.FILA_PRECO, precoDTO);
        return new ResponseEntity(HttpStatus.OK);
    }
    
    
}
