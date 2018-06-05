<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
              <a class="nav-link" href="/alternatives">Alternative <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
              <a class="nav-link" href="/criteria">Criteria</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/marks">Marks</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/vectors">Vectors</a>
            </li>
          </ul>
        </div>
      </nav>
    </div>
  </section>
</header>
<section class="container main-content">
  <div class="title-wrapper row">
    <p class="h3">Criteria</p>
  </div>
  <div class="form-container row">
    <a href="javascript:void(0)" data-toggle="modal" data-target=".bd-example-modal-lg">Создать критерий</a>
  </div>
  <div class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title">Создать/Редактировать критерий</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>

        <div class="popup-form-wrapper">
          <form method="post" action="/criteria">
            <div class="form-group"><label for="criteria-name">Название:</label>
            <input type="text" name="name" class="form-control" id="criteria-name" placeholder="Название"></div>
            <div class="form-group"><label for="criteria-range">Ранг:</label>
             <input type="text" name="range" class="form-control" id="criteria-range" placeholder="Ранг"></div>
             <div class="form-group"><label for="criteria-weight">Вес:</label>
             <input type="text" name="weight" class="form-control" id="criteria-weight" placeholder="Вес"></div>
            <div class="form-group">
            <label for="criteria-type">Тип: </label>
              <select class="form-control" id="criteria-type" name="type">
                <c:forEach var="elem" items="${typeList}">
                  <option value="${elem}">${elem.value}</option>
                </c:forEach>
              </select>
            </div>
            <div class="form-group">
            <label for="criteria-type">Тип оптимизации: </label>
              <select class="form-control" id="criteria-type" name="optimType">
                <c:forEach var="elem" items="${optimalityTypeList}">
                  <option value="${elem}">${elem.value}</option>
                </c:forEach>
              </select>
            </div>

            <div class="form-group"><label for="criteria-scale">Еденица измерения:</label>
            <input type="text" name="units" class="form-control" id="criteria-scale" placeholder="Еденица измерения"></div>
            <div class="form-group">
              <label for="criteria-type">Тип шкалы: </label>
              <select class="form-control" id="criteria-type" name="scaleType">
                <c:forEach var="elem" items="${scaleTypeList}">
                  <option value="${elem}">${elem.value}</option>
                </c:forEach>
              </select>
            </div>

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
    <table class="table">
      <thead>
      <tr>
        <th>Criteria name</th>
        <th>Criteria type</th>
        <th>Criteria optimality</th>
        <th>Units</th>
        <th>Scale type</th>
        <th></th>
      </tr>
      </thead>
      <tbody>
      <c:forEach var="criteria" items="${criteriaList}">
        <tr>
          <td>${criteria.name}</td>
          <td>${criteria.type.value}</td>
          <td>${criteria.optimType.value}</td>
          <td>${criteria.units}</td>
          <td>${criteria.scaleType.value}</td>
          <td>
            <a href="#" class="action-link" data-id="${criteria.id}">Preview</a>
            <a href="#" class="action-link" data-id="${criteria.id}">Update</a>
            <a href="#" class="action-link last" data-id="${criteria.id}">Remove</a>
          </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
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
</body>

</html>