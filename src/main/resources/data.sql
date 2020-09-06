--DROP TABLE IF EXISTS collateral;

--CREATE TABLE collateral (
--  id INT AUTO_INCREMENT  PRIMARY KEY,
--  collateral_type VARCHAR(250) NOT NULL,
--  valuation_status VARCHAR(250) DEFAULT NULL
--);

INSERT INTO collateral (id,collateral_type, created_date, last_updated_date) VALUES
  (1,'residential', now(), now()),
  (2,'rural',now(), now());