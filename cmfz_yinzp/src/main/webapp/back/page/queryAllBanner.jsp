<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<script type="text/javascript">
    var $dg;
    $(function () {
        $dg = $("#dg");
        $dg.datagrid({
            url: '/cmfz_yinzp/banner/all',
            fitColumns: true,
            fit: true,
            striped: true,
            remoteSort: false,
            ctrlSelect: true,
            columns: [[{
                title: "图片名称",
                field: "oldName",
                align: "center",
                width: 100,
                sortable: true,

            }, {
                title: "状态",
                field: "status",
                width: 100,
                align: "center",
                sortable: true,
                editor:{
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
                }
            }, {

                title: "图片描述",
                field: "descs",
                width: 100,
                align: "center",
                sortable: true,

                editor:{
                    type:'textbox',
                    options:{
                        required:true,

                    }
                }

            }, {
                title: "上传时间",
                field: "bir",
                width: 100,
                align: "center",
                formatter: function (value) {
                    var date = new Date(value);
                    var y = date.getFullYear();
                    var m = date.getMonth() + 1;
                    var d = date.getDate();
                    return y + '-' + m + '-' + d;
                },
                sortable: true,

            }, {
                title: "操作",
                field: "options",
                width: 200,
                align: "center",
                sortable: true,

                formatter: function (value, row, index) {
                    return "<a href='javascript:;' class='upd' onClick=\"updRow('" + index + "',this)\">修改</a><a href='javascript:;' onClick=\"saveRow('" + index + "');\" class='save' style='display:none' class='easyui-linkbutton'>保存</a>"
                }
            }
            ]
            ],
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                console.log("++++++++"+rowData.descs)
                return  "<img src='/cmfz_yinzp/back/uplod/"+rowData.name+"' style='height:100px;width:100px;float:left;margin:5px 5px 5px 5px;'/>"+
                    "<p style='padding-top:5px'>"+"轮播图名称:&nbsp;"+rowData.name +"</p>"+
                    "<p style='padding-top:5px'>"+"轮播图描述:&nbsp;"+rowData.descs +"</p>"+
                    "<p style='padding-top:5px'>"+"轮播图状态:&nbsp;"+rowData.status +"</p>";
                },
                onLoadSuccess: function () {
                $(".upd").linkbutton({plain: true, iconCls: 'icon-bullet_edit'})
                $(".save").linkbutton({plain: true, iconCls: 'icon-save'});
            },
            toolbar: '#userdatagridtb',
            loadMsg: '请稍后....',
            pagination: true,
            onAfterEdit:function (index,row,changes) {
                $.ajax({
                    url:"/cmfz_yinzp/banner/update",
                    data:JSON.stringify(row),
                    type:"POST",
                    contentType:"application/json",
                    success:function (result) {
                        $("#dg").datagrid('reload');
                    }
                })
            }
        })
    })
    //    这是修改
    function updRow(index,current) {
        $("#dg").datagrid('beginEdit',index);
        $(current).css("display","none");
        $(current).next().css("display","inline");
    }
    //这是保存用户
    function saveUser() {
        $("#saveFileForm").form('submit', {
            url: "/cmfz_yinzp/banner/add",
            success: function (result) {//无论成功和失败都会进入success
                console.log(result);
                result = $.parseJSON(result);
                $("#saveuserDialog").dialog('close', true);//关闭对话框
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
                $("#dg").datagrid('reload');
            }
        });
    }
    //    保存一个用户
    function saveUser() {
        $("#saveFileForm").form('submit', {
            url: "/cmfz_yinzp/banner/add",
            success: function (result) {//无论成功和失败都会进入success
                result = $.parseJSON(result);
                $("#saveuserDialog").dialog('close', true);//关闭对话框
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
                $("#dg").datagrid('reload');
            }
        });

    }
    function closeSaveUserDialog(){
        $("#saveuserDialog").dialog('close',true);//关闭对话框
    }
    //    打开保存用户对话框
    function openUserDialog(){
        $("#saveuserDialog").dialog({
            title:'保存用户',
            width:600,
            height:400,
            href:'/cmfz_yinzp/back/page/addBanner.jsp',
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                handler:saveUser,
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:closeSaveUserDialog,
            }]

        });

    }
    //    点击事件
    function saveRow(index){
        $dg.datagrid('endEdit',index);
        //数据加载完成渲染删除 和  修改按钮
        $(".upd").linkbutton({plain:true,iconCls:'icon-edit'});
        $(".save").linkbutton({plain:true,iconCls:'icon-save'});
    }
//    修改密码

</script>

<table id="dg"></table>
<div id="userdatagridtb">
    <a class="easyui-linkbutton" onclick="openUserDialog();" data-options="iconCls:'icon-add',plain:false">添加</a>
</div>
<div id="saveuserDialog">

</div>
`