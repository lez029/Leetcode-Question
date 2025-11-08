"""176. Second Highest Salary
#/Table: Employee

+-------------+------+
| Column Name | Type |
+-------------+------+
| id          | int  |
| salary      | int  |
+-------------+------+
id is the primary key (column with unique values) for this table.
Each row of this table contains information about the salary of an employee.
 

Write a solution to find the second highest distinct salary from the Employee table. If there is no second highest salary, return null (return None in Pandas).

The result format is in the following example.

Example 1:

Input: 
Employee table:
+----+--------+
| id | salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+
Output: 
+---------------------+
| SecondHighestSalary |
+---------------------+
| 200                 |
+---------------------+
Example 2:

Input: 
Employee table:
+----+--------+
| id | salary |
+----+--------+
| 1  | 100    |
+----+--------+
Output: 
+---------------------+
| SecondHighestSalary |
+---------------------+
| null                |
+---------------------+
"""
#First Solution
import pandas as pd

def second_highest_salary_1(employee: pd.DataFrame) -> pd.DataFrame:
    unique_salary = employee['salary'].drop_duplicates().sort_values(ascending = False)
    return (pd.DataFrame({'SecondHighestSalary':[unique_salary.iloc[1]]}) if len(unique_salary) >= 2 else   
    pd.DataFrame({'SecondHighestSalary':[None]}))
#This one is based on the method .drop_duplicates

#Second Solution
def second_highest_salary_2(employee: pd.DataFrame) -> pd.DataFrame:
    unique_salary = employee.groupby('salary').mean().sort_values('salary',ascending=False)
    return (pd.DataFrame({'SecondHighestSalary':[unique_salary.index[1]]}) if unique_salary.shape[0] >= 2 else pd.DataFrame({'SecondHighestSalary':[None]}))
#This one is based on the method .groupby to group duplicates into a single row and sort the values. 
#The complexity is less because it doesn't need to drop items in the DataFrame, it only calculates the mean
