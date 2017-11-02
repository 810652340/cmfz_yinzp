    <%@page pageEncoding="UTF-8" isELIgnored="false" contentType="text/html; UTF-8" %>
   <script src="${pageContext.request.contextPath}/back/easyUi/echarts.min.js"></script>
    <script src="${pageContext.request.contextPath}/back/easyUi/china.js"></script>
    <script type="text/javascript">
        var myeChart = echarts.init(document.getElementById('city'));

        $.ajax({
            url:'${pageContext.request.contextPath}/user/city',
            dataType:'json',
            success:function (data) {
                var option = {
                    title : {
                        text: 'app用户地区分布',
                        subtext: '地区分布',
                        left: 'center'
                    },
                    tooltip : {
                        trigger: 'item'
                    },
                    legend: {
                        orient: 'vertical',
                        left: 'left',
                        data:['用户分布']
                    },
                    visualMap: {
                        min: 0,
                        max: 35000,
                        left: 'left',
                        top: 'bottom',
                        text:['高','低'],           // 文本，默认为数值文本
                        calculable : true
                    },
                    toolbox: {
                        show: true,
                        orient : 'vertical',
                        left: 'right',
                        top: 'center',
                        feature : {
                            mark : {show: true},
                            dataView : {show: true, readOnly: false},
                            restore : {show: true},
                            saveAsImage : {show: true}
                        }
                    },
                    series : [
                        {
                            name: '用户分布',
                            type: 'map',
                            mapType: 'china',
                            roam: false,
                            label: {
                                normal: {
                                    show: false
                                },
                                emphasis: {
                                    show: true
                                }
                            },
                            data:data
                        },
                    ]
                };

                myeChart.setOption(option);
            }

        })





    </script>
    <div id="city" style="width: 600px;height: 400px"></div>
