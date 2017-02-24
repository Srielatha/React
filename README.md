This is sample project with CRUD  operation User 

Steps:
- import project by maven in eclipse
- copy company.db file in C:\sqlite2  or place in any location but change path in DbConnection.
- do maven clean
- run with goal as jetty:run or tomcat7:run

Tech:
Spring mvc

DB: Sqlite

UI :  jsp,jquery,javascript, bootstrap, datatables


	create table student_data(
	rowid integer primary key  autoincrement,
	first_name char(50),
	last_name char(50),
	age int );

