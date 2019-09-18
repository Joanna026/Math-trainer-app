<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: joanna
  Date: 9/17/19
  Time: 2:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DwaxDwa</title>
</head>
<body>
${exercise.title}<br/>
${exercise.content}

<div>
    <form action="${pageContext.request.contextPath}/student/exercise?index=${index}&collectionId=${collectionId}"  method="post">
        <input name ="answer" type="text"/><br/>
<%--        <input type="hidden" name="collectionId" value="${collectionId}"/>--%>
<%--        <input type="hidden" name="index" value="${index}"/>--%>
        <input type="hidden" name="correctAnswer" value="${exercise.correctAnswer}"/>
        <input type="submit" value="ok"/>
    </form>
</div>
</body>
</html>
