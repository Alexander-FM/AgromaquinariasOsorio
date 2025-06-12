package com.agromaquinariasosorio.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {

  private Connection con;
  private boolean transaccionIniciada;

  // Cambia estos valores según tu configuración de Oracle XE
  private final String url = "jdbc:oracle:thin:@localhost:1521:xe"; // Formato de conexión para Oracle
  private final String user = "SYSTEM"; // Usuario de Oracle
  private final String pass = "admin"; // Contraseña de Oracle

  public Connection getConnection() {
    try {
      // Cargar el driver de Oracle
      Class.forName("oracle.jdbc.OracleDriver");
      con = DriverManager.getConnection(url, user, pass);
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace(); // Manejo de errores
    }
    return con;
  }

  public void conectar() throws SQLException, ClassNotFoundException {
    Class.forName("oracle.jdbc.OracleDriver");
    con = DriverManager.getConnection(url, user, pass);
  }

  public void desconectar() throws SQLException {
    if (con != null) {
      con.close();
    }
  }

  protected void conectar(boolean wTransaccion) throws Exception {
    Class.forName("oracle.jdbc.OracleDriver");
    con = DriverManager.getConnection(url, user, pass);

    if (wTransaccion) {
      this.con.setAutoCommit(false);
      this.transaccionIniciada = true;
    } else {
      this.con.setAutoCommit(true);
      this.transaccionIniciada = false;
    }
  }

  protected void cerrar(boolean wEstado) throws Exception {
    if (this.con != null) {
      if (this.transaccionIniciada) {
        try {
          if (wEstado) {
            this.con.commit();
          } else {
            this.con.rollback();
          }
        } catch (SQLException e) {
          throw e;
        }
      }
      try {
        this.con.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    this.con = null;
  }

  protected void ejecutarOrden(String wSQL) throws Exception {
    Statement st;

    if (this.con != null) {
      st = this.con.createStatement();
      st.executeUpdate(wSQL);
    }
  }

  protected ResultSet ejecutarOrdenDatos(String wSQL) throws Exception {
    Statement st;
    ResultSet rs = null;

    if (this.con != null) {
      st = this.con.createStatement();
      rs = st.executeQuery(wSQL);
    }

    return rs;
  }
}
