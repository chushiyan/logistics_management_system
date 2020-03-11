# data_dict表
insert into data_dict(dict_id,dict_type_code,dict_type_name,dict_type_value,dict_status)values('0','car_type','绿牌','0',1);
insert into data_dict(dict_id,dict_type_code,dict_type_name,dict_type_value,dict_status)values('1','car_type','蓝牌','1',1);
insert into data_dict(dict_id,dict_type_code,dict_type_name,dict_type_value,dict_status)values('2','car_type','黄牌','2',1);

insert into data_dict(dict_id,dict_type_code,dict_type_name,dict_type_value,dict_status) values('3','order_status','已删除','0',1);
insert into data_dict(dict_id,dict_type_code,dict_type_name,dict_type_value,dict_status) values('4','order_status','已收件','1',1);
insert into data_dict(dict_id,dict_type_code,dict_type_name,dict_type_value,dict_status) values('5','order_status','运输中','2',1);
insert into data_dict(dict_id,dict_type_code,dict_type_name,dict_type_value,dict_status) values('6','order_status','派送中','3',1);
insert into data_dict(dict_id,dict_type_code,dict_type_name,dict_type_value,dict_status) values('7','order_status','已完成','4',1);


# customer表
insert into customer(customer_id,customer_name,customer_fullname,customer_address,customer_status)values('1','甲公司','','上海',1);
insert into customer(customer_id,customer_name,customer_fullname,customer_address,customer_status)values('2','乙公司','','杭州',1);
insert into customer(customer_id,customer_name,customer_fullname,customer_address,customer_status)values('3','丙公司','','苏州',1);
insert into customer(customer_id,customer_name,customer_fullname,customer_address,customer_status)values('4','丁公司','','太仓',1);
insert into customer(customer_id,customer_name,customer_fullname,customer_address,customer_status)values('5','戊公司','','昆山',1);
insert into customer(customer_id,customer_name,customer_fullname,customer_address,customer_status)values('6','己公司','','嘉兴',1);



# linkman表  
insert into linkman(linkman_id,linkman_name,linkman_gender,linkman_phone,linkman_mobile,linkman_email,linkman_position,linkman_memo,customer_id,linkman_status)values(1,'李斌','1','18812345678','87549512','libin@163.com','经理','',1,1);
insert into linkman(linkman_id,linkman_name,linkman_gender,linkman_phone,linkman_mobile,linkman_email,linkman_position,linkman_memo,customer_id,linkman_status)values(2,'章明','1','18012345678','87549512','zhangming@163.com','业务员','',1,1);

insert into linkman(linkman_id,linkman_name,linkman_gender,linkman_phone,linkman_mobile,linkman_email,linkman_position,linkman_memo,customer_id,linkman_status)values(3,'孙振','1','18912345678','87549512','sunzhen@163.com','副总经理','',2,1);
insert into linkman(linkman_id,linkman_name,linkman_gender,linkman_phone,linkman_mobile,linkman_email,linkman_position,linkman_memo,customer_id,linkman_status)values(4,'张景','1','18912345678','87549512','zhangjing@163.com','总经理助理','',2,1);

insert into linkman(linkman_id,linkman_name,linkman_gender,linkman_phone,linkman_mobile,linkman_email,linkman_position,linkman_memo,customer_id,linkman_status)values(5,'赵廷','1','18012345678','87549512','zhaoting@163.com','总经理','',3,1);
insert into linkman(linkman_id,linkman_name,linkman_gender,linkman_phone,linkman_mobile,linkman_email,linkman_position,linkman_memo,customer_id,linkman_status)values(6,'赵岩','1','18012345678','87549512','zhaoyan@163.com','物流主管','',3,1);

insert into linkman(linkman_id,linkman_name,linkman_gender,linkman_phone,linkman_mobile,linkman_email,linkman_position,linkman_memo,customer_id,linkman_status)values(7,'郑军','1','18012345678','87549512','zhengjun@163.com','物流经理','',4,1);
insert into linkman(linkman_id,linkman_name,linkman_gender,linkman_phone,linkman_mobile,linkman_email,linkman_position,linkman_memo,customer_id,linkman_status)values(8,'周明','1','18012345678','87549512','zhouming@163.com','物流员','',4,1);

insert into linkman(linkman_id,linkman_name,linkman_gender,linkman_phone,linkman_mobile,linkman_email,linkman_position,linkman_memo,customer_id,linkman_status)values(9,'武钢','1','18012345678','87549512','wugang@163.com','副总经理','',5,1);
insert into linkman(linkman_id,linkman_name,linkman_gender,linkman_phone,linkman_mobile,linkman_email,linkman_position,linkman_memo,customer_id,linkman_status)values(10,'李柯','1','18012345678','87549512','like@163.com','发货员','',5,1);

insert into linkman(linkman_id,linkman_name,linkman_gender,linkman_phone,linkman_mobile,linkman_email,linkman_position,linkman_memo,customer_id,linkman_status)values(11,'陈鹏','1','18012345678','87549512','chenpeng@163.com','物流经理','',6,1);
insert into linkman(linkman_id,linkman_name,linkman_gender,linkman_phone,linkman_mobile,linkman_email,linkman_position,linkman_memo,customer_id,linkman_status)values(12,'朱强','1','18012345678','87549512','zhuqiang@163.com','物流员','',6,1);



# short_driver表
insert into short_driver(driver_id,driver_name,driver_id_card,driver_phone,driver_wechat,car_number,car_length,car_height,car_width,car_load,car_volume,car_type,driver_status)values(1,'吕布','458713199001024580','15512345678','lvbu1990','沪B456086',4.2,2,2,3.5,16.8,1,1);

insert into short_driver(driver_id,driver_name,driver_id_card,driver_phone,driver_wechat,car_number,car_length,car_height,car_width,car_load,car_volume,car_type,driver_status)values(2,'赵云','526713199101024580','15512345678','zhaoyun','沪B758086',4,2,2,2.5,16,1,1);

insert into short_driver(driver_id,driver_name,driver_id_card,driver_phone,driver_wechat,car_number,car_length,car_height,car_width,car_load,car_volume,car_type,driver_status)values(3,'典韦','788713199101024580','15512345678','dianwei','沪B758086',4.2,2,2,3.5,16.8,0,1);

insert into short_driver(driver_id,driver_name,driver_id_card,driver_phone,driver_wechat,car_number,car_length,car_height,car_width,car_load,car_volume,car_type,driver_status)values(4,'关羽','258713199101024580','15512345678','guanyu','沪B814286',4.2,2,2,3.5,16.8,0,1);

insert into short_driver(driver_id,driver_name,driver_id_card,driver_phone,driver_wechat,car_number,car_length,car_height,car_width,car_load,car_volume,car_type,driver_status)values(5,'张飞','458713199211124580','15512345678','zhangfei123','沪D128080',4.2,1.8,1.8,3,14,0,1);

insert into short_driver(driver_id,driver_name,driver_id_card,driver_phone,driver_wechat,car_number,car_length,car_height,car_width,car_load,car_volume,car_type,driver_status)values(6,'黄忠','458713199311124580','15012345678','huangzhong','沪D780004',7.6,2,2,10,29,2,1);

insert into short_driver(driver_id,driver_name,driver_id_card,driver_phone,driver_wechat,car_number,car_length,car_height,car_width,car_load,car_volume,car_type,driver_status)values(7,'许褚','854713199311124580','15012345678','xuchu','沪C007185',7.6,2,2,10,29,2,1);

insert into short_driver(driver_id,driver_name,driver_id_card,driver_phone,driver_wechat,car_number,car_length,car_height,car_width,car_load,car_volume,car_type,driver_status)values(8,'张辽','458713199211124580','15512345678','zhangliao','沪D787084',4.2,1.8,1.8,3,14,0,1);

insert into short_driver(driver_id,driver_name,driver_id_card,driver_phone,driver_wechat,car_number,car_length,car_height,car_width,car_load,car_volume,car_type,driver_status)values(9,'夏侯渊','458713199211124580','15512345678','xiahouyuan','沪A017096',4.2,1.8,1.8,3,14,0,1);

insert into short_driver(driver_id,driver_name,driver_id_card,driver_phone,driver_wechat,car_number,car_length,car_height,car_width,car_load,car_volume,car_type,driver_status)values(10,'许褚','854713199311124580','15012345678','xuchu','沪C007107',7.6,2,2,10,29,2,1);

insert into short_driver(driver_id,driver_name,driver_id_card,driver_phone,driver_wechat,car_number,car_length,car_height,car_width,car_load,car_volume,car_type,driver_status)values(11,'夏侯淳','854713199311124580','15012345678','xiahouchun','沪A07015',9.6,2,2,12,36,2,1);

insert into short_driver(driver_id,driver_name,driver_id_card,driver_phone,driver_wechat,car_number,car_length,car_height,car_width,car_load,car_volume,car_type,driver_status)values(12,'张郃','854713199311124580','15012345678','zhanghe','沪C741101',7.6,2,2,10,29,2,1);



# trailer_driver表
insert into trailer_driver(driver_id,driver_name,driver_id_card,driver_phone,driver_wechat,car_number,car_length,car_height,car_width,car_load,car_volume,driver_status)values(1,'荀彧','854713199311124580','18112345678','xunyu','赣A784689',17,4,4,25,270,1);

insert into trailer_driver(driver_id,driver_name,driver_id_card,driver_phone,driver_wechat,car_number,car_length,car_height,car_width,car_load,car_volume,driver_status)values(2,'贾诩','854713199311124580','18112345678','xunyu','赣A784689',17,4,4,25,270,1);

insert into trailer_driver(driver_id,driver_name,driver_id_card,driver_phone,driver_wechat,car_number,car_length,car_height,car_width,car_load,car_volume,driver_status)values(3,'郭嘉','854713199311124580','18112345678','xunyu','粤A463531',17,4,4,25,270,1);

insert into trailer_driver(driver_id,driver_name,driver_id_card,driver_phone,driver_wechat,car_number,car_length,car_height,car_width,car_load,car_volume,driver_status)values(4,'程昱','854713199311124580','18112345678','xunyu','闽S74546',17,4,4,25,270,1);

insert into trailer_driver(driver_id,driver_name,driver_id_card,driver_phone,driver_wechat,car_number,car_length,car_height,car_width,car_load,car_volume,driver_status)values(5,'蒋济','854713199311124580','18112345678','xunyu','浙D741233',17,4,4,25,270,1);

insert into trailer_driver(driver_id,driver_name,driver_id_card,driver_phone,driver_wechat,car_number,car_length,car_height,car_width,car_load,car_volume,driver_status)values(6,'陈群','854713199311124580','18112345678','xunyu','苏A78421',17,4,4,25,270,1);

insert into trailer_driver(driver_id,driver_name,driver_id_card,driver_phone,driver_wechat,car_number,car_length,car_height,car_width,car_load,car_volume,driver_status)values(7,'华歆','854713199311124580','18112345678','xunyu','赣A745211',20,4,4,25,300,1);

insert into trailer_driver(driver_id,driver_name,driver_id_card,driver_phone,driver_wechat,car_number,car_length,car_height,car_width,car_load,car_volume,driver_status)values(8,'钟繇','854713199311124580','18112345678','xunyu','粤A41255',17,4,4,25,270,1);

insert into trailer_driver(driver_id,driver_name,driver_id_card,driver_phone,driver_wechat,car_number,car_length,car_height,car_width,car_load,car_volume,driver_status)values(9,'满宠','854713199311124580','18112345678','xunyu','粤B862341',17,4,4,25,270,1);

insert into trailer_driver(driver_id,driver_name,driver_id_card,driver_phone,driver_wechat,car_number,car_length,car_height,car_width,car_load,car_volume,driver_status)values(10,'董昭','854713199311124580','18112345678','xunyu','沪D456800',17,4,4,25,270,1);

insert into trailer_driver(driver_id,driver_name,driver_id_card,driver_phone,driver_wechat,car_number,car_length,car_height,car_width,car_load,car_volume,driver_status)values(11,'王朗','854713199311124580','18112345678','xunyu','赣B451368',17,4,4,25,270,1);

insert into trailer_driver(driver_id,driver_name,driver_id_card,driver_phone,driver_wechat,car_number,car_length,car_height,car_width,car_load,car_volume,driver_status)values(12,'崔琰','854713199311124580','18112345678','xunyu','赣B451368',17,4,4,25,270,1);




# waybill表
insert into waybill(waybill_id,departure_date,settlement_method,yufukuan,daofukuan,huijiekuan,agreement_nun,driver_id,waybill_status)values(1,'2019-01-01','预付回结',1000000,0,300000,'2019010101','1',1);

insert into waybill(waybill_id,departure_date,settlement_method,yufukuan,daofukuan,huijiekuan,agreement_nun,driver_id,waybill_status)values(2,'2019-01-02','预付',1300000,0,0,'2019010201','1',1);

insert into waybill(waybill_id,departure_date,settlement_method,yufukuan,daofukuan,huijiekuan,agreement_nun,driver_id,waybill_status)values(3,'2019-01-03','预付',1400000,0,0,'2019010401','1',1);

insert into waybill(waybill_id,departure_date,settlement_method,yufukuan,daofukuan,huijiekuan,agreement_nun,driver_id,waybill_status)values(4,'2019-01-04','预付回结',900000,0,500000,'2019010401','1',1);

insert into waybill(waybill_id,departure_date,settlement_method,yufukuan,daofukuan,huijiekuan,agreement_nun,driver_id,waybill_status)values(5,'2019-01-05','预付回结',800000,0,600000,'2019010501','1',1);

insert into waybill(waybill_id,departure_date,settlement_method,yufukuan,daofukuan,huijiekuan,agreement_nun,driver_id,waybill_status)values(6,'2019-01-06','预付回结',500000,0,800000,'2019010601','1',1);

insert into waybill(waybill_id,departure_date,settlement_method,yufukuan,daofukuan,huijiekuan,agreement_nun,driver_id,waybill_status)values(7,'2019-01-07','回结',0,0,1300000,'2019010701','1',1);




# order_item表
insert into order_item(order_item_id,shipping_date,packaging_type,weight,volume,packages_number,goods_name,shipping_address,receiver,receiver_phone,freight,daofukuan,short_barge_fee,memo,waybill_id,customer_id,order_status)values(1,'2019-01-01','托盘',2000,5,4,'电子产品','深圳龙岗','李先生','189112233445',4000,0,240,'',1,1,1);

insert into order_item(order_item_id,shipping_date,packaging_type,weight,volume,packages_number,goods_name,shipping_address,receiver,receiver_phone,freight,daofukuan,short_barge_fee,memo,waybill_id,customer_id,order_status)values(2,'2019-01-01','托盘',1000,3,4,'电脑','深圳福田','章先生','180112233445',2000,0,240,'',1,2,1);

insert into order_item(order_item_id,shipping_date,packaging_type,weight,volume,packages_number,goods_name,shipping_address,receiver,receiver_phone,freight,daofukuan,short_barge_fee,memo,waybill_id,customer_id,order_status)values(3,'2019-01-01','',2000,5,4,'电子产品','深圳龙华','戴先生','156112233445',1000,0,240,'',1,3,1);

insert into order_item(order_item_id,shipping_date,packaging_type,weight,volume,packages_number,goods_name,shipping_address,receiver,receiver_phone,freight,daofukuan,short_barge_fee,memo,waybill_id,customer_id,order_status)values(4,'2019-01-01','',2000,5,4,'电子产品','深圳龙岗','李先生','189112233445',4000,0,240,'',1,4,1);

insert into order_item(order_item_id,shipping_date,packaging_type,weight,volume,packages_number,goods_name,shipping_address,receiver,receiver_phone,freight,daofukuan,short_barge_fee,memo,waybill_id,customer_id,order_status)values(5,'2019-01-01','托盘',2000,5,4,'电子产品','深圳龙岗','李先生','189112233445',4000,0,240,'',1,5,1);

insert into order_item(order_item_id,shipping_date,packaging_type,weight,volume,packages_number,goods_name,shipping_address,receiver,receiver_phone,freight,daofukuan,short_barge_fee,memo,waybill_id,customer_id,order_status)values(6,'2019-01-01','托盘',2000,5,4,'电子产品','深圳龙岗','李先生','189112233445',4000,0,240,'',1,6,1);

insert into order_item(order_item_id,shipping_date,packaging_type,weight,volume,packages_number,goods_name,shipping_address,receiver,receiver_phone,freight,daofukuan,short_barge_fee,memo,waybill_id,customer_id,order_status)values(7,'2019-01-01','托盘',2000,5,4,'电子产品','深圳龙岗','李先生','189112233445',4000,0,240,'',1,1,1);

insert into order_item(order_item_id,shipping_date,packaging_type,weight,volume,packages_number,goods_name,shipping_address,receiver,receiver_phone,freight,daofukuan,short_barge_fee,memo,waybill_id,customer_id,order_status)values(39,'2019-01-07','托盘',2000,5,4,'电脑','深圳龙岗','李先生','189112233445',4000,0,240,'',7,3,1);

insert into order_item(order_item_id,shipping_date,packaging_type,weight,volume,packages_number,goods_name,shipping_address,receiver,receiver_phone,freight,daofukuan,short_barge_fee,memo,waybill_id,customer_id,order_status)values(40,'2019-01-07','托盘',2000,5,4,'电脑','深圳龙岗','孙小姐','189112233445',4000,0,240,'',7,2,1);




insert into order_item(order_item_id,shipping_date,packaging_type,weight,volume,packages_number,goods_name,shipping_address,receiver,receiver_phone,freight,daofukuan,short_barge_fee,memo,waybill_id,customer_id,order_status)values(8,'2019-01-02','托盘',2000,5,4,'电子产品','深圳龙岗','李先生','189112233445',4000,0,240,'',2,1,1);

insert into order_item(order_item_id,shipping_date,packaging_type,weight,volume,packages_number,goods_name,shipping_address,receiver,receiver_phone,freight,daofukuan,short_barge_fee,memo,waybill_id,customer_id,order_status)values(9,'2019-01-02','托盘',1000,3,4,'电脑','深圳福田','章先生','180112233445',2000,0,240,'',2,2,1);

insert into order_item(order_item_id,shipping_date,packaging_type,weight,volume,packages_number,goods_name,shipping_address,receiver,receiver_phone,freight,daofukuan,short_barge_fee,memo,waybill_id,customer_id,order_status)values(10,'2019-01-02','',2000,5,4,'电子产品','深圳龙华','戴先生','156112233445',1000,0,240,'',2,3,1);

insert into order_item(order_item_id,shipping_date,packaging_type,weight,volume,packages_number,goods_name,shipping_address,receiver,receiver_phone,freight,daofukuan,short_barge_fee,memo,waybill_id,customer_id,order_status)values(11,'2019-01-02','',2000,5,4,'电子产品','深圳龙岗','李先生','189112233445',4000,0,240,'',2,4,1);

insert into order_item(order_item_id,shipping_date,packaging_type,weight,volume,packages_number,goods_name,shipping_address,receiver,receiver_phone,freight,daofukuan,short_barge_fee,memo,waybill_id,customer_id,order_status)values(12,'2019-01-02','托盘',2000,5,4,'电子产品','深圳龙岗','李先生','189112233445',4000,0,240,'',2,5,1);

insert into order_item(order_item_id,shipping_date,packaging_type,weight,volume,packages_number,goods_name,shipping_address,receiver,receiver_phone,freight,daofukuan,short_barge_fee,memo,waybill_id,customer_id,order_status)values(13,'2019-01-02','托盘',2000,5,4,'电子产品','深圳龙岗','李先生','189112233445',4000,0,240,'',2,6,1);

insert into order_item(order_item_id,shipping_date,packaging_type,weight,volume,packages_number,goods_name,shipping_address,receiver,receiver_phone,freight,daofukuan,short_barge_fee,memo,waybill_id,customer_id,order_status)values(14,'2019-01-02','托盘',2000,5,4,'电子产品','深圳龙岗','李先生','189112233445',4000,0,240,'',2,1,1);




insert into order_item(order_item_id,shipping_date,packaging_type,weight,volume,packages_number,goods_name,shipping_address,receiver,receiver_phone,freight,daofukuan,short_barge_fee,memo,waybill_id,customer_id,order_status)values(15,'2019-01-03','托盘',2000,5,4,'电子产品','深圳龙岗','李先生','189112233445',4000,0,240,'',3,1,1);

insert into order_item(order_item_id,shipping_date,packaging_type,weight,volume,packages_number,goods_name,shipping_address,receiver,receiver_phone,freight,daofukuan,short_barge_fee,memo,waybill_id,customer_id,order_status)values(16,'2019-01-03','托盘',1000,3,4,'电脑','深圳福田','章先生','180112233445',2000,0,240,'',3,2,1);

insert into order_item(order_item_id,shipping_date,packaging_type,weight,volume,packages_number,goods_name,shipping_address,receiver,receiver_phone,freight,daofukuan,short_barge_fee,memo,waybill_id,customer_id,order_status)values(17,'2019-01-03','',2000,5,4,'电子产品','深圳龙华','戴先生','156112233445',1000,0,240,'',3,3,1);

insert into order_item(order_item_id,shipping_date,packaging_type,weight,volume,packages_number,goods_name,shipping_address,receiver,receiver_phone,freight,daofukuan,short_barge_fee,memo,waybill_id,customer_id,order_status)values(18,'2019-01-03','',2000,5,4,'电子产品','深圳龙岗','李先生','189112233445',4000,0,240,'',3,4,1);

insert into order_item(order_item_id,shipping_date,packaging_type,weight,volume,packages_number,goods_name,shipping_address,receiver,receiver_phone,freight,daofukuan,short_barge_fee,memo,waybill_id,customer_id,order_status)values(19,'2019-01-03','托盘',2000,5,4,'电子产品','深圳龙岗','李先生','189112233445',4000,0,240,'',3,5,1);

insert into order_item(order_item_id,shipping_date,packaging_type,weight,volume,packages_number,goods_name,shipping_address,receiver,receiver_phone,freight,daofukuan,short_barge_fee,memo,waybill_id,customer_id,order_status)values(20,'2019-01-03','托盘',2000,5,4,'电子产品','深圳龙岗','李先生','189112233445',4000,0,240,'',3,6,1);

insert into order_item(order_item_id,shipping_date,packaging_type,weight,volume,packages_number,goods_name,shipping_address,receiver,receiver_phone,freight,daofukuan,short_barge_fee,memo,waybill_id,customer_id,order_status)values(21,'2019-01-03','托盘',2000,5,4,'电子产品','深圳龙岗','李先生','189112233445',4000,0,240,'',3,1,1);






insert into order_item(order_item_id,shipping_date,packaging_type,weight,volume,packages_number,goods_name,shipping_address,receiver,receiver_phone,freight,daofukuan,short_barge_fee,memo,waybill_id,customer_id,order_status)values(22,'2019-01-04','托盘',2000,5,4,'电子产品','深圳龙岗','钱先生','189112233445',4000,0,240,'',4,2,1);


insert into order_item(order_item_id,shipping_date,packaging_type,weight,volume,packages_number,goods_name,shipping_address,receiver,receiver_phone,freight,daofukuan,short_barge_fee,memo,waybill_id,customer_id,order_status)values(23,'2019-01-04','托盘',2000,5,4,'电子产品','深圳龙岗','钱先生','189112233445',4000,0,240,'',4,2,1);


insert into order_item(order_item_id,shipping_date,packaging_type,weight,volume,packages_number,goods_name,shipping_address,receiver,receiver_phone,freight,daofukuan,short_barge_fee,memo,waybill_id,customer_id,order_status)values(24,'2019-01-04','托盘',2000,5,4,'电子产品','深圳龙岗','李先生','189112233445',4000,0,240,'',4,2,1);

insert into order_item(order_item_id,shipping_date,packaging_type,weight,volume,packages_number,goods_name,shipping_address,receiver,receiver_phone,freight,daofukuan,short_barge_fee,memo,waybill_id,customer_id,order_status)values(25,'2019-01-04','托盘',2000,5,4,'手机','深圳龙岗','李先生','189112233445',4000,0,240,'',4,2,1);


insert into order_item(order_item_id,shipping_date,packaging_type,weight,volume,packages_number,goods_name,shipping_address,receiver,receiver_phone,freight,daofukuan,short_barge_fee,memo,waybill_id,customer_id,order_status)values(26,'2019-01-04','托盘',2000,5,4,'电脑','深圳龙岗','李先生','189112233445',4000,0,240,'',4,2,1);




insert into order_item(order_item_id,shipping_date,packaging_type,weight,volume,packages_number,goods_name,shipping_address,receiver,receiver_phone,freight,daofukuan,short_barge_fee,memo,waybill_id,customer_id,order_status)values(27,'2019-01-05','托盘',2000,5,4,'电子产品','深圳龙岗','钱先生','189112233445',4000,0,240,'',5,2,1);


insert into order_item(order_item_id,shipping_date,packaging_type,weight,volume,packages_number,goods_name,shipping_address,receiver,receiver_phone,freight,daofukuan,short_barge_fee,memo,waybill_id,customer_id,order_status)values(28,'2019-01-05','托盘',2000,5,4,'电子产品','深圳龙岗','李先生','189112233445',4000,0,240,'',5,2,1);

insert into order_item(order_item_id,shipping_date,packaging_type,weight,volume,packages_number,goods_name,shipping_address,receiver,receiver_phone,freight,daofukuan,short_barge_fee,memo,waybill_id,customer_id,order_status)values(29,'2019-01-05','托盘',2000,5,4,'手机','深圳龙岗','李先生','189112233445',4000,0,240,'',5,2,1);


insert into order_item(order_item_id,shipping_date,packaging_type,weight,volume,packages_number,goods_name,shipping_address,receiver,receiver_phone,freight,daofukuan,short_barge_fee,memo,waybill_id,customer_id,order_status)values(30,'2019-01-05','托盘',2000,5,4,'电脑','深圳龙岗','李先生','189112233445',4000,0,240,'',5,2,1);




insert into order_item(order_item_id,shipping_date,packaging_type,weight,volume,packages_number,goods_name,shipping_address,receiver,receiver_phone,freight,daofukuan,short_barge_fee,memo,waybill_id,customer_id,order_status)values(31,'2019-01-06','托盘',2000,5,4,'电子产品','深圳龙岗','钱先生','189112233445',4000,0,240,'',6,5,1);


insert into order_item(order_item_id,shipping_date,packaging_type,weight,volume,packages_number,goods_name,shipping_address,receiver,receiver_phone,freight,daofukuan,short_barge_fee,memo,waybill_id,customer_id,order_status)values(32,'2019-01-06','托盘',2000,5,4,'电子产品','深圳龙岗','李先生','189112233445',4000,0,240,'',6,2,1);

insert into order_item(order_item_id,shipping_date,packaging_type,weight,volume,packages_number,goods_name,shipping_address,receiver,receiver_phone,freight,daofukuan,short_barge_fee,memo,waybill_id,customer_id,order_status)values(33,'2019-01-06','',2000,5,4,'手机','深圳龙岗','李先生','189112233445',4000,0,240,'',6,3,1);


insert into order_item(order_item_id,shipping_date,packaging_type,weight,volume,packages_number,goods_name,shipping_address,receiver,receiver_phone,freight,daofukuan,short_barge_fee,memo,waybill_id,customer_id,order_status)values(34,'2019-01-06','托盘',2000,5,4,'电脑','深圳龙岗','李先生','189112233445',4000,0,240,'',6,1,1);



insert into order_item(order_item_id,shipping_date,packaging_type,weight,volume,packages_number,goods_name,shipping_address,receiver,receiver_phone,freight,daofukuan,short_barge_fee,memo,waybill_id,customer_id,order_status)values(35,'2019-01-07','',2000,5,4,'电脑','深圳龙岗','钱先生','189112233445',4000,0,240,'',7,5,1);


insert into order_item(order_item_id,shipping_date,packaging_type,weight,volume,packages_number,goods_name,shipping_address,receiver,receiver_phone,freight,daofukuan,short_barge_fee,memo,waybill_id,customer_id,order_status)values(36,'2019-01-07','托盘',2000,5,4,'电机','深圳龙岗','李先生','189112233445',4000,0,240,'',7,2,1);

insert into order_item(order_item_id,shipping_date,packaging_type,weight,volume,packages_number,goods_name,shipping_address,receiver,receiver_phone,freight,daofukuan,short_barge_fee,memo,waybill_id,customer_id,order_status)values(37,'2019-01-07','',2000,5,4,'笔记簿','深圳龙岗','李先生','189112233445',4000,0,240,'',7,3,1);


insert into order_item(order_item_id,shipping_date,packaging_type,weight,volume,packages_number,goods_name,shipping_address,receiver,receiver_phone,freight,daofukuan,short_barge_fee,memo,waybill_id,customer_id,order_status)values(38,'2019-01-07','托盘',2000,5,4,'电脑','深圳龙岗','李先生','189112233445',4000,0,240,'',7,1,1);



# short_driver_order_item_ref表
insert into short_driver_order_item_ref(order_item_id,driver_id)values(1,1);
insert into short_driver_order_item_ref(order_item_id,driver_id)values(2,2);
insert into short_driver_order_item_ref(order_item_id,driver_id)values(3,3);
insert into short_driver_order_item_ref(order_item_id,driver_id)values(4,4);
insert into short_driver_order_item_ref(order_item_id,driver_id)values(5,1);
insert into short_driver_order_item_ref(order_item_id,driver_id)values(6,2);
insert into short_driver_order_item_ref(order_item_id,driver_id)values(7,3);
insert into short_driver_order_item_ref(order_item_id,driver_id)values(8,4);
insert into short_driver_order_item_ref(order_item_id,driver_id)values(9,1);
insert into short_driver_order_item_ref(order_item_id,driver_id)values(10,2);
insert into short_driver_order_item_ref(order_item_id,driver_id)values(11,3);
insert into short_driver_order_item_ref(order_item_id,driver_id)values(12,4);
insert into short_driver_order_item_ref(order_item_id,driver_id)values(13,1);
insert into short_driver_order_item_ref(order_item_id,driver_id)values(14,2);
insert into short_driver_order_item_ref(order_item_id,driver_id)values(15,3);
insert into short_driver_order_item_ref(order_item_id,driver_id)values(16,4);
insert into short_driver_order_item_ref(order_item_id,driver_id)values(17,5);
insert into short_driver_order_item_ref(order_item_id,driver_id)values(18,6);
insert into short_driver_order_item_ref(order_item_id,driver_id)values(19,7);
insert into short_driver_order_item_ref(order_item_id,driver_id)values(20,8);
insert into short_driver_order_item_ref(order_item_id,driver_id)values(21,9);
insert into short_driver_order_item_ref(order_item_id,driver_id)values(22,10);
insert into short_driver_order_item_ref(order_item_id,driver_id)values(23,11);
insert into short_driver_order_item_ref(order_item_id,driver_id)values(24,12);

insert into short_driver_order_item_ref(order_item_id,driver_id)values(25,1);
insert into short_driver_order_item_ref(order_item_id,driver_id)values(26,2);
insert into short_driver_order_item_ref(order_item_id,driver_id)values(27,3);
insert into short_driver_order_item_ref(order_item_id,driver_id)values(28,5);
insert into short_driver_order_item_ref(order_item_id,driver_id)values(29,6);
insert into short_driver_order_item_ref(order_item_id,driver_id)values(30,7);
insert into short_driver_order_item_ref(order_item_id,driver_id)values(31,8);
insert into short_driver_order_item_ref(order_item_id,driver_id)values(32,9);
insert into short_driver_order_item_ref(order_item_id,driver_id)values(33,10);
insert into short_driver_order_item_ref(order_item_id,driver_id)values(34,12);
insert into short_driver_order_item_ref(order_item_id,driver_id)values(35,12);

insert into short_driver_order_item_ref(order_item_id,driver_id)values(36,7);
insert into short_driver_order_item_ref(order_item_id,driver_id)values(37,2);
insert into short_driver_order_item_ref(order_item_id,driver_id)values(38,2);
insert into short_driver_order_item_ref(order_item_id,driver_id)values(39,1);
insert into short_driver_order_item_ref(order_item_id,driver_id)values(40,1);




