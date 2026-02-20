CREATE TABLE IF NOT EXISTS tb_product(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(255),
    amount NUMERIC(10, 2)
)
