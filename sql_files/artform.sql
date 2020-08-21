-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 21, 2020 at 11:04 PM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.4.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `artisan-profiling`
--

-- --------------------------------------------------------

--
-- Table structure for table `artform`
--

CREATE TABLE `artform` (
  `id` int(100) NOT NULL,
  `artFormName` varchar(500) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `picture` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `artform`
--

INSERT INTO `artform` (`id`, `artFormName`, `description`, `picture`) VALUES
(1, 'কাঁথা স্টিচ', NULL, NULL),
(2, 'বাটিক', NULL, NULL),
(3, 'চামড়ার কাজ', NULL, NULL),
(4, 'কাঠের কাজ', NULL, NULL),
(5, 'পেইন্টিং', NULL, NULL),
(6, 'গয়না তৈরী', NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `artform`
--
ALTER TABLE `artform`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `artform`
--
ALTER TABLE `artform`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
