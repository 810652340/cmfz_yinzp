<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<script type="text/javascript">
    var $Logdg;
    $(function () {
        $Logdg = $("#Logdg");
        $Logdg.datagrid({
            url: '/cmfz_yinzp/log/all',
            fitColumns: true,
            fit: true,
            striped: true,
            remoteSort: false,
            ctrlSelect: true,
            columns: [[{
                title: "姓名",
                field: "username",
                align: "center",
                width: 100,
                sortable: true,

            }, {
                title: "创建时间",
                field: "date",
                width: 100,
                align: "center",
            }, {

                title: "事件",
                field: "doSomething",
                width: 100,
                align: "center",
                sortable: true,
            },{

                title: "状态",
                field: "status",
                width: 100,
                align: "center",
                sortable: true,
            }
            ]
            ],

        })
    })


</script>

<table id="Logdg"></table>


