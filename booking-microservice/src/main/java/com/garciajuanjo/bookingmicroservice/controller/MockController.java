package com.garciajuanjo.bookingmicroservice.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Este es un controlador de prueba para probar el Spring boot starter actuator para
 * cuando hacemos cambios en el config-server que se refresquen solos en donde los
 * necesitemos (lo que anotamos con @Value) sin tener que reiniciar el microservicio
 */

@RestController
@RequestMapping("/api/mock")
@Getter @Setter
@RefreshScope //actualizará lo que anotemos con @Value al hacer commit and push en service-configuration
public class MockController {

    //app.testProp lo obtenemos del perfil de application.properties de service-configuration
    @Value("${app.testProp}")
    private String testProp;

    @GetMapping("test-prop")
    public String getTestProp(){
        return this.testProp;
    }
}
