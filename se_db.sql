-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Dec 13, 2021 at 05:25 PM
-- Server version: 8.0.17
-- PHP Version: 7.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `se_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `emp_id` int(11) NOT NULL,
  `title` varchar(5) NOT NULL,
  `name` varchar(45) NOT NULL,
  `role` varchar(11) NOT NULL,
  `nic` varchar(11) NOT NULL,
  `email` varchar(45) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `uname` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL DEFAULT 'asdf1234',
  `logged_in` tinyint(4) NOT NULL DEFAULT '0',
  `last_logged_in` datetime NOT NULL,
  `availability` tinyint(4) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`emp_id`, `title`, `name`, `role`, `nic`, `email`, `phone`, `uname`, `password`, `logged_in`, `last_logged_in`, `availability`) VALUES
(1, 'Mr.', 'A.B.C.D. Perera', 'Admin', '941234567V', 'thaka@gmail.com', '0761234567', 'abcp', 'asdf1234', 0, '2021-12-13 22:52:23', 1),
(2, 'Mr.', 'W.D.S. Wijesekera', 'Admin', '954512751V', 'dayans@gmail.com', '0762214589', 'dayans', 'abcd1234', 0, '2021-04-22 11:34:10', 1),
(3, 'Mr.', 'Kalana', 'Others', '965647345V', 'gune@gmail.com', '0755643657', 'kgune', 'asdf1234', 0, '2021-12-13 22:51:55', 1),
(4, 'Ms.', 'gayani', 'Others', '960682325V', 'gayani@gmail.com', '0770235569', '960682325V', 'asdf1234', 0, '0000-00-00 00:00:00', 1),
(5, 'Mr.', 'Kalhara', 'Admin', '960682522V', 'kalhara96@gmail.com', '0770583374', '960682522V', 'asdf1234', 0, '0000-00-00 00:00:00', 1),
(6, 'Ms.', 'Dora', 'Others', '965474235V', 'dora@gmail.com', '0758895412', '965474235V', 'asdf1234', 0, '0000-00-00 00:00:00', 0),
(7, 'Mr.', 'Lari', 'Others', '958655412V', 'lariin@ymail.com', '0785541254', '958655412V', 'asdf1234', 0, '0000-00-00 00:00:00', 1),
(8, 'Ms.', 'Alex', 'Others', '975412845V', 'alaxa@live.com', '0757541254', '975412845V', 'asdf1234', 0, '0000-00-00 00:00:00', 1),
(9, 'Mr.', 'Aaaa', 'Admin', '961458452V', 'aaaaaa@live.com', '0352214586', '961458452V', 'asdf1234', 0, '0000-00-00 00:00:00', 1),
(10, 'Mr.', 'Loki', 'Others', '987654323V', 'loki@gmail.com', '0767654323', '987654323V', 'asdf1234', 0, '0000-00-00 00:00:00', 0),
(11, 'Mr.', 'loki', 'Others', '987654321V', 'loki@gmail.com', '0767876543', '987654321V', 'asdf1234', 0, '0000-00-00 00:00:00', 0),
(12, 'Mr.', 'loki', 'null', '987654321V', 'loki@gmail.com', '0765432123', '987654321V', 'asdf1234', 0, '0000-00-00 00:00:00', 0),
(13, 'Mr.', 'loki', 'Others', '987654321V', 'loki@gmail.com', '0765543212', '987654321V', 'asdf1234', 0, '0000-00-00 00:00:00', 1);

-- --------------------------------------------------------

--
-- Table structure for table `emp_email`
--

CREATE TABLE `emp_email` (
  `email` varchar(45) NOT NULL,
  `employee_emp_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `emp_email`
--

INSERT INTO `emp_email` (`email`, `employee_emp_id`) VALUES
('abcp@gmail.com', 1),
('perera96@gmail.com', 1);

-- --------------------------------------------------------

--
-- Table structure for table `emp_phone`
--

CREATE TABLE `emp_phone` (
  `phone` varchar(15) NOT NULL,
  `employee_emp_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `emp_phone`
--

INSERT INTO `emp_phone` (`phone`, `employee_emp_id`) VALUES
('0765543276', 1),
('0786754356', 1);

-- --------------------------------------------------------

--
-- Table structure for table `grn`
--

CREATE TABLE `grn` (
  `grn_id` int(11) NOT NULL,
  `net_total` double NOT NULL,
  `made_date` datetime NOT NULL,
  `special_notes` varchar(256) DEFAULT NULL,
  `supplier_sup_id` int(11) NOT NULL,
  `employee_emp_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `grn`
--

INSERT INTO `grn` (`grn_id`, `net_total`, `made_date`, `special_notes`, `supplier_sup_id`, `employee_emp_id`) VALUES
(1, 5750.5, '2021-04-27 22:46:52', '', 2, 1),
(2, 1500, '2021-04-27 23:21:13', '', 3, 1),
(3, 170151, '2021-04-28 09:29:03', '', 4, 1),
(4, 4450.5, '2021-04-28 10:49:31', '', 3, 1),
(5, 49960.5, '2021-04-28 11:09:43', '', 3, 1),
(6, 1500, '2021-04-28 13:11:07', '', 2, 1),
(7, 7500, '2021-08-29 14:53:18', 'Test Note', 3, 1),
(8, 342350, '2021-08-29 14:57:56', '', 2, 1),
(9, 463800, '2021-08-30 21:13:28', 'Test', 3, 1),
(10, 328500, '2021-12-01 22:18:04', '', 4, 1),
(11, 44450, '2021-12-13 21:18:58', '', 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `grn_has_item`
--

CREATE TABLE `grn_has_item` (
  `grn_grn_id` int(11) NOT NULL,
  `item_item_id` int(11) NOT NULL,
  `item_qty` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `grn_has_item`
--

INSERT INTO `grn_has_item` (`grn_grn_id`, `item_item_id`, `item_qty`) VALUES
(1, 6, 2),
(1, 7, 1),
(1, 5, 1),
(2, 6, 1),
(3, 6, 2),
(3, 5, 2),
(3, 8, 1),
(4, 6, 2),
(4, 5, 1),
(5, 6, 13),
(5, 5, 21),
(6, 6, 1),
(7, 1, 2),
(7, 13, 3),
(8, 3, 1),
(8, 8, 2),
(9, 13, 3),
(9, 3, 2),
(9, 9, 2),
(10, 8, 2),
(11, 3, 3),
(11, 13, 2),
(11, 2, 5);

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE `item` (
  `item_id` int(11) NOT NULL,
  `category` varchar(45) NOT NULL,
  `item_name` varchar(45) NOT NULL,
  `unit_price` double NOT NULL,
  `net_qty` int(11) NOT NULL,
  `warranty` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `item`
--

INSERT INTO `item` (`item_id`, `category`, `item_name`, `unit_price`, `net_qty`, `warranty`) VALUES
(1, 'Battery', 'UPS Battery-ABM 12V/7A', 1950, 4, '6 months'),
(2, 'Battery', 'Battery-Sony CMOS 2032 ', 100, 11, '10 months'),
(3, 'Monitor', 'Asus 19.5\" VS207DF LED ', 13850, 6, '3 year'),
(4, 'Keyboard', 'A4 Tech KM-720 USB', 1250, 0, '1year'),
(5, 'Keyboard', 'Dell KB216-BK-US USB', 1450.5, 30, '6 months'),
(6, 'Keyboard', 'Delux K6010 Sinhala/Tamil', 1500, 30, '1 year'),
(7, 'Keyboard', 'Flexible USB', 1300, 0, '6 months'),
(8, 'Laptop', 'Acer A315 i7/8GB/1TB/2GV/W10H', 164250, 6, '2 years'),
(9, 'Laptop', 'Asus FA5061 R7/8/512/4/W10H', 216250, 9, '2 years'),
(11, 'Motherboard', 'Gigabyte Z490 gaming x ATX 10th Gen motherboa', 42000, 3, '2 years'),
(13, 'Keyboard', 'A4 Tech KM-720 USB', 1200, 10, '1 year'),
(14, 'Mouse', 'Gforce X-729 GR5 USB mouse', 3000, 17, '2 years');

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `sup_id` int(11) NOT NULL,
  `sup_title` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `company` varchar(45) NOT NULL,
  `sup_name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nic` varchar(11) NOT NULL,
  `email` varchar(45) NOT NULL,
  `phone` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`sup_id`, `sup_title`, `company`, `sup_name`, `nic`, `email`, `phone`) VALUES
(2, 'Mr.', 'CBA Company', 'M.B.M. Karunarathna', '951236598V', 'madudx@gmail.com', '0770562235'),
(3, 'Mr.', 'ABC company', 'K.P.S. De Silve', '123659585V', 'gdgdsg@gmail.com', '0552365597'),
(4, 'Mr.', 'Shockwavez studio', 'Alex', '945212545V', 'swalexa@gmail.com', '0812541896');

-- --------------------------------------------------------

--
-- Table structure for table `sup_email`
--

CREATE TABLE `sup_email` (
  `email` varchar(45) NOT NULL,
  `supplier_sup_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `sup_phone`
--

CREATE TABLE `sup_phone` (
  `phone` varchar(15) NOT NULL,
  `supplier_sup_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `trans_id` int(11) NOT NULL,
  `net_qty` int(11) NOT NULL,
  `net_total` double NOT NULL,
  `made_date` datetime NOT NULL,
  `employee_emp_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`trans_id`, `net_qty`, `net_total`, `made_date`, `employee_emp_id`) VALUES
(1, 0, 167250, '2021-03-07 11:03:20', 1),
(2, 0, 167700, '2021-03-07 11:09:08', 1),
(3, 0, 20851, '2021-03-07 11:27:42', 1),
(4, 0, 20651, '2021-03-07 11:29:36', 1),
(5, 0, 168451, '2021-03-07 11:33:44', 1),
(6, 0, 168800, '2021-03-07 11:35:02', 1),
(7, 0, 17950, '2021-03-07 11:35:55', 1),
(8, 0, 558600, '2021-03-07 11:53:47', 1),
(9, 0, 572450, '2021-03-07 11:58:12', 1),
(10, 0, 27700, '2021-03-07 11:58:27', 1),
(11, 0, 2800, '2021-03-07 11:58:58', 1),
(12, 0, 4450.5, '2021-03-07 12:10:58', 1),
(13, 0, 5901, '2021-03-07 12:13:39', 1),
(14, 0, 5901, '2021-03-07 12:16:30', 1),
(15, 0, 5901, '2021-03-07 12:19:09', 1),
(16, 4, 5901, '2021-03-07 12:31:51', 1),
(17, 7, 452400, '2021-03-07 13:10:03', 1),
(18, 4, 5901, '2021-03-07 13:10:22', 1),
(19, 8, 171750, '2021-03-07 14:25:33', 1),
(20, 2, 2950.5, '2021-03-16 09:50:27', 1),
(21, 1, 13850, '2021-04-22 21:00:58', 1),
(22, 6, 333550, '2021-04-22 23:20:36', 1),
(23, 10, 403401, '2021-04-26 10:36:29', 1),
(24, 3, 167250, '2021-04-26 11:09:12', 1),
(25, 1, 1450.5, '2021-04-27 18:36:08', 1),
(26, 1, 1250, '2021-04-27 20:41:54', 1),
(27, 1, 1500, '2021-04-27 20:52:50', 1),
(28, 1, 1500, '2021-04-27 21:03:31', 1),
(29, 1, 1500, '2021-04-27 21:04:57', 1),
(30, 2, 2750, '2021-04-27 21:07:21', 1),
(31, 7, 171150.5, '2021-04-27 21:08:13', 1),
(32, 1, 1500, '2021-04-27 21:09:40', 1),
(33, 1, 1500, '2021-04-27 21:30:51', 1),
(34, 1, 1500, '2021-04-27 21:49:40', 1),
(35, 9, 401900.5, '2021-04-27 22:10:17', 1),
(36, 5, 47550.5, '2021-04-27 22:20:27', 1),
(37, 2, 2800, '2021-04-28 09:27:35', 1),
(38, 1, 42000, '2021-04-28 09:31:12', 1),
(39, 1, 1500, '2021-04-28 10:46:41', 1),
(40, 1, 1500, '2021-04-28 13:09:23', 1),
(41, 1, 1500, '2021-04-28 13:13:56', 1),
(42, 4, 5901, '2021-08-30 21:10:46', 1),
(43, 2, 3000, '2021-09-06 21:19:25', 1),
(44, 3, 16751, '2021-12-13 21:14:53', 1),
(45, 1, 1500, '2021-12-13 21:16:38', 1);

-- --------------------------------------------------------

--
-- Table structure for table `transaction_has_item`
--

CREATE TABLE `transaction_has_item` (
  `transaction_trans_id` int(11) NOT NULL,
  `item_item_id` int(11) NOT NULL,
  `item_qty` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `transaction_has_item`
--

INSERT INTO `transaction_has_item` (`transaction_trans_id`, `item_item_id`, `item_qty`) VALUES
(9, 8, 2),
(9, 3, 2),
(9, 9, 1),
(10, 3, 2),
(11, 2, 2),
(11, 7, 2),
(12, 5, 1),
(12, 6, 2),
(13, 6, 2),
(13, 5, 2),
(14, 5, 2),
(14, 6, 2),
(15, 5, 2),
(15, 6, 2),
(16, 6, 2),
(16, 5, 2),
(17, 3, 1),
(17, 9, 2),
(17, 6, 1),
(17, 7, 2),
(17, 1, 1),
(18, 5, 2),
(18, 6, 2),
(19, 8, 1),
(19, 2, 2),
(19, 6, 4),
(19, 7, 1),
(20, 5, 1),
(20, 6, 1),
(21, 3, 1),
(22, 2, 1),
(22, 6, 2),
(22, 1, 1),
(22, 8, 2),
(23, 5, 2),
(23, 6, 1),
(23, 3, 1),
(23, 9, 1),
(23, 7, 2),
(23, 8, 1),
(23, 1, 1),
(23, 2, 1),
(24, 8, 1),
(24, 6, 2),
(25, 5, 1),
(26, 4, 1),
(27, 6, 1),
(28, 6, 1),
(29, 6, 1),
(30, 6, 1),
(30, 4, 1),
(31, 4, 1),
(31, 2, 1),
(31, 5, 1),
(31, 6, 1),
(31, 7, 2),
(31, 8, 1),
(32, 6, 1),
(33, 6, 1),
(34, 6, 1),
(35, 1, 1),
(35, 7, 1),
(35, 6, 1),
(35, 5, 1),
(35, 2, 1),
(35, 9, 1),
(35, 3, 1),
(35, 8, 1),
(35, 4, 1),
(36, 6, 1),
(36, 7, 2),
(36, 11, 1),
(36, 5, 1),
(37, 6, 1),
(37, 7, 1),
(38, 11, 1),
(39, 6, 1),
(40, 6, 1),
(41, 6, 1),
(42, 5, 2),
(42, 6, 2),
(43, 6, 2),
(44, 5, 2),
(44, 3, 1),
(45, 6, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`emp_id`),
  ADD UNIQUE KEY `emp_id_UNIQUE` (`emp_id`);

--
-- Indexes for table `emp_email`
--
ALTER TABLE `emp_email`
  ADD KEY `fk_emp_email_employee1_idx` (`employee_emp_id`);

--
-- Indexes for table `emp_phone`
--
ALTER TABLE `emp_phone`
  ADD KEY `fk_emp_phone_employee_idx` (`employee_emp_id`);

--
-- Indexes for table `grn`
--
ALTER TABLE `grn`
  ADD PRIMARY KEY (`grn_id`),
  ADD UNIQUE KEY `grn_id_UNIQUE` (`grn_id`),
  ADD KEY `fk_grn_supplier1_idx` (`supplier_sup_id`),
  ADD KEY `fk_grn_employee1_idx` (`employee_emp_id`);

--
-- Indexes for table `grn_has_item`
--
ALTER TABLE `grn_has_item`
  ADD KEY `fk_grn_has_item_item1_idx` (`item_item_id`),
  ADD KEY `fk_grn_has_item_grn1_idx` (`grn_grn_id`);

--
-- Indexes for table `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`item_id`),
  ADD UNIQUE KEY `item_id_UNIQUE` (`item_id`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`sup_id`),
  ADD UNIQUE KEY `sup_id_UNIQUE` (`sup_id`);

--
-- Indexes for table `sup_email`
--
ALTER TABLE `sup_email`
  ADD KEY `fk_sup_email_supplier1_idx` (`supplier_sup_id`);

--
-- Indexes for table `sup_phone`
--
ALTER TABLE `sup_phone`
  ADD KEY `fk_sup_phone_supplier1_idx` (`supplier_sup_id`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`trans_id`),
  ADD UNIQUE KEY `trans_id_UNIQUE` (`trans_id`),
  ADD KEY `fk_transaction_employee1_idx` (`employee_emp_id`);

--
-- Indexes for table `transaction_has_item`
--
ALTER TABLE `transaction_has_item`
  ADD KEY `fk_transaction_has_item_item1_idx` (`item_item_id`),
  ADD KEY `fk_transaction_has_item_transaction1_idx` (`transaction_trans_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `emp_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `grn`
--
ALTER TABLE `grn`
  MODIFY `grn_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `item`
--
ALTER TABLE `item`
  MODIFY `item_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `supplier`
--
ALTER TABLE `supplier`
  MODIFY `sup_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `transaction`
--
ALTER TABLE `transaction`
  MODIFY `trans_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `emp_email`
--
ALTER TABLE `emp_email`
  ADD CONSTRAINT `fk_emp_email_employee1` FOREIGN KEY (`employee_emp_id`) REFERENCES `employee` (`emp_id`);

--
-- Constraints for table `emp_phone`
--
ALTER TABLE `emp_phone`
  ADD CONSTRAINT `fk_emp_phone_employee` FOREIGN KEY (`employee_emp_id`) REFERENCES `employee` (`emp_id`);

--
-- Constraints for table `grn`
--
ALTER TABLE `grn`
  ADD CONSTRAINT `fk_grn_employee1` FOREIGN KEY (`employee_emp_id`) REFERENCES `employee` (`emp_id`),
  ADD CONSTRAINT `fk_grn_supplier1` FOREIGN KEY (`supplier_sup_id`) REFERENCES `supplier` (`sup_id`);

--
-- Constraints for table `grn_has_item`
--
ALTER TABLE `grn_has_item`
  ADD CONSTRAINT `fk_grn_has_item_grn1` FOREIGN KEY (`grn_grn_id`) REFERENCES `grn` (`grn_id`),
  ADD CONSTRAINT `fk_grn_has_item_item1` FOREIGN KEY (`item_item_id`) REFERENCES `item` (`item_id`);

--
-- Constraints for table `sup_email`
--
ALTER TABLE `sup_email`
  ADD CONSTRAINT `fk_sup_email_supplier1` FOREIGN KEY (`supplier_sup_id`) REFERENCES `supplier` (`sup_id`);

--
-- Constraints for table `sup_phone`
--
ALTER TABLE `sup_phone`
  ADD CONSTRAINT `fk_sup_phone_supplier1` FOREIGN KEY (`supplier_sup_id`) REFERENCES `supplier` (`sup_id`);

--
-- Constraints for table `transaction`
--
ALTER TABLE `transaction`
  ADD CONSTRAINT `fk_transaction_employee1` FOREIGN KEY (`employee_emp_id`) REFERENCES `employee` (`emp_id`);

--
-- Constraints for table `transaction_has_item`
--
ALTER TABLE `transaction_has_item`
  ADD CONSTRAINT `fk_transaction_has_item_item1` FOREIGN KEY (`item_item_id`) REFERENCES `item` (`item_id`),
  ADD CONSTRAINT `fk_transaction_has_item_transaction1` FOREIGN KEY (`transaction_trans_id`) REFERENCES `transaction` (`trans_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
