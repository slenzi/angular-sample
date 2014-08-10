'use strict';

/* Services */


// Demonstrate how to register services
var sampleServices = angular.module('myApp.services', ['ngResource']).
	value('version', '0.1');

// register a service called 'PersonService' which fetches data from our REST Jersey person service
sampleServices.factory('PersonService', ['$resource',
	function($resource){
		return $resource('jersey/person/all', {}, {
			query: { method:'GET', isArray:true }
		});
	}]);