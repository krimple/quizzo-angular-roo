'use strict';

/* jasmine specs for controllers go here */

describe('QuizDetailsControllerSpec', function(){
  var Quiz, scope, controller;

  beforeEach(inject(function($rootScope, $controller) {
    scope = $rootScope.$new();
    controller = $controller;

	Quiz = {

      get: function() {
          return  {
                "name" : "Easy Quiz",
                "id" : "easy_quiz",
                "description" : "This is a simple quiz.",
                "players" : [
                    {
                        "nick" : "Joey"
                    },
                    {
                        "nick" : "Sue"
                    }
                ]
	        }
      }
    };
  }));


  it('should make quizzo model with two quizzes fetched from xhr GET', function() {
    var routeParams = { "quiz" : "1"};
	expect(scope.quizDetails).toBeUndefined();
    var quizDetailsController = controller(QuizDetailsController, {Quiz: Quiz, $scope: scope, $routeParams: routeParams});
	expect(scope.quizDetails).toEqual({
	    "name" : "Easy Quiz",
	    "id" : "easy_quiz",
	    "description" : "This is a simple quiz.",
	    "players" : [
			{
				"nick" : "Joey"
			},
			{
				"nick" : "Sue"
			}
		]
	  });
  });
});


