/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.agromaquinariasosorio.config;

import com.agromaquinariasosorio.modelo.Carrito;
import com.agromaquinariasosorio.modelo.Categoria;
import com.agromaquinariasosorio.modelo.CategoriaDAO;
import com.agromaquinariasosorio.modelo.ItemCarrito;
import com.agromaquinariasosorio.modelo.PedidoDAO;
import com.agromaquinariasosorio.modelo.Producto;
import com.agromaquinariasosorio.modelo.ProductoDAO;
import com.agromaquinariasosorio.modelo.Usuario;
import com.agromaquinariasosorio.modelo.UsuarioDAO;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MARY LEONOR
 */
public class Test {

  public static void main(String[] args) throws Exception {
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    try{
      Usuario usu = new Usuario();
      usu.setNombre("Juan Luis Castro Bonilla");
      usu.setCorreo("juanluis@gmail.com");
      usu.setContrasena("admin123");
      Usuario usuBD = usuarioDAO.verificarUsuario(usu);
      System.out.println("Usuario encontrado:" + usuBD.getNombre());
    }catch (Exception ex) {
      System.out.println("Error" + ex.getLocalizedMessage());
    }
  }
}
