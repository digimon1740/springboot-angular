'use strict';

define([
		'angular',
		//'route-config' //registers에 각 프로바이더를 제공하기 위해 임포트
	],

	function (angular, routeConfig) {
		//모듈 선언
		var app = angular.module('cmsmanager', [], function ($provide, $compileProvider, $controllerProvider, $filterProvider) {

			//부트스트랩 과정에서만 가져올 수 있는 프로바이더들을 각 registers와 연계될 수 있도록
			// routeConfig.setProvide($provide); //for services
			// routeConfig.setCompileProvider($compileProvider);  //for directives
			// routeConfig.setControllerProvider($controllerProvider); //for controllers
			// routeConfig.setFilterProvider($filterProvider); //for filters
		});

		//공통 컨트롤러 설정 - 모든 컨트롤러에서 공통적으로 사용하는 부분들 선언
		// app.controller('CommonController', function ($scope) {
		//
		// 	//스타일시트 업데이트
		// 	$scope.$on('updateCSS', function (event, args) {
		//
		// 		//파라메터로 받아온 스타일 시트 반영
		// 		$scope.stylesheets = args;
		// 	});
		// });
		return app;
	}
);
