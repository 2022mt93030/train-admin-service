INSERT INTO `trainadmindb`.`station` (`code`, `name`) VALUES ("DD", "Daund");
INSERT INTO `trainadmindb`.`station` (`code`, `name`) VALUES ("PUN", "Pune");
INSERT INTO `trainadmindb`.`station` (`code`, `name`) VALUES ("SHN", "Shivaji Nagar");
INSERT INTO `trainadmindb`.`station` (`code`, `name`) VALUES ("CV", "Chinchvad");
INSERT INTO `trainadmindb`.`station` (`code`, `name`) VALUES ("LV", "Lonavala");
INSERT INTO `trainadmindb`.`station` (`code`, `name`) VALUES ("KD", "Khandala");
INSERT INTO `trainadmindb`.`station` (`code`, `name`) VALUES ("KAR", "Karjat");
INSERT INTO `trainadmindb`.`station` (`code`, `name`) VALUES ("KY", "Kalyan");
INSERT INTO `trainadmindb`.`station` (`code`, `name`) VALUES ("TN", "Thane");
INSERT INTO `trainadmindb`.`station` (`code`, `name`) VALUES ("DDR", "Dadar");
INSERT INTO `trainadmindb`.`station` (`code`, `name`) VALUES ("CST", "Chatrapati Shivaji Terminus");


INSERT INTO `trainadmindb`.`train_capacity`(`train_num`,`travel_class`,`total_seats`,`travel_date`)VALUES(1001,"AC3",20,null);
INSERT INTO `trainadmindb`.`train_capacity`(`train_num`,`travel_class`,`total_seats`,`travel_date`)VALUES(1001,"SL",50,null);
INSERT INTO `trainadmindb`.`train_capacity`(`train_num`,`travel_class`,`total_seats`,`travel_date`)VALUES(1001,"AC2",10,null);

INSERT INTO `trainadmindb`.`train_capacity`(`train_num`,`travel_class`,`total_seats`,`travel_date`)VALUES(1002,"SL",50,null);
INSERT INTO `trainadmindb`.`train_capacity`(`train_num`,`travel_class`,`total_seats`,`travel_date`)VALUES(1002,"AC3",30,null);

INSERT INTO `trainadmindb`.`train_capacity`(`train_num`,`travel_class`,`total_seats`,`travel_date`)VALUES(1004,"AC3",30,null);

INSERT INTO `trainadmindb`.`train_capacity`(`train_num`,`travel_class`,`total_seats`,`travel_date`)VALUES(1005,"AC3",30,null);

INSERT INTO `trainadmindb`.`train`(`id`, `name`, `frequency`, `route_id`) VALUES (1001, "Deccan Express", "ALL", 1111);
INSERT INTO `trainadmindb`.`train`(`id`, `name`, `frequency`, `route_id`) VALUES (1002, "Pune Special", "ALL", 1111);
INSERT INTO `trainadmindb`.`train`(`id`, `name`, `frequency`, `route_id`) VALUES (1004, "CST VISTADOME", "SAT, SUN", 1111);
INSERT INTO `trainadmindb`.`train`(`id`, `name`, `frequency`, `route_id`) VALUES (1005, "Pune Fast", "SAT, SUN", 1111);


INSERT INTO `trainadmindb`.`route`(`id`,`name`) VALUES(1111,"PUNE-CST");
INSERT INTO `trainadmindb`.`route`(`id`,`name`) VALUES(1112,"DAUND-CST");

INSERT INTO `trainadmindb`.`route_station`(`route_id`,`station_code`,`sequence_no`)VALUES(1111,PUN,1);
INSERT INTO `trainadmindb`.`route_station`(`route_id`,`station_code`,`sequence_no`)VALUES(1111,SHN,2);
INSERT INTO `trainadmindb`.`route_station`(`route_id`,`station_code`,`sequence_no`)VALUES(1111,CV,3);
INSERT INTO `trainadmindb`.`route_station`(`route_id`,`station_code`,`sequence_no`)VALUES(1111,LV,4);
INSERT INTO `trainadmindb`.`route_station`(`route_id`,`station_code`,`sequence_no`)VALUES(1111,KD,5);
NSERT INTO `trainadmindb`.`route_station`(`route_id`,`station_code`,`sequence_no`)VALUES(1111,KAR,6);
INSERT INTO `trainadmindb`.`route_station`(`route_id`,`station_code`,`sequence_no`)VALUES(1111,KY,7);
INSERT INTO `trainadmindb`.`route_station`(`route_id`,`station_code`,`sequence_no`)VALUES(1111,TN,8);
INSERT INTO `trainadmindb`.`route_station`(`route_id`,`station_code`,`sequence_no`)VALUES(1111,DDR,9);
INSERT INTO `trainadmindb`.`route_station`(`route_id`,`station_code`,`sequence_no`)VALUES(1111,CST,10);

INSERT INTO `trainadmindb`.`route_station`(`route_id`,`station_code`,`sequence_no`)VALUES(1112,DD,1);
INSERT INTO `trainadmindb`.`route_station`(`route_id`,`station_code`,`sequence_no`)VALUES(1112,PUN,2);



INSERT INTO `trainadmindb`.`train_station` (`station_stop`, `train_num`, `route_no`)VALUES("PUN",1001,1111);
INSERT INTO `trainadmindb`.`train_station` (`station_stop`, `train_num`, `route_no`)VALUES("SHN",1001,1111);
INSERT INTO `trainadmindb`.`train_station` (`station_stop`, `train_num`, `route_no`)VALUES("KAR",1001,1111);
INSERT INTO `trainadmindb`.`train_station` (`station_stop`, `train_num`, `route_no`)VALUES("DDR",1001,1111);
INSERT INTO `trainadmindb`.`train_station` (`station_stop`, `train_num`, `route_no`)VALUES("CST",1001,1111);


INSERT INTO `trainadmindb`.`train_station` (`station_stop`, `train_num`, `route_no`)VALUES("PUN",1002,1111);
INSERT INTO `trainadmindb`.`train_station` (`station_stop`, `train_num`, `route_no`)VALUES("KAR",1002,1111);
INSERT INTO `trainadmindb`.`train_station` (`station_stop`, `train_num`, `route_no`)VALUES("DDR",1002,1111);
INSERT INTO `trainadmindb`.`train_station` (`station_stop`, `train_num`, `route_no`)VALUES("CST",1002,1111);


INSERT INTO `trainadmindb`.`train_station` (`station_stop`, `train_num`, `route_no`)VALUES("PUN",1004,1111);
INSERT INTO `trainadmindb`.`train_station` (`station_stop`, `train_num`, `route_no`)VALUES("DDR",1004,1111);

INSERT INTO `trainadmindb`.`train_station` (`station_stop`, `train_num`, `route_no`)VALUES("CST",1005,1111);
INSERT INTO `trainadmindb`.`train_station` (`station_stop`, `train_num`, `route_no`)VALUES("PUN",1005,1111);