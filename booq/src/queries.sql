use booqDB;

select title, author, price, genreName from Book
	inner join Genre on Book.genreId = Genre.genreId;

select Book.id, title, author, price, stock, genreName, genreId, description
	from Book inner join Genre
	on Book.genreId = Genre.id;

select id, genreName from Genre;

select bookId, customerId, ratingDate, rating, description
	from Ratings
	where bookId = 5;

select id from Customer where email = 'john@gmail.com' and passwd = '1234';

select * from Customer inner join Address on addrId = Address.id;

select * from Address inner join Customer on Customer.addrId = Address.id;

select Book.id, title, author, price, stock, genreName, genreId, description, picturePath
	from Book inner join Genre on Book.genreId = Genre.id
	where Book.id = 1;

update Customer set addrId = 5 where id = 4;

select cName, title, quantity, orderDate
	from MainOrder
		inner join OrderLink
			on MainOrder.id = orderId
		inner join CartItem
			on itemId = CartItem.id
		inner join Customer
			on Customer.id = customerId
		inner join Book
			on Book.id = bookId;

select * from MainOrder;

select * from CartItem;

/*testing CreateOrder.getOrder()*/  
select * from OrderLink order by orderId;
select * from MainOrder where id = 5;
select * from CartItem;