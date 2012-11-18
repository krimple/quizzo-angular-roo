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

function QuizFormCtrl($scope) {
  $scope.myForm = {
    userName: "Joey"
  }
}
