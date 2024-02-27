INSERT INTO author (name)
VALUES (unnest(array['King', 'Dostoevsky', 'Pushkin', 'Allan Poe', 'Lovecraft']));

INSERT INTO publisher (name)
VALUES (unnest(array['house1', 'house2', 'house3', 'house4', 'house5']));

INSERT INTO book (title, price, author_id, publisher_id)
VALUES ('Good book', 12.53, 1, 2);

INSERT INTO book (title, price, author_id, publisher_id)
VALUES ('Good book part 2', 14.80, 1, 2);