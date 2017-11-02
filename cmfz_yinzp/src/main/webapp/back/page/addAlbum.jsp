<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<script type="text/javascript">

</script>
<form id="saveAlbumForm" method="post" enctype="multipart/form-data">

    <div style="text-align: center; ">
        <div style="margin: 70px 0px 10px 0px">
            <input type="file" name="multipartFile" value="选择文件吧，骚年" />
        </div>
        <div style="margin: 10px 0px 10px 0px">
            专辑名字:<input name="title" class="easyui-textbox"   data-options="iconCls:'icon-star'"/>
        </div>
        <div style="margin: 10px 0px 10px 0px">
            专辑级数:<input name="setCount" class="easyui-textbox"  data-options=""  />
        </div>
        <div style="margin: 10px 0px 10px 0px">
            专辑评分:<input name="score" class="easyui-textbox"  data-options=""  />
        </div>
        <div style="margin: 10px 0px 10px 0px">
            专辑作者:<input name="author" class="easyui-textbox"  data-options=""  />
        </div>
        <div style="margin: 10px 0px 10px 0px">
            专辑播音:<input name="broadcast" class="easyui-textbox"  data-options=""  />
        </div>
        <div style="margin: 10px 0px 10px 0px">
            专辑简介:<input name="brief" class="easyui-textbox"  data-options=""  />
        </div>
        <div>
            专辑状态：上架：<input type="radio" name="status" value="Y"/>
            下架：<input type="radio" name="status" value="N"/>
        </div>
    </div>

</form>