'use strict';

/* http://docs.angularjs.org/guide/dev_guide.e2e-testing */

describe('quizzo app', function() {

  beforeEach(function() {
    browser().navigateTo('/quizzo/app/index.html');
  });


  it('should automatically redirect to /error when location hash/fragment is empty', function() {
    expect(browser().location().url()).toBe("/error");
  });


  describe('quiz listing', function() {

    beforeEach(function() {
      browser().navigateTo('#/quiz-http');
    });


    it('should render quizzes partial when user navigates to /quiz-http', function() {
      expect(repeater('.quizzes td', 'Quiz List').column("quiz.name")).
		toEqual(["xzcgs", "asdfsaf"]);
	  expect(repeater('.quizzes td', 'Quiz List').column("quiz.description")).
		toEqual(["asfsd", "asdfsadf"]);
    });

  });

    describe('quiz listing REST', function() {

        beforeEach(function() {
            browser().navigateTo('#/quiz');
        });


        it('should render quizzes partial when user navigates to /quiz', function() {
            expect(repeater('.quizzes td', 'Quiz List').column("quiz.name")).
                toEqual(["xzcgs", "asdfsaf"]);
            expect(repeater('.quizzes td', 'Quiz List').column("quiz.description")).
                toEqual(["asfsd", "asdfsadf"]);
        });

    });


  describe('quiz details', function() {

    beforeEach(function() {
      browser().navigateTo('#/quiz/easy_quiz');
    });


    it('should render quiz details when user browses to /quizzes/app#/quiz/easy_quiz', function() {
      expect(element('body').text()).
        toMatch(/simple/);
    });

  });
});
