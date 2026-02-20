CREATE TABLE IF NOT EXISTS tb_stock(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    product_id UUID REFERENCES tb_product(id),
    stock INTEGER
)
