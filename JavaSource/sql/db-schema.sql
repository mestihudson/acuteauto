/********************EXECUTE SEQUENCE 2********************/

-- ----------------------------
-- Table structure for "MAKE"
-- ----------------------------
DROP TABLE MAKE;
CREATE TABLE MAKE (
MAKE_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
NAME VARCHAR(60) NOT NULL,
DESCRIPTION VARCHAR(100),
YEAR_START INT NOT NULL,
YEAR_END INT
);

-- ----------------------------
-- Table structure for "MODEL"
-- ----------------------------
DROP TABLE MODEL;
CREATE TABLE MODEL (
MODEL_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
NAME VARCHAR(60) NOT NULL,
DESCRIPTION VARCHAR(100),
YEAR_START INT NOT NULL,
YEAR_END INT,
MAKE_ID INT NOT NULL
);

-- ----------------------------
-- Table structure for "STYLE"
-- ----------------------------
DROP TABLE STYLE;
CREATE TABLE STYLE (
STYLE_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
NAME VARCHAR(60) NOT NULL,
DESCRIPTION VARCHAR(100),
MPG_CITY INT,
MPG_HIGHWAY INT,
VEHICLE_TYPE INT(3) NOT NULL, -- SEDAN, WAGON, CROSSOVER, LUXURY, COUPE, HATCHBACK, SUV, HYBRID ETC..
YEAR_START INT NOT NULL,
YEAR_END INT,
MODEL_ID INT NOT NULL
);

-- ----------------------------
-- Table structure for "CATEGORY"
-- ----------------------------
DROP TABLE CATEGORY;
CREATE TABLE CATEGORY (
CATEGORY_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
NAME VARCHAR(60) NOT NULL,
DESCRIPTION VARCHAR(100),
PARENT_ID INT,
CREATE_DATE TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
CREATED_BY INT NOT NULL
);

-- ----------------------------
-- Table structure for "VEHICLE"
-- ----------------------------
DROP TABLE VEHICLE;
CREATE TABLE VEHICLE (
VEHICLE_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
NAME VARCHAR(60) NOT NULL,
DESCRIPTION VARCHAR(100),
YEAR INT NOT NULL,
MAKE_ID INT NOT NULL,
MODEL_ID INT NOT NULL,
STYLE_ID INT NOT NULL,
ENGINE VARCHAR(60) NOT NULL,
TRANSMISSION VARCHAR(60) NOT NULL,
VIN VARCHAR(60),
MILEAGE INT NOT NULL,
PRICE DECIMAL(8, 2) NOT NULL,
COLOR_EXT VARCHAR(60) NOT NULL,
COLOR_INT VARCHAR(60),
INTERIOR_TYPE INT(3) NOT NULL, -- LEATHER, CLOTH
WARRANTY_TYPE INT(3), -- STANDARD, EXTENDED
WARRANTY_TERM INT, -- EX: IN MONTHS 12, 24, 36, 48, 60
WARRANTY_MILES INT, -- EX: 30000, 50000, 100000
STATUS INT(3) NOT NULL, -- NEW, USED
ADDITIONAL_INFO VARCHAR(1000),
CREATE_DATE TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
CREATED_BY INT NOT NULL
);

-- ----------------------------
-- Table structure for "FEATURE"
-- ----------------------------
DROP TABLE FEATURE_GROUP;
CREATE TABLE FEATURE_GROUP (
FEATURE_GROUP_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
NAME VARCHAR(60) NOT NULL,
DISPLAY_AS INT(3), -- CHECKBOX: CAN SELECT MORE THAN ONE VALUE, RADIOBUTTON: SELECT ONLY ONE VALUE.
DESCRIPTION VARCHAR(100),
PARENT_ID INT -- REFERS TO THE FEATURE_GROUP_ID TO PROVIDE SUPPORT FOR SUB-GROUPING
);

-- ----------------------------
-- Table structure for "FEATURE_VALUE"
-- ----------------------------
DROP TABLE FEATURE;
CREATE TABLE FEATURE (
FEATURE_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
FEATURE_VALUE VARCHAR(100),
MAKE_ID INT, -- IF VALUE INSERTED HERE, THIS WILL BE SHOWN ONLY FOR THE SPECIFIED MAKES. IF NULL, THEN WILL BE SHOWN FOR ALL. EX: ACURALINK
FEATURE_GROUP_ID INT NOT NULL
);

-- ----------------------------
-- Table structure for "IMAGE"
-- ----------------------------
DROP TABLE IMAGE;
CREATE TABLE IMAGE (
IMAGE_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
NAME VARCHAR(60) NOT NULL,
DESCRIPTION VARCHAR(100),
IMAGE_EXTENSION VARCHAR(10),
MIME_TYPE VARCHAR(40),
IMAGE_LOCATION VARCHAR(100),
IMAGE_TYPE INT(3), -- PRIMARY
ADVERTISE TINYINT(1),
VEHICLE_ID INT NOT NULL,
CREATE_DATE TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- ----------------------------
-- Table structure for "ADVERTISEMENT"
-- ----------------------------
DROP TABLE ADVERTISEMENT;
CREATE TABLE ADVERTISEMENT (
ADVERTISEMENT_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
EFFECTIVE_DATE DATE NOT NULL,
EXPIRY_DATE DATE,
UNIT_PRICE DECIMAL(8, 2),
UNITS INT(3), -- PRICE PER UNIT WHICH CAN BE: HOURLY, DAILY, WEEKLY, MONTHLY ETC. 
VEHICLE_ID INT NOT NULL, -- REFERS TO THE VEHICLE WHICH NEEDS TO BE ADVERTISED.
CREATED_BY INT NOT NULL, -- REFERS TO THE USER WHO IS ADVERTISING THE VEHICLE. CAN BE EITHER CLIENT OR CUSTOMER.
CREATE_DATE TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);


-- ----------------------------
-- MANY TO MANY RELATIONSHIP --
-- ----------------------------

-- ----------------------------
-- Table structure for "RL_VEHICLE_CATEGORY"
-- ----------------------------
DROP TABLE RL_VEHICLE_CATEGORY;
CREATE TABLE RL_VEHICLE_CATEGORY (
VEHICLE_ID INT NOT NULL,
CATEGORY_ID INT NOT NULL,
PRIMARY KEY(VEHICLE_ID, CATEGORY_ID)
);

-- ----------------------------
-- Table structure for "RL_VEHICLE_FEATURE"
-- ----------------------------
DROP TABLE RL_VEHICLE_FEATURE;
CREATE TABLE RL_VEHICLE_FEATURE (
VEHICLE_ID INT NOT NULL,
FEATURE_ID INT NOT NULL,
PRIMARY KEY(VEHICLE_ID, FEATURE_ID)
);

-- ----------------------------
-- Table structure for "RL_STYLE_FEATURE"
-- ----------------------------
DROP TABLE RL_STYLE_FEATURE;
CREATE TABLE RL_STYLE_FEATURE (
STYLE_ID INT NOT NULL,
FEATURE_ID INT NOT NULL,
PRIMARY KEY(STYLE_ID, FEATURE_ID)
);
