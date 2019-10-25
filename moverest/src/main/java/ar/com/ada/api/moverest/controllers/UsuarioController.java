package ar.com.ada.api.moverest.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.moverest.services.LocatarioService;
import ar.com.ada.api.moverest.services.UsuarioService;

/**
 * UsuarioController
 */
@RestController
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;
    @Autowired
    LocatarioService locatarioService;


}