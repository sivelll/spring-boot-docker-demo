CREATE TABLE product (
    data_id VARCHAR(100) NOT NULL PRIMARY KEY COMMENT '商品 ID',
    name VARCHAR(255) NULL COMMENT '商品名稱',
    short_name VARCHAR(100) NULL COMMENT '商品短名稱',
    data_grouping VARCHAR(1) NULL COMMENT '是否分组'
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci
COMMENT='商品表';

