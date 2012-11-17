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

function QuizDetailsCtrl($scope, $http, $routeParams) {
	$http.get('/quizzo/quizzes/' + $routeParams.quiz).
	  success(function(data) {
		$scope.quizDetails = data;
	});
}

function NewQuizCtrl($scope) {

}

function QuizFormCtrl($scope) {
  $scope.myForm = {
    userName: "Joey"
  }
}
