
# 权限表

insert into bos_privilege(privilege_id ,privilege_name,privilege_description,privilege_path,privilege_parent_id)values(0,'系统管理','拥有所有权限',null,null);


insert into bos_privilege(privilege_id ,privilege_name,privilege_description,privilege_path,privilege_parent_id)values(1,'用户管理','','',0);

insert into bos_privilege(privilege_id ,privilege_name,privilege_description,privilege_path,privilege_parent_id)values(11,'用户增加','','user-add',1);
insert into bos_privilege(privilege_id ,privilege_name,privilege_description,privilege_path,privilege_parent_id)values(12,'用户删除','','user-delete',1);
insert into bos_privilege(privilege_id ,privilege_name,privilege_description,privilege_path,privilege_parent_id)values(13,'用户修改','','user-update',1);
insert into bos_privilege(privilege_id ,privilege_name,privilege_description,privilege_path,privilege_parent_id)values(14,'用户查询','','user-find',1);


insert into bos_privilege(privilege_id ,privilege_name,privilege_description,privilege_path,privilege_parent_id)values(2,'角色管理','','',0);
insert into bos_privilege(privilege_id ,privilege_name,privilege_description,privilege_path,privilege_parent_id)values(21,'角色增加','','role-add',2);
insert into bos_privilege(privilege_id ,privilege_name,privilege_description,privilege_path,privilege_parent_id)values(22,'角色删除','','role-delete',2);
insert into bos_privilege(privilege_id ,privilege_name,privilege_description,privilege_path,privilege_parent_id)values(23,'角色修改','','role-update',2);
insert into bos_privilege(privilege_id ,privilege_name,privilege_description,privilege_path,privilege_parent_id)values(24,'角色查询','','role-find',2);


insert into bos_privilege(privilege_id ,privilege_name,privilege_description,privilege_path,privilege_parent_id)values(3,'权限管理','','',0);
insert into bos_privilege(privilege_id ,privilege_name,privilege_description,privilege_path,privilege_parent_id)values(31,'权限增加','','privilege-add',3);
insert into bos_privilege(privilege_id ,privilege_name,privilege_description,privilege_path,privilege_parent_id)values(32,'权限删除','','privilege-delete',3);
insert into bos_privilege(privilege_id ,privilege_name,privilege_description,privilege_path,privilege_parent_id)values(33,'权限修改','','privilege-update',3);
insert into bos_privilege(privilege_id ,privilege_name,privilege_description,privilege_path,privilege_parent_id)values(34,'权限查询','','privilege-find',3);


insert into bos_privilege(privilege_id ,privilege_name,privilege_description,privilege_path,privilege_parent_id)values(4,'运单管理','','',0);
insert into bos_privilege(privilege_id ,privilege_name,privilege_description,privilege_path,privilege_parent_id)values(41,'运单增加','','waybill-add',4);
insert into bos_privilege(privilege_id ,privilege_name,privilege_description,privilege_path,privilege_parent_id)values(42,'运单删除','','waybill-delete',4);
insert into bos_privilege(privilege_id ,privilege_name,privilege_description,privilege_path,privilege_parent_id)values(43,'运单修改','','waybill-update',4);
insert into bos_privilege(privilege_id ,privilege_name,privilege_description,privilege_path,privilege_parent_id)values(44,'运单查询','','waybill-find',4);


insert into bos_privilege(privilege_id ,privilege_name,privilege_description,privilege_path,privilege_parent_id)values(5,'订单管理','','',0);
insert into bos_privilege(privilege_id ,privilege_name,privilege_description,privilege_path,privilege_parent_id)values(51,'订单增加','','order-add',5);
insert into bos_privilege(privilege_id ,privilege_name,privilege_description,privilege_path,privilege_parent_id)values(52,'订单删除','','order-delete',5);
insert into bos_privilege(privilege_id ,privilege_name,privilege_description,privilege_path,privilege_parent_id)values(53,'订单修改','','order-update',5);
insert into bos_privilege(privilege_id ,privilege_name,privilege_description,privilege_path,privilege_parent_id)values(54,'订单查询','','order-find',5);


insert into bos_privilege(privilege_id ,privilege_name,privilege_description,privilege_path,privilege_parent_id)values(6,'客户管理','','',0);
insert into bos_privilege(privilege_id ,privilege_name,privilege_description,privilege_path,privilege_parent_id)values(61,'客户增加','','customer-add',6);
insert into bos_privilege(privilege_id ,privilege_name,privilege_description,privilege_path,privilege_parent_id)values(62,'客户删除','','customer-delete',6);
insert into bos_privilege(privilege_id ,privilege_name,privilege_description,privilege_path,privilege_parent_id)values(63,'客户修改','','customer-update',6);
insert into bos_privilege(privilege_id ,privilege_name,privilege_description,privilege_path,privilege_parent_id)values(64,'客户查询','','customer-find',6);


insert into bos_privilege(privilege_id ,privilege_name,privilege_description,privilege_path,privilege_parent_id)values(7,'客户联系人管理','','',0);
insert into bos_privilege(privilege_id ,privilege_name,privilege_description,privilege_path,privilege_parent_id)values(71,'客户联系人增加','','linkman-add',7);
insert into bos_privilege(privilege_id ,privilege_name,privilege_description,privilege_path,privilege_parent_id)values(72,'客户联系人删除','','linkman-delete',7);
insert into bos_privilege(privilege_id ,privilege_name,privilege_description,privilege_path,privilege_parent_id)values(73,'客户联系人修改','','linkman-update',7);
insert into bos_privilege(privilege_id ,privilege_name,privilege_description,privilege_path,privilege_parent_id)values(74,'客户联系人查询','','linkman-find',7);


insert into bos_privilege(privilege_id ,privilege_name,privilege_description,privilege_path,privilege_parent_id)values(8,'卡车司机管理','','',0);
insert into bos_privilege(privilege_id ,privilege_name,privilege_description,privilege_path,privilege_parent_id)values(81,'卡车司机增加','','trailerDriver-add',8);
insert into bos_privilege(privilege_id ,privilege_name,privilege_description,privilege_path,privilege_parent_id)values(82,'卡车司机删除','','trailerDriver-delete',8);
insert into bos_privilege(privilege_id ,privilege_name,privilege_description,privilege_path,privilege_parent_id)values(83,'卡车司机修改','','trailerDriver-update',8);
insert into bos_privilege(privilege_id ,privilege_name,privilege_description,privilege_path,privilege_parent_id)values(84,'卡车司机查询','','trailerDriver-find',8);


insert into bos_privilege(privilege_id ,privilege_name,privilege_description,privilege_path,privilege_parent_id)values(9,'短驳司机管理','','',0);
insert into bos_privilege(privilege_id ,privilege_name,privilege_description,privilege_path,privilege_parent_id)values(91,'短驳司机增加','','shortDriver/add',9);
insert into bos_privilege(privilege_id ,privilege_name,privilege_description,privilege_path,privilege_parent_id)values(92,'短驳司机删除','','shortDriver-delete',9);
insert into bos_privilege(privilege_id ,privilege_name,privilege_description,privilege_path,privilege_parent_id)values(93,'短驳司机修改','','shortDriver-update',9);
insert into bos_privilege(privilege_id ,privilege_name,privilege_description,privilege_path,privilege_parent_id)values(94,'短驳司机查询','','shortDriver-find',9);




# 角色表

insert into bos_role(role_id,role_name,role_description)values(0,'系统管理员','拥有所有权限');
insert into bos_role(role_id,role_name,role_description)values(1,'用户管理员','拥有对用户的增删改查');
insert into bos_role(role_id,role_name,role_description)values(2,'角色管理员','拥有对角色的增删改查');
insert into bos_role(role_id,role_name,role_description)values(3,'权限管理员','拥有对权限的增删改查');

insert into bos_role(role_id,role_name,role_description)values(4,'运单管理员','拥有对运单的增删改查');
insert into bos_role(role_id,role_name,role_description)values(5,'订单管理员','拥有对订单的增删改查');
insert into bos_role(role_id,role_name,role_description)values(6,'客户管理员','拥有对客户的增删改查');
insert into bos_role(role_id,role_name,role_description)values(7,'客户联系人管理员','拥有对客户联系人的增删改查');

insert into bos_role(role_id,role_name,role_description)values(8,'卡车司机管理员','拥有对卡车司机的增删改查');
insert into bos_role(role_id,role_name,role_description)values(9,'短驳司机管理员','拥有对短驳司机的增删改查');




# 用户表

# 密码都是123，插入的是BCrypt加密后的
insert into bos_user(user_id,user_name,user_password)values(0,'系统管理员小张','$2a$10$dTsRNg7bmxDAGi0.KBt9eeC8EcYmc/R9TJMrw/244aO8hy435RTvm');

insert into bos_user(user_id,user_name,user_password)values(1,'总经理老郭','$2a$10$dTsRNg7bmxDAGi0.KBt9eeC8EcYmc/R9TJMrw/244aO8hy435RTvm');

insert into bos_user(user_id,user_name,user_password)values(2,'副总经理老钱','$2a$10$dTsRNg7bmxDAGi0.KBt9eeC8EcYmc/R9TJMrw/244aO8hy435RTvm');

insert into bos_user(user_id,user_name,user_password)values(3,'文员小李','$2a$10$dTsRNg7bmxDAGi0.KBt9eeC8EcYmc/R9TJMrw/244aO8hy435RTvm');

insert into bos_user(user_id,user_name,user_password)values(4,'跟单小赵','$2a$10$dTsRNg7bmxDAGi0.KBt9eeC8EcYmc/R9TJMrw/244aO8hy435RTvm');



# 用户角色表

insert into  user_role_ref(user_id,role_id)values(0,0);
insert into  user_role_ref(user_id,role_id)values(1,0);
insert into  user_role_ref(user_id,role_id)values(2,0);
insert into  user_role_ref(user_id,role_id)values(3,4);
insert into  user_role_ref(user_id,role_id)values(3,5);
insert into  user_role_ref(user_id,role_id)values(3,6);
insert into  user_role_ref(user_id,role_id)values(3,7);
insert into  user_role_ref(user_id,role_id)values(3,8);
insert into  user_role_ref(user_id,role_id)values(3,9);

insert into  user_role_ref(user_id,role_id)values(4,4);
insert into  user_role_ref(user_id,role_id)values(4,5);



# 角色权限表

insert into role_privilege_ref(role_id,privilege_id)values('0','0');
insert into role_privilege_ref(role_id,privilege_id)values('1','1');
insert into role_privilege_ref(role_id,privilege_id)values('2','2');
insert into role_privilege_ref(role_id,privilege_id)values('3','3');
insert into role_privilege_ref(role_id,privilege_id)values('4','4');
insert into role_privilege_ref(role_id,privilege_id)values('5','5');
insert into role_privilege_ref(role_id,privilege_id)values('6','6');
insert into role_privilege_ref(role_id,privilege_id)values('7','7');
insert into role_privilege_ref(role_id,privilege_id)values('8','8');
insert into role_privilege_ref(role_id,privilege_id)values('9','9');


