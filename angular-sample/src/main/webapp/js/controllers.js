'use strict';

/* Controllers */

angular.module('myApp.controllers', [])
	.controller('InfoController', ['$scope', function($scope) {
	
	}])
	.controller('ConsumeTestController', ['$scope', 'SampleDataService', function($scope, SampleDataService) {
		// Use our SampleDataService object to fetch data from our test REST service (see services.js)
		$scope.sampleDataOut = SampleDataService.query();
	}]);
