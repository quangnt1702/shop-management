/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quangnt.servlet;

import com.quangnt.dao.CategoryDAO;
import com.quangnt.dao.ProductDAO;
import com.quangnt.entities.Category;
import com.quangnt.entities.Product;
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
@WebServlet(name = "UpdateProductController", urlPatterns = {"/UpdateProductController"})
public class UpdateProductController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "ListProductsController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            int productID = Integer.parseInt(request.getParameter("productID"));
            String productName = request.getParameter("productName");
            double unitPrice = Double.parseDouble(request.getParameter("unitPrice"));
            int unitInStock = Integer.parseInt(request.getParameter("unitsInStock"));
            Category category = new Category();
            category.setCategoryId(Integer.parseInt(request.getParameter("productCategory")));
            String status = request.getParameter("status");
            ProductDAO dao = new ProductDAO();
            Product product = new Product(productID, category, productName, unitPrice, unitInStock, status);
            if (dao.updateProduct(product) != null) {
                url = SUCCESS;
            }
        } catch (Exception e) {
            log("Error at UpdateProductController: " + e.toString());
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
        try {
            int productID = Integer.parseInt(request.getParameter("productID"));
            ProductDAO productDAO = new ProductDAO();
            if (productDAO.getProductByID(productID) != null) {
                request.setAttribute("PRODUCT_EDITING", productDAO.getProductByID(productID));
            }
            CategoryDAO categoryDAO = new CategoryDAO();
            if (categoryDAO.getAllCategories() != null) {
                request.setAttribute("LIST_CATEGORY", categoryDAO.getAllCategories());
            }
        } catch (Exception e) {
            log("Error at Edit Product DoGet: " + e.toString());
        } finally {
            request.getRequestDispatcher("backend/products/addOrEdit.jsp").forward(request, response);
        }
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
