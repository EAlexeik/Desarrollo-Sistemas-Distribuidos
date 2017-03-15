-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema practica1_dsd
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema practica1_dsd
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `practica1_dsd` DEFAULT CHARACTER SET utf8 ;
USE `practica1_dsd` ;

-- -----------------------------------------------------
-- Table `practica1_dsd`.`alumno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `practica1_dsd`.`alumno` (
  `idAlumno` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL DEFAULT NULL,
  `paterno` VARCHAR(45) NULL DEFAULT NULL,
  `materno` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `calle` VARCHAR(45) NULL DEFAULT NULL,
  `numero` VARCHAR(45) NULL DEFAULT NULL,
  `colonia` VARCHAR(45) NULL DEFAULT NULL,
  `delegacion` VARCHAR(45) NULL DEFAULT NULL,
  `entidad` VARCHAR(45) NULL DEFAULT NULL,
  `telefono` VARCHAR(10) NULL DEFAULT NULL,
  PRIMARY KEY (`idAlumno`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `practica1_dsd`.`curso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `practica1_dsd`.`curso` (
  `idCurso` INT(11) NOT NULL AUTO_INCREMENT,
  `nombreC` VARCHAR(45) NULL DEFAULT NULL,
  `fechaInicio` DATETIME NULL DEFAULT NULL,
  `fechaTermino` DATETIME NULL DEFAULT NULL,
  `cuotaDeRecuperacion` DECIMAL(10,2) NULL DEFAULT NULL,
  PRIMARY KEY (`idCurso`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `practica1_dsd`.`asignacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `practica1_dsd`.`asignacion` (
  `idAlumno` INT(11) NOT NULL,
  `idCurso` INT(11) NOT NULL,
  `horario` VARCHAR(45) NULL DEFAULT NULL,
  `tipoCurso` INT(11) NULL DEFAULT NULL,
  INDEX `idAlumno_idx` (`idAlumno` ASC),
  INDEX `idCurso_idx` (`idCurso` ASC),
  PRIMARY KEY (`idAlumno`, `idCurso`),
  CONSTRAINT `idAlumno`
    FOREIGN KEY (`idAlumno`)
    REFERENCES `practica1_dsd`.`alumno` (`idAlumno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idCurso`
    FOREIGN KEY (`idCurso`)
    REFERENCES `practica1_dsd`.`curso` (`idCurso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
