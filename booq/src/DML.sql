use booqDB;

insert into Genre(id, genreName) values
  (1,'Action'),
  (2,'Adventure'),
  (3,'Comedy'),
  (4,'Crime'),
  (5,'Fiction'),
  (6,'Fantasy'),
  (7,'Historical'),
  (8,'Horror'),
  (9,'Mystery'),
  (10,'Philosophical'),
  (11,'Romance'),
  (12,'Science Fiction'),
  (13,'Thriller');

insert into Book(id, title, author, price, genreId, stock) values
  (1, 'My Name Is Dallas', 'Greg Kitzmiller', 44.99, 1, 5),
  (2, 'Harry Potter and the Rolling Indiana Jones Goblet', 'David Bowie', 24.99, 2, 1),
  (3, 'Greg','Dallas van Ess', 8.95, 3, 4),
  (4, 'The Last Murderer', 'Luke Selbeck', 8.95, 4, 7),
  (5, 'Bubbles in my ***', 'Henry XVI', 5.99, 5, 9),
  (6, 'My Fantasies', 'Greg Kitzmiller', 6.99, 6, 1),
  (7, 'A Brief History of WoW', 'Dallas van Ess', 8.95, 7, 3),
  (8, 'A Day With Luke', 'Luke Selbeck', 8.95, 8, 5),
  (9, 'Who Dun It?', 'David Bowie', 8.95, 9, 7),
  (10, 'What is Truth?', 'Greg Kitzmiller', 8.95, 10, 3),
  (11, 'Cowboys Past Curfew', 'Dallas van Ess', 8.95, 11, 2),
  (12, 'Robots', 'Henry XVI', 8.95, 12, 2),
  (13, 'Thriller', 'Michael Jackson', 8.95, 13, 1),
  (14, '50 Layers of Skin', 'Greg Kitzmiller', 8.95, 11, 14)