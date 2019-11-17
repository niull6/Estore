
create sequence cus_id_seq start with 1 increment by 1;
--用户表
create table e_customer(
	id number primary key,
	username varchar2(50) not null,
	password varchar2(50) not null,
	zip varchar2(10),
	address varchar2(30),
	phone varchar2(20),
	email varchar2(50)
);

create sequence cate_id_seq start with 1 increment by 1;
--分类表
create table e_category(
	id number primary key,
	name varchar2(40),
	info varchar2(255)
);

create sequence book_id_seq start with 1 increment by 1;
--书籍表 
create table e_book(
	id number primary key,
	name varchar2(50) not null,
	price number(10,2),
	categoryId number references e_category(id)
);

create sequence order_id_seq start with 1 increment by 1;
--订单表
create table e_order(
	id number primary key,
	total number,
	orderDate date,
	name varchar2(50),
	address varchar2(50),
	telephone varchar2(50),
	cusId number references e_customer(id)
);

create sequence line_id_seq start with 1 increment by 1;
--订单项表
create table e_orderline(
	id number primary key,
	num number,
	bookId number references e_book(id),
	orderId number references e_order(id)
);
create sequence orderLine_sequence start with 1 increment by 1;

--往书籍类别中插入数据
INSERT INTO e_category VALUES ('1', '文学类', '文学的一个类别这是关于文学的一个类别这是关于文学的一个类别这是关于文学的一个类别');
INSERT INTO e_category VALUES ('2', '教育类', '这是关于教育的一个类别');
INSERT INTO e_category VALUES ('3', '计算机类', '这是关于计算机的一个类别');
INSERT INTO e_category VALUES ('4', '儿童类', '这是关于儿童的一个类别');
INSERT INTO e_category VALUES ('5', '漫画类', '这是关于漫画的一个类别');
INSERT INTO e_category VALUES ('6', '工具类', '这是关于工具的一个类别');
INSERT INTO e_category VALUES ('7', '期刊类', '这是关于期刊的一个类别');

--往书籍表中插入数据
insert into e_book(id,name,price,categoryId) values(book_id_seq.nextval,'JAVA核心技术','81','3');
insert into e_book(id,name,price,categoryId) values(book_id_seq.nextval,'UNIX技术手册','21.15','3');
insert into e_book(id,name,price,categoryId) values(book_id_seq.nextval,'ORACLE9I参考手册','108','6');
insert into e_book(id,name,price,categoryId) values(book_id_seq.nextval, 'JSP设计(第三版)', '59.25','3');
insert into e_book(id,name,price,categoryId) values(book_id_seq.nextval, '唐诗三百首', '38.25','4');
insert into e_book(id,name,price,categoryId) values(book_id_seq.nextval, '好妈妈胜过好老师', '97.20','2');
insert into e_book(id,name,price,categoryId) values(book_id_seq.nextval, '育儿心经', '36.75','2');
insert into e_book(id,name,price,categoryId) values(book_id_seq.nextval, '水浒传', '44.25','1');
insert into e_book(id,name,price,categoryId) values(book_id_seq.nextval, '三国演义', '29.25','1');
insert into e_book(id,name,price,categoryId) values(book_id_seq.nextval, '活着', '44.25','1');
insert into e_book(id,name,price,categoryId) values(book_id_seq.nextval, '猫和老鼠', '12','5');
insert into e_book(id,name,price,categoryId) values(book_id_seq.nextval, '小猪佩奇', '44.25','5');
insert into e_book(id,name,price,categoryId) values(book_id_seq.nextval, '求职注意事项', '100','7');
insert into e_book(id,name,price,categoryId) values(book_id_seq.nextval, '70周年大庆', '100','7');
commit;


