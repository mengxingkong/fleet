CREATE TABLE `blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bloid` varchar(100) DEFAULT NULL,
  `author` varchar(45) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `content` longtext,
  `committime` varchar(45) DEFAULT NULL,
  `updatetime` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `comment` (
  `cid` int(11) NOT NULL,
  `user` varchar(45) DEFAULT NULL,
  `bloid` varchar(45) DEFAULT NULL,
  `content` longtext,
  `committime` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `sys_role` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `rname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `sys_user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(45) DEFAULT NULL,
  `upasswd` varchar(100) DEFAULT NULL,
  `lastmodified` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `sys_user_role` (
  `uid` int(11) NOT NULL,
  `rid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
