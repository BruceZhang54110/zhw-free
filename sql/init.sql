create database demo_test;

drop table user_info;
create table user_info (
                           id int auto_increment not null comment '主键id',
                           name varchar(50) not null default '' comment '用户名',
                           dept_id int not null default 0 comment '所属部门',
                           create_time datetime comment '创建时间',
                           primary key (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 comment '用户表';


create table dept_info (
                           id int auto_increment not null comment '主键id',
                           dept_name varchar(50) not null default '' comment '部门名',
                           create_time datetime comment '创建时间',
                           primary key (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 comment '部门表';


insert into user_info(name, dept_id, create_time) values ('张三', 1, now());


select  * from user_info;



show create table user_info;