<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <jsp:include page="/commons/static.jsp"></jsp:include>
    <link rel="stylesheet" type="text/css" href="https://files.cnblogs.com/files/yjlblog/flat-ui.min.css"/>
    <link href="<%=request.getContextPath()%>/commons/live2d/assets/waifu.css" rel="stylesheet"/>
    <script type="text/javascript" src="<%=request.getContextPath()%>/commons/live2d/assets/waifu-tips.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/commons/live2d/assets/live2d.js"></script>


</head>

<body>

<div class="container">
    <div class="panel panel-danger">
        <!-- Default panel contents -->
        <div class="panel-heading"> <center>品牌列表</center></div>
        <div class="panel-heading">
            <center>
                <input type="button" value="新增" onclick="addUser()" class="btn btn-info "/>
                <a href="<%=request.getContextPath()%>/queryJsp?url=User/lookGo">版娘</a>
            </center>
        </div>
        <div class="bg-success">
            <table id="userTable" class="table table-bordered table-striped"></table>
        </div>
    </div>

</div>

<script >
    //展示
    var userTable = $("#userTable").DataTable({
        "autoWidth":true, //自适应宽度
        "info":true,//展示表格左下角信息,分页栏
        "lengthChange":true,//是否改变每页展示的条数
        "lengthMenu": [ 2, 5, 10 ],
        "ordering": false,//是否允许排序
        "paging": true,//是否允许开启本地分页
        "processing": true,//是否先处理状态
        "serverSide": true,//true是服务器模式，false是客户端模式
        //如何和后台进行交互并展示
        "ajax":{
            url:"http://localhost:8090/user/queryUser",
            type:"GET",
            "dataSrc":function (result) {
                return result.data;
            }
        },
        //数据如何展示到表格中
        "columns":[
            {"data":"id","title":"<input type=\"checkbox\" value=\"\" name=\"\" onclick='qx(this)'>",render:function(data, type, row, meta){
                    return '<input type="checkbox"  name="boxId" value="' + data +'">';

                }},

            {"data":"id","title":"编号"},

            {"data":"userName","title":"用户名字"},


            {data:"loginTime","title":"登陆时间",render:function (data, type, row, meta) {
                    if(data!=null){
                        return new Date(data).Format("yyyy-MM-dd");
                    }
                    return "";
                }},

            {data:"id","title":"操作",render:function (data, type, row, meta) {
                    return '<input type="button" value="修改" onclick=" updateUser('+ data +')" class="btn btn-info " />'
                        +'<input type="button" value="删除" onclick=" deleteUser('+ data +')" class="btn btn-info " />';
                }}
        ],
        "language":{
            "url":"<%=request.getContextPath()%>/commons/datatable/Chinese.json"
        }
    })


    //新增
    function addUser() {
        var addHTML="wwww";
        $.ajax({
            url:"<%=request.getContextPath()%>/jumpController/jumpPage",
            type:"post",
            data:{
              url:"User/addUser"
            },
            dataType:"html",
            async:false,
            success:function(success){
                addHTML=success;
            },
            error:function(){
                alert("遇到未知错误！");
            }
        });

        bootbox.dialog({
            title: '新增页面',
            message: addHTML,
            size: 'large',
            buttons: {
                cancel: {
                    label: "取消",
                    className: 'btn-danger',
                    callback: function(){
                        console.log('Custom cancel clicked');
                    }
                },
                ok: {
                    label: "增加",
                    className: 'btn-info',
                    callback: function(resourc){
                        if(resourc){
                            $.ajax({
                                url:"http://localhost:8090/user/toAddUser",
                                type:"PUT",
                                dataType:"json",
                                async:false,
                                data:$("#addUserForm").serialize(),
                                success:function(result){
                                    if(result.code){
                                        alert(res.message)
                                    }
                                    location.reload();
                                },
                                error:function(){
                                    alert("遇到未知错误！");
                                }
                            });
                        }

                    }
                },
            }
        })
    }



    function deleteUser(id) {
        $.ajax({
            url:"http://localhost:8090/user",
            type:"DELETE",
            dataType:"json",
            data:{
                id:id
            },
            async:false,
            success:function(result){
                if(result.code){
                    window.location.reload()
                }
                alert(result.message)
            },
            error:function(){
                alert("遇到未知错误！");
            }
        });

    }

    //修改
    function updateUser(id) {
        var togoHTML="wwww";
        $.ajax({
            url:"<%=request.getContextPath()%>/jumpController/togoUser",
            type:"post",
            dataType:"html",
            data:{
                id:id,
            },
            async:false,
            success:function(success){
                togoHTML=success;
            },
            error:function(){
                alert("遇到未知错误！");
            }
        });

        bootbox.dialog({
            title: '修改页面',
            message: togoHTML,
            size: 'large',
            buttons: {
                cancel: {
                    label: "取消",
                    className: 'btn-danger',
                    callback: function(){
                        console.log('Custom cancel clicked');
                    }
                },
                ok: {
                    label: "修改",
                    className: 'btn-info',
                    callback: function(resourc){
                        if(resourc){
                            $.ajax({
                                url:"http://localhost:8090/user/toAddUser",
                                type:"PUT",
                                dataType:"json",
                                async:false,
                                data:$("#updateUserFrom").serialize(),
                                success:function(result){
                                    if(result.code){
                                        alert(result.message)
                                    }
                                    location.reload();
                                },
                                error:function(){
                                    alert("遇到未知错误！");
                                }
                            });
                        }

                    }
                },
            }
        })
    }


</script>

</body>
</html>
