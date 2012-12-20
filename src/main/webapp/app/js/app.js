'use strict';

// Declare app level module which depends on filters, and services
angular.module('quizzoApp',
        ['ui', 'quizzoApp.filters', 'quizzoApp.services', 'quizzoApp.directives']
    ).config(function($routeProvider, $locationProvider) {
        $routeProvider.
              when('/quiz', {templateUrl: 'partials/quizzes.html', controller: QuizListController}).
              when('/quiz/:quiz', {templateUrl: 'partials/quiz_details.html', controller: QuizDetailsController}).
              when('/quiz/:quiz/edit', {templateUrl: 'partials/quiz_form.html', controller: QuizFormController}).
              when('/quiz-new', {templateUrl: 'partials/quiz_form.html', controller: QuizFormController}).
              when('/quiz/engine', {templateUrl: 'partials/quiz_machines.html', controller: EngineController});

    }).run(function($rootScope) {
      $rootScope.getWSBase = function() {
        return "http://localhost:8080/quizzo/";
    };
});

