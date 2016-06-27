<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>

	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<title>CMS | CMS 목록</title>

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
						<li class="active"><a href="/list">CMS 목록</a></li>
						<li><a href="/calculate">CMS 정산 현황</a></li>
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
			<div class="col-lg-10 cms-list-breadcrumb">
				<h2>CMS 목록</h2>
				<ol class="breadcrumb">
					<li>
						<a href="index.html">Home</a>
					</li>
					<li>
						<a>CMS 관리</a>
					</li>
					<li class="active">
						<strong>CMS 목록 <a href="#"><i class="fa fa-refresh"></i></a></strong>
					</li>
				</ol>
			</div>

		</div>
		<div class="wrapper wrapper-content">
			<div class="row">
			</div>
			<!-- left tree -->
			<div class="col-lg-3">
				<div class="ibox float-e-margins">
					<div class="ibox-content mailbox-content">
						<div class="file-manager">

							<div class="space-8"></div>
							<!-- first level -->
							<ul class="folder-list m-b-md" style="padding: 0">
								<li><a href="#"> <i class="fa fa-chevron-down"></i> 헬로월드(본사) </a></li>
								<li>
									<!-- second level -->
									<ul class="folder-list navL navL-second-level">
										<li><a href="#"> <i class="fa fa-chevron-down"></i> 총판명(지역) </a></li>
										<li>
											<!-- third level -->
											<div style="clear:both;"></div>
											<ul class="navL navL-third-level">
												<li><a href="#"> <i></i> 가맹점주명(지역) </a></li>
											</ul>
											<ul class="navL navL-third-level">
												<li><a href="#"> <i></i> 가맹점주명(지역) </a></li>
											</ul>
										</li>
									</ul>
								</li>
								<li>
									<!-- second level -->
									<ul class="folder-list navL navL-second-level">
										<li><a href="#"> <i class="fa fa-chevron-down"></i> 총판명(지역) </a></li>
										<li>
											<!-- third level -->
											<div style="clear:both;"></div>
											<ul class="navL navL-third-level">
												<li><a href="#"> <i></i> 가맹점주명(지역) </a></li>
											</ul>
											<ul class="navL navL-third-level">
												<li><a href="#"> <i></i> 가맹점주명(지역) </a></li>
											</ul>
											<ul class="navL navL-third-level">
												<li><a href="#"> <i></i> 가맹점주명(지역) </a></li>
											</ul>
											<ul class="navL navL-third-level">
												<li><a href="#"> <i></i> 가맹점주명(지역) </a></li>
											</ul>
										</li>
									</ul>
								</li>
								<li>
									<!-- second level -->
									<ul class="folder-list navL navL-second-level">
										<li><a href="#"> <i class="fa fa-chevron-right"></i> 총판명(지역) </a></li>
									</ul>
								</li>
							</ul>

							<div class="clearfix"></div>
						</div>
					</div>
				</div>
			</div>
			<!-- right panel-->
			<div class="col-lg-9 animated fadeInRight">
				<div class="mail-box-header cms-list-header">
					<div class="mail-tools tooltip-demo m-t-md">
						<button class="btn btn-white btn-sm" data-toggle="tooltip" data-placement="top"
						        title="활성" style="float:left;">활성
						</button>
						<button class="btn btn-default btn-sm" data-toggle="tooltip" data-placement="top"
						        title="비활성" style="float:left;">비활성
						</button>
						<div class="cms-list-filter-panel">
							<select class="form-control component-margin cms-filter">
								<option selected>상태 필터</option>
								<option value="1">활성</option>
								<option value="0">비활성</option>
							</select>
							<select class="form-control component-margin cms-filter">
								<option selected>결제방식</option>
								<option value="cms">CMS</option>
								<option value="card">카드</option>
							</select>
							<select class="form-control component-margin cms-filter">
								<option selected>결제상태</option>
								<option value="1">정상출금</option>
								<option value="0">미출금</option>
							</select>
						</div>
						<div class="input-group search-container">
							<input type="text" class="form-control input-sm" name="search"
							       placeholder="가맹점주 이름이나 코드를 입력하세요">
							<div class="input-group-btn">
								<button type="submit" class="btn btn-sm btn-primary">
									Search
								</button>
							</div>
						</div>
						<div class="cms-list-btn-container">
							<button type="button" class="btn btn-primary btn-sm pull-right" data-toggle="modal"
							        data-target="#register-modal">신규 CMS 등록
							</button>
							<button class="btn btn-outline btn-success btn-sm component-margin" type="button">
								<i class="fa fa-download"></i>
								엑셀 다운로드
							</button>
						</div>
					</div>

				</div>
				<div class="mail-box">
					<!-- table area -->
					<%--<div class="gridStyle">--%>
					<div class="table-responsive">
						<table class="table table-bordered table-striped cms-list-wrap-table">
							<thead>
							<tr class="cms-list-table-header">
								<th>
									<input type="checkbox" class="i-checks" name="input[]"/>
								</th>
								<th>번호</th>
								<th>상태</th>
								<th>가맹점주코드</th>
								<th>가맹점주명</th>
								<th>결제방식</th>
								<th>마지막출금일</th>
								<th>결제상태</th>
								<th>출금예정일</th>
								<th>출금예정금액</th>
								<th></th>
							</tr>
							</thead>
							<tbody>
							<tr>
								<td>
									<input type="checkbox" class="i-checks" name="input[]"/>
								</td>
								<td>
									10
								</td>
								<td>
									활성
								</td>
								<td>
									145154
								</td>
								<td>
									이상훈
								</td>
								<td>
									CMS
								</td>
								<td>
									<a href="#" data-toggle="modal" data-target="#history-modal">2016.06.24 </a>
								</td>
								<td>
									정상 출금
								</td>
								<td>
									2016.07.24
								</td>
								<td>
									33,000원
								</td>
								<td>
									<a href="#" data-toggle="modal"
									   data-target="#register-modal">자세히</a>
								</td>
							</tr>
							<tr>
								<td>
									<input type="checkbox" class="i-checks" name="input[]"/>
								</td>
								<td>
									9
								</td>
								<td>
									활성
								</td>
								<td>
									145154
								</td>
								<td>
									이상훈
								</td>
								<td>
									CMS
								</td>
								<td>
									<a href="#" data-toggle="modal" data-target="#history-modal">2016.06.24 </a>
								</td>
								<td>
									정상 출금
								</td>
								<td>
									2016.07.24
								</td>
								<td>
									33,000원
								</td>
								<td>
									<a href="#" data-toggle="modal"
									   data-target="#register-modal">자세히</a>
								</td>
							</tr>
							<tr>
								<td>
									<input type="checkbox" class="i-checks" name="input[]"/>
								</td>
								<td>
									8
								</td>
								<td>
									활성
								</td>
								<td>
									145154
								</td>
								<td>
									이상훈
								</td>
								<td>
									CMS
								</td>
								<td>
									<a href="#" data-toggle="modal" data-target="#history-modal">2016.06.24 </a>
								</td>
								<td>
									정상 출금
								</td>
								<td>
									2016.07.24
								</td>
								<td>
									33,000원
								</td>
								<td>
									<a href="#" data-toggle="modal"
									   data-target="#register-modal">자세히</a>
								</td>
							</tr>
							<tr>
								<td>
									<input type="checkbox" class="i-checks" name="input[]"/>
								</td>
								<td>
									7
								</td>
								<td>
									활성
								</td>
								<td>
									145154
								</td>
								<td>
									이상훈
								</td>
								<td>
									CMS
								</td>
								<td>
									<a href="#" data-toggle="modal" data-target="#history-modal">2016.06.24 </a>
								</td>
								<td>
									정상 출금
								</td>
								<td>
									2016.07.24
								</td>
								<td>
									33,000원
								</td>
								<td>
									<a href="#" data-toggle="modal"
									   data-target="#register-modal">자세히</a>
								</td>
							</tr>
							<tr>
								<td>
									<input type="checkbox" class="i-checks" name="input[]"/>
								</td>
								<td>
									6
								</td>
								<td>
									활성
								</td>
								<td>
									145154
								</td>
								<td>
									이상훈
								</td>
								<td>
									CMS
								</td>
								<td>
									<a href="#" data-toggle="modal" data-target="#history-modal">2016.06.24 </a>
								</td>
								<td>
									정상 출금
								</td>
								<td>
									2016.07.24
								</td>
								<td>
									33,000원
								</td>
								<td>
									<a href="#" data-toggle="modal"
									   data-target="#register-modal">자세히</a>
								</td>
							</tr>
							<tr>
								<td>
									<input type="checkbox" class="i-checks" name="input[]"/>
								</td>
								<td>
									5
								</td>
								<td>
									활성
								</td>
								<td>
									145154
								</td>
								<td>
									이상훈
								</td>
								<td>
									CMS
								</td>
								<td>
									<a href="#" data-toggle="modal" data-target="#history-modal">2016.06.24 </a>
								</td>
								<td>
									정상 출금
								</td>
								<td>
									2016.07.24
								</td>
								<td>
									33,000원
								</td>
								<td>
									<a href="#" data-toggle="modal"
									   data-target="#register-modal">자세히</a>
								</td>
							</tr>
							<tr>
								<td>
									<input type="checkbox" class="i-checks" name="input[]"/>
								</td>
								<td>
									4
								</td>
								<td>
									활성
								</td>
								<td>
									145154
								</td>
								<td>
									이상훈
								</td>
								<td>
									CMS
								</td>
								<td>
									<a href="#" data-toggle="modal" data-target="#history-modal">2016.06.24 </a>
								</td>
								<td>
									정상 출금
								</td>
								<td>
									2016.07.24
								</td>
								<td>
									33,000원
								</td>
								<td>
									<a href="#" data-toggle="modal"
									   data-target="#register-modal">자세히</a>
								</td>
							</tr>
							<tr>
								<td>
									<input type="checkbox" class="i-checks" name="input[]"/>
								</td>
								<td>
									3
								</td>
								<td>
									활성
								</td>
								<td>
									145154
								</td>
								<td>
									이상훈
								</td>
								<td>
									CMS
								</td>
								<td>
									<a href="#" data-toggle="modal" data-target="#history-modal">2016.06.24 </a>
								</td>
								<td>
									정상 출금
								</td>
								<td>
									2016.07.24
								</td>
								<td>
									33,000원
								</td>
								<td>
									<a href="#" data-toggle="modal"
									   data-target="#register-modal">자세히</a>
								</td>
							</tr>
							<tr>
								<td>
									<input type="checkbox" class="i-checks" name="input[]"/>
								</td>
								<td>
									2
								</td>
								<td>
									활성
								</td>
								<td>
									145154
								</td>
								<td>
									이상훈
								</td>
								<td>
									CMS
								</td>
								<td>
									<a href="#" data-toggle="modal" data-target="#history-modal">2016.06.24 </a>
								</td>
								<td>
									정상 출금
								</td>
								<td>
									2016.07.24
								</td>
								<td>
									33,000원
								</td>
								<td>
									<a href="#" data-toggle="modal"
									   data-target="#register-modal">자세히</a>
								</td>
							</tr>
							<tr>
								<td>
									<input type="checkbox" class="i-checks" name="input[]"/>
								</td>
								<td>
									1
								</td>
								<td>
									활성
								</td>
								<td>
									145154
								</td>
								<td>
									이상훈
								</td>
								<td>
									CMS
								</td>
								<td>
									<a href="#" data-toggle="modal" data-target="#history-modal">2016.06.24 </a>
								</td>
								<td>
									정상 출금
								</td>
								<td>
									2016.07.24
								</td>
								<td>
									33,000원
								</td>
								<td>
									<a href="#" data-toggle="modal"
									   data-target="#register-modal">자세히</a>
								</td>
							</tr>
							</tbody>
						</table>
					</div>
					<%--<button class="fa fa-arrow-up pull-right">맨위로</button>--%>
					<%--</div>--%>
				</div>
			</div>
		</div>
	</div>
	<!-- CMS 등록 및 수정 -->
	<div class="modal inmodal fade" id="register-modal" tabindex="-1" role="dialog" aria-hidden="true"
	     style="display: none;">
		<div class="modal-dialog modal-lg register-modal">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span
							class="sr-only">Close</span></button>
					<h4 class="modal-title">신규 CMS 등록</h4>
				</div>
				<div class="modal-body gray-bg ng-scope">
					<div class="tabs-container">
						<div class="ng-isolate-scope">
							<ul class="nav nav-tabs">
								<li heading="개별 입력"
								    class="ng-isolate-scope active single-register">
									<a href="" class="ng-binding" onclick="changeTabs(this,event);">개별
										입력</a>
								</li>
								<li heading="대량파일 업로드"
								    class="ng-isolate-scope multi-register">
									<a href="" class="ng-binding" onclick="changeTabs(this,event);">대량파일
										업로드</a>
								</li>
							</ul>
							<div class="tab-content">
								<div class="tab-pane active single-register-panel">
									<div class="modal-body white-bg modal-body-override">
										<form method="post"
										      class="form-horizontal"
										      name="frm" novalidate="">
											<div class="form-group"><label class="col-sm-2 control-label">결제구분</label>
												<div class="col-sm-10">
													<div><label> <input class="type ng-pristine ng-untouched ng-valid"
													                    type="radio" value="cms"
													                    name="type"> CMS
													</label>
														<label> <input class="type ng-pristine ng-untouched ng-valid"
														               type="radio" value="card"
														               name="type"> 카드
														</label>
													</div>
												</div>
											</div>
											<div class="form-group"><label class="col-sm-2 control-label">회원명<br>
												<small>(가맹점주)</small>
											</label>
												<div class="col-sm-5">
													<div class="input-group">
														<input type="text"
														       class="form-control">
														<ul class="dropdown-menu storeOwnerList" role="menu">
														</ul>
							<span class="input-group-btn">
							<button type="button" class="btn btn-primary">
							<small>가맹점주 찾기</small>
										</button>
							</span>
													</div>
												</div>
											</div>

											<div class="form-group"><label class="col-sm-2 control-label">회원번호<br>
												<small>(가맹점주 코드)</small>
											</label>
												<div class="col-sm-5"><input type="text"
												                             class="form-control"
												                             required=""></div>
											</div>

											<div class="form-group"><label class="col-lg-2 control-label">가맹점 목록</label>
												<div class="col-lg-10">
													<div class="table-responsive">
														<table class="table table-bordered table-striped cms-list-wrap-table">
															<thead>
															<tr class="cms-list-table-header">
																<th>번호</th>
																<th>가맹점코드</th>
																<th>구분</th>
																<th>가맹점이름</th>
																<th>전화번호</th>
																<th>￦</th>
															</tr>
															</thead>
															<tbody>
															<tr>
																<td>1</td>
																<td>32242</td>
																<td>프리미엄</td>
																<td>김밥지옥</td>
																<td>011-222-333</td>
																<td>
																	<input type="text">
																</td>
															</tr>
															<tr>
																<td>2</td>
																<td>31126</td>
																<td>무료</td>
																<td>날아라병아리</td>
																<td>052-221-3333</td>
																<td>0</td>
															</tr>
															<tr>
																<td>3</td>
																<td>11123</td>
																<td>플러스</td>
																<td>황비홍네 중국집</td>
																<td>02-113-2233</td>
																<td>22,000</td>
															</tr>
															</tbody>
														</table>
													</div>
												</div>
											</div>

											<div class="hr-line-dashed"></div>

											<div class="form-group">
												<div class="col-sm-6">
													<div class="form-group"><label
															class="col-sm-4 control-label">결제약정일</label>
														<div class="col-sm-8">
															<input type="text"
															       class="form-control"
															       min="1"
															       max="31" placeholder="DD"
															       required=""></div>
													</div>
													<div class="form-group"><label
															class="col-sm-4 control-label">기본결제금액</label>
														<div class="col-sm-8">
															<div class="input-group m-b"><span
																	class="input-group-addon">￦</span><input type="text"
															                                                 class="form-control"
															                                                 required="">
															</div>
														</div>
													</div>
													<div class="form-group"><label
															class="col-sm-4 control-label">결제시작일</label>
														<div class="col-sm-8"><input type="text"
														                             class="form-control ng-pristine ng-invalid ng-invalid-required ng-touched"
														                             ng-model="form.withdrawStartDay"
														                             placeholder="YYYYMMDD" required="">
														</div>
													</div>
													<div class="form-group"><label
															class="col-sm-4 control-label">결제종료일</label>
														<div class="col-sm-8"><input type="text"
														                             class="form-control ng-pristine ng-untouched ng-invalid ng-invalid-required"
														                             ng-model="form.withdrawEndDay"
														                             placeholder="YYYYMMDD" required="">
														</div>
													</div>
												</div>
												<div class="col-sm-6">
													<div class="form-group"><label
															class="col-sm-4 control-label">관리자</label>
														<div class="col-sm-8"><input type="text"
														                             class="form-control ng-pristine ng-untouched ng-invalid ng-invalid-required"
														                             ng-model="form.manager"
														                             required=""></div>
													</div>
													<div class="form-group"><label class="col-sm-4 control-label">가맹점주연락처</label>
														<div class="col-sm-8"><input type="text" class="form-control"
														                             value=""></div>
													</div>
													<div class="form-group"><label class="col-sm-4 control-label">SMS전송
														여부</label>
														<div class="col-sm-8">
															<div><label> <input type="radio" ng-model="form.smsYn"
															                    value="Y" id="optionsRadios5"
															                    name="sendSms"
															                    class="ng-pristine ng-untouched ng-valid">
																전송
															</label>
																<label> <input type="radio" ng-model="form.smsYn"
																               value="N" id="optionsRadios6"
																               name="sendSms"
																               class="ng-pristine ng-untouched ng-valid">
																	전송안함
																</label></div>
														</div>
													</div>
												</div>
											</div>


											<div class="hr-line-dashed"></div>

											<div class="cms payType">
												<div class="form-group"><label class="col-sm-2 control-label">은행코드<br>
													<small>(은행명)</small>
												</label>
													<div class="col-sm-5">
														<select class="form-control m-b ng-pristine ng-untouched ng-valid"
														        ng-model="form.paycoCd"
														        ng-options="b.bankCode as b.bankName for b in bankCode | orderBy: 'bankName'">
															<option value="?" selected="selected"></option>
															<option label="HSBC은행" value="string:54">HSBC은행</option>
															<option label="경남은행" value="string:39">경남은행</option>
															<option label="광주은행" value="string:34">광주은행</option>
															<option label="국민은행" value="string:04">국민은행</option>
															<option label="기업은행" value="string:03">기업은행</option>
															<option label="농협은행" value="string:11">농협은행</option>
															<option label="농협중앙회" value="string:12">농협중앙회</option>
															<option label="대구은행" value="string:31">대구은행</option>
															<option label="도이치은행" value="string:55">도이치은행</option>
															<option label="뱅크오브아메리카은행" value="string:60">뱅크오브아메리카은행
															</option>
															<option label="부산은행" value="string:32">부산은행</option>
															<option label="산림조합중앙회" value="string:64">산림조합중앙회</option>
															<option label="산업은행" value="string:02">산업은행</option>
															<option label="상호저축은행" value="string:50">상호저축은행</option>
															<option label="새마을금고연합회" value="string:45">새마을금고연합회</option>
															<option label="수협중앙회" value="string:07">수협중앙회</option>
															<option label="신한(조흥)은행" value="string:21">신한(조흥)은행</option>
															<option label="신한은행" value="string:26">신한은행</option>
															<option label="신협중앙회" value="string:48">신협중앙회</option>
															<option label="외환은행" value="string:05">외환은행</option>
															<option label="우리은행" value="string:20">우리은행</option>
															<option label="전북은행" value="string:37">전북은행</option>
															<option label="제이피모간체이스은행" value="string:57">제이피모간체이스은행
															</option>
															<option label="제주은행" value="string:35">제주은행</option>
															<option label="지식경제부 우체국" value="string:71">지식경제부 우체국
															</option>
															<option label="하나은행" value="string:81">하나은행</option>
															<option label="한국스탠다드차타드은행" value="string:23">한국스탠다드차타드은행
															</option>
															<option label="한국씨티은행 구)한미은행" value="string:27">한국씨티은행
																구)한미은행
															</option>
														</select>
													</div>
												</div>

												<div class="form-group"><label
														class="col-sm-2 control-label">예금주명</label>
													<div class="col-sm-5"><input type="text"
													                             class="form-control ng-pristine ng-untouched ng-valid"
													                             ng-model="form.accountNm"></div>
												</div>

												<div class="form-group"><label
														class="col-sm-2 control-label">계좌번호</label>
													<div class="col-sm-8">
														<div class="input-group"><input type="text"
														                                class="form-control ng-pristine ng-untouched ng-valid"
														                                ng-model="form.payNo"> <span
																class="input-group-btn"> <button type="button"
														                                         class="btn btn-primary"
														                                         ng-click="ajaxBankAcount()">
                        <small>인증하기</small>
                    </button> </span></div>
													</div>
												</div>
												<div class="form-group ">
													<div class="col-sm-10 col-sm-offset-2 ng-binding"><i
															class="fa "></i></div>
												</div>
											</div>
											<div class="card payType" style="display: none;">
												<div class="form-group"><label
														class="col-sm-2 control-label">카드번호</label>
													<div class="col-sm-2"><input type="text"
													                             class="form-control ng-pristine ng-untouched ng-valid"
													                             placeholder="xxxx"
													                             ng-model="form.cardNum1"></div>
													<div class="col-sm-2"><input type="text"
													                             class="form-control ng-pristine ng-untouched ng-valid"
													                             placeholder="xxxx"
													                             ng-model="form.cardNum2"></div>
													<div class="col-sm-3"><input type="text"
													                             class="form-control ng-pristine ng-untouched ng-valid"
													                             placeholder="xxxx"
													                             ng-model="form.cardNum3"></div>
													<div class="col-sm-3"><input type="text"
													                             class="form-control ng-pristine ng-untouched ng-valid"
													                             placeholder="xxxx"
													                             ng-model="form.cardNum4"></div>
												</div>

												<div class="form-group"><label
														class="col-sm-2 control-label">유효기간</label>
													<div class="col-sm-4"><input type="text"
													                             class="form-control ng-pristine ng-untouched ng-valid ng-valid-maxlength"
													                             maxlength="2" placeholder="MM"
													                             ng-model="form.validMm"></div>
													<div class="col-sm-6"><input type="text"
													                             class="form-control ng-pristine ng-untouched ng-valid ng-valid-maxlength"
													                             maxlength="4" placeholder="YYYY"
													                             ng-model="form.validYear"></div>
												</div>


												<div class="form-group"><label class="col-sm-2 control-label">명의자<br>생년월일</label>
													<div class="col-sm-4"><input type="text"
													                             class="form-control ng-pristine ng-untouched ng-valid ng-valid-maxlength"
													                             maxlength="6" placeholder="YYMMDD"
													                             ng-model="form.birthday"></div>
												</div>
											</div>

											<div class="hr-line-dashed"></div>

											<div class="form-group"><label
													class="col-sm-3 control-label">생년월일/사업자번호</label>
												<div class="col-sm-7"><input type="text" id="busiNo"
												                             class="form-control ng-pristine ng-untouched ng-invalid ng-invalid-required"
												                             placeholder="YYMMDD/사업자번호"
												                             ng-model="form.busiNo" required=""></div>
											</div>

											<div class="form-group"><label class="col-sm-2 control-label">메모</label>
												<div class="col-sm-10"><textarea
														class="form-control ng-pristine ng-untouched ng-valid"
														ng-model="form.memo"></textarea></div>
											</div>

											<div class="form-group"><label
													class="col-sm-2 control-label">현금영수증발행</label>
												<div class="col-sm-10">
													<div><label> <input type="radio" ng-model="form.cashReceiptYn"
													                    value="Y" id="optionsRadios3" name="receipt"
													                    class="ng-pristine ng-untouched ng-valid"> 대상
													</label>
														<label> <input type="radio" ng-model="form.cashReceiptYn"
														               value="N" id="optionsRadios4" name="receipt"
														               class="ng-pristine ng-untouched ng-valid"> 비대상
														</label></div>
												</div>
											</div>

											<div class="hr-line-dashed"></div>

											<div class="form-group">
												<div class="col-sm-10 col-sm-offset-2">

													<button class="btn btn-primary" type="submit">저장하기</button>
													<button class="btn btn-white" type="button" ng-click="cancel()">닫기
													</button>
												</div>
											</div>
										</form>
									</div>

								</div><!-- end ngRepeat: tab in tabs -->
								<div class="tab-pane ng-scope multi-register-panel" ng-repeat="tab in tabs"
								     ng-class="{active: tab.active}"
								     tab-content-transclude="tab">


									<script src="js/plugins/dropzone/dropzone.js" class="ng-scope"></script>
									<link rel="stylesheet" href="css/plugins/dropzone/basic.css"
									      class="ng-scope">
									<link rel="stylesheet" href="css/plugins//dropzone/dropzone.css"
									      class="ng-scope">
									<div class="float-e-margins ng-scope" ng-controller="dropzoneCtrl">
										<div class="modal-body white-bg">
											<div>
												1. CMS 파일 양식을 다운로드합니다. <a>CMS 파일양식 다운로드</a>
												<br>2. 양식을 업로드하여 업로드 정보를 불러옵니다.
												<br>3. 등록하고자 하는 CMS 정보를 확인한 후 등록을 완료합니다.
											</div>
											<div>
												<form action="" class="dropzone ng-pristine ng-valid dz-clickable"
												      drop-zone="" id="file-dropzone">
													<button class="btn btn-primary pull-right" ng-click="checkFile()">정보
														불러오기
													</button>
													<div class="dz-default dz-message">
														<span>Drop files here to upload</span></div>
												</form>

												<div>
													<!-- ngIf: getResult.ok != null -->
													<!-- ngIf: getResult.err != null -->
													<!-- ngIf: getResult.dup != null -->
												</div>

											</div>

											<div>
												<div class="m text-right">
													<small>DropzoneJS is an open source library that provides
														drag'n'drop file uploads with image previews: <a
																href="https://github.com/enyo/dropzone" target="_blank">https://github.com/enyo/dropzone</a>
													</small>
												</div>
											</div>
											<div>
												<button class="btn btn-primary" ng-click="uploadOkData(getResult.ok)">
													업로드
												</button>
												<button class="btn btn-default" ng-click="reset()">reset</button>
												<button class="btn btn-white" ng-click="cancel()">닫기</button>
											</div>
										</div>
									</div>

								</div><!-- end ngRepeat: tab in tabs -->
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- CMS 이력보기 -->
<div class="modal inmodal fade in" id="history-modal" tabindex="-1" role="dialog" aria-hidden="true"
     style="display: none;">
	<div class="modal-dialog modal-lg history-modal">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span
						class="sr-only">Close</span></button>
				<h4 class="modal-title">CMS 이력보기</h4>
			</div>
			<div class="modal-body white-bg modal-body-override">
				<form class="form-horizontal" name="frm2" novalidate>
					<div class="form-group"><label class="col-sm-1 control-label">가맹점주 코드</label>
						<div class="col-sm-10">
							<div>
								<label> 145154 </label>
							</div>
						</div>
					</div>
					<div class="form-group"><label class="col-sm-1 control-label">가맹점주명</label>
						<div class="col-sm-10">
							<div>
								<label> 이상훈 </label>
							</div>
						</div>
					</div>
					<div class="form-group"><label class="col-sm-1 control-label">결제구분</label>
						<div class="col-sm-10">
							<div>
								<label> CMS </label>
							</div>
						</div>
					</div>
					<div class="form-group"><label class="col-sm-1 control-label">결제 시작일</label>
						<div class="col-sm-10">
							<div>
								<label> 2015.01.24 </label>
							</div>
						</div>
					</div>
					<div class="form-group"><label class="col-sm-1 control-label">마지막 결제일</label>
						<div class="col-sm-10">
							<div>
								<label> 2016.06.24 </label>
							</div>
						</div>
					</div>
					<div class="form-group"><label class="col-sm-1 control-label">결제상태</label>
						<div class="col-sm-10">
							<div>
								<label> 정상 </label>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label"><h3>가맹점별 월별 결제 금액</h3></label>
						<a class="collapse-link pull-right">
							<i class="fa fa-chevron-up"></i>
						</a>
					</div>
					<div class="form-group">
						<div class="col-lg-15">
							<div class="table-responsive">
								<table class="table table-bordered table-striped cms-list-wrap-table">
									<thead>
									<tr class="cms-list-table-header">
										<th>결제구분</th>
										<th>가맹점명</th>
										<th>분류</th>
										<th>결제시작일</th>
										<th>1월</th>
										<th>2월</th>
										<th>3월</th>
										<th>4월</th>
										<th>5월</th>
										<th>6월</th>
										<th>7월</th>
										<th>8월</th>
										<th>9월</th>
										<th>10월</th>
										<th>11월</th>
										<th>12월</th>
									</tr>
									</thead>
									<tbody>
									<tr>
										<td>유료</td>
										<td>불스떡복이</td>
										<td>배대</td>
										<td>2015.01.24</td>
										<td>33,000</td>
										<td>33,000</td>
										<td>33,000</td>
										<td>33,000</td>
										<td>33,000</td>
										<td>33,000</td>
										<td>33,000</td>
										<td>33,000</td>
										<td>22,000</td>
										<td>22,000</td>
										<td>22,000</td>
										<td>22,000</td>
									</tr>
									<tr>
										<td>유료</td>
										<td>날아라병아리</td>
										<td>책자</td>
										<td>2015.02.24</td>
										<td>33,000</td>
										<td>33,000</td>
										<td>33,000</td>
										<td>33,000</td>
										<td>33,000</td>
										<td>33,000</td>
										<td>33,000</td>
										<td>33,000</td>
										<td>22,000</td>
										<td>22,000</td>
										<td>22,000</td>
										<td>22,000</td>
									</tr>
									<tr>
										<td>유료</td>
										<td>황비홍의 중국집</td>
										<td>책자</td>
										<td>2015.03.24</td>
										<td>22,000</td>
										<td>22,000</td>
										<td>22,000</td>
										<td>22,000</td>
										<td>22,000</td>
										<td>22,000</td>
										<td>22,000</td>
										<td>22,000</td>
										<td>22,000</td>
										<td>22,000</td>
										<td>22,000</td>
										<td>22,000</td>
									</tr>
									<tr>
										<td colspan="3">
											합계
										</td>
										<td>2015.01.24</td>
										<td>88,000</td>
										<td>88,000</td>
										<td>88,000</td>
										<td>88,000</td>
										<td>88,000</td>
										<td>88,000</td>
										<td>88,000</td>
										<td>88,000</td>
										<td>66,000</td>
										<td>66,000</td>
										<td>66,000</td>
										<td>66,000</td>
									</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label"><h3>2016년</h3></label>
						<a class="collapse-link pull-right">
							<i class="fa fa-chevron-up"></i>
						</a>
					</div>
					<div class="form-group">
						<div class="col-lg-15">
							<div class="table-responsive">
								<table class="table table-bordered table-striped cms-list-wrap-table">
									<thead>
									<tr class="cms-list-table-header">
										<th>월</th>
										<th>기본 출금일(5일)</th>
										<th>1차 추가 출금(7일)</th>
										<th>2차 추가 출금(10일)</th>
										<th>출금액</th>
										<th>출금계좌</th>
									</tr>
									</thead>
									<tbody>
									<tr>
										<td>3</td>
										<td>잔액부족</td>
										<td>잔액부족</td>
										<td>잔액부족</td>
										<td>-</td>
										<td>04.국민은행</td>
									</tr>
									<tr>
										<td>2</td>
										<td>정상</td>
										<td>-</td>
										<td>-</td>
										<td>22,000원</td>
										<td>04.국민은행</td>
									</tr>
									<tr>
										<td>1</td>
										<td>잔액부족</td>
										<td>잔액부족</td>
										<td>잔액부족</td>
										<td>-</td>
										<td>04.국민은행</td>
									</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label"><h3>2015년</h3></label>
						<a class="collapse-link pull-right">
							<i class="fa fa-chevron-up"></i>
						</a>
					</div>
					<div class="form-group">
						<div class="col-lg-15">
							<div class="table-responsive">
								<table class="table table-bordered table-striped cms-list-wrap-table">
									<thead>
									<tr class="cms-list-table-header">
										<th>월</th>
										<th>기본 출금일(5일)</th>
										<th>1차 추가 출금(7일)</th>
										<th>2차 추가 출금(10일)</th>
										<th>출금액</th>
										<th>출금계좌</th>
									</tr>
									</thead>
									<tbody>
									<tr>
										<td>12</td>
										<td>정상</td>
										<td>-</td>
										<td>-</td>
										<td>33,000원</td>
										<td>04.국민은행</td>
									</tr>
									<tr>
										<td>11</td>
										<td>정상</td>
										<td>-</td>
										<td>-</td>
										<td>33,000원</td>
										<td>04.국민은행</td>
									</tr>
									<tr>
										<td>10</td>
										<td>정상</td>
										<td>-</td>
										<td>-</td>
										<td>33,000원</td>
										<td>04.국민은행</td>
									</tr>
									<tr>
										<td>9</td>
										<td>정상</td>
										<td>-</td>
										<td>-</td>
										<td>33,000원</td>
										<td>04.국민은행</td>
									</tr>
									<tr>
										<td>8</td>
										<td>정상</td>
										<td>-</td>
										<td>-</td>
										<td>33,000원</td>
										<td>04.국민은행</td>
									</tr>
									<tr>
										<td>7</td>
										<td>정상</td>
										<td>-</td>
										<td>-</td>
										<td>33,000원</td>
										<td>04.국민은행</td>
									</tr>
									<tr>
										<td>6</td>
										<td>정상</td>
										<td>-</td>
										<td>-</td>
										<td>33,000원</td>
										<td>04.국민은행</td>
									</tr>
									<tr>
										<td>5</td>
										<td>잔액부족</td>
										<td>정상</td>
										<td>-</td>
										<td>33,000원</td>
										<td>04.국민은행</td>
									</tr>
									<tr>
										<td>4</td>
										<td>정상</td>
										<td>-</td>
										<td>-</td>
										<td>33,000원</td>
										<td>04.국민은행</td>
									</tr>
									<tr>
										<td>3</td>
										<td>정상</td>
										<td>-</td>
										<td>-</td>
										<td>33,000원</td>
										<td>04.국민은행</td>
									</tr>
									<tr>
										<td>2</td>
										<td>정상</td>
										<td>-</td>
										<td>-</td>
										<td>33,000원</td>
										<td>04.국민은행</td>
									</tr>
									<tr>
										<td>1</td>
										<td>정상</td>
										<td>-</td>
										<td>-</td>
										<td>33,000원</td>
										<td>04.국민은행</td>
									</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<div class="form-group" style="text-align:center">
						<button class="btn btn-white" type="button" data-dismiss="modal">닫기
						</button>
					</div>
				</form>
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
	$(function () {
		var $tr = $('table.cms-list-wrap-table tbody tr');
		$tr.hover(function () {
			var $this = $(this);
			$this.addClass('info').siblings().removeClass('info');
		});
		$tr.mouseout(function () {
			$tr.removeClass('info');
		});
	})();
	function changeTabs(element, event) {
		event.preventDefault() && event.stopPropagation();
		if (!element) {
			return;
		}
		var $tab = $(element);
		var $parent = $tab.parent('li');
		var $siblings = $parent.addClass('active').siblings();
		$siblings.removeClass('active');

		var $singleRegisterPanel = $('div.single-register-panel');
		var $multiRegisterPanel = $('div.multi-register-panel');
		if ($parent.hasClass('single-register')) {
			$multiRegisterPanel.hide();
			$singleRegisterPanel.show();
		} else {
			$singleRegisterPanel.hide();
			$multiRegisterPanel.show();
		}
		return false;
	}
</script>

</body>

</html>

