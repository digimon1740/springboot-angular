<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>

	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<title>CMS | CMS 정산 현황</title>

	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="font-awesome/css/font-awesome.css" rel="stylesheet">
	<link href="css/plugins/iCheck/custom.css" rel="stylesheet">
	<link href="css/animate.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">
	<link href="css/common.css" rel="stylesheet">
</head>

<body>

<div id="wrapper">

	<nav class="navbar-default navbar-static-side" role="navigation">
		<div class="sidebar-collapse">
			<ul class="nav metismenu" id="side-menu">
				<li class="nav-header">
					<div class="dropdown profile-element">
						<a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <span class="clear"> <span class="block m-t-xs"> <strong
									class="font-bold">David Williams</strong>
                             </span> <span class="text-muted text-xs block">Art Director <b
									class="caret"></b></span> </span> </a>
						<ul class="dropdown-menu animated fadeInRight m-t-xs">
							<li><a href="/logout">Logout</a></li>
						</ul>
					</div>
					<div class="logo-element">
						IN+
					</div>
				</li>
				<li class="active">
					<a href="index.html"><i class="fa fa-th-large"></i> <span class="nav-label">CMS 관리</span> <span
							class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a href="/list">CMS 목록</a></li>
						<li class="active"><a href="/calculate">CMS 정산 현황</a></li>
					</ul>
				</li>
				<%--<li>--%>
				<%--<a href="minor.html"><i class="fa fa-th-large"></i> <span class="nav-label">CMS 정산 현황</span> </a>--%>
				<%--</li>--%>
			</ul>

		</div>
	</nav>

	<div id="page-wrapper" class="gray-bg">
		<div class="row border-bottom">
			<nav class="navbar navbar-static-top white-bg" role="navigation" style="margin-bottom: 0">
				<ul class="nav navbar-top-links navbar-right">
					<li>
						<a href="/logout">
							<i class="fa fa-sign-out"></i> Log out
						</a>
					</li>
				</ul>
			</nav>
		</div>
		<div class="row wrapper border-bottom white-bg page-heading">
			<div class="col-lg-10">
				<h2>CMS 정산 현황</h2>
				<ol class="breadcrumb">
					<li>
						<a href="index.html">Home</a>
					</li>
					<li>
						<a>CMS 관리</a>
					</li>
					<li class="active">
						<strong>CMS 정산 현황  <a href="#"><i class="fa fa-refresh"></i></a></strong>
					</li>
				</ol>
			</div>
			<div class="col-lg-2">

			</div>
		</div>
		<div class="wrapper wrapper-content">
			<div class="row">
				<div class="col-lg-12">
					<div class="ibox-content">
						<div class="before">
							<div class="mail-box-header">
								<div class="mail-tools tooltip-demo m-t-md">
									<select class="form-control component-margin" style="width:80px;float:left;">
										<option selected value="2016">2016년</option>
										<option value="2017">2017년</option>
										<option value="2018">2018년</option>
										<option value="2019">2019년</option>
									</select>
									<select class="form-control component-margin" style="width:60px;float:left;">
										<option selected value="1">1월</option>
										<option value="2">2월</option>
										<option value="3">3월</option>
										<option value="4">4월</option>
										<option value="5">5월</option>
										<option value="6">6월</option>
										<option value="7">7월</option>
										<option value="8">8월</option>
										<option value="9">9월</option>
										<option value="10">10월</option>
										<option value="11">11월</option>
										<option value="12">12월</option>
									</select>
									<div class="input-group search-container">
										<input type="text" class="form-control input-sm" name="search"
											   placeholder="키워드를 입력하여 주세요">
										<div class="input-group-btn">
											<button type="submit" class="btn btn-sm btn-primary">
												Search
											</button>
										</div>
									</div>
									<div class="input-group search-container">
										<button class="btn btn-outline btn-success btn-sm component-margin" type="button">
											<i class="fa fa-download"></i>
											세금계산서
										</button>
										<button class="btn btn-outline btn-success btn-sm component-margin" type="button">
											<i class="fa fa-download"></i>
											지역사업자
										</button>
									</div>
									<div style="clear:both;"/>
								</div>
							</div>
						</div>
						<div class="table-responsive">
							<table class="table table-bordered table-striped cms-wrap-table">
								<thead>
								<tr class="cms-table-header">
									<th>본사</th>
									<th>총판</th>
									<th>대리점 코드</th>
									<th>대리점주명</th>
									<th>가맹점</th>
									<th>출금</th>
									<th>미수</th>
									<th>정산액</th>
									<th>가맹점 코드</th>
									<th>가맹점명</th>
									<th>대표자명</th>
									<th>출금일</th>
									<th>출금액</th>
									<th>공급가액</th>
									<th>부가세</th>
									<th>입금액</th>
								</tr>
								<tr class="cms-cal-header">
									<td></td>
									<td></td>
									<!-- 대리점 코드 ~ 정산액 -->
									<td></td>
									<td></td>
									<td>13</td>
									<td>12</td>
									<td>1</td>
									<td>65,000,000</td>
									<!-- 가맹점 코드 ~ 출금일 -->
									<td colspan="4"></td>
									<!-- 출금액 -->
									<td>561,000</td>
									<!-- 공급가액 ~ 입금액 -->
									<td>255,000</td>
									<td>25,500</td>
									<td>280,500</td>
								</tr>
								</thead>
								<tbody>
								<tr>
									<!-- 본사 -->
									<td>
										<table class="table table-bordered cms-table-no-border">
											<tbody>
											<tr>
												<td>헬로월드 (50)</td>
											</tr>
											</tbody>
										</table>
									</td>
									<!-- 총판 -->
									<td>
										<table class="table table-bordered cms-table-no-border">
											<tbody>
											<tr>
												<td>성광기획 (20)</td>
											</tr>
											<tr>
												<td>SPNC (29)</td>
											</tr>
											</tbody>
										</table>
									</td>
									<!-- 대리점 코드 ~ 정산액 -->
									<td colspan="6">
										<table class="table table-bordered cms-table-agency">
											<tbody>
											<tr>
												<td width="121px">##</td>
												<td width="117px">지역사업자명</td>
												<td width="80px">##</td>
												<td width="63px">##</td>
												<td width="63px">##</td>
												<td width="131px">5,000,000</td>
											</tr>
											<tr>
												<td>##</td>
												<td>지역사업자명</td>
												<td>##</td>
												<td>##</td>
												<td>##</td>
												<td></td>
											</tr>
											<tr>
												<td>##</td>
												<td>지역사업자명</td>
												<td>##</td>
												<td>##</td>
												<td>##</td>
												<td></td>
											</tr>
											<tr>
												<td>##</td>
												<td>지역사업자명</td>
												<td>##</td>
												<td>##</td>
												<td>##</td>
												<td></td>
											</tr>
											<tr>
												<td>##</td>
												<td>지역사업자명</td>
												<td>##</td>
												<td>##</td>
												<td>##</td>
												<td></td>
											</tr>
											<tr>
												<td>##</td>
												<td>지역사업자명</td>
												<td>##</td>
												<td>##</td>
												<td>##</td>
												<td></td>
											</tr>
											<tr>
												<td>##</td>
												<td>지역사업자명</td>
												<td>##</td>
												<td>##</td>
												<td>##</td>
												<td></td>
											</tr>
											<tr>
												<td>##</td>
												<td>지역사업자명</td>
												<td>##</td>
												<td>##</td>
												<td>##</td>
												<td></td>
											</tr>
											<tr>
												<td>##</td>
												<td>지역사업자명</td>
												<td>##</td>
												<td>##</td>
												<td>##</td>
												<td></td>
											</tr>
											<tr>
												<td>##</td>
												<td>지역사업자명</td>
												<td>##</td>
												<td>##</td>
												<td>##</td>
												<td></td>
											</tr>
											<tr>
												<td>##</td>
												<td>지역사업자명</td>
												<td>##</td>
												<td>##</td>
												<td>##</td>
												<td></td>
											</tr>
											<tr>
												<td>##</td>
												<td>지역사업자명</td>
												<td>##</td>
												<td>##</td>
												<td>##</td>
												<td></td>
											</tr>
											<tr>
												<td>##</td>
												<td>지역사업자명</td>
												<td>##</td>
												<td>##</td>
												<td>##</td>
												<td></td>
											</tr>
											</tbody>
										</table>
									</td>
									<!-- 가맹점 코드 ~ 출금일 -->
									<td colspan="4">
										<table class="table table-bordered cms-table-agency">
											<tbody>
											<tr>
												<td width="138px">##</td>
												<td width="111px">1마리 치킨</td>
												<td width="112px">대표자명</td>
												<td width="93px">5일</td>
											</tr>
											<tr>
												<td>##</td>
												<td>1마리 치킨</td>
												<td>대표자명</td>
												<td>5일</td>
											</tr>
											<tr>
												<td>##</td>
												<td>1마리 치킨</td>
												<td>대표자명</td>
												<td>5일</td>
											</tr>
											<tr>
												<td>##</td>
												<td>1마리 치킨</td>
												<td>대표자명</td>
												<td>5일</td>
											</tr>
											<tr>
												<td>##</td>
												<td>1마리 치킨</td>
												<td>대표자명</td>
												<td>5일</td>
											</tr>
											<tr>
												<td>##</td>
												<td>1마리 치킨</td>
												<td>대표자명</td>
												<td>5일</td>
											</tr>
											<tr>
												<td>##</td>
												<td>1마리 치킨</td>
												<td>대표자명</td>
												<td>5일</td>
											</tr>
											<tr>
												<td>##</td>
												<td>1마리 치킨</td>
												<td>대표자명</td>
												<td>5일</td>
											</tr>
											<tr>
												<td>##</td>
												<td>1마리 치킨</td>
												<td>대표자명</td>
												<td>5일</td>
											</tr>
											<tr>
												<td>##</td>
												<td>1마리 치킨</td>
												<td>대표자명</td>
												<td>5일</td>
											</tr>
											<tr>
												<td>##</td>
												<td>1마리 치킨</td>
												<td>대표자명</td>
												<td>5일</td>
											</tr>
											<tr>
												<td>##</td>
												<td>1마리 치킨</td>
												<td>대표자명</td>
												<td>5일</td>
											</tr>
											<tr>
												<td>##</td>
												<td>1마리 치킨</td>
												<td>대표자명</td>
												<td>5일</td>
											</tr>
											<tr>
												<td>##</td>
												<td>1마리 치킨</td>
												<td>대표자명</td>
												<td>5일</td>
											</tr>
											<tr>
												<td>##</td>
												<td>1마리 치킨</td>
												<td>대표자명</td>
												<td>5일</td>
											</tr>
											<tr>
												<td>##</td>
												<td>1마리 치킨</td>
												<td>대표자명</td>
												<td>5일</td>
											</tr>
											<tr>
												<td>##</td>
												<td>1마리 치킨</td>
												<td>대표자명</td>
												<td>5일</td>
											</tr>
											</tbody>
										</table>
									</td>
									<!-- 출금액 ~ 입금 -->
									<td colspan="4">
										<table class="table table-bordered cms-table-agency">
											<tbody>
											<tr>
												<td width="73px">33,000</td>
												<td width="73px">15,000</td>
												<td width="66px">1,500</td>
												<td width="75px">16,500</td>
											</tr>
											<tr>
												<td>33,000</td>
												<td>15,000</td>
												<td>1,500</td>
												<td>16,500</td>
											</tr>
											<tr>
												<td>33,000</td>
												<td>15,000</td>
												<td>1,500</td>
												<td>16,500</td>
											</tr>
											<tr>
												<td>33,000</td>
												<td>15,000</td>
												<td>1,500</td>
												<td>16,500</td>
											</tr>
											<tr>
												<td>33,000</td>
												<td>15,000</td>
												<td>1,500</td>
												<td>16,500</td>
											</tr>
											<tr>
												<td>33,000</td>
												<td>15,000</td>
												<td>1,500</td>
												<td>16,500</td>
											</tr>
											<tr>
												<td>33,000</td>
												<td>15,000</td>
												<td>1,500</td>
												<td>16,500</td>
											</tr>
											<tr>
												<td>33,000</td>
												<td>15,000</td>
												<td>1,500</td>
												<td>16,500</td>
											</tr>
											<tr>
												<td>33,000</td>
												<td>15,000</td>
												<td>1,500</td>
												<td>16,500</td>
											</tr>
											<tr>
												<td>33,000</td>
												<td>15,000</td>
												<td>1,500</td>
												<td>16,500</td>
											</tr>
											<tr>
												<td>33,000</td>
												<td>15,000</td>
												<td>1,500</td>
												<td>16,500</td>
											</tr>
											<tr>
												<td>33,000</td>
												<td>15,000</td>
												<td>1,500</td>
												<td>16,500</td>
											</tr>
											<tr>
												<td>33,000</td>
												<td>15,000</td>
												<td>1,500</td>
												<td>16,500</td>
											</tr>
											<tr>
												<td>33,000</td>
												<td>15,000</td>
												<td>1,500</td>
												<td>16,500</td>
											</tr>
											<tr>
												<td>33,000</td>
												<td>15,000</td>
												<td>1,500</td>
												<td>16,500</td>
											</tr>
											<tr>
												<td>33,000</td>
												<td>15,000</td>
												<td>1,500</td>
												<td>16,500</td>
											</tr>
											<tr>
												<td>33,000</td>
												<td>15,000</td>
												<td>1,500</td>
												<td>16,500</td>
											</tr>
											</tbody>
										</table>
									</td>
								</tr>
								</tbody>
							</table>
						</div>

					</div>
				</div>
			</div>

		</div>
	</div>

</div>
</div>


<!-- Mainly scripts -->
<script src="js/jquery-2.1.1.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

<!-- Peity -->
<script src="js/plugins/peity/jquery.peity.min.js"></script>

<!-- Custom and plugin javascript -->
<script src="js/inspinia.js"></script>
<script src="js/plugins/pace/pace.min.js"></script>

<!-- iCheck -->
<script src="js/plugins/iCheck/icheck.min.js"></script>

<!-- Peity -->
<script src="js/demo/peity-demo.js"></script>

<script>
	$(document).ready(function () {
		$('.i-checks').iCheck({
			checkboxClass: 'icheckbox_square-green',
			radioClass: 'iradio_square-green',
		});
	});
</script>

</body>

</html>

