<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<script type="text/javascript">

</script>
<form id="saveFileForm" method="post" enctype="multipart/form-data">

    <div style="text-align: center; ">
        <div style="margin: 70px 0px 10px 0px">
            <input type="file" name="multipartFile" value="选择文件吧，骚年" />
        </div>
        <div style="margin: 10px 0px 10px 0px">
            文件描述:<input name="descs" class="easyui-textbox"   data-options="iconCls:'icon-star'"/>
        </div>
        <div style="margin: 10px 0px 10px 0px">

            <div>
                文件状态：上架：<input type="radio" name="status" value="Y"/>
                下架：<input type="radio" name="status" value="N"/>
            </div>
        </div>
    </div>

</form>