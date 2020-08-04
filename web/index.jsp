<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Rent Rooms Daily</title>
  <script src="https://kit.fontawesome.com/83ff4f7960.js" crossorigin="anonymous"></script>
  <link rel = "shortcut icon" type = "image/png" href="images/shortcutIcon.png">
  <link rel="stylesheet" type="text/css" href="css/bootstrap3.css">
  <link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body>

<jsp:include page="Jsp/Board.jsp"/>

<div class="container">
  <div class="jumbotron" >
    <h1> <i class="fa fa-home"></i>Find Your Dream Apartment </h1>
    <p>We help you in finding the aparement you've been looking for </p>
  </div>
  <jsp:include page="Jsp/AllRooms.jsp"/>

  <div class="container">
    <div class="aboutClass">
      <h1> For More information please contact us on mail: contact@apartments.com </h1>
    </div>
  </div>
</div>

<script
        src="https://code.jquery.com/jquery-2.2.4.js"
        integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
        crossorigin="anonymous">
</script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>

