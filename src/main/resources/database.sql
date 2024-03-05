CREATE DATABASE `dopplerdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
-- dopplerdb.customer definition

CREATE TABLE `customer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Id_customer` int NOT NULL,
  `name` varchar(100) NOT NULL,
  `address` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phone` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- dopplerdb.order_status definition

CREATE TABLE `order_status` (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_status_name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- dopplerdb.product_type definition

CREATE TABLE `product_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `product_type_desc` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- dopplerdb.service_status definition

CREATE TABLE `service_status` (
  `id` int NOT NULL AUTO_INCREMENT,
  `service_status_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- dopplerdb.service definition

CREATE TABLE `service` (
  `id` int NOT NULL AUTO_INCREMENT,
  `service_name` varchar(100) NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- dopplerdb.`order` definition

CREATE TABLE `order` (
  `id` int NOT NULL AUTO_INCREMENT,
  `customer_id` int NOT NULL,
  `order_status_id` int NOT NULL,
  `date` date NOT NULL,
  `total` decimal(10,2) NOT NULL,
  `tax` decimal(10,2) DEFAULT NULL,
  `discount` decimal(10,2) DEFAULT NULL,
  `requires_installation` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `order_customer_FK` (`customer_id`),
  KEY `order_order_status_FK` (`order_status_id`),
  CONSTRAINT `order_customer_FK` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `order_order_status_FK` FOREIGN KEY (`order_status_id`) REFERENCES `order_status` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- dopplerdb.product definition

CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `product_type_id` int NOT NULL,
  `product_name` varchar(100) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `quantity` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `products_product_type_FK` (`product_type_id`),
  CONSTRAINT `products_product_type_FK` FOREIGN KEY (`product_type_id`) REFERENCES `product_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- dopplerdb.service_order_detail definition

CREATE TABLE `service_order_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_id` int NOT NULL,
  `service_id` int NOT NULL,
  `subtotal` double NOT NULL,
  `service_status` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `service_order_detail_services_FK` (`service_id`),
  KEY `service_order_detail_order_FK` (`order_id`),
  KEY `service_order_detail_service_status_FK` (`service_status`),
  CONSTRAINT `service_order_detail_order_FK` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`),
  CONSTRAINT `service_order_detail_service_status_FK` FOREIGN KEY (`service_status`) REFERENCES `service_status` (`id`),
  CONSTRAINT `service_order_detail_services_FK` FOREIGN KEY (`service_id`) REFERENCES `service` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- dopplerdb.product_order_detail definition

CREATE TABLE `product_order_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `product_id` int NOT NULL,
  `order_id` int NOT NULL,
  `quantity` int NOT NULL,
  `subtotal` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `product_order_detail_order_FK` (`order_id`),
  KEY `product_order_detail_products_FK` (`product_id`),
  CONSTRAINT `product_order_detail_order_FK` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`),
  CONSTRAINT `product_order_detail_products_FK` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;