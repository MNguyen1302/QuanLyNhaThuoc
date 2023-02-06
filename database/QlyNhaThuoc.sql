-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Apr 25, 2022 at 11:47 AM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `QlyNhaThuoc`
--

-- --------------------------------------------------------

--
-- Table structure for table `ChiTietKM`
--

CREATE TABLE `ChiTietKM` (
  `MaKM` varchar(10) NOT NULL,
  `MaThuoc` varchar(10) NOT NULL,
  `TiLeKM` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `ChiTietPNH`
--

CREATE TABLE `ChiTietPNH` (
  `MaPNH` varchar(10) NOT NULL,
  `MaThuoc` varchar(10) NOT NULL,
  `SoLuongNhap` int(5) NOT NULL,
  `DonGiaNhap` int(10) NOT NULL,
  `ThanhTien` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `CTHD`
--

CREATE TABLE `CTHD` (
  `MaHD` varchar(10) NOT NULL,
  `MaThuoc` varchar(10) NOT NULL,
  `SoLuong` int(10) NOT NULL,
  `DonGia` int(20) NOT NULL,
  `ThanhTien` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `HoaDon`
--

CREATE TABLE `HoaDon` (
  `MaHD` varchar(10) NOT NULL,
  `MaKH` varchar(10) NOT NULL,
  `MaNV` varchar(10) NOT NULL,
  `NgayLap` date NOT NULL,
  `TongTien` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `KhachHang`
--

CREATE TABLE `KhachHang` (
  `MaKH` varchar(10) NOT NULL,
  `HoTen` varchar(50) NOT NULL,
  `SDT` int(10) NOT NULL,
  `DiaChi` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `KhuyenMai`
--

CREATE TABLE `KhuyenMai` (
  `MaKM` varchar(10) NOT NULL,
  `TenKM` varchar(50) NOT NULL,
  `NgayBatDau` date NOT NULL,
  `NgayKetThuc` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `LoaiThuoc`
--

CREATE TABLE `LoaiThuoc` (
  `MaLoaiThuoc` varchar(10) NOT NULL,
  `TenLoaiThuoc` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `LoaiThuoc`
--

INSERT INTO `LoaiThuoc` (`MaLoaiThuoc`, `TenLoaiThuoc`) VALUES
('L001', 'Thuốc kháng dị ứng'),
('L002', 'Thuốc kháng viêm'),
('L003', 'Thuốc cảm lạnh'),
('L004', 'Thuốc da liễu'),
('L005', 'Thuốc mắt/tai/mũi'),
('L006', 'Thuốc tiêu hóa'),
('L007', 'Thuốc giảm đau, hạ sốt'),
('L008', 'Thuốc thần kinh'),
('L009', 'Thuốc cơ xương khớp'),
('L010', 'Vitamin & khoáng chất'),
('L011', 'Thuốc dành cho nữ'),
('L012', 'Thuốc dành cho nam'),
('L013', 'Thuốc da liễu'),
('L014', 'Thuốc kháng sinh');

-- --------------------------------------------------------

--
-- Table structure for table `NCC`
--

CREATE TABLE `NCC` (
  `MaNCC` varchar(10) NOT NULL,
  `TenNCC` varchar(50) NOT NULL,
  `SDT` int(10) NOT NULL,
  `DiaChi` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `NCC`
--

INSERT INTO `NCC` (`MaNCC`, `TenNCC`, `SDT`, `DiaChi`) VALUES
('NCC004', 'Công ty cổ phần dược Hậu Giang (DHG)', 292389143, '288 Nguyễn Văn Cừ, Q. Ninh Kiều, TP. Cần Thơ'),
('NCC1', 'Công ty TNHH Mediphar USA', 92910899, '93 Đất Thánh, F6, Tân Bình, Tp.HCM'),
('NCC2', 'Công ty cổ phần Traphaco', 18006612, '75 Yên Ninh, Ba Đình, Hà Nội, Việt Nam'),
('NCC3', 'Công ty cổ phần dược phẩm Hà Tây', 433522525, '10A Quang Trung – Hà Đông – Hà Nội');

-- --------------------------------------------------------

--
-- Table structure for table `NhanVien`
--

CREATE TABLE `NhanVien` (
  `MaNV` varchar(10) NOT NULL,
  `HoTen` varchar(50) NOT NULL,
  `SDT` int(10) NOT NULL,
  `GioiTinh` int(1) NOT NULL,
  `MaCaLamViec` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `PhieuNhapHang`
--

CREATE TABLE `PhieuNhapHang` (
  `MaPNH` varchar(10) NOT NULL,
  `MaNV` varchar(10) NOT NULL,
  `MaNCC` varchar(10) NOT NULL,
  `NgayLapPhieu` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `Thuoc`
--

CREATE TABLE `Thuoc` (
  `MaThuoc` varchar(10) NOT NULL,
  `TenThuoc` varchar(50) NOT NULL,
  `DonGia` int(10) NOT NULL,
  `DonViTinh` varchar(20) NOT NULL,
  `SoLuong` int(10) NOT NULL,
  `NgaySanXuat` date NOT NULL,
  `HanSuDung` date NOT NULL,
  `MaLoaiThuoc` varchar(10) NOT NULL,
  `TrangThai` varchar(30) NOT NULL,
  `Anh` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Thuoc`
--

INSERT INTO `Thuoc` (`MaThuoc`, `TenThuoc`, `DonGia`, `DonViTinh`, `SoLuong`, `NgaySanXuat`, `HanSuDung`, `MaLoaiThuoc`, `TrangThai`, `Anh`) VALUES
('TH001', 'Loxfen 60mg', 150000, 'Hộp', 150, '2022-04-01', '2022-10-16', 'L002', 'Còn hàng', 'loxfen.jpg'),
('TH002', 'Aleradin 25mg', 190000, 'Hộp', 200, '2022-04-01', '2022-04-30', 'L001', 'Còn hàng', 'aleradin.jpg'),
('TH003', 'Antilox Forte 20g', 69900, 'Hộp', 150, '2022-04-02', '2022-04-12', 'L006', 'Còn hàng', 'antilox.jpg'),
('TH004', 'Biragan 500mg', 46000, 'Hộp', 300, '2022-05-05', '2022-12-10', 'L007', 'Còn hàng', ''),
('TH005', 'Barudon 10ml', 4500, 'Gói', 500, '2022-04-01', '2023-07-05', 'L006', 'Còn hàng', ''),
('TH006', 'Aleucin 500mg', 30000, 'Hộp', 250, '2022-04-01', '2022-04-30', 'L008', 'Còn hàng', ''),
('TH007', 'Kodemin', 120000, 'Hộp', 300, '2022-04-13', '2023-10-13', 'L003', 'Còn hàng', ''),
('TH008', 'Clogin elle', 305000, 'Hộp', 250, '2022-04-01', '2022-04-30', 'L011', 'Còn hàng', ''),
('TH009', 'Paracetamol', 40000, 'Hộp', 500, '2022-04-01', '2022-04-30', 'L007', 'Còn hàng', 'paracetamol.jpg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ChiTietKM`
--
ALTER TABLE `ChiTietKM`
  ADD PRIMARY KEY (`MaKM`,`MaThuoc`),
  ADD KEY `MaThuoc` (`MaThuoc`),
  ADD KEY `MaKM` (`MaKM`);

--
-- Indexes for table `ChiTietPNH`
--
ALTER TABLE `ChiTietPNH`
  ADD PRIMARY KEY (`MaPNH`,`MaThuoc`),
  ADD KEY `MaThuoc` (`MaThuoc`),
  ADD KEY `MaPNH` (`MaPNH`);

--
-- Indexes for table `CTHD`
--
ALTER TABLE `CTHD`
  ADD PRIMARY KEY (`MaHD`,`MaThuoc`),
  ADD KEY `MaHD` (`MaHD`,`MaThuoc`),
  ADD KEY `MaThuoc` (`MaThuoc`);

--
-- Indexes for table `HoaDon`
--
ALTER TABLE `HoaDon`
  ADD PRIMARY KEY (`MaHD`),
  ADD UNIQUE KEY `MaKH` (`MaKH`,`MaNV`),
  ADD KEY `MaNV` (`MaNV`);

--
-- Indexes for table `KhachHang`
--
ALTER TABLE `KhachHang`
  ADD PRIMARY KEY (`MaKH`);

--
-- Indexes for table `KhuyenMai`
--
ALTER TABLE `KhuyenMai`
  ADD PRIMARY KEY (`MaKM`);

--
-- Indexes for table `LoaiThuoc`
--
ALTER TABLE `LoaiThuoc`
  ADD PRIMARY KEY (`MaLoaiThuoc`);

--
-- Indexes for table `NCC`
--
ALTER TABLE `NCC`
  ADD PRIMARY KEY (`MaNCC`);

--
-- Indexes for table `NhanVien`
--
ALTER TABLE `NhanVien`
  ADD PRIMARY KEY (`MaNV`);

--
-- Indexes for table `PhieuNhapHang`
--
ALTER TABLE `PhieuNhapHang`
  ADD PRIMARY KEY (`MaPNH`),
  ADD KEY `MaNV` (`MaNV`),
  ADD KEY `MaNCC` (`MaNCC`);

--
-- Indexes for table `Thuoc`
--
ALTER TABLE `Thuoc`
  ADD PRIMARY KEY (`MaThuoc`),
  ADD KEY `MaLoaiThuoc` (`MaLoaiThuoc`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ChiTietKM`
--
ALTER TABLE `ChiTietKM`
  ADD CONSTRAINT `ChiTietKM_ibfk_1` FOREIGN KEY (`MaKM`) REFERENCES `KhuyenMai` (`MaKM`),
  ADD CONSTRAINT `ChiTietKM_ibfk_2` FOREIGN KEY (`MaThuoc`) REFERENCES `Thuoc` (`MaThuoc`);

--
-- Constraints for table `ChiTietPNH`
--
ALTER TABLE `ChiTietPNH`
  ADD CONSTRAINT `ChiTietPNH_ibfk_1` FOREIGN KEY (`MaPNH`) REFERENCES `PhieuNhapHang` (`MaPNH`),
  ADD CONSTRAINT `ChiTietPNH_ibfk_2` FOREIGN KEY (`MaThuoc`) REFERENCES `Thuoc` (`MaThuoc`);

--
-- Constraints for table `CTHD`
--
ALTER TABLE `CTHD`
  ADD CONSTRAINT `CTHD_ibfk_1` FOREIGN KEY (`MaHD`) REFERENCES `HoaDon` (`MaHD`),
  ADD CONSTRAINT `CTHD_ibfk_2` FOREIGN KEY (`MaThuoc`) REFERENCES `Thuoc` (`MaThuoc`);

--
-- Constraints for table `HoaDon`
--
ALTER TABLE `HoaDon`
  ADD CONSTRAINT `HoaDon_ibfk_1` FOREIGN KEY (`MaKH`) REFERENCES `KhachHang` (`MaKH`),
  ADD CONSTRAINT `HoaDon_ibfk_2` FOREIGN KEY (`MaNV`) REFERENCES `NhanVien` (`MaNV`);

--
-- Constraints for table `NhanVien`
--
ALTER TABLE `NhanVien`
  ADD CONSTRAINT `NhanVien_ibfk_1` FOREIGN KEY (`MaCaLamViec`) REFERENCES `CaLamViec` (`MaCaLamViec`);

--
-- Constraints for table `PhieuNhapHang`
--
ALTER TABLE `PhieuNhapHang`
  ADD CONSTRAINT `PhieuNhapHang_ibfk_1` FOREIGN KEY (`MaNV`) REFERENCES `NhanVien` (`MaNV`),
  ADD CONSTRAINT `PhieuNhapHang_ibfk_2` FOREIGN KEY (`MaNCC`) REFERENCES `NCC` (`MaNCC`);

--
-- Constraints for table `Thuoc`
--
ALTER TABLE `Thuoc`
  ADD CONSTRAINT `Thuoc_ibfk_1` FOREIGN KEY (`MaLoaiThuoc`) REFERENCES `LoaiThuoc` (`MaLoaiThuoc`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
