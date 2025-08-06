
package modelo;


public class Book {
    private String title;
    private String author;
    private String genre;
   
    private int codigo;

    /*public Book(String title, String author, String genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
    }*/

    // Getters and Setters
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

     public String getGenre() {
        return genre;
    }

   public void setGenre(String genre) {
        this.genre = genre;
    }

   
   
    
     public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
   
   

    
 
}
