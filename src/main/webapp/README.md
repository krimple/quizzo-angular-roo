# Quizzo - Angular

This is a project that is a demonstration of the Angular.js framework.

## Getting up and running

The project uses Maven for builds, hypersonic sql (for this installation) for database access, and Spring Roo to configure and manage everything.

The Maven commands are:

* `package` - configure the WAR file to run the application
* `jetty:run` - execute the Jetty web server
* `verify` - run the integration test stream, which launches the Angular `e2e` testing scripts. This currently is only functional on Unix/OS X but could be made functional on Windows platforms with a simple profile.

## The Roo/Spring Side

I am busy integrating various features. For now, I just have the scaffolded Roo web app for testing the RESTful data objects. I plan on doing data resets in the future for the end-to-end testing with a different database.

For Roo, I'm using the following annotations on my entities:

        @RooJavaBean
        @RooToString
        @RooJpaActiveRecord
        @RooJson
        @RooPlural("Quizzes")
        public class Quiz {

            private String name;

            private String short_name;

            private String description;
        }

This allows me to properly control the name of the object when scaffolding both the utility (Roo) UI, and the Angular.js UI. The controller:


        @RequestMapping("/quizzes")
        @Controller
        @RooWebScaffold(path = "quizzes", formBackingObject = Quiz.class)
        @RooWebJson(jsonObject = com.chariot.quizzo.db.Quiz.class)
        @RooPlural("quizzes")
            public class QuizController {
        }

I am scaffolding both the traditional Roo web app and the Angular RESTful services.

## The Angular.js side

I'm using as my basis the angular-seed project. I have worked the scripts into the maven build, although I'm not liking where they live at the moment and plan on moving them out of the web app.

I will be integrating Twitter Bootstrap too, and likely portions of AngularJS UI.

To hit the Angular app once the server is started, do this:

    http://localhost:8080/quizzo/app/index.html

To run end-to-end tests, either execute `mvn verify` or run the script `src/main/webapp/scripts/e2e-test.sh`. Either approach will work, but the `mvn verify` will lauch the app server, run tests, then shut it down.

To run the Jasmine unit tests, run the script `src/main/webrapp/scripts/test.sh` - this is an interactive test runner. It does not need the Maven system nor the Roo web app - it has its own launcher.


