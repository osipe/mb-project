create table dm_cauhinhthutientet (
	cauHinhThuTienTetId bigint not null primary key,
	nam integer,
	ngayBatDau timestamp null,
	ngayKetThuc timestamp null,
	soNgay integer
);

create table dm_cauhinhthutientruoc (
	cauHinhThuTienTruocId bigint not null primary key,
	companyId bigint,
	groupId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	nam integer,
	ngayTu timestamp null,
	ngayDen timestamp null,
	hoatDong bool
);

create table dm_congtacvien (
	congTacVienId bigint not null primary key,
	companyId bigint,
	groupId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	ma varchar(75) null,
	hoTen varchar(75) null,
	soCMND varchar(75) null,
	duNoToiDa double precision,
	duNoToiDaTheChap double precision,
	diaChi varchar(75) null,
	ghiChu varchar(75) null,
	hoatDong bool
);

create table dm_khachhang (
	khachHangId bigint not null primary key,
	companyId bigint,
	groupId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	maCTV varchar(75) null,
	ma varchar(75) null,
	hoTen varchar(75) null,
	soCMND varchar(75) null,
	diaChi varchar(75) null,
	hoatDong bool
);

create table dm_laisuat (
	laiSuatId bigint not null primary key,
	companyId bigint,
	groupId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	soTienVay double precision,
	thoiHan integer,
	laiSuatVay double precision,
	gocNgay double precision,
	laiNgay double precision,
	gocNgayCuoi double precision,
	hoatDong bool
);

create table dm_loaiTaiSan (
	loaiTaiSanId bigint not null primary key,
	companyId bigint,
	groupId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	ten varchar(75) null,
	ma varchar(75) null,
	ghiChu varchar(75) null,
	hoatDong bool
);

create table dm_masotheodoi (
	maSoTheoDoiId bigint not null primary key,
	companyId bigint,
	groupId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	ma varchar(75) null,
	dienGiai varchar(75) null,
	hoatDong bool
);

create table dm_masothuchi (
	maSoThuChiId bigint not null primary key,
	companyId bigint,
	groupId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	ma varchar(75) null,
	dienGiai varchar(75) null,
	loai integer,
	hoatDong bool
);

create table dm_quanlymaso (
	quanLyMaSoId bigint not null primary key,
	key_ varchar(75) null,
	so integer
);

create table dm_sokheuoc (
	soKheUocId bigint not null primary key,
	cauTruc varchar(75) null,
	so integer
);

create table dm_taikhoandoiung (
	taiKhoanDoiUngId bigint not null primary key,
	companyId bigint,
	groupId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	taiKhoanDoiUngChaId bigint,
	soHieu varchar(75) null,
	ten varchar(75) null,
	dienGiaiTheoDoi varchar(75) null,
	loaiTaiKhoan integer,
	hoatDong bool
);

create table ketoan_dsphieutaikhoan (
	dsPhieuTaiKhoanId bigint not null primary key,
	companyId bigint,
	groupId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	phieuId bigint,
	ngayChungTu timestamp null,
	taiKhoanDoiUngId bigint,
	maTheoDoi varchar(75) null,
	dienGiaiTheoDoi varchar(75) null,
	soTien double precision,
	tenCTV varchar(75) null,
	maCTV varchar(75) null,
	soPhieu varchar(75) null,
	hoatDong bool
);

create table ketoan_lichsutaikhoandauky (
	lichSuTaiKhoanDauKyId bigint not null primary key,
	companyId bigint,
	groupId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	taiKhoanDoiUngId bigint,
	thang integer,
	nam integer,
	soTienTon double precision,
	soTienThu double precision,
	soTienChi double precision,
	hoatDong bool
);

create table ketoan_phieu (
	phieuId bigint not null primary key,
	companyId bigint,
	groupId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	maCTV varchar(75) null,
	hoTenCTV varchar(75) null,
	soHopDong varchar(75) null,
	ngayChungTu timestamp null,
	diaChi varchar(75) null,
	soPhieu varchar(75) null,
	ngayGhiSo timestamp null,
	maMSThuChi varchar(75) null,
	soTien double precision,
	chungTuKemTheo varchar(75) null,
	loai integer,
	hoatDong bool
);

create table mb_lichsuthuphatchi (
	lichSuThuPhatChiId bigint not null primary key,
	companyId bigint,
	groupId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	phatVayId bigint,
	maCTV varchar(75) null,
	soTien double precision,
	tongSoTienVonTra double precision,
	tongSoTienLaiTra double precision,
	ngayXuLy timestamp null,
	loai integer,
	trangThaiPhatVayHienTai integer
);

create table mb_phatvay (
	phatVayId bigint not null primary key,
	companyId bigint,
	groupId bigint,
	userId bigint,
	userName varchar(75) null,
	ngayTao timestamp null,
	modifiedDate timestamp null,
	maCTV varchar(75) null,
	maKhachHang varchar(75) null,
	soKU varchar(75) null,
	createDate timestamp null,
	ngayBatDau timestamp null,
	ngayKetThuc timestamp null,
	loaiPhatVay integer,
	soLanDaThu integer,
	ngayDaThuCuoi timestamp null,
	soTienVay double precision,
	thoiHan integer,
	laiSuatVay double precision,
	gocNgay double precision,
	laiNgay double precision,
	gocNgayCuoi double precision,
	soNgayThuTruoc integer,
	ngayThuTruocTu timestamp null,
	ngayThuTruocDen timestamp null,
	ngayTatToan timestamp null,
	trangThai integer
);

create table mb_taisaithuechap (
	taiSanThueChapId bigint not null primary key,
	companyId bigint,
	groupId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	phatVayId bigint,
	soKU varchar(75) null,
	maKhachHang varchar(75) null,
	loaiTaiSanId bigint,
	giaTriTaiSan double precision,
	thongTinTaiSan varchar(75) null,
	ten varchar(75) null,
	ghiChu varchar(75) null
);
