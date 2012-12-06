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

// inject the $location so we can browse to the main
// page when we've finished inserting our new Quiz
function QuizFormCtrl($scope, $location, $routeParams, Quiz) {
    if ($routeParams.quiz) {
      Quiz.get({"id" : $routeParams.quiz}, function(quizData) {
        console.log("Quiz is ", quizData);
        $scope.quiz = angular.copy(quizData);
      });

    } else {
      $scope.master= {
        "name" : "Please enter name",
        "description" : "Enter a good description.",
        "shortName" : "enter a short name here"
      };
    }

    $scope.update = function(quiz) {
        console.log("quiz is", quiz);
        $scope.master = angular.copy(quiz);
        // now that we have valid form data, let's send it
        // to our resource. IF successful, we browse to
        // our list again.
        // TODO - check for error and handle that
        if (quiz.id) {
          Quiz.update($scope.master, function(u, putResponseHeaders) {
            $location.path("/quiz/" + u.id);
          });
        } else {
          Quiz.save($scope.master, function(u, putResponseHeaders) {
            //u => saved user object
            //putResponseHeaders => $http header getter
            $location.path("/quiz");
        });
        };
    };
    $scope.reset = function() {
        $scope.quiz = angular.copy($scope.master);
    };

    $scope.reset();
}

