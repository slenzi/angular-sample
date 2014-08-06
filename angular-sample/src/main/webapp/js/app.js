'use strict';

// Declare app level module which depends on filters, and services
angular.module('myApp', [
	'ngRoute',
	'ngResource',
	'myApp.filters',
	'myApp.services',
	'myApp.directives',
	'myApp.controllers'
]).
config(['$routeProvider', function($routeProvider) {
	$routeProvider.when('/info', {templateUrl: 'partials/information.html', controller: 'InfoController'});
	$routeProvider.when('/consume', {templateUrl: 'partials/consume-test.html', controller: 'ConsumeTestController'});
	$routeProvider.otherwise({redirectTo: '/info'});
}]);
