/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.agromaquinariasosorio.controlador;

import com.agromaquinariasosorio.modelo.Usuario;
import com.agromaquinariasosorio.modelo.UsuarioDAO;
import com.agromaquinariasosorio.utils.AgromaquinariasUtils;
import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 *
 * @author MARY LEONOR
 */
@WebServlet(name = "srvUsuario", urlPatterns = "/srvUsuario")
public class srvUsuario extends HttpServlet {

  /**
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
   * methods.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("application/json;charset=UTF-8");

    if (request.getParameter("accion") != null) {
      String accion = request.getParameter("accion");
      switch (accion) {
        case "registrarUsuario" ->
          this.registrarUsuario(request, response);
        case "iniciarSesion" ->
          this.iniciarSesion(request, response);
        default ->
          throw new AssertionError();
      }
    } else {
      AgromaquinariasUtils.printError("No se indico la operación a realizar", response);
    }
  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

  private void registrarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {

    if (request.getParameter("usu") != null) {
      final Gson gson = new Gson();
      final Usuario usu = gson.fromJson(request.getParameter("usu"), Usuario.class);
      try {
        UsuarioDAO dao = new UsuarioDAO();
        dao.registrarUsuario(usu);
        AgromaquinariasUtils.printMessage("Usuario registrado correctamente", true, response);
      } catch (Exception e) {
        AgromaquinariasUtils.printMessage(e.getMessage(), false, response);
      }
    } else {
      AgromaquinariasUtils.printMessage("Rellene el formulario", false, response);
    }
  }

  private void iniciarSesion(HttpServletRequest request, HttpServletResponse response) throws IOException {
    PrintWriter out = response.getWriter();
    if (request.getParameter("usu") != null) {
      Gson gson = new Gson();
      Usuario usuario = gson.fromJson(request.getParameter("usu"), Usuario.class);
      try {
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usu = dao.verificarUsuario(usuario);
        String json = gson.toJson(usu);
        out.print(json);
      } catch (Exception e) {
        AgromaquinariasUtils.printError(e.getMessage(), response);
      }
    } else {
      AgromaquinariasUtils.printMessage("Rellene el formulario", false, response);
    }

  }

}
