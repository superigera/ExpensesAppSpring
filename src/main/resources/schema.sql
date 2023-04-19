CREATE TABLE IF NOT EXISTS members (
  member_id INT PRIMARY KEY AUTO_INCREMENT,
  lastName VARCHAR(50),
  firstName VARCHAR(50),
  email VARCHAR(50),
  password VARCHAR(50),
  created_at VARCHAR(50),
  update_at VARCHAR(50)
);


CREATE TABLE IF NOT EXISTS categories (
  categoryId INT PRIMARY KEY AUTO_INCREMENT,
  categoryName VARCHAR(50),
  categoryFlag VARCHAR(50)
);


CREATE TABLE IF NOT EXISTS records (
  recordId INT PRIMARY KEY AUTO_INCREMENT,
  dating VARCHAR(50),
  amountOfMoney INT,
  categoryId INT,
  remarks VARCHAR(50),
  created_at VARCHAR(50),
  update_at VARCHAR(50)
);