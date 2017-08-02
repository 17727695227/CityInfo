<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head><title>后台-侧栏</title></head>
<script type="text/javascript">
	function checkForm(){
		var typeId=document.getElementById("typeId").value;
		if(typeId==null || typeId==""){
			alert("请选择信息类别！");
			return;
		}else{
			document.getElementById("searchForm").submit();
		}
	}
</script>
<body background="images/back.gif">
    <center>
        <table border="0" width="220" height="100%" cellspacing="0" cellpadding="0" style="margin-top:7">
            <!-- 显示方式 -->
            <tr height="30" bgcolor="#F0F0F0"><td style="text-indent:5;border:1 solid"><font color="#004790"><b>■显示方式</b></font></td></tr>
            <tr height="1"><td></td></tr>
            <form id="searchForm" action="cityinfo/admin!searchInfo" method="post">
            <tr>
                <td align="center" valign="top" style="border:1 solid">
                    <table border="0" width="220" height="150" rules="all" cellspacing="0">
                        <tr>
                            <td align="center" colspan="2">
                                <fieldset style="height:60;width:210">
                                  <legend>★付费状态</legend>
                                  <br>
                                  <input id="payfor1" value="1" type="radio"  name="payfor" />已付费
                                  <input id="payfor2" value="0" type="radio"  name="payfor" />未付费
                                  <input id="payfor3" value="all" type="radio"  name="payfor" checked="checked"/>全部
                                </fieldset>
                                <fieldset style="height:60;width:210">
                                  <legend>★审核状态</legend>
                                  <br>
                                  <input id="state1" value="1" type="radio"  name="state" />已审核
                                  <input id="state2" value="0" type="radio"  name="state" />未审核
                                  <input id="state3" value="all" type="radio"  name="state" checked="checked"/>全部
                                </fieldset>
                            </td>
                        </tr>
                        <tr align="center" height="30" bgcolor="lightgrey">
                            <td>
                               信息类别：
                       <select id="typeId" name="typeId">
                       		<option value="">请选择...</option>
                       		<c:forEach var="infoType" items="${infoTypeList }">
                       			<option value="${infoType.id }">${infoType.typeName }</option>
                       		</c:forEach>
                       </select>     
                       <input type="button" onclick="checkForm()" value="查询"/>   
                            </td>
                        </tr>
                        
                    </table>
                </td>
            </tr>
            </form>
            <tr height="5"><td></td></tr>
           
            <tr height="5"><td></td></tr>
            <tr height="30" bgcolor="#F0F0F0"><td style="text-indent:5;border:1 solid"><font color="#004790"><b>■日历</b></font></td></tr>
            <tr height="1"><td></td></tr>
            <!-- 日历 -->            
            <tr height="130">
                <td valign="top" style="border:1 solid"><jsp:include page="/pages/calendar.jsp"/></td>
            </tr>
        </table>        
    </center>
</body>
<script type="text/javascript">

// 付费状态设置
setRadioBoxSelect("payfor",'${payfor}');
// 审核状态设置
setRadioBoxSelect("state","${state}");
// 设置信息类别
document.getElementById("typeId").value='${typeId}';
 
function setRadioBoxSelect(radioName,radiovalue){
	var obj = document.getElementsByName(radioName);
    for(i = 0; i < obj.length; i++){  
      if(obj[i].value == radiovalue){  
        obj[i].checked = true;
      }  
    }
}
</script>
</html>