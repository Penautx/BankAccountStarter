DELETE FROM AccountBalanceChange;
DELETE FROM AccountProfile;
DELETE FROM ApplicationUser;
DELETE FROM Payment;



INSERT INTO ApplicationUser (username, password, accountprofileid) VALUES
('Mateusz', '1234', 1);
INSERT INTO ApplicationUser (username, password, accountprofileid) VALUES
('Krzysztof', '1234', 1);
INSERT INTO ApplicationUser (username, password, accountprofileid) VALUES
('Marek', '1234', 1);

INSERT INTO AccountProfile (accountProfileNumber, balance, currency) VALUES
('1234', 12.34, 'EUR');
INSERT INTO AccountProfile (accountProfileNumber, balance, currency) VALUES
('1342', 214124.312, 'USD');
INSERT INTO AccountProfile (accountProfileNumber, balance, currency) VALUES
('1521', 0, 'PLN');

INSERT INTO AccountBalanceChange (amount, isDeposit, createDatetime, accountprofileid) VALUES
('200', false, '2022-01-11 15:25:30', 1);
INSERT INTO AccountBalanceChange (amount, isDeposit, createDatetime, accountprofileid) VALUES
('200', true, '2022-01-11 15:25:30', 2);
INSERT INTO AccountBalanceChange (amount, isDeposit, createDatetime, accountprofileid) VALUES
('300', true, '2022-01-12 15:25:33', 3);

INSERT INTO Payment (amount, currency, createDatetime, accountProfileNumber, accountprofileid ) VALUES
('123.12', 'EUR', '2022-01-11 15:25:30', '1342', 1);
INSERT INTO Payment (amount, currency, createDatetime, accountProfileNumber, accountprofileid ) VALUES
('200.12', 'PLN', '2020-01-11 15:25:30', '1234', 2);
INSERT INTO Payment (amount, currency, createDatetime, accountProfileNumber, accountprofileid ) VALUES
('200.12', 'USD', '2021-10-11 16:25:30', '1234', 3);

SET REFERENTIAL_INTEGRITY TRUE