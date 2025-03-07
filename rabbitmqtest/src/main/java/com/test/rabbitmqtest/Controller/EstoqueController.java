package com.test.rabbitmqtest.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DTO.EstoqueDTO;
import com.test.rabbitmqtest.Service.RabbitMQService;
import constantes.RabbitMQConstantes;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    @Autowired
    RabbitMQService rabbitMQService;

    @PutMapping
    private ResponseEntity alteraEstoque(@RequestBody EstoqueDTO estoqueDTO) {
        this.rabbitMQService.enviaMensagem(RabbitMQConstantes.FILA_ESTOQUE, estoqueDTO);
        return new ResponseEntity(HttpStatus.OK);
    }
}
