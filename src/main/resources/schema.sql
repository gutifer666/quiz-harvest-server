use quiz_harvest;
create table question
(
    id            bigint auto_increment
        primary key,
    text_question varchar(255)                                                                                                                                               not null,
    evaluation    enum ('FIRST', 'SECOND')                                                                                                                                   null,
    subject       enum ('BUSINESS', 'CLIENT', 'DATABASES', 'DEPLOYMENT', 'ELECTIVE', 'ENVIRONMENTS', 'INTERFACE', 'MARKUP', 'PROGRAMMING', 'SERVER', 'SYSTEMS', 'WORKPLACE') null
)
    charset = utf8mb4;

create table option_entity
(
    is_correct  bit              not null,
    is_selected bit default b'0' null,
    option_id   bigint auto_increment
        primary key,
    question_id bigint           not null,
    text_option varchar(255)     not null,
    constraint FK4ma06qiypv4hxw5oypa2a5xkl
        foreign key (question_id) references question (id)
)
    charset = utf8mb4;


