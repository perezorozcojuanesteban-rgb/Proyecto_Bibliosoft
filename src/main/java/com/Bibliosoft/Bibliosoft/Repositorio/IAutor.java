package com.Bibliosoft.Bibliosoft.Repositorio;

import com.Bibliosoft.Bibliosoft.Modelo.MAutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAutor extends JpaRepository<MAutor,Integer> {
    List<MAutor>findByNombreautor(String Nombreautor);
}
