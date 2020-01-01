<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/30
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<jsp:include page="../../commons/jqCss.jsp"></jsp:include>
<style>
    li{
        list-style: none;
    }
</style>
<body>
    <div class="container">
        <div class="row" style="height: 84px" >
            <img src="/commons/img/u5.png">
        </div>
        <div class="row">
            <div class="col-md-3" style="height: 600px">
                <ul class="list-group" id="systemListPage">
                </ul>
            </div>
            <div class="col-md-8" style="height: 600px;background: #f7e1b5;">
                <div id="depa" class="col-md-4"></div>
                <div id="job" class="col-md-4"></div>
                <div id="right" class="col-md-4"></div>
            </div>
        </div>
    </div>
</body>
<script type="text/javascript">
    $(function () {
        showSystemList();
    })
    function showSystemList() {
        $.ajax({
            url:"http://localhost:8091/rights/"+0,
            type:"get",
            dataType:"json",
            success:function (result) {
                if ("200" == result.code){
                    var systemListPage="";
                    var systemList=result.data;
                    for (var i = 0; i < systemList.length; i++) {
                        if (0 == systemList[i].pid){
                            systemListPage+='<a href="#javascript:void(0);" onclick="secondShow('+systemList[i].id+')">\n' +
                                '                        <li class="list-group-item">\n' +
                                '                                <span id="systemSpan_'+systemList[i].id+'" class="glyphicon glyphicon-chevron-right">'+systemList[i].rightName+'</span>\n'+
                                '                                <div id="second_'+systemList[i].id+'"><div>'+
                                '                        </li>\n' +
                                '              </a>';
                        }
                    }
                    $("#systemListPage").html(systemListPage);
                }
            }
        })
    }
    function secondShow(pId) {
        $.ajax({
            url:"http://localhost:8091/rights/"+pId,
            type:"get",
            dataType:"json",
            success:function (result) {
                if ("200" == result.code){
                    var systemList=result.data;
                    var secondPage="";
                    for (var i = 0; i < systemList.length; i++) {
                        if (0 != systemList[i].pid && pId == systemList[i].pid){
                            secondPage+='<ul>\n' +
                                '                        <a href="#javascript:void(0);">\n' +
                                '                            <li><span class="glyphicon glyphicon-menu-right">'+systemList[i].rightName+'</span></li>\n' +
                                '                        </a>\n' +
                                '                    </ul>';
                        }
                    }
                    $("#second_"+pId).html(secondPage);
                }
            }
        })
        $("#systemSpan_"+pId).attr("class","glyphicon glyphicon-chevron-down");
    }
</script>
</html>
