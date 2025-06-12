/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.agromaquinariasosorio.config;

import com.agromaquinariasosorio.modelo.CategoriaDAO;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author MARY LEONOR
 */
public class Test {
      public static void main(String[] args) {
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();

        if (con != null) {
            System.out.println("Conexion exitosa a Oracle XE");
            CategoriaDAO categoriaDAO = new CategoriaDAO();
            List list = categoriaDAO.listar();
            System.out.println(list.getFirst().toString());
        } else {
            System.out.println("Error al conectar a Oracle XE");
        }
    }
}
