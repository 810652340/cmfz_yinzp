    <%@page pageEncoding="UTF-8" isELIgnored="false" contentType="text/html; UTF-8" %>
    <script>
        $(function () {
            $('#ttreegrid').treegrid({
                url:'/cmfz_yinzp/album/all',
                idField:'id',
                fit: true,
                treeField:'title',
                columns:[[
                    {title:'名字',field:'title',width:180},
                    {field:'setCount',title:'级数',width:160,align:'right'},
                    {field:'author',title:'作者',width:180},
                    {field:'size',title:'大小',width:180},
                    {field:'status',title:'状态',width:180},
                    {field:'score',title:'评分',width:180},
                    {field:'options',title:'操作',width:100,
                        formatter: function (value, row, index) {
                            return "<a href='javascript:;' class='upd' onClick=\"downRow('" + index + "',this)\">下载</a>"
                        }
                    },

                ]],
                toolbar: '#addAlbum',
                onClickCell:playAudio
            });
        })
        function downRow(){
            var hehe=$("#ttreegrid").treegrid('getSelected');
            location.href="${pageContext.request.contextPath}/chapter/down?fileName="+hehe.newName;

        }
//        打开专辑
        function openAlubmDialog(){
            $("#saveAlbumDialog").dialog({
                title:'添加专辑',
                width:600,
                height:400,
                href:'/cmfz_yinzp/back/page/addAlbum.jsp',
                buttons:[{
                    text:'保存',
                    iconCls:'icon-save',
                    handler:saveAlbum,
                },{
                    text:'关闭',
                    iconCls:'icon-cancel',
                    handler:closeSaveAlbumDialog,
                }]

            });

        }
//        保存专辑
        function saveAlbum() {
            $("#saveAlbumForm").form('submit', {
                url: "/cmfz_yinzp/album/add",
                success: function (result) {//无论成功和失败都会进入success
                    $("#saveAlbumDialog").dialog('close', true);//关闭对话框
                    $("#ttreegrid").treegrid('reload');
                }
            });

        }
        function closeSaveAlbumDialog(){
            $("#saveAlbumDialog").dialog('close',true);//关闭对话框
        }

//        添加音乐
        function openChapterDialog(){
            $("#saveChapterDialog").dialog({
                title:'添加专辑',
                width:600,
                height:400,
                href:'/cmfz_yinzp/back/page/addChapter.jsp',
                buttons:[{
                    text:'保存',
                    iconCls:'icon-save',
                    handler:saveChapter,
                },{
                    text:'关闭',
                    iconCls:'icon-cancel',
                    handler:closeSaveChapterDialog,
                }]

            });

        }
        //        保存专辑
        function saveChapter() {
            $("#saveChapterForm").form('submit', {
                url: "/cmfz_yinzp/chapter/add",
                success: function (result) {//无论成功和失败都会进入success
                    $("#saveChapterDialog").dialog('close', true);//关闭对话框
                    $("#ttreegrid").treegrid('reload');
                }
            });

        }
        function closeSaveChapterDialog(){
            $("#saveChapterDialog").dialog('close',true);//关闭对话框
        }
        function playAudio(field,row){
            console.log(row);
            $("#audioDiv").dialog({
                title:'music-play',
                width:400,
                height:100,
                border:'thin',
                collapsible:true,
                iconCls:'icon-music',
                resizable:true,
                modal:true,
                resizable:false,
                content:'<div style="margin-top: 15px">'+
                '<audio src="${pageContext.request.contextPath}/back/album/'+row.newName+'" controls="controls">您的浏览器不支持H5的audio</audio></div>'
            });
        }
    </script>

    <table id="ttreegrid" style="width:600px;height:400px"></table>
    <div id="addAlbum">
        <a class="easyui-linkbutton" onclick="openAlubmDialog();" data-options="iconCls:'icon-add',plain:false">添加专辑</a>
        <a class="easyui-linkbutton" onclick="openChapterDialog();" data-options="iconCls:'icon-add',plain:false">添加音乐</a>
    </div>
    <div id="saveAlbumDialog">

    </div>
    <div id="saveChapterDialog">

    </div>
    <div id="audioDiv" style="text-align: center"></div>


