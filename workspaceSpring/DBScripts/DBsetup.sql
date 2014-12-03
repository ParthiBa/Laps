/* to reintailise your DB uncomment the below line */
/*drop database LAPSDB;*/
/* after creating check for the values in some tables*/
/*if it says somekind of error please exetute that part of the code alone*/
create database LAPSDB;

use LAPSDB;


/*1*/
CREATE TABLE LeaveType
(
    LeaveTypeID    varchar(255),
    LeaveTypeName  varchar(255),
    PRIMARY KEY (LeaveTypeID)
);

INSERT INTO LeaveType VALUES ("MED", "Medical Leave");
INSERT INTO LeaveType VALUES ("AN", "Annual Leave");
INSERT INTO LeaveType VALUES ("COMP", "Compensation Leave");

/*2*/
CREATE TABLE employeeroles
(
    RoleID varchar(255),
    Roletype varchar(255),
    PRIMARY KEY (RoleID)
);

INSERT INTO employeeroles VALUES ("A", "Administrators");
INSERT INTO employeeroles VALUES ("M", "Managers");
INSERT INTO employeeroles VALUES ("E", "Employees");


/*3
Drop table employees
*/
CREATE TABLE employees
(
    EmployeeID     varchar(255),
    Employeename   varchar(255),
    DOB            DATE,
    RoleID         varchar(255),
	Password       varchar(255),
    SupervisorID   varchar(255),
    PRIMARY KEY (EmployeeID),
    FOREIGN KEY (RoleID) REFERENCES employeeroles(RoleID)
);

INSERT INTO employees 
  VALUES ("E01","Zhang Guo", '1992-02-27', "E","E01", "E02");
INSERT INTO employees 
  VALUES ("E02","James Blunt", '1987-06-23', "M","E02", "");
INSERT INTO employees 
  VALUES ("E03","Emma Watson", '1990-04-15', "A","E03", "");
INSERT INTO employees
  VALUES ("E04","White", '1976-06-23', "E","E04", "E02");
INSERT INTO employees 
  VALUES ("E05","Katty Perry", '1987-05-03', "M","E05", "");
INSERT INTO employees 
  VALUES ("E06","Tom Soffiya", '1981-04-13', "E","E06", "E05");


create view user as
select  EmployeeID as username,Password
from employees



/*A for Administrators
  M for Managers
  E for Employees*/


/*4*/
CREATE TABLE TypeOfLeave
(
    RoleID         varchar(255),
    LeaveTypeID    varchar(255),
    NumofDays      INT,
    ApprovelRoleid varchar(255),
    PRIMARY KEY (RoleID, LeaveTypeID),
    FOREIGN KEY (LeaveTypeID) REFERENCES LeaveType(LeaveTypeID)
);

INSERT INTO TypeOfLeave VALUES ("E","MED", 60,"M");
INSERT INTO TypeOfLeave VALUES ("E","AN", 18,"M");
INSERT INTO TypeOfLeave VALUES ("A","AN", 14,"");
INSERT INTO TypeOfLeave VALUES ("A","MED", 60,"");
INSERT INTO TypeOfLeave VALUES ("M","AN", 18,"");
INSERT INTO TypeOfLeave VALUES ("M","MED", 60,"");

create view Rolehierarchy as 
select RoleID,ApprovelRoleid as superiorID
from TypeOfLeave




create table leaveDetails 
(
EmployeeID   varchar(255),
RoleID  varchar(255),
LeaveTypeID  varchar(255),
FromDate date,
ToDate date,
NumberOfDays float8(3,1),
leaveStatus varchar(255),
workDissemination varchar(255),
ContactDetails  varchar(255),
primary key (EmployeeID,FromDate),
FOREIGN key (EmployeeID) references Employees(EmployeeID),
FOREIGN KEY (RoleID) references EmployeeRoles(RoleID),
Foreign key(LeaveTypeID) references LeaveType(LeaveTypeID)
)



/*drop table leaveDetails; */

insert into leaveDetails values ("E01","E","AN",'2014-06-22','2014-06-22',1,"APPROVED","E02","");

insert into leaveDetails values ("E02","M","MED",'2014-06-27','2014-06-29',2,"DELETED","E05","");


insert into leaveDetails values ("E05","M","COMP",'2014-07-27','2014-07-29',2,"APPLIED","E02","");

insert into leaveDetails values ("E03","A","MED",'2014-07-30','2014-07-30',0.5,"REJECTED","E02","");

insert into leaveDetails values ("E06","E","AN",'2014-12-30','2014-12-30',1,"APPLIED","E04","");


create table Holidays
(
HolidayName varchar(255),
startDate date,
endDate date,
primary key (Holidayname)
)

insert into Holidays values ("New_Year",'2014-01-01','2014-01-01' );
insert into Holidays values("Chinese_New_Year",'2014-01-31','2014-02-01');
insert into Holidays values("Hari_Raya_Puasa",'2014-06-28','2014-06-28');
insert into Holidays values("Deepavali",'2014-10-22','2014-10-22');

/*select * from holidays */
/* drop table otDetails */
create table OTDetails
(
EmployeeID varchar(255),
OTWorkedDate date,
IsFullDay boolean,
ISApproved boolean, /* to prove that the staff has worked overtime only to values approved{true} / rejected {false}*/ 
primary key(EmployeeID,OTWorkedDate),
foreign key (EmployeeID) references Employees(EmployeeID)

)

INSERT INTO `lapsdb`.`otdetails`
(`EmployeeID`,
`OTWorkedDate`,
`IsFullDay`,
`ISApproved`)
VALUES
("E01",
'2014-12-2',
true,true);



insert into OTDetails values ("E03",'2014-12-4',false,false)