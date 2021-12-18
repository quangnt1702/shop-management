<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../../common/templates/backend/header.jsp" %>
<%@include file="../../common/templates/backend/navbar.jsp" %>
<c:if test="${requestScope.LIST_CATEGORY == null}">
    <c:redirect url="../../AddProductController"></c:redirect>
</c:if>
<br>
<section class="row">
    <article class="col">
        <div class="card" >
            <h5 class="card-header">
                ${requestScope.PRODUCT_EDITING!=null?"Edit Product":"Add Product"}
            </h5> 
            <div class="card-body">
                <form action="MainController" method="Post">
                    <div class="form-group">
                        <label for="productCategory" style="margin-bottom: 7px;">Product Category</label>
                        <select class="form-select" required
                                name="productCategory">
                            <c:if test="${requestScope.PRODUCT_EDITING.categories.categoryId==null}">
                                <option selected disabled="" value="">Choose Product Category</option>
                            </c:if>
                            <c:if test="${requestScope.PRODUCT_EDITING.categories.categoryId!=null}">
                                <option selected value="${requestScope.PRODUCT_EDITING.categories.categoryId}" style="background-color: gray;color: white;">${requestScope.PRODUCT_EDITING.categories.categoryName}</option>
                            </c:if>
                            <c:forEach var="o" items="${requestScope.LIST_CATEGORY}">
                                <option value="${o.categoryId}">${o.categoryName}</option>
                            </c:forEach>
                        </select>
                    </div><br>  
                    <div class="form-group">
                        <label for="productName" style="margin-bottom: 7px;">Product Name</label>
                        <input type="text" class="form-control" id="productName" placeholder="Product Name" required="" value="${requestScope.PRODUCT_EDITING.productName}"
                               name="productName"/>
                    </div><br>
                    <div class="form-group">
                        <label for="unitPrice" style="margin-bottom: 7px;">Unit Price</label>
                        <input type="number" class="form-control" id="unitPrice" placeholder="Unit Price" required="" value="${requestScope.PRODUCT_EDITING.unitPrice}"
                               name="unitPrice" min="0"/>
                    </div><br>
                    <div class="form-group">
                        <label for="unitsInStock" style="margin-bottom: 7px;">Units in Stock</label>
                        <input type="number" class="form-control" id="unitsInStock" placeholder="Units in Stock" required="" value="${requestScope.PRODUCT_EDITING.unitsInStock}"
                               name="unitsInStock" min="0"/>
                    </div><br>
                    <div class="form-group">
                        <label for="status" style="margin-bottom: 7px;">Status</label>
                        <select class="form-select" required
                                name="status">
                            <c:if test="${requestScope.PRODUCT_EDITING.status==null}">
                                <option selected disabled="" value="">Choose Status</option>
                            </c:if>
                            <c:if test="${requestScope.PRODUCT_EDITING.status!=null}">
                                <option selected value="${requestScope.PRODUCT_EDITING.status}" style="background-color: gray;color: white;">${requestScope.PRODUCT_EDITING.status}</option>
                            </c:if>
                            <option value="InStock">In-Stock</option>
                            <option value="OutStock">Out-Stock</option>
                        </select>
                    </div><br>
                    <div class="form-group">
                        <input type="hidden" value="${requestScope.PRODUCT_EDITING.productId}" name="productID"/>
                        <input type="submit" class="btn btn-primary" name="action" value="${requestScope.PRODUCT_EDITING!=null?"Edit Product":"Add Product"}"/>
                    </div>
                </form>
            </div>
        </div>
    </article>
</section>
<br>
<%@include file="../../common/templates/backend/footer.jsp" %>