create table dm_cauhinhthutientet (
	cauHinhThuTienTetId bigint not null primary key,
	nam integer,
	ngayBatDau datetime(6) null,
	ngayKetThuc datetime(6) null,
	soNgay integer
) engine InnoDB;

create table dm_congtacvien (
	congTacVienId bigint not null primary key,
	companyId bigint,
	groupId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate datetime(6) null,
	modifiedDate datetime(6) null,
	ma varchar(75) null,
	hoTen varchar(75) null,
	soCMND varchar(75) null,
	duNoToiDa double,
	duNoToiDaTheChap double,
	diaChi varchar(75) null,
	ghiChu varchar(75) null,
	hoatDong tinyint
) engine InnoDB;

create table dm_khachhang (
	khachHangId bigint not null primary key,
	companyId bigint,
	groupId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate datetime(6) null,
	modifiedDate datetime(6) null,
	maCTV varchar(75) null,
	ma varchar(75) null,
	hoTen varchar(75) null,
	soCMND varchar(75) null,
	diaChi varchar(75) null,
	hoatDong tinyint
) engine InnoDB;

create table dm_laisuat (
	laiSuatId bigint not null primary key,
	companyId bigint,
	groupId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate datetime(6) null,
	modifiedDate datetime(6) null,
	soTienVay double,
	thoiHan integer,
	laiSuatVay double,
	gocNgay double,
	laiNgay double,
	gocNgayCuoi double,
	hoatDong tinyint
) engine InnoDB;

create table dm_loaiTaiSan (
	loaiTaiSanId bigint not null primary key,
	companyId bigint,
	groupId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate datetime(6) null,
	modifiedDate datetime(6) null,
	ten varchar(75) null,
	ma varchar(75) null,
	ghiChu varchar(75) null,
	hoatDong tinyint
) engine InnoDB;

create table dm_masotheodoi (
	maSoTheoDoiId bigint not null primary key,
	companyId bigint,
	groupId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate datetime(6) null,
	modifiedDate datetime(6) null,
	ma varchar(75) null,
	dienGiai varchar(75) null,
	hoatDong tinyint
) engine InnoDB;

create table dm_masothuchi (
	maSoThuChiId bigint not null primary key,
	companyId bigint,
	groupId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate datetime(6) null,
	modifiedDate datetime(6) null,
	ma varchar(75) null,
	dienGiai varchar(75) null,
	dienGiaiTheoDoi varchar(75) null,
	loai integer,
	hoatDong tinyint
) engine InnoDB;

create table dm_quanlymaso (
	quanLyMaSoId bigint not null primary key,
	key_ varchar(75) null,
	so integer
) engine InnoDB;

create table dm_sokheuoc (
	soKheUocId bigint not null primary key,
	cauTruc varchar(75) null,
	so integer
) engine InnoDB;

create table dm_taikhoandoiung (
	taiKhoanDoiUngId bigint not null primary key,
	companyId bigint,
	groupId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate datetime(6) null,
	modifiedDate datetime(6) null,
	taiKhoanDoiUngChaId bigint,
	soHieu varchar(75) null,
	ten varchar(75) null,
	loaiTaiKhoan integer,
	hoatDong tinyint
) engine InnoDB;

create table ketoan_dsphieutaikhoan (
	dsPhieuTaiKhoanId bigint not null primary key,
	companyId bigint,
	groupId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate datetime(6) null,
	modifiedDate datetime(6) null,
	phieuId bigint,
	ngayChungTu datetime(6) null,
	taiKhoanDoiUngId bigint,
	maTheoDoi varchar(75) null,
	dienGiaiTheoDoi varchar(75) null,
	soTien double,
	tenCTV varchar(75) null,
	maCTV varchar(75) null,
	hoatDong tinyint
) engine InnoDB;

create table ketoan_lichsutaikhoandauky (
	lichSuTaiKhoanDauKyId bigint not null primary key,
	companyId bigint,
	groupId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate datetime(6) null,
	modifiedDate datetime(6) null,
	taiKhoanDoiUngId bigint,
	thang integer,
	nam integer,
	soTienTon double,
	hoatDong tinyint
) engine InnoDB;

create table ketoan_phieu (
	phieuId bigint not null primary key,
	companyId bigint,
	groupId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate datetime(6) null,
	modifiedDate datetime(6) null,
	maCTV varchar(75) null,
	hoTenCTV varchar(75) null,
	soHopDong varchar(75) null,
	ngayChungTu datetime(6) null,
	diaChi varchar(75) null,
	soPhieu varchar(75) null,
	ngayGhiSo datetime(6) null,
	maMSThuChi varchar(75) null,
	soTien double,
	chungTuKemTheo varchar(75) null,
	loai integer,
	hoatDong tinyint
) engine InnoDB;

create table mb_lichsuthuphatchi (
	lichSuThuPhatChiId bigint not null primary key,
	companyId bigint,
	groupId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate datetime(6) null,
	modifiedDate datetime(6) null,
	phatVayId bigint,
	maCTV varchar(75) null,
	soTien double,
	tongSoTienVonTra double,
	tongSoTienLaiTra double,
	loai integer,
	trangThaiPhatVayHienTai integer
) engine InnoDB;

create table mb_phatvay (
	phatVayId bigint not null primary key,
	companyId bigint,
	groupId bigint,
	userId bigint,
	userName varchar(75) null,
	ngayTao datetime(6) null,
	modifiedDate datetime(6) null,
	maCTV varchar(75) null,
	maKhachHang varchar(75) null,
	soKU varchar(75) null,
	createDate datetime(6) null,
	ngayBatDau datetime(6) null,
	ngayKetThuc datetime(6) null,
	loaiPhatVay integer,
	soLanDaThu integer,
	ngayDaThuCuoi datetime(6) null,
	soTienVay double,
	thoiHan integer,
	laiSuatVay double,
	gocNgay double,
	laiNgay double,
	gocNgayCuoi double,
	soNgayThuTruoc integer,
	ngayThuTruocTu datetime(6) null,
	ngayThuTruocDen datetime(6) null,
	ngayTatToan datetime(6) null,
	trangThai integer
) engine InnoDB;

create table mb_taisaithuechap (
	taiSanThueChapId bigint not null primary key,
	companyId bigint,
	groupId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate datetime(6) null,
	modifiedDate datetime(6) null,
	phatVayId bigint,
	soKU varchar(75) null,
	maKhachHang varchar(75) null,
	loaiTaiSanId bigint,
	giaTriTaiSan double,
	thongTinTaiSan varchar(75) null,
	ten varchar(75) null,
	ghiChu varchar(75) null
) engine InnoDB;
