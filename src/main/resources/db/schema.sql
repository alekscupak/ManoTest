-- Удаление существующих таблиц, если они существуют
DROP TABLE IF EXISTS comment;
DROP TABLE IF EXISTS parking;
DROP TABLE IF EXISTS car;

-- Создание таблицы car
CREATE TABLE car (
                     id BIGINT IDENTITY PRIMARY KEY,
                     brand VARCHAR(255),
                     model VARCHAR(255),
                     year INT,
                     fuel_type VARCHAR(50),
                     price DECIMAL(10, 2)
);

-- Создание таблицы parking
CREATE TABLE parking (
                         id BIGINT IDENTITY PRIMARY KEY,
                         plate VARCHAR(255),
                         model VARCHAR(255),
                         space VARCHAR(255),
                         paid VARCHAR(255),
                         dateFrom DATE,  -- Изменено на DATE
                         dateTo DATE     -- Изменено на DATE
);

-- Создание таблицы comment
CREATE TABLE comment (
                         id BIGINT IDENTITY PRIMARY KEY,
                         text VARCHAR(255),
                         parking_id BIGINT,
                         FOREIGN KEY (parking_id) REFERENCES parking(id)
);