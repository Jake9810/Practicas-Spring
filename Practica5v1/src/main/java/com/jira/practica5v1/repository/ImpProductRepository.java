package com.jira.practica5v1.repository;

import com.jira.practica5v1.entities.ProductoEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ImpProductRepository implements ProductRespository{
    private List<ProductoEntity> productos=new ArrayList<>();
    @Override
    public Optional<ProductoEntity> getById(int id) {
        return productos.stream()
                .filter(producto -> producto.getId()==id)
                .map(producto ->
                        ProductoEntity.builder()
                                .id(producto.getId())
                                .nombre(producto.getNombre())
                                .cantidad(producto.getCantidad())
                                .precio(producto.getPrecio())
                                .build()
                ).findFirst();

    }

    @Override
    public List<ProductoEntity> getList() {
        return productos.stream().map( producto ->
                ProductoEntity.builder()
                        .id(producto.getId())
                        .nombre(producto.getNombre())
                        .cantidad(producto.getCantidad())
                        .precio(producto.getPrecio())
                        .build()
        ).toList();
    }

    @Override
    public Optional<ProductoEntity> crearP(String name, float cant, double precio) {
        int tempId;
        if(productos.size()<=0){
            tempId=1;
        }
        else{
            ProductoEntity temp = productos.get(productos.size() - 1);
            if (productos.size() <= temp.getId()) {
                tempId = temp.getId() + 1;
            } else {
                tempId = productos.size() + 1;
            }
        }
        ProductoEntity producto=ProductoEntity.builder()
                .id(tempId)
                .nombre(name)
                .cantidad(cant)
                .precio(precio)
                .build();
        productos.add(producto);
        return Optional.of(producto);
    }

    @Override
    public Optional<ProductoEntity> modificarP(int id, String name2, float cant, double precio) {
        Optional<ProductoEntity> productoE=null;
        for(ProductoEntity pro:productos){
            if(pro.getId()==id){
                pro.setNombre(name2);
                pro.setCantidad(cant);
                pro.setPrecio(precio);
                productoE= Optional.of(pro);
                break;
            }
        }

        return productoE;
    }
    @Override
    public Optional<ProductoEntity> modificarP2( String nom, String name2, float cant) {
        Optional<ProductoEntity> productoE=null;
        for(ProductoEntity pro:productos){
            if(pro.getNombre().equals(nom)){
                pro.setNombre(name2);
                pro.setCantidad(cant);
                productoE= Optional.of(pro);
                break;
            }
        }

        return productoE;
    }
    @Override
    public Optional<ProductoEntity> eliminarP(int id) {
        ProductoEntity productoRm=productos.get(id);
        productos.remove(id);
        System.out.print("el producto "+productoRm.getNombre()+" ha sido eliminado");
        return Optional.of(productoRm);
    }

    @Override
    public Optional<ProductoEntity> eliminarP(ProductoEntity producto) {
        ProductoEntity productoRm=productos.get(producto.getId());
        System.out.print("el producto "+productoRm.getNombre()+" ha sido eliminado");
        return Optional.of(productoRm);
    }
}
