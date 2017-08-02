<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head><title>首页</title></head>
<body>
    <!-- 缴费专区 -->
    <table border="0" width="670" cellspacing="0" cellpadding="5">
            <tr height="35"><td style="text-indent:5" valign="bottom"><font color="#004790"><b>■推荐信息</b>『缴费专区』</font></td></tr>
            <tr bgcolor="#FAFCF5">
                <td style="border:1 solid">
                    <table border="0" width="100%" cellspacing="0" cellpadding="0">	
                    <c:choose>
                    	<c:when test="${payinfoList==null || payinfoList.size()==0 }">
                    		<tr height="30"><td align="center" style="border:1 solid">★★★ 缴费后，您发布信息就可在这里显示！★★★</td></tr>
                    	</c:when>
                    	<c:otherwise>
                    		<c:forEach var="payinfo" items="${payinfoList }" varStatus="status">
                    			<c:if test="${status.index%2==0 }">
                    				<tr height="23">                    				
                    			</c:if>
                    				<td width="50%">『<b>${payinfo.typeName }</b>』<a href="cityinfo/info!detailsInfo?id=${payinfo.id }">${payinfo.title }</a></td>
                    			<c:if test="${status.index%2==1 }">
	                    			</tr>
                    			</c:if>
                    		</c:forEach>
                    	</c:otherwise>
                    </c:choose>
                	</table>
                </td>
            </tr> 
    </table>
    <!-- 广告 -->
        <table border="0" width="670"cellspacing="0" cellpadding="0" style="margin-top:1">
            <tr><td align="center"><img src="images/pcard2.jpg"></td></tr>
        </table>        
    <!-- 免费专区 -->
    <table border="0" width="670" cellspacing="2" cellpadding="0">
            <tr height="35"><td colspan="2" style="text-indent:5" valign="bottom"><font color="#004790"><b>■最新信息</b>『免费专区』</font></td></tr>
            <c:choose>
            	<c:when test="${allFreeList==null || allFreeList.size()==0 }">
            		<tr height="30"><td align="center" style="border:1 solid">★★★ 在这里显示免费发布的信息！★★★</td></tr>
            	</c:when>
            	<c:otherwise>
            		<c:forEach var="subFreeList" items="${allFreeList }" varStatus="allstatus">
            				<c:if test="${allstatus.index%2==0 }">
	            				<tr>
                    		</c:if>
            				<td align="center">
								<table border="1" cellspacing="0" cellpadding="0" width="332" height="160" rules="none" bordercolor="lightgrey" bordercolorlight="lightgrey" bordercolordark="white">
									<c:forEach var="subFree" items="${subFreeList }" varStatus="oneStatus">
										<tr bgcolor="#00B48F" height="30">
											<c:if test="${oneStatus.index==0 }">
									            <td style="text-indent:10"><b><font color="white">▲${subFree.typeName }</font></b></td>      
											</c:if>
											<tr bgcolor="#FAFCF5"><td style="text-indent:3">★ <a href="cityinfo/info!detailsInfo?id=${subFree.id }">${subFree.title }</a></td></tr>
											<c:if test="${oneStatus.last }">
												<tr height="20" bgcolor="#FAFCF5"><td align="right"><a href="cityinfo/info!getInfoByType?typeId=${subFree.typeId }">更多...</a>&nbsp;&nbsp;</td></tr>
											</c:if>
								        </tr>
									</c:forEach>
								</table>
							</td>
							<c:if test="${allstatus.index%2==1 }">
	                    			</tr>
                    		</c:if>
            		</c:forEach>
            	</c:otherwise>
            </c:choose>            
    </table>
</body>
</html>