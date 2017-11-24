<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <!-- 引入 ECharts 文件 -->
        <script src="echarts.min.js"></script>
    </head>
    <body>
        Hello,${student.name?if_exists}
        --------<br/>
        <table>
            <#list studentList as student>
                <tr>
                    <td>${student["name"]! "null"}</td>
                    <td>${student["age"]! "null"}</td>
                </tr>
            </#list>
        </table>
    </body>
</html>