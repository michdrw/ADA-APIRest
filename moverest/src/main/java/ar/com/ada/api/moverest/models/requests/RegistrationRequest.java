package ar.com.ada.api.moverest.models.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * RegistrationRequest
 */
public class RegistrationRequest {

    public String email;
    public String password;
    @JsonProperty(required = true)
    public boolean tipo;  
    public PersonaRequest personaData;
    
}