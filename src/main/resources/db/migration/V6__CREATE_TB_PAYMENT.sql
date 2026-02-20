CREATE TABLE IF NOT EXISTS tb_payment(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    order_id UUID NOT NULL,
    amount NUMERIC(10, 2),
    CONSTRAINT fk_order_id FOREIGN KEY (order_id) REFERENCES tb_order(id)
)