<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../../common/templates/backend/header.jsp" %>
<%@include file="../../common/templates/backend/navbar.jsp" %>
<section class="row">
    <article class="col">
         <nav class="navbar navbar-light bg-light">
                <div class="container-fluid ">
                    <a href="MainController?action=Add Category" class="btn btn-primary"><i class="fas fa-plus"></i> Add new category</a>
                    <form class="d-flex" action="MainController">
                        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search"
                               name="searchText">
                        <button class="btn btn-outline-success" type="submit" name="action" value="Search Category">Search</button>
                    </form>
                </div>
            </nav>
        <div class="card">
            <h5 class="card-header">
                Search Categories Result
            </h5>
            <div class="card-body">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">No</th>
                            <th scope="col">Category ID</th>
                            <th scope="col">Category Name</th>
                            <th scope="col">&nbsp;</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:set var="count" value="0"/>
                    <c:forEach var="o" items="${requestScope.LIST_SEARCH_CATEGORY}">
                        <c:set var="count" value="${count+1}"/>
                        <tr>
                            <td>${count}</td>
                            <td>${o.categoryId}</td>
                            <td>${o.categoryName}</td>
                            <td>
                                <a href="MainController?action=Edit Category&categoryID=${o.categoryId}" title="Edit"><i class='fas fa-edit' style='font-size:24px;color:green'></i></a>
                                <a href="MainController?action=Delete Category&categoryID=${o.categoryId}" title="Delete"><i class='fas fa-trash' style='margin-left:5px;font-size:24px;color:red'></i></a>
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