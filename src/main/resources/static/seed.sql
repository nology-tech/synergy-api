INSERT INTO users (userID, firstName, lastName, email, address_houseNum,
address_streetName, address_city, address_state, address_postCode,
isContactFlag, createDateTime)
VALUES
(1000000,  'Samantha',  'Brooks',  'sbrooks@test.com',  '1',
'Columbus Circle',  'New York',  'NY',  '10019',  false,  sysdate() ),
(1234560,  'Roberto',  'Hoopero',  'test@test.com',  '45',
'East 25th St',  'New York',  'NY',  '10010',  true,  sysdate() ),
(1234561,  'Will',  'Boosby',  'test1@test.com',  '3177',
'Design Cast Walk',  'Henderson',  'NV',  '89044',  true,
sysdate() ),
(1234562,  'Olliesworth',  'Holdensburg The Fourth',
'test2@test.com',  '5',
'East 55th St',  'New York',  'NY',  '10016',  true,  now() ),
(1000002,  'Ollie',  'Holden',  'ollie@test.com',  '100',
'Columbus Circle',  'New York',  'NY',  '10019',  true,  sysdate() ),
(1000004,  'Monica',  'Torres',  'monica@test.com',  '104',
'Columbus Circle',  'New York',  'NY',  '10019',  true,  sysdate() );

INSERT INTO user_contact (userid, contactid) VALUES
(1000000,  1234560),
(1000000,  1234561),
(1000000,  1234562),
(1000000, 1000002),
(1000002, 1234560),
(1000002, 1234561),
(1234560, 1000002),
(1000002, 1000004);

INSERT INTO account (accountID,  sortCode,  userID, currencyID, IBAN,
accountType,  accountStatus,  accountBalance,  dateCreated)
VALUES
(1000002, '03', 1000002, 'EUR', 'GB10HLFX1100011000005',
'Checking', 'Active',  8000.00, now()),
(10840366, '01', 1000000, 'USD', 'GB10HLFX1100011000000',
'Checking', 'Active', 10000.00, now()),
(02205254, '04', 1234560, 'GBP', 'GB56NWBK60600402205254',
'Checking', 'Active',  10000.00, now()),
(1, '02', 1234561, 'GBP', 'GB56NWBK60600402205255',
'Checking', 'Active',  18000.00, now()),
(2, '03', 1234562, 'AUD', 'GB56NWBK60600402205256',
'Checking', 'Active',  28000.00, now()),
(1000004, '01', 1000004, 'USD', 'GB10HLFX1100011000008',
'Checking', 'Active',  8000.00, now());