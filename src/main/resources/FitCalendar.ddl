
DROP SEQUENCE exerciserIdSeq;

DROP SEQUENCE inbodyIdSeq;

DROP SEQUENCE itemIdSeq;

DROP SEQUENCE msgIdSeq;

DROP SEQUENCE recordIdSeq;

DROP SEQUENCE requestIdSeq;

DROP TABLE MatchingStatus CASCADE CONSTRAINTS PURGE;

DROP TABLE WeightOptions CASCADE CONSTRAINTS PURGE;

DROP TABLE PercentBodyFatOptions CASCADE CONSTRAINTS PURGE;

DROP TABLE HeightOptions CASCADE CONSTRAINTS PURGE;

DROP TABLE RecommendList CASCADE CONSTRAINTS PURGE;

DROP TABLE FitMate CASCADE CONSTRAINTS PURGE;

DROP TABLE Message CASCADE CONSTRAINTS PURGE;

DROP TABLE Attendance CASCADE CONSTRAINTS PURGE;

DROP TABLE Count CASCADE CONSTRAINTS PURGE;

DROP TABLE Record CASCADE CONSTRAINTS PURGE;

DROP TABLE ToExercise CASCADE CONSTRAINTS PURGE;

DROP TABLE Inbody CASCADE CONSTRAINTS PURGE;

DROP TABLE Exerciser CASCADE CONSTRAINTS PURGE;

CREATE TABLE Exerciser
(
	exerciserId          INTEGER  NOT NULL ,
	password             VARCHAR2(18)  NOT NULL ,
	nickname             VARCHAR2(18)  NOT NULL ,
	explanation          VARCHAR2(50)  NULL ,
	speciality           VARCHAR2(18)  NOT NULL ,
	personality          VARCHAR2(18)  NULL ,
	gender               VARCHAR2(5)  NOT NULL ,
	point                INTEGER  DEFAULT 0  NOT NULL ,
	useMatchSvc          SMALLINT  DEFAULT 0  NOT NULL ,
	id                   VARCHAR2(18)  NOT NULL ,
	MAXMATE              LONG  NULL 
);

CREATE UNIQUE INDEX XPKExerciser ON Exerciser
(exerciserId   ASC);

ALTER TABLE Exerciser
	ADD CONSTRAINT  XPKExerciser PRIMARY KEY (exerciserId);

CREATE TABLE Attendance
(
	creationDate         DATE  DEFAULT SYSDATE  NOT NULL ,
	exerciserId          INTEGER  NOT NULL 
);

CREATE UNIQUE INDEX XPKAttendance ON Attendance
(creationDate   ASC,exerciserId   ASC);

ALTER TABLE Attendance
	ADD CONSTRAINT  XPKAttendance PRIMARY KEY (creationDate,exerciserId);

CREATE TABLE Count
(
	weeklyCount          INTEGER  NOT NULL ,
	monthlyCount         INTEGER  NOT NULL ,
	countId              INTEGER  NOT NULL ,
	exerciserId          INTEGER  NOT NULL 
);

CREATE UNIQUE INDEX XPKCount ON Count
(countId   ASC);

ALTER TABLE Count
	ADD CONSTRAINT  XPKCount PRIMARY KEY (countId);

CREATE TABLE HeightOptions
(
	heightId             INTEGER  NOT NULL ,
	height1              INTEGER  NULL ,
	height2              INTEGER  NULL 
);

CREATE UNIQUE INDEX XPKHeightOptions ON HeightOptions
(heightId   ASC);

ALTER TABLE HeightOptions
	ADD CONSTRAINT  XPKHeightOptions PRIMARY KEY (heightId);

CREATE TABLE PercentBodyFatOptions
(
	percentBodyFatId     INTEGER  NOT NULL ,
	percentBodyFat1      INTEGER  NULL ,
	percentBodyFat2      INTEGER  NULL 
);

CREATE UNIQUE INDEX XPKPercentBodyFatOptions ON PercentBodyFatOptions
(percentBodyFatId   ASC);

ALTER TABLE PercentBodyFatOptions
	ADD CONSTRAINT  XPKPercentBodyFatOptions PRIMARY KEY (percentBodyFatId);

CREATE TABLE Record
(
	recordId             INTEGER  NOT NULL ,
	title                VARCHAR2(50)  NOT NULL ,
	creationDate         DATE  DEFAULT SYSDATE  NOT NULL ,
	totalTime            INTEGER  NOT NULL ,
	category             INTEGER  NOT NULL ,
	routine              VARCHAR2(50)  NULL ,
	diet                 VARCHAR2(50)  NULL ,
	photo                VARCHAR2(50)  NULL ,
	shareOption          SMALLINT  NOT NULL ,
	exerciserId          INTEGER  NOT NULL 
);

CREATE UNIQUE INDEX XPKRecord ON Record
(recordId   ASC,exerciserId   ASC);

ALTER TABLE Record
	ADD CONSTRAINT  XPKRecord PRIMARY KEY (recordId,exerciserId);

CREATE TABLE ToExercise
(
	itemId               CHAR(18)  NOT NULL ,
	creationDate         DATE  DEFAULT SYSDATE  NOT NULL ,
	content              VARCHAR2(50)  NOT NULL ,
	checked              CHAR(1)  NOT NULL ,
	exerciserId          INTEGER  NOT NULL 
);

CREATE UNIQUE INDEX XPKToExercise ON ToExercise
(itemId   ASC,exerciserId   ASC);

ALTER TABLE ToExercise
	ADD CONSTRAINT  XPKToExercise PRIMARY KEY (itemId,exerciserId);

CREATE TABLE Inbody
(
	inbodyId             INTEGER  NOT NULL ,
	height               INTEGER  NOT NULL ,
	weight               INTEGER  NOT NULL ,
	percentBodyFat       INTEGER  NOT NULL ,
	skeletalMM           INTEGER  NOT NULL ,
	visceralFat          INTEGER  NOT NULL ,
	measureDate          DATE  NOT NULL ,
	exerciserId          INTEGER  NOT NULL 
);

CREATE UNIQUE INDEX XPKInbody ON Inbody
(inbodyId   ASC,exerciserId   ASC);

ALTER TABLE Inbody
	ADD CONSTRAINT  XPKInbody PRIMARY KEY (inbodyId,exerciserId);

CREATE TABLE Message
(
	msgId                INTEGER  NOT NULL ,
	content              VARCHAR2(1000)  NOT NULL ,
	senderId             INTEGER  NOT NULL ,
	receiverId           INTEGER  NOT NULL ,
	sendDate             DATE  NOT NULL 
);

CREATE UNIQUE INDEX XPKMessage ON Message
(msgId   ASC);

ALTER TABLE Message
	ADD CONSTRAINT  XPKMessage PRIMARY KEY (msgId);

CREATE TABLE FitMate
(
	exerciser1           INTEGER  NOT NULL ,
	exerciser2           INTEGER  NOT NULL 
);

CREATE UNIQUE INDEX XPKFitMate ON FitMate
(exerciser2   ASC,exerciser1   ASC);

ALTER TABLE FitMate
	ADD CONSTRAINT  XPKFitMate PRIMARY KEY (exerciser2,exerciser1);

CREATE TABLE RecommendList
(
	exerciserId          INTEGER  NOT NULL ,
	recomId1             INTEGER  NOT NULL ,
	recomId2             INTEGER  NOT NULL ,
	recomId3             INTEGER  NOT NULL ,
	count                INTEGER  NULL 
);

CREATE UNIQUE INDEX XPKRecommendList ON RecommendList
(exerciserId   ASC);

ALTER TABLE RecommendList
	ADD CONSTRAINT  XPKRecommendList PRIMARY KEY (exerciserId);

CREATE TABLE WeightOptions
(
	weightId             INTEGER  NOT NULL ,
	weight1              INTEGER  NULL ,
	weight2              INTEGER  NULL 
);

CREATE UNIQUE INDEX XPKWeightOptions ON WeightOptions
(weightId   ASC);

ALTER TABLE WeightOptions
	ADD CONSTRAINT  XPKWeightOptions PRIMARY KEY (weightId);

CREATE TABLE MatchingStatus
(
	status               INTEGER  NOT NULL ,
	receiverId           INTEGER  NOT NULL ,
	senderId             INTEGER  NOT NULL 
);

CREATE UNIQUE INDEX XPKMatchingStatus ON MatchingStatus
(receiverId   ASC,senderId   ASC);

ALTER TABLE MatchingStatus
	ADD CONSTRAINT  XPKMatchingStatus PRIMARY KEY (receiverId,senderId);

ALTER TABLE Attendance
	ADD (
CONSTRAINT R_9 FOREIGN KEY (exerciserId) REFERENCES Exerciser (exerciserId));

ALTER TABLE Count
	ADD (
CONSTRAINT R_10 FOREIGN KEY (exerciserId) REFERENCES Exerciser (exerciserId));

ALTER TABLE Record
	ADD (
CONSTRAINT R_29 FOREIGN KEY (exerciserId) REFERENCES Exerciser (exerciserId));

ALTER TABLE ToExercise
	ADD (
CONSTRAINT R_3 FOREIGN KEY (exerciserId) REFERENCES Exerciser (exerciserId));

ALTER TABLE Inbody
	ADD (
CONSTRAINT R_2 FOREIGN KEY (exerciserId) REFERENCES Exerciser (exerciserId));

ALTER TABLE Message
	ADD (
CONSTRAINT R_16 FOREIGN KEY (senderId) REFERENCES Exerciser (exerciserId) ON DELETE SET NULL);

ALTER TABLE Message
	ADD (
CONSTRAINT R_17 FOREIGN KEY (receiverId) REFERENCES Exerciser (exerciserId) ON DELETE SET NULL);

ALTER TABLE FitMate
	ADD (
CONSTRAINT R_18 FOREIGN KEY (exerciser1) REFERENCES Exerciser (exerciserId));

ALTER TABLE FitMate
	ADD (
CONSTRAINT R_21 FOREIGN KEY (exerciser2) REFERENCES Exerciser (exerciserId));

ALTER TABLE RecommendList
	ADD (
CONSTRAINT R_25 FOREIGN KEY (exerciserId) REFERENCES Exerciser (exerciserId));

ALTER TABLE RecommendList
	ADD (
CONSTRAINT R_35 FOREIGN KEY (recomId1) REFERENCES Exerciser (exerciserId));

ALTER TABLE RecommendList
	ADD (
CONSTRAINT R_36 FOREIGN KEY (recomId2) REFERENCES Exerciser (exerciserId));

ALTER TABLE RecommendList
	ADD (
CONSTRAINT R_37 FOREIGN KEY (recomId3) REFERENCES Exerciser (exerciserId));

ALTER TABLE MatchingStatus
	ADD (
CONSTRAINT R_38 FOREIGN KEY (receiverId) REFERENCES Exerciser (exerciserId));

ALTER TABLE MatchingStatus
	ADD (
CONSTRAINT R_39 FOREIGN KEY (senderId) REFERENCES Exerciser (exerciserId));

CREATE  TRIGGER  tD_Exerciser AFTER DELETE ON Exerciser for each row
-- erwin Builtin Trigger
-- DELETE trigger on Exerciser 
DECLARE NUMROWS INTEGER;
BEGIN
    /* erwin Builtin Trigger */
    /* Exerciser  MatchingStatus on parent delete restrict */
    /* ERWIN_RELATION:CHECKSUM="000e0ddc", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="MatchingStatus"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_39", FK_COLUMNS="senderId" */
    SELECT count(*) INTO NUMROWS
      FROM MatchingStatus
      WHERE
        /*  %JoinFKPK(MatchingStatus,:%Old," = "," AND") */
        MatchingStatus.senderId = :old.exerciserId;
    IF (NUMROWS > 0)
    THEN
      raise_application_error(
        -20001,
        'Cannot delete Exerciser because MatchingStatus exists.'
      );
    END IF;

    /* erwin Builtin Trigger */
    /* Exerciser  MatchingStatus on parent delete restrict */
    /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="MatchingStatus"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_38", FK_COLUMNS="receiverId" */
    SELECT count(*) INTO NUMROWS
      FROM MatchingStatus
      WHERE
        /*  %JoinFKPK(MatchingStatus,:%Old," = "," AND") */
        MatchingStatus.receiverId = :old.exerciserId;
    IF (NUMROWS > 0)
    THEN
      raise_application_error(
        -20001,
        'Cannot delete Exerciser because MatchingStatus exists.'
      );
    END IF;

    /* erwin Builtin Trigger */
    /* Exerciser  RecommendList on parent delete restrict */
    /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="RecommendList"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_37", FK_COLUMNS="recomId3" */
    SELECT count(*) INTO NUMROWS
      FROM RecommendList
      WHERE
        /*  %JoinFKPK(RecommendList,:%Old," = "," AND") */
        RecommendList.recomId3 = :old.exerciserId;
    IF (NUMROWS > 0)
    THEN
      raise_application_error(
        -20001,
        'Cannot delete Exerciser because RecommendList exists.'
      );
    END IF;

    /* erwin Builtin Trigger */
    /* Exerciser  RecommendList on parent delete restrict */
    /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="RecommendList"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_36", FK_COLUMNS="recomId2" */
    SELECT count(*) INTO NUMROWS
      FROM RecommendList
      WHERE
        /*  %JoinFKPK(RecommendList,:%Old," = "," AND") */
        RecommendList.recomId2 = :old.exerciserId;
    IF (NUMROWS > 0)
    THEN
      raise_application_error(
        -20001,
        'Cannot delete Exerciser because RecommendList exists.'
      );
    END IF;

    /* erwin Builtin Trigger */
    /* Exerciser  RecommendList on parent delete restrict */
    /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="RecommendList"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_35", FK_COLUMNS="recomId1" */
    SELECT count(*) INTO NUMROWS
      FROM RecommendList
      WHERE
        /*  %JoinFKPK(RecommendList,:%Old," = "," AND") */
        RecommendList.recomId1 = :old.exerciserId;
    IF (NUMROWS > 0)
    THEN
      raise_application_error(
        -20001,
        'Cannot delete Exerciser because RecommendList exists.'
      );
    END IF;

    /* erwin Builtin Trigger */
    /* Exerciser  Record on parent delete restrict */
    /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="Record"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_29", FK_COLUMNS="exerciserId" */
    SELECT count(*) INTO NUMROWS
      FROM Record
      WHERE
        /*  %JoinFKPK(Record,:%Old," = "," AND") */
        Record.exerciserId = :old.exerciserId;
    IF (NUMROWS > 0)
    THEN
      raise_application_error(
        -20001,
        'Cannot delete Exerciser because Record exists.'
      );
    END IF;

    /* erwin Builtin Trigger */
    /* Exerciser  RecommendList on parent delete restrict */
    /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="RecommendList"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_25", FK_COLUMNS="exerciserId" */
    SELECT count(*) INTO NUMROWS
      FROM RecommendList
      WHERE
        /*  %JoinFKPK(RecommendList,:%Old," = "," AND") */
        RecommendList.exerciserId = :old.exerciserId;
    IF (NUMROWS > 0)
    THEN
      raise_application_error(
        -20001,
        'Cannot delete Exerciser because RecommendList exists.'
      );
    END IF;

    /* erwin Builtin Trigger */
    /* Exerciser  FitMate on parent delete restrict */
    /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="FitMate"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_21", FK_COLUMNS="exerciser2" */
    SELECT count(*) INTO NUMROWS
      FROM FitMate
      WHERE
        /*  %JoinFKPK(FitMate,:%Old," = "," AND") */
        FitMate.exerciser2 = :old.exerciserId;
    IF (NUMROWS > 0)
    THEN
      raise_application_error(
        -20001,
        'Cannot delete Exerciser because FitMate exists.'
      );
    END IF;

    /* erwin Builtin Trigger */
    /* Exerciser  FitMate on parent delete restrict */
    /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="FitMate"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_18", FK_COLUMNS="exerciser1" */
    SELECT count(*) INTO NUMROWS
      FROM FitMate
      WHERE
        /*  %JoinFKPK(FitMate,:%Old," = "," AND") */
        FitMate.exerciser1 = :old.exerciserId;
    IF (NUMROWS > 0)
    THEN
      raise_application_error(
        -20001,
        'Cannot delete Exerciser because FitMate exists.'
      );
    END IF;

    /* erwin Builtin Trigger */
    /* Exerciser  Message on parent delete set null */
    /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="Message"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_17", FK_COLUMNS="receiverId" */
    UPDATE Message
      SET
        /* %SetFK(Message,NULL) */
        Message.receiverId = NULL
      WHERE
        /* %JoinFKPK(Message,:%Old," = "," AND") */
        Message.receiverId = :old.exerciserId;

    /* erwin Builtin Trigger */
    /* Exerciser  Message on parent delete set null */
    /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="Message"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_16", FK_COLUMNS="senderId" */
    UPDATE Message
      SET
        /* %SetFK(Message,NULL) */
        Message.senderId = NULL
      WHERE
        /* %JoinFKPK(Message,:%Old," = "," AND") */
        Message.senderId = :old.exerciserId;

    /* erwin Builtin Trigger */
    /* Exerciser  Count on parent delete restrict */
    /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="Count"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_10", FK_COLUMNS="exerciserId" */
    SELECT count(*) INTO NUMROWS
      FROM Count
      WHERE
        /*  %JoinFKPK(Count,:%Old," = "," AND") */
        Count.exerciserId = :old.exerciserId;
    IF (NUMROWS > 0)
    THEN
      raise_application_error(
        -20001,
        'Cannot delete Exerciser because Count exists.'
      );
    END IF;

    /* erwin Builtin Trigger */
    /* Exerciser  Attendance on parent delete restrict */
    /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="Attendance"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_9", FK_COLUMNS="exerciserId" */
    SELECT count(*) INTO NUMROWS
      FROM Attendance
      WHERE
        /*  %JoinFKPK(Attendance,:%Old," = "," AND") */
        Attendance.exerciserId = :old.exerciserId;
    IF (NUMROWS > 0)
    THEN
      raise_application_error(
        -20001,
        'Cannot delete Exerciser because Attendance exists.'
      );
    END IF;

    /* erwin Builtin Trigger */
    /* Exerciser  ToExercise on parent delete restrict */
    /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="ToExercise"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_3", FK_COLUMNS="exerciserId" */
    SELECT count(*) INTO NUMROWS
      FROM ToExercise
      WHERE
        /*  %JoinFKPK(ToExercise,:%Old," = "," AND") */
        ToExercise.exerciserId = :old.exerciserId;
    IF (NUMROWS > 0)
    THEN
      raise_application_error(
        -20001,
        'Cannot delete Exerciser because ToExercise exists.'
      );
    END IF;

    /* erwin Builtin Trigger */
    /* Exerciser  Inbody on parent delete restrict */
    /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="Inbody"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_2", FK_COLUMNS="exerciserId" */
    SELECT count(*) INTO NUMROWS
      FROM Inbody
      WHERE
        /*  %JoinFKPK(Inbody,:%Old," = "," AND") */
        Inbody.exerciserId = :old.exerciserId;
    IF (NUMROWS > 0)
    THEN
      raise_application_error(
        -20001,
        'Cannot delete Exerciser because Inbody exists.'
      );
    END IF;


-- erwin Builtin Trigger
END;
/

CREATE  TRIGGER tU_Exerciser AFTER UPDATE ON Exerciser for each row
-- erwin Builtin Trigger
-- UPDATE trigger on Exerciser 
DECLARE NUMROWS INTEGER;
BEGIN
  /* erwin Builtin Trigger */
  /* Exerciser  MatchingStatus on parent update restrict */
  /* ERWIN_RELATION:CHECKSUM="001016b8", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="MatchingStatus"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_39", FK_COLUMNS="senderId" */
  IF
    /* %JoinPKPK(:%Old,:%New," <> "," OR ") */
    :old.exerciserId <> :new.exerciserId
  THEN
    SELECT count(*) INTO NUMROWS
      FROM MatchingStatus
      WHERE
        /*  %JoinFKPK(MatchingStatus,:%Old," = "," AND") */
        MatchingStatus.senderId = :old.exerciserId;
    IF (NUMROWS > 0)
    THEN 
      raise_application_error(
        -20005,
        'Cannot update Exerciser because MatchingStatus exists.'
      );
    END IF;
  END IF;

  /* erwin Builtin Trigger */
  /* Exerciser  MatchingStatus on parent update restrict */
  /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="MatchingStatus"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_38", FK_COLUMNS="receiverId" */
  IF
    /* %JoinPKPK(:%Old,:%New," <> "," OR ") */
    :old.exerciserId <> :new.exerciserId
  THEN
    SELECT count(*) INTO NUMROWS
      FROM MatchingStatus
      WHERE
        /*  %JoinFKPK(MatchingStatus,:%Old," = "," AND") */
        MatchingStatus.receiverId = :old.exerciserId;
    IF (NUMROWS > 0)
    THEN 
      raise_application_error(
        -20005,
        'Cannot update Exerciser because MatchingStatus exists.'
      );
    END IF;
  END IF;

  /* erwin Builtin Trigger */
  /* Exerciser  RecommendList on parent update restrict */
  /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="RecommendList"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_37", FK_COLUMNS="recomId3" */
  IF
    /* %JoinPKPK(:%Old,:%New," <> "," OR ") */
    :old.exerciserId <> :new.exerciserId
  THEN
    SELECT count(*) INTO NUMROWS
      FROM RecommendList
      WHERE
        /*  %JoinFKPK(RecommendList,:%Old," = "," AND") */
        RecommendList.recomId3 = :old.exerciserId;
    IF (NUMROWS > 0)
    THEN 
      raise_application_error(
        -20005,
        'Cannot update Exerciser because RecommendList exists.'
      );
    END IF;
  END IF;

  /* erwin Builtin Trigger */
  /* Exerciser  RecommendList on parent update restrict */
  /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="RecommendList"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_36", FK_COLUMNS="recomId2" */
  IF
    /* %JoinPKPK(:%Old,:%New," <> "," OR ") */
    :old.exerciserId <> :new.exerciserId
  THEN
    SELECT count(*) INTO NUMROWS
      FROM RecommendList
      WHERE
        /*  %JoinFKPK(RecommendList,:%Old," = "," AND") */
        RecommendList.recomId2 = :old.exerciserId;
    IF (NUMROWS > 0)
    THEN 
      raise_application_error(
        -20005,
        'Cannot update Exerciser because RecommendList exists.'
      );
    END IF;
  END IF;

  /* erwin Builtin Trigger */
  /* Exerciser  RecommendList on parent update restrict */
  /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="RecommendList"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_35", FK_COLUMNS="recomId1" */
  IF
    /* %JoinPKPK(:%Old,:%New," <> "," OR ") */
    :old.exerciserId <> :new.exerciserId
  THEN
    SELECT count(*) INTO NUMROWS
      FROM RecommendList
      WHERE
        /*  %JoinFKPK(RecommendList,:%Old," = "," AND") */
        RecommendList.recomId1 = :old.exerciserId;
    IF (NUMROWS > 0)
    THEN 
      raise_application_error(
        -20005,
        'Cannot update Exerciser because RecommendList exists.'
      );
    END IF;
  END IF;

  /* erwin Builtin Trigger */
  /* Exerciser  Record on parent update restrict */
  /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="Record"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_29", FK_COLUMNS="exerciserId" */
  IF
    /* %JoinPKPK(:%Old,:%New," <> "," OR ") */
    :old.exerciserId <> :new.exerciserId
  THEN
    SELECT count(*) INTO NUMROWS
      FROM Record
      WHERE
        /*  %JoinFKPK(Record,:%Old," = "," AND") */
        Record.exerciserId = :old.exerciserId;
    IF (NUMROWS > 0)
    THEN 
      raise_application_error(
        -20005,
        'Cannot update Exerciser because Record exists.'
      );
    END IF;
  END IF;

  /* erwin Builtin Trigger */
  /* Exerciser  RecommendList on parent update restrict */
  /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="RecommendList"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_25", FK_COLUMNS="exerciserId" */
  IF
    /* %JoinPKPK(:%Old,:%New," <> "," OR ") */
    :old.exerciserId <> :new.exerciserId
  THEN
    SELECT count(*) INTO NUMROWS
      FROM RecommendList
      WHERE
        /*  %JoinFKPK(RecommendList,:%Old," = "," AND") */
        RecommendList.exerciserId = :old.exerciserId;
    IF (NUMROWS > 0)
    THEN 
      raise_application_error(
        -20005,
        'Cannot update Exerciser because RecommendList exists.'
      );
    END IF;
  END IF;

  /* erwin Builtin Trigger */
  /* Exerciser  FitMate on parent update restrict */
  /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="FitMate"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_21", FK_COLUMNS="exerciser2" */
  IF
    /* %JoinPKPK(:%Old,:%New," <> "," OR ") */
    :old.exerciserId <> :new.exerciserId
  THEN
    SELECT count(*) INTO NUMROWS
      FROM FitMate
      WHERE
        /*  %JoinFKPK(FitMate,:%Old," = "," AND") */
        FitMate.exerciser2 = :old.exerciserId;
    IF (NUMROWS > 0)
    THEN 
      raise_application_error(
        -20005,
        'Cannot update Exerciser because FitMate exists.'
      );
    END IF;
  END IF;

  /* erwin Builtin Trigger */
  /* Exerciser  FitMate on parent update restrict */
  /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="FitMate"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_18", FK_COLUMNS="exerciser1" */
  IF
    /* %JoinPKPK(:%Old,:%New," <> "," OR ") */
    :old.exerciserId <> :new.exerciserId
  THEN
    SELECT count(*) INTO NUMROWS
      FROM FitMate
      WHERE
        /*  %JoinFKPK(FitMate,:%Old," = "," AND") */
        FitMate.exerciser1 = :old.exerciserId;
    IF (NUMROWS > 0)
    THEN 
      raise_application_error(
        -20005,
        'Cannot update Exerciser because FitMate exists.'
      );
    END IF;
  END IF;

  /* Exerciser  Message on parent update set null */
  /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="Message"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_17", FK_COLUMNS="receiverId" */
  IF
    /* %JoinPKPK(:%Old,:%New," <> "," OR ") */
    :old.exerciserId <> :new.exerciserId
  THEN
    UPDATE Message
      SET
        /* %SetFK(Message,NULL) */
        Message.receiverId = NULL
      WHERE
        /* %JoinFKPK(Message,:%Old," = ",",") */
        Message.receiverId = :old.exerciserId;
  END IF;

  /* Exerciser  Message on parent update set null */
  /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="Message"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_16", FK_COLUMNS="senderId" */
  IF
    /* %JoinPKPK(:%Old,:%New," <> "," OR ") */
    :old.exerciserId <> :new.exerciserId
  THEN
    UPDATE Message
      SET
        /* %SetFK(Message,NULL) */
        Message.senderId = NULL
      WHERE
        /* %JoinFKPK(Message,:%Old," = ",",") */
        Message.senderId = :old.exerciserId;
  END IF;

  /* erwin Builtin Trigger */
  /* Exerciser  Count on parent update restrict */
  /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="Count"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_10", FK_COLUMNS="exerciserId" */
  IF
    /* %JoinPKPK(:%Old,:%New," <> "," OR ") */
    :old.exerciserId <> :new.exerciserId
  THEN
    SELECT count(*) INTO NUMROWS
      FROM Count
      WHERE
        /*  %JoinFKPK(Count,:%Old," = "," AND") */
        Count.exerciserId = :old.exerciserId;
    IF (NUMROWS > 0)
    THEN 
      raise_application_error(
        -20005,
        'Cannot update Exerciser because Count exists.'
      );
    END IF;
  END IF;

  /* erwin Builtin Trigger */
  /* Exerciser  Attendance on parent update restrict */
  /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="Attendance"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_9", FK_COLUMNS="exerciserId" */
  IF
    /* %JoinPKPK(:%Old,:%New," <> "," OR ") */
    :old.exerciserId <> :new.exerciserId
  THEN
    SELECT count(*) INTO NUMROWS
      FROM Attendance
      WHERE
        /*  %JoinFKPK(Attendance,:%Old," = "," AND") */
        Attendance.exerciserId = :old.exerciserId;
    IF (NUMROWS > 0)
    THEN 
      raise_application_error(
        -20005,
        'Cannot update Exerciser because Attendance exists.'
      );
    END IF;
  END IF;

  /* erwin Builtin Trigger */
  /* Exerciser  ToExercise on parent update restrict */
  /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="ToExercise"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_3", FK_COLUMNS="exerciserId" */
  IF
    /* %JoinPKPK(:%Old,:%New," <> "," OR ") */
    :old.exerciserId <> :new.exerciserId
  THEN
    SELECT count(*) INTO NUMROWS
      FROM ToExercise
      WHERE
        /*  %JoinFKPK(ToExercise,:%Old," = "," AND") */
        ToExercise.exerciserId = :old.exerciserId;
    IF (NUMROWS > 0)
    THEN 
      raise_application_error(
        -20005,
        'Cannot update Exerciser because ToExercise exists.'
      );
    END IF;
  END IF;

  /* erwin Builtin Trigger */
  /* Exerciser  Inbody on parent update restrict */
  /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="Inbody"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_2", FK_COLUMNS="exerciserId" */
  IF
    /* %JoinPKPK(:%Old,:%New," <> "," OR ") */
    :old.exerciserId <> :new.exerciserId
  THEN
    SELECT count(*) INTO NUMROWS
      FROM Inbody
      WHERE
        /*  %JoinFKPK(Inbody,:%Old," = "," AND") */
        Inbody.exerciserId = :old.exerciserId;
    IF (NUMROWS > 0)
    THEN 
      raise_application_error(
        -20005,
        'Cannot update Exerciser because Inbody exists.'
      );
    END IF;
  END IF;


-- erwin Builtin Trigger
END;
/


CREATE  TRIGGER tI_Attendance BEFORE INSERT ON Attendance for each row
-- erwin Builtin Trigger
-- INSERT trigger on Attendance 
DECLARE NUMROWS INTEGER;
BEGIN
    /* erwin Builtin Trigger */
    /* Exerciser  Attendance on child insert restrict */
    /* ERWIN_RELATION:CHECKSUM="0000f40d", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="Attendance"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_9", FK_COLUMNS="exerciserId" */
    SELECT count(*) INTO NUMROWS
      FROM Exerciser
      WHERE
        /* %JoinFKPK(:%New,Exerciser," = "," AND") */
        :new.exerciserId = Exerciser.exerciserId;
    IF (
      /* %NotnullFK(:%New," IS NOT NULL AND") */
      
      NUMROWS = 0
    )
    THEN
      raise_application_error(
        -20002,
        'Cannot insert Attendance because Exerciser does not exist.'
      );
    END IF;


-- erwin Builtin Trigger
END;
/

CREATE  TRIGGER tU_Attendance AFTER UPDATE ON Attendance for each row
-- erwin Builtin Trigger
-- UPDATE trigger on Attendance 
DECLARE NUMROWS INTEGER;
BEGIN
  /* erwin Builtin Trigger */
  /* Exerciser  Attendance on child update restrict */
  /* ERWIN_RELATION:CHECKSUM="0000f437", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="Attendance"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_9", FK_COLUMNS="exerciserId" */
  SELECT count(*) INTO NUMROWS
    FROM Exerciser
    WHERE
      /* %JoinFKPK(:%New,Exerciser," = "," AND") */
      :new.exerciserId = Exerciser.exerciserId;
  IF (
    /* %NotnullFK(:%New," IS NOT NULL AND") */
    
    NUMROWS = 0
  )
  THEN
    raise_application_error(
      -20007,
      'Cannot update Attendance because Exerciser does not exist.'
    );
  END IF;


-- erwin Builtin Trigger
END;
/


CREATE  TRIGGER tI_Count BEFORE INSERT ON Count for each row
-- erwin Builtin Trigger
-- INSERT trigger on Count 
DECLARE NUMROWS INTEGER;
BEGIN
    /* erwin Builtin Trigger */
    /* Exerciser  Count on child insert restrict */
    /* ERWIN_RELATION:CHECKSUM="0000ec63", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="Count"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_10", FK_COLUMNS="exerciserId" */
    SELECT count(*) INTO NUMROWS
      FROM Exerciser
      WHERE
        /* %JoinFKPK(:%New,Exerciser," = "," AND") */
        :new.exerciserId = Exerciser.exerciserId;
    IF (
      /* %NotnullFK(:%New," IS NOT NULL AND") */
      
      NUMROWS = 0
    )
    THEN
      raise_application_error(
        -20002,
        'Cannot insert Count because Exerciser does not exist.'
      );
    END IF;


-- erwin Builtin Trigger
END;
/

CREATE  TRIGGER tU_Count AFTER UPDATE ON Count for each row
-- erwin Builtin Trigger
-- UPDATE trigger on Count 
DECLARE NUMROWS INTEGER;
BEGIN
  /* erwin Builtin Trigger */
  /* Exerciser  Count on child update restrict */
  /* ERWIN_RELATION:CHECKSUM="0000efb3", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="Count"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_10", FK_COLUMNS="exerciserId" */
  SELECT count(*) INTO NUMROWS
    FROM Exerciser
    WHERE
      /* %JoinFKPK(:%New,Exerciser," = "," AND") */
      :new.exerciserId = Exerciser.exerciserId;
  IF (
    /* %NotnullFK(:%New," IS NOT NULL AND") */
    
    NUMROWS = 0
  )
  THEN
    raise_application_error(
      -20007,
      'Cannot update Count because Exerciser does not exist.'
    );
  END IF;


-- erwin Builtin Trigger
END;
/


CREATE  TRIGGER tI_Record BEFORE INSERT ON Record for each row
-- erwin Builtin Trigger
-- INSERT trigger on Record 
DECLARE NUMROWS INTEGER;
BEGIN
    /* erwin Builtin Trigger */
    /* Exerciser  Record on child insert restrict */
    /* ERWIN_RELATION:CHECKSUM="0000f314", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="Record"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_29", FK_COLUMNS="exerciserId" */
    SELECT count(*) INTO NUMROWS
      FROM Exerciser
      WHERE
        /* %JoinFKPK(:%New,Exerciser," = "," AND") */
        :new.exerciserId = Exerciser.exerciserId;
    IF (
      /* %NotnullFK(:%New," IS NOT NULL AND") */
      
      NUMROWS = 0
    )
    THEN
      raise_application_error(
        -20002,
        'Cannot insert Record because Exerciser does not exist.'
      );
    END IF;


-- erwin Builtin Trigger
END;
/

CREATE  TRIGGER tU_Record AFTER UPDATE ON Record for each row
-- erwin Builtin Trigger
-- UPDATE trigger on Record 
DECLARE NUMROWS INTEGER;
BEGIN
  /* erwin Builtin Trigger */
  /* Exerciser  Record on child update restrict */
  /* ERWIN_RELATION:CHECKSUM="0000f5dc", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="Record"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_29", FK_COLUMNS="exerciserId" */
  SELECT count(*) INTO NUMROWS
    FROM Exerciser
    WHERE
      /* %JoinFKPK(:%New,Exerciser," = "," AND") */
      :new.exerciserId = Exerciser.exerciserId;
  IF (
    /* %NotnullFK(:%New," IS NOT NULL AND") */
    
    NUMROWS = 0
  )
  THEN
    raise_application_error(
      -20007,
      'Cannot update Record because Exerciser does not exist.'
    );
  END IF;


-- erwin Builtin Trigger
END;
/


CREATE  TRIGGER tI_ToExercise BEFORE INSERT ON ToExercise for each row
-- erwin Builtin Trigger
-- INSERT trigger on ToExercise 
DECLARE NUMROWS INTEGER;
BEGIN
    /* erwin Builtin Trigger */
    /* Exerciser  ToExercise on child insert restrict */
    /* ERWIN_RELATION:CHECKSUM="0000fc5c", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="ToExercise"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_3", FK_COLUMNS="exerciserId" */
    SELECT count(*) INTO NUMROWS
      FROM Exerciser
      WHERE
        /* %JoinFKPK(:%New,Exerciser," = "," AND") */
        :new.exerciserId = Exerciser.exerciserId;
    IF (
      /* %NotnullFK(:%New," IS NOT NULL AND") */
      
      NUMROWS = 0
    )
    THEN
      raise_application_error(
        -20002,
        'Cannot insert ToExercise because Exerciser does not exist.'
      );
    END IF;


-- erwin Builtin Trigger
END;
/

CREATE  TRIGGER tU_ToExercise AFTER UPDATE ON ToExercise for each row
-- erwin Builtin Trigger
-- UPDATE trigger on ToExercise 
DECLARE NUMROWS INTEGER;
BEGIN
  /* erwin Builtin Trigger */
  /* Exerciser  ToExercise on child update restrict */
  /* ERWIN_RELATION:CHECKSUM="0000fd3a", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="ToExercise"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_3", FK_COLUMNS="exerciserId" */
  SELECT count(*) INTO NUMROWS
    FROM Exerciser
    WHERE
      /* %JoinFKPK(:%New,Exerciser," = "," AND") */
      :new.exerciserId = Exerciser.exerciserId;
  IF (
    /* %NotnullFK(:%New," IS NOT NULL AND") */
    
    NUMROWS = 0
  )
  THEN
    raise_application_error(
      -20007,
      'Cannot update ToExercise because Exerciser does not exist.'
    );
  END IF;


-- erwin Builtin Trigger
END;
/


CREATE  TRIGGER tI_Inbody BEFORE INSERT ON Inbody for each row
-- erwin Builtin Trigger
-- INSERT trigger on Inbody 
DECLARE NUMROWS INTEGER;
BEGIN
    /* erwin Builtin Trigger */
    /* Exerciser  Inbody on child insert restrict */
    /* ERWIN_RELATION:CHECKSUM="0000f98c", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="Inbody"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_2", FK_COLUMNS="exerciserId" */
    SELECT count(*) INTO NUMROWS
      FROM Exerciser
      WHERE
        /* %JoinFKPK(:%New,Exerciser," = "," AND") */
        :new.exerciserId = Exerciser.exerciserId;
    IF (
      /* %NotnullFK(:%New," IS NOT NULL AND") */
      
      NUMROWS = 0
    )
    THEN
      raise_application_error(
        -20002,
        'Cannot insert Inbody because Exerciser does not exist.'
      );
    END IF;


-- erwin Builtin Trigger
END;
/

CREATE  TRIGGER tU_Inbody AFTER UPDATE ON Inbody for each row
-- erwin Builtin Trigger
-- UPDATE trigger on Inbody 
DECLARE NUMROWS INTEGER;
BEGIN
  /* erwin Builtin Trigger */
  /* Exerciser  Inbody on child update restrict */
  /* ERWIN_RELATION:CHECKSUM="0000fce7", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="Inbody"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_2", FK_COLUMNS="exerciserId" */
  SELECT count(*) INTO NUMROWS
    FROM Exerciser
    WHERE
      /* %JoinFKPK(:%New,Exerciser," = "," AND") */
      :new.exerciserId = Exerciser.exerciserId;
  IF (
    /* %NotnullFK(:%New," IS NOT NULL AND") */
    
    NUMROWS = 0
  )
  THEN
    raise_application_error(
      -20007,
      'Cannot update Inbody because Exerciser does not exist.'
    );
  END IF;


-- erwin Builtin Trigger
END;
/


CREATE  TRIGGER tI_Message BEFORE INSERT ON Message for each row
-- erwin Builtin Trigger
-- INSERT trigger on Message 
DECLARE NUMROWS INTEGER;
BEGIN
    /* erwin Builtin Trigger */
    /* Exerciser  Message on child insert set null */
    /* ERWIN_RELATION:CHECKSUM="0001e11e", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="Message"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_17", FK_COLUMNS="receiverId" */
    UPDATE Message
      SET
        /* %SetFK(Message,NULL) */
        Message.receiverId = NULL
      WHERE
        NOT EXISTS (
          SELECT * FROM Exerciser
            WHERE
              /* %JoinFKPK(:%New,Exerciser," = "," AND") */
              :new.receiverId = Exerciser.exerciserId
        ) 
        /* %JoinPKPK(Message,:%New," = "," AND") */
         and Message.msgId = :new.msgId;

    /* erwin Builtin Trigger */
    /* Exerciser  Message on child insert set null */
    /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="Message"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_16", FK_COLUMNS="senderId" */
    UPDATE Message
      SET
        /* %SetFK(Message,NULL) */
        Message.senderId = NULL
      WHERE
        NOT EXISTS (
          SELECT * FROM Exerciser
            WHERE
              /* %JoinFKPK(:%New,Exerciser," = "," AND") */
              :new.senderId = Exerciser.exerciserId
        ) 
        /* %JoinPKPK(Message,:%New," = "," AND") */
         and Message.msgId = :new.msgId;


-- erwin Builtin Trigger
END;
/

CREATE  TRIGGER tU_Message AFTER UPDATE ON Message for each row
-- erwin Builtin Trigger
-- UPDATE trigger on Message 
DECLARE NUMROWS INTEGER;
BEGIN
  /* erwin Builtin Trigger */
  /* Exerciser  Message on child update no action */
  /* ERWIN_RELATION:CHECKSUM="00020c69", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="Message"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_17", FK_COLUMNS="receiverId" */
  SELECT count(*) INTO NUMROWS
    FROM Exerciser
    WHERE
      /* %JoinFKPK(:%New,Exerciser," = "," AND") */
      :new.receiverId = Exerciser.exerciserId;
  IF (
    /* %NotnullFK(:%New," IS NOT NULL AND") */
    :new.receiverId IS NOT NULL AND
    NUMROWS = 0
  )
  THEN
    raise_application_error(
      -20007,
      'Cannot update Message because Exerciser does not exist.'
    );
  END IF;

  /* erwin Builtin Trigger */
  /* Exerciser  Message on child update no action */
  /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="Message"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_16", FK_COLUMNS="senderId" */
  SELECT count(*) INTO NUMROWS
    FROM Exerciser
    WHERE
      /* %JoinFKPK(:%New,Exerciser," = "," AND") */
      :new.senderId = Exerciser.exerciserId;
  IF (
    /* %NotnullFK(:%New," IS NOT NULL AND") */
    :new.senderId IS NOT NULL AND
    NUMROWS = 0
  )
  THEN
    raise_application_error(
      -20007,
      'Cannot update Message because Exerciser does not exist.'
    );
  END IF;


-- erwin Builtin Trigger
END;
/


CREATE  TRIGGER tI_FitMate BEFORE INSERT ON FitMate for each row
-- erwin Builtin Trigger
-- INSERT trigger on FitMate 
DECLARE NUMROWS INTEGER;
BEGIN
    /* erwin Builtin Trigger */
    /* Exerciser  FitMate on child insert restrict */
    /* ERWIN_RELATION:CHECKSUM="0001f3d2", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="FitMate"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_21", FK_COLUMNS="exerciser2" */
    SELECT count(*) INTO NUMROWS
      FROM Exerciser
      WHERE
        /* %JoinFKPK(:%New,Exerciser," = "," AND") */
        :new.exerciser2 = Exerciser.exerciserId;
    IF (
      /* %NotnullFK(:%New," IS NOT NULL AND") */
      
      NUMROWS = 0
    )
    THEN
      raise_application_error(
        -20002,
        'Cannot insert FitMate because Exerciser does not exist.'
      );
    END IF;

    /* erwin Builtin Trigger */
    /* Exerciser  FitMate on child insert restrict */
    /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="FitMate"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_18", FK_COLUMNS="exerciser1" */
    SELECT count(*) INTO NUMROWS
      FROM Exerciser
      WHERE
        /* %JoinFKPK(:%New,Exerciser," = "," AND") */
        :new.exerciser1 = Exerciser.exerciserId;
    IF (
      /* %NotnullFK(:%New," IS NOT NULL AND") */
      
      NUMROWS = 0
    )
    THEN
      raise_application_error(
        -20002,
        'Cannot insert FitMate because Exerciser does not exist.'
      );
    END IF;


-- erwin Builtin Trigger
END;
/

CREATE  TRIGGER tU_FitMate AFTER UPDATE ON FitMate for each row
-- erwin Builtin Trigger
-- UPDATE trigger on FitMate 
DECLARE NUMROWS INTEGER;
BEGIN
  /* erwin Builtin Trigger */
  /* Exerciser  FitMate on child update restrict */
  /* ERWIN_RELATION:CHECKSUM="0001f5c8", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="FitMate"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_21", FK_COLUMNS="exerciser2" */
  SELECT count(*) INTO NUMROWS
    FROM Exerciser
    WHERE
      /* %JoinFKPK(:%New,Exerciser," = "," AND") */
      :new.exerciser2 = Exerciser.exerciserId;
  IF (
    /* %NotnullFK(:%New," IS NOT NULL AND") */
    
    NUMROWS = 0
  )
  THEN
    raise_application_error(
      -20007,
      'Cannot update FitMate because Exerciser does not exist.'
    );
  END IF;

  /* erwin Builtin Trigger */
  /* Exerciser  FitMate on child update restrict */
  /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="FitMate"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_18", FK_COLUMNS="exerciser1" */
  SELECT count(*) INTO NUMROWS
    FROM Exerciser
    WHERE
      /* %JoinFKPK(:%New,Exerciser," = "," AND") */
      :new.exerciser1 = Exerciser.exerciserId;
  IF (
    /* %NotnullFK(:%New," IS NOT NULL AND") */
    
    NUMROWS = 0
  )
  THEN
    raise_application_error(
      -20007,
      'Cannot update FitMate because Exerciser does not exist.'
    );
  END IF;


-- erwin Builtin Trigger
END;
/


CREATE  TRIGGER tI_RecommendList BEFORE INSERT ON RecommendList for each row
-- erwin Builtin Trigger
-- INSERT trigger on RecommendList 
DECLARE NUMROWS INTEGER;
BEGIN
    /* erwin Builtin Trigger */
    /* Exerciser  RecommendList on child insert restrict */
    /* ERWIN_RELATION:CHECKSUM="00041b04", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="RecommendList"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_37", FK_COLUMNS="recomId3" */
    SELECT count(*) INTO NUMROWS
      FROM Exerciser
      WHERE
        /* %JoinFKPK(:%New,Exerciser," = "," AND") */
        :new.recomId3 = Exerciser.exerciserId;
    IF (
      /* %NotnullFK(:%New," IS NOT NULL AND") */
      
      NUMROWS = 0
    )
    THEN
      raise_application_error(
        -20002,
        'Cannot insert RecommendList because Exerciser does not exist.'
      );
    END IF;

    /* erwin Builtin Trigger */
    /* Exerciser  RecommendList on child insert restrict */
    /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="RecommendList"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_36", FK_COLUMNS="recomId2" */
    SELECT count(*) INTO NUMROWS
      FROM Exerciser
      WHERE
        /* %JoinFKPK(:%New,Exerciser," = "," AND") */
        :new.recomId2 = Exerciser.exerciserId;
    IF (
      /* %NotnullFK(:%New," IS NOT NULL AND") */
      
      NUMROWS = 0
    )
    THEN
      raise_application_error(
        -20002,
        'Cannot insert RecommendList because Exerciser does not exist.'
      );
    END IF;

    /* erwin Builtin Trigger */
    /* Exerciser  RecommendList on child insert restrict */
    /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="RecommendList"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_35", FK_COLUMNS="recomId1" */
    SELECT count(*) INTO NUMROWS
      FROM Exerciser
      WHERE
        /* %JoinFKPK(:%New,Exerciser," = "," AND") */
        :new.recomId1 = Exerciser.exerciserId;
    IF (
      /* %NotnullFK(:%New," IS NOT NULL AND") */
      
      NUMROWS = 0
    )
    THEN
      raise_application_error(
        -20002,
        'Cannot insert RecommendList because Exerciser does not exist.'
      );
    END IF;

    /* erwin Builtin Trigger */
    /* Exerciser  RecommendList on child insert restrict */
    /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="RecommendList"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_25", FK_COLUMNS="exerciserId" */
    SELECT count(*) INTO NUMROWS
      FROM Exerciser
      WHERE
        /* %JoinFKPK(:%New,Exerciser," = "," AND") */
        :new.exerciserId = Exerciser.exerciserId;
    IF (
      /* %NotnullFK(:%New," IS NOT NULL AND") */
      
      NUMROWS = 0
    )
    THEN
      raise_application_error(
        -20002,
        'Cannot insert RecommendList because Exerciser does not exist.'
      );
    END IF;


-- erwin Builtin Trigger
END;
/

CREATE  TRIGGER tU_RecommendList AFTER UPDATE ON RecommendList for each row
-- erwin Builtin Trigger
-- UPDATE trigger on RecommendList 
DECLARE NUMROWS INTEGER;
BEGIN
  /* erwin Builtin Trigger */
  /* Exerciser  RecommendList on child update restrict */
  /* ERWIN_RELATION:CHECKSUM="00041e46", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="RecommendList"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_37", FK_COLUMNS="recomId3" */
  SELECT count(*) INTO NUMROWS
    FROM Exerciser
    WHERE
      /* %JoinFKPK(:%New,Exerciser," = "," AND") */
      :new.recomId3 = Exerciser.exerciserId;
  IF (
    /* %NotnullFK(:%New," IS NOT NULL AND") */
    
    NUMROWS = 0
  )
  THEN
    raise_application_error(
      -20007,
      'Cannot update RecommendList because Exerciser does not exist.'
    );
  END IF;

  /* erwin Builtin Trigger */
  /* Exerciser  RecommendList on child update restrict */
  /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="RecommendList"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_36", FK_COLUMNS="recomId2" */
  SELECT count(*) INTO NUMROWS
    FROM Exerciser
    WHERE
      /* %JoinFKPK(:%New,Exerciser," = "," AND") */
      :new.recomId2 = Exerciser.exerciserId;
  IF (
    /* %NotnullFK(:%New," IS NOT NULL AND") */
    
    NUMROWS = 0
  )
  THEN
    raise_application_error(
      -20007,
      'Cannot update RecommendList because Exerciser does not exist.'
    );
  END IF;

  /* erwin Builtin Trigger */
  /* Exerciser  RecommendList on child update restrict */
  /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="RecommendList"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_35", FK_COLUMNS="recomId1" */
  SELECT count(*) INTO NUMROWS
    FROM Exerciser
    WHERE
      /* %JoinFKPK(:%New,Exerciser," = "," AND") */
      :new.recomId1 = Exerciser.exerciserId;
  IF (
    /* %NotnullFK(:%New," IS NOT NULL AND") */
    
    NUMROWS = 0
  )
  THEN
    raise_application_error(
      -20007,
      'Cannot update RecommendList because Exerciser does not exist.'
    );
  END IF;

  /* erwin Builtin Trigger */
  /* Exerciser  RecommendList on child update restrict */
  /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="RecommendList"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_25", FK_COLUMNS="exerciserId" */
  SELECT count(*) INTO NUMROWS
    FROM Exerciser
    WHERE
      /* %JoinFKPK(:%New,Exerciser," = "," AND") */
      :new.exerciserId = Exerciser.exerciserId;
  IF (
    /* %NotnullFK(:%New," IS NOT NULL AND") */
    
    NUMROWS = 0
  )
  THEN
    raise_application_error(
      -20007,
      'Cannot update RecommendList because Exerciser does not exist.'
    );
  END IF;


-- erwin Builtin Trigger
END;
/


CREATE  TRIGGER tI_MatchingStatus BEFORE INSERT ON MatchingStatus for each row
-- erwin Builtin Trigger
-- INSERT trigger on MatchingStatus 
DECLARE NUMROWS INTEGER;
BEGIN
    /* erwin Builtin Trigger */
    /* Exerciser  MatchingStatus on child insert restrict */
    /* ERWIN_RELATION:CHECKSUM="0002027f", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="MatchingStatus"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_39", FK_COLUMNS="senderId" */
    SELECT count(*) INTO NUMROWS
      FROM Exerciser
      WHERE
        /* %JoinFKPK(:%New,Exerciser," = "," AND") */
        :new.senderId = Exerciser.exerciserId;
    IF (
      /* %NotnullFK(:%New," IS NOT NULL AND") */
      
      NUMROWS = 0
    )
    THEN
      raise_application_error(
        -20002,
        'Cannot insert MatchingStatus because Exerciser does not exist.'
      );
    END IF;

    /* erwin Builtin Trigger */
    /* Exerciser  MatchingStatus on child insert restrict */
    /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="MatchingStatus"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_38", FK_COLUMNS="receiverId" */
    SELECT count(*) INTO NUMROWS
      FROM Exerciser
      WHERE
        /* %JoinFKPK(:%New,Exerciser," = "," AND") */
        :new.receiverId = Exerciser.exerciserId;
    IF (
      /* %NotnullFK(:%New," IS NOT NULL AND") */
      
      NUMROWS = 0
    )
    THEN
      raise_application_error(
        -20002,
        'Cannot insert MatchingStatus because Exerciser does not exist.'
      );
    END IF;


-- erwin Builtin Trigger
END;
/

CREATE  TRIGGER tU_MatchingStatus AFTER UPDATE ON MatchingStatus for each row
-- erwin Builtin Trigger
-- UPDATE trigger on MatchingStatus 
DECLARE NUMROWS INTEGER;
BEGIN
  /* erwin Builtin Trigger */
  /* Exerciser  MatchingStatus on child update restrict */
  /* ERWIN_RELATION:CHECKSUM="000209c4", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="MatchingStatus"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_39", FK_COLUMNS="senderId" */
  SELECT count(*) INTO NUMROWS
    FROM Exerciser
    WHERE
      /* %JoinFKPK(:%New,Exerciser," = "," AND") */
      :new.senderId = Exerciser.exerciserId;
  IF (
    /* %NotnullFK(:%New," IS NOT NULL AND") */
    
    NUMROWS = 0
  )
  THEN
    raise_application_error(
      -20007,
      'Cannot update MatchingStatus because Exerciser does not exist.'
    );
  END IF;

  /* erwin Builtin Trigger */
  /* Exerciser  MatchingStatus on child update restrict */
  /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="Exerciser"
    CHILD_OWNER="", CHILD_TABLE="MatchingStatus"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_38", FK_COLUMNS="receiverId" */
  SELECT count(*) INTO NUMROWS
    FROM Exerciser
    WHERE
      /* %JoinFKPK(:%New,Exerciser," = "," AND") */
      :new.receiverId = Exerciser.exerciserId;
  IF (
    /* %NotnullFK(:%New," IS NOT NULL AND") */
    
    NUMROWS = 0
  )
  THEN
    raise_application_error(
      -20007,
      'Cannot update MatchingStatus because Exerciser does not exist.'
    );
  END IF;


-- erwin Builtin Trigger
END;
/

