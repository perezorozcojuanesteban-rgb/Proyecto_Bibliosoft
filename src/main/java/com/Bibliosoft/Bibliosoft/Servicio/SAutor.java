package com.Bibliosoft.Bibliosoft.Servicio;

import com.Bibliosoft.Bibliosoft.Modelo.MAutor;
import com.Bibliosoft.Bibliosoft.Repositorio.IAutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SAutor {
    @Autowired
    IAutor iAutor;

    // Constructor

    public SAutor(IAutor iAutor) {
        this.iAutor = iAutor;
    }

    // Guardar
    public MAutor guardar(MAutor mAutor) throws Exception{
        try{
            return this.iAutor.save(mAutor);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    // Consulta general
    public List<MAutor> consultageneral() throws Exception{
        try{
            return this.iAutor.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    // consulta individual por id
    public MAutor consultaIndividualId(Integer ideautor) throws Exception{
        try{
            Optional<MAutor> autorEncontrado= this.iAutor.findById(ideautor);
            if (autorEncontrado.isPresent())
                return autorEncontrado.get();
            else
                throw new Exception("Autor no encontrado");
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    // Consulta individual por nombre
    public List<MAutor> consultaIndividualNombre(String nombreautor) throws Exception{
        try{
            return this.iAutor.findByNombreautor(nombreautor);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    // Modificar
    public MAutor modificar(MAutor mAutor, Integer ideautor) throws Exception{
        try{
           Optional<MAutor> autorEncontrado = this.iAutor.findById(ideautor);
           if (autorEncontrado.isPresent()){
               MAutor nuevoRegistro = autorEncontrado.get();
               nuevoRegistro.setIdeautor(mAutor.getIdeautor());
               nuevoRegistro.setNombreautor(mAutor.getNombreautor());
               nuevoRegistro.setApellidoautor(mAutor.getApellidoautor());
               nuevoRegistro.setNacionalidadautor(mAutor.getNacionalidadautor());
               nuevoRegistro.setActivo(mAutor.getActivo());
               return this.iAutor.save(nuevoRegistro);
           }else
               throw new Exception("No es posible modificar, el autor no se encuentra registrado.");
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    // Eliminar
    public Boolean eliminar (Integer ideautor) throws Exception{
        try{
            Optional<MAutor> autorencontrado = this.iAutor.findById(ideautor);
            if (autorencontrado.isPresent()){
                this.iAutor.deleteById(ideautor);
                return true;
            }else
                throw new Exception("No es posible eliminar, el autor no existe.");
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    // Anular
    public MAutor anular (MAutor mAutor, Integer ideautor) throws Exception{
        try{
            Optional<MAutor> autorEncontrado = this.iAutor.findById(ideautor);
            if (autorEncontrado.isPresent()){
                MAutor nuevoRegistro = autorEncontrado.get();
                if (mAutor.getActivo().equals("True"))
                    nuevoRegistro.setActivo("True");
                else
                    nuevoRegistro.setActivo("False");
                return this.iAutor.save(nuevoRegistro);

            }else
                throw new Exception("El autor no esta registrado, no es posile anular.");
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
