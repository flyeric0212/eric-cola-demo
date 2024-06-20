CREATE TABLE `customer`
(
    `id`                 bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `customer_id`        varchar(64)  NOT NULL COMMENT '客户ID',
    `member_id`          varchar(64)  NOT NULL COMMENT '会员ID',
    `global_id`          varchar(100) NOT NULL COMMENT '全局ID',
    `company_name`       varchar(255) NOT NULL COMMENT '公司名称',
    `registered_capital` bigInt(21) NOT NULL DEFAULT 0 COMMENT '注册资金',
    `create_by`          varchar(64)  NOT NULL COMMENT '创建人',
    `create_time`        datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_by`          varchar(64)  NOT NULL COMMENT '最后修改人',
    `update_time`        datetime     NOT NULL COMMENT '最后修改时间',
    `delete_time`        datetime              DEFAULT NULL COMMENT '删除时间',
    `deleted`            tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除，0-未删除 1-已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uq_customer_id` (`customer_id`) USING BTREE,
    KEY                  `idx_member_id` (`member_id`),
    KEY                  `idx_global_id` (`global_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='客户表';

INSERT INTO `customer` (`id`, `customer_id`, `member_id`, `global_id`, `company_name`, `registered_capital`,
                        `create_by`, `create_time`, `update_by`, `update_time`, `delete_time`, `deleted`)
VALUES (1, '9c97dbe392374b45b1eaef4ad2918f7f', '9fa6d46c4a3b469c889c984186e8f480', '923f30cd45e14f4c9330d461127bc954',
        '公司A', 1000000, '张三', '2024-03-11 02:12:20', '张三', '2024-03-11 02:12:20', NULL, 0),
       (2, '03a267516bdc46f790b86075804a8d2a', '78204ee255f34e74b1e70df77cb5462e', '883b5a0d6282491ba2ab3040c1fc62f7',
        '公司B', 40000000, '李四', '2024-03-11 02:12:20', '王五', '2024-03-11 02:12:20', NULL, 0),
       (3, '948360d51a2b468da174dd727c7dc527', '28f6be2fbea74b38b3d879a3ba36bd44', '608fdb16694d438b88a0b8c8e9cb203d',
        '公司C', 5000000, '王五', '2024-03-11 02:12:20', '王五', '2024-03-11 02:12:20', NULL, 0);
