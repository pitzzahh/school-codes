# Task Performance
### Peter John Arao BSIT202-A
___
## Last Activity (Creating tables)
```tsql
USE myDB;

CREATE TABLE Customers
(
    CustomerID INT         NOT NULL PRIMARY KEY,
    FirstName  VARCHAR(50) NOT NULL,
    LastName   VARCHAR(50) NOT NULL,
    Email      VARCHAR(50),
    Gender     CHAR        NOT NULL,
    Birthdate  DATE        NOT NULL
);
CREATE TABLE Vendors
(
    VendorID      INT          NOT NULL PRIMARY KEY,
    Name          VARCHAR(255) NOT NULL,
    ContactNumber VARCHAR(12)  NOT NULL,
    CityAddress   VARCHAR(255) NOT NULL
);
CREATE TABLE Products
(
    ProductID   INT          NOT NULL PRIMARY KEY,
    Description VARCHAR(255) NOT NULL,
    Quantity    INT          NOT NULL,
    Price       DECIMAL      NOT NULL,
    VendorID    INT FOREIGN KEY REFERENCES Vendors(VendorID)
);
```

## Alter the table to match the data to be inserted
```tsql
ALTER TABLE Customers
ALTER
COLUMN CustomerID VARCHAR(10);

ALTER TABLE Vendors
ALTER
COLUMN VendorID VARCHAR(6);

ALTER TABLE Products
ALTER
COLUMN ProductID VARCHAR(7);

ALTER TABLE Products
ALTER
COLUMN VendorID VARCHAR(6);

ALTER TABLE Products
DROP
COLUMN Price;
```

## Inserting values
```tsql
INSERT INTO Customers
VALUES ('2000262262', 'Adrian', 'Embellado', 'embellado.@legazpi.sti.edu.ph', 'M', '2002-3-7');
INSERT INTO Customers
VALUES ('2000267811', 'Ian Carl', 'Azupardo', 'azupardo.267811@legazpi.sti.edu.ph', 'M', '2002-4-6');
INSERT INTO Customers
VALUES ('2000260771', 'Gerard', 'Bongaos', 'bongaos.260771@legazpi.sti.edu.ph', 'M', '2002-5-5');
INSERT INTO Customers
VALUES ('2000266777', 'John Russel', 'Camo', 'camo.266777@legazpi.sti.edu.ph', 'M', '2002-6-4');
INSERT INTO Customers
VALUES ('2000262245', 'Alessandro', 'Benig', 'benig.262245@legazpi.sti.edu.ph', 'M', '2002-7-3');

INSERT INTO Vendors
VALUES ('V00001', 'Universal Robina Corporation', '8633-7631', 'Pasig, MM');
INSERT INTO Vendors
VALUES ('V00002', 'Liwayway Marketing Corporation', '8844-8441', 'Pasay, MM');
INSERT INTO Vendors
VALUES ('V00003', 'Monde Nissin', '7759-7500', 'Makati, MM');

INSERT INTO Products
VALUES ('P000101', 'Jack ''n Jill Piattos', '1000', 'V00001');
INSERT INTO Products
VALUES ('P000102', 'Jack ''n Jill Nova', '1000', 'V00001');
INSERT INTO Products
VALUES ('P001005', 'Oishi Prawn Crackers', '700', 'V00002');
INSERT INTO Products
VALUES ('P030007', 'Nissin Eggnog Cookies', '850', 'V00003');
```
___
### Modifications

#### 1. Create UPDATE statements with += and -= operators to add 274 pieces of Nova and deduct 42 pieces 
```tsql
UPDATE Products SET Quantity += 274 WHERE Description = 'Jack ''n Jill Nova';
UPDATE Products SET Quantity -= 42 WHERE Description = 'Nissin Eggnog Cookies';
```
#### 2. Determine which products have a quantity of less than 1000.
```tsql
SELECT * FROM Products WHERE Quantity < 1000;
```

#### 3. Determine which products have a quantity of less than 1000 then display the product's vendor ID and name.
```tsql
SELECT Vendors.VendorID, Vendors.Name
FROM Products
INNER JOIN Vendors ON Products.VendorID = Vendors.VendorID
WHERE Quantity < 1000;
```
#### 4. Delete one (1) record from the Customers table based on a condition
```tsql
DELETE FROM Customers WHERE CustomerID = '2000262262';
```
