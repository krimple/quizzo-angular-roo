delete from quiz;
insert into quiz(id, name, description) values(1, 'Simple Quiz', 'simple', 'This is a Simple Quiz');
insert into question(id, quiz_id, question_text, sort_order) values (1, 1, 'What is your favorite color?', 1);
insert into choice(id, question_id, text, correct, point_value, sort_order) value (1, 1, 'blue', 1, 100, 1);
insert into choice(id, question_id, text, correct, point_value, sort_order) value (2, 1, 'red', 0, -100, 2);
insert into choice(id, question_id, text, correct, point_value, sort_order) value (3, 1, 'green', 0, 0, 3);
insert into question(id, quiz_id, question_text, sort_order) values (2, 1, 'What is your favorite game?', 1);
insert into choice(id, question_id, text, correct, point_value, sort_order) value (4, 2, 'monopoly', 1, 100, 1);
insert into choice(id, question_id, text, correct, point_value, sort_order) value (5, 2, 'scrabble', 0, -100, 2);
insert into choice(id, question_id, text, correct, point_value, sort_order) value (6, 2, 'tic tac toe', 0, 0, 3);

