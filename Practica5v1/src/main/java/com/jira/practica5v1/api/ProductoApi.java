package com.jira.practica5v1.api;

import com.jira.practica5v1.ProductService.ProductoServicio;
import com.jira.practica5v1.entities.ProductoEntity;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(maxAge = 3600)
@RestController

public class ProductoApi {
    private final ProductoServicio servicioP;

    public ProductoApi(ProductoServicio servicio){
        this.servicioP=servicio;
    }

    @GetMapping("/product/listProducts")
    public List<ProductoEntity>getProducts(){
        return servicioP.getProductos();
    }

    @GetMapping("/product/{id}/details")
    public ResponseEntity<ProductoEntity> ProducDetails(@PathVariable ("id") int id){
        try{
            return ResponseEntity.ok(servicioP.getById(id));
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/product/create")
    public ResponseEntity<ProductoEntity> crearProducto(@RequestBody ProductoEntity producto){
        try{
            return ResponseEntity.ok(servicioP.CrearProducto(producto.getNombre(),producto.getCantidad(), producto.getPrecio()));
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/product/{id}/edit")
    public ResponseEntity<ProductoEntity> editProducto(@PathVariable("id") int id, @RequestBody ProductoEntity producto){
        try{
            return ResponseEntity.ok(servicioP.ModProducto(id, producto.getNombre(), producto.getCantidad(),
                    producto.getPrecio()));
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/producto/{id}/delete")
    public ResponseEntity<ProductoEntity>deleteProduct(@PathVariable("id") int id){
        try{
            return ResponseEntity.ok(servicioP.RmProducto(id));
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
    //antes del repositorio
    /*
    @GetMapping("/product/listProducts")
    public List<ProductoEntity>getProducts(){
        return servicio.getProductos();
    }

    @GetMapping("/product/{id}/details")
    public Optional<ProductoEntity> ProducDetails(@PathVariable ("id") int id){
        return Optional.of(servicio.getById(id));
    }

    @PutMapping("/product/create")
    public Optional<ProductoEntity> crearProducto(@RequestBody ProductoEntity producto){
        Optional<ProductoEntity> productoCreado= servicio.CrearProducto(producto.getNombre(),producto.getCantidad());
        return Optional.of( servicio.getById(productoCreado.get().getId()));
    }

    @PostMapping("/product/{id}/edit")
    public Optional<ProductoEntity> editProducto(@PathVariable("id") int id, @RequestBody ProductoEntity producto){
        Optional<ProductoEntity> productoE=servicio.ModProducto(id,producto.getNombre(),producto.getCantidad());
        return productoE;
    }

    @DeleteMapping("/producto/{id}/delete")
    public String deleteProduct(@PathVariable("id") int id){
        return servicio.RmProducto(id);
    }*/


}
