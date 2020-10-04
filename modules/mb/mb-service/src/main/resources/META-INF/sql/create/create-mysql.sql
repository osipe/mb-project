drop database if exists lportal;
create database lportal character set utf8;
use lportal;



create index IX_3C5078C4 on dm_cauhinhthutientet (nam);

create index IX_20BD795C on dm_cauhinhthutientruoc (nam);

create index IX_672B6A45 on dm_congtacvien (ma);
create index IX_34912B2D on dm_congtacvien (soCMND);

create index IX_8DAA6BD3 on dm_khachhang (ma);
create index IX_CC94A7B6 on dm_khachhang (maCTV);
create index IX_1978B5BB on dm_khachhang (soCMND);

create index IX_6D3EA83E on dm_laisuat (soTienVay, thoiHan, hoatDong);

create index IX_5AB2AF3 on dm_loaiTaiSan (ma);

create index IX_5A4A349A on dm_masotheodoi (ma, hoatDong);

create index IX_4DFD6160 on dm_masothuchi (loai, hoatDong);
create index IX_A8136CC9 on dm_masothuchi (ma, hoatDong);
create index IX_364B8EE8 on dm_masothuchi (ma, loai, hoatDong);

create index IX_4E67C51E on dm_quanlymaso (key_);

create index IX_27CFEFDA on dm_sokheuoc (cauTruc);

create index IX_6AD2CFC1 on dm_taikhoandoiung (hoatDong);
create index IX_4DE60BA3 on dm_taikhoandoiung (loaiTaiKhoan, hoatDong);
create index IX_9D2A69A2 on dm_taikhoandoiung (soHieu, hoatDong);
create index IX_B54D00B7 on dm_taikhoandoiung (taiKhoanDoiUngChaId, hoatDong);

create index IX_20EE0820 on ketoan_dsphieutaikhoan (phieuId, hoatDong);
create index IX_85FF8992 on ketoan_dsphieutaikhoan (taiKhoanDoiUngId, hoatDong);

create index IX_85F7F836 on ketoan_lichsutaikhoandauky (taiKhoanDoiUngId, nam, thang);

create index IX_8735CCB5 on mb_lichsuthuphatchi (maCTV);
create index IX_B57FF0A1 on mb_lichsuthuphatchi (phatVayId, loai);

create index IX_FA2C6182 on mb_phatvay (maCTV);
create index IX_86B4D7F9 on mb_phatvay (soKU);

create index IX_FF2864C7 on mb_taisaithuechap (phatVayId);


