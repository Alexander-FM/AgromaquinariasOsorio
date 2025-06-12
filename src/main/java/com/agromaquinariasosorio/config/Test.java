/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.agromaquinariasosorio.config;

import com.agromaquinariasosorio.modelo.Categoria;
import com.agromaquinariasosorio.modelo.CategoriaDAO;
import com.agromaquinariasosorio.modelo.Producto;
import com.agromaquinariasosorio.modelo.ProductoDAO;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author MARY LEONOR
 */
public class Test {
      public static void main(String[] args) throws Exception {
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();

        if (con != null) {
            System.out.println("Conexion exitosa a Oracle XE");
            ProductoDAO productoDAO = new ProductoDAO();
            Producto pro = new Producto();
            pro.setIdCategoria(new Categoria());
            pro.getIdCategoria().setIdCategoria(1);
            pro.setNombre("Motosierra Juanaza");
            pro.setDescripcion("Muy buena y barata");
            pro.setPrecio(new BigDecimal(460.40));
            pro.setImagen("http://localhost:8080/imagen");
            pro.setStock(45);
            pro.setIdProducto(23);
            
            productoDAO.actualizar(pro);
            //System.out.println(prod.toString());
        } else {
            System.out.println("Error al conectar a Oracle XE");
        }
    }
}
