/********************EXECUTE SEQUENCE 4********************/

-- ADDING INDEXES

ALTER TABLE USER_INFO ADD UNIQUE INDEX UNIQUE_USERNAME(USER_NAME);      
	
-- ADDING FK RELATION SHIPS

ALTER TABLE USER_INFO ADD 
      CONSTRAINT FK_USER_INFO_ROLE
      FOREIGN    KEY (ROLE_ID)
      REFERENCES ROLE(ROLE_ID);
      
ALTER TABLE USER_INFO ADD 
      CONSTRAINT FK_USER_INFO_CLIENT
      FOREIGN    KEY (CLIENT_ID)
      REFERENCES CLIENT(CLIENT_ID);
      
ALTER TABLE RL_ROLE_PRIVILEGE ADD 
      CONSTRAINT FK_ROLE_PRIVILEGE
      FOREIGN    KEY (PRIVILEGE_ID)
      REFERENCES PRIVILEGE(PRIVILEGE_ID);

ALTER TABLE RL_ROLE_PRIVILEGE ADD 
      CONSTRAINT FK_PRIVILEGE_ROLE
      FOREIGN    KEY (ROLE_ID)
      REFERENCES ROLE(ROLE_ID);
      
ALTER TABLE STATE ADD 
      CONSTRAINT FK_STATE_COUNTRY
      FOREIGN    KEY (COUNTRY_ID)
      REFERENCES COUNTRY(COUNTRY_ID);

ALTER TABLE LOCATION ADD 
      CONSTRAINT FK_LOCATION_USER_INFO
      FOREIGN    KEY (USER_INFO_ID)
      REFERENCES USER_INFO(USER_INFO_ID);

ALTER TABLE LOCATION ADD 
      CONSTRAINT FK_LOCATION_CLIENT
      FOREIGN    KEY (CLIENT_ID)
      REFERENCES CLIENT(CLIENT_ID);
      
ALTER TABLE ENUM ADD 
      CONSTRAINT FK_ENUM_TYPE
      FOREIGN    KEY (ENUM_TYPE_ID)
      REFERENCES ENUM_TYPE(ENUM_TYPE_ID);      

-- ADDING FK RELATION SHIPS

ALTER TABLE MODEL ADD 
      CONSTRAINT FK_MODEL_MAKE
      FOREIGN    KEY (MAKE_ID)
      REFERENCES MAKE(MAKE_ID);
      
ALTER TABLE STYLE ADD 
      CONSTRAINT FK_STYLE_MODEL
      FOREIGN    KEY (MODEL_ID)
      REFERENCES MODEL(MODEL_ID);
      
ALTER TABLE CATEGORY ADD 
      CONSTRAINT FK_CATEGORY_PARENT
      FOREIGN    KEY (PARENT_ID)
      REFERENCES CATEGORY(CATEGORY_ID);
      
ALTER TABLE VEHICLE ADD 
      CONSTRAINT FK_VEHICLE_MAKE
      FOREIGN    KEY (MAKE_ID)
      REFERENCES MAKE(MAKE_ID);
      
ALTER TABLE VEHICLE ADD 
      CONSTRAINT FK_VEHICLE_MODEL
      FOREIGN    KEY (MODEL_ID)
      REFERENCES MODEL(MODEL_ID);

ALTER TABLE VEHICLE ADD 
      CONSTRAINT FK_VEHICLE_STYLE
      FOREIGN    KEY (STYLE_ID)
      REFERENCES STYLE(STYLE_ID);
      
ALTER TABLE VEHICLE ADD 
      CONSTRAINT FK_VEHICLE_USER
      FOREIGN    KEY (CREATED_BY)
      REFERENCES USER_INFO(USER_INFO_ID);
      
ALTER TABLE FEATURE_GROUP ADD 
      CONSTRAINT FK_FEATURE_GROUP_PARENT
      FOREIGN    KEY (PARENT_ID)
      REFERENCES FEATURE_GROUP(FEATURE_GROUP_ID);
      
ALTER TABLE FEATURE ADD 
      CONSTRAINT FK_FEATURE_GROUP
      FOREIGN    KEY (FEATURE_GROUP_ID)
      REFERENCES FEATURE_GROUP(FEATURE_GROUP_ID);      
      
ALTER TABLE FEATURE ADD 
      CONSTRAINT FK_FEATURE_MAKE
      FOREIGN    KEY (MAKE_ID)
      REFERENCES MAKE(MAKE_ID);  
      
ALTER TABLE IMAGE ADD 
      CONSTRAINT FK_IMAGE_VEHICLE
      FOREIGN    KEY (VEHICLE_ID)
      REFERENCES VEHICLE(VEHICLE_ID);  
      
ALTER TABLE ADVERTISEMENT ADD 
      CONSTRAINT FK_ADVERTISEMENT_USER
      FOREIGN    KEY (CREATED_BY)
      REFERENCES USER_INFO(USER_INFO_ID); 
 
ALTER TABLE ADVERTISEMENT ADD 
      CONSTRAINT FK_ADVERTISEMENT_VEHICLE
      FOREIGN    KEY (VEHICLE_ID)
      REFERENCES VEHICLE(VEHICLE_ID);
      
-- ADDING MANY TO MANY RELATIONSHIPS

ALTER TABLE RL_VEHICLE_CATEGORY ADD 
      CONSTRAINT FK_VEHICLE_CATEGORY
      FOREIGN    KEY (VEHICLE_ID)
      REFERENCES VEHICLE(VEHICLE_ID);
      
ALTER TABLE RL_VEHICLE_CATEGORY ADD 
      CONSTRAINT FK_CATEGORY_VEHICLE
      FOREIGN    KEY (CATEGORY_ID)
      REFERENCES CATEGORY(CATEGORY_ID);      

ALTER TABLE RL_VEHICLE_FEATURE ADD 
      CONSTRAINT FK_VEHICLE_FEATURE
      FOREIGN    KEY (VEHICLE_ID)
      REFERENCES VEHICLE(VEHICLE_ID);      

ALTER TABLE RL_VEHICLE_FEATURE ADD 
      CONSTRAINT FK_FEATURE_VEHICLE
      FOREIGN    KEY (FEATURE_ID)
      REFERENCES FEATURE(FEATURE_ID);
      
ALTER TABLE RL_STYLE_FEATURE ADD 
      CONSTRAINT FK_STYLE_FEATURE
      FOREIGN    KEY (STYLE_ID)
      REFERENCES STYLE(STYLE_ID);      

ALTER TABLE RL_STYLE_FEATURE ADD 
      CONSTRAINT FK_FEATURE_STYLE
      FOREIGN    KEY (FEATURE_ID)
      REFERENCES FEATURE(FEATURE_ID);      
      
      