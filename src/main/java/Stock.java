public interface Stock {
    public void searchByAuthor();
    public void searchByISBN();
    public void searchByGenre();
    public void searchByPrice();
    public Book updateBookDetails();
    public void deleteBook();
}
