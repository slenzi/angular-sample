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
	['$scope', '$http', 'PersonAPI', function($scope, $http, PersonAPI) {
		
		console.log(PersonAPI.apiVersion);
		
		$scope.personData = PersonAPI.service().query();
		
	    $scope.gridOptions = {
	    	data: 'personData',
	    	columnDefs: [
	            { field: 'id', displayName: 'Id' },
	            { field: 'firstName', displayName: 'First Name' },
	            { field: 'middleName', displayName: 'Middle Name' },
	            { field: 'lastName', displayName: 'Last Name' },
	            { displayName: 'Edit', cellTemplate: '<button id="editPersonBtn" type="button" class="btn btn-small btn-primary" ng-click="showEditPerson(row.entity)">Edit</button>' },
	            { displayName: 'Delete', cellTemplate: '<button id="deletePersonBtn" type="button" class="btn btn-small btn-danger" ng-click="deletePerson(row.entity)">Delete</button>' }
	    	],
	    	multiSelect: false
	    };
	    
		//
		// process add person form
		//
		$scope.personFormData = {};
		$scope.processAddPersonForm = function() {

			console.log("Processing add person action");
				
			PersonAPI.service().save($scope.personFormData).$promise.then(
				function(data) {
					
					// success handler
					console.log("Person was added: " + data);
					$scope.personData = PersonAPI.service().query();
					// clear form
					$scope.addPersonForm.$pristine;
					$scope.personFormData = {};
					
				}, function(error) {
					
					// error handler
					console.log("Error, failed to add person: " + error);
					
				});
			
		};
		
		//
		// Handle edit person button click
		//
		$scope.showEditPerson = function(person) {
			
			alert('edit person:\n' + JSON.stringify(person));
			
		};
		
		//
		// Handle delete person button click
		//
		$scope.deletePerson = function(person) {
			
			console.log("Processing delete person action.");
			
			var deletePersonId = person.id;
			
			PersonAPI.service().delete({id: deletePersonId}).$promise.then(
				function(data) {
					
					// success handler
					console.log("Person was deleted: " + JSON.stringify(data));
					$scope.personData = PersonAPI.service().query();
					
				}, function(error) {
					
					// error handler
					console.log("Error, failed to delete person: " + error);
					
				});			
			
		};		
	    		
	}]
);







/*
 
controllerModule.controller('ConsumeTestController',
	['$scope', '$http', 'PersonAPI', function($scope, $http, PersonAPI) {
		
		//alert(PersonAPI.apiVersion());
		
		// Use our PersonService object to fetch data from our REST service (see services.js)
		//$scope.sampleDataOut = SampleDataService.query();
		$scope.personData = PersonAPI.service().query();
		
		// load ng-grid with some test data
	
	    //$scope.myData = [{name: "Moroni", age: 50},
	    //                {name: "Tiancum", age: 43},
	    //                 {name: "Jacob", age: 27},
	    //                 {name: "Nephi", age: 29},
	    //                 {name: "Enos", age: 34}];
	
	    $scope.gridOptions = { data: 'personData' };

		//
		// process add person form
		//
		$scope.personFormData = {};
		$scope.processAddPersonForm = function() {

			alert("Processing add person form!");
			
			$http({
				method : 'POST',
				url : 'jersey/person/:id',
				data : $scope.personFormData
		
				//,
				//headers : {
				//	'Content-Type' : 'application/x-www-form-urlencoded'
				//}
				// set the headers so angular passing info as form data (not request payload)
			
				
			}).success(function(data) {
				
				// log data returned from service
				console.log(data);
				
				$scope.addPersonMessage = "Person was added!"
					
				// get latest person data from service	
				$scope.personData = PersonAPI.service().query();

			
				//if (!data.success) {
				//	alert("Error: " + data);
					// if not successful, bind errors to error variables
					//$scope.errorId = data.errors.id;
				//} else {
				//	alert("Success!");
					// if successful, bind success message to message
				//	$scope.addPersonMessage = data.message;
				//}
				
				
			}).error(function(data, status, headers, config) {
		        
				console.log("Error adding person.");
				
				console.log(data);
				console.log(status);
				console.log(headers);
				console.log(config);
		    
		    });		
			
		};	    
	    		
		
	}]
); 
 
 */
