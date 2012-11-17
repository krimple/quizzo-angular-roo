'use strict';

// Declare app level module which depends on filters, and services
angular.module('quizzoApp', ['ui', 'quizzoApp.filters', 'quizzoApp.services', 'quizzoApp.directives']).
  config(function($routeProvider, $locationProvider) {
    $routeProvider.
      when('/quiz-http', {templateUrl: 'partials/quizzes.html', controller: QuizzoHttpCtrl}).
      when('/quiz', {templateUrl: 'partials/quizzes.html', controller: QuizzoRESTCtrl}).
      when('/quiz/:quiz', {templateUrl: 'partials/quiz_details.html', controller: QuizDetailsCtrl}).
	    when('/newquiz', {templateUrl: 'partials/quiz_form.html', controller: NewQuizCtrl});
  }).
    run(function($rootScope) {
      $rootScope.getWSBase = function() {
        return "http://localhost:8080/quizzo/";
    };
});

