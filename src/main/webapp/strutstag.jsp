<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<!-- <input type="radio" name="sex" value="女"/>女
	<input type="radio" name="sex" value="nan"/>男 -->
	
	<!-- <input type="checkbox" name="sex" value="女"/>女 -->
	
	<!-- form标签 -->
	<s:form>
		<!-- 1 普通输入项 -->
		<s:textfield name="username" label="username"></s:textfield>
		
		<!-- 2 密码输入项 -->
		<s:password name="password" label="password"></s:password>
		
		<!-- 3 单选输入项 -->
		<!-- value属性值和显示值一样的 -->
		<s:radio list="{'女','男'}" name="sex" label="性别"></s:radio>
		
		<!-- value属性值和显示值不一样的 -->
		<s:radio list="#{'nv':'女','nan':'男'}" name="sex1" label="性别"></s:radio>
		
		<!-- 4 复习输入项 -->
		<s:checkboxlist list="{'吃饭','睡觉','敲代码'}" name="love" label="爱好"></s:checkboxlist>
		
		<!-- 5 下拉输入框 -->
		<s:select list="{'幼儿园','博士后','教授'}" name="college" label="学历"></s:select>	
	
		<!-- 6 文件上传项 -->
		<s:file name="file" label="上传文件"></s:file>
		
		<!-- 7 隐藏项 -->
		<s:hidden name="hid" value="abcd"></s:hidden>
		
		<!--  文本域 --> 
		<s:textarea rows="10" cols="3" name="resume" label="简历"></s:textarea>
		
		<!-- 8 提交按钮 -->
		<s:submit value="提交"></s:submit>
		
		<!-- 9 重置 -->
		<s:reset value="重置"></s:reset>
	</s:form>
</body>
</html>



