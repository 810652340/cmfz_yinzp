<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<script type="text/javascript">
    var $guru;
    $(function () {
        $gurudg = $("#gurudg");
        $gurudg.datagrid({
            url: '/cmfz_yinzp/guru/all',
            fitColumns: true,
            fit: true,
            striped: true,
            remoteSort: false,
            ctrlSelect: true,
            columns: [[{
                title: "上师名字",
                field: "name",
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
                            value: '正常'
                        },{
                            label: 'N',
                            value: '封禁'
                        }]
                    }
                }
            }, {
                title: "操作",
                field: "options",
                width: 200,
                align: "center",
                sortable: true,

                formatter: function (value, row, index) {
                    return "<a href='javascript:;' class='updguru' onClick=\"updGuruRow('" + index + "',this)\">修改</a><a href='javascript:;' onClick=\"saveGuruRow('" + index + "');\" class='saveguru' style='display:none' class='easyui-linkbutton'>保存</a>"
                }
            }
            ]
            ],
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                console.log("++++++++"+rowData.descs)
                return  "<img src='/cmfz_yinzp/back/uplod/"+rowData.headpic+"' style='height:100px;width:100px;float:left;margin:5px 5px 5px 5px;'/>"+
                    "<p style='padding-top:5px'>"+"上师名称:&nbsp;"+rowData.name +"</p>"+
                    "<p style='padding-top:5px'>"+"上师状态:&nbsp;"+rowData.status +"</p>";
                },
                onLoadSuccess: function () {
                $(".updguru").linkbutton({plain: true, iconCls: 'icon-bullet_edit'})
                $(".saveguru").linkbutton({plain: true, iconCls: 'icon-save'});
            },
            toolbar: '#gurudatagridtb',
            loadMsg: '请稍后....',
            pagination: true,
            onAfterEdit:function (index,row,changes) {
                $.ajax({
                    url:"/cmfz_yinzp/guru/update",
                    data:JSON.stringify(row),
                    type:"POST",
                    contentType:"application/json",
                    success:function (result) {
                        $("#gurudg").datagrid('reload');
                    }
                })
            }
        })
    })
    //    这是修改
    function updGuruRow(index,current) {
        $("#gurudg").datagrid('beginEdit',index);
        $(current).css("display","none");
        $(current).next().css("display","inline");
    }
    //这是保存用户
    function saveguru() {
        $("#saveGuruForm").form('submit', {
            url: "/cmfz_yinzp/guru/add",
            success: function (result) {//无论成功和失败都会进入success
                console.log(result);
                result = $.parseJSON(result);
                $("#saveguruDialog").dialog('close', true);//关闭对话框
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
                $("#gurudg").datagrid('reload');
            }
        });
    }
    function closeSaveguruDialog(){
        $("#saveguruDialog").dialog('close',true);//关闭对话框
    }
    //    打开保存用户对话框
    function openGuruDialog(){
        $("#saveguruDialog").dialog({
            title:'保存用户',
            width:600,
            height:400,
            href:'/cmfz_yinzp/back/page/addGuru.jsp',
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                handler:saveguru,
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:closeSaveguruDialog,
            }]

        });

    }
    //    点击事件
    function saveGuruRow(index){
        $gurudg.datagrid('endEdit',index);
        //数据加载完成渲染删除 和  修改按钮
        $(".updguru").linkbutton({plain:true,iconCls:'icon-edit'});
        $(".saveguru").linkbutton({plain:true,iconCls:'icon-save'});
    }
//    修改密码

</script>

<table id="gurudg"></table>
<div id="gurudatagridtb">
    <a class="easyui-linkbutton" onclick="openGuruDialog();" data-options="iconCls:'icon-add',plain:false">添加</a>
</div>
<div id="saveguruDialog">

</div>
`