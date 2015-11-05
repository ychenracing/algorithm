package leetcode.CombineTwoTables;

/**
 * 
 * <pre>
 * Table: Person
 * 
 * +-------------+---------+
 * | Column Name | Type    |
 * +-------------+---------+
 * | PersonId    | int     |
 * | FirstName   | varchar |
 * | LastName    | varchar |
 * +-------------+---------+
 * PersonId is the primary key column for this table.
 * Table: Address
 * 
 * +-------------+---------+
 * | Column Name | Type    |
 * +-------------+---------+
 * | AddressId   | int     |
 * | PersonId    | int     |
 * | City        | varchar |
 * | State       | varchar |
 * +-------------+---------+
 * AddressId is the primary key column for this table.
 * 
 * Write a SQL query for a report that provides the following information for each person in the Person table, regardless if there is an address for each of those people:
 * 
 * FirstName, LastName, City, State
 * </pre>
 * 
 * 
 * @author racing
 * @version $Id: Solution.java, v 0.1 Oct 21, 2015 8:55:24 AM racing Exp $
 */
public class Solution {

    public static void main(String[] args) {
        /**
         * 思路一：
         * 使用最常见的select+where语句，也即内连接的形式。将符合Person.PersonId=Address.PersonId条件的，
         * 存在于两个表的四个字段FirstName, LastName, City, State的记录，形成连接。
         * 
         * select FirstName, LastName, City, State
         * from Person, Address
         * where Person.PersonId = Address.PersonId
         * 
         * 问题：
         * 当Address表为空时，Address表中没有匹配的记录，这样会出现连接错误。
         * 
         */

        /**
         * 思路二：
         * 通过外连接发方式实现。外联结：分为外左联结和外右联结。
         * 对于左表（右表）中没有匹配的记录时，右表（左表）中没有匹配的记录将被设置为null。
         * 
         * select Person.FirstName, Person.LastName, Address.City, Address.State
         * from Person 
         * left join Address
         * on Person.PersonId = Address.PersonId
         * 
         * 
         */
    }

}
