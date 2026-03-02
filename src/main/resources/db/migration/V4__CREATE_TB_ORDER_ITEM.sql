CREATE TABLE IF NOT EXISTS tb_order_item(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    order_id UUID NOT NULL,
    product_id UUID NOT NULL,
    quantity INTEGER,
    unit_price NUMERIC(10, 2),
    subtotal NUMERIC(10, 2),
    FOREIGN KEY (order_id) REFERENCES tb_order(id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES tb_product(id)
)
