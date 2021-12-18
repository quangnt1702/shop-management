<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../../common/templates/backend/header.jsp" %>
<%@include file="../../common/templates/backend/navbar.jsp" %>
<section class="row">
    <article class="col">
        <nav class="navbar navbar-light bg-light">
            <div class="container-fluid ">
                <a href="MainController?action=Add Product" class="btn btn-primary"><i class="fas fa-plus"></i> Add new product</a>
                <form class="d-flex" action="MainController">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search"
                           name="searchText">
                    <button class="btn btn-outline-success" type="submit" name="action" value="Search Product">Search</button>
                </form>
            </div>
        </nav>
        <div class="card">
            <h5 class="card-header">
                Search Products Result
            </h5>
            <div class="card-body">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">No</th>
                            <th scope="col">Product ID</th>
                            <th scope="col">Product Name</th>
                            <th scope="col">Product Category</th>
                            <th scope="col">Unit Price</th>
                            <th scope="col">Units in Stock</th>
                            <th scope="col">Status</th>
                            <th scope="col">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:set var="count" value="0"/>
                        <c:forEach var="o" items="${requestScope.LIST_PRODUCT_CATEGORY}">
                            <c:set var="count" value="${count+1}"/>
                            <tr>
                                <td>${count}</td>
                                <td>${o.productId}</td>
                                <td>${o.productName}</td>
                                <td>${o.categories.categoryName}</td>
                                <td>$${o.unitPrice}</td>
                                <td>${o.unitsInStock}</td>
                                <td>
                                    <c:if test="${o.status == 'InStock'}">
                                        <span class="badge bg-success">${o.status}</span>
                                    </c:if>
                                    <c:if test="${o.status == 'OutStock'}">
                                        <span class="badge bg-warning">${o.status}</span>
                                    </c:if>
                                </td>
                                <td>
                                    <a href="MainController?action=Edit Product&productID=${o.productId}" title="Edit"><i class='fas fa-edit' style='font-size:24px;color:green'></i></a>
                                    <a href="MainController?action=Delete Product&productID=${o.productId}" title="Delete"><i class='fas fa-trash' style='margin-left:5px;font-size:24px;color:red'></i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </article>
</section>
<br>
<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
<%@include file="../../common/templates/backend/footer.jsp" %>