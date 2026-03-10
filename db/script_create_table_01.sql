BEGIN;
-- ============================================================
--  generic_ecommerce — DDL completo
--  Orden respetando dependencias (FK)
-- ============================================================

-- ------------------------------------------------------------
-- 1. password
-- ------------------------------------------------------------
CREATE TABLE password (
    id                  BIGSERIAL    NOT NULL,
    password_encrypted  VARCHAR(255) NOT NULL,
    salt                VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

-- ------------------------------------------------------------
-- 2. role
-- ------------------------------------------------------------
CREATE TABLE role (
    id                  BIGSERIAL    NOT NULL,
    code        VARCHAR(50)  NOT NULL,
    name        VARCHAR(100) NOT NULL,
    description VARCHAR(255),
    PRIMARY KEY (id)
);

-- ------------------------------------------------------------
-- 3. user_contact
-- ------------------------------------------------------------
CREATE TABLE user_contact (
    id           BIGSERIAL    NOT NULL,
    email        VARCHAR(255) NOT NULL,
    phone_number VARCHAR(50),
    indicative   VARCHAR(10),
    PRIMARY KEY (id)
);

-- ------------------------------------------------------------
-- 4. user_state
-- ------------------------------------------------------------
CREATE TABLE user_state (
    id          BIGSERIAL    NOT NULL,
    code        VARCHAR(50)  NOT NULL,
    name        VARCHAR(100) NOT NULL,
    title       VARCHAR(100),
    description VARCHAR(255),
    PRIMARY KEY (id)
);

-- ------------------------------------------------------------
-- 5. email_template
-- ------------------------------------------------------------
CREATE TABLE email_template (
    id            BIGSERIAL    NOT NULL,
    email_code    VARCHAR(100) NOT NULL,
    email_subject VARCHAR(255) NOT NULL,
    email_title   VARCHAR(255),
    message       VARCHAR(2000),
    enabled       BOOLEAN      NOT NULL DEFAULT TRUE,
    PRIMARY KEY (id)
);

-- ------------------------------------------------------------
-- 6. users 
-- ------------------------------------------------------------
CREATE TABLE users  (
    id              BIGSERIAL    NOT NULL,
    password_id     BIGINT       NOT NULL,
    role_id         BIGINT       NOT NULL,
    first_name      VARCHAR(100) NOT NULL,
    last_name       VARCHAR(100) NOT NULL,
    user_contact_id BIGINT,
    avatar_file_id  BIGINT,
    created_at      DATE         NOT NULL,
    user_state_id   BIGINT,
    birthday        DATE,
    PRIMARY KEY (id),

    CONSTRAINT fk_user_password
        FOREIGN KEY (password_id)
        REFERENCES password (id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,

    CONSTRAINT fk_user_role
        FOREIGN KEY (role_id)
        REFERENCES role (id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,

    CONSTRAINT fk_user_contact
        FOREIGN KEY (user_contact_id)
        REFERENCES user_contact (id)
        ON DELETE SET NULL
        ON UPDATE CASCADE,

    CONSTRAINT fk_user_state
        FOREIGN KEY (user_state_id)
        REFERENCES user_state (id)
        ON DELETE SET NULL
        ON UPDATE CASCADE
);

-- ------------------------------------------------------------
-- 7. file
-- ------------------------------------------------------------
CREATE TABLE file (
    id       BIGSERIAL    NOT NULL,
    base64   TEXT,
    url_file VARCHAR(500),
    PRIMARY KEY (id)
);

-- ------------------------------------------------------------
-- 8. category
-- ------------------------------------------------------------
CREATE TABLE category (
    id   BIGSERIAL    NOT NULL,
    name VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

-- ------------------------------------------------------------
-- 9. price
-- ------------------------------------------------------------
CREATE TABLE price (
    id         BIGSERIAL      NOT NULL,
    price      DECIMAL(17, 2) NOT NULL,
    cost_price DECIMAL(17, 2),
    PRIMARY KEY (id)
);

-- ------------------------------------------------------------
-- 10. product
-- ------------------------------------------------------------
CREATE TABLE product (
    id                BIGSERIAL    NOT NULL,
    title             VARCHAR(255) NOT NULL,
    price_id          BIGINT       NOT NULL,
    description       VARCHAR(1000),
    short_description VARCHAR(255),
    category_id       BIGINT,
    file_id           BIGINT,
    PRIMARY KEY (id),

    CONSTRAINT fk_product_price
        FOREIGN KEY (price_id)
        REFERENCES price (id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,

    CONSTRAINT fk_product_category
        FOREIGN KEY (category_id)
        REFERENCES category (id)
        ON DELETE SET NULL
        ON UPDATE CASCADE,

    CONSTRAINT fk_product_file
        FOREIGN KEY (file_id)
        REFERENCES file (id)
        ON DELETE SET NULL
        ON UPDATE CASCADE
);

-- ------------------------------------------------------------
-- 11. cart
-- ------------------------------------------------------------
CREATE TABLE cart (
    id                BIGSERIAL    NOT NULL,
    total_amount      DECIMAL(19, 2),
    sub_total_amount  DECIMAL(19, 2),
    user_id           BIGINT,
    PRIMARY KEY (id),

    CONSTRAINT fk_cart_user
        FOREIGN KEY (user_id)
        REFERENCES users (id)
        ON DELETE SET NULL
        ON UPDATE CASCADE
);

-- ------------------------------------------------------------
-- 12. cart_product  (tabla intermedia cart <-> product)
-- ------------------------------------------------------------
CREATE TABLE cart_product (
    id         BIGSERIAL NOT NULL,
    cart_id    BIGINT    NOT NULL,
    product_id BIGINT    NOT NULL,
    created_at DATE,
    PRIMARY KEY (id),

    CONSTRAINT fk_cart_product_cart
        FOREIGN KEY (cart_id)
        REFERENCES cart (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,

    CONSTRAINT fk_cart_product_product
        FOREIGN KEY (product_id)
        REFERENCES product (id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);

-- ------------------------------------------------------------
-- 13. payment_state
-- ------------------------------------------------------------
CREATE TABLE payment_state (
    id          BIGSERIAL    NOT NULL,
    code        VARCHAR(50)  NOT NULL,
    name        VARCHAR(100) NOT NULL,
    title       VARCHAR(100),
    description VARCHAR(255),
    PRIMARY KEY (id)
);

-- ------------------------------------------------------------
-- 14. payment_method
-- ------------------------------------------------------------
CREATE TABLE payment_method (
    id          BIGSERIAL    NOT NULL,
    code        VARCHAR(50)  NOT NULL,
    name        VARCHAR(100) NOT NULL,
    title       VARCHAR(100),
    description VARCHAR(255),
    PRIMARY KEY (id)
);

-- ------------------------------------------------------------
-- 15. payment
-- ------------------------------------------------------------
CREATE TABLE payment (
    id                BIGSERIAL      NOT NULL,
    created_at        DATE           NOT NULL,
    amount            DECIMAL(17, 2) NOT NULL,
    payment_state_id  BIGINT,
    cart_id           BIGINT,
    payment_method_id BIGINT,
    PRIMARY KEY (id),

    CONSTRAINT fk_payment_state
        FOREIGN KEY (payment_state_id)
        REFERENCES payment_state (id)
        ON DELETE SET NULL
        ON UPDATE CASCADE,

    CONSTRAINT fk_payment_cart
        FOREIGN KEY (cart_id)
        REFERENCES cart (id)
        ON DELETE SET NULL
        ON UPDATE CASCADE,

    CONSTRAINT fk_payment_method
        FOREIGN KEY (payment_method_id)
        REFERENCES payment_method (id)
        ON DELETE SET NULL
        ON UPDATE CASCADE
);

-- ------------------------------------------------------------
-- 16. order_state
-- ------------------------------------------------------------
CREATE TABLE order_state (
    id          BIGSERIAL    NOT NULL,
    code        VARCHAR(50)  NOT NULL,
    name        VARCHAR(100) NOT NULL,
    title       VARCHAR(100),
    description VARCHAR(255),
    PRIMARY KEY (id)
);

-- ------------------------------------------------------------
-- 17. order
-- ------------------------------------------------------------
CREATE TABLE orders (
    id                BIGSERIAL    NOT NULL,
    order_state_id    BIGINT,
    url_file          VARCHAR(500),
    created_at        DATE         NOT NULL,
    last_modification DATE,
    cart_id           BIGINT,
    PRIMARY KEY (id),

    CONSTRAINT fk_order_state
        FOREIGN KEY (order_state_id)
        REFERENCES order_state (id)
        ON DELETE SET NULL
        ON UPDATE CASCADE,

    CONSTRAINT fk_order_cart
        FOREIGN KEY (cart_id)
        REFERENCES cart (id)
        ON DELETE SET NULL
        ON UPDATE CASCADE
);

COMMIT;