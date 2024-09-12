-- Вставка данных в таблицу parking
INSERT INTO parking (model, plate, paid, space, dateFrom, dateTo) VALUES
                                                                      ('BMW 328', 'LEL254', 'YES', '1', '2022-03-06', '2022-03-06'),
                                                                      ('VW GOLD', 'LTL232', 'NO', '3', '2022-03-06', '2022-03-06'),
                                                                      ('AUDI A5', 'RPL205', 'NO', '6', '2022-03-06', '2022-03-06'),
                                                                      ('TOYOTA YARIS', 'GUI456', 'YES', '9', '2022-03-06', '2022-03-06'),
                                                                      ('LEXUS LS460', 'LEY415', 'YES', '15', '2022-03-06', '2022-03-06');

-- Вставка данных в таблицу comment
INSERT INTO comment (text, parking_id) VALUES
                                           ('comment', 1),
                                           ('comment', 2),
                                           ('comment', 3),
                                           ('comment', 4),
                                           ('comment', 5),
                                           ('comment', 3);

-- Вставка данных в таблицу car
INSERT INTO car (brand, model, year, fuel_type, price) VALUES
                                                           ('Toyota', 'Camry', 2020, 'Petrol', 25000),
                                                           ('BMW', 'X5', 2019, 'Diesel', 40000),
                                                           ('Audi', 'A4', 2018, 'Petrol', 22000),
                                                           ('Mercedes', 'E-Class', 2021, 'Diesel', 45000);
