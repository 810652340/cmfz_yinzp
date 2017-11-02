<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<script type="text/javascript">
    $(function () {
        $("#zj").combobox({
            url:'/cmfz_yinzp/album/all',
            textField:'title',
            valueField:'id'
        })
    })
</script>
<form id="saveChapterForm" method="post" enctype="multipart/form-data">

    <div style="text-align: center; ">
        <div style="margin: 70px 0px 10px 0px">
            <input type="file" name="multipartFile" class="easyui-filebox" dataoptions="accept:'.mp3',label:'选择文件吧，骚年'"/>
        </div>
        <div style="margin: 10px 0px 10px 0px">
            <div>
                音乐状态：上架：<input type="radio" name="status" value="Y"/>
                下架：<input type="radio" name="status" value="N"/>
            </div>
        </div>
        <div style="margin: 10px 0px 10px 0px">
            喜欢哪个专辑,选一个吧年轻人：<input id="zj" name="albumId">
        </div>

    </div>

</form>