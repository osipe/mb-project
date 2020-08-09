--07.08.2020
ALTER TABLE public.mb_lichsuthuphatchi ADD COLUMN ngayXuLy timestamp without time zone;
--16.07.2020
ALTER TABLE public.dm_taikhoandoiung ADD COLUMN dienGiaiTheoDoi text;

--02.07.2020
ALTER TABLE public.dm_taikhoandoiung ADD COLUMN loaiTaiKhoan integer;
ALTER TABLE public.ketoan_dsphieutaikhoan ADD COLUMN maCTV  character varying(255);
ALTER TABLE public.ketoan_dsphieutaikhoan ADD COLUMN tenCTV  character varying(255);
CREATE OR REPLACE FUNCTION public.capNhatTenCTV()
  RETURNS character varying AS
$BODY$
DECLARE
tenCTV_ character varying(500);
_temp ketoan_dsphieutaikhoan%rowtype;	
BEGIN
	FOR _temp IN  (SELECT * FROM ketoan_dsphieutaikhoan)
	LOOP
		SELECT hotenctv INTO tenCTV_ FROM ketoan_phieu WHERE phieuid = _temp.phieuid;
		IF(tenCTV_ != '' AND tenCTV_ IS NOT NULL) THEN
			EXECUTE('UPDATE ketoan_dsphieutaikhoan SET tenCTV =''' || tenCTV_ || ''' WHERE phieuid =' || _temp.phieuid || ';');
		END IF;
	END LOOP;
RETURN '13132';
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION public.capNhatTenCTV()
  OWNER TO postgres;
select public.capNhatTenCTV();


ALTER TABLE public.dm_congtacvien ADD COLUMN duNoToiDaTheChap double precision;
ALTER TABLE public.mb_phatvay ADD COLUMN ngaytao timestamp without time zone;
ALTER TABLE public.mb_lichsuthuphatchi ADD COLUMN trangThaiPhatVayHienTai integer;
ALTER TABLE public.ketoan_dsphieutaikhoan ADD COLUMN sophieu character varying(75);
ALTER TABLE public.ketoan_lichsutaikhoandauky ADD COLUMN soTienThu double precision;
ALTER TABLE public.ketoan_lichsutaikhoandauky ADD COLUMN soTienChi double precision;

ALTER TABLE public.ketoan_dsphieutaikhoan ADD COLUMN sophieu character varying(75);
ALTER TABLE public.ketoan_lichsutaikhoandauky ADD COLUMN sotienchi double precision;
ALTER TABLE public.ketoan_lichsutaikhoandauky ADD COLUMN sotienthu double precision;

