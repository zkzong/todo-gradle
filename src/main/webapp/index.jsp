<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>todo</title>
    <script type="text/javascript">
      function addTodo() {
        var name = document.getElementById("name").value;
        var list = document.getElementById("list");
        list.innerHTML = list.innerHTML + "<p>" + name + "</p>";
      }
    </script>
  </head>
  <body>
    <h1>todo-web版</h1>
    <label>请输入待办事项名称：</label><input id="name" type="text" />
    <button onclick="addTodo()">添加</button>
    <h3>待办事项列表：</h3>
    <div id="list"></div>
  </body>
</html>
