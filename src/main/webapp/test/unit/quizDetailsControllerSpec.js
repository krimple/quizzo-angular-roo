'use strict';

/* jasmine specs for controllers go here */

describe('QuizDetailsCtrlSpec', function(){
  var scope, quizzoCtrl, $httpBackend;

  beforeEach(inject(function(_$httpBackend_, $rootScope, $controller) {
	$httpBackend = _$httpBackend_;
	$httpBackend.expectGET('/quizzo/quizzes/1').respond(
 	  {
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
	scope = $rootScope.$new();
    var routeParams = { "quiz" : "1"};
    quizzoCtrl = $controller(QuizDetailsCtrl, {$scope: scope, $routeParams: routeParams});
  }));


  it('should make quizzo model with two quizzes fetched from xhr GET', function() {
	expect(scope.quizDetails).toBeUndefined();
	$httpBackend.flush();
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
    //spec body
  });
});


