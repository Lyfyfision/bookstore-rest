INSERT INTO author (name)
VALUES (unnest(array['King', 'Dostoevsky', 'Pushkin', 'Allan Poe', 'Lovecraft']));

INSERT INTO publisher (name)
VALUES (unnest(array['house1', 'house2', 'house3', 'house4', 'house5']));

INSERT INTO book (title, price, author_id)
VALUES ('Good book', 12.53, 1);

INSERT INTO book (title, price, author_id)
VALUES ('Good book part 2', 14.80, 1);

INSERT INTO book (title, price, author_id)
VALUES ('SOme another book', 8, 3);

INSERT INTO book_publisher (book_id, publisher_id)
VALUES (1, 1), (2, 2), (1,3), (2,1), (2,5), (3,5);