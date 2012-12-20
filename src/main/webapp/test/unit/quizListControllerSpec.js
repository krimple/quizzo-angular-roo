'use strict';

/* jasmine specs for controllers go here */

describe('QuizListControllerSpec', function(){
    var scope, $httpBackend, quizService, controller;

    beforeEach(inject(function($rootScope, $controller) {
        controller = $controller;
        scope = $rootScope.$new();
        quizService = {
            query: function() {
                return [
                    {
                        "name" : "Easy Quiz",
                        "id" : "easy_quiz",
                        "description" : "This is a simple quiz."
                    },
                    {
                        "name" : "Tough Quiz",
                        "id" : "tough_quiz",
                        "description" : "This is a tough quiz."
                    }];
            }
        };
    }));


    it('should make quizzo model with two quizzes fetched from xhr GET', function() {
        var quizListController = controller(QuizListController, {$scope: scope, Quiz: quizService});
        expect(scope.quizzes).toEqual([
            {
                "name" : "Easy Quiz",
                "id" : "easy_quiz",
                "description" : "This is a simple quiz."
            },
            {
                "name" : "Tough Quiz",
                "id" : "tough_quiz",
                "description" : "This is a tough quiz."
            }
        ]);
    });
});


