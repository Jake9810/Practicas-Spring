package com.jira.practica5v1.api;

import com.jira.practica5v1.ProductService.ProductoServicio;
import com.jira.practica5v1.entities.ProductoEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(maxAge = 3600)
@Controller
public class HomeController {
    private final ProductoServicio Productoservicio;
    public HomeController(ProductoServicio servicio){
        this.Productoservicio=servicio;
    }
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/prt5/productos/listar")
    public String listar(Model model){
        model.addAttribute("productos", Productoservicio.getProductos());
        return "listar";
    }

    @GetMapping("/prt5/productos/crear")
    public String crear(Model model){
        model.addAttribute("producto", new ProductoEntity());

        return "crear";
    }

    @PostMapping("/prt5/productos/crear")
    public String creado(Model model, @ModelAttribute ProductoEntity producto){
        model.addAttribute("producto", producto);
        Productoservicio.CrearProducto(producto.getNombre(), producto.getCantidad(), producto.getPrecio());
        return "creado";
    }
    @GetMapping("/prt5/productos/{id}/modificar")
    public String modificar(Model model, @PathVariable("id") int id){

        ProductoEntity producto=Productoservicio.getById(id);
        //System.out.println(producto.toString());
        model.addAttribute("producto",producto);
        return "modificar";
    }
    @PostMapping("/prt5/productos/{id}/modificar")
    public String modificado(Model model,@ModelAttribute ProductoEntity producto, @PathVariable("id") int id ){

        ProductoEntity pro=Productoservicio.ModProducto(id, producto.getNombre(), producto.getCantidad(), producto.getPrecio());
        model.addAttribute("producto",pro);
        return "modificado";
    }

    @GetMapping("/prt5/productos/{id}/eliminar")
    public String eliminar(Model model, @PathVariable("id") int id){
        ProductoEntity producto=Productoservicio.getById(id);
        model.addAttribute("producto", producto);
        return "eliminar";
    }

    @PostMapping("/prt5/productos/{id}/eliminar")
    public String eliminado(Model model, @PathVariable("id") int id){
        ProductoEntity producto=Productoservicio.RmProducto(id-1);
        Map<String,Object> MapsProducts=new HashMap<>();
        MapsProducts.put("producto",producto);
        MapsProducts.put("productos",Productoservicio.getProductos());

        model.addAllAttributes(MapsProducts);
        return "eliminado";
    }

}
