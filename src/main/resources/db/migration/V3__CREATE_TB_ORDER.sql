CREATE TABLE IF NOT EXISTS tb_order(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    customer_email VARCHAR(255),
    total_amount NUMERIC(10, 2)
)
