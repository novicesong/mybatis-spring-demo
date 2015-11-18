<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/api/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>论坛报名</title>
    <link rel="stylesheet" href="css/jquery.mobile-1.4.5.min.css">
    <script src="js/jquery-1.10.2.js"></script>
    <script src="js/jquery/jquery.json-2.2.min.js"></script>
    <script src="js/common.js"></script>
    <script src="js/jquery.mobile-1.4.5.min.js"></script>
    <script>
        (function (window, $) {

            var pathName = window.location.pathname;
            var projectName = pathName.substr(0, pathName.substr(1).indexOf('/') + 1);

            var dekota = {

                url: '',

                init: function () {
                    dekota.url = '<%=basePath%>';
                    $("#btn-sign").click(dekota.addPerson);

                },
                addPerson: function () {
                    var jsonData = $("#add-user-frm").serializeObject();
                    $.ajax({
                        url: dekota.url + 'person',
                        type: 'POST',
                        dataType: 'json',
                        data: jsonData
                    }).done(function (data, status, xhr) {
                        alert("ok");
//                        window.location = projectName + "/user/listUser";
                    }).fail(function (xhr, status, error) {
                        alert("error");
                    });
                }
            };
            window.dekota = (window.dekota) ? window.dekota : dekota;
            $(function () {
                dekota.init();
            });
        })(window, jQuery);
    </script>
    <style>
        .noshadow * {
            -webkit-box-shadow: none !important;
            -moz-box-shadow: none !important;
            box-shadow: none !important;
        }

        form.ui-mini .ui-field-contain fieldset.ui-controlgroup legend small {
            color: #666;
        }
    </style>
</head>
<body>
<div data-role="page" id="testpage">

    <div data-role="header" data-position="fixed">
        <h1>注册</h1>
        <a href="#" data-rel="back" style="display:none;"
           class="ui-btn ui-corner-all ui-shadow ui-icon-back ui-btn-icon-left ui-btn-icon-notext">Back</a>
        <a href="#" style="display:none;"
           class="ui-btn ui-corner-all ui-shadow ui-btn-icon-left ui-icon-gear">Button</a>

        <div data-role="navbar">
            <ul style="display:none;">
                <li><a href="#" class="ui-btn-active ui-state-persist">Menu item 1</a></li>
                <li><a href="#">Menu item 2</a></li>
                <li><a href="#">Menu item 3</a></li>
            </ul>
        </div>
    </div>
    <!-- /header -->

    <div class="ui-content" role="main">
        <form id="add-user-frm">
            <div class="ui-field-contain">
                <label>姓名： <span style="color:red">*</span></label>
                <input type="text" name="userName" id="userName" value="" data-clear-btn="true">
            </div>
            <div class="ui-field-contain">
                <label>密码： <span style="color:red">*</span></label>
                <input type="text" name="password" id="password" value="" data-clear-btn="true">
            </div>
            <div class="ui-field-contain">
                <a href="#" class="ui-btn ui-corner-all ui-shadow ui-btn-active" id="btn-sign">报 名</a>
            </div>
        </form>

    </div>
    <!-- /content -->

    <div data-role="footer" data-position="fixed">
        <div data-role="navbar">
            <ul style="display:none;">
                <li><a href="#">Menu item 1</a></li>
                <li><a href="#" class="ui-btn-active ui-state-persist">Menu item 2</a></li>
                <li><a href="#">Menu item 3</a></li>
            </ul>
        </div>
        <h4 style="display:none;">Footer</h4>
    </div>

</div>
<!-- /page -->

</body>
</html>