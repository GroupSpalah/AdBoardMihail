package org.bulletin_board.domain;

import org.bulletin_board.service.CrudService;
import org.bulletin_board.service.imp.AdServiceImpl;
import org.bulletin_board.service.imp.AuthorServiceImpl;
import org.bulletin_board.service.imp.CategoryServiceImpl;
import org.bulletin_board.service.imp.AddressServiceImpl;

import java.sql.SQLException;
import java.time.LocalDate;

public class Test {
    public static void main(String[] args) throws SQLException {
        CrudService<Author> authorService = new AuthorServiceImpl();
        CrudService<Ad> adService = new AdServiceImpl();
        CrudService<Category> categoryService = new CategoryServiceImpl();
        CrudService<Address> addressService = new AddressServiceImpl();

        Category auto = new Category(0, "Auto");

        Ad ad = new Ad(0,"BMW", LocalDate.now(), "buy a car", 150, auto);

        Address address = new Address(0, "Kyiv", "Ukraine");

        Phone phone = new Phone(0, "088-88-22-45");

        Email email = new Email(0, "jack@gmail.com");

        Author author = new Author(0, "Jack", phone, address, email, ad);
        Author author1 = new Author(0, "John", phone, address, email, ad);

        address.setAuthor(author);

        categoryService.add(auto);
        Category category = categoryService.findById(1);
        ad.setCategory(category);

        adService.add(ad);
        Ad adServiceById = adService.findById(1);
        author.setAd(adServiceById);

        authorService.add(author);

    }
}
