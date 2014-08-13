'use strict';

/* Services */

/*
 * Create services module with dependency on ngResource for consuming RESTful services.
 */
var sampleServices = angular.module('myApp.services', ['ngResource']).
	value('version', '0.1');

/*
 * Person service
 */
sampleServices.factory('PersonAPI', [ '$resource',
    function($resource) {
		return {
			service: function() {
				return $resource('jersey/person/:id', {id:'@personId'});			
			},
			apiVersion: "Person API, v1.0"
		}
    }
]);


/*
sampleServices.factory('PersonService', ['$resource',                                
    function($resource){
		return $resource('jersey/person/all', {}, {
			query: { method:'GET', isArray:true }
		});
	}
]);
 */

/*
var factory = {}; 
factory.method1 = function() {
   
}
return factory;
*/

/*
services.factory('Api', ['$resource',
function($resource) {
 return {
   Recipe: $resource('/recipes/:id', {id: '@id'}),
   Users:  $resource('/users/:id', {id: '@id'}),
   Group:  $resource('/groups/:id', {id: '@id'})
 };
}]);

function myCtrl($scope, Api){
 $scope.recipe = Api.Recipe.get({id: 1});
 $scope.users = Api.Users.query();
 ...
}
*/