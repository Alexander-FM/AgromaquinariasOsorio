/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.agromaquinariasosorio.modelo;

import com.agromaquinariasosorio.config.Conexion;
import java.sql.ResultSet;

/**
 *
 * @author MARY LEONOR
 */
public class UsuarioDAO extends Conexion {

  public Usuario verificarUsuario(Usuario usuario) throws Exception {
    Usuario usu = null;
    ResultSet rs;
    String sql = "SELECT id_usuario, nombre, correo "
            + "FROM Usuario "
            + "WHERE correo = '" + usuario.getCorreo() + "' "
            + "AND contrasena = '" + usuario.getContrasena() + "'";
    try {
      this.conectar(false);
      rs = this.ejecutarOrdenDatos(sql);
      if (rs.next()) {
        usu = new Usuario();
        usu.setIdUsuario(rs.getInt("id_usuario"));
        usu.setNombre(rs.getString("nombre"));
        usu.setCorreo(rs.getString("correo"));
      }
    } catch (Exception e) {
      throw new Exception("Error al encontrar el usuario: " + e.getMessage());
    } finally {
      this.cerrar(false);
    }
    return usu;
  }

  public void registrarUsuario(Usuario usuario) throws Exception {
    String sql = "INSERT INTO Usuario (nombre, correo, contrasena) "
            + "VALUES ('" + usuario.getNombre() + "', '"
            + usuario.getCorreo() + "', '"
            + usuario.getContrasena() + "')";
    try {
      this.conectar(false);
      this.ejecutarOrden(sql);
    } catch (Exception e) {
      throw new Exception("Error al registrar el usuario: " + e.getMessage());
    } finally {
      this.cerrar(false);
    }
  }

}
