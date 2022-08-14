-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 14, 2022 at 03:07 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `assignment1`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `customerid` varchar(255) NOT NULL,
  `fullname` varchar(255) NOT NULL,
  `phoneno` varchar(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `typeofcontact` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customerid`, `fullname`, `phoneno`, `email`, `typeofcontact`) VALUES
('01133931031', 'Muhammad Haziq Fiqri Bin Norhasmi', '01133931031', 'haziq.fiqri.4417@gmail.com', 2),
('01133931032', 'Haziq Fiqri', '01133931032', 'EthoSylar1990@gmail.com', 1),
('01133931035', 'Muhammad Haziq Fiqri Bin Norhasmi', '01133931035', 'haziq.fiqri.4417@gmail.com', 2),
('12345', 'admin@gmail.com', '12345', 'Administrator', 1);

-- --------------------------------------------------------

--
-- Table structure for table `ticket`
--

CREATE TABLE `ticket` (
  `ticketid` varchar(255) NOT NULL,
  `typeofpurchase` varchar(255) NOT NULL,
  `timeframe` varchar(255) DEFAULT NULL,
  `product` varchar(255) NOT NULL,
  `ticketdate` date NOT NULL,
  `minbudget` double(10,2) NOT NULL,
  `maxbudget` double(10,2) NOT NULL,
  `comments` text NOT NULL DEFAULT 'None',
  `customerid` varchar(255) NOT NULL,
  `quantity` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ticket`
--

INSERT INTO `ticket` (`ticketid`, `typeofpurchase`, `timeframe`, `product`, `ticketdate`, `minbudget`, `maxbudget`, `comments`, `customerid`, `quantity`) VALUES
('0907202201133931032', 'Gaming', 'Not yet decided', 'PC', '2022-07-09', 67.00, 68.00, '', '01133931032', 30),
('0907202201133931035', 'Gaming', 'Less than 2 weeks', 'PC', '2022-07-09', 10000.00, 100000.00, 'Viper Mini', '01133931035', 10);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customerid`);

--
-- Indexes for table `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`ticketid`),
  ADD KEY `customerid` (`customerid`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ticket`
--
ALTER TABLE `ticket`
  ADD CONSTRAINT `ticket_ibfk_1` FOREIGN KEY (`customerid`) REFERENCES `customer` (`customerid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
