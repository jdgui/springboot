DROP TABLE IF EXISTS hs_user;
CREATE TABLE `hs_user` (
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'primary key',
    `user_id` BIGINT UNSIGNED NOT NULL COMMENT 'user id',
    `name` VARCHAR(64) NOT NULL DEFAULT '' COMMENT 'user name',
    `sex_code` TINYINT NOT NULL DEFAULT 0 COMMENT 'sex code',
    `age` INT UNSIGNED NOT NULL DEFAULT 0 COMMENT 'age',
    `remark` VARCHAR(256) NOT NULL DEFAULT '' COMMENT 'remark',
    `state_code` TINYINT NOT NULL DEFAULT 0 COMMENT 'state code',
    `create_time` TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT 'create time',
    `update_time` TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT 'update time',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uniq_user_id` (`user_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4;
CREATE INDEX idx_name ON `hs_user`(`name`);




