DROP DATABASE IF EXISTS db_ssm;
CREATE DATABASE db_ssm;

DROP TABLE IF EXISTS db_ssm.museum;
CREATE TABLE db_ssm.museum (
  id INT AUTO_INCREMENT PRIMARY KEY
  COMMENT 'PK',
  name VARCHAR(255) NOT NULL COMMENT '名称',
  logo VARCHAR(255) COMMENT '标志',
  picture VARCHAR(255) COMMENT '图片',
  address VARCHAR(255) NOT NULL COMMENT '地址'
)
  COMMENT '博物馆表';

DROP TABLE IF EXISTS db_ssm.work;
CREATE TABLE db_ssm.work (
  id INT AUTO_INCREMENT PRIMARY KEY
  COMMENT 'PK',
  title VARCHAR(255) NOT NULL COMMENT '',
  picture VARCHAR(255) COMMENT '图片',
  artist VARCHAR(255) NOT NULL COMMENT '作者',
  year INT(255) NOT NULL COMMENT '年份',
  museumId INT COMMENT 'FK'
)
  COMMENT '作品表';

ALTER TABLE db_ssm.work
    ADD CONSTRAINT
work_fk_museumId
FOREIGN KEY (museumId)
  REFERENCES db_ssm.museum(id);

SELECT *
FROM db_ssm.museum;

SELECT *
FROM db_ssm.work;

