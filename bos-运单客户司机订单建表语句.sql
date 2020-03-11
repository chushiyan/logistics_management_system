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
   staff_name           varchar(10) comment '员工姓名',
   staff_password       varchar(400) comment '登录密码',
   staff_idcard         varchar(20) comment '身份证号码',
   staff_gender         int comment '性别。0：女。1：男',
   staff_wechat         varchar(100) comment '微信号',
   staff_qq             varchar(20) comment 'qq号',
   staff_email          varchar(100) comment '邮箱',
   staff_birthday       date comment '生日',
   staff_hiredate       date comment '雇佣开始日期',
   staff_salary         int comment '工资',
   staff_position       varchar(50) comment '职位',
   staff_status         int default 1 comment '状态。0：离职。 1：在职。',
   primary key (staff_id)
);

alter table bos_staff comment '员工表';

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

alter table customer comment '客户表';

/*==============================================================*/
/* Table: data_dict                                             */
/*==============================================================*/
create table data_dict
(
   dict_id              varchar(32) not null,
   dict_type_code       varchar(255),
   dict_type_name       varchar(255),
   dict_type_value      int,
   dict_status          int comment '0：弃用。   1：使用中。',
   primary key (dict_id)
);

alter table data_dict comment '数据字典';

/*==============================================================*/
/* Table: linkman                                               */
/*==============================================================*/
create table linkman
(
   linkman_id           varchar(200) not null,
   linkman_name         varchar(10),
   linkman_gender       int comment '0：女 ， 1：男',
   linkman_phone        varchar(11),
   linkman_mobile       varchar(15),
   linkman_email        varchar(255),
   linkman_position     varchar(255),
   linkman_memo         varchar(255),
   customer_id          varchar(200),
   linkman_status       int default 1,
   primary key (linkman_id)
);

alter table linkman comment '客户联系人';

/*==============================================================*/
/* Table: order_item                                            */
/*==============================================================*/
create table order_item
(
   order_item_id        varchar(100) not null comment '订单编号。人工指定',
   shipping_date        date comment '发车日期',
   packaging_type       varchar(20) comment '包装方式',
   weight               double,
   volume               double,
   packages_number      int comment '件数',
   goods_name           varchar(15) comment '货名',
   shipping_address     varchar(100) comment '货物收货地址',
   receiver             varchar(20) comment '收货人',
   receiver_phone       varchar(20) comment '收货人手机、电话',
   freight              int comment '运费。单位：分',
   daofukuan            int comment '到付款',
   short_barge_fee      int comment '短驳费。',
   memo                 varchar(100) comment '备注',
   waybill_id           varchar(200) comment '运货单id',
   customer_id          varchar(200),
   order_status         int comment '订单项状态。0：删除。 1：已收件。 2：运输中。 3：派送中。 4：完成'',',
   primary key (order_item_id)
);

alter table order_item comment '订单项';

/*==============================================================*/
/* Table: short_driver                                          */
/*==============================================================*/
create table short_driver
(
   driver_id            varchar(200) not null,
   driver_name          varchar(10) comment '司机姓名',
   driver_id_card       varchar(20) comment '司机身份证号',
   driver_phone         varchar(11) comment '司机手机号',
   driver_wechat        varchar(100) comment '司机微信号',
   car_number           varchar(20) comment '车牌号',
   car_length           double comment '车厢长度',
   car_height           double comment '车厢高度',
   car_width            double comment '车厢宽度',
   car_load             double comment '载重',
   car_volume           double comment '车厢体积',
   car_type             int comment '车型，0：绿牌。 1：蓝牌。 2：黄牌',
   driver_status        int,
   primary key (driver_id)
);

alter table short_driver comment '短驳车司机表';

/*==============================================================*/
/* Table: short_driver_order_item_ref                           */
/*==============================================================*/
create table short_driver_order_item_ref
(
   order_item_id        varchar(100) not null comment '订单编号。人工指定',
   driver_id            varchar(200) not null,
   primary key (order_item_id, driver_id)
);

alter table short_driver_order_item_ref comment '短驳司机、订单中间表';

/*==============================================================*/
/* Table: trailer_driver                                        */
/*==============================================================*/
create table trailer_driver
(
   driver_id            varchar(200) not null,
   driver_name          varchar(10) comment '挂车司机姓名',
   driver_id_card       varchar(20) comment '司机身份证',
   driver_phone         varchar(11) comment '司机手机',
   driver_wechat        varchar(100),
   car_number           varchar(20) comment '车牌号',
   car_length           double comment '车厢长度',
   car_height           double comment '车厢高度',
   car_width            double comment '车厢宽度',
   car_load             double comment '总载重',
   car_volume           double comment '车厢体积',
   driver_status        int default 1,
   primary key (driver_id)
);

alter table trailer_driver comment '长途挂车司机表';

/*==============================================================*/
/* Table: waybill                                               */
/*==============================================================*/
create table waybill
(
   waybill_id           varchar(200) not null,
   departure_date       date comment '发车日期',
   settlement_method    varchar(10) comment '结算方式：预付、回结、预付回结、到付、预付到付',
   yufukuan             int comment '预付款。单位：分',
   daofukuan            int comment '到付款。单位：分',
   huijiekuan           int comment '回单结算运费。Return bill check freight',
   agreement_nun        varchar(50) comment '协议编号',
   driver_id            varchar(200) comment '卡车司机id',
   waybill_status       int comment '运单状态。0：删除。  1：正常',
   primary key (waybill_id)
);

alter table waybill comment '运货单';

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

