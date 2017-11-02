<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<script type="text/javascript">
    var $usdg;
    $(function () {
        $usdg = $("#usdg");
        $usdg.datagrid({
            url: '/cmfz_yinzp/user/all',
            fitColumns: true,
            fit: true,
            striped: true,
            remoteSort: false,
            ctrlSelect: true,
            columns: [[{
                title: "手机号",
                field: "phone",
                align: "center",
                width: 100,
                sortable: true,

            }, {
                title: "昵称",
                field: "nickname",
                width: 100,
                align: "center",
            }, {

                title: "法号",
                field: "farmington",
                width: 100,
                align: "center",
                sortable: true,
            },{

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
                title: "上师",
                field: "gurn",
                width: 100,
                align: "center",
                formatter: function (value,row,index) {
                    return row.children.name
                },
                sortable: true,

            }, {
                title: "操作",
                field: "options",
                width: 200,
                align: "center",
                sortable: true,

                formatter: function (value, row, index) {
                    return "<a href='javascript:;' class='updUs' onClick=\"updUsRow('" + index + "',this)\">修改</a><a href='javascript:;' onClick=\"saveUsRow('" + index + "');\" class='saveUs' style='display:none' class='easyui-linkbutton'>保存</a>"
                }
            }
            ]
            ],
            onLoadSuccess: function () {
                $(".updUs").linkbutton({plain: true, iconCls: 'icon-bullet_edit'})
                $(".saveUs").linkbutton({plain: true, iconCls: 'icon-save'});
            },
            toolbar: '#usdatagridtb',
            loadMsg: '请稍后....',
            pagination: true,
            onAfterEdit:function (index,row,changes) {
                $.ajax({
                    url:"/cmfz_yinzp/user/update",
                    data:JSON.stringify(row),
                    type:"POST",
                    contentType:"application/json",
                    success:function (result) {
                        $("#usdg").datagrid('reload');
                    }
                })
            }
        })
    })
    //    这是修改
    function updUsRow(index,current) {
        $("#usdg").datagrid('beginEdit',index);
        $(current).css("display","none");
        $(current).next().css("display","inline");
    }
//    保存修改
    function saveUsRow(index){
        $usdg.datagrid('endEdit',index);
        //数据加载完成渲染删除 和  修改按钮
        $(".updUs").linkbutton({plain:true,iconCls:'icon-edit'});
        $(".saveUs").linkbutton({plain:true,iconCls:'icon-save'});
    }

</script>

<table id="usdg"></table>
<div id="usdatagridtb">
    <a class="easyui-linkbutton" onclick="openUsDialog();" data-options="iconCls:'icon-add',plain:false">导入</a>
    <a class="easyui-linkbutton" onclick="openUseDialog();" data-options="iconCls:'icon-add',plain:false">导出</a>
</div>

