    <%@page pageEncoding="UTF-8" isELIgnored="false" contentType="text/html; UTF-8" %>
   <script src="${pageContext.request.contextPath}/back/easyUi/echarts.min.js"></script>
    <script type="text/javascript">
        var myeChart = echarts.init(document.getElementById('main'));

        $.ajax({
            url:'${pageContext.request.contextPath}/user/ac',
            dataType:'json',
            success:function(data){
                var option={
                    title:{
                        text:'活跃'
                    },
                    legend:{
                        data:['折线','柱状']
                    },
                    xAxis:{
                        data:['一周','两周','三周']
                    },
                    yAxis:{},
                    series:[{
                        name:'折线',
                        type:'line',
                        data:data
                    },{
                        name:'柱状',
                        type:'bar',
                        data:data
                    }]
                }
                myeChart.setOption(option);
            }
        })



    </script>
    <div id="main" style="width: 600px;height: 400px"></div>
