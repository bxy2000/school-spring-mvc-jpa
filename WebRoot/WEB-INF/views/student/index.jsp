<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>通讯录</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/pages/css/style.css" type="text/css" />
<script type="text/javascript">
	function selectAll(checked) {
		var checkits = document.getElementsByName("checkit");

		for (var i = 0; i < checkits.length; i++) {
			checkits[i].checked = checked;
		}
	}

	function batDelete() {
		if (!confirm('确认删除吗？')) {
			return;
		}

		document.frmIndex.submit();
	}

	function searchText() {
		var searchText = document.frmIndex.search.value;

		location.href = "${pageContext.request.contextPath}/student/index/1?word="
				+ encodeURI(searchText);
	}
</script>
</head>
<body>
	<div id="container">
		<jsp:include page="../share/header.jsp" />
		<div id="main">
			<form name="frmIndex" action="${pageContext.request.contextPath}/student/batdelete" method="post">
				<table>
					<tr>
						<td colspan="7">
							<ul class="button">
								<li><a href="${pageContext.request.contextPath}/student/create">新增</a></li>
								<li><a href="#" onclick="batDelete()">删除</a></li>
							</ul>
						</td>
						<td colspan="4"><input type="text" name="search" value="" style="float: left; margin-top: 4px; width: 200px;" />
							<ul style="float: left" class="button">
								<li><a href="#" onclick="searchText()">搜索</a></li>
							</ul></td>
					</tr> 
					<tr>
						<th rowspan="2"><input type="checkbox" name="checkAll" onclick="selectAll(this.checked)" /></th>
						<th rowspan="2">学号</th>
						<th rowspan="2">姓名</th>
						<th rowspan="2">性别</th>
						<th rowspan="2">生日</th>
						<th rowspan="2">电话</th>
						<th rowspan="2">email</th>
						<th colspan="3">家庭住址</th>
						<th rowspan="2">操作</th>
					</tr>
					<tr>
						<th>省份</th>
						<th>城市</th>
						<th>住址</th>
					</tr>
					<c:forEach var="student" items="${students.content }" varStatus="status">
						<c:choose>
							<c:when test="${status.index % 2 == 1 }">
								<tr style="background-color: #E0EEE0">
							</c:when>
							<c:otherwise>
								<tr>
							</c:otherwise>
						</c:choose>

						<td class="text-center"><input type="checkbox" name="checkit" value="${student.id}" /></td>
						<td class="text-center">${student.studentNumber}</td>
						<td>${student.studentName}</td>
						<td class="text-center">${student.gender}</td>
						<td class="text-center">${student.birthday}</td>
						<td>${student.mobile}</td>
						<td>${student.email}</td>
						<td>${student.province}</td>
						<td>${student.city}</td>
						<td>${student.address}</td>
						<td class="text-center">
							<ul class="button">
								<li><a href="${pageContext.request.contextPath}/student/edit/${student.id}">编辑</a></li>
								<li><a href="${pageContext.request.contextPath}/student/delete/${student.id}" onclick="return confirm('确认删除吗？')">删除</a></li>
							</ul>
						</td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="11">
							<ul class="button page">
								<li class="space">第${students.number+1}/${students.totalPages}页</li>
								<c:if test="${!students.first }">
									<li><a href="${pageContext.request.contextPath}/student/index/1?word=${param.word}">&lt;&lt;</a></li>
								</c:if>
								<c:forEach var="p" begin="1" end="${students.totalPages }" step="1">
									<li><a href="${pageContext.request.contextPath}/student/index/${p}?word=${param.word}">${p }</a></li>									
								</c:forEach>
								<c:if test="${!students.last }">
									<li><a href="${pageContext.request.contextPath}/student/index/${students.totalPages}?word=${param.word}">&gt;&gt;</a></li>
								</c:if>
							</ul>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<jsp:include page="../share/footer.jsp" />
	</div>
	
</body>
</html>