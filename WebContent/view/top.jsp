<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=gbk">
  <title>页眉</title>
</head>
<body>
    <center>
        <table border="0" width="100%" cellspacing="0" cellpadding="0">
            <!-- 顶部菜单 -->
            <tr height="20">
                <td style="text-indent:10" valign="bottom">
                    <a href="cityinfo/info!preparedAddInfo" style="color:gray">[发布信息]</a>
                    <a href="cityinfo/user!isLogin" style="color:gray">[进入后台]</a>
                </td>
                <td align="right" valign="bottom">
                    <a href="#" style="color:gray" onclick="this.style.behavior='url(#default#homepage)';this.setHomePage('http://localhost:8080/CityInfo');">设为主页 -</a>
                    <a href="javascript:window.external.AddFavorite('http://localhost:8080/CityInfo','都市供求信息网')" style="color:gray">收藏本页 -</a>
                    <a href="mailto:123@***.com.cn" style="color:gray">联系我们</a>
                    &nbsp;
                </td>
            </tr>
            <!-- 导航菜单 -->
            <tr height="56">
                <td align="center" width="220" background="images/logo.gif"></td>
                <td align="right" background="images/menu.gif">
                	<c:choose>
                		<c:when test="${infoTypeList==null || infoTypeList.size()==0 }">
                			没有信息类别可以显示！
                		</c:when>
                		<c:otherwise>
                			<table border="0" width="600">
                            <tr align="center">
                               	    <td width="100"><font><a href="" style="color:white">首&nbsp;&nbsp;&nbsp;&nbsp;页</a></font></td>
                               	    <c:forEach var="infoType" items="${infoTypeList }" varStatus="status">
                               	    		<td width="100"><a href="cityinfo/info!getInfoByType?typeId=${infoType.id }" style="color:white">${infoType.typeName }</a></td>
                               	    		<c:if test="${status.index==4 }">
                               	    			 </tr>
                          					  <tr align="center">
                               	    		</c:if>
                               	    </c:forEach>
                        </table>
                		</c:otherwise>
                	</c:choose>
                        
                </td>
            </tr>
        </table>
        <table border="0" width="100%" height="90" cellspacing="0" cellpadding="0" style="margin-top:1">
            <tr><td align="center"><a href="" target="_blank"><img src="images/pcard1.jpg"></a></td></tr>
        </table>
    </center>
</body>
</html>