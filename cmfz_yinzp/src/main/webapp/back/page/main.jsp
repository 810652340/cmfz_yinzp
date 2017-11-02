<%@page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>持名法州主页</title>
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/themes/gray/easyui.css">
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/themes/IconExtension.css">
   <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyUi/jquery.js"></script>
   <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyUi/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyUi/datagrid-detailview.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/editor/kindeditor-all-min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/editor/lang/zh-CN.js"></script>
    <script>
        var $aa;
        $(function(){
            $aa = $("#aa");

            //发送异步请求  加载菜单数据
            $.get("/cmfz_yinzp/menu/all",function(result){
                //console.log(result);
                //遍历一级菜单
                $.each(result,function(idx,menu){
                    //遍历二级菜单
                    var content ="<div style='text-align:center;'>";
                    $.each(menu.children,function(idx,child){
                        //console.log(child);
                        //console.log(child.href);
                        console.log(child.href);
                        console.log(child.iconCls);
                        console.log(child.title);
                        var args = child.href+"#"+child.iconCls+"#"+child.title;
                        content += "<div class='easyui-linkbutton' onClick=\"addTabs('"+args+"');\" data-options=\" plain:true,iconCls:'"+ child.iconCls +"' \" style='border-radius:5%;margin:5px 0px 5px 0px;width:90%;border: 1px solid #95B8E7;'>"+child.title+"</div><br/>";
                    });
                    content +="</div>";
                    //添加一个新的菜单项
                    $aa.accordion('add',{
                        title:menu.title,
                        iconCls:menu.iconCls,
                        selected:menu.selected,
                        content:content,

                    });
                });
            },"JSON");



        });
        //跳转路径
        function addTabs(args){
            var arg = args.split("#");
            var href = arg[0];
            var iconCls = arg[1];
            console.log("href"+href);
            console.log(iconCls);
            var title = arg[2];
            console.log(title)
            //判断当前选项卡容器中有没有添加的选项卡
            if(!$("#tt").tabs('exists',title)){
                $("#tt").tabs('add',{
                    title:title,
                    iconCls:iconCls,
                    closable:true,
                    href:href,
                    tools:[
                        {
                            iconCls:'icon-reload',
                            handler:refershTab,
                        }],
                });
            }else{//选中当前面板
                $("#tt").tabs('select',title);
            }
        }

        //刷新当前选项卡
        function refershTab(){
            //返回当前选项卡面板
            var tab = $("#tt").tabs('getSelected');
            //调用面板方法
            tab.panel('refresh');
        }
//这是修改密码
        function updatePassword(){
            $("#savePasswordDialog").dialog({
                title:'修改密码',
                width:600,
                height:400,
                href:'/cmfz_yinzp/back/page/updateAdmini.jsp',
                buttons:[{
                    text:'修改',
                    iconCls:'icon-save',
                    handler:saveAdmini,
                },{
                    text:'关闭',
                    iconCls:'icon-cancel',
                    handler:closeSavePasswordDialog,
                }]

            });

        }
//        保存用户
        function saveAdmini() {
            $("#saveAdminiForm").form('submit', {
                url: "/cmfz_yinzp/admini/update",
                success: function (result) {//无论成功和失败都会进入success

                    $("#savePasswordDialog").dialog('close', true);//关闭对话框

                }
            });

        }
        function closeSavePasswordDialog(){
            $("#savePasswordDialog").dialog('close',true);//关闭对话框
        }
    </script>
</head>
<body class="easyui-layout">   
    <div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    	<div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
    	<div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:${sessionScope.name.name} &nbsp;<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onclick="updatePassword()">修改密码</a>&nbsp;&nbsp;<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a></div>
    </div>   
    <div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    	<div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育</div>
    </div>   
       
    <div data-options="region:'west',title:'导航菜单'" style="width:220px;">
        <div id="aa" class="easyui-accordion" data-options="fit:true" >

        </div>
    </div>   
    <div data-options="region:'center'">
    	<div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">   
		    <div title="主页" data-options="iconCls:'icon-neighbourhood',"  style="background-image:url(../img/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
		</div>  
    </div>
    <div id="savePasswordDialog">

    </div>
</body> 
</html>