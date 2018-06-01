<html>
  <head></head>
  <style>
    h1 {
      color: blue;
    }
    .red {
      color: red;
    }
    .green {
      color: green;
    }
  </style>
  <body>
    <h1>Message : ${message} </h1>
    <h1 class="red">Message1 : ${message1} </h1>
    <h1 class="green">Message2 : ${message2} </h1>

    <form action="tests/jsp-test" method="post">
      <input type="text" name="line1"/>
      <input type="text" name="line2"/>
      <input type="submit" value="Send"/>
    </form>
  </body>
</html>