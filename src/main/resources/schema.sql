
DROP TABLE IF EXISTS users;

CREATE TABLE IF NOT EXISTS users (
  id CHAR(10) PRIMARY KEY,
  username VARCHAR(64) UNIQUE NOT NULL,
  password STRING NOT NULL,
  firstname VARCHAR(64) NOT NULL,
  lastname VARCHAR(64) NOT NULL,
  address VARCHAR(64),
  birthday DATE address VARCHAR(64),

 );

CREATE INDEX IF NOT EXISTS idx_users_tid ON users (id);
CREATE INDEX IF NOT EXISTS idx_users_username ON users (username);