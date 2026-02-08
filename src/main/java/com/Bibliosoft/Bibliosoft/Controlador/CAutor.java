package com.Bibliosoft.Bibliosoft.Controlador;

import com.Bibliosoft.Bibliosoft.Modelo.MAutor;
import com.Bibliosoft.Bibliosoft.Servicio.SAutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/autores")
public class CAutor {
    @Autowired
    SAutor sAutor;

    // EndPoint metodo guardar
    @PostMapping
    public ResponseEntity<?> guardar (@RequestBody MAutor mAutor) throws Exception{
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.sAutor.guardar(mAutor));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }

    // EndPoint para la consulta general
    @GetMapping
    public ResponseEntity<?> consultaGeneral () throws Exception{
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sAutor.consultageneral());
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }

    // EndPoint de la consulta individual por llave primaria
    @GetMapping("/{ideautor}")
    public ResponseEntity<?> consultaIndividualId (@PathVariable Integer ideautor) throws Exception{
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sAutor.consultaIndividualId(ideautor));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }

    // EndPoint de la consulta individual por nombre
    @GetMapping("/buscarnom/{nombreautor}")
    public ResponseEntity<?> consultaIndividualNombre (@PathVariable String nombreautor) throws Exception{
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sAutor.consultaIndividualNombre(nombreautor));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }

    // EndPoint modificar
    @PutMapping("/{ideautor}")
    public ResponseEntity<?> modificar (@RequestBody MAutor mAutor, @PathVariable Integer ideautor) throws Exception{
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sAutor.modificar(mAutor,ideautor));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }

    // EndPoint eliminar
    @DeleteMapping("/{ideautor}")
    public ResponseEntity<?> eliminar (@PathVariable Integer ideautor) throws Exception{
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sAutor.eliminar(ideautor));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }

    // EndPoint anular
    @PutMapping("/anular/{ideautor}")
    public ResponseEntity<?> anular (@RequestBody MAutor mAutor, @PathVariable Integer ideautor) throws Exception{
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sAutor.anular(mAutor,ideautor));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }
}
