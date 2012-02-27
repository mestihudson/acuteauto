/********************EXECUTE SEQUENCE 1********************/

/********************CREATE NEW DB USER****************/
CREATE USER 'newuser'@'localhost' IDENTIFIED BY 'some_pass';
GRANT ALL PRIVILEGES ON *.* TO 'newuser'@'localhost' WITH GRANT OPTION;

/******************** USER_INFO **********************/
DROP TABLE USER_INFO;
CREATE TABLE USER_INFO(
	USER_INFO_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	FIRST_NAME VARCHAR(60) NOT NULL,
	MIDDLE_NAME VARCHAR(60),
	LAST_NAME VARCHAR(60) NOT NULL,
	USER_NAME VARCHAR(40) NOT NULL,
	PASSWORD VARCHAR(100) NOT NULL,
	USER_TYPE INT(3) NOT NULL, -- DEALER, CUSTOMER 
	STATUS INT(3) NOT NULL, -- ACTIVE, SUSPENDED, CANCELLED
	LAST_LOGIN_DATE DATE,
	CREATE_DATE TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	ROLE_ID INT NOT NULL,
	CLIENT_ID INT	
);

-- ----------------------------
-- Table structure for "LOCATION"
-- ----------------------------
DROP TABLE LOCATION;
CREATE TABLE LOCATION (
LOCATION_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
LOCATION_TYPE INT(3), -- PRIMARY, SECONDARY
LOCATION_DESC VARCHAR(100),
ADDRESS1 VARCHAR(100) NOT NULL,
ADDRESS2 VARCHAR(100),
ZIP VARCHAR(5) NOT NULL,
CITY VARCHAR(20) NOT NULL,
STATE VARCHAR(2) NOT NULL,
HOME_PHONE VARCHAR(10),
CELL_PHONE VARCHAR(10),
BUS_NUMBER VARCHAR(10),
EMAIL VARCHAR(100) NOT NULL,
COUNTRY VARCHAR(20) NOT NULL,
USER_INFO_ID INT,
CLIENT_ID INT 
);

-- ----------------------------
-- Table structure for "CLIENT"
-- ----------------------------
DROP TABLE CLIENT;
CREATE TABLE CLIENT (
CLIENT_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
CLIENT_NAME VARCHAR(60) NOT NULL,
CLIENT_DESC VARCHAR(200),
YEAR_ESTD INT(4),
REGISTERED_NAME VARCHAR(60)
);

-- ----------------------------
-- Table structure for "ROLE"
-- ----------------------------
DROP TABLE ROLE;
CREATE TABLE ROLE (
ROLE_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
ROLE_NAME VARCHAR(25) NOT NULL ,
DESCRIPTION VARCHAR(200) NULL 
);


-- ----------------------------
-- Table structure for "PRIVILEGE"
-- ----------------------------
DROP TABLE PRIVILEGE;
CREATE TABLE PRIVILEGE (
PRIVILEGE_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
PRIV_NAME VARCHAR(25) NOT NULL ,
PRIV_CODE VARCHAR(20) NOT NULL ,
PRIV_DESC VARCHAR(100),
TRAN_URI VARCHAR(100) -- URI WITHOUT CONTEXTPATH
);

-- ----------------------------
-- Table structure for "RL_ROLE_PRIVILEGE"
-- ----------------------------
DROP TABLE RL_ROLE_PRIVILEGE;
CREATE TABLE RL_ROLE_PRIVILEGE (
ROLE_ID INT NOT NULL ,
PRIVILEGE_ID INT NOT NULL,
PRIMARY KEY(ROLE_ID, PRIVILEGE_ID)
);

-- ----------------------------
-- Table structure for "ENUM_TYPE"
-- ----------------------------
DROP TABLE ENUM_TYPE;
CREATE TABLE ENUM_TYPE(
	ENUM_TYPE_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	CODE_NAME VARCHAR(40) NOT NULL,
	SHORT_DESC VARCHAR(100),
	LONG_DESC VARCHAR(200)	
);

-- ----------------------------
-- Table structure for "ENUM"
-- ----------------------------
DROP TABLE ENUM;
CREATE TABLE ENUM(
	ENUM_TYPE_ID INT NOT NULL,
	ENUM_VALUE VARCHAR(60) NOT NULL,
	SHORT_DESC VARCHAR(100),
	LONG_DESC VARCHAR(200),
	PRIMARY KEY(ENUM_TYPE_ID, ENUM_VALUE)
);


-- ----------------------------
-- Table structure for "COUNTRY"
-- ----------------------------
DROP TABLE COUNTRY;
CREATE TABLE COUNTRY(
	COUNTRY_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	NAME VARCHAR(100) NOT NULL,
	SYMBOL VARCHAR(10) NOT NULL
);


-- ----------------------------
-- Table structure for "STATE"
-- ----------------------------
DROP TABLE STATE;
CREATE TABLE STATE(
	STATE_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	NAME VARCHAR(100),
	SYMBOL VARCHAR(10),
	COUNTRY_ID INT NOT NULL
);