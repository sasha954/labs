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
            <li class="nav-item active">
              <a class="nav-link" href="/alternatives">Alternative <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
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
    <p class="h3">Alternative</p>
  </div>
  <div class="form-container row">
    <div class="form-wrapper">
      <form action="" method="post">
        <div class="form-group">
          <label for="alternative-name">Alternative name:</label>
          <input type="text" class="form-control" id="alternative-name" name="name"/>
        </div>
        <div class="form-group">
          <input type="submit" class="btn btn-primary half-width" value="Create">
        </div>
      </form>
    </div>
  </div>
  <div class="content-wrapper row">
    <ul class="data-list">
      <li class="data-list__elem__header">

      </li>
      <c:forEach var="elem" items="${alternativeList}">
        <li>${elem.id} | ${elem.name}</li>
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
</body>

</html>
