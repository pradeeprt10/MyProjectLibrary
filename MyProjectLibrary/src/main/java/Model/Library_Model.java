package Model;

public class Library_Model {
	private int Bookid;
	private String Titel;
	private String Author;
	private double price;
	private int Page;

	/**
	 * @param bookid
	 * @param titel
	 * @param author
	 * @param price
	 * @param page
	 */
	public Library_Model() {
		super();
//		this.Bookid = 1;
//		this.Titel = "";
//		this.Author = "";
//		this.price = 1.0;
//		Page = 1;
	}

	/**
	 * @param bookid
	 * @param titel
	 * @param author
	 * @param price
	 * @param page
	 */
	public Library_Model(int bookid, String titel, String author, double price, int page) {
		super();
		this.Bookid = bookid;
		this.Titel = titel;
		this.Author = author;
		this.price = price;
		this.Page = page;
	}

	public int getBookid() {
		return Bookid;
	}

	public void setBookid(int bookid) {
		Bookid = bookid;
	}

	public String getTitel() {
		return Titel;
	}

	public void setTitel(String titel) {
		Titel = titel;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getPage() {
		return Page;
	}

	public void setPage(int page) {
		Page = page;
	}

	}
