CREATE TABLE iotnew
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(10),
    cls VARCHAR(10),
    tel VARCHAR(11),
    clsnum VARCHAR(16),
    email VARCHAR(20),
    detail TEXT
);
CREATE TABLE mechine
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    mechineName VARCHAR(30) NOT NULL
);
CREATE TABLE result
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    mechineId INT(11) NOT NULL,
    rate FLOAT(11) DEFAULT '0',
    count INT(11) DEFAULT '0',
    voteId INT(11) NOT NULL,
    voteName VARCHAR(30),
    excellentCount INT(11) DEFAULT '0',
    goodCount INT(11) DEFAULT '0',
    sosoCount INT(11) DEFAULT '0',
    unsatisfiedCount INT(11) DEFAULT '0'
);
CREATE TABLE user
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    user_name VARCHAR(40) NOT NULL,
    password VARCHAR(255) NOT NULL
);
CREATE TABLE vote
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    voteId INT(11) NOT NULL,
    result VARCHAR(60) NOT NULL,
    userId INT(11) NOT NULL,
    date DATE
);
CREATE TABLE voteList
(
    voteId INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    startTime DATE NOT NULL,
    endTime DATE NOT NULL,
    voteName VARCHAR(30) NOT NULL
);
CREATE TABLE voteuser
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    account VARCHAR(10) NOT NULL,
    password VARCHAR(10) NOT NULL,
    clsnum VARCHAR(16),
    tel VARCHAR(11),
    role INT(11) DEFAULT '1' NOT NULL
);
CREATE UNIQUE INDEX voteuser_account_uindex ON voteuser (account);
CREATE TABLE webchat
(
    webchatid VARCHAR(20) PRIMARY KEY NOT NULL,
    appid VARCHAR(20),
    secret VARCHAR(20),
    webchatopen VARCHAR(8)
);
CREATE TABLE webchatclient
(
    id INT(11) PRIMARY KEY NOT NULL,
    openid VARCHAR(20) NOT NULL COMMENT '用户的标识，对当前公众号唯一
',
    subscribe INT(11) COMMENT '用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息。',
    nickname VARCHAR(18) COMMENT '用户的昵称',
    sex INT(11) COMMENT '用户的性别，值为1时是男性，值为2时是女性，值为0时是未知',
    city VARCHAR(10) COMMENT '用户所在城市',
    country VARCHAR(10) COMMENT '用户所在国家',
    province VARCHAR(10) COMMENT '省份',
    headimgurl VARCHAR(256) COMMENT '用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。',
    unionid VARCHAR(64) COMMENT '只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段',
    remark VARCHAR(10) COMMENT '公众号运营者对粉丝的备注，公众号运营者可在微信公众平台用户管理界面对粉丝添加备注
',
    groupid INT(11) COMMENT '用户所在的分组ID
',
    new_column INT(11),
    language VARCHAR(10),
    subscribe_time VARCHAR(20)
);