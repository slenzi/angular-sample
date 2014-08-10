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
	['$scope', 'PersonService', function($scope, PersonService) {
		
		// Use our PersonService object to fetch data from our REST service (see services.js)
		//$scope.sampleDataOut = SampleDataService.query();
		$scope.personData = PersonService.query();
		
		// load ng-grid with some test data
		/*
	    $scope.myData = [{name: "Moroni", age: 50},
	                     {name: "Tiancum", age: 43},
	                     {name: "Jacob", age: 27},
	                     {name: "Nephi", age: 29},
	                     {name: "Enos", age: 34}];
	    */
	    $scope.gridOptions = { data: 'personData' };

		//
		// process add person form
		//
		$scope.personFormData = {};
		$scope.processAddPersonForm = function() {

			alert("Processing add person form!");
			
		};	    
	    		
		
	}]
);