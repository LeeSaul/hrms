/*序列
*/
-- 游客序列
create SEQUENCE tour_seq
  START WITH 1
  INCREMENT BY 1
  MAXVALUE 999999
  NOCYCLE
  NOCACHE
;
delete from tourist where id=27;
-- 员工序列
create SEQUENCE user_seq
START WITH 1
INCREMENT BY 1
MAXVALUE 999999
NOCYCLE
NOCACHE;
-- 其他序列
create SEQUENCE aa
START WITH 1
INCREMENT BY 1
MAXVALUE 999999
NOCYCLE
NOCACHE;

/*游客表tourist
id tour_name tour_password tour_stutus*/
create table tourist(
  id number(11) not null primary KEY,
  resume_id NUMBER(4),
  tour_name VARCHAR2(255),
  tour_password varchar2(255),
  tour_status varchar2(20) DEFAULT '未录用', /*未录用，已录用*/
  resume_id NUMBER(4)
);
/*
员工表employee
id resume_id position_id emp_name emp_password emp_status  type*/
create table employee(
  id NUMBER(11) not null primary key,
  tourist_id NUMBER(4),
  position_id NUMBER(4),
  emp_name varchar2(255),
  emp_password varchar2(255),
  emp_status varchar2(255),
  emp_type VARCHAR2(255),
  basic_wage NUMBER(10,2),
  proportion NUMBER(10,2)
);


/*简历表简历表resume
*/
create table resume(
  id number(11) not null primary key,
  tourst_id NUMBER(11),
  name VARCHAR2(25),
  age NUMBER(11),
  gender VARCHAR2(25),
  phone VARCHAR2(25),
  birthdate VARCHAR2(255),
  birthplace VARCHAR2(255),
  job VARCHAR2(25),
  education VARCHAR2(25),
  image VARCHAR2(255),
  special_skill VARCHAR2(255),
  hobbies VARCHAR2(255),
  awards VARCHAR2(255),
  marry VARCHAR2(25),
  email VARCHAR(255),
  self_evaluation VARCHAR2(600),
  work_experience VARCHAR2(600),
  project_experience VARCHAR2(600),
  education_experience varchar2(600)
);

/*部门表department
*/
create table department(
  id NUMBER(4),
  dep_name VARCHAR2(25),
  dep_type varchar2(25),
  dep_description VARCHAR2(100)
);
/*职位表position
*/

create table position(
  id NUMBER(4) not null PRIMARY KEY,
  pos_name varchar2(25),
  pos_description VARCHAR2(25)
);
-- 管理员账号
insert into EMPLOYEE(id,emp_name, emp_password, emp_status,emp_type)
VALUES(aa.nextval,'admin','admin','可用',0);

/*
招聘表recruitment
*/
create table recruitment(
  id NUMBER(4) PRIMARY KEY ,
  working_place VARCHAR2(255),
  salary VARCHAR2(255),
  position_type varchar2(255),
  description VARCHAR2(255),
  create_date TIMESTAMP,
  other_info varchar2(255)
);

-- 投递记录表id
create table delivery(
  id NUMBER(4) PRIMARY KEY ,
  resume_id NUMBER(4),
  rec_id NUMBER(4),
  status VARCHAR2(25)
);
-- 职位表
create table depOption(
  ID NUMBER(4) PRIMARY KEY,
  DEP_ID NUMBER(4),
  option_name VARCHAR2(25),
  option_desc VARCHAR2(100)
);
-- 培训表
create table train (
  id NUMBER(4) primary KEY,
  title VARCHAR2(255),
  content VARCHAR2(255),
  start_time VARCHAR2(255),
  end_time VARCHAR2(255),
  create_time VARCHAR2(255)
);

-- 培训通知
create table trainNotice(
  id NUMBER(4) PRIMARY KEY ,
  train_id NUMBER(4) ,
  emp_id NUMBER(4)
);
/*奖惩表rewards_punishment
id salary_id rewards fine caption att_id*/
create table rewards_punishment(
  id NUMBER(4) primary key,
  emp_id VARCHAR2(255),
  rewards_fine VARCHAR2(255),
  caption VARCHAR2(255),
  att_id number(4)
);
/*考勤表attendance
id emp_id start_time end_time work_time off_work_time*/
create table attendance(
  id NUMBER(4) PRIMARY KEY ,
  emp_id NUMBER(4),
  start_time TIMESTAMP,
  end_time TIMESTAMP
);

-- 薪资表salary(基本薪资和社保基本不变的，每次工资结算都是需要的，放在员工的基本信息中);
-- id emp_id basic_id social_security  overtime_pay
create table salary(
  id NUMBER(4) primary key,
  emp_id NUMBER(4),
  social_securtity NUMBER(10,2),
  overtime_pay NUMBER(10,2),
  performance_pay number(10,2),
  re_pun_pay NUMBER(10,2),
  real_wage NUMBER(10,2),
  create_date varchar2(25)
);

create table suggest (
  id           NUMBER(4) PRIMARY KEY,
  suggest_info VARCHAR2(255),
  emp_id       NUMBER(4)
);

select * from attendance where
  to_date(create_time,'yyyy-mm-dd hh24:mi:ss') > to_date('2009-02-04 21:17:00','yyyy-mm-dd hh24:mi:ss');

-- 工作表work
create table work(
  id NUMBER(4) PRIMARY KEY,
  work_time VARCHAR2(25),
  off_work_time VARCHAR2(25),
  days number(4),
  overtime VARCHAR2(25),
  over_pay VARCHAR2(25)
);

select sysdate - 300/(24*60*60) from dual; /*当前时间*/

-- 考勤测试数据

-- 考勤测试数据


insert into attendance(id, emp_id,start_time,END_TIME)
VALUES(aa.nextval,52,to_date('2017-10-01 08:21:13','yyyy-mm-dd hh24:mi:ss'),
       to_date('2017-10-01 19:21:13','yyyy-mm-dd hh24:mi:ss'));
insert into attendance(id, emp_id,start_time,END_TIME)
VALUES(aa.nextval,52,to_date('2017-10-02 08:21:13','yyyy-mm-dd hh24:mi:ss'),
       to_date('2017-10-02 19:21:13','yyyy-mm-dd hh24:mi:ss'));
insert into attendance(id, emp_id,start_time,END_TIME)
VALUES(aa.nextval,52,to_date('2017-10-03 09:21:13','yyyy-mm-dd hh24:mi:ss'),
       to_date('2017-10-03 19:21:13','yyyy-mm-dd hh24:mi:ss'));
insert into attendance(id, emp_id,start_time,END_TIME)
VALUES(aa.nextval,52,to_date('2017-10-04 08:21:13','yyyy-mm-dd hh24:mi:ss'),
       to_date('2017-10-04 19:21:13','yyyy-mm-dd hh24:mi:ss'));
insert into attendance(id, emp_id,start_time,END_TIME)
VALUES(aa.nextval,52,to_date('2017-10-05 08:21:13','yyyy-mm-dd hh24:mi:ss'),
       to_date('2017-10-05 19:21:13','yyyy-mm-dd hh24:mi:ss'));
insert into attendance(id, emp_id,start_time,END_TIME)
VALUES(aa.nextval,52,to_date('2017-10-06 08:21:13','yyyy-mm-dd hh24:mi:ss'),
       to_date('2017-10-06 19:21:13','yyyy-mm-dd hh24:mi:ss'));
insert into attendance(id, emp_id,start_time,END_TIME)
VALUES(aa.nextval,52,to_date('2017-10-07 08:21:13','yyyy-mm-dd hh24:mi:ss'),
       to_date('2017-10-07 19:21:13','yyyy-mm-dd hh24:mi:ss'));
insert into attendance(id, emp_id,start_time,END_TIME)
VALUES(aa.nextval,52,to_date('2017-10-08 10:21:13','yyyy-mm-dd hh24:mi:ss'),
       to_date('2017-10-08 19:21:13','yyyy-mm-dd hh24:mi:ss'));
insert into attendance(id, emp_id,start_time,END_TIME)
VALUES(aa.nextval,52,to_date('2017-10-09 08:21:13','yyyy-mm-dd hh24:mi:ss'),
       to_date('2017-10-09 19:21:13','yyyy-mm-dd hh24:mi:ss'));
insert into attendance(id, emp_id,start_time,END_TIME)
VALUES(aa.nextval,52,to_date('2017-10-10 08:21:13','yyyy-mm-dd hh24:mi:ss'),
       to_date('2017-10-10 19:21:13','yyyy-mm-dd hh24:mi:ss'));
insert into attendance(id, emp_id,start_time,END_TIME)
VALUES(aa.nextval,52,to_date('2017-10-11 08:21:13','yyyy-mm-dd hh24:mi:ss'),
       to_date('2017-10-11 19:21:13','yyyy-mm-dd hh24:mi:ss'));
insert into attendance(id, emp_id,start_time,END_TIME)
VALUES(aa.nextval,52,to_date('2017-10-12 08:21:13','yyyy-mm-dd hh24:mi:ss'),
       to_date('2017-10-12 19:21:13','yyyy-mm-dd hh24:mi:ss'));
insert into attendance(id, emp_id,start_time,END_TIME)
VALUES(aa.nextval,52,to_date('2017-10-13 08:21:13','yyyy-mm-dd hh24:mi:ss'),
       to_date('2017-10-13 19:21:13','yyyy-mm-dd hh24:mi:ss'));
insert into attendance(id, emp_id,start_time,END_TIME)
VALUES(aa.nextval,52,to_date('2017-10-14 08:21:13','yyyy-mm-dd hh24:mi:ss'),
       to_date('2017-10-14 19:21:13','yyyy-mm-dd hh24:mi:ss'));
insert into attendance(id, emp_id,start_time,END_TIME)
VALUES(aa.nextval,52,to_date('2017-10-15 08:21:13','yyyy-mm-dd hh24:mi:ss'),
       to_date('2017-10-15 19:21:13','yyyy-mm-dd hh24:mi:ss'));
insert into attendance(id, emp_id,start_time,END_TIME)
VALUES(aa.nextval,52,to_date('2017-10-16 08:21:13','yyyy-mm-dd hh24:mi:ss'),
       to_date('2017-10-16 19:21:13','yyyy-mm-dd hh24:mi:ss'));
insert into attendance(id, emp_id,start_time,END_TIME)
VALUES(aa.nextval,52,to_date('2017-10-17 08:21:13','yyyy-mm-dd hh24:mi:ss'),
       to_date('2017-10-17 19:21:13','yyyy-mm-dd hh24:mi:ss'));
insert into attendance(id, emp_id,start_time,END_TIME)
VALUES(aa.nextval,52,to_date('2017-10-18 08:21:13','yyyy-mm-dd hh24:mi:ss'),
       to_date('2017-10-18 19:21:13','yyyy-mm-dd hh24:mi:ss'));
insert into attendance(id, emp_id,start_time,END_TIME)
VALUES(aa.nextval,52,to_date('2017-10-19 08:21:13','yyyy-mm-dd hh24:mi:ss'),
       to_date('2017-10-19 19:21:13','yyyy-mm-dd hh24:mi:ss'));
insert into attendance(id, emp_id,start_time,END_TIME)
VALUES(aa.nextval,52,to_date('2017-10-20 08:21:13','yyyy-mm-dd hh24:mi:ss'),
       to_date('2017-10-20 19:21:13','yyyy-mm-dd hh24:mi:ss'));
insert into attendance(id, emp_id,start_time,END_TIME)
VALUES(aa.nextval,52,to_date('2017-10-21 08:21:13','yyyy-mm-dd hh24:mi:ss'),
       to_date('2017-10-21 19:21:13','yyyy-mm-dd hh24:mi:ss'));




insert into attendance(id, emp_id,start_time,END_TIME)
VALUES(aa.nextval,47,to_date('2017-10-22 08:21:13','yyyy-mm-dd hh24:mi:ss'),
       to_date('2017-10-22 19:21:13','yyyy-mm-dd hh24:mi:ss'));
insert into attendance(id, emp_id,start_time,END_TIME)
VALUES(aa.nextval,47,to_date('2017-10-23 08:21:13','yyyy-mm-dd hh24:mi:ss'),
       to_date('2017-10-23 19:21:13','yyyy-mm-dd hh24:mi:ss'));
insert into attendance(id, emp_id,start_time,END_TIME)
VALUES(aa.nextval,47,to_date('2017-10-24 08:21:13','yyyy-mm-dd hh24:mi:ss'),
       to_date('2017-10-24 19:21:13','yyyy-mm-dd hh24:mi:ss'));
insert into attendance(id, emp_id,start_time,END_TIME)
VALUES(aa.nextval,47
  ,to_date('2017-10-25 08:21:13','yyyy-mm-dd hh24:mi:ss'),
       to_date('2017-10-25 19:21:13','yyyy-mm-dd hh24:mi:ss'));
insert into attendance(id, emp_id,start_time,END_TIME)
VALUES(aa.nextval,47,to_date('2017-10-26 08:21:13','yyyy-mm-dd hh24:mi:ss'),
       to_date('2017-10-26 19:21:13','yyyy-mm-dd hh24:mi:ss'));



insert into attendance(id, emp_id,start_time,END_TIME)
VALUES(aa.nextval,47,to_date('2017-10-27 08:21:13','yyyy-mm-dd hh24:mi:ss'),
       to_date('2017-10-27 19:21:13','yyyy-mm-dd hh24:mi:ss'));
insert into attendance(id, emp_id,start_time,END_TIME)
VALUES(aa.nextval,47,to_date('2017-10-28 08:21:13','yyyy-mm-dd hh24:mi:ss'),
       to_date('2017-10-28 19:21:13','yyyy-mm-dd hh24:mi:ss'));
insert into attendance(id, emp_id,start_time,END_TIME)
VALUES(aa.nextval,47,to_date('2017-10-29 08:21:13','yyyy-mm-dd hh24:mi:ss'),
       to_date('2017-10-29 19:21:13','yyyy-mm-dd hh24:mi:ss'));
insert into attendance(id, emp_id,start_time,END_TIME)
VALUES(aa.nextval,47,to_date('2017-10-30 08:21:13','yyyy-mm-dd hh24:mi:ss'),
       to_date('2017-10-30 19:21:13','yyyy-mm-dd hh24:mi:ss'));
insert into attendance(id, emp_id,start_time,END_TIME)
VALUES(aa.nextval,47,to_date('2017-10-31 08:21:13','yyyy-mm-dd hh24:mi:ss'),
       to_date('2017-10-31 19:21:13','yyyy-mm-dd hh24:mi:ss'));
