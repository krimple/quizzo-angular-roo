'use strict';

/* jasmine specs for controllers go here */

describe('QuizzoRESTCtrlSpec', function(){
    var scope, quizzoRESTCtrl, $httpBackend;

    beforeEach(inject(function(_$httpBackend_, $rootScope, $controller) {
        $httpBackend = _$httpBackend_;
        $httpBackend.expectGET('/quizzo/quizzes').respond([
            {
                "name" : "Easy Quiz",
                "id" : "easy_quiz",
                "description" : "This is a simple quiz."
            },
            {
                "name" : "Tough Quiz",
                "id" : "tough_quiz",
                "description" : "This is a tough quiz."
            }]);
        scope = $rootScope.$new();
        var quizService = {
            index: function() {
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
        quizzoRESTCtrl = $controller(QuizzoHttpCtrl, {$scope: scope, Quiz: quizService});
    }));


    it('should make quizzo model with two quizzes fetched from xhr GET', function() {
        expect(scope.quizzes).toBeUndefined();
        $httpBackend.flush();
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


