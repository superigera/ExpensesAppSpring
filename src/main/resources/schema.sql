
CREATE TABLE IF NOT EXISTS members (
  member_id INT PRIMARY KEY AUTO_INCREMENT,
  lastName VARCHAR(50),
  firstName VARCHAR(50),
  email VARCHAR(50),
  password VARCHAR(50)
);