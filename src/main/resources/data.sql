INSERT INTO book (name) VALUES ('1번 책');
INSERT INTO book (name) VALUES ('2번 책');


INSERT INTO chapter (sequence, name, book_id) VALUES (1, '1단원', 1);
INSERT INTO chapter (sequence, name, book_id) VALUES (2, '2단원', 1);
INSERT INTO chapter (sequence, name, book_id) VALUES (3, '3단원', 1);
INSERT INTO chapter (sequence, name, book_id) VALUES (4, '4단원', 1);
INSERT INTO chapter (sequence, name, book_id) VALUES (5, '5단원', 1);

INSERT INTO chapter (sequence, name, book_id) VALUES (1, '1단원', 2);
INSERT INTO chapter (sequence, name, book_id) VALUES (2, '2단원', 2);
INSERT INTO chapter (sequence, name, book_id) VALUES (3, '3단원', 2);
INSERT INTO chapter (sequence, name, book_id) VALUES (4, '4단원', 2);
INSERT INTO chapter (sequence, name, book_id) VALUES (5, '5단원', 2);

INSERT INTO vocabulary (english, korean, is_derivative,chapter_id) VALUES ('1', '단어', false , 1);
INSERT INTO vocabulary (english, korean, is_derivative,chapter_id) VALUES ('2', '단어', false , 1);
INSERT INTO vocabulary (english, korean, is_derivative,chapter_id) VALUES ('3', '단어', false , 1);
INSERT INTO vocabulary (english, korean, is_derivative,chapter_id) VALUES ('4', '단어', false , 1);
INSERT INTO vocabulary (english, korean, is_derivative,chapter_id) VALUES ('5', '단어', true , 1);

INSERT INTO vocabulary (english, korean, is_derivative,chapter_id) VALUES ('6', '단어', false , 2);
INSERT INTO vocabulary (english, korean, is_derivative,chapter_id) VALUES ('7', '단어', false , 2);
INSERT INTO vocabulary (english, korean, is_derivative,chapter_id) VALUES ('8', '단어', false , 2);
INSERT INTO vocabulary (english, korean, is_derivative,chapter_id) VALUES ('9', '단어', false , 2);
INSERT INTO vocabulary (english, korean, is_derivative,chapter_id) VALUES ('10', '단어', true , 2);


INSERT INTO vocabulary (english, korean, is_derivative,chapter_id) VALUES ('11', '단어', false , 3);
INSERT INTO vocabulary (english, korean, is_derivative,chapter_id) VALUES ('12', '단어', false , 3);
INSERT INTO vocabulary (english, korean, is_derivative,chapter_id) VALUES ('13', '단어', false , 3);
INSERT INTO vocabulary (english, korean, is_derivative,chapter_id) VALUES ('14', '단어', false , 3);
INSERT INTO vocabulary (english, korean, is_derivative,chapter_id) VALUES ('15', '단어', true , 3);
