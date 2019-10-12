package ar.com.ada.api.moverest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.moverest.services.ReservaService;

/**
 * ReservaController
 */
@RestController
public class ReservaController {

    @Autowired
    ReservaService reservaService;
}