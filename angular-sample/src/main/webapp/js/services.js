'use strict';

/* Services */


// Demonstrate how to register services
var sampleServices = angular.module('myApp.services', ['ngResource']).
	value('version', '0.1');

// register a service called 'SampleDataService' which fetches data from our test REST Jersey service
sampleServices.factory('SampleDataService', ['$resource',
	function($resource){
		return $resource('jersey/person/all', {}, {
			query: { method:'GET', isArray:true }
		});
	}]);