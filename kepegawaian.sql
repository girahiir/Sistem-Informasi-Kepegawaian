-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 19, 2016 at 08:22 PM
-- Server version: 10.1.10-MariaDB
-- PHP Version: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kepegawaian`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbldataindukpeg`
--

CREATE TABLE `tbldataindukpeg` (
  `NIP` varchar(15) NOT NULL DEFAULT '',
  `Nama` varchar(20) DEFAULT NULL,
  `JenisKelamin` enum('P','W') DEFAULT NULL,
  `status` enum('Menikah','Belum_Menikah') DEFAULT NULL,
  `golDarah` enum('A','B','O','AB') DEFAULT NULL,
  `gelarDepan` varchar(15) DEFAULT NULL,
  `gelarBelakang` varchar(15) DEFAULT NULL,
  `agama` enum('Islam','Kristen','Katolik','Hindu','Budha') DEFAULT NULL,
  `tempatLahir` varchar(30) NOT NULL,
  `tglLahir` date DEFAULT NULL,
  `noKtp` int(20) DEFAULT NULL,
  `alamat` varchar(100) DEFAULT NULL,
  `telRumah` varchar(15) DEFAULT NULL,
  `noPonsel` varchar(15) DEFAULT NULL,
  `tahunmasuk` int(4) NOT NULL,
  `idPangkat` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbldataindukpeg`
--

INSERT INTO `tbldataindukpeg` (`NIP`, `Nama`, `JenisKelamin`, `status`, `golDarah`, `gelarDepan`, `gelarBelakang`, `agama`, `tempatLahir`, `tglLahir`, `noKtp`, `alamat`, `telRumah`, `noPonsel`, `tahunmasuk`, `idPangkat`) VALUES
('admin', 'admin', 'P', 'Menikah', 'A', 'Drs', 'SH', 'Islam', 'Yogya', '1996-06-03', 123, 'ugm', '345', '234', 2010, 'p01'),
('anin', 'anin', 'W', 'Belum_Menikah', 'O', 'sdr', 'drs', 'Budha', 'bulan', '2016-05-28', 234, 'itb', '987', '234', 2001, 'p15'),
('bk', 'bk', 'P', 'Belum_Menikah', 'B', 'Drs', 'SH', 'Kristen', 'Yogya', '1996-06-03', 123, 'ugm', '345', '234', 2010, 'p03'),
('budi', 'budi', 'P', 'Belum_Menikah', 'O', 'sdr', 'drs', 'Katolik', 'bulan', '2016-05-28', 234, 'itb', '987', '234', 2001, 'p09'),
('cinta', 'cinta', 'W', 'Belum_Menikah', 'O', 'sdr', 'drs', 'Kristen', 'bulan', '2016-05-28', 234, 'itb', '987', '234', 2001, 'p08'),
('danang', 'danang', 'P', 'Menikah', 'B', 'sdr', 'drs', 'Katolik', 'bulan', '2016-05-28', 234, 'itb', '987', '234', 2001, 'p03'),
('dhani', 'dhani', 'P', 'Belum_Menikah', 'O', 'sdr', 'drs', 'Hindu', 'bulan', '2016-05-28', 234, 'itb', '987', '234', 2001, 'p08'),
('halim', 'halim', 'P', 'Belum_Menikah', 'B', 'sdr', 'sh', 'Hindu', 'cina', '1999-05-06', 123, 'ugm', '098', '876', 2003, 'p10'),
('iir', 'iir', 'W', 'Belum_Menikah', 'O', 'sdr', 'drs', 'Islam', 'bulan', '2016-05-28', 234, 'itb', '987', '234', 2001, 'p06'),
('ima', 'ima', 'W', 'Belum_Menikah', 'O', 'sdr', 'drs', 'Budha', 'bulan', '2016-05-28', 234, 'itb', '987', '234', 2001, 'p13'),
('isna', 'isna', 'W', 'Belum_Menikah', 'O', 'sdr', 'drs', 'Kristen', 'bulan', '2016-05-28', 234, 'itb', '987', '234', 2001, 'p12'),
('joko', 'joko', 'P', 'Belum_Menikah', 'O', 'sdr', 'drs', 'Budha', 'bulan', '2016-05-28', 234, 'itb', '987', '234', 2001, 'p07'),
('pegawai', 'pegawai', 'W', 'Menikah', 'O', 'Drs', 'SH', 'Katolik', 'Yogya', '1996-06-03', 123, 'ugm', '345', '234', 2010, 'p02'),
('rahmat', 'rahmat', 'P', 'Belum_Menikah', 'A', 'sdr', 'sh', 'Budha', 'cina', '1999-05-06', 123, 'ugm', '098', '876', 2011, 'p03'),
('raka', 'raka', 'P', 'Belum_Menikah', 'O', 'sdr', 'drs', 'Katolik', 'bulan', '2016-05-28', 234, 'itb', '987', '234', 2001, 'p16'),
('rektor', 'rektor', 'W', 'Menikah', 'AB', 'Drs', 'SH', 'Hindu', 'Yogya', '1996-06-03', 123, 'ugm', '345', '234', 2010, 'p04'),
('taqim', 'taqim', 'P', 'Belum_Menikah', 'O', 'sdr', 'drs', '', 'bulan', '2016-05-28', 234, 'itb', '987', '234', 2001, 'p03'),
('Upi', 'Upi', 'W', 'Menikah', 'AB', 'sdr', 'sh', 'Islam', 'Indo', '1999-05-06', 123, 'ugm', '098', '876', 2011, 'p05'),
('Yoga', 'Yoga', 'P', 'Belum_Menikah', 'O', 'sdr', 'drs', '', 'bulan', '2016-05-28', 234, 'itb', '987', '234', 2001, 'p10');

-- --------------------------------------------------------

--
-- Table structure for table `tbldatakeluarga`
--

CREATE TABLE `tbldatakeluarga` (
  `idDk` varchar(6) NOT NULL,
  `NIP` varchar(15) NOT NULL,
  `namaAyah` varchar(15) DEFAULT NULL,
  `namaIbu` varchar(15) DEFAULT NULL,
  `namaIstri` varchar(15) DEFAULT NULL,
  `namaSuami` varchar(15) DEFAULT NULL,
  `jumlahAnak` int(11) DEFAULT NULL,
  `pekerjaanSuami` varchar(10) DEFAULT NULL,
  `pekerjaanIstri` varchar(10) DEFAULT NULL,
  `pekerjaanAnak` enum('Bekerja','BelumBekerja','Pelajar/Mahasiswa') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbldatakeluarga`
--

INSERT INTO `tbldatakeluarga` (`idDk`, `NIP`, `namaAyah`, `namaIbu`, `namaIstri`, `namaSuami`, `jumlahAnak`, `pekerjaanSuami`, `pekerjaanIstri`, `pekerjaanAnak`) VALUES
('bk3', 'rektor', 'ayahe rektor', 'ibune rektor', 'istrine rektor', 'bojone rektor', 2, 'rektor', 'wakil rekt', 'BelumBekerja'),
('dk1', 'admin', 'ayah', 'ibu', 'istri', 'suami', 3, 'suamikerja', 'istrikerja', 'Bekerja'),
('dk2', 'pegawai', 'ayahpegawai', 'ibupegawai', 'istripegawai', 'suamipegawai', 3, 'mancing', 'masak', 'Bekerja');

-- --------------------------------------------------------

--
-- Table structure for table `tbldatapangkat`
--

CREATE TABLE `tbldatapangkat` (
  `idPangkat` varchar(6) NOT NULL,
  `namaPangkat` varchar(30) DEFAULT NULL,
  `golongan` varchar(4) DEFAULT NULL,
  `ruang` varchar(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbldatapangkat`
--

INSERT INTO `tbldatapangkat` (`idPangkat`, `namaPangkat`, `golongan`, `ruang`) VALUES
('p01', 'Juru Muda', 'I', 'A'),
('p02', 'Juru Muda Tingkat I', 'I', 'B'),
('p03', 'Juru', 'I', 'C'),
('p04', 'Juru Tingkat I', 'I', 'D'),
('p05', 'Pengatur Muda', 'II', 'A'),
('p06', 'Pengatur Muda Tingkat I', 'II', 'B'),
('p07', 'Pengatur', 'II', 'C'),
('p08', 'Pengatur Tingkat I', 'II', 'D'),
('p09', 'Penata Muda', 'III', 'A'),
('p10', 'Penata Muda Tingkat I', 'III', 'B'),
('p11', 'Penata', 'III', 'C'),
('p12', 'Penata Tingkat I', 'III', 'D'),
('p13', 'Pembina', 'IV', 'A'),
('p14', 'Pembina Tingkat I', 'IV', 'B'),
('p15', 'Pembina Utama Muda', 'IV', 'C'),
('p16', 'Pembina Utama Madya', 'IV', 'D'),
('p17', 'Pembina Utama', 'IV', 'E');

-- --------------------------------------------------------

--
-- Table structure for table `tbldatapengajupangkat`
--

CREATE TABLE `tbldatapengajupangkat` (
  `idPengajuPangkat` varchar(6) NOT NULL,
  `NIP` varchar(15) DEFAULT NULL,
  `pangkat_Lama` varchar(20) DEFAULT NULL,
  `pangkat_baru` varchar(20) DEFAULT NULL,
  `status` enum('TUNGGU','DITOLAK','DITERIMA') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbldatapengajupangkat`
--

INSERT INTO `tbldatapengajupangkat` (`idPengajuPangkat`, `NIP`, `pangkat_Lama`, `pangkat_baru`, `status`) VALUES
('p01', 'pegawai', 'P01', 'P02', 'DITOLAK');

-- --------------------------------------------------------

--
-- Table structure for table `tbldatapensiun`
--

CREATE TABLE `tbldatapensiun` (
  `idDataPensiun` varchar(6) NOT NULL DEFAULT '',
  `idPengajuPensiun` varchar(6) NOT NULL,
  `NIP` varchar(15) DEFAULT NULL,
  `nama` varchar(20) DEFAULT NULL,
  `tglPengajuan` date DEFAULT NULL,
  `tglBerlaku` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbldatariwayatpend`
--

CREATE TABLE `tbldatariwayatpend` (
  `idRp` varchar(6) NOT NULL,
  `NIP` varchar(15) NOT NULL,
  `tingkatPendidikan` varchar(40) DEFAULT NULL,
  `tempatPendidikan` varchar(40) DEFAULT NULL,
  `jurusan` varchar(50) DEFAULT NULL,
  `tglIjazah` date DEFAULT NULL,
  `thnMasuk` int(4) DEFAULT NULL,
  `thnLulus` int(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbldatariwayatpend`
--

INSERT INTO `tbldatariwayatpend` (`idRp`, `NIP`, `tingkatPendidikan`, `tempatPendidikan`, `jurusan`, `tglIjazah`, `thnMasuk`, `thnLulus`) VALUES
('drp1', 'admin', 'S1', 'UGM', 'D4 Teknologi Jaringan', '2016-05-28', 2012, 2016),
('drp2', 'rektor', 'S3', 'ITB', 'geologi', '2010-05-13', 2006, 2010),
('drp3', 'cinta', 'SD', 'SD Gedongtengen', 'IPA', '2016-05-13', 2002, 2008),
('drp4', 'taqim', 'SMP', 'SMP N Banjar', 'IPS', '2012-05-13', 2008, 2012),
('drp7', 'halim', 'S2', 'UI', 'Psikologi', '2016-05-19', 2012, 2016),
('drp8', 'pegawai', 'SMA', 'SMA Gaul', 'IPS', '2016-05-01', 2013, 2016);

-- --------------------------------------------------------

--
-- Table structure for table `tbldatauser`
--

CREATE TABLE `tbldatauser` (
  `idUser` varchar(6) NOT NULL,
  `NIP` varchar(15) DEFAULT NULL,
  `password` varchar(8) DEFAULT NULL,
  `type` enum('Admin','Rektor','Pegawai','Bagian Kepegawaian') DEFAULT NULL,
  `status` enum('Aktif','Non-Aktif') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbldatauser`
--

INSERT INTO `tbldatauser` (`idUser`, `NIP`, `password`, `type`, `status`) VALUES
('us1', 'admin', 'admin', 'Pegawai', 'Aktif'),
('us2', 'rektor', 'rektor', 'Rektor', 'Aktif'),
('us3', 'pegawai', 'pegawai', 'Pegawai', 'Aktif'),
('us4', 'halim', 'halim', 'Pegawai', 'Aktif'),
('us5', 'bk', 'bk', 'Pegawai', 'Aktif');

-- --------------------------------------------------------

--
-- Table structure for table `tblpengajupensiun`
--

CREATE TABLE `tblpengajupensiun` (
  `idPengajuPensiun` varchar(6) NOT NULL,
  `NIP` varchar(15) DEFAULT NULL,
  `status` enum('TUNGGU','DISETUJUI') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tblpengajupensiun`
--

INSERT INTO `tblpengajupensiun` (`idPengajuPensiun`, `NIP`, `status`) VALUES
('n2', 'pegawai', 'TUNGGU');

-- --------------------------------------------------------

--
-- Table structure for table `tblpesan`
--

CREATE TABLE `tblpesan` (
  `isiPesan` varchar(200) NOT NULL,
  `NIP` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tblpesan`
--

INSERT INTO `tblpesan` (`isiPesan`, `NIP`) VALUES
('naik pangkat bro', 'pegawai');

-- --------------------------------------------------------

--
-- Table structure for table `tblterimanaikpangkat`
--

CREATE TABLE `tblterimanaikpangkat` (
  `idTerima` varchar(6) NOT NULL,
  `idPengajuPangkat` varchar(6) NOT NULL,
  `NIP` varchar(15) DEFAULT NULL,
  `id_pangkatbaru` varchar(6) DEFAULT NULL,
  `tgl_pengajuan` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbltolaknaikpangkat`
--

CREATE TABLE `tbltolaknaikpangkat` (
  `idTolak` varchar(6) NOT NULL DEFAULT '',
  `idPengajuPangkat` varchar(6) NOT NULL,
  `NIP` varchar(15) DEFAULT NULL,
  `Ket` varchar(30) DEFAULT NULL,
  `tgl_Pengajuan` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbldataindukpeg`
--
ALTER TABLE `tbldataindukpeg`
  ADD PRIMARY KEY (`NIP`),
  ADD KEY `idPangkat` (`idPangkat`);

--
-- Indexes for table `tbldatakeluarga`
--
ALTER TABLE `tbldatakeluarga`
  ADD PRIMARY KEY (`idDk`),
  ADD KEY `NIP` (`NIP`);

--
-- Indexes for table `tbldatapangkat`
--
ALTER TABLE `tbldatapangkat`
  ADD PRIMARY KEY (`idPangkat`);

--
-- Indexes for table `tbldatapengajupangkat`
--
ALTER TABLE `tbldatapengajupangkat`
  ADD PRIMARY KEY (`idPengajuPangkat`),
  ADD KEY `NIP` (`NIP`);

--
-- Indexes for table `tbldatapensiun`
--
ALTER TABLE `tbldatapensiun`
  ADD PRIMARY KEY (`idDataPensiun`),
  ADD KEY `idPengajuPensiun` (`idPengajuPensiun`),
  ADD KEY `NIP` (`NIP`);

--
-- Indexes for table `tbldatariwayatpend`
--
ALTER TABLE `tbldatariwayatpend`
  ADD PRIMARY KEY (`idRp`),
  ADD KEY `NIP` (`NIP`);

--
-- Indexes for table `tbldatauser`
--
ALTER TABLE `tbldatauser`
  ADD PRIMARY KEY (`idUser`),
  ADD KEY `NIP` (`NIP`);

--
-- Indexes for table `tblpengajupensiun`
--
ALTER TABLE `tblpengajupensiun`
  ADD PRIMARY KEY (`idPengajuPensiun`),
  ADD KEY `NIP` (`NIP`);

--
-- Indexes for table `tblterimanaikpangkat`
--
ALTER TABLE `tblterimanaikpangkat`
  ADD PRIMARY KEY (`idTerima`),
  ADD KEY `idPengajuPangkat` (`idPengajuPangkat`),
  ADD KEY `idDip` (`NIP`),
  ADD KEY `id_pangkatbaru` (`id_pangkatbaru`);

--
-- Indexes for table `tbltolaknaikpangkat`
--
ALTER TABLE `tbltolaknaikpangkat`
  ADD PRIMARY KEY (`idTolak`),
  ADD KEY `idPengajuPangkat` (`idPengajuPangkat`),
  ADD KEY `NIP` (`NIP`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbldataindukpeg`
--
ALTER TABLE `tbldataindukpeg`
  ADD CONSTRAINT `tbldataindukpeg_ibfk_1` FOREIGN KEY (`idPangkat`) REFERENCES `tbldatapangkat` (`idPangkat`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tbldatakeluarga`
--
ALTER TABLE `tbldatakeluarga`
  ADD CONSTRAINT `tbldatakeluarga_ibfk_1` FOREIGN KEY (`NIP`) REFERENCES `tbldataindukpeg` (`NIP`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tbldatapengajupangkat`
--
ALTER TABLE `tbldatapengajupangkat`
  ADD CONSTRAINT `tbldatapengajupangkat_ibfk_1` FOREIGN KEY (`NIP`) REFERENCES `tbldataindukpeg` (`NIP`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tbldatapensiun`
--
ALTER TABLE `tbldatapensiun`
  ADD CONSTRAINT `tbldatapensiun_ibfk_1` FOREIGN KEY (`idPengajuPensiun`) REFERENCES `tblpengajupensiun` (`idPengajuPensiun`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tbldatapensiun_ibfk_2` FOREIGN KEY (`NIP`) REFERENCES `tbldataindukpeg` (`NIP`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tbldatariwayatpend`
--
ALTER TABLE `tbldatariwayatpend`
  ADD CONSTRAINT `tbldatariwayatpend_ibfk_1` FOREIGN KEY (`NIP`) REFERENCES `tbldataindukpeg` (`NIP`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tbldatauser`
--
ALTER TABLE `tbldatauser`
  ADD CONSTRAINT `tbldatauser_ibfk_1` FOREIGN KEY (`NIP`) REFERENCES `tbldataindukpeg` (`NIP`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tblpengajupensiun`
--
ALTER TABLE `tblpengajupensiun`
  ADD CONSTRAINT `tblpengajupensiun_ibfk_1` FOREIGN KEY (`NIP`) REFERENCES `tbldataindukpeg` (`NIP`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tblterimanaikpangkat`
--
ALTER TABLE `tblterimanaikpangkat`
  ADD CONSTRAINT `tblterimanaikpangkat_ibfk_2` FOREIGN KEY (`idPengajuPangkat`) REFERENCES `tbldatapengajupangkat` (`idPengajuPangkat`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tblterimanaikpangkat_ibfk_3` FOREIGN KEY (`NIP`) REFERENCES `tbldataindukpeg` (`NIP`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tblterimanaikpangkat_ibfk_4` FOREIGN KEY (`id_pangkatbaru`) REFERENCES `tbldataindukpeg` (`idPangkat`) ON UPDATE CASCADE;

--
-- Constraints for table `tbltolaknaikpangkat`
--
ALTER TABLE `tbltolaknaikpangkat`
  ADD CONSTRAINT `tbltolaknaikpangkat_ibfk_1` FOREIGN KEY (`idPengajuPangkat`) REFERENCES `tbldatapengajupangkat` (`idPengajuPangkat`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tbltolaknaikpangkat_ibfk_2` FOREIGN KEY (`NIP`) REFERENCES `tbldataindukpeg` (`NIP`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
