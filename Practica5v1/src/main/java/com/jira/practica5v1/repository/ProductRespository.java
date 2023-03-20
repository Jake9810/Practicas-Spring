package com.jira.practica5v1.repository;

import com.jira.practica5v1.entities.ProductoEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRespository {
    Optional <ProductoEntity> getById(int id);
    List<ProductoEntity> getList();
    Optional<ProductoEntity> crearP(String name, float cant, double precio);
    Optional<ProductoEntity> modificarP(int id, String name2, float cant, double precio);
    public Optional<ProductoEntity> modificarP2( String nom, String name2, float cant);
    Optional<ProductoEntity> eliminarP(int id);
    Optional<ProductoEntity> eliminarP(ProductoEntity producto);
}
