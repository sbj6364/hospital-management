select * from Patients;
select * from Treatments;
select * from Nurses;
select * from Doctors;
select * from Charts;

select n.nur_id, n.nur_name, count(*)
from Nurses n, Charts c
where c.nur_id = n.nur_id
group by n.nur_id
having count(*) >= 2
order by count(*) desc;




# 소아과 의사에게 진료를 받은 환자들의 수를 각 증상에 따라 분류

select t.treat_contents, count(*)
from Treatments t, Patients p, Doctors d
where t.pat_id = p.pat_id and p.doc_id = d.doc_id and d.major_treat = '소아과'
group by t.treat_contents
order by t.treat_contents;


select d.doc_name, count(*) as patien
from Doctors d, Patients p
where p.doc_id = d.doc_id
group by d.doc_name;



select count(p.pat_name), count(d.doc_name), count(d.doc_name)
from Patients p, Doctors d, Nurses n
where p.doc_id = d.doc_id and p.nur_id = n.nur_id;

select major_treat, count(*) from Doctors
group by major_treat
order by major_treat;

select major_job, count(*) from Nurses
group by major_job
order by major_job;

select d.major_treat, count(*) from Patients p, Doctors d
where p.doc_id = d.doc_id
group by d.major_treat
order by major_treat;

select d.major_treat, a.CNT, b.CNT, c.CNT
from Doctors d,
	(
	select major_treat m, count(*) as CNT from Doctors
	group by major_treat
	order by major_treat
    ) a,
    (
    select major_job m, count(*) as CNT from Nurses
	group by major_job
    order by major_job
	) b,
    (
    select d.major_treat m, count(*) as CNT from Patients p, Doctors d
	where p.doc_id = d.doc_id
	group by d.major_treat
	order by d.major_treat
    ) c
where d.major_treat = a.m and a.m = b.m and b.m = c.m
group by d.major_treat
order by d.major_treat;
    



select * from Doctors
where major_treat;

select distinct major_treat from Doctors;
select distinct major_job from Nurses;

select d.major_treat, count(d.*),  from Doctors d, Nurses n
where d.major_treat = n.major_job
group by d.major_treat;


select d.major_treat, n.major_job from Doctors d, Nurses n;


select count(*), d.* from Doctors d, Nurses n, Patients p;
group by d.major_treat;

select d.doc_name as 'Doctor', count(*) as 'Charts' from Charts c, Doctors d
where d.doc_id = c.doc_id
group by doc_name
having count(*) >= 2
order by count(*) DESC;

update Doctors
set doc_position = '차장'
where doc_id = 1208;

select * from Treatments
where treat_date < '2014-01-09';

delete from Treatments
where treat_date < '2014-01-09';

delete from Charts
where treat_id in (
	select treat_id from Treatments
    where treat_date < '2014-01-09');
    
select * from Charts
where treat_id in (
	select treat_id from Treatments
    where treat_date > '20140108');

# 소아과 간호사와 

insert into Patients values (1234, 1234, 1234, '서병준', 'M', '1234', '서울', '1234', null, '학생');