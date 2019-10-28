package ar.com.ada.api.moverest.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.moverest.entities.Inmobiliaria;
import ar.com.ada.api.moverest.entities.Locador;
import ar.com.ada.api.moverest.repositories.InmobiliariaRepository;

/**
 * InmobiliariaService
 */
@Service
public class InmobiliariaService {

    @Autowired
    InmobiliariaRepository repoInmobiliaria;
    @Autowired
    LocadorService locadorService;
    

    public void save(Inmobiliaria mr) 
    {
        repoInmobiliaria.save(mr);
    }

    public Inmobiliaria buscarPorId(int id)
    {
        Optional<Inmobiliaria> i = repoInmobiliaria.findById(id);

        if (i.isPresent()) {
            return i.get();
        }
        return null;
    }

   public int crearLocador(String nombre, String tipoIdentificacion, int nroIdentificacion, int edad, String juricidad, int inmobiliariaId)
   {
       Locador l = new Locador();
        l.setNombre(nombre);
        l.setTipoIdentificacion(tipoIdentificacion);
        l.setNroIdentificacion(nroIdentificacion);
        l.setEdad(edad);
        l.setJuricidad(juricidad);
        Inmobiliaria i = buscarPorId(inmobiliariaId);
        l.setInmobiliaria(i);
        locadorService.save(l);
        return l.getLocadorId();
   }
    
}