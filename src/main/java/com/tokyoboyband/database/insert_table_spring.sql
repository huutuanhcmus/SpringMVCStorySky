use springmvcbasicfree;

INSERT INTO `springmvcbasicfree`.`category` (`name`, `code`) VALUES ('Ngôn tình', 'ngon-tinh');
INSERT INTO `springmvcbasicfree`.`category` (`name`, `code`) VALUES ('Trinh thám', 'trinh-tham');

INSERT INTO `springmvcbasicfree`.`story` (`category_id`, `name`, `introduce`, `image`, `createdby`) VALUES ('3', 'CÔ DÂU TRĂM TỶ, TỔNG TÀI ĐẠI NHÂN XIN DỊU DÀNG', 'CÔ DÂU TRĂM TỶ, TỔNG TÀI ĐẠI NHÂN XIN DỊU DÀNG', 'https://goctruyen.com/public/frontend/images/codautramtytongtaidainhanxindiudangxjfS1tJYk7.jpg', 'user1');
INSERT INTO `springmvcbasicfree`.`story` (`category_id`, `name`, `introduce`, `image`, `createdby`) VALUES ('3', 'TỔNG GIÁM ĐỐC TÀ ÁC YÊU THƯƠNG VỢ', 'TỔNG GIÁM ĐỐC TÀ ÁC YÊU THƯƠNG VỢ', 'https://goctruyen.com/public/frontend/images/tonggiamdoctaacyeuthuongvo1v9nGHzbEh.jpg', 'user1');
INSERT INTO `springmvcbasicfree`.`story` (`category_id`, `name`, `introduce`, `image`, `createdby`) VALUES ('4', 'ĐÔNG PHƯƠNG THẦN THÁM', 'ĐÔNG PHƯƠNG THẦN THÁM', 'https://static.8cache.com/cover/o/eJzLyTDV13X39Eyv8LZ0LDOL1A8LDvAOMg0xMizz1HeEgtwwE_1ECyOjFD_d0vxCR_1yI0NT3QxjIyMANz4RkQ==/dong-phuong-than-tham-180620.jpg', 'user2');

INSERT INTO `springmvcbasicfree`.`collectionstory` (`story_id`, `name`, `content`, `createdby`) VALUES ('25', 'Tập 1', 'Nội dung 1', 'user1');
INSERT INTO `springmvcbasicfree`.`collectionstory` (`story_id`, `name`, `content`, `createdby`) VALUES ('25', 'Tập 2', 'Nội dung 2', 'user1');
INSERT INTO `springmvcbasicfree`.`collectionstory` (`story_id`, `name`, `content`, `createdby`) VALUES ('26', 'Tập 1', 'Nội dung 1', 'user1');
INSERT INTO `springmvcbasicfree`.`collectionstory` (`story_id`, `name`, `content`, `createdby`) VALUES ('26', 'Tập 2', 'Nội dung 2', 'user1');
INSERT INTO `springmvcbasicfree`.`collectionstory` (`story_id`, `name`, `content`, `createdby`) VALUES ('27', 'Tập 1', 'Nội dung 1', 'user2');
INSERT INTO `springmvcbasicfree`.`collectionstory` (`story_id`, `name`, `content`, `createdby`) VALUES ('27', 'Tập 2', 'Nội dung 2', 'user2');

INSERT INTO `springmvcbasicfree`.`role` (`name`, `code`) VALUES ('Khách hàng', 'user');
INSERT INTO `springmvcbasicfree`.`role` (`name`, `code`) VALUES ('Quản lý', 'admin');

INSERT INTO `springmvcbasicfree`.`user` (`username`, `password`, `fullname`, `status`, `role_id`) VALUES ('user1', '123456', 'Người dùng 1', '1', '3');
INSERT INTO `springmvcbasicfree`.`user` (`username`, `password`, `fullname`, `status`, `role_id`) VALUES ('user2', '123456', 'Người dùng 2', '1', '3');