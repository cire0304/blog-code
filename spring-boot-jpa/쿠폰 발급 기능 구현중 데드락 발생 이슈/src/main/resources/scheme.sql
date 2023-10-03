DROP TABLE IF EXISTS `coupon`, `user_coupon`, `user`;

-- -----------------------------------------------------
-- Table `coupon`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `coupon` (
    `coupon_id` BIGINT NOT NULL AUTO_INCREMENT,
    `quantity` INT NOT NULL,
    `version` BIGINT DEFAULT 1,
    PRIMARY KEY (`coupon_id`))
    ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `user_coupon`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user_coupon` (
    `user_coupon_id` BIGINT NOT NULL AUTO_INCREMENT,
    `coupon_id` BIGINT NOT NULL,
     PRIMARY KEY (`user_coupon_id`),
    INDEX `fk_coupon_id_idx` (`coupon_id` ASC) VISIBLE,
    CONSTRAINT `fk_coupon_coupon`
    FOREIGN KEY (`coupon_id`)
    REFERENCES `coupon` (`coupon_id`))
    ENGINE = InnoDB;
