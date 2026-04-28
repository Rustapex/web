package book;

public class Book {
	String bookId;
	String title;
	String author;
	int price;
	int stock;
	
	public Book() {
		
	}

	public Book(String bookId, String title, String author, int price, int stock) {
		
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.price = price;
		this.stock = stock;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", author=" + author + ", price=" + price + ", stock="
				+ stock + "]";
	}

	

}
