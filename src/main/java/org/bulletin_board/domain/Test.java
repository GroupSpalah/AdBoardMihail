package org.bulletin_board.domain;

import org.bulletin_board.service.AdService;
import org.bulletin_board.service.CategoryService;
import org.bulletin_board.service.CrudService;
import org.bulletin_board.service.imp.AdServiceImpl;
import org.bulletin_board.service.imp.AuthorServiceImpl;
import org.bulletin_board.service.imp.CategoryServiceImpl;

import java.sql.SQLException;
import java.time.LocalDate;

public class Test {
    public static void main(String[] args) throws SQLException {
        CrudService<Author> authorService = new AuthorServiceImpl();
        AdService adService = new AdServiceImpl();
        CategoryService categoryService = new CategoryServiceImpl();

        Category auto = Category.builder()
                .name("Auto")
                .build();

        Category car = Category.builder()
                .name("Car")
                .build();

        Ad ad = Ad.builder()
                .name("Volvo")
                .date(LocalDate.now())
                .text("change a car")
                .costService(150)
                .category(auto)
                .build();

        Address address = Address
                .builder()
                .city("Dnipro")
                .country("Ukraine")
                .build();

        Phone phone = Phone.builder()
                .number("089-234-12-56")
                .build();

        Email email = Email.builder()
                .name("Jack@gmail.com")
                .build();

        Author author = Author.builder()
                .name("Jack")
                .phone(phone)
                .address(address)
                .email(email)
                .build();

        address.setAuthor(author);

        categoryService.add(car);
        categoryService.add(auto);
        ad.setCategory(car);
        Category category = categoryService.findById(1);
        ad.setCategory(category);

        adService.add(ad);
        Ad adServiceById = adService.findById(1);

        authorService.add(author);

        adService.update(1);
        authorService.update(1);
        categoryService.update(1);

        adService.delete(1);
        categoryService.delete(1);

    }
}
