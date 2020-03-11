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
   privilege_name       varchar(255) comment 'Ȩ������',
   privilege_description varchar(255) comment 'Ȩ������',
   privilege_path       varchar(255) comment 'Ȩ�޵�·��',
   privilege_parent_id  varchar(100),
   privilege_status     int default 1 comment '״̬��0�����á�1��ʹ����',
   primary key (privilege_id)
);

alter table bos_privilege comment 'Ȩ�ޱ�';

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

alter table bos_role comment '��ɫ��';

/*==============================================================*/
/* Table: bos_user                                              */
/*==============================================================*/
create table bos_user
(
   user_id              varchar(100) not null,
   user_name            varchar(10) comment 'Ա������',
   user_password        varchar(400) comment '��¼����',
   user_status          int default 1 comment '״̬��0����ְ�� 1����ְ��',
   primary key (user_id)
);

alter table bos_user comment '�û���';

/*==============================================================*/
/* Table: role_privilege_ref                                    */
/*==============================================================*/
create table role_privilege_ref
(
   role_id              varchar(32) not null,
   privilege_id         varchar(100) not null,
   primary key (role_id, privilege_id)
);

alter table role_privilege_ref comment '��ɫȨ�ޱ�';

/*==============================================================*/
/* Table: user_role_ref                                         */
/*==============================================================*/
create table user_role_ref
(
   user_id              varchar(100) not null,
   role_id              varchar(32) not null,
   primary key (user_id, role_id)
);

alter table user_role_ref comment '�û���ɫ��';

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

