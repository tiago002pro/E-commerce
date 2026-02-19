CREATE TABLE IF NOT EXISTS tb_order_product(
    order_id UUID REFERENCES tb_order(id),
    product_id UUID REFERENCES tb_product(id),
    PRIMARY KEY (order_id, product_id)
)
