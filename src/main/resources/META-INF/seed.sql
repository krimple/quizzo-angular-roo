delete from quiz;
insert into quiz(id, name, short_name, description) values(1, 'Simple Quiz', 'simple', 'This is a Simple Quiz');
insert into quiz(id, name, short_name, description) values(2, 'Difficult Quiz', 'difficult', 'This is a Difficult Quiz');
insert into quiz(name, short_name, description) values('Strange Quiz', 'strange', 'This is a Strange Quiz');
delete from player;
insert into player(id, nick_name, first_name, last_name) values (1, 'kenny', 'Ken', 'Rimple');
insert into player(id, nick_name, first_name, last_name) values (2, 'markie', 'Mark', 'Rimple');
delete from game_member;
insert into game_member(quiz_id, player_id) values(1, 1);
insert into game_member(quiz_id, player_id) values(1, 2);

