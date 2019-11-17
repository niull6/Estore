
create sequence cus_id_seq start with 1 increment by 1;
--�û���
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
--�����
create table e_category(
	id number primary key,
	name varchar2(40),
	info varchar2(255)
);

create sequence book_id_seq start with 1 increment by 1;
--�鼮�� 
create table e_book(
	id number primary key,
	name varchar2(50) not null,
	price number(10,2),
	categoryId number references e_category(id)
);

create sequence order_id_seq start with 1 increment by 1;
--������
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
--�������
create table e_orderline(
	id number primary key,
	num number,
	bookId number references e_book(id),
	orderId number references e_order(id)
);
create sequence orderLine_sequence start with 1 increment by 1;

--���鼮����в�������
INSERT INTO e_category VALUES ('1', '��ѧ��', '��ѧ��һ��������ǹ�����ѧ��һ��������ǹ�����ѧ��һ��������ǹ�����ѧ��һ�����');
INSERT INTO e_category VALUES ('2', '������', '���ǹ��ڽ�����һ�����');
INSERT INTO e_category VALUES ('3', '�������', '���ǹ��ڼ������һ�����');
INSERT INTO e_category VALUES ('4', '��ͯ��', '���ǹ��ڶ�ͯ��һ�����');
INSERT INTO e_category VALUES ('5', '������', '���ǹ���������һ�����');
INSERT INTO e_category VALUES ('6', '������', '���ǹ��ڹ��ߵ�һ�����');
INSERT INTO e_category VALUES ('7', '�ڿ���', '���ǹ����ڿ���һ�����');

--���鼮���в�������
insert into e_book(id,name,price,categoryId) values(book_id_seq.nextval,'JAVA���ļ���','81','3');
insert into e_book(id,name,price,categoryId) values(book_id_seq.nextval,'UNIX�����ֲ�','21.15','3');
insert into e_book(id,name,price,categoryId) values(book_id_seq.nextval,'ORACLE9I�ο��ֲ�','108','6');
insert into e_book(id,name,price,categoryId) values(book_id_seq.nextval, 'JSP���(������)', '59.25','3');
insert into e_book(id,name,price,categoryId) values(book_id_seq.nextval, '��ʫ������', '38.25','4');
insert into e_book(id,name,price,categoryId) values(book_id_seq.nextval, '������ʤ������ʦ', '97.20','2');
insert into e_book(id,name,price,categoryId) values(book_id_seq.nextval, '�����ľ�', '36.75','2');
insert into e_book(id,name,price,categoryId) values(book_id_seq.nextval, 'ˮ䰴�', '44.25','1');
insert into e_book(id,name,price,categoryId) values(book_id_seq.nextval, '��������', '29.25','1');
insert into e_book(id,name,price,categoryId) values(book_id_seq.nextval, '����', '44.25','1');
insert into e_book(id,name,price,categoryId) values(book_id_seq.nextval, 'è������', '12','5');
insert into e_book(id,name,price,categoryId) values(book_id_seq.nextval, 'С������', '44.25','5');
insert into e_book(id,name,price,categoryId) values(book_id_seq.nextval, '��ְע������', '100','7');
insert into e_book(id,name,price,categoryId) values(book_id_seq.nextval, '70�������', '100','7');
commit;


