drop table train;
drop table traintype;
drop table staffalter;
drop table staffagreement;
drop table staff;
drop table position;
drop table department;
drop table admin;

---------------------
--管理员表
---------------------
create table admin(
	admin_id number(20) primary key,
	admin_password varchar2(20) not null,
	admin_username varchar2(20) not null
);

drop sequence adm_seq;
create sequence adm_seq increment by 1 start with 5 ;


insert into admin values ('1', '1234', '1234');
insert into admin values ('3', '123', '123');


---------------------
--部门表
---------------------


create table department(
	dept_id number(11) primary key,
	dept_name varchar2(20) not null	
);



insert into department values (1,'董事局');
insert into department values (2,'管理部');
insert into department values (3,'技术部');
insert into department values (4,'人事部');
insert into department values (5,'后勤部');
insert into department values (6,'财务部');



---------------------
--职位表
---------------------


create table position(
	pos_id number(11) primary key ,
	pos_name varchar2(20) not null,
	dept_id number(11) references department(dept_id) on delete cascade	
);

insert into position values (1,'董事长',1);
insert into position values (2,'董事',1);
insert into position values (3,'CEO',1);
insert into position values (4,'总监',2);
insert into position values (5,'经理',2);
insert into position values (6,'职员',2);
insert into position values (7,'总监',3);
insert into position values (8,'经理',3);
insert into position values (9,'职员',3);
insert into position values (10,'总监',4);
insert into position values (11,'经理',4);
insert into position values (12,'职员',4);
insert into position values (13,'总监',5);
insert into position values (14,'经理',5);
insert into position values (15,'职员',5);
insert into position values (16,'总监',6);
insert into position values (17,'经理',6);
insert into position values (18,'职员',6);


----------
--员工表
----------
create table staff(
	p_id number(11) primary key,
	p_name varchar2(20),
	sex varchar2(5),
	degree varchar2(20),
	pos_id number(11) references position(pos_id) on delete cascade,
	state varchar2(20),
	dept_id number(11) references department(dept_id) on delete cascade, 
	username varchar2(50),
	password varchar2(50)
);

drop sequence staff_seq;
create sequence staff_seq increment by 1 start with 11;

insert into staff values ('1', '张一', '男', '博士', 1, '在职', '1', 'zhangyi', 'zhangyi');
insert into staff values ('2', '张二', '男', '博士', 2, '在职', '1', 'zhanger', 'zhanger');
insert into staff values ('3', '张三', '男', '研究生', 4, '在职', '2', 'zhangsan', 'zhangsan');
insert into staff values ('4', '张四', '男', '研究生', 4, '在职', '3', 'zhangsi', '1234');
insert into staff values ('5', '张五', '男', '研究生', 5, '在职', '4', 'zhangwu', '1234');
insert into staff values ('6', '张六', '男', '本科', 6, '在职', '5', 'zhangliu', '1234');
insert into staff values ('7', '张七', '男', '本科', 7, '在职', '4', 'zhangqi', '1234');
insert into staff values ('8', '张八', '男', '本科', 8, '在职', '6', 'zhangba', '1234');
insert into staff values ('9', '张九', '男', '专科', 9, '在职', '6', 'zhangjiu', '1234');
insert into staff values ('10', '张十', '男', '专科', 10, '在职', '5', 'zhangshi', '1234');





---------------------
--员工合同表
---------------------
create table staffagreement(
	p_id number(11) primary key references staff(p_id) on delete cascade,
	agreement_id number(11) not null,
	agreement_btime date not null,
	agreement_content varchar2(100) not null
);


drop sequence agreement_seq;
create sequence agreement_seq increment by 1 start with 11;


insert into staffagreement values ('1', '1',to_date('2017-01-15','YYYY-MM-DD'), '1.docx');
insert into staffagreement values ('2', '2',to_date('2017-01-16','YYYY-MM-DD'), '2.docx');
insert into staffagreement values ('3', '3',to_date('2017-03-23','YYYY-MM-DD'), '3.docx');
insert into staffagreement values ('4', '4',to_date('2017-03-15','YYYY-MM-DD'), '4.docx');
insert into staffagreement values ('5', '5',to_date('2017-01-28','YYYY-MM-DD'), '5.docx');
insert into staffagreement values ('6', '6',to_date('2017-04-18','YYYY-MM-DD'), '6.docx');
insert into staffagreement values ('7', '7',to_date('2017-01-01','YYYY-MM-DD'), '7.docx');
insert into staffagreement values ('8', '8',to_date('2017-03-09','YYYY-MM-DD'), '8.docx');
insert into staffagreement values ('9', '9',to_date('2017-03-31','YYYY-MM-DD'), '9.docx');
insert into staffagreement values ('10', '10',to_date('2017-03-18','YYYY-MM-DD'), '10.docx');




---------------------
--员工出差表
---------------------

create table staffalter(
	alter_id number(11) primary key,
	p_id number(11) references staff(p_id) on delete cascade,
	alter_btime date,
	alter_etime date,
	alter_content varchar2(100)
);

drop sequence staffalter_seq;
create sequence staffalter_seq increment by 1 start with 11;


insert into staffalter values ('1', '1',to_date('2017-01-08','YYYY-MM-DD'),to_date('2017-01-22','YYYY-MM-DD'), '一号测试');
insert into staffalter values ('2', '2',to_date('2017-01-08','YYYY-MM-DD'),to_date('2017-01-22','YYYY-MM-DD'), '二号测试');
insert into staffalter values ('3', '3',to_date('2017-01-08','YYYY-MM-DD'),to_date('2017-01-22','YYYY-MM-DD'), '三号测试');
insert into staffalter values ('4', '4',to_date('2017-01-08','YYYY-MM-DD'),to_date('2017-01-22','YYYY-MM-DD'), '测试');
insert into staffalter values ('5', '5',to_date('2017-01-08','YYYY-MM-DD'),to_date('2017-01-22','YYYY-MM-DD'), '测试');
insert into staffalter values ('6', '6',to_date('2017-03-01','YYYY-MM-DD'),to_date( '2017-03-21', 'YYYY-MM-DD'),'测试');
insert into staffalter values ('7', '7',to_date('2017-03-04','YYYY-MM-DD'),to_date( '2017-03-23', 'YYYY-MM-DD'),'测试');
insert into staffalter values ('8', '8',to_date('2017-03-03','YYYY-MM-DD'),to_date( '2017-03-25', 'YYYY-MM-DD'),'测试');
insert into staffalter values ('9', '9',to_date('2017-03-18','YYYY-MM-DD'),to_date( '2017-03-24','YYYY-MM-DD'), '测试');
insert into staffalter values ('10', '10',to_date('2017-03-09','YYYY-MM-DD'),to_date( '2017-03-25','YYYY-MM-DD'), '测试');


---------------------
--员工培训表
---------------------

create table train(
	train_id number(11) primary key,
	type_code number(20),
	train_btime date,
	train_etime date,
	train_expense varchar2(20),
	p_id number(11) references staff(p_id) on delete cascade
);

drop sequence train_seq;
create sequence train_seq increment by 1 start with 11;


insert into train values ('1', '1',to_date('2017-01-18','YYYY-MM-DD'),to_date( '2017-01-24','YYYY-MM-DD'), '测试培训心得', '1');
insert into train values ('2', '2',to_date('2017-03-09','YYYY-MM-DD'),to_date('2017-03-30','YYYY-MM-DD'), '很棒', '3');
insert into train values ('3', '3',to_date('2017-03-01','YYYY-MM-DD'),to_date('2017-03-16','YYYY-MM-DD'), '很nice', '2');
insert into train values ('4', '4',to_date('2017-01-01','YYYY-MM-DD'),to_date('2017-01-17','YYYY-MM-DD'), 'hhh', '1');
insert into train values ('5', '4',to_date('2017-03-09','YYYY-MM-DD'),to_date('2017-03-24','YYYY-MM-DD'), '完美', '4');
insert into train values ('6', '5',to_date('2017-03-01','YYYY-MM-DD'),to_date('2017-03-31','YYYY-MM-DD'), '棒极了', '1');
insert into train values ('7', '7',to_date('2017-03-16','YYYY-MM-DD'),to_date('2017-03-23','YYYY-MM-DD'), '无敌', '2');
insert into train values ('8', '6',to_date('2017-03-15','YYYY-MM-DD'),to_date('2017-03-23','YYYY-MM-DD'), '新人加入', '3');
insert into train values ('9', '8',to_date('2017-03-09','YYYY-MM-DD'),to_date('2017-03-25','YYYY-MM-DD'), '培训开始', '4');
insert into train values ('10', '9',to_date('2017-03-16','YYYY-MM-DD'),to_date('2017-03-30','YYYY-MM-DD'), '努力学习', '3');



---------------------
--培训类型表
---------------------

create table traintype(
	type_name varchar2(50),
	type_code number(20) primary key,
	type_info varchar2(200)
);


insert into traintype values ('IT培训', '1', 'IT专业技能培训');
insert into traintype values ('Office培训', '2', '训练office技能');
insert into traintype values ('团队建设培训', '3', '增强团队合作能力');
insert into traintype values ('礼仪培训', '4', '熟悉礼仪');
insert into traintype values ('入职培训', '5', '新人必须参加');
insert into traintype values ('业务培训', '6', '熟悉业务');
insert into traintype values ('SAP培训', '7', '掌握SAP技能');
insert into traintype values ('Oracle培训', '8', '掌握Oracle技能');
insert into traintype values ('Android培训', '9', '掌握Android技能');
insert into traintype values ('Java培训', '10', '掌握Java技能');


commit;



