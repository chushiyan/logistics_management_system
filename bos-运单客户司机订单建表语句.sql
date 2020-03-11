/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/11/24 21:02:15                          */
/*==============================================================*/


drop table if exists bos_staff;

drop table if exists customer;

drop table if exists data_dict;

drop table if exists linkman;

drop table if exists order_item;

drop table if exists short_driver;

drop table if exists short_driver_order_item_ref;

drop table if exists trailer_driver;

drop table if exists waybill;

/*==============================================================*/
/* Table: bos_staff                                             */
/*==============================================================*/
create table bos_staff
(
   staff_id             varchar(100) not null,
   staff_name           varchar(10) comment 'Ա������',
   staff_password       varchar(400) comment '��¼����',
   staff_idcard         varchar(20) comment '���֤����',
   staff_gender         int comment '�Ա�0��Ů��1����',
   staff_wechat         varchar(100) comment '΢�ź�',
   staff_qq             varchar(20) comment 'qq��',
   staff_email          varchar(100) comment '����',
   staff_birthday       date comment '����',
   staff_hiredate       date comment '��Ӷ��ʼ����',
   staff_salary         int comment '����',
   staff_position       varchar(50) comment 'ְλ',
   staff_status         int default 1 comment '״̬��0����ְ�� 1����ְ��',
   primary key (staff_id)
);

alter table bos_staff comment 'Ա����';

/*==============================================================*/
/* Table: customer                                              */
/*==============================================================*/
create table customer
(
   customer_id          varchar(200) not null,
   customer_name        varchar(50),
   customer_fullname    varchar(255),
   customer_address     varchar(200),
   customer_status      int default 1,
   primary key (customer_id)
);

alter table customer comment '�ͻ���';

/*==============================================================*/
/* Table: data_dict                                             */
/*==============================================================*/
create table data_dict
(
   dict_id              varchar(32) not null,
   dict_type_code       varchar(255),
   dict_type_name       varchar(255),
   dict_type_value      int,
   dict_status          int comment '0�����á�   1��ʹ���С�',
   primary key (dict_id)
);

alter table data_dict comment '�����ֵ�';

/*==============================================================*/
/* Table: linkman                                               */
/*==============================================================*/
create table linkman
(
   linkman_id           varchar(200) not null,
   linkman_name         varchar(10),
   linkman_gender       int comment '0��Ů �� 1����',
   linkman_phone        varchar(11),
   linkman_mobile       varchar(15),
   linkman_email        varchar(255),
   linkman_position     varchar(255),
   linkman_memo         varchar(255),
   customer_id          varchar(200),
   linkman_status       int default 1,
   primary key (linkman_id)
);

alter table linkman comment '�ͻ���ϵ��';

/*==============================================================*/
/* Table: order_item                                            */
/*==============================================================*/
create table order_item
(
   order_item_id        varchar(100) not null comment '������š��˹�ָ��',
   shipping_date        date comment '��������',
   packaging_type       varchar(20) comment '��װ��ʽ',
   weight               double,
   volume               double,
   packages_number      int comment '����',
   goods_name           varchar(15) comment '����',
   shipping_address     varchar(100) comment '�����ջ���ַ',
   receiver             varchar(20) comment '�ջ���',
   receiver_phone       varchar(20) comment '�ջ����ֻ����绰',
   freight              int comment '�˷ѡ���λ����',
   daofukuan            int comment '������',
   short_barge_fee      int comment '�̲��ѡ�',
   memo                 varchar(100) comment '��ע',
   waybill_id           varchar(200) comment '�˻���id',
   customer_id          varchar(200),
   order_status         int comment '������״̬��0��ɾ���� 1�����ռ��� 2�������С� 3�������С� 4�����'',',
   primary key (order_item_id)
);

alter table order_item comment '������';

/*==============================================================*/
/* Table: short_driver                                          */
/*==============================================================*/
create table short_driver
(
   driver_id            varchar(200) not null,
   driver_name          varchar(10) comment '˾������',
   driver_id_card       varchar(20) comment '˾�����֤��',
   driver_phone         varchar(11) comment '˾���ֻ���',
   driver_wechat        varchar(100) comment '˾��΢�ź�',
   car_number           varchar(20) comment '���ƺ�',
   car_length           double comment '���᳤��',
   car_height           double comment '����߶�',
   car_width            double comment '������',
   car_load             double comment '����',
   car_volume           double comment '�������',
   car_type             int comment '���ͣ�0�����ơ� 1�����ơ� 2������',
   driver_status        int,
   primary key (driver_id)
);

alter table short_driver comment '�̲���˾����';

/*==============================================================*/
/* Table: short_driver_order_item_ref                           */
/*==============================================================*/
create table short_driver_order_item_ref
(
   order_item_id        varchar(100) not null comment '������š��˹�ָ��',
   driver_id            varchar(200) not null,
   primary key (order_item_id, driver_id)
);

alter table short_driver_order_item_ref comment '�̲�˾���������м��';

/*==============================================================*/
/* Table: trailer_driver                                        */
/*==============================================================*/
create table trailer_driver
(
   driver_id            varchar(200) not null,
   driver_name          varchar(10) comment '�ҳ�˾������',
   driver_id_card       varchar(20) comment '˾�����֤',
   driver_phone         varchar(11) comment '˾���ֻ�',
   driver_wechat        varchar(100),
   car_number           varchar(20) comment '���ƺ�',
   car_length           double comment '���᳤��',
   car_height           double comment '����߶�',
   car_width            double comment '������',
   car_load             double comment '������',
   car_volume           double comment '�������',
   driver_status        int default 1,
   primary key (driver_id)
);

alter table trailer_driver comment '��;�ҳ�˾����';

/*==============================================================*/
/* Table: waybill                                               */
/*==============================================================*/
create table waybill
(
   waybill_id           varchar(200) not null,
   departure_date       date comment '��������',
   settlement_method    varchar(10) comment '���㷽ʽ��Ԥ�����ؽᡢԤ���ؽᡢ������Ԥ������',
   yufukuan             int comment 'Ԥ�����λ����',
   daofukuan            int comment '�������λ����',
   huijiekuan           int comment '�ص������˷ѡ�Return bill check freight',
   agreement_nun        varchar(50) comment 'Э����',
   driver_id            varchar(200) comment '����˾��id',
   waybill_status       int comment '�˵�״̬��0��ɾ����  1������',
   primary key (waybill_id)
);

alter table waybill comment '�˻���';

alter table linkman add constraint FK_Reference_3 foreign key (customer_id)
      references customer (customer_id) on delete restrict on update restrict;

alter table order_item add constraint FK_Reference_13 foreign key (customer_id)
      references customer (customer_id) on delete restrict on update restrict;

alter table order_item add constraint FK_Reference_2 foreign key (waybill_id)
      references waybill (waybill_id) on delete restrict on update restrict;

alter table short_driver_order_item_ref add constraint FK_Reference_11 foreign key (order_item_id)
      references order_item (order_item_id) on delete restrict on update restrict;

alter table short_driver_order_item_ref add constraint FK_Reference_12 foreign key (driver_id)
      references short_driver (driver_id) on delete restrict on update restrict;

alter table waybill add constraint FK_Reference_1 foreign key (driver_id)
      references trailer_driver (driver_id) on delete restrict on update restrict;

