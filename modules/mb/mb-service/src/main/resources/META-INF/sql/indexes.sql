create index IX_3C5078C4 on dm_cauhinhthutientet (nam);

create index IX_20BD795C on dm_cauhinhthutientruoc (nam);

create index IX_8B11A80B on dm_chinhanh (hoatDong);
create index IX_B12FA41 on dm_chinhanh (ma[$COLUMN_LENGTH:75$]);

create index IX_35F049B on dm_congtacvien (chiNhanhId, hoatDong);
create index IX_672B6A45 on dm_congtacvien (ma[$COLUMN_LENGTH:75$]);
create index IX_34912B2D on dm_congtacvien (soCMND[$COLUMN_LENGTH:75$]);

create index IX_8DAA6BD3 on dm_khachhang (ma[$COLUMN_LENGTH:75$]);
create index IX_CC94A7B6 on dm_khachhang (maCTV[$COLUMN_LENGTH:75$]);
create index IX_1978B5BB on dm_khachhang (soCMND[$COLUMN_LENGTH:75$]);

create index IX_6D3EA83E on dm_laisuat (soTienVay, thoiHan, hoatDong);

create index IX_5AB2AF3 on dm_loaiTaiSan (ma[$COLUMN_LENGTH:75$]);

create index IX_5A4A349A on dm_masotheodoi (ma[$COLUMN_LENGTH:75$], hoatDong);

create index IX_4DFD6160 on dm_masothuchi (loai, hoatDong);
create index IX_A8136CC9 on dm_masothuchi (ma[$COLUMN_LENGTH:75$], hoatDong);
create index IX_364B8EE8 on dm_masothuchi (ma[$COLUMN_LENGTH:75$], loai, hoatDong);

create index IX_4E67C51E on dm_quanlymaso (key_[$COLUMN_LENGTH:75$]);

create index IX_27CFEFDA on dm_sokheuoc (cauTruc[$COLUMN_LENGTH:75$]);

create index IX_6AD2CFC1 on dm_taikhoandoiung (hoatDong);
create index IX_4DE60BA3 on dm_taikhoandoiung (loaiTaiKhoan, hoatDong);
create index IX_9D2A69A2 on dm_taikhoandoiung (soHieu[$COLUMN_LENGTH:75$], hoatDong);
create index IX_B54D00B7 on dm_taikhoandoiung (taiKhoanDoiUngChaId, hoatDong);

create index IX_20EE0820 on ketoan_dsphieutaikhoan (phieuId, hoatDong);
create index IX_85FF8992 on ketoan_dsphieutaikhoan (taiKhoanDoiUngId, hoatDong);

create index IX_85F7F836 on ketoan_lichsutaikhoandauky (taiKhoanDoiUngId, nam, thang);

create index IX_8735CCB5 on mb_lichsuthuphatchi (maCTV[$COLUMN_LENGTH:75$]);
create index IX_B57FF0A1 on mb_lichsuthuphatchi (phatVayId, loai);

create index IX_FA2C6182 on mb_phatvay (maCTV[$COLUMN_LENGTH:75$]);
create index IX_86B4D7F9 on mb_phatvay (soKU[$COLUMN_LENGTH:75$]);

create index IX_FF2864C7 on mb_taisaithuechap (phatVayId);