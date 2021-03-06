SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

DROP DATABASE IF EXISTS  madang;
DROP USER IF EXISTS  madang@localhost;
create user madang@localhost identified WITH mysql_native_password  by 'madang';
create database madang;
grant all privileges on madang.* to madang@localhost with grant option;
commit;

USE `madang`;





CREATE TABLE Doctors (
	doc_id			INTEGER NOT NULL,
    major_treat		VARCHAR(25) NOT NULL,
    doc_name		VARCHAR(20) NOT NULL,
    doc_gen			char(1)	NOT NULL,
    doc_phone		VARCHAR(15) NULL,
	doc_email		VARCHAR(50) UNIQUE,
    doc_position	VARCHAR(20) NOT NULL
);
ALTER TABLE Doctors
	ADD CONSTRAINT doc_id_pk PRIMARY KEY (doc_id);
    
    

CREATE TABLE Nurses (
	nur_id			INTEGER NOT NULL,
    major_job		VARCHAR(25) NOT NULL,
    nur_name		VARCHAR(20) NOT NULL,
    nur_gen			char(1)	NOT NULL,
    nur_phone		VARCHAR(15) NULL,
	nur_email		VARCHAR(50) UNIQUE,
    nur_position	VARCHAR(20) NOT NULL
);
ALTER TABLE Nurses
	ADD CONSTRAINT nur_id_pk PRIMARY KEY (nur_id);




CREATE TABLE Patients (
	pat_id			INTEGER NOT NULL,
    nur_id			INTEGER NOT NULL,
    doc_id			INTEGER NOT NULL,
    pat_name		VARCHAR(20) NOT NULL,
    pat_gen			char(1)	NOT NULL,
    pat_jumin		VARCHAR(14) NOT NULL,
	pat_addr		VARCHAR(100) NOT NULL,
    pat_phone		VARCHAR(15) NULL,
	pat_email		VARCHAR(50) UNIQUE,
    pat_job			VARCHAR(20) NOT NULL
);
ALTER TABLE Patients
	ADD CONSTRAINT pat_id_pk PRIMARY KEY (pat_id);
ALTER TABLE Patients
	ADD (CONSTRAINT R_2 FOREIGN KEY (doc_id) REFERENCES Doctors (doc_id));
ALTER TABLE Patients
	ADD (CONSTRAINT R_3 FOREIGN KEY (nur_id) REFERENCES Nurses (nur_id));




CREATE TABLE Treatments (
	treat_id		INTEGER NOT NULL,
    pat_id			INTEGER NOT NULL,
    doc_id			INTEGER NOT NULL,
    treat_contents	VARCHAR(1000) NOT NULL,
    treat_date		DATE NOT NULL
);
ALTER TABLE Treatments
	ADD CONSTRAINT treat_pat_doc_id_pk PRIMARY KEY (treat_id, pat_id, doc_id);
ALTER TABLE Treatments
	ADD (CONSTRAINT R_5 FOREIGN KEY (pat_id) REFERENCES Patients (pat_id));
ALTER TABLE Treatments
	ADD (CONSTRAINT R_6 FOREIGN KEY (doc_id) REFERENCES Doctors (doc_id));
    

CREATE TABLE Charts (
	chart_id		VARCHAR(20) NOT NULL,
    treat_id		INTEGER NOT NULL,
    doc_id			INTEGER NOT NULL,
    pat_id			INTEGER NOT NULL,
    nur_id			INTEGER NOT NULL,
	chart_contents	VARCHAR(1000) NOT NULL
);
ALTER TABLE Charts
	ADD CONSTRAINT chart_treat_doc_pat_id_pk PRIMARY KEY (chart_id, treat_id, doc_id, pat_id);
ALTER TABLE Charts
	ADD (CONSTRAINT R_4 FOREIGN KEY (nur_id) REFERENCES Nurses (nur_id));
ALTER TABLE Charts
	ADD (CONSTRAINT R_7 FOREIGN KEY (treat_id, pat_id, doc_id) REFERENCES Treatments (treat_id, pat_id, doc_id));





INSERT INTO doctors(doc_id, major_treat, doc_name, doc_gen, doc_phone, doc_email, doc_position)
VALUES (980312,'?????????', '?????????','M','010-333-1340','lft@hanbh.com','??????');

INSERT INTO doctors(doc_id, major_treat, doc_name, doc_gen, doc_phone, doc_email, doc_position)
VALUES (000601, '??????', '?????????','M','011-222-0987', 'ask@hanbh.com','??????');

INSERT INTO doctors(doc_id, major_treat, doc_name, doc_gen, doc_phone, doc_email, doc_position)
VALUES (001208,'??????','?????????','M','010-333-8743','kmj@han.com','??????');

INSERT INTO doctors(doc_id, major_treat, doc_name, doc_gen, doc_phone, doc_email, doc_position)
VALUES (020403, '?????????','?????????' ,'M' ,'019-777-3764', 'lts@hanbh.com', '??????');

INSERT INTO doctors(doc_id, major_treat, doc_name, doc_gen, doc_phone, doc_email, doc_position)
VALUES (050900, '?????????', '?????????', 'F' ,'010-555-3746', 'kya@hanbh.com', '?????????');

INSERT INTO doctors(doc_id, major_treat, doc_name, doc_gen, doc_phone, doc_email, doc_position)
VALUES (050101, '??????', '?????????', 'M' ,'011-222-7643', 'cth@hanbh.com', '?????????');

INSERT INTO doctors(doc_id, major_treat, doc_name, doc_gen, doc_phone, doc_email, doc_position)
VALUES (062019, '?????????', '?????????', 'F', '010-999-1265', 'jjh@hanbh.com', '?????????');

INSERT INTO doctors(doc_id, major_treat, doc_name, doc_gen, doc_phone, doc_email, doc_position)
VALUES (070576, '?????????', '?????????', 'M' ,'016-333-7263', 'hgd@hanbh.com', '?????????');

INSERT INTO doctors(doc_id, major_treat, doc_name, doc_gen, doc_phone, doc_email, doc_position)
VALUES (080543, '????????????', '?????????', 'M', '010-222-1263', 'yjs@hanbh.com', '??????');

INSERT INTO doctors(doc_id, major_treat, doc_name, doc_gen, doc_phone, doc_email, doc_position)
VALUES (091001, '??????', '?????????', 'M', '010-555-3542', 'kbm@hanbh.com', '?????????');

 

INSERT INTO Nurses(nur_id, major_job, nur_name, nur_gen, nur_phone, nur_email, nur_position)
VALUES (050302, '?????????', '?????????', 'F', '010-555-8751', 'kye@hanbh.com', '????????????');

INSERT INTO Nurses(nur_id, major_job, nur_name, nur_gen, nur_phone, nur_email, nur_position)
VALUES (050021, '??????', '?????????', 'F', '016-333-8745', 'ysa@hanbh.com', '????????????');

INSERT INTO Nurses(nur_id, major_job, nur_name, nur_gen, nur_phone, nur_email, nur_position)
VALUES (040089, '?????????', '?????????', 'M', '010-666-7646', 'sjw@hanbh.com', '??????');

INSERT INTO Nurses(nur_id, major_job, nur_name, nur_gen, nur_phone, nur_email, nur_position)
VALUES (070605, '????????????', '?????????', 'F', '010-333-4588', 'yjh@hanbh.com', '??????');

INSERT INTO Nurses(nur_id, major_job, nur_name, nur_gen, nur_phone, nur_email, nur_position)
VALUES (070804, '??????', '?????????', 'F', '010-222-1340', 'nhn@hanbh.com', '??????');

INSERT INTO Nurses(nur_id, major_job, nur_name, nur_gen, nur_phone, nur_email, nur_position)
VALUES (071018, '?????????', '?????????', 'F', '019-888-4116', 'khk@hanbh.com', '??????');

INSERT INTO Nurses(nur_id, major_job, nur_name, nur_gen, nur_phone, nur_email, nur_position)
VALUES (100356, '?????????', '?????????', 'M', '010-777-1234', 'lsy@hanbh.com', '?????????');

INSERT INTO Nurses(nur_id, major_job, nur_name, nur_gen, nur_phone, nur_email, nur_position)
VALUES (104145, '??????', '??????', 'M', '010-999-8520', 'kh@hanbh.com', '?????????');

INSERT INTO Nurses(nur_id, major_job, nur_name, nur_gen, nur_phone, nur_email, nur_position)
VALUES (120309, '?????????', '?????????', 'M', '010-777-4996', 'psw@hanbh.com', '?????????');

INSERT INTO Nurses(nur_id, major_job, nur_name, nur_gen, nur_phone, nur_email, nur_position)
VALUES (130211, '??????', '?????????', 'F', '010-222-3214', 'lsy2@hanbh.com', '?????????');

 


INSERT INTO Patients(pat_id, nur_id, doc_id, pat_name, pat_gen, pat_jumin, pat_addr, pat_phone, pat_email,pat_job)
VALUES(2345,   50302,   980312,   '?????????',   'M',   232345,   '??????',   010-555-7845,   'ask@ab.com',   '?????????');

INSERT INTO Patients (pat_id, nur_id, doc_id, pat_name, pat_gen, pat_jumin, pat_addr, pat_phone, pat_email,pat_job)
VALUES(3545,   40089,   20403,   '?????????',   'M',   543545,   '??????',   010-333-7812,   'ksr@bb.com',   '?????????');

INSERT INTO Patients(pat_id, nur_id, doc_id, pat_name, pat_gen, pat_jumin, pat_addr, pat_phone, pat_email,pat_job)
VALUES(3424,   70605,   80543,   '?????????',   'M',   433424,   '??????',   019-888-4859,   'ijj@ab.com',   '?????????');

INSERT INTO Patients(pat_id, nur_id, doc_id, pat_name, pat_gen, pat_jumin, pat_addr, pat_phone, pat_email,pat_job)
VALUES(7675,   100356,   50900,   '?????????',   'M',   677675,   '??????',   010-222-4847,   'cks@cc.com',   '?????????');

INSERT INTO Patients(pat_id, nur_id, doc_id, pat_name, pat_gen, pat_jumin, pat_addr, pat_phone, pat_email,pat_job)
VALUES(4533,   70804,   601,   '?????????',   'M',   744533,   '??????',   010-777-9630,   'jhk@ab.com',   '??????');

INSERT INTO Patients(pat_id, nur_id, doc_id, pat_name, pat_gen, pat_jumin, pat_addr, pat_phone, pat_email,pat_job)
VALUES(5546,   120309,   70576,   '?????????',   'M',   765546,   '??????',   016-777-0214,   'ywh@cc.com',   '?????????');

INSERT INTO Patients(pat_id, nur_id, doc_id, pat_name, pat_gen, pat_jumin, pat_addr, pat_phone, pat_email,pat_job)
VALUES(4543,   70804,   50101,   '?????????',   'M',   454543,   '??????',   010-555-4187,   'cjj@bb.com',   '?????????');

INSERT INTO Patients(pat_id, nur_id, doc_id, pat_name, pat_gen, pat_jumin, pat_addr, pat_phone, pat_email,pat_job)
VALUES(9768,   130211,   91001,   '?????????',   'F',   119768,   '??????',   010-888-3675,   'ijh@ab.com',   '??????');

INSERT INTO Patients(pat_id, nur_id, doc_id, pat_name, pat_gen, pat_jumin, pat_addr, pat_phone, pat_email,pat_job)
VALUES(4234,   130211,   91001,   '?????????',   'F',   234234,   '??????',   010-999-6541,   'onm@cc.com',   '??????');

INSERT INTO Patients(pat_id, nur_id, doc_id, pat_name, pat_gen, pat_jumin, pat_addr, pat_phone, pat_email,pat_job)
VALUES(7643,   71018,   62019,   '?????????',   'M',   987643,   '??????',   010-222-5874,   'ssm@bb.com',   '??????');

 



INSERT INTO Treatments(treat_id,pat_id, doc_id, treat_contents, treat_date)
VALUES (130516023, 2345, 980312, '??????, ??????', '13/05/16');

INSERT INTO Treatments(treat_id,pat_id, doc_id, treat_contents, treat_date)
VALUES (130628100, 3545, 020403, '?????? ????????? ??????', '13/06/28');

INSERT INTO Treatments(treat_id,pat_id, doc_id, treat_contents, treat_date)
VALUES (131205056, 3424, 080543, '??? ???????????? MRI ??????', '13/12/05');

INSERT INTO Treatments(treat_id,pat_id, doc_id, treat_contents, treat_date)
VALUES (131218024, 7675, 050900, '?????????', '13/12/18');

INSERT INTO Treatments(treat_id,pat_id, doc_id, treat_contents, treat_date)
VALUES (131224012, 4533, 000601, '??????', '13/12/24');

INSERT INTO Treatments(treat_id,pat_id, doc_id, treat_contents, treat_date)
VALUES (140103001, 5546, 070576, '????????? ??????', '14/01/03');

INSERT INTO Treatments(treat_id,pat_id, doc_id, treat_contents, treat_date)
VALUES (140109026, 4543, 050101, '??????' ,'14/01/09');

INSERT INTO Treatments(treat_id,pat_id, doc_id, treat_contents, treat_date)
VALUES (140226102, 9768, 091001, '????????????', '14/02/26');

INSERT INTO Treatments(treat_id,pat_id, doc_id, treat_contents, treat_date)
VALUES (140303003, 4234, 091001, '???????????? ????????????', '14/03/03');

INSERT INTO Treatments(treat_id,pat_id, doc_id, treat_contents, treat_date)
VALUES (140308087, 7643, 062019, '??????', '14/03/08');


INSERT INTO Charts(chart_id, treat_id, doc_id, pat_id, nur_id, chart_contents)
VALUES ('a0001', 130516023, 980312, 2345, 50302, '????????? ??? ?????? ??????');

INSERT INTO Charts(chart_id, treat_id, doc_id, pat_id, nur_id, chart_contents)
VALUES ('a0002', 130628100, 020403, 3545, 040089, '????????? ??? ???????????? ??????');

INSERT INTO Charts(chart_id, treat_id, doc_id, pat_id, nur_id, chart_contents)
VALUES ('a0003', 131205056, 080543, 3424, 070605, '?????? CT ?????? ??????');

INSERT INTO Charts(chart_id, treat_id, doc_id, pat_id, nur_id, chart_contents)
VALUES ('a0004', 131218024, 050900, 7675, 100356, '???????????? ??? ????????? ?????? ??????');

INSERT INTO Charts(chart_id, treat_id, doc_id, pat_id, nur_id, chart_contents)
VALUES ('a0005', 131224012, 000601, 4533, 070804, '?????? ?????? ??????');

INSERT INTO Charts(chart_id, treat_id, doc_id, pat_id, nur_id, chart_contents)
VALUES ('a0006', 140103001, 070576, 5546, 120309, '????????? ????????? ??????');

INSERT INTO Charts(chart_id, treat_id, doc_id, pat_id, nur_id, chart_contents)
VALUES ('a0007', 140109026, 050101, 4543, 070804, '???????????? ??? ????????? ??????');

INSERT INTO Charts(chart_id, treat_id, doc_id, pat_id, nur_id, chart_contents)
VALUES ('a0008', 140226102, 091001, 9768, 130211, '???????????? ??? ?????? ?????? ??????');

INSERT INTO Charts(chart_id, treat_id, doc_id, pat_id, nur_id, chart_contents)
VALUES ('a0009', 140303003, 091001, 4234, 130211, '?????? ??? ?????? ??????');

INSERT INTO Charts(chart_id, treat_id, doc_id, pat_id, nur_id, chart_contents)
VALUES ('a0010', 140308087, 000601, 7643, 071018, '?????? ????????? ??????');

INSERT INTO Charts(chart_id, treat_id, doc_id, pat_id, nur_id, chart_contents)
VALUES ('a0011', 140103001, 070576, 7643, 071018, '????????? ?????? ????????? ??????');

INSERT INTO Charts(chart_id, treat_id, doc_id, pat_id, nur_id, chart_contents)
VALUES ('a0012', 140109026, 980312, 7643, 071018, '?????? ?????? ?????? ??? ????????? ?????? ??????');

INSERT INTO Charts(chart_id, treat_id, doc_id, pat_id, nur_id, chart_contents)
VALUES ('a0013', 140226102, 091001, 7643, 071018, '???????????? ??? ????????? ??????');

INSERT INTO Charts(chart_id, treat_id, doc_id, pat_id, nur_id, chart_contents)
VALUES ('a0014', 140303003, 001208, 7643, 071018, '?????? ?????? ??? ??????');

INSERT INTO Charts(chart_id, treat_id, doc_id, pat_id, nur_id, chart_contents)
VALUES ('a0015', 140308087, 062019, 7643, 071018, '????????? ??? ?????? ??????');





commit; 



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
