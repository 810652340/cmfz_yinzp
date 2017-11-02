<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript">
    var $Articledg;
    $(function () {
        $Articledg = $("#Articledg");
        $Articledg.datagrid({
            url: '/cmfz_yinzp/article/all',
            fitColumns: true,
            fit: true,
            striped: true,
            remoteSort: false,
            ctrlSelect: true,
            columns: [[{
                title: "文章名称",
                field: "title",
                align: "center",
                width: 100,
                sortable: true,

            }, {

                title: "文章标题",
                field: "ext",
                width: 100,
                align: "center",
                sortable: true,
            }, {
                title: "状态",
                field: "status",
                width: 100,
                align: "center",
                editor: {
                    type:'combobox',
                    options:{
                        valueField: 'label',
                        textField: 'value',
                        data: [{
                            label: 'Y',
                            value: '上架'
                        },{
                            label: 'N',
                            value: '下架'
                        }]
                    }
                },
                sortable: true,
            },{
                title: "创建时间",
                field: "createDate",
                width: 100,
                align: "center",
                sortable: true,
            },{
                title: "操作",
                field: "options",
                width: 200,
                align: "center",
                sortable: true,

                formatter: function (value, row, index) {
                    return "<a href='javascript:;' class='updArticle' onClick=\"updArticleRow('" + index + "',this)\">修改</a><a href='javascript:;' onClick=\"saveArticleRow('" + index + "');\" class='saveArticle' style='display:none' class='easyui-linkbutton'>保存</a>"
                }
            }
            ]
            ],
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                console.log("++++++++"+rowData.descs)
                return  "<img src='/cmfz_yinzp/back/uplod/"+rowData.illustration+"' style='height:100px;width:100px;float:left;margin:5px 5px 5px 5px;'/>"+
                    "<p style='padding-top:5px'>"+"文章名称:&nbsp;"+rowData.ext +"</p>"+
                    "<p style='padding-top:5px'>"+"文章内容:&nbsp;"+rowData.texts +"</p>"

            },
            onLoadSuccess: function () {
                $(".updArticle").linkbutton({plain: true, iconCls: 'icon-bullet_edit'})
                $(".saveArticle").linkbutton({plain: true, iconCls: 'icon-save'});
            },
            toolbar: '#Articledatagridtb',
            loadMsg: '请稍后....',
            pagination: true,
            onAfterEdit:function (index,row,changes) {
                $.ajax({
                    url:"/cmfz_yinzp/article/update",
                    data:JSON.stringify(row),
                    type:"POST",
                    contentType:"application/json",
                    success:function (result) {
                        $("#Articledg").datagrid('reload');
                    }
                })
            }
        })
    })
    //    这是修改
    function updArticleRow(index,current) {
        $("#Articledg").datagrid('beginEdit',index);
        $(current).css("display","none");
        $(current).next().css("display","inline");
    }
    //这是保存用户
    function saveArticle() {
        $("#saveArticleForm").form('submit', {
            url: "/cmfz_yinzp/article/add",
            success: function (result) {//无论成功和失败都会进入success
                console.log(result);
                result = $.parseJSON(result);
                $("#saveArticleDialog").dialog('close', true);//关闭对话框
                if (result.success) {
                    $.messager.show({
                        title: "提示",
                        msg: result.message,
                    });
                } else {
                    $.messager.show({
                        title: "提示",
                        msg: result.message,
                    });
                }
                $("#Articledg").datagrid('reload');
            }
        });
    }
    //    保存一个用户
    function saveArticle() {
        $("#saveArticleForm").form('submit', {
            url: "/cmfz_yinzp/article/add",
            success: function (result) {//无论成功和失败都会进入success
                result = $.parseJSON(result);
                $("#saveArticleDialog").dialog('close', true);//关闭对话框
                if (result.success) {
                    $.messager.show({
                        title: "提示",
                        msg: result.message,
                    });
                } else {
                    $.messager.show({
                        title: "提示",
                        msg: result.message,
                    });
                }
                $("#Articledg").datagrid('reload');
            }
        });

    }
    function closeSaveArticleDialog(){
        $("#saveArticleDialog").dialog('close',true);//关闭对话框
    }
    //    打开保存用户对话框
    function openArticleDialog(){
        $("#saveArticleDialog").dialog({
            title:'保存用户',
            width:600,
            height:400,
            href:'/cmfz_yinzp/back/page/addArticle.jsp',
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                handler:saveArticle,
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:closeSaveArticleDialog,
            }]

        });

    }
    //    点击事件
    function saveArticleRow(index){
        $Articledg.datagrid('endEdit',index);
        //数据加载完成渲染删除 和  修改按钮
        $(".updArticle").linkbutton({plain:true,iconCls:'icon-edit'});
        $(".saveArticle").linkbutton({plain:true,iconCls:'icon-save'});
    }
    //    修改密码

</script>

<table id="Articledg"></table>
<div id="Articledatagridtb">
    <a class="easyui-linkbutton" onclick="openArticleDialog();" data-options="iconCls:'icon-add',plain:false">添加</a>
</div>
<div id="saveArticleDialog">

</div>
