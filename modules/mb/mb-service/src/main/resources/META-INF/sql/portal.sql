create table dm_cauhinhthutientet (
	cauHinhThuTienTetId LONG not null primary key,
	nam INTEGER,
	ngayBatDau DATE null,
	ngayKetThuc DATE null,
	soNgay INTEGER
);

create table dm_cauhinhthutientruoc (
	cauHinhThuTienTruocId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	nam INTEGER,
	ngayTu DATE null,
	ngayDen DATE null,
	hoatDong BOOLEAN
);

create table dm_congtacvien (
	congTacVienId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	ma VARCHAR(75) null,
	hoTen VARCHAR(75) null,
	soCMND VARCHAR(75) null,
	duNoToiDa DOUBLE,
	duNoToiDaTheChap DOUBLE,
	diaChi VARCHAR(75) null,
	ghiChu VARCHAR(75) null,
	hoatDong BOOLEAN
);

create table dm_khachhang (
	khachHangId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	maCTV VARCHAR(75) null,
	ma VARCHAR(75) null,
	hoTen VARCHAR(75) null,
	soCMND VARCHAR(75) null,
	diaChi VARCHAR(75) null,
	hoatDong BOOLEAN
);

create table dm_laisuat (
	laiSuatId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	soTienVay DOUBLE,
	thoiHan INTEGER,
	laiSuatVay DOUBLE,
	gocNgay DOUBLE,
	laiNgay DOUBLE,
	gocNgayCuoi DOUBLE,
	hoatDong BOOLEAN
);

create table dm_loaiTaiSan (
	loaiTaiSanId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	ten VARCHAR(75) null,
	ma VARCHAR(75) null,
	ghiChu VARCHAR(75) null,
	hoatDong BOOLEAN
);

create table dm_masotheodoi (
	maSoTheoDoiId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	ma VARCHAR(75) null,
	dienGiai VARCHAR(75) null,
	hoatDong BOOLEAN
);

create table dm_masothuchi (
	maSoThuChiId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	ma VARCHAR(75) null,
	dienGiai VARCHAR(75) null,
	loai INTEGER,
	hoatDong BOOLEAN
);

create table dm_quanlymaso (
	quanLyMaSoId LONG not null primary key,
	key_ VARCHAR(75) null,
	so INTEGER
);

create table dm_sokheuoc (
	soKheUocId LONG not null primary key,
	cauTruc VARCHAR(75) null,
	so INTEGER
);

create table dm_taikhoandoiung (
	taiKhoanDoiUngId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	taiKhoanDoiUngChaId LONG,
	soHieu VARCHAR(75) null,
	ten VARCHAR(75) null,
	dienGiaiTheoDoi VARCHAR(75) null,
	loaiTaiKhoan INTEGER,
	hoatDong BOOLEAN
);

create table ketoan_dsphieutaikhoan (
	dsPhieuTaiKhoanId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	phieuId LONG,
	ngayChungTu DATE null,
	taiKhoanDoiUngId LONG,
	maTheoDoi VARCHAR(75) null,
	dienGiaiTheoDoi VARCHAR(75) null,
	soTien DOUBLE,
	tenCTV VARCHAR(75) null,
	maCTV VARCHAR(75) null,
	soPhieu VARCHAR(75) null,
	hoatDong BOOLEAN
);

create table ketoan_lichsutaikhoandauky (
	lichSuTaiKhoanDauKyId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	taiKhoanDoiUngId LONG,
	thang INTEGER,
	nam INTEGER,
	soTienTon DOUBLE,
	soTienThu DOUBLE,
	soTienChi DOUBLE,
	hoatDong BOOLEAN
);

create table ketoan_phieu (
	phieuId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	maCTV VARCHAR(75) null,
	hoTenCTV VARCHAR(75) null,
	soHopDong VARCHAR(75) null,
	ngayChungTu DATE null,
	diaChi VARCHAR(75) null,
	soPhieu VARCHAR(75) null,
	ngayGhiSo DATE null,
	maMSThuChi VARCHAR(75) null,
	soTien DOUBLE,
	chungTuKemTheo VARCHAR(75) null,
	loai INTEGER,
	hoatDong BOOLEAN
);

create table mb_lichsuthuphatchi (
	lichSuThuPhatChiId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	phatVayId LONG,
	maCTV VARCHAR(75) null,
	soTien DOUBLE,
	tongSoTienVonTra DOUBLE,
	tongSoTienLaiTra DOUBLE,
	ngayXuLy DATE null,
	loai INTEGER,
	trangThaiPhatVayHienTai INTEGER
);

create table mb_phatvay (
	phatVayId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	ngayTao DATE null,
	modifiedDate DATE null,
	maCTV VARCHAR(75) null,
	maKhachHang VARCHAR(75) null,
	soKU VARCHAR(75) null,
	createDate DATE null,
	ngayBatDau DATE null,
	ngayKetThuc DATE null,
	loaiPhatVay INTEGER,
	soLanDaThu INTEGER,
	ngayDaThuCuoi DATE null,
	soTienVay DOUBLE,
	thoiHan INTEGER,
	laiSuatVay DOUBLE,
	gocNgay DOUBLE,
	laiNgay DOUBLE,
	gocNgayCuoi DOUBLE,
	soNgayThuTruoc INTEGER,
	ngayThuTruocTu DATE null,
	ngayThuTruocDen DATE null,
	ngayTatToan DATE null,
	trangThai INTEGER
);

create table mb_taisaithuechap (
	taiSanThueChapId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	phatVayId LONG,
	soKU VARCHAR(75) null,
	maKhachHang VARCHAR(75) null,
	loaiTaiSanId LONG,
	giaTriTaiSan DOUBLE,
	thongTinTaiSan VARCHAR(75) null,
	ten VARCHAR(75) null,
	ghiChu VARCHAR(75) null
);