/*global require*/
'use strict';

require.config({

	paths: {
		text: '/js/lib/text-2.0.12',
		i18n: '/js/lib/i18n-2.0.4',
		jquery: '/js/lib/jquery-2.1.1',
		'jquery.ui': '/js/lib/jquery-ui-1.10.4.min',
		angular: '/js/lib/angular.min',
		'angular.route': '/js/lib/angular-route',
		'angular.resource': '/js/lib/angular-resource',
	},
	shim: {
		'jquery.ui': {
			deps: ['jquery']
		},
		'angular': {
			deps: ['jquery'],
			exports: 'angular'
		},
		'angular.route': {
			deps: ['angular'],
		},
		'angular.resource': {
			deps: ['angular', 'angular.route']
		},
		'app': {
			deps: ['angular']
		},
	},
	//deps: ['app']
});

require(['text', 'i18n', 'jquery', 'angular', 'jquery.ui', 'app', 'angular.route', 'angular.resource'], function (text, i18n, $, angular) {
	$(function () {
		/**
		 * @type {angular.Module}
		 */
		angular.bootstrap(document, ['springbootAngular']);    //  app start
	});
});