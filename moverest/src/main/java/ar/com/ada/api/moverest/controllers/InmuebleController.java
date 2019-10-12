package ar.com.ada.api.moverest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.moverest.services.InmuebleService;

/**
 * InmuebleController
 */
@RestController
public class InmuebleController {

    @Autowired
    InmuebleService inmuebleService;
}