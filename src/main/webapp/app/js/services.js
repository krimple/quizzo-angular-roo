'use strict';

/* Services */


// Demonstrate how to register services
// In this case it is a simple value service.
angular.module('quizzoApp.services', ['ngResource']).
  value('version', '0.1').
  factory('Quiz', function($resource) {
    var REST_ROOT = '/quizzo/quizzes';
    	  // take default methods against the quizzes resource
	  return $resource(REST_ROOT ,{}, {
		  'save':   {method:'POST'},
		  'query':  {method:'GET', isArray:true},
		  'remove': {method:'DELETE'},
		  'delete': {method:'DELETE'} 
	  });
});

