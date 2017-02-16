-- MySQL Script generated by MySQL Workbench
-- 02/15/17 17:50:33
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema voteservice
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema voteservice
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `voteservice` DEFAULT CHARACTER SET utf8 ;
USE `voteservice` ;

-- -----------------------------------------------------
-- Table `voteservice`.`vote`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `voteservice`.`vote` (
  `id` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NULL,
  `first_option` VARCHAR(45) NULL,
  `second_option` VARCHAR(45) NULL,
  `is_open` VARCHAR(10) NULL,
  `link` VARCHAR(100) NULL,
  `first_counter` INT NULL,
  `second_counter` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
