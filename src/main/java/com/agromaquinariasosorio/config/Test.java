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
    Conexion conexion = new Conexion();
    Connection con = conexion.getConnection();

    PedidoDAO pedidoDAO = new PedidoDAO();

    // Simular productos para el carrito (usando el método simulado)
    Producto p1 = new Producto(23, null, "Motosierra Juanaza", "Muy linda", new BigDecimal("460.40"), 45, "http://localhost:8080/AgromaquinariasOsorio/img/motosierras/motosierras1.jpg");
    Producto p2 = new Producto(22, null, "Motosierra Jesus", "Muy linda", new BigDecimal("150.20"), 100, "http://localhost:8080/AgromaquinariasOsorio/img/motosierras/motosierras2.png");

    // Simular un carrito
    Carrito miCarrito = new Carrito(1); // ID del usuario 1
    // Ahora usar setItems con una lista de ItemCarrito directamente
    List<ItemCarrito> itemsCarrito = new ArrayList<>();
    itemsCarrito.add(new ItemCarrito(p1, 2)); // 2 Laptops
    itemsCarrito.add(new ItemCarrito(p2, 3)); // 3 Mouses
    miCarrito.setItems(itemsCarrito);

    System.out.println("Intentando guardar el siguiente carrito:\n" + miCarrito);

    try {
      int idNuevoPedido = pedidoDAO.guardarPedido(miCarrito);
      System.out.println("Pedido guardado con éxito. ID del Pedido: " + idNuevoPedido);
    } catch (Exception e) {
      System.err.println("Fallo al guardar el pedido: " + e.getMessage());
    }
  }
}
