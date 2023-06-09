/*
 * Copyright (c) 2023.  Yaser Rodriguez
 * yaser.rguez@gmail.com
 * LastUpdate: 6/8/23, 11:44 PM
 *
 */

/*
 * Copyright (c) 2023.  Yaser Rodriguez
 * yaser.rguez@gmail.com
 * LastUpdate: 6/8/23, 3:03 PM
 *
 */

/*
 * Copyright (c) 2023.  Yaser Rodriguez
 * yaser.rguez@gmail.com
 * LastUpdate: 6/8/23, 1:04 PM
 *
 */

insert into T_CONTACT (ID, version, CREATED_DATE, LAST_MODIFIED_DATE, ENABLED, FIRST_NAME, SECOND_NAME, DATE_OF_BIRTH) values (101, 5, '2022-08-28 14:12:27', '2022-08-28 14:12:27', true, 'Udale', 'Phyllys', '2020-06-08 14:12:27');
insert into T_CONTACT (ID, version, CREATED_DATE, LAST_MODIFIED_DATE, ENABLED, FIRST_NAME, SECOND_NAME, DATE_OF_BIRTH) values (102, 4, '2022-08-28 14:12:27', '2022-08-28 14:12:27', true, 'Madge', 'Dorolisa', '2021-06-08 14:12:27');
insert into T_CONTACT (ID, version, CREATED_DATE, LAST_MODIFIED_DATE, ENABLED, FIRST_NAME, SECOND_NAME, DATE_OF_BIRTH) values (103, 3, '2022-08-28 14:12:27', '2022-08-28 14:12:27', false, 'Culver', 'Erma', '2022-06-08 14:12:27');

insert into T_PHONE (ID, NUMBER, CONTACT_ID) values (100, '511 426 7182', 101);
insert into T_PHONE (ID, NUMBER, CONTACT_ID) values (101, '511 426 7182', 101);
insert into T_PHONE (ID, NUMBER, CONTACT_ID) values (102, '579 384 6237', 102);
insert into T_PHONE (ID, NUMBER, CONTACT_ID) values (103, '419 977 1026', 103);
insert into T_PHONE (ID, NUMBER, CONTACT_ID) values (104, '256 295 4996', 103);
insert into T_PHONE (ID, NUMBER, CONTACT_ID) values (105, '200 294 4927', 103);

insert into T_ADDRESS (ID, CONTACT_ID, STREET, HOUSE_NUMBER, BETWEEN1, BETWEEN2, TOWN, DISTRICT, STATE, CONTRY) values (100, 101, 'Forest', 38, 'David', 'Golf View', 'Taquara', 'Gualeguaychú', 'Gualeguaychú', 'Brazil');
insert into T_ADDRESS (ID, CONTACT_ID, STREET, HOUSE_NUMBER, BETWEEN1, BETWEEN2, TOWN, DISTRICT, STATE, CONTRY) values (101, 101, 'Glacier Hill', 6, 'Vera', 'Bobwhite', 'Zebbug', 'Baturaden', 'Baturaden', 'Malta');
insert into T_ADDRESS (ID, CONTACT_ID, STREET, HOUSE_NUMBER, BETWEEN1, BETWEEN2, TOWN, DISTRICT, STATE, CONTRY) values (102, 102, 'Sachs', 72, 'Prairie Rose', 'Del Sol', 'Zhuting', 'Belajen', 'Belajen', 'China');
insert into T_ADDRESS (ID, CONTACT_ID, STREET, HOUSE_NUMBER, BETWEEN1, BETWEEN2, TOWN, DISTRICT, STATE, CONTRY) values (103, 103, 'Sachs', 72, 'Prairie Rose', 'Del Sol', 'Zhuting', 'Belajen', 'Belajen', 'China');

insert into T_PHOTO (CONTACT_ID, URL) values (101, 'https://robohash.org/reprehenderitveniamamet.png?size=50x50&set=set1');
insert into T_PHOTO (CONTACT_ID, URL) values (102, 'https://robohash.org/utautsunt.png?size=50x50&set=set1');
insert into T_PHOTO (CONTACT_ID, URL) values (103, 'https://robohash.org/adipisciquisoptio.png?size=50x50&set=set1');
