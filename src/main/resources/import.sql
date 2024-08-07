INSERT INTO tb_role (id, authority) VALUES ('550e8400-e29b-41d4-a716-446655440000', 'ROLE_ADMIN');
INSERT INTO tb_role (id, authority) VALUES ('550e8400-e29b-41d4-a716-446655440001', 'ROLE_USER');

INSERT INTO tb_user (id, first_name, last_name, email, password, updated_at, created_at, deleted_at)VALUES ('550e8400-e29b-41d4-a716-446655440002', 'John', 'Doe', 'john.doe@example.com', 'password123', '2024-08-06 10:00:00', '2024-08-05 09:00:00', NULL);
INSERT INTO tb_user (id, first_name, last_name, email, password, updated_at, created_at, deleted_at)VALUES ('550e8400-e29b-41d4-a716-446655440003', 'Jane', 'Smith', 'jane.smith@example.com', 'password456', '2024-08-06 10:00:00', '2024-08-05 09:00:00', NULL);
INSERT INTO tb_user (id, first_name, last_name, email, password, updated_at, created_at, deleted_at)VALUES ('550e8400-e29b-41d4-a716-446655440004', 'Noah', 'Lourenço', 'Noah@example.com', 'password456', '2024-01-01 10:00:00', '2024-08-05 09:00:00', '2024-02-01 10:00:00');

INSERT INTO tb_user_role (user_id, role_id)VALUES ('550e8400-e29b-41d4-a716-446655440002', '550e8400-e29b-41d4-a716-446655440000');
INSERT INTO tb_user_role (user_id, role_id)VALUES ('550e8400-e29b-41d4-a716-446655440003', '550e8400-e29b-41d4-a716-446655440001');
