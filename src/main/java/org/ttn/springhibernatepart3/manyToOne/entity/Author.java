package org.ttn.springhibernatepart3.manyToOne.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @Embedded
    private Address address;


    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Subject> subjects=new HashSet<>();

    @OneToMany(mappedBy = "author",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
   private Set<Book> books;

    public Author() {
    }

    public Author(int id, String name, Address address, Set<Subject> subjects, Set<Book> books) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.subjects = subjects;
        this.books = books;
    }

    public void addBookDetails(Book bookDetails){
        if(bookDetails!=null){
            if(books==null){
                books=new HashSet<>();
            }
            bookDetails.setAuthor(this);
            books.add(bookDetails);
        }
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", subjects=" + subjects +
                ", books=" + books +
                '}';
    }
}
