'use strict';

/* Controllers */

/*
 * Create controller module for myApp 
 */
var controllerModule = angular.module('myApp.controllers', [/*'ngGrid'*/]);

/*
 * Controller for 'Info' view.
 */
controllerModule.controller('InfoController',
	['$scope', function($scope) {
	
	
	}]
);

/*
 * Controller for 'REST Consume Test' view.
 */
controllerModule.controller('ConsumeTestController',
	['$scope', 'SampleDataService', function($scope, SampleDataService) {
		
		// Use our SampleDataService object to fetch data from our test REST service (see services.js)
		//$scope.sampleDataOut = SampleDataService.query();
		$scope.personData = SampleDataService.query();
		
		
		// load ng-grid with some test data
		/*
	    $scope.myData = [{name: "Moroni", age: 50},
	                     {name: "Tiancum", age: 43},
	                     {name: "Jacob", age: 27},
	                     {name: "Nephi", age: 29},
	                     {name: "Enos", age: 34}];
	    */
	    
	    $scope.gridOptions = { data: 'personData' };
	    		
		
	}]
);