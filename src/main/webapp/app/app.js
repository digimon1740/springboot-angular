require(['text', 'i18n', 'jquery', 'angular'], function (text, i18n, $, angular) {
	/*global angular */
	(function () {
		'use strict';

		/**
		 * @type {angular.Module}
		 */
		angular.module('cmsmanager', ['todoCtrl', 'todoFocus', 'todoStorage']);
	})();
});
