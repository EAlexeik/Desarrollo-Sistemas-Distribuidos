-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema Cursos
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `Cursos` ;

-- -----------------------------------------------------
-- Schema Cursos
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Cursos` DEFAULT CHARACTER SET utf8 ;
USE `Cursos` ;

-- -----------------------------------------------------
-- Table `Cursos`.`Alumno`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Cursos`.`Alumno` ;

CREATE TABLE IF NOT EXISTS `Cursos`.`Alumno` (
  `idAlumno` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `paterno` VARCHAR(45) NULL,
  `materno` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `calle` VARCHAR(45) NULL,
  `numero` VARCHAR(45) NULL,
  `colonia` VARCHAR(45) NULL,
  `delegacion` VARCHAR(45) NULL,
  `entidad` VARCHAR(45) NULL,
  `NoTelefono` VARCHAR(10) NULL,
  PRIMARY KEY (`idAlumno`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Cursos`.`Curso`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Cursos`.`Curso` ;

CREATE TABLE IF NOT EXISTS `Cursos`.`Curso` (
  `idCurso` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `fechaInicio` DATETIME NULL,
  `fechaTermino` DATETIME NULL,
  `cuotaDeRecuperacion` DECIMAL(10,2) NULL,
  PRIMARY KEY (`idCurso`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Cursos`.`Asignacion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Cursos`.`Asignacion` ;

CREATE TABLE IF NOT EXISTS `Cursos`.`Asignacion` (
  `Curso_idCurso` INT NOT NULL,
  `Alumno_idAlumno` INT NOT NULL,
  `horario` VARCHAR(45) NULL,
  `tipoCurso` INT NULL,
  PRIMARY KEY (`Curso_idCurso`, `Alumno_idAlumno`),
  INDEX `fk_Asignacion_Curso_idx` (`Curso_idCurso` ASC),
  INDEX `fk_Asignacion_Alumno1_idx` (`Alumno_idAlumno` ASC),
  CONSTRAINT `fk_Asignacion_Curso`
    FOREIGN KEY (`Curso_idCurso`)
    REFERENCES `Cursos`.`Curso` (`idCurso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Asignacion_Alumno1`
    FOREIGN KEY (`Alumno_idAlumno`)
    REFERENCES `Cursos`.`Alumno` (`idAlumno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
