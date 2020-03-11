drop database bos3;
CREATE DATABASE `bos3` CHARACTER SET utf8 ;
use bos3;

/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/11/24 13:14:04                          */
/*==============================================================*/


drop table if exists bos_privilege;

drop table if exists bos_role;

drop table if exists bos_user;

drop table if exists role_privilege_ref;

drop table if exists user_role_ref;

/*==============================================================*/
/* Table: bos_privilege                                         */
/*==============================================================*/
create table bos_privilege
(
   privilege_id         varchar(100) not null,
   privilege_name       varchar(255) comment '权限名称',
   privilege_description varchar(255) comment '权限描述',
   privilege_path       varchar(255) comment '权限的路径',
   privilege_parent_id  varchar(100),
   privilege_status     int default 1 comment '状态。0：弃用。1：使用中',
   primary key (privilege_id)
);

alter table bos_privilege comment '权限表';

/*==============================================================*/
/* Table: bos_role                                              */
/*==============================================================*/
create table bos_role
(
   role_id              varchar(32) not null,
   role_name            varchar(255),
   role_description     varchar(255),
   role_status          int default 1,
   primary key (role_id)
);

alter table bos_role comment '角色表';

/*==============================================================*/
/* Table: bos_user                                              */
/*==============================================================*/
create table bos_user
(
   user_id              varchar(100) not null,
   user_name            varchar(10) comment '员工姓名',
   user_password        varchar(400) comment '登录密码',
   user_status          int default 1 comment '状态。0：离职。 1：在职。',
   primary key (user_id)
);

alter table bos_user comment '用户表';

/*==============================================================*/
/* Table: role_privilege_ref                                    */
/*==============================================================*/
create table role_privilege_ref
(
   role_id              varchar(32) not null,
   privilege_id         varchar(100) not null,
   primary key (role_id, privilege_id)
);

alter table role_privilege_ref comment '角色权限表';

/*==============================================================*/
/* Table: user_role_ref                                         */
/*==============================================================*/
create table user_role_ref
(
   user_id              varchar(100) not null,
   role_id              varchar(32) not null,
   primary key (user_id, role_id)
);

alter table user_role_ref comment '用户角色表';

alter table bos_privilege add constraint FK_Reference_105 foreign key (privilege_parent_id)
      references bos_privilege (privilege_id) on delete restrict on update restrict;

alter table role_privilege_ref add constraint FK_Reference_108 foreign key (role_id)
      references bos_role (role_id) on delete restrict on update restrict;

alter table role_privilege_ref add constraint FK_Reference_109 foreign key (privilege_id)
      references bos_privilege (privilege_id) on delete restrict on update restrict;

alter table user_role_ref add constraint FK_Reference_106 foreign key (user_id)
      references bos_user (user_id) on delete restrict on update restrict;

alter table user_role_ref add constraint FK_Reference_107 foreign key (role_id)
      references bos_role (role_id) on delete restrict on update restrict;

