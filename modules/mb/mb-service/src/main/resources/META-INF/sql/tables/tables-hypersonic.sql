create table dm_cauhinhthutientet (
	cauHinhThuTienTetId bigint not null primary key,
	nam int,
	ngayBatDau timestamp null,
	ngayKetThuc timestamp null,
	soNgay int
);

create table dm_cauhinhthutientruoc (
	cauHinhThuTienTruocId bigint not null primary key,
	companyId bigint,
	groupId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	nam int,
	ngayTu timestamp null,
	ngayDen timestamp null,
	hoatDong bit
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
	duNoToiDa double,
	duNoToiDaTheChap double,
	diaChi varchar(75) null,
	ghiChu varchar(75) null,
	hoatDong bit
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
	hoatDong bit
);

create table dm_laisuat (
	laiSuatId bigint not null primary key,
	companyId bigint,
	groupId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	soTienVay double,
	thoiHan int,
	laiSuatVay double,
	gocNgay double,
	laiNgay double,
	gocNgayCuoi double,
	hoatDong bit
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
	hoatDong bit
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
	hoatDong bit
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
	loai int,
	hoatDong bit
);

create table dm_quanlymaso (
	quanLyMaSoId bigint not null primary key,
	key_ varchar(75) null,
	so int
);

create table dm_sokheuoc (
	soKheUocId bigint not null primary key,
	cauTruc varchar(75) null,
	so int
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
	loaiTaiKhoan int,
	hoatDong bit
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
	soTien double,
	tenCTV varchar(75) null,
	maCTV varchar(75) null,
	soPhieu varchar(75) null,
	hoatDong bit
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
	thang int,
	nam int,
	soTienTon double,
	soTienThu double,
	soTienChi double,
	hoatDong bit
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
	soTien double,
	chungTuKemTheo varchar(75) null,
	loai int,
	hoatDong bit
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
	soTien double,
	tongSoTienVonTra double,
	tongSoTienLaiTra double,
	ngayXuLy timestamp null,
	loai int,
	trangThaiPhatVayHienTai int
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
	loaiPhatVay int,
	soLanDaThu int,
	ngayDaThuCuoi timestamp null,
	soTienVay double,
	thoiHan int,
	laiSuatVay double,
	gocNgay double,
	laiNgay double,
	gocNgayCuoi double,
	soNgayThuTruoc int,
	ngayThuTruocTu timestamp null,
	ngayThuTruocDen timestamp null,
	ngayTatToan timestamp null,
	trangThai int
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
	giaTriTaiSan double,
	thongTinTaiSan varchar(75) null,
	ten varchar(75) null,
	ghiChu varchar(75) null
);
