'use strict';

/**
 * Shows a list of quizzes
 * @constructor
 * @param $scope - the browser shared scope
 * @param Quiz - the RESTful resource
 */
function QuizListController($scope, Quiz) {
  $scope.quizzes = Quiz.query();
}

/**
   Shows a single Quiz

   @constructor
   @param $scope - the browser shared scope
   @param Quiz - the RESTful resource
   @param $routeParams - used to fetch the ID of the quiz to display
 */
function QuizDetailsController($scope, Quiz, $routeParams) {
	$scope.quizDetails = Quiz.get({'id' : $routeParams.quiz});
    console.log($scope.quizDetails);
}

/**
 Sets up a form fragment and loads a new / existing
    quiz into the scope as 'quiz'.

    Will provide an <code>update</code> method to update the form
    via a Restful URL

    @constructor

    @param  $scope - the browser's shared objects and events
    @param  $location - the Location service that can change the angular fragment's location
    @param $routeParams - parameters passed to the controller via URL fragments, etc...
    @param Quiz - the RESTful Quiz resource backing our controller
 */
function QuizFormCtrl($scope, $location, $routeParams, Quiz) {
    // if existing quiz, get by id, else create a new one with sample data
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

    // provide
    $scope.update = function(quiz) {
        console.log("quiz is", quiz);
        $scope.master = angular.copy(quiz);
        // now that we have valid form data, let's send it
        // to our resource. IF successful, we browse to
        // our list again.
        // TODO check for error and handle that
        if (quiz.id) {
          Quiz.update($scope.master, function(u, putResponseHeaders) {
            $location.path("/quiz");

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


/**
 * TODO where we are going next...
 * @param $scope
 * @param $http
 * @constructor
 */
function EngineController($scope, $http) {

}