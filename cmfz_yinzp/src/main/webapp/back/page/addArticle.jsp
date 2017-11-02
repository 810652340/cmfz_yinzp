<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/editor/kindeditor-all-min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/editor/lang/zh-CN.js"></script>
<script>
    KindEditor.create('#content', {
        afterBlur: function () { this.sync(); },
        //basePath:'${pageContext.request.contextPath}/back/editor/',
        uploadJson:'${pageContext.request.contextPath}/article/save',
        filePostName:'multipartFile'

    })
    $(function () {
        $("#ss").combobox({
            url:'/cmfz_yinzp/guru/one',
            textField:'name',
            valueField:'id'
        })
    })
</script>
<form id="saveArticleForm" method="post" enctype="multipart/form-data">

    <div style="text-align: center; ">
        <div style="margin: 70px 0px 10px 0px">
            <input type="file" name="multipartFile" value="选择文件吧，骚年" />
        </div>
        <div style="margin: 10px 0px 10px 0px">
            文章名字:<input name="title" class="easyui-textbox"   data-options="iconCls:'icon-star'"/>
        </div>
        <div style="margin: 10px 0px 10px 0px">
            <div>
                文章状态：上架：<input type="radio" name="status" value="Y"/>
                下架：<input type="radio" name="status" value="N"/>
            </div>
        </div>
        <div style="margin: 10px 0px 10px 0px">
            喜欢哪个上师,选一个吧年轻人：<input id="ss" name="guruid">
        </div>
        <div style="margin: 10px 0px 10px 0px">
            <textarea id="content" name="texts" style="width:700px;height:300px;" />
        </div>

    </div>

</form>