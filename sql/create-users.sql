USE ARVORE_GENEALOGICA;

CREATE TABLE IF NOT EXISTS `users` (
  `user_id` bigint(20) unsigned NOT NULL auto_increment,
  `user_login` varchar(100) NOT NULL,
  `user_password` varchar(64) NOT NULL,
  `user_firstname` varchar(50) NOT NULL,
  `user_surname` varchar(50) NOT NULL,
  `user_email` varchar(100) NOT NULL,
  `user_registered` datetime NOT NULL,  
  PRIMARY KEY (`user_id`),
  KEY `idx_user_login_key` (`user_login`)
) DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;