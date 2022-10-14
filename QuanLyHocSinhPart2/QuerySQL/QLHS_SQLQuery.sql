

Create database QLHS;
go

USE QLHS;

go

create table TaiKhoan(
	UserName char(20) primary key,
	Pass char(10),
	Hoten nvarchar(20),
	Sdt char(11),
	Email char(30),
	Quyen char(10)
);
go
insert into TaiKhoan(UserName, Pass, Hoten, Sdt, Email, Quyen)
values ( 'HiuHiu', '1234' , N'Nguyễn Minh Quân' ,'0928392222', 'minh@gmail.com', 'Admin');

select * from TaiKhoan;

go
create table MonHoc(
	MaMon char(10) primary key not null ,
	TenMon nvarchar(15),
);
go
create table HocKy(
	MaHK char(10) primary key,
	TenHK nvarchar(20),
	NamBatDau int,
	NamKetThuc int,

);

go
create table Lop(
	MaLop char(10) primary key, 
	TenLop nvarchar(10),
	SiSo int,	
);
go
create table HocSinh(
	MaHS char(15) primary key,
	HoTenHS nvarchar(20),
	MaLop char(10),
	NgaySinh Date,
	GioiTinh nvarchar(4),
	SDT_LL varchar(11),
	DanToc nvarchar(15),
	NoiSinh nvarchar(40),
	DiaChi nvarchar(40),
	TenPhuHuynh nvarchar(20),
	NgheNghiep nvarchar(20),
	TieuHoc nvarchar(30),

	foreign key (MaLop) references Lop(MaLop),
);
go

create table DiemMon(
	MaMon char(10),
	MaHS char(15),
	MaHK char(10),
	DiemMieng real,
	Diem15p real,
	Diem1tiet real,
	DiemThi real,
	DiemTBmon real,
	foreign key(MaHK) references HocKy(MaHK),
	foreign key(MaHS) references HocSinh(MaHS),
	foreign key(MaMon) references MonHoc(MaMon),
);
