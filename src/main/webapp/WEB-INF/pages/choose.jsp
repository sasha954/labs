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
            <li class="nav-item">
              <a class="nav-link" href="/users">Пользователи</a>
            </li>
            <li class="nav-item active">
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
    <p class="h3">Результат</p>
  </div>
  <div class="form-choose-wrapper">
    <c:if test="${not empty firstAlter and not empty secondAlter and empty winner}">
    <form method="post" action="/results/choose-alternative">
      <div class="form-control-wrapper">
        <c:if test="${not empty firstAlter}">
          <div class="alternative">
            <p class="h5">${firstAlter.alternative.name}</p>
            <ul>
              <li class="header">
                <div class="header-title">Критерий</div>
                <div class="header-title">Оценка</div>
              </li>
              <c:forEach var="criteria" items="${firstAlter.alternative.mark}">
                <li class="criteria-item">
                  <div class="criteria-elem">${criteria.criterion.name}</div>
                  <div class="criteria-elem">${criteria.name}</div>
                </li>
              </c:forEach>
            </ul>
          </div>
        </c:if>
        <c:if test="${not empty secondAlter}">
          <div class="alternative">
            <p class="h5">${secondAlter.alternative.name}</p>
            <ul>
              <li class="header">
                <div class="header-title">Критерий</div>
                <div class="header-title">Оценка</div>
              </li>
              <c:forEach var="criteria" items="${secondAlter.alternative.mark}">
                <li class="criteria-item">
                  <div class="criteria-elem">${criteria.criterion.name}</div>
                  <div class="criteria-elem">${criteria.name}</div>
                </li>
              </c:forEach>
            </ul>
          </div>
        </c:if>

      </div>
      <div class="radio-button-wrapper">
        <div class="radio">
          <label for="left-alternative"><input type="radio" name="alternative-value" value="left-alternative"
                                               id="left-alternative">Выбрать ${firstAlter.alternative.name}</label>

        </div>
        <div class="radio">
          <label for="equals"><input type="radio" name="alternative-value" value="equals" id="equals">Равны</label>

        </div>
        <div class="radio">
          <label for="right-alternative"><input type="radio" name="alternative-value" value="right-alternative"
                                                id="right-alternative">Выбрать ${secondAlter.alternative.name}</label>

        </div>
      </div>
      <input type="submit" class="btn btn-success make-choose" value="Голосовать">
    </form>
    </c:if>
    <c:if test="${not empty winner}">
      <div class="content-wrapper row">
        <c:forEach var="alternative" items="${winner}">
          <c:if test="${fn:length(alternative.mark) gt 0}">
            <div class="mark-list-wrapper">
              <ul class="mark-list">
                <li class="mark-list__header h6">${alternative.name}</li>
                <c:forEach var="mark" items="${alternative.mark}">
                  <li class="mark-list__item">${mark.criterion.name} <span class="mark-list__mark-value">${mark.name}</span>

                    <!-- <div class="actions">
              <a class="action-link" data-action="update" data-id="${mark.id}" href="#">Редактировать</a>
              <a class="action-link" data-action="preview" data-id="${mark.id}" href="#">Просмотр</a>
              <a class="action-link last" data-action="remove" data-id="${mark.id}" href="#">Удалить</a>
            </div>--></li>
                </c:forEach>
              </ul>
            </div>
          </c:if>
        </c:forEach>
      </div>
      <form method="post" action="/results/clear">
        <input type="submit" class="btn btn-success make-choose" value="Заново">
      </form>
    </c:if>
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