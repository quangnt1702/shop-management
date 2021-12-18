/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quangnt.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ACER
 */
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SEARCH_PRODUCT = "SearchProductController";
    private static final String DELETE_PRODUCT = "DeleteProductController";
    private static final String ADD_PRODUCT = "AddProductController";
    private static final String UPDATE_PRODUCT = "UpdateProductController";
    private static final String SEARCH_CATEGORY = "SearchCategoryController";
    private static final String DELETE_CATEGORY = "DeleteCategoryController";
    private static final String ADD_CATEGORY = "AddCategoryController";
    private static final String UPDATE_CATEGORY = "UpdateCategoryController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String action = request.getParameter("action");
            if ("Search Product".equals(action)) {
                url = SEARCH_PRODUCT;
            } else if ("Delete Product".equals(action)) {
                url = DELETE_PRODUCT;
            } else if ("Add Product".equals(action)) {
                url = ADD_PRODUCT;
            } else if ("Edit Product".equals(action)) {
                url = UPDATE_PRODUCT;
            } else if ("Delete Category".equals(action)) {
                url = DELETE_CATEGORY;
            } else if ("Add Category".equals(action)) {
                url = ADD_CATEGORY;
            } else if ("Edit Category".equals(action)) {
                url = UPDATE_CATEGORY;
            } else if ("Search Category".equals(action)) {
                url = SEARCH_CATEGORY;
            }
        } catch (Exception e) {
            log("Error at MainController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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

}
