<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="../jspf/header.jspf" %>
<header class="main-header">
  <section class="nav-container container">
    <div class="nav-wrapper row">
      <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse"
                data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item">
              <a class="nav-link" href="/alternatives">Альтернативы <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/criteria">Критерии</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/marks">Оценки</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/vectors">Векторы</a>
            </li>
            <li class="nav-item active">
              <a class="nav-link" href="/users">Пользователи</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/results">Результат</a>
            </li>
          </ul>
        </div>
      </nav>
    </div>
  </section>
</header>
<section class="container main-content">
  <div class="title-wrapper row">
    <p class="h3">Пользователи</p>
  </div>
  <div class="form-container row">
    <a href="javascript:void(0)" data-toggle="modal" data-target=".bd-example-modal-lg">Создать пользователя</a>
  </div>
  <div class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title">Создать/Редактировать пользователя</h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>

            <div class="popup-form-wrapper">
              <form class="user-form" method="post" action="/users">
                <div class="form-group row">
                  <label class="col-sm-3 col-form-label" for="user-name"><strong>Имя пользователя: </strong></label>
                    <div class="col-sm-9">
                      <input type="text" name="userName" class="form-control" id="user-name" placeholder="Имя пользователя"/>
                    </div>
                </div>
                <div class="form-group row">
                  <label class="col-sm-3 col-form-label" for="role"><strong>Роль: </strong></label>
                    <div class="col-sm-9">
                      <select name="role" class="form-control" id="role">
                        <c:forEach var="role" items="${roles}">
                          <option>${role}</option>
                        </c:forEach>
                      </select>
                    </div>
                </div>
                 <input type="hidden" name="id" class="form-control" id="user-id" value="0"></div>

                <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" data-dismiss="modal">Закрыть</button>
                  <button type="submit" class="btn btn-primary">Добавить</button>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
  <div class="content-wrapper row">
    <div class="mark-list-wrapper">
        <ul class="mark-list">
          <c:forEach var="user" items="${userList}">
            <li class="mark-list__item" data-role="${user.role}"><span class="user-name">${user.userName}</span>
              <div class="actions">
                <a class="action-link last" data-action="update-user"  data-toggle="modal" data-target=".bd-example-modal-lg"
                 data-id="${user.id}" href="javascript:void(0)">Редактировать</a>
                <%--<a class="action-link" data-action="preview" data-id="${user.id}" href="javascript:void(0)">Просмотр</a>--%>
                <%--<a class="action-link last" data-action="remove" data-id="${user.id}"
                   href="<c:url value="/users/delete?user-id=${user.id}"/>">Удалить</a>--%>
              </div>
             </li>
          </c:forEach>
        </ul>
        </div>
</section>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"
        integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"
        integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm"
        crossorigin="anonymous"></script>
<script src="../scripts/main.js"></script>

</body>

</html>