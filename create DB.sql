CREATE SCHEMA `orders` DEFAULT CHARACTER SET utf8mb4 ;

CREATE TABLE `orders`.`buyer_tbl` (
  `buyer_id` BIGINT NOT NULL AUTO_INCREMENT,
  `name_fld` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`buyer_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE `orders`.`product_tbl` (
  `product_id` BIGINT NOT NULL AUTO_INCREMENT,
  `title_fld` VARCHAR(255) NOT NULL,
  `price_fld` INT NULL,
  PRIMARY KEY (`product_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE `orders`.`order_tbl` (
  `order_id` BIGINT NOT NULL AUTO_INCREMENT,
  `buyer_id` BIGINT NOT NULL,
  `product_id` BIGINT NOT NULL,
  PRIMARY KEY (`order_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

ALTER TABLE `orders`.`order_tbl` 
ADD COLUMN `price_fld` INT NULL AFTER `product_id`;

ALTER TABLE `orders`.`order_tbl` 
ADD INDEX `order_tbl_buyer_id_idx` (`buyer_id` ASC) VISIBLE,
ADD INDEX `order_tbl_product_id_idx` (`product_id` ASC) VISIBLE;
;
ALTER TABLE `orders`.`order_tbl` 
ADD CONSTRAINT `order_tbl_buyer_id`
  FOREIGN KEY (`buyer_id`)
  REFERENCES `orders`.`buyer_tbl` (`buyer_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `order_tbl_product_id`
  FOREIGN KEY (`product_id`)
  REFERENCES `orders`.`product_tbl` (`product_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

INSERT INTO `orders`.`buyer_tbl` (`name_fld`) VALUES ('Sasha');
INSERT INTO `orders`.`buyer_tbl` (`name_fld`) VALUES ('Pasha');
INSERT INTO `orders`.`buyer_tbl` (`name_fld`) VALUES ('Petya');

INSERT INTO `orders`.`product_tbl` (`title_fld`, `price_fld`) VALUES ('shouse', '200');
INSERT INTO `orders`.`product_tbl` (`title_fld`, `price_fld`) VALUES ('dress', '300');
INSERT INTO `orders`.`product_tbl` (`title_fld`, `price_fld`) VALUES ('hat', '50');
INSERT INTO `orders`.`product_tbl` (`title_fld`, `price_fld`) VALUES ('shirt', '120');

INSERT INTO `orders`.`order_tbl` (`buyer_id`, `product_id`) VALUES ('1', '2');
INSERT INTO `orders`.`order_tbl` (`buyer_id`, `product_id`) VALUES ('1', '3');
INSERT INTO `orders`.`order_tbl` (`buyer_id`, `product_id`) VALUES ('2', '3');
INSERT INTO `orders`.`order_tbl` (`buyer_id`, `product_id`) VALUES ('2', '2');
INSERT INTO `orders`.`order_tbl` (`buyer_id`, `product_id`) VALUES ('1', '2');
INSERT INTO `orders`.`order_tbl` (`buyer_id`, `product_id`) VALUES ('3', '1');
INSERT INTO `orders`.`order_tbl` (`buyer_id`, `product_id`) VALUES ('2', '4');

UPDATE `orders`.`order_tbl` SET `price_fld` = '300' WHERE (`order_id` = '1');
UPDATE `orders`.`order_tbl` SET `price_fld` = '300' WHERE (`order_id` = '4');
UPDATE `orders`.`order_tbl` SET `price_fld` = '300' WHERE (`order_id` = '5');
UPDATE `orders`.`order_tbl` SET `price_fld` = '200' WHERE (`order_id` = '6');
UPDATE `orders`.`order_tbl` SET `price_fld` = '50' WHERE (`order_id` = '2');
UPDATE `orders`.`order_tbl` SET `price_fld` = '50' WHERE (`order_id` = '3');
UPDATE `orders`.`order_tbl` SET `price_fld` = '120' WHERE (`order_id` = '7');

