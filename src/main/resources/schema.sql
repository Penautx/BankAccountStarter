CREATE TABLE IF NOT EXISTS ApplicationUser (
applicationuserid INT PRIMARY KEY AUTO_INCREMENT,
password VARCHAR(60) NOT NULL,
username VARCHAR(35) NOT NULL,
accountprofileid INT);

CREATE TABLE IF NOT EXISTS Payment (
paymentid INT PRIMARY KEY AUTO_INCREMENT,
amount DECIMAL(65, 10) NOT NULL,
currency VARCHAR(3) NOT NULL,
createDatetime TIMESTAMP NOT NULL,
accountProfileNumber VARCHAR(30) NOT NULL,
accountprofileid INT);

CREATE TABLE IF NOT EXISTS AccountProfile (
accountprofileid INT PRIMARY KEY AUTO_INCREMENT,
accountProfileNumber VARCHAR(30) NOT NULL,
balance DECIMAL (65, 10) NOT NULL,
currency VARCHAR(3) NOT NULL,
optlock INTEGER DEFAULT 0);

CREATE TABLE IF NOT EXISTS AccountBalanceChange (
accountbalancechangeid INT PRIMARY KEY AUTO_INCREMENT,
amount DECIMAL(65, 10) NOT NULL,
isDeposit BOOLEAN NOT NULL,
createDatetime TIMESTAMP NOT NULL,
accountProfileid INT);

ALTER TABLE ApplicationUser
ADD CONSTRAINT FK_AccountProfile_ApplicationUser FOREIGN KEY (accountprofileid)
REFERENCES AccountProfile (accountprofileid);


ALTER TABLE Payment
ADD CONSTRAINT FK_AccountProfile_Payment FOREIGN KEY (accountProfileid)
REFERENCES AccountProfile (accountProfileid);

ALTER TABLE AccountBalanceChange
ADD CONSTRAINT FK_AccountProfile_AccountBalanceChange FOREIGN KEY (accountprofileid)
REFERENCES AccountProfile (accountprofileid);

CREATE TABLE IF NOT EXISTS ApplicationUserRole (
roleid INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(30) NOT NULL);

CREATE TABLE IF NOT EXISTS ApplicationUser_Roles (
roles_roleid INT,
users_applicationuserid INT);

ALTER TABLE ApplicationUser_Roles
ADD CONSTRAINT FK_ApplicationRole FOREIGN KEY (roles_roleid)
REFERENCES applicationuserrole (roleid);

ALTER TABLE ApplicationUser_Roles
ADD CONSTRAINT FK_ApplicationUser FOREIGN KEY (users_applicationuserid)
REFERENCES applicationUser (applicationuserid);

SET REFERENTIAL_INTEGRITY FALSE