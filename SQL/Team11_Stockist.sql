CREATE DATABASE `Team11_Stockist` ;

use Team11_Stockist;
CREATE TABLE `user` (
  `userID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `userName` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`userID`),
  UNIQUE KEY `userid_UNIQUE` (`userID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

CREATE TABLE `administrator` (
  `adminID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userID` int(10) unsigned NOT NULL,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phoneNumber` int(11) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`adminID`),
  UNIQUE KEY `adminID_UNIQUE` (`adminID`),
  UNIQUE KEY `userID_UNIQUE` (`userID`),
  CONSTRAINT `userID` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

CREATE TABLE `mechanic` (
  `mechID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `userID` int(11) unsigned NOT NULL,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phoneNumber` int(11) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`mechID`),
  UNIQUE KEY `mechID_UNIQUE` (`mechID`),
  UNIQUE KEY `userID_UNIQUE` (`userID`),
  CONSTRAINT `user_ID` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

CREATE TABLE `supplier` (
  `supplierID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `supplierName` varchar(45) DEFAULT NULL,
  `contactNumber` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`supplierID`),
  UNIQUE KEY `supplierid_UNIQUE` (`supplierID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

CREATE TABLE `product` (
  `productID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `partNO` int(11) unsigned NOT NULL ,
  `productName` varchar(45) DEFAULT NULL,
  `unitPrice` float(11) DEFAULT NULL,
  `supplierID` int(11)unsigned NOT NULL,
`description` varchar(45) DEFAULT NULL,
`color` varchar(45) DEFAULT NULL,
`dimension` varchar(45) DEFAULT NULL,
`manufacturer` varchar(45) DEFAULT NULL,
`reorderLevel` varchar(45) DEFAULT NULL,
`minOrderQty` int(11) DEFAULT NULL,
`shelfLocation` varchar(100) DEFAULT NULL,
  `qty` int(11) DEFAULT NULL,
`damageQty` int(11) DEFAULT NULL,
  PRIMARY KEY (`productID`),
  UNIQUE KEY `productID_UNIQUE` (`productID`),
  KEY `supplierID_idx` (`supplierID`),
  CONSTRAINT `supplierID` FOREIGN KEY (`supplierID`) REFERENCES `supplier` (`supplierID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;


CREATE TABLE `reorder` (
  `orderID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `productID` int(11) unsigned NOT NULL,
  `partNO` int(11) unsigned NOT NULL,
  `supplierID` int(11) unsigned NOT NULL,
   `unitPrice` float(11) DEFAULT NULL,
   `minOrderQty` int(11) DEFAULT NULL,
   `reorderQty` int(11) DEFAULT NULL,
   `orderQty` int(11) DEFAULT NULL,
`qty` int(11) DEFAULT NULL, 
`price` float(11) DEFAULT NULL,
    `orderDate` date DEFAULT NULL,
  PRIMARY KEY (`orderID`),
  UNIQUE KEY `orderID_UNIQUE` (`orderID`),
  KEY `productId_idx` (`productId`),
  CONSTRAINT `productId` FOREIGN KEY (`productId`) REFERENCES `product` (`productId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `transaction` (
  `transactionID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `productID` int(11) unsigned NOT NULL,
  `mechID` int(11) unsigned NOT NULL,
   `customerName` varchar(45) DEFAULT NULL,
   `usage` int(11) DEFAULT NULL,
    `dateofUsage` date DEFAULT NULL,
  PRIMARY KEY (`transactionID`),
  CONSTRAINT `FK_productID` FOREIGN KEY (`productID`) REFERENCES `product` (`productID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `mechID` FOREIGN KEY (`mechID`) REFERENCES `mechanic` (`mechID`) ON DELETE CASCADE ON UPDATE CASCADE,
  UNIQUE KEY `transactionID_UNIQUE` (`transactionID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `team11_stockist`.`user` (`userID`, `userName`, `password`, `role`) VALUES ('1', 'Alexa', 'alexa', 'admin');
INSERT INTO `team11_stockist`.`user` (`userID`, `userName`, `password`, `role`) VALUES ('2', 'Xuxu', 'xuxu', 'admin');
INSERT INTO `team11_stockist`.`user` (`userID`, `userName`, `password`, `role`) VALUES ('3', 'Laylee', 'laylee', 'mechanic');
INSERT INTO `team11_stockist`.`user` (`userID`, `userName`, `password`, `role`) VALUES ('4', 'Lidanyang', 'lidanyang', 'mechanic');
INSERT INTO `team11_stockist`.`supplier` (`supplierID`, `supplierName`, `contactNumber`, `email`) VALUES ('1', 'Nissan', '110101', 'nissan@gmail.com');
INSERT INTO `team11_stockist`.`supplier` (`supplierID`, `supplierName`, `contactNumber`, `email`) VALUES ('2', 'Benz', '110102', 'benz@gmail.com');
INSERT INTO `team11_stockist`.`supplier` (`supplierID`, `supplierName`, `contactNumber`, `email`) VALUES ('3', 'Porsche', '110103', 'porsh@gmail.com');
INSERT INTO `team11_stockist`.`supplier` (`supplierID`, `supplierName`, `contactNumber`, `email`) VALUES ('4', 'Jaguar', '110104', 'jaguar@gmail.com');
INSERT INTO `team11_stockist`.`supplier` (`supplierID`, `supplierName`, `contactNumber`, `email`) VALUES ('5', 'Audi', '110105', 'audi@gmail.com');
INSERT INTO `team11_stockist`.`supplier` (`supplierID`, `supplierName`, `contactNumber`, `email`) VALUES ('6', 'Ferrari', '110106', 'Ferrari@gmail.com');
INSERT INTO `team11_stockist`.`supplier` (`supplierID`, `supplierName`, `contactNumber`, `email`) VALUES ('7', 'Tesla', '110109', 'tesla@gmail.com');
INSERT INTO `team11_stockist`.`supplier` (`supplierID`, `supplierName`, `contactNumber`, `email`) VALUES ('8', 'Martin', '111111', 'shiang@gmail.com');
INSERT INTO `team11_stockist`.`supplier` (`supplierID`, `supplierName`, `contactNumber`, `email`) VALUES ('9', 'Bentley', '222222', 'weaf@gmail.com');
INSERT INTO `team11_stockist`.`supplier` (`supplierID`, `supplierName`, `contactNumber`, `email`) VALUES ('10', 'Renault', '333333', 'renault@gmail.com');
INSERT INTO `team11_stockist`.`supplier` (`supplierID`, `supplierName`, `contactNumber`, `email`) VALUES ('11', 'Opel', '444444', 'opel@gmail.com');
INSERT INTO `team11_stockist`.`supplier` (`supplierID`, `supplierName`, `contactNumber`, `email`) VALUES ('12', 'Bugatti', '555555', 'bugati@gmail.com');
INSERT INTO `team11_stockist`.`supplier` (`supplierID`, `supplierName`, `contactNumber`, `email`) VALUES ('13', 'Infiniti', '666666', 'infiniti@gmail.com');
INSERT INTO `team11_stockist`.`supplier` (`supplierID`, `supplierName`, `contactNumber`, `email`) VALUES ('14', 'Lexus', '777777', 'lexus@gmail.com');
INSERT INTO `team11_stockist`.`supplier` (`supplierID`, `supplierName`, `contactNumber`, `email`) VALUES ('15', 'Lamborghini', '888888', 'lambora@gmail.com');


INSERT INTO `team11_stockist`.`administrator` (`adminID`, `userID`, `firstName`, `lastName`, `email`, `phoneNumber`, `address`, `description`) VALUES ('1', '1', 'Alexa', 'Zhou', 'alexazhou@gmail.com', '65652231', 'west cost dr', 'admin clerk');
INSERT INTO `team11_stockist`.`administrator` (`adminID`, `userID`, `firstName`, `lastName`, `email`, `phoneNumber`, `address`, `description`) VALUES ('2', '2', 'Xu', 'Xu', 'xuxu@gmail.com', '45456699', 'west cost dr', 'admin clerk');

INSERT INTO `team11_stockist`.`mechanic` (`mechID`, `userID`, `firstName`, `lastName`, `email`, `phoneNumber`, `address`, `description`) VALUES ('1', '3', 'Lay', 'Lee', 'laylee@gmail.com', '75758822', 'Nus iss', 'mechanic');
INSERT INTO `team11_stockist`.`mechanic` (`mechID`, `userID`, `firstName`, `lastName`, `email`, `phoneNumber`, `address`, `description`) VALUES ('2', '4', 'DanYang', 'Li', 'lidanyang@gmail.com', '65658844', 'Nus iss', 'mechanic');

INSERT INTO `team11_stockist`.`product` (`productID`, `partNO`, `productName`, `unitPrice`, `supplierID`, `description`, `color`, `dimension`, `manufacturer`, `reorderLevel`, `minOrderQty`, `shelfLocation`, `qty`) VALUES ('1', '1001', 'RAseat', '40', '1', 'One year warranty', 'black', 'L 10', 'Germany', '25', '10', 'A01BA', '30');
INSERT INTO `team11_stockist`.`product` (`productID`, `partNO`, `productName`, `unitPrice`, `supplierID`, `description`, `color`, `dimension`, `manufacturer`, `reorderLevel`, `minOrderQty`, `shelfLocation`, `qty`) VALUES ('2', '1001', 'RTseat', '40', '3', 'One year warranty', 'red', 'L 10', 'Germany', '25', '10', 'A01BB', '30');
INSERT INTO `team11_stockist`.`product` (`productID`, `partNO`, `productName`, `unitPrice`, `supplierID`, `description`, `color`, `dimension`, `manufacturer`, `reorderLevel`, `minOrderQty`, `shelfLocation`, `qty`) VALUES ('3', '1001', 'RCseat', '50', '4', 'One year warranty', 'red', 'L 10', 'Germany', '25', '10', 'A01BC', '30');
INSERT INTO `team11_stockist`.`product` (`productID`, `partNO`, `productName`, `unitPrice`, `supplierID`, `description`, `color`, `dimension`, `manufacturer`, `reorderLevel`, `minOrderQty`, `shelfLocation`, `qty`) VALUES ('4', '1001', 'ECseat', '50', '5', 'One year warranty', 'red', 'L 10', 'Germany', '25', '10', 'A01BD', '30');
INSERT INTO `team11_stockist`.`product` (`productID`, `partNO`, `productName`, `unitPrice`, `supplierID`, `description`, `color`, `dimension`, `manufacturer`, `reorderLevel`, `minOrderQty`, `shelfLocation`, `qty`) VALUES ('5', '2001', 'Oil Filter', '70', '3', 'One year warranty', 'black', '', 'Germany', '25', '10', 'B21CA', '50');
INSERT INTO `team11_stockist`.`product` (`productID`, `partNO`, `productName`, `unitPrice`, `supplierID`, `description`, `color`, `manufacturer`, `reorderLevel`, `minOrderQty`, `shelfLocation`, `qty`, `damageQty`) VALUES ('6', '2001', 'Oil Filter', '70', '6', 'One year warranty', 'red', 'Germany', '25', '10', 'B21CB', '49', '1');
INSERT INTO `team11_stockist`.`product` (`productID`, `partNO`, `productName`, `unitPrice`, `supplierID`, `description`, `color`, `manufacturer`, `reorderLevel`, `minOrderQty`, `shelfLocation`, `qty`) VALUES ('7', '2001', 'Oil Filter', '70', '7', 'One year warranty', 'red', 'Germany', '25', '10', 'B21CC', '50');
INSERT INTO `team11_stockist`.`product` (`productID`, `partNO`, `productName`, `unitPrice`, `supplierID`, `description`, `color`, `manufacturer`, `reorderLevel`, `minOrderQty`, `shelfLocation`, `qty`) VALUES ('8', '2001', 'Oil Filter SPR', '80', '8', 'One year warranty', 'red', 'Germany', '25', '10', 'B21CD', '50');
INSERT INTO `team11_stockist`.`product` (`productID`, `partNO`, `productName`, `unitPrice`, `supplierID`, `description`, `color`, `manufacturer`, `reorderLevel`, `minOrderQty`, `shelfLocation`, `qty`) VALUES ('9', '2001', 'Oil Filter TAC', '90', '3', 'One year warranty', 'red', 'Germany', '25', '10', 'B21CF', '50');
INSERT INTO `team11_stockist`.`product` (`productID`, `partNO`, `productName`, `unitPrice`, `supplierID`, `description`, `color`, `manufacturer`, `reorderLevel`, `minOrderQty`, `shelfLocation`, `qty`) VALUES ('10', '2001', 'Oil Filter CRC', '90', '2', 'One year warranty', 'black', 'Germany', '25', '10', 'B21CG', '50');
INSERT INTO `team11_stockist`.`product` (`productID`, `partNO`, `productName`, `unitPrice`, `supplierID`, `description`, `color`, `dimension`, `manufacturer`, `reorderLevel`, `minOrderQty`, `shelfLocation`, `qty`) VALUES ('11', '3001', 'Battery NM', '110', '5', 'Six month warranty', 'red', 'L 10', 'Germany', '15', '5', 'C34FE', '30');
INSERT INTO `team11_stockist`.`product` (`productID`, `partNO`, `productName`, `unitPrice`, `supplierID`, `description`, `color`, `dimension`, `manufacturer`, `reorderLevel`, `minOrderQty`, `shelfLocation`, `qty`) VALUES ('12', '3001', 'Battery NM', '110', '6', 'Six month warranty', 'red', 'L 10', 'Germany', '15', '5', 'C34ER', '30');
INSERT INTO `team11_stockist`.`product` (`productID`, `partNO`, `productName`, `unitPrice`, `supplierID`, `description`, `color`, `dimension`, `manufacturer`, `reorderLevel`, `minOrderQty`, `shelfLocation`, `qty`) VALUES ('13', '3001', 'Battery MD', '110', '7', 'Six month warranty', 'black', 'L 20', 'Germany', '15', '5', 'C34GE', '30');
INSERT INTO `team11_stockist`.`product` (`productID`, `partNO`, `productName`, `unitPrice`, `supplierID`, `description`, `color`, `dimension`, `manufacturer`, `reorderLevel`, `minOrderQty`, `shelfLocation`, `qty`) VALUES ('14', '3001', 'Battery MD', '110', '11', 'Six month warranty', 'white', 'L 20', 'Germany', '15', '5', 'C34FA', '30');
INSERT INTO `team11_stockist`.`product` (`productID`, `partNO`, `productName`, `unitPrice`, `supplierID`, `description`, `color`, `dimension`, `manufacturer`, `reorderLevel`, `minOrderQty`, `shelfLocation`, `qty`) VALUES ('15', '3001', 'Battery TR', '150', '12', 'Six month warranty', 'white', 'L 10', 'Germany', '15', '5', 'C34CV', '30');
INSERT INTO `team11_stockist`.`product` (`productID`, `partNO`, `productName`, `unitPrice`, `supplierID`, `description`, `color`, `dimension`, `manufacturer`, `reorderLevel`, `minOrderQty`, `shelfLocation`, `qty`, `damageQty`) VALUES ('16', '3001', 'Battery LG', '150', '14', 'Six month warranty', 'white', 'L 10', 'Germany', '15', '5', 'C34QW', '29', '1');
INSERT INTO `team11_stockist`.`product` (`productID`, `partNO`, `productName`, `unitPrice`, `supplierID`, `description`, `color`, `dimension`, `manufacturer`, `reorderLevel`, `minOrderQty`, `shelfLocation`, `qty`) VALUES ('17', '3001', 'Battery LG', '150', '13', 'Six month warranty', 'white', 'L 10', 'Germany', '15', '5', 'C34IO', '30');
INSERT INTO `team11_stockist`.`product` (`productID`, `partNO`, `productName`, `unitPrice`, `supplierID`, `description`, `color`, `dimension`, `manufacturer`, `reorderLevel`, `minOrderQty`, `shelfLocation`, `qty`) VALUES ('18', '4001', 'Air Filter', '30', '15', 'One year warranty', 'white', 'L 15', 'Germany', '15', '5', 'C34DA', '30');
INSERT INTO `team11_stockist`.`product` (`productID`, `partNO`, `productName`, `unitPrice`, `supplierID`, `description`, `color`, `dimension`, `manufacturer`, `reorderLevel`, `minOrderQty`, `shelfLocation`, `qty`) VALUES ('19', '4001', 'Air Filter', '30', '2', 'One year warranty', 'black', 'L 15', 'Germany', '20', '10', 'D50ZY', '25');
INSERT INTO `team11_stockist`.`product` (`productID`, `partNO`, `productName`, `unitPrice`, `supplierID`, `description`, `color`, `dimension`, `manufacturer`, `reorderLevel`, `minOrderQty`, `shelfLocation`, `qty`) VALUES ('20', '4001', 'Air Filter', '30', '3', 'One year warranty', 'white', 'L 15', 'Germany', '20', '10', 'D50YZ', '25');
INSERT INTO `team11_stockist`.`product` (`productID`, `partNO`, `productName`, `unitPrice`, `supplierID`, `description`, `color`, `dimension`, `manufacturer`, `reorderLevel`, `minOrderQty`, `shelfLocation`, `qty`) VALUES ('21', '4001', 'Air Filter', '30', '4', 'One year warranty', 'black', 'L 15', 'China', '20', '10', 'D50KX', '25');
INSERT INTO `team11_stockist`.`product` (`productID`, `partNO`, `productName`, `unitPrice`, `supplierID`, `description`, `color`, `dimension`, `manufacturer`, `reorderLevel`, `minOrderQty`, `shelfLocation`, `qty`) VALUES ('22', '4001', 'Air Filter', '30', '5', 'One year warranty', 'black', 'L 15', 'China', '20', '10', 'D50IC', '25');
INSERT INTO `team11_stockist`.`product` (`productID`, `partNO`, `productName`, `unitPrice`, `supplierID`, `description`, `color`, `dimension`, `manufacturer`, `reorderLevel`, `minOrderQty`, `shelfLocation`, `qty`) VALUES ('23', '4001', 'Air Filter', '45', '6', 'One year warranty', 'black', 'L 15', 'China', '20', '10', 'D50OP', '25');
INSERT INTO `team11_stockist`.`product` (`productID`, `partNO`, `productName`, `unitPrice`, `supplierID`, `description`, `color`, `dimension`, `manufacturer`, `reorderLevel`, `minOrderQty`, `shelfLocation`, `qty`) VALUES ('24', '4001', 'Air Filter', '45', '7', 'One year warranty', 'white', 'L 15', 'China', '20', '10', 'D50JZ', '25');
INSERT INTO `team11_stockist`.`product` (`productID`, `partNO`, `productName`, `unitPrice`, `supplierID`, `description`, `color`, `dimension`, `manufacturer`, `reorderLevel`, `minOrderQty`, `shelfLocation`, `qty`) VALUES ('25', '4001', 'Air Filter', '45', '8', 'One year warranty', 'white', 'L 15', 'China', '20', '10', 'D50PO', '25');
INSERT INTO `team11_stockist`.`product` (`productID`, `partNO`, `productName`, `unitPrice`, `supplierID`, `description`, `color`, `dimension`, `manufacturer`, `reorderLevel`, `minOrderQty`, `shelfLocation`, `qty`) VALUES ('26', '4001', 'Air Filter', '45', '9', 'One year warranty', 'white', 'L 15', 'China', '20', '10', 'D50ER', '25');
INSERT INTO `team11_stockist`.`product` (`productID`, `partNO`, `productName`, `unitPrice`, `supplierID`, `description`, `color`, `manufacturer`, `reorderLevel`, `minOrderQty`, `shelfLocation`, `qty`) VALUES ('27', '5001', 'Window Frame', '70', '2', 'Six month warranty', 'white', 'China', '10', '1', 'C45GZ', '15');
INSERT INTO `team11_stockist`.`product` (`productID`, `partNO`, `productName`, `unitPrice`, `supplierID`, `description`, `color`, `manufacturer`, `reorderLevel`, `minOrderQty`, `shelfLocation`, `qty`) VALUES ('28', '5001', 'Window Frame', '70', '3', 'Six month warranty', 'white', 'China', '10', '1', 'C45ZT', '15');
INSERT INTO `team11_stockist`.`product` (`productID`, `partNO`, `productName`, `unitPrice`, `supplierID`, `description`, `color`, `manufacturer`, `reorderLevel`, `minOrderQty`, `shelfLocation`, `qty`) VALUES ('29', '5001', 'Window Frame', '70', '4', 'Six month warranty', 'black', 'China', '10', '1', 'C45CB', '15');
INSERT INTO `team11_stockist`.`product` (`productID`, `partNO`, `productName`, `unitPrice`, `supplierID`, `description`, `color`, `manufacturer`, `reorderLevel`, `minOrderQty`, `shelfLocation`, `qty`) VALUES ('30', '5001', 'Window Frame', '70', '5', 'Six month warranty', 'black', 'China', '10', '1', 'C45PO', '15');
INSERT INTO `team11_stockist`.`product` (`productID`, `partNO`, `productName`, `unitPrice`, `supplierID`, `description`, `color`, `manufacturer`, `reorderLevel`, `minOrderQty`, `shelfLocation`, `qty`) VALUES ('31', '5001', 'Window Frame', '80', '6', 'Six month warranty', 'black', 'China', '10', '1', 'C45GZ', '15');
INSERT INTO `team11_stockist`.`product` (`productID`, `partNO`, `productName`, `unitPrice`, `supplierID`, `description`, `color`, `manufacturer`, `reorderLevel`, `minOrderQty`, `shelfLocation`, `qty`) VALUES ('32', '5001', 'Window Frame', '70', '12', 'Six month warranty', 'black', 'China', '10', '1', 'C45IC', '15');
INSERT INTO `team11_stockist`.`product` (`productID`, `partNO`, `productName`, `unitPrice`, `supplierID`, `description`, `color`, `manufacturer`, `reorderLevel`, `minOrderQty`, `shelfLocation`, `qty`) VALUES ('33', '5001', 'Window Frame', '90', '11', 'Six month warranty', 'white', 'China', '10', '1', 'C45ID', '15');
INSERT INTO `team11_stockist`.`product` (`productID`, `partNO`, `productName`, `unitPrice`, `supplierID`, `description`, `color`, `manufacturer`, `reorderLevel`, `minOrderQty`, `shelfLocation`, `qty`) VALUES ('34', '5001', 'Window Frame', '70', '10', 'Six month warranty', 'white', 'China', '10', '1', 'C45ID', '15');
INSERT INTO `team11_stockist`.`product` (`productID`, `partNO`, `productName`, `unitPrice`, `supplierID`, `description`, `color`, `manufacturer`, `reorderLevel`, `minOrderQty`, `shelfLocation`, `qty`) VALUES ('35', '5001', 'Window Frame', '70', '5', 'Six month warranty', 'black', 'China', '10', '1', 'C45OP', '15');
INSERT INTO `team11_stockist`.`product` (`productID`, `partNO`, `productName`, `unitPrice`, `supplierID`, `description`, `color`, `manufacturer`, `reorderLevel`, `minOrderQty`, `shelfLocation`, `qty`, `damageQty`) VALUES ('36', '6001', 'Tail Light', '45', '15', 'One year warranty', 'black', 'China', '30', '15', 'H56SD', '23', '2');
INSERT INTO `team11_stockist`.`product` (`productID`, `partNO`, `productName`, `unitPrice`, `supplierID`, `description`, `color`, `manufacturer`, `reorderLevel`, `minOrderQty`, `shelfLocation`, `qty`) VALUES ('37', '6001', 'Tail Light', '45', '14', 'One year warranty', 'black', 'China', '30', '15', 'H56CX', '25');
INSERT INTO `team11_stockist`.`product` (`productID`, `partNO`, `productName`, `unitPrice`, `supplierID`, `description`, `color`, `manufacturer`, `reorderLevel`, `minOrderQty`, `shelfLocation`, `qty`) VALUES ('38', '6001', 'Tail Light', '45', '2', 'One year warranty', 'white', 'China', '30', '15', 'H56ID', '25');
INSERT INTO `team11_stockist`.`product` (`productID`, `partNO`, `productName`, `unitPrice`, `supplierID`, `description`, `color`, `manufacturer`, `reorderLevel`, `minOrderQty`, `shelfLocation`, `qty`) VALUES ('39', '6001', 'Tail Light', '60', '5', 'One year warranty', 'white', 'China', '30', '15', 'H56ZY', '25');
INSERT INTO `team11_stockist`.`product` (`productID`, `partNO`, `productName`, `unitPrice`, `supplierID`, `description`, `color`, `manufacturer`, `reorderLevel`, `minOrderQty`, `shelfLocation`, `qty`) VALUES ('40', '6001', 'Tail Light', '60', '7', 'One year warranty', 'white', 'China', '30', '15', 'H56OP', '25');

