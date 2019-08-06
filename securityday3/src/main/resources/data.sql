-- INSERT INTO `users` VALUES ('admin', '$2a$10$vLSbLoHEsnjqlHVe8pv24ec11Qr/Qi.RfY7DiBE/cGfu1sdwbOQ82', '1'), ('user', '$2a$10$vLSbLoHEsnjqlHVe8pv24ec11Qr/Qi.RfY7DiBE/cGfu1sdwbOQ82', '1');
-- INSERT INTO `authorities` VALUES ('admin', 'ROLE_ADMIN'), ('user', 'ROLE_USER');

-- insert into user_info (password, roles, username, uid) values ('$2a$10$vLSbLoHEsnjqlHVe8pv24ec11Qr/Qi.RfY7DiBE/cGfu1sdwbOQ82', 'ROLE_ADMIN', 'admin', '1')
-- insert into user_info (password, roles, username, uid) values ('$2a$10$vLSbLoHEsnjqlHVe8pv24ec11Qr/Qi.RfY7DiBE/cGfu1sdwbOQ82', 'ROLE_USER', 'user', '2')

-- 初始化role
insert into role (name, description,rid) values ('ROLE_ADMIN', '管理员','1')
insert into role (name, description,rid) values ('ROLE_USER', '普通用户','2')

-- 初始化user
insert into user_info (password, username, uid) values ('$2a$10$vLSbLoHEsnjqlHVe8pv24ec11Qr/Qi.RfY7DiBE/cGfu1sdwbOQ82', 'admin', '1')
insert into user_info (password, username, uid) values ('$2a$10$vLSbLoHEsnjqlHVe8pv24ec11Qr/Qi.RfY7DiBE/cGfu1sdwbOQ82', 'user', '2')
insert into user_info (password, username, uid) values ('$2a$10$vLSbLoHEsnjqlHVe8pv24ec11Qr/Qi.RfY7DiBE/cGfu1sdwbOQ82', 'user2', '3')
-- insert into user_info (password, username, uid) values (MD5('1'), 'user2', '3')

-- 给User配置Role
insert into user_role (rid, uid) values ('1','1')
insert into user_role (rid, uid) values ('2','2')
insert into user_role (rid, uid) values ('2','3')

-- 初始化所有接口
insert into permission (pid, url) values ('1','/user')
insert into permission (pid, url) values ('2','/admin')
insert into permission (pid, url) values ('3','/a')
insert into permission (pid, url) values ('4','/b')
insert into permission (pid, url) values ('5','/')

-- 增加默认的权限配置
insert into role_permission(pid, rid) values ('1','1')
insert into role_permission(pid, rid) values ('1','2')
insert into role_permission(pid, rid) values ('2','1')
insert into role_permission(pid, rid) values ('3','1')
insert into role_permission(pid, rid) values ('4','1')
insert into role_permission(pid, rid) values ('5','1')
insert into role_permission(pid, rid) values ('5','2')
