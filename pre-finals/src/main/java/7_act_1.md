### Write SQL statements that will perform the following. (5 items x 5 points)

#### 1. Select all the unique values from the Album column in the Artists table.
```sql
SELECT DISTINCT Album FROM Artists;
```
#### 2. From the Regions table, select all rows where the Province column has the value 'Rizal'.
```sql
SELECT * FROM Regions WHERE Province = 'Rizal';
```
#### 3. Select all records from the Artists table and sort the result reversed alphabetically by the column Album.
```sql
SELECT * FROM Artists ORDER BY Album DESC;
```
#### 4. In the Regions table, set the values of the Municipality column to 'Cainta', but only the ones where the Province column has the value 'Rizal'.
```sql
UPDATE Regions SET Municipality = 'Cainta' WHERE Province = 'Rizal';
```
#### 5. From the Regions table, select all records where the value of the Province column starts with 'L' and ends with 'a'.
```sql
SELECT * FROM Regions WHERE Province LIKE 'L%a';
```