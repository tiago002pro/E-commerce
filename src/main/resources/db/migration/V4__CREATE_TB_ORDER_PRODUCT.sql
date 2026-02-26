CREATE TABLE IF NOT EXISTS tb_order_product(
    order_id UUID NOT NULL,
    product_id UUID NOT NULL,
    PRIMARY KEY (order_id, product_id),
    FOREIGN KEY (order_id) REFERENCES tb_order(id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES tb_product(id) ON DELETE CASCADE
)
