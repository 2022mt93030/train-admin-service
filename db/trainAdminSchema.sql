-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema trainadmindb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema trainadmindb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `trainadmindb` DEFAULT CHARACTER SET utf8 ;
USE `trainadmindb` ;

-- -----------------------------------------------------
-- Table `trainadmindb`.`route`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `trainadmindb`.`route` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `trainadmindb`.`station`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `trainadmindb`.`station` (
  `code` VARCHAR(3) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `trainadmindb`.`route_station`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `trainadmindb`.`route_station` (
  `route_id` INT NOT NULL,
  `station_code` VARCHAR(3) NOT NULL,
  `sequence_no` INT NOT NULL,
  PRIMARY KEY (`route_id`, `station_code`),
  INDEX `fk_station_code_idx` (`station_code` ASC) VISIBLE,
  CONSTRAINT `fk_route_num`
    FOREIGN KEY (`route_id`)
    REFERENCES `trainadmindb`.`route` (`id`),
  CONSTRAINT `fk_station_code`
    FOREIGN KEY (`station_code`)
    REFERENCES `trainadmindb`.`station` (`code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `trainadmindb`.`train`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `trainadmindb`.`train` (
  `id` BIGINT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `frequency` VARCHAR(45) NOT NULL,
  `route_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_route_idx` (`route_id` ASC) VISIBLE,
  CONSTRAINT `fk_route_number`
    FOREIGN KEY (`route_id`)
    REFERENCES `trainadmindb`.`route` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `trainadmindb`.`train_capacity`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `trainadmindb`.`train_capacity` (
  `train_num` BIGINT NOT NULL,
  `travel_class` VARCHAR(45) NOT NULL,
  `total_seats` INT NOT NULL,
  `travel_date` DATE NULL,
  PRIMARY KEY (`train_num`, `travel_class`),
  CONSTRAINT `fk_train_num`
    FOREIGN KEY (`train_num`)
    REFERENCES `trainadmindb`.`train` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `trainadmindb`.`train_station`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `trainadmindb`.`train_station` (
  `station_stop` VARCHAR(3) NOT NULL,
  `train_num` BIGINT(8) NOT NULL,
  `route_no` INT NOT NULL,
  PRIMARY KEY (`station_stop`, `train_num`, `route_no`),
  INDEX `fk_route_no_idx` (`route_no` ASC) VISIBLE,
  INDEX `fk_train_no_idx` (`train_num` ASC) VISIBLE,
  CONSTRAINT `fk_train_number`
    FOREIGN KEY (`train_num`)
    REFERENCES `trainadmindb`.`train` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_station_no`
    FOREIGN KEY (`station_stop`)
    REFERENCES `trainadmindb`.`route_station` (`station_code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_route_no`
    FOREIGN KEY (`route_no`)
    REFERENCES `trainadmindb`.`route_station` (`route_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
