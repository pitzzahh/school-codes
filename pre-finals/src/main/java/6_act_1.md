### 1. Create table Flavors
#### Columns
- ItemCode (int)
- ItemDesc (varchar)
- Price (Float)
```sql
CREATE TABLE Flavors (
    ItemCode int,
    ItemDesc varchar(255),
    Price float
);
```
### 2. Set ItemCode as Primary Key
```sql
ALTER TABLE Flavors
ADD PRIMARY KEY (ItemCode);
```

### 3. Add CHECK Constraint to Price column to ensure that the lowest price is 65.
```sql
ALTER TABLE Flavors
ADD CONSTRAINT chk_Price CHECK (Price >= 65);
```

### 4. Delete the ItemDesc column
```sql
ALTER TABLE Flavors
DROP COLUMN ItemDesc;
```
