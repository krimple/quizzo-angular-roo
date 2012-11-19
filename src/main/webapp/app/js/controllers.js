'use strict';

/* Controllers */

function QuizzoHttpCtrl($scope, $http) {
  $http.get('/quizzo/quizzes').
    success(function (data) {
    	$scope.quizzes = data;
  	});
}

function QuizzoRESTCtrl($scope, Quiz) {
  $scope.quizzes = Quiz.query();
}

function QuizDetailsCtrl($scope, Quiz, $routeParams) {
	$scope.quizDetails = Quiz.get({'id' : $routeParams.quiz});
    console.log($scope.quizDetails);
}

function NewQuizCtrl($scope) {

}

// inject the $location so we can browse to the main
// page when we've finished inserting our new Quiz
function QuizFormCtrl($scope, $location, Quiz) {
    $scope.master= {};

    $scope.update = function(quiz) {
        $scope.master= angular.copy(quiz);
        // now that we have valid form data, let's send it
        // to our resource. IF successful, we browse to
        // our list again.
        // TODO - check for error and handle that
        Quiz.save($scope.master, function(u, putResponseHeaders) {
            //u => saved user object
            //putResponseHeaders => $http header getter
            $location.path("/quiz");
        });
    };
    $scope.reset = function() {
        $scope.quiz = angular.copy($scope.master);
    };

    $scope.reset();
}

