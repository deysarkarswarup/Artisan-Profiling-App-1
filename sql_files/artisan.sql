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
-- Table structure for table `artisan`
--

CREATE TABLE `artisan` (
  `id` int(100) NOT NULL,
  `name` varchar(500) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `profilePicture` varchar(500) DEFAULT NULL,
  `artisanVideoUrl` varchar(500) DEFAULT NULL,
  `productDescriptionVideoUrl` varchar(500) DEFAULT NULL,
  `experience` int(10) DEFAULT NULL,
  `overview` varchar(500) DEFAULT NULL,
  `district` varchar(50) DEFAULT NULL,
  `addressLine1` varchar(500) DEFAULT NULL,
  `addressLine2` varchar(500) DEFAULT NULL,
  `pinCode` varchar(50) DEFAULT NULL,
  `landMark` varchar(500) DEFAULT NULL,
  `gender` varchar(50) DEFAULT NULL,
  `isTrainer` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `artisan`
--
ALTER TABLE `artisan`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `artisan`
--
ALTER TABLE `artisan`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=106;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
