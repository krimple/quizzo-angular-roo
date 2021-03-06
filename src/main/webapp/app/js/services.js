'use strict';

/* Services */

angular.module('quizzoApp.services', ['ngResource']).
  value('version', '0.1').
  factory('Quiz', function($resource) {
    var REST_ROOT = '/quizzo/quizzes/:id';

    	  // take default methods against the quizzes resource
	  return $resource(REST_ROOT ,{}, {
		  'save':   {method:'POST'},
      'update': {method: 'PUT'},
		  'query':  {method:'GET', isArray:true},
      'get': {method:'GET'},
		  'remove': {method:'DELETE'},
		  'delete': {method:'DELETE'}
	  });
});

