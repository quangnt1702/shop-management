<%@include file="../../common/templates/backend/header.jsp" %>
<%@include file="../../common/templates/backend/navbar.jsp" %>
<br>
<section class="row">
    <article class="col">
        <div class="card" >
            <h5 class="card-header">
                ${requestScope.CATEGORY_EDITING!=null?"Edit Category":"Add Category"}
            </h5>
            <div class="card-body">
                <form action="MainController" method="Post">
                    <div class="form-group">
                    <label for="categoryID" style="margin-bottom: 7px;">Category ID</label>
                    <input type="text" class="form-control" id="categoryID" placeholder="Category ID" value="${requestScope.CATEGORY_EDITING.categoryId}""
                           name="categoryID" readonly=""/>
                    </div><br>
                    <div class="form-group">
                        <label for="categoryName" style="margin-bottom: 7px;">Category Name</label>
                        <input type="text" class="form-control" id="categoryName" placeholder="Category Name" value="${requestScope.CATEGORY_EDITING.categoryName}"
                               name="categoryName"/>
                    </div><br>
                    <div class="form-group">
                        <input type="submit" class="btn btn-primary" name="action" value="${requestScope.CATEGORY_EDITING!=null?"Edit Category":"Add Category"}"/>
                    </div>
                </form>
            </div>
        </div>
    </article>
</section>
<br>
<%@include file="../../common/templates/backend/footer.jsp" %>