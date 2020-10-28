<%-- JSP 页面本质上是一个 Servlet，页面中的 HTML 标签都是通过 Response 输出流打印的 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户登录</title>
    <%
        //这是代码脚本
        String basePath = request.getScheme() + "://"
                + request.getServerName() + ":"
                + request.getServerPort()
                + request.getContextPath() + "/";

        //四大内置对象：pageContext, requestScope, sessionScope, applicationScope
        pageContext.setAttribute("basePath", basePath);

    %>

    <%-- 这是表达式脚本 --%>
    <%= basePath %>

    <%--
        base标签只能位于 head 标签内，注意顺序，要先赋值到 pageScope 中再取出来
        base标签中 href 的设置，让页面中所有 href 都基于该值
        ${ xxxScope.key } 等价 <%= xxxScope.getAttribute(key) %>
     --%>
    <base href="${basePath}">
    <base href="<%= basePath %>">
</head>
<body>
<form method="get" action="${basePath}user/login">
    账号：<input name="userId" placeholder="请输入用户名" type="text"/><br/>
    密码：<input name="password" placeholder="请输入密码" type="password"/><br/>
    <input type="submit" value="登录"/>
</form>
<%-- 基于 --%>
<a href="pages/test.jsp">返回首页</a>

</body>
</html>
