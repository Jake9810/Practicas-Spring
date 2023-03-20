package com.jira.practica5v1.ProductService;

import com.jira.practica5v1.entities.ProductoEntity;
import com.jira.practica5v1.repository.ProductRespository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductoServicio {
    private final ProductRespository productoRepo;

    public ProductoServicio(ProductRespository repo) {
        this.productoRepo=repo;
    }
    public List<ProductoEntity> getProductos(){
        return productoRepo.getList();
    }

    public ProductoEntity getById(Integer id){
        return productoRepo.getById(id).orElseThrow();
    }
    public ProductoEntity CrearProducto(String nom, Float cant, double precio){
        return productoRepo.crearP(nom,cant, precio).orElseThrow();
    }

    public ProductoEntity ModProducto(int id, String nom2, float cant, double precio){
        return productoRepo.modificarP(id,nom2,cant,precio).orElseThrow();
    }
    public ProductoEntity ModProducto2(String nom, String nom2, float cant){
        return productoRepo.modificarP2(nom,nom2,cant).orElseThrow();
    }
    public ProductoEntity RmProducto(int id){


        return productoRepo.eliminarP(id).orElseThrow();
    }
    //versión antes del repositorio
    /*private final List<ProductoEntity> productos =new ArrayList<>();

    /*public List<ProductoEntity> getProductos(){
        return productos;
    }* /

    public List<ProductoEntity> getProductos(){
         productos.stream().map(
                                      producto -> ProductoEntity.builder()
                                              .id(producto.getId())
                                              .nombre(producto.getNombre())
                                              .cantidad(producto.getCantidad())
                                              .build()
        ).toList();
         System.out.print(productos);
         System.out.print("\n");
         return productos;
    }
    public Optional<ProductoEntity> getById(Integer id){
        /*ProductoEntity producto=new ProductoEntity();
        for(ProductoEntity pro:productos){
            if(pro.getId()==id){
                producto=pro;
            }
        }* /
        return productos.stream()
                .filter(producto -> producto.getId()==id)
                .map(producto ->
                        ProductoEntity.builder()
                                      .id(producto.getId())
                                      .nombre(producto.getNombre())
                                      .cantidad(producto.getCantidad())
                                      .build()
                ).findFirst();
    }* /

    public Optional<ProductoEntity> CrearProducto(String nom, Float cant){
        /*ProductoEntity producto=new ProductoEntity();
        producto.setId(productos.size()+1);
        producto.setNombre(nom);
        producto.setCantidad(cant);

        productos.add(producto);* /
        ProductoEntity producto=ProductoEntity.builder()
                .id(productos.size()+1)
                .nombre(nom)
                .cantidad(cant)
                .build();
        productos.add(producto);
        return Optional.of(producto);
    }

    public Optional<ProductoEntity> ModProducto(int id, String nom2, float cant){
        /*ProductoEntity producto=new ProductoEntity();
        for(ProductoEntity product:productos){
            if(product.getId()==id){
                product.setNombre(nom2);
                product.setCantidad(cant);
                producto=product;
                break;
            }
            else{
                product=null;
            }
        }* /
        Optional<ProductoEntity> productoEn=getById(id);
        productoEn.get().setNombre(nom2);
        productoEn.get().setCantidad(cant);
        return productoEn;
    }

    public String RmProducto(int id){
        ProductoEntity producto;
        String resultado="NO se pudo eliminar el producto";
        for(ProductoEntity product:productos){
            if(product.getId()==id){
                producto=product;
                productos.remove(producto.getId());
                resultado="Producto: "+producto.getNombre()+" ELIMINADO";
                break;
            }
        }
        return resultado;
    }

*/

}
