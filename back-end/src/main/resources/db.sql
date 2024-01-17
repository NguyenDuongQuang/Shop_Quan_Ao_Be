

create database duantotnghiep;




DROP TABLE IF EXISTS `annual_report`;

CREATE TABLE `annual_report` (
                                 `id` bigint NOT NULL AUTO_INCREMENT,
                                 `customer_count` bigint NOT NULL,
                                 `month` int NOT NULL,
                                 `order_count` bigint NOT NULL,
                                 `product_count` bigint NOT NULL,
                                 `revenue` double NOT NULL,
                                 `year` int NOT NULL,
                                 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `annual_report` WRITE;

INSERT INTO `annual_report` VALUES (38,3,5,3,2,8902000,2023);

UNLOCK TABLES;

DROP TABLE IF EXISTS `brand`;

CREATE TABLE `brand` (
                         `id` int NOT NULL AUTO_INCREMENT,
                         `created_at` datetime(6) DEFAULT NULL,
                         `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
                         `status` int NOT NULL,
                         `updated_at` datetime(6) DEFAULT NULL,
                         `updated_by` varchar(30) DEFAULT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `brand` WRITE;

INSERT INTO `brand` VALUES (1,'2023-05-13 23:25:02.246000','Gucci',1,'2023-05-13 23:25:02.246000','phongvu'),(2,'2023-05-15 16:30:42.134000','Adidas',1,'2023-05-15 16:30:42.134000','phongvu'),(3,'2023-05-15 16:30:47.452000','Nike',1,'2023-05-15 16:30:47.452000','phongvu'),(4,'2023-05-15 16:30:56.819000','Jordan',1,'2023-05-15 16:30:56.819000','phongvu'),(5,'2023-05-15 16:31:01.067000','Puma',1,'2023-05-15 16:31:01.067000','phongvu'),(6,'2023-05-15 16:31:10.114000','Biti\'s',1,'2023-05-15 16:31:10.114000','phongvu');

UNLOCK TABLES;


DROP TABLE IF EXISTS `cart_general`;

CREATE TABLE `cart_general` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `registered_user` bit(1) NOT NULL,
  `user_auth_token` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_7redl3811svkuao0ufjk6vrwo` (`user_auth_token`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `cart_general` WRITE;

INSERT INTO `cart_general` VALUES (1,_binary '\0','7e313faf-5967-4fef-8a09-02e3378cdd99'),(3,_binary '\0','1'),(23,_binary '\0','6da1632a-79e6-4d8b-bd23-a75c19d2e344'),(26,_binary '','3'),(27,_binary '\0','87334438-0fe4-4dee-a1b4-cdf4d11ad911'),(31,_binary '\0','4');

UNLOCK TABLES;


DROP TABLE IF EXISTS `cart_product`;

CREATE TABLE `cart_product` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `quantity` int NOT NULL,
  `cart_id` bigint NOT NULL,
  `product_detail_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5lxxduutmrn4emypo082n58wv` (`cart_id`),
  KEY `FKtv5ljclt4nwbhsgvqjhn5n3o` (`product_detail_id`),
  CONSTRAINT `FK5lxxduutmrn4emypo082n58wv` FOREIGN KEY (`cart_id`) REFERENCES `cart_general` (`id`),
  CONSTRAINT `FKtv5ljclt4nwbhsgvqjhn5n3o` FOREIGN KEY (`product_detail_id`) REFERENCES `product_detail` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `cart_product` WRITE;

INSERT INTO `cart_product` VALUES (1,1,1,1),(3,1,3,2),(5,1,23,1),(6,1,3,1),(13,1,26,12),(19,1,31,12);

UNLOCK TABLES;


DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `status` int NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` varchar(30) DEFAULT NULL,
  `product_set_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlgteo393i39sxgbtay3pi7hr8` (`product_set_id`),
  CONSTRAINT `FKlgteo393i39sxgbtay3pi7hr8` FOREIGN KEY (`product_set_id`) REFERENCES `product_set` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `category` WRITE;

INSERT INTO `category` VALUES (1,'2023-05-13 23:25:19.976000','Giày Sneaker',1,'2023-05-13 23:25:19.976000','phongvu',1),(2,'2023-05-15 16:30:14.940000','Giày trẻ em thấp cổ',1,'2023-05-22 22:52:35.173000','phongvu',2),(3,'2023-05-15 16:30:27.431000','Giày trẻ em cao cổ',1,'2023-05-22 22:52:45.678000','phongvu',2);

UNLOCK TABLES;

DROP TABLE IF EXISTS `color`;

CREATE TABLE `color` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `image` varchar(1000) DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `color` WRITE;

INSERT INTO `color` VALUES (1,'2023-05-13 23:26:15.268000','black',NULL,'Màu đen','2023-05-13 23:26:15.268000','phongvu'),(2,'2023-05-13 23:26:25.556000','red\n',NULL,'Màu đỏ','2023-05-13 23:26:25.556000','phongvu'),(3,'2023-05-15 16:32:47.406000','pink',NULL,'Màu hồng','2023-05-15 16:32:47.406000','phongvu'),(4,'2023-05-15 21:48:02.289000','gray',NULL,'Màu xám','2023-05-15 21:48:02.289000','phongvu'),(5,'2023-05-22 08:53:29.920000','blue',NULL,'Màu xanh nước biển','2023-05-22 08:53:48.288000','phongvu'),(6,'2023-05-23 05:13:23.890000','white',NULL,'Màu trắng','2023-05-23 05:13:23.890000','phongvu');

UNLOCK TABLES;


DROP TABLE IF EXISTS `combo`;

CREATE TABLE `combo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `origin_price` double NOT NULL,
  `sale_percentage` double NOT NULL,
  `sale_price` double NOT NULL,
  `combo_set_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK871i899b2vkodx6ihjatl8092` (`combo_set_id`),
  CONSTRAINT `FK871i899b2vkodx6ihjatl8092` FOREIGN KEY (`combo_set_id`) REFERENCES `combo_set` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `combo` WRITE;

UNLOCK TABLES;


DROP TABLE IF EXISTS `combo_detail`;

CREATE TABLE `combo_detail` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `color_id` int NOT NULL,
  `combo_id` int NOT NULL,
  `product_detail_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKf21i1gqlwa9kjmdk5bsdp2c5s` (`color_id`),
  KEY `FKs943yxk1fctp436ptss9kn5sl` (`combo_id`),
  KEY `FK9ex070wgdr3xctioy9bv2wfc8` (`product_detail_id`),
  CONSTRAINT `FK9ex070wgdr3xctioy9bv2wfc8` FOREIGN KEY (`product_detail_id`) REFERENCES `product_detail` (`id`),
  CONSTRAINT `FKf21i1gqlwa9kjmdk5bsdp2c5s` FOREIGN KEY (`color_id`) REFERENCES `color` (`id`),
  CONSTRAINT `FKs943yxk1fctp436ptss9kn5sl` FOREIGN KEY (`combo_id`) REFERENCES `combo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `combo_detail` WRITE;

UNLOCK TABLES;


DROP TABLE IF EXISTS `combo_image`;

CREATE TABLE `combo_image` (
  `id` int NOT NULL AUTO_INCREMENT,
  `image` varchar(1000) DEFAULT NULL,
  `combo_detail_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6arv3t5vdo7yhuikguysrxyng` (`combo_detail_id`),
  CONSTRAINT `FK6arv3t5vdo7yhuikguysrxyng` FOREIGN KEY (`combo_detail_id`) REFERENCES `combo_detail` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `combo_image` WRITE;

UNLOCK TABLES;



DROP TABLE IF EXISTS `combo_set`;

CREATE TABLE `combo_set` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `available` int NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `description` varchar(3000) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `gender` int NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `status` int NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `combo_set` WRITE;

UNLOCK TABLES;


DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `birth_day` date DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `gender` int DEFAULT NULL,
  `height` float DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `status` int NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` varchar(30) DEFAULT NULL,
  `weight` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_dwk6cx0afu8bs9o4t536v1j5v` (`email`),
  UNIQUE KEY `UK_o3uty20c6csmx5y4uk2tc5r4m` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,NULL,'2023-05-13 23:29:44.700000','rumblethanthanh@gmail.com',0,0,'Hiếu','115694425133595714506','0987524631',0,'2023-05-23 08:02:37.576000','phongvu',0),(2,NULL,'2023-05-14 21:54:24.295000','hieuvdph09214@fpt.edu.vn',0,0,'Vu','110301359491210104479',NULL,1,'2023-05-14 21:54:24.295000',NULL,0),(3,NULL,'2023-05-22 23:02:01.964000','vuhieu3108@gmail.com',0,0,'Hiếu','116169170084369659145',NULL,1,'2023-05-22 23:02:01.964000',NULL,0),(4,NULL,'2023-05-23 10:00:55.411000','dungna@gmail.com',0,0,'dungna','123','0868981002',1,'2023-05-23 10:00:55.411000',NULL,0);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;


DROP TABLE IF EXISTS `customer_growth_report`;

CREATE TABLE `customer_growth_report` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `count` bigint DEFAULT NULL,
  `month` int DEFAULT NULL,
  `year` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `customer_growth_report` WRITE;

UNLOCK TABLES;


DROP TABLE IF EXISTS `customer_info`;

CREATE TABLE `customer_info` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(1000) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `district` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `is_default` bit(1) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `province` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `ward` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `customer_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKq6agoreh1q6wffd7mql6vk95o` (`customer_id`),
  CONSTRAINT `FKq6agoreh1q6wffd7mql6vk95o` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `customer_info` WRITE;

UNLOCK TABLES;


DROP TABLE IF EXISTS `customer_voucher_record`;

CREATE TABLE `customer_voucher_record` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `customer_voucher_record` WRITE;

INSERT INTO `customer_voucher_record` VALUES (1,'147852','dungna@gmail.com');

UNLOCK TABLES;


DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `birth_day` date DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `gender` int NOT NULL,
  `identity_card` varchar(20) DEFAULT NULL,
  `image` varchar(1000) DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `note` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `role` int NOT NULL,
  `status` int NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` varchar(30) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_fopic1oh5oln2khj8eat6ino0` (`email`),
  UNIQUE KEY `UK_8eqtlsgfje7mlnlya7h5q2j27` (`identity_card`),
  UNIQUE KEY `UK_buf2qp04xpwfp5qq355706h4a` (`phone`),
  UNIQUE KEY `UK_im8flsuftl52etbhgnr62d6wh` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `employee` WRITE;

INSERT INTO `employee` VALUES (1,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,'$2y$10$5hgtYiJ5HRyRebvKv5XBbu4DM9XF2YosLu2Qawq698kYJ/cPJOGcy',NULL,1,1,NULL,NULL,'phongvu'),(2,'1998-08-31','2023-05-14 21:11:46.807000','vuhieu3108@gmail.com',1,'170863297',NULL,'Vũ Nhật Phong','Nhân viên','$2a$10$rJj73VjqhPUJeEhMxhBVDeyL3lYNLJMvOtp5h2Gy82pMlAG7exzy2','0947512368',0,1,'2023-05-14 21:11:46.774000','phongvu','vunhatphong'),(3,'2000-01-01','2023-05-14 21:49:39.531000','vinhnv32@gmail.com',1,'0657895745268',NULL,'Nguyễn Văn Vinh','Đã nghỉ làm','$2a$10$lfjKo/O6ca1r8LTyA.kuJ.6aBHF/PXHpE15uGaIM/VBm3qGO0e9z.','0978546328',0,0,'2023-05-14 21:49:39.497000','phongvu','vinhnguyen'),(4,'2020-01-01','2023-05-15 15:29:05.226000','test1@gmail.com',0,'014523698752',NULL,'testnv1','test nhan vien','$2a$10$uUDpvAFPkLrUKqCLC7nHzO/FDJmTVzyxoawlaV6H0EXHl8ijNPQa6','0987245682',0,1,'2023-05-15 15:29:05.181000','phongvu','Nguyễn Văn H'),(5,'2023-05-02','2023-05-22 23:38:11.074000','hungdtph16943@fpt.edu.vn',1,'123578956245',NULL,'Đỗ Tiến Hưng',NULL,'$2a$10$BIdSjhG1w7kZ4B2vWD.I3OHwnbdyqyoKKU280sPbSTX9/4UPcCcY6','0986322478',0,1,'2023-05-22 23:38:11.070000','phongvu','hungdo');

UNLOCK TABLES;

DROP TABLE IF EXISTS `made_in`;

CREATE TABLE `made_in` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `made_in` WRITE;

INSERT INTO `made_in` VALUES (1,'2023-05-13 23:25:28.291000','VIệt Nam','2023-05-13 23:25:28.291000','phongvu'),(2,'2023-05-15 21:17:15.027000','Mỹ','2023-05-15 21:17:15.027000','phongvu'),(3,'2023-05-15 21:17:26.290000','Anh Quốc','2023-05-15 21:17:26.290000','phongvu'),(4,'2023-05-15 21:17:33.513000','Pháp','2023-05-15 21:17:33.513000','phongvu'),(5,'2023-05-22 22:48:02.397000','Italia','2023-05-22 22:48:02.397000','phongvu');

UNLOCK TABLES;

DROP TABLE IF EXISTS `order_detail`;

CREATE TABLE `order_detail` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `image` varchar(1000) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `listed_price` double NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `quantity` int NOT NULL,
  `sub_price` double NOT NULL,
  `variant` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `order_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrws2q0si6oyd6il8gqe2aennc` (`order_id`),
  CONSTRAINT `FKrws2q0si6oyd6il8gqe2aennc` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `order_detail` WRITE;

INSERT INTO `order_detail` VALUES (1,'http://res.cloudinary.com/dipuod7ic/image/upload/v1683995247/s06qmipdexfxrqedzuxp.jpg',300000,'Giày Sneaker Gucci',2,600000,'Màu đen | 40',1),(2,'http://res.cloudinary.com/dipuod7ic/image/upload/v1683995247/s06qmipdexfxrqedzuxp.jpg',300000,'Giày Sneaker Gucci',1,300000,'Màu đen | 40',2),(3,'http://res.cloudinary.com/dipuod7ic/image/upload/v1684162556/gyococrpcwmgmcqmdrtr.webp',210000,'Giày Thể Thao Trẻ Em Biti\'s Hunter Junior',1,210000,'Màu hồng | 26',3),(4,'http://res.cloudinary.com/dipuod7ic/image/upload/v1684161882/sfjhgo2jtih8pegy0jyx.jpg',500000,'Giày Jordan 1',1,500000,'Màu đen | 41',3),(5,'http://res.cloudinary.com/dipuod7ic/image/upload/v1684771010/byrmwk9lvdwgad96o2ob.jpg',2500000,'Giày Sneakers Nam Gucci',1,2500000,'Màu đen | 41',4),(6,'http://res.cloudinary.com/dipuod7ic/image/upload/v1684771010/byrmwk9lvdwgad96o2ob.jpg',2500000,'Giày Sneakers Nam Gucci',2,5000000,'Màu đen | 40',4),(7,'http://res.cloudinary.com/dipuod7ic/image/upload/v1684162556/gyococrpcwmgmcqmdrtr.webp',210000,'Giày Thể Thao Trẻ Em Biti\'s Hunter Junior',2,420000,'Màu đen | 41',4),(8,'http://res.cloudinary.com/dipuod7ic/image/upload/v1684771010/byrmwk9lvdwgad96o2ob.jpg',4500000,'Giày Sneakers Nam Gucci',2,9000000,'Màu đen | 40',5),(9,'http://res.cloudinary.com/dipuod7ic/image/upload/v1684771010/byrmwk9lvdwgad96o2ob.jpg',4500000,'Giày Sneakers Nam Gucci',2,9000000,'Màu đen | 41',5),(10,'http://res.cloudinary.com/dipuod7ic/image/upload/v1684793959/tkgssrwtykxyubhgvdxz.webp',500000,'Giày Jordan Max Aura 4',1,500000,'Màu đen | 40',11),(11,'http://res.cloudinary.com/dipuod7ic/image/upload/v1684771010/byrmwk9lvdwgad96o2ob.jpg',4500000,'Giày Sneakers Nam Gucci',1,4500000,'Màu đen | 40',13);

UNLOCK TABLES;


DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(1000) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `confirmed_at` datetime(6) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `district` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `note` varchar(1000) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `payment_status` bit(1) DEFAULT NULL,
  `payment_type` int NOT NULL,
  `phone` varchar(255) NOT NULL,
  `province` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `ship_cost` double NOT NULL,
  `ship_type` int NOT NULL,
  `status` int NOT NULL,
  `total_payment` double NOT NULL,
  `total_price` double NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `voucher` double NOT NULL,
  `ward` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `orders` WRITE;

INSERT INTO `orders` VALUES (1,'ha noi, Phường Hưng Trí, Thị xã Kỳ Anh, Hà Tĩnh','2023-05-13 23:31:12.772000','2023-05-13 23:30:14.219000','Thị xã Kỳ Anh','rumblethanthanh@gmail.com','phong vu','',_binary '',1,'0349913365','Hà Tĩnh',30000,1,4,630000,600000,'2023-05-13 23:31:12.772000','phongvu',0,'Phường Hưng Trí'),(2,'Số 10 đường Kim Văn, Phường Cổ Nhuế 1, Quận Bắc Từ Liêm, Hà Nội','2023-05-19 00:58:34.924000','2023-05-14 21:47:10.916000','Quận Bắc Từ Liêm','hungnv0123@gmail.com','Nguyễn Văn Hùng','Giao hàng thứ 7 chủ nhật',_binary '',1,'0985246317','Hà Nội',22000,1,4,322000,300000,'2023-05-19 00:58:34.924000','phongvu',0,'Phường Cổ Nhuế 1'),(3,'Số 11 đường Thanh Xuân, Thị trấn Sóc Sơn, Huyện Sóc Sơn, Hà Nội',NULL,'2023-05-22 09:14:06.560000','Huyện Sóc Sơn','phongvu01@gmail.com','Phong Vũ','Giao trong các ngày thứ 7 và chủ nhật',_binary '\0',1,'0987542367','Hà Nội',22000,1,0,732000,710000,'2023-05-22 09:14:06.560000',NULL,0,'Thị trấn Sóc Sơn'),(4,'Số 9 đường Huế, Thị Trấn Si Ma Cai, Huyện Si Ma Cai, Lào Cai','2023-05-22 23:14:01.405000','2023-05-22 23:11:30.297000','Huyện Si Ma Cai','vuhieu3108@gmail.com','Phong Vũ','Trong giờ hành chính',_binary '',1,'0987546279','Lào Cai',30000,1,4,7950000,7920000,'2023-05-22 23:14:01.405000','phongvu',0,'Thị Trấn Si Ma Cai'),(5,'Số 11 đường Thanh Xuân, Xã Vân Tảo, Huyện Thường Tín, Hà Nội','2023-05-23 09:53:06.375000','2023-05-23 09:47:14.020000','Huyện Thường Tín','0802hungdo@gmail.com','dungna','',_binary '\0',1,'0868981002','Hà Nội',22000,1,3,18022000,18000000,'2023-05-23 09:53:06.375000','phongvu',0,'Xã Vân Tảo'),(11,'Số 11 đường Thanh Xuân, Xã Trưng Trắc, Huyện Văn Lâm, Hưng Yên',NULL,'2023-05-23 10:02:40.612000','Huyện Văn Lâm','dungna@gmail.com','Phong Vũ','',_binary '\0',1,'0987541236','Hưng Yên',30000,1,0,530000,500000,'2023-05-23 10:02:40.612000',NULL,0,'Xã Trưng Trắc'),(13,'Số 11 đường Thanh Xuân, Xã Phú Nghĩa, Huyện Lạc Thủy, Hòa Bình',NULL,'2023-05-23 10:03:47.332000','Huyện Lạc Thủy','dungna@gmail.com','Phong Vũ','',_binary '\0',1,'0987541236','Hòa Bình',30000,1,0,4330000,4500000,'2023-05-23 10:03:47.332000',NULL,200000,'Xã Phú Nghĩa');

UNLOCK TABLES;

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `available` int NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `description` varchar(3000) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `gender` int NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `status` int NOT NULL,
  `total_amount` int NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` varchar(30) DEFAULT NULL,
  `brand_id` int NOT NULL,
  `category_id` int NOT NULL,
  `made_in_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKs6cydsualtsrprvlf2bb3lcam` (`brand_id`),
  KEY `FK1mtsbur82frn64de7balymq9s` (`category_id`),
  KEY `FK7nire2fiv9yqh1ucn9jy7edo3` (`made_in_id`),
  CONSTRAINT `FK1mtsbur82frn64de7balymq9s` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `FK7nire2fiv9yqh1ucn9jy7edo3` FOREIGN KEY (`made_in_id`) REFERENCES `made_in` (`id`),
  CONSTRAINT `FKs6cydsualtsrprvlf2bb3lcam` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `product` WRITE;

INSERT INTO `product` VALUES (1,1,'2023-05-13 23:28:01.259000','Giày Thể Thao Trẻ Em Biti\'s được làm bằng chất liệu cao cấp, mềm mại, an toàn cho sức khỏe và làn da của trẻ, giúp trẻ tha hồ chạy nhảy suốt cả ngày.\n\nSản phẩm được thiết kế dạng giày thể thao năng động giúp bé dễ dàng mang vào và không bị tuột trong quá trình chơi đùa, mũi giày bo tròn ôm gọn chân, thoải mái di chuyển cả ngày.\n\nGiày được thiết kế bền chắc với quai dệt mềm mại, dễ dàng thao tác mà không cần sự hỗ trợ của bố mẹ, bé có thể chủ động nới rộng hoặc thu nhỏ lại để vừa vặn với chân của mình.',0,'Giày Thể Thao Trẻ Em Biti\'s Hunter Junior',1,1095,'2023-05-22 22:56:22.790000','phongvu',6,2,1),(2,1,'2023-05-15 21:45:25.135000','Giày auth đẹp chất',1,'Giày Jordan Max Aura 4',1,149,'2023-05-23 05:19:24.129000','phongvu',4,1,2),(3,1,'2023-05-15 21:49:02.891000','Giày auth giá sốc',0,'Giày Air Force 1',1,500,'2023-05-23 05:16:40.221000','phongvu',3,1,3),(4,1,'2023-05-22 22:59:39.135000','Giày dành cho nam giới',1,'Giày Sneakers Nam Gucci',1,441,'2023-05-23 08:13:19.698000','phongvu',1,1,5);

UNLOCK TABLES;



DROP TABLE IF EXISTS `product_detail`;

CREATE TABLE `product_detail` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `avail_amount` int NOT NULL,
  `origin_price` double NOT NULL,
  `promotion_percentage` double NOT NULL,
  `promotion_price` double NOT NULL,
  `status` int NOT NULL,
  `color_id` int NOT NULL,
  `product_id` bigint NOT NULL,
  `size_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK99vj2np1gk1robp8n6htiweii` (`color_id`),
  KEY `FKilxoi77ctyin6jn9robktb16c` (`product_id`),
  KEY `FKcum8u2vfvebmmc4xo8de3k35s` (`size_id`),
  CONSTRAINT `FK99vj2np1gk1robp8n6htiweii` FOREIGN KEY (`color_id`) REFERENCES `color` (`id`),
  CONSTRAINT `FKcum8u2vfvebmmc4xo8de3k35s` FOREIGN KEY (`size_id`) REFERENCES `size` (`id`),
  CONSTRAINT `FKilxoi77ctyin6jn9robktb16c` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `product_detail` WRITE;

INSERT INTO `product_detail` VALUES (1,97,300000,30,210000,1,1,1,1),(2,198,300000,30,210000,1,1,1,2),(3,99,1000000,50,500000,1,1,2,1),(4,50,1000000,50,500000,1,1,2,2),(5,150,1500000,50,750000,1,4,3,1),(6,100,300000,30,210000,1,1,1,3),(7,200,300000,30,210000,1,1,1,4),(8,100,500000,30,350000,1,5,1,5),(9,100,300000,30,210000,1,1,1,5),(10,100,300000,30,210000,1,3,1,3),(11,200,300000,30,210000,1,3,1,4),(12,95,5000000,10,4500000,1,1,4,1),(13,97,5000000,10,4500000,1,1,4,2),(14,150,100000,10,90000,1,2,4,2),(15,99,100000,10,90000,1,2,4,1),(16,150,1500000,50,750000,1,6,3,1),(17,200,1500000,50,750000,1,6,3,2);

UNLOCK TABLES;


DROP TABLE IF EXISTS `product_image`;

CREATE TABLE `product_image` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `image` varchar(1000) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `color_id` int NOT NULL,
  `product_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqcabopu2ex77fymxr9rhxb5uj` (`color_id`),
  KEY `FK6oo0cvcdtb6qmwsga468uuukk` (`product_id`),
  CONSTRAINT `FK6oo0cvcdtb6qmwsga468uuukk` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `FKqcabopu2ex77fymxr9rhxb5uj` FOREIGN KEY (`color_id`) REFERENCES `color` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `product_image` WRITE;

INSERT INTO `product_image` VALUES (15,'http://res.cloudinary.com/dipuod7ic/image/upload/v1684162556/gyococrpcwmgmcqmdrtr.webp',1,1),(23,'http://res.cloudinary.com/dipuod7ic/image/upload/v1684720603/doa3dqlm8zvtiwqalqqy.jpg',5,1),(24,'http://res.cloudinary.com/dipuod7ic/image/upload/v1684720975/kk71k0dwefa8jbvmxziq.webp',3,1),(32,'http://res.cloudinary.com/dipuod7ic/image/upload/v1684793790/hawjvzl7vxr9vwccbycv.webp',4,3),(33,'http://res.cloudinary.com/dipuod7ic/image/upload/v1684793670/ygw4nyanjkdxe4ydnxt7.webp',6,3),(34,'http://res.cloudinary.com/dipuod7ic/image/upload/v1684793959/tkgssrwtykxyubhgvdxz.webp',1,2),(35,'http://res.cloudinary.com/dipuod7ic/image/upload/v1684771010/byrmwk9lvdwgad96o2ob.jpg',1,4),(36,'http://res.cloudinary.com/dipuod7ic/image/upload/v1684771016/vcjr5mgdmdpipbytzsjb.jpg',1,4),(37,'http://res.cloudinary.com/dipuod7ic/image/upload/v1684771118/r8iof5lichvr8at9slb9.jpg',2,4),(38,'http://res.cloudinary.com/dipuod7ic/image/upload/v1684804395/kxyolynkx0oz3soe5w4f.jpg',2,4);

UNLOCK TABLES;

DROP TABLE IF EXISTS `product_set`;

CREATE TABLE `product_set` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `status` int NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `product_set` WRITE;

INSERT INTO `product_set` VALUES (1,'2023-05-13 23:24:52.289000','Giày thể thao',1,'2023-05-13 23:24:52.289000','phongvu'),(2,'2023-05-15 16:29:24.576000','Giày trẻ em',1,'2023-05-15 16:29:24.576000','phongvu'),(3,'2023-05-15 16:29:38.546000','Giày nam',1,'2023-05-15 16:29:38.546000','phongvu'),(4,'2023-05-15 16:29:47.275000','Giày nữ',1,'2023-05-22 22:51:23.171000','phongvu'),(5,'2023-05-22 22:49:50.796000','Giày thời trang',1,'2023-05-22 22:49:50.796000','phongvu');

UNLOCK TABLES;


DROP TABLE IF EXISTS `promotion_category`;

CREATE TABLE `promotion_category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `description` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `percentage` float NOT NULL,
  `status` bit(1) NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` varchar(30) DEFAULT NULL,
  `category_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKifob7v9b53tll9sw212do1c4y` (`category_id`),
  CONSTRAINT `FKifob7v9b53tll9sw212do1c4y` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `promotion_category` WRITE;

INSERT INTO `promotion_category` VALUES (1,'2023-05-15 22:12:30.822000','Xả kho chào hàng mới','Ưu đãi giày sneaker',50,_binary '','2023-05-15 22:12:30.822000','phongvu',1),(2,'2023-05-15 22:13:12.102000','Deal sốc săn ngay','Giảm giá sốc giày cho bé trai',30,_binary '\0','2023-05-15 22:13:12.102000','phongvu',3),(3,'2023-05-15 22:13:51.167000','Giá cực hời cho các công chúa nhỏ đón năm học mới','Giảm giá sốc cho bé gái',60,_binary '\0','2023-05-15 22:13:51.167000','phongvu',2),(4,'2023-05-22 23:17:47.768000','Ưu đãi sốc','Ưu đãi hè',10,_binary '','2023-05-22 23:17:47.768000','phongvu',2);

UNLOCK TABLES;


DROP TABLE IF EXISTS `promotion_product`;

CREATE TABLE `promotion_product` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `percentage` float NOT NULL,
  `status` bit(1) NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` varchar(30) DEFAULT NULL,
  `product_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK43h73x8pdqrk8ea8h8w16ulve` (`product_id`),
  CONSTRAINT `FK43h73x8pdqrk8ea8h8w16ulve` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `promotion_product` WRITE;

INSERT INTO `promotion_product` VALUES (1,'2023-05-15 21:53:32.091000','Khuyến mại từ 01/06 đến 31/08','Khuyến mại chào hè',10,_binary '\0','2023-05-15 21:53:32.091000','phongvu',2),(2,'2023-05-15 21:54:28.919000','Noel mua 2 tặng 1 lời thêm 1 ny','Khuyến mãi dịp Noel',50,_binary '','2023-05-15 21:54:28.919000','phongvu',3),(3,'2023-05-15 21:55:13.674000','Chào đón tết âm xả giày','Khuyến mãi Tết âm lịch',50,_binary '\0','2023-05-15 21:55:13.674000','phongvu',1),(4,'2023-05-15 21:57:15.751000','Xả kho cuối năm tết Âm','Khuyến mãi Tết âm',30,_binary '','2023-05-15 21:57:15.751000','phongvu',1),(5,'2023-05-22 23:20:46.450000','Ưu đãi sốc','Khuyến mãi giày Gucci',10,_binary '','2023-05-22 23:20:46.450000','phongvu',4);

UNLOCK TABLES;


DROP TABLE IF EXISTS `size`;

CREATE TABLE `size` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `size` WRITE;

INSERT INTO `size` VALUES (1,'2023-05-13 23:25:39.304000',NULL,'40','2023-05-13 23:25:39.304000','phongvu'),(2,'2023-05-13 23:25:44.154000',NULL,'41','2023-05-13 23:25:44.154000','phongvu'),(3,'2023-05-22 08:55:17.358000',NULL,'25','2023-05-22 08:55:17.358000','phongvu'),(4,'2023-05-22 08:55:24.058000',NULL,'26','2023-05-22 08:55:24.058000','phongvu'),(5,'2023-05-22 08:55:31.204000',NULL,'27','2023-05-22 08:55:31.204000','phongvu');

UNLOCK TABLES;

DROP TABLE IF EXISTS `stats_product`;

CREATE TABLE `stats_product` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `listed_price` double NOT NULL,
  `quantity` int NOT NULL,
  `sub_price` double NOT NULL,
  `order_detail_id` bigint NOT NULL,
  `product_detail_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKq9u83uj7jara6bs3b4ckmut7y` (`order_detail_id`),
  KEY `FKosqxo69qf804k0tuh4tab8e8n` (`product_detail_id`),
  CONSTRAINT `FKosqxo69qf804k0tuh4tab8e8n` FOREIGN KEY (`product_detail_id`) REFERENCES `product_detail` (`id`),
  CONSTRAINT `FKq9u83uj7jara6bs3b4ckmut7y` FOREIGN KEY (`order_detail_id`) REFERENCES `order_detail` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `stats_product` WRITE;

INSERT INTO `stats_product` VALUES (1,'2023-05-13 23:30:14.244000',300000,2,600000,1,1),(2,'2023-05-14 21:47:10.948000',300000,1,300000,2,1),(3,'2023-05-22 09:14:06.604000',210000,1,210000,3,11),(4,'2023-05-22 09:14:06.623000',500000,1,500000,4,4),(5,'2023-05-22 23:11:30.326000',2500000,1,2500000,5,13),(6,'2023-05-22 23:11:30.337000',2500000,2,5000000,6,12),(7,'2023-05-22 23:11:30.343000',210000,2,420000,7,2),(8,'2023-05-23 09:47:14.038000',4500000,2,9000000,8,12),(9,'2023-05-23 09:47:14.055000',4500000,2,9000000,9,13),(10,'2023-05-23 10:02:40.631000',500000,1,500000,10,3),(11,'2023-05-23 10:03:47.376000',4500000,1,4500000,11,12);

UNLOCK TABLES;


DROP TABLE IF EXISTS `top_sales_customer`;

CREATE TABLE `top_sales_customer` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `month` int NOT NULL,
  `total_payment` double DEFAULT NULL,
  `year` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `top_sales_customer` WRITE;

UNLOCK TABLES;


DROP TABLE IF EXISTS `top_sales_product`;

CREATE TABLE `top_sales_product` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `month` int NOT NULL,
  `product_id` bigint DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `total_payment` double DEFAULT NULL,
  `total_sales` bigint DEFAULT NULL,
  `year` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `top_sales_product` WRITE;

UNLOCK TABLES;

DROP TABLE IF EXISTS `voucher`;

CREATE TABLE `voucher` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `active` int NOT NULL,
  `code` varchar(255) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `money` double NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `note` varchar(1000) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `slot` int NOT NULL,
  `start_date` date DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `customer_id` bigint DEFAULT NULL,
  `order_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK54x7dllq1ts557joc0cunvyk9` (`customer_id`),
  KEY `FK26e2de0akwygxlr9al8du1uef` (`order_id`),
  CONSTRAINT `FK26e2de0akwygxlr9al8du1uef` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
  CONSTRAINT `FK54x7dllq1ts557joc0cunvyk9` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `voucher` WRITE;

INSERT INTO `voucher` VALUES (1,1,'1234578','2023-05-19 00:40:36.065000','2023-05-20',100000,'Giảm giá giày Biti\'s',NULL,10,'2023-05-18','2023-05-19 22:11:15.460000','phongvu',2,NULL),(2,1,'147852','2023-05-19 22:12:48.720000','2023-05-24',200000,'Khuyến mãi hè 2023',NULL,49,'2023-05-19','2023-05-19 22:12:48.720000','phongvu',NULL,13),(3,1,'123','2023-05-22 23:27:36.791000','2023-05-23',100000,'Khuyến mãi hè',NULL,10,'2023-05-16','2023-05-22 23:27:36.791000','phongvu',NULL,NULL),(4,1,'123','2023-05-23 09:57:43.417000','2023-05-31',200000,'dungna',NULL,10,'2023-05-01','2023-05-23 09:57:43.417000','phongvu',NULL,NULL);

UNLOCK TABLES;

