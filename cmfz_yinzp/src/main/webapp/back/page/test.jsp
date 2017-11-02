<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
    <script>
        KindEditor.create('#content', {

            basePath:'${pageContext.request.contextPath}/back/editor/',
            uploadJson:'${pageContext.request.contextPath}/',
            filePostName:'image'
        })
    </script>
<textarea id="content" name="content" style="width:700px;height:300px;">请输入内容</textarea>

