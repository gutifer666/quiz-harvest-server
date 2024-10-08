use quiz_harvest;
-- Insert questions for each subject
INSERT INTO question (text_question, evaluation, subject) VALUES
('Question 1 for BUSINESS', 'FIRST', 'BUSINESS'),
('Question 2 for BUSINESS', 'SECOND', 'BUSINESS'),
('Question 3 for BUSINESS', 'FIRST', 'BUSINESS'),
('Question 4 for BUSINESS', 'SECOND', 'BUSINESS'),
('Question 1 for CLIENT', 'FIRST', 'CLIENT'),
('Question 2 for CLIENT', 'SECOND', 'CLIENT'),
('Question 3 for CLIENT', 'FIRST', 'CLIENT'),
('Question 4 for CLIENT', 'SECOND', 'CLIENT'),
('Question 1 for DATABASES', 'FIRST', 'DATABASES'),
('Question 2 for DATABASES', 'SECOND', 'DATABASES'),
('Question 3 for DATABASES', 'FIRST', 'DATABASES'),
('Question 4 for DATABASES', 'SECOND', 'DATABASES'),
('Question 1 for DEPLOYMENT', 'FIRST', 'DEPLOYMENT'),
('Question 2 for DEPLOYMENT', 'SECOND', 'DEPLOYMENT'),
('Question 3 for DEPLOYMENT', 'FIRST', 'DEPLOYMENT'),
('Question 4 for DEPLOYMENT', 'SECOND', 'DEPLOYMENT'),
('Question 1 for ELECTIVE', 'FIRST', 'ELECTIVE'),
('Question 2 for ELECTIVE', 'SECOND', 'ELECTIVE'),
('Question 3 for ELECTIVE', 'FIRST', 'ELECTIVE'),
('Question 4 for ELECTIVE', 'SECOND', 'ELECTIVE'),
('Question 1 for ENVIRONMENTS', 'FIRST', 'ENVIRONMENTS'),
('Question 2 for ENVIRONMENTS', 'SECOND', 'ENVIRONMENTS'),
('Question 3 for ENVIRONMENTS', 'FIRST', 'ENVIRONMENTS'),
('Question 4 for ENVIRONMENTS', 'SECOND', 'ENVIRONMENTS'),
('Question 1 for INTERFACE', 'FIRST', 'INTERFACE'),
('Question 2 for INTERFACE', 'SECOND', 'INTERFACE'),
('Question 3 for INTERFACE', 'FIRST', 'INTERFACE'),
('Question 4 for INTERFACE', 'SECOND', 'INTERFACE'),
('Question 1 for MARKUP', 'FIRST', 'MARKUP'),
('Question 2 for MARKUP', 'SECOND', 'MARKUP'),
('Question 3 for MARKUP', 'FIRST', 'MARKUP'),
('Question 4 for MARKUP', 'SECOND', 'MARKUP'),
('Question 1 for PROGRAMMING', 'FIRST', 'PROGRAMMING'),
('Question 2 for PROGRAMMING', 'SECOND', 'PROGRAMMING'),
('Question 3 for PROGRAMMING', 'FIRST', 'PROGRAMMING'),
('Question 4 for PROGRAMMING', 'SECOND', 'PROGRAMMING'),
('Question 1 for SERVER', 'FIRST', 'SERVER'),
('Question 2 for SERVER', 'SECOND', 'SERVER'),
('Question 3 for SERVER', 'FIRST', 'SERVER'),
('Question 4 for SERVER', 'SECOND', 'SERVER'),
('Question 1 for SYSTEMS', 'FIRST', 'SYSTEMS'),
('Question 2 for SYSTEMS', 'SECOND', 'SYSTEMS'),
('Question 3 for SYSTEMS', 'FIRST', 'SYSTEMS'),
('Question 4 for SYSTEMS', 'SECOND', 'SYSTEMS'),
('Question 1 for WORKPLACE', 'FIRST', 'WORKPLACE'),
('Question 2 for WORKPLACE', 'SECOND', 'WORKPLACE'),
('Question 3 for WORKPLACE', 'FIRST', 'WORKPLACE'),
('Question 4 for WORKPLACE', 'SECOND', 'WORKPLACE');
-- Insert options for each question
INSERT INTO option_entity (question_id, text_option, is_correct, is_selected) VALUES
(1, 'Option 1', true, b'0'),
(1, 'Option 2', false, b'0'),
(1, 'Option 3', false, b'0'),
(1, 'Option 4', false, b'0'),
(2, 'Option 1', true, b'0'),
(2, 'Option 2', false, b'0'),
(2, 'Option 3', false, b'0'),
(2, 'Option 4', false, b'0'),
(3, 'Option 1', true, b'0'),
(3, 'Option 2', false, b'0'),
(3, 'Option 3', false, b'0'),
(3, 'Option 4', false, b'0'),
(4, 'Option 1', true, b'0'),
(4, 'Option 2', false, b'0'),
(4, 'Option 3', false, b'0'),
(4, 'Option 4', false, b'0'),
(5, 'Option 1', true, b'0'),
(5, 'Option 2', false, b'0'),
(5, 'Option 3', false, b'0'),
(5, 'Option 4', false, b'0'),
(6, 'Option 1', true, b'0'),
(6, 'Option 2', false, b'0'),
(6, 'Option 3', false, b'0'),
(6, 'Option 4', false, b'0'),
(7, 'Option 1', true, b'0'),
(7, 'Option 2', false, b'0'),
(7, 'Option 3', false, b'0'),
(7, 'Option 4', false, b'0'),
(8, 'Option 1', true, b'0'),
(8, 'Option 2', false, b'0'),
(8, 'Option 3', false, b'0'),
(8, 'Option 4', false, b'0'),
(9, 'Option 1', true, b'0'),
(9, 'Option 2', false, b'0'),
(9, 'Option 3', false, b'0'),
(9, 'Option 4', false, b'0'),
(10, 'Option 1', true, b'0'),
(10, 'Option 2', false, b'0'),
(10, 'Option 3', false, b'0'),
(10, 'Option 4', false, b'0'),
(11, 'Option 1', true, b'0'),
(11, 'Option 2', false, b'0'),
(11, 'Option 3', false, b'0'),
(11, 'Option 4', false, b'0'),
(12, 'Option 1', true, b'0'),
(12, 'Option 2', false, b'0'),
(12, 'Option 3', false, b'0'),
(12, 'Option 4', false, b'0'),
(13, 'Option 1', true, b'0'),
(13, 'Option 2', false, b'0'),
(13, 'Option 3', false, b'0'),
(13, 'Option 4', false, b'0'),
(14, 'Option 1', true, b'0'),
(14, 'Option 2', false, b'0'),
(14, 'Option 3', false, b'0'),
(14, 'Option 4', false, b'0'),
(15, 'Option 1', true, b'0'),
(15, 'Option 2', false, b'0'),
(15, 'Option 3', false, b'0'),
(15, 'Option 4', false, b'0'),
(16, 'Option 1', true, b'0'),
(16, 'Option 2', false, b'0'),
(16, 'Option 3', false, b'0'),
(16, 'Option 4', false, b'0'),
(17, 'Option 1', true, b'0'),
(17, 'Option 2', false, b'0'),
(17, 'Option 3', false, b'0'),
(17, 'Option 4', false, b'0'),
(18, 'Option 1', true, b'0'),
(18, 'Option 2', false, b'0'),
(18, 'Option 3', false, b'0'),
(18, 'Option 4', false, b'0'),
(19, 'Option 1', true, b'0'),
(19, 'Option 2', false, b'0'),
(19, 'Option 3', false, b'0'),
(19, 'Option 4', false, b'0'),
(20, 'Option 1', true, b'0'),
(20, 'Option 2', false, b'0'),
(20, 'Option 3', false, b'0'),
(20, 'Option 4', false, b'0'),
(21, 'Option 1', true, b'0'),
(21, 'Option 2', false, b'0'),
(21, 'Option 3', false, b'0'),
(21, 'Option 4', false, b'0'),
(22, 'Option 1', true, b'0'),
(22, 'Option 2', false, b'0'),
(22, 'Option 3', false, b'0'),
(22, 'Option 4', false, b'0'),
(23, 'Option 1', true, b'0'),
(23, 'Option 2', false, b'0'),
(23, 'Option 3', false, b'0'),
(23, 'Option 4', false, b'0'),
(24, 'Option 1', true, b'0'),
(24, 'Option 2', false, b'0'),
(24, 'Option 3', false, b'0'),
(24, 'Option 4', false, b'0'),
(25, 'Option 1', true, b'0'),
(25, 'Option 2', false, b'0'),
(25, 'Option 3', false, b'0'),
(25, 'Option 4', false, b'0'),
(26, 'Option 1', true, b'0'),
(26, 'Option 2', false, b'0'),
(26, 'Option 3', false, b'0'),
(26, 'Option 4', false, b'0'),
(27, 'Option 1', true, b'0'),
(27, 'Option 2', false, b'0'),
(27, 'Option 3', false, b'0'),
(27, 'Option 4', false, b'0'),
(28, 'Option 1', true, b'0'),
(28, 'Option 2', false, b'0'),
(28, 'Option 3', false, b'0'),
(28, 'Option 4', false, b'0'),
(29, 'Option 1', true, b'0'),
(29, 'Option 2', false, b'0'),
(29, 'Option 3', false, b'0'),
(29, 'Option 4', false, b'0'),
(30, 'Option 1', true, b'0'),
(30, 'Option 2', false, b'0'),
(30, 'Option 3', false, b'0'),
(30, 'Option 4', false, b'0'),
(31, 'Option 1', true, b'0'),
(31, 'Option 2', false, b'0'),
(31, 'Option 3', false, b'0'),
(31, 'Option 4', false, b'0'),
(32, 'Option 1', true, b'0'),
(32, 'Option 2', false, b'0'),
(32, 'Option 3', false, b'0'),
(32, 'Option 4', false, b'0'),
(33, 'Option 1', true, b'0'),
(33, 'Option 2', false, b'0'),
(33, 'Option 3', false, b'0'),
(33, 'Option 4', false, b'0'),
(34, 'Option 1', true, b'0'),
(34, 'Option 2', false, b'0'),
(34, 'Option 3', false, b'0'),
(34, 'Option 4', false  , b'0'),
(35, 'Option 1', true, b'0'),
(35, 'Option 2', false, b'0'),
(35, 'Option 3', false, b'0'),
(35, 'Option 4', false, b'0'),
(36, 'Option 1', true, b'0'),
(36, 'Option 2', false, b'0'),
(36, 'Option 3', false, b'0'),
(36, 'Option 4', false, b'0'),
(37, 'Option 1', true, b'0'),
(37, 'Option 2', false, b'0'),
(37, 'Option 3', false, b'0'),
(37, 'Option 4', false, b'0'),
(38, 'Option 1', true, b'0'),
(38, 'Option 2', false, b'0'),
(38, 'Option 3', false, b'0'),
(38, 'Option 4', false, b'0'),
(39, 'Option 1', true, b'0'),
(39, 'Option 2', false, b'0'),
(39, 'Option 3', false, b'0'),
(39, 'Option 4', false, b'0'),
(40, 'Option 1', true, b'0'),
(40, 'Option 2', false, b'0'),
(40, 'Option 3', false, b'0'),
(40, 'Option 4', false, b'0'),
(41, 'Option 1', true, b'0'),
(41, 'Option 2', false, b'0'),
(41, 'Option 3', false, b'0'),
(41, 'Option 4', false, b'0'),
(42, 'Option 1', true, b'0'),
(42, 'Option 2', false, b'0'),
(42, 'Option 3', false, b'0'),
(42, 'Option 4', false, b'0'),
(43, 'Option 1', true, b'0'),
(43, 'Option 2', false, b'0'),
(43, 'Option 3', false, b'0'),
(43, 'Option 3', false, b'0'),
(44, 'Option 1', true, b'0'),
(44, 'Option 2', false, b'0'),
(44, 'Option 3', false, b'0'),
(44, 'Option 4', false, b'0'),
(45, 'Option 1', true, b'0'),
(45, 'Option 2', false, b'0'),
(45, 'Option 3', false, b'0'),
(45, 'Option 4', false, b'0'),
(46, 'Option 1', true, b'0'),
(46, 'Option 2', false, b'0'),
(46, 'Option 3', false, b'0'),
(46, 'Option 4', false, b'0'),
(47, 'Option 1', true, b'0'),
(47, 'Option 2', false, b'0'),
(47, 'Option 3', false, b'0'),
(47, 'Option 4', false, b'0'),
(48, 'Option 1', true, b'0'),
(48, 'Option 2', false, b'0'),
(48, 'Option 3', false, b'0'),
(48, 'Option 4', false, b'0')
;
