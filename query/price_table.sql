CREATE TABLE demo.price (
    date VARCHAR(100) NOT NULL PRIMARY KEY COMMENT '日期',
    data_id VARCHAR(100) NOT NULL COMMENT '商品 ID',
    price DECIMAL(10, 2) NOT NULL COMMENT '價格',
    CONSTRAINT fk_product
        FOREIGN KEY (data_id) 
        REFERENCES demo.product(data_id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci
COMMENT='價格表';
