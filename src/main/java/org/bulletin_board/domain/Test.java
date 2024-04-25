package org.bulletin_board.domain;

import org.bulletin_board.service.AdService;
import org.bulletin_board.service.CrudService;
import org.bulletin_board.service.imp.AdServiceImpl;
import org.bulletin_board.service.imp.AuthorServiceImpl;
import org.bulletin_board.service.imp.CategoryServiceImpl;
import org.bulletin_board.service.imp.MatchingAdServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.time.LocalDate;

public class Test {
    public static void main(String[] args) throws SQLException {

        AnnotationConfigApplicationContext
                context = new AnnotationConfigApplicationContext(ConfigAppProject.class);

        AdService adService = context.getBean(AdServiceImpl.class);

        AuthorServiceImpl authorService = context.getBean(AuthorServiceImpl.class);

        CategoryServiceImpl categoryService = context.getBean(CategoryServiceImpl.class);

        MatchingAdServiceImpl matAdCrudService = context.getBean(MatchingAdServiceImpl.class);

//        CrudService<Author> authorService = new AuthorServiceImpl();
//        AdService adService = new AdServiceImpl();
//        CrudService<Category> categoryService = new CategoryServiceImpl();
//        CrudService<MatchingAd> matAdCrudService = new MatchingAdServiceImpl();

        Category auto = Category.builder()
                .name("Auto")
                .build();

        Category car = Category.builder()
                .name("Car")
                .build();

        Address address = Address
                .builder()
                .city("Kyiv")
                .country("Ukraine")
                .build();

        Phone phone = Phone.builder()
                .number("059-456-32-86")
                .build();

        Email email = Email.builder()
                .name("Mike@gmail.com")
                .build();

        Author jack = Author.builder()
                .name("Jack")
                .phone(phone)
                .address(address)
                .email(email)
                .build();

        Ad ad = Ad.builder()
                .name("BMW")
                .date(LocalDate.now())
                .text("buy a car")
                .costService(150)
                .category(auto)
                .author(jack)
                .build();

        MatchingAd matchingAd = MatchingAd.builder()
                .priceFrom(1000)
                .priceTo(2000)
                .tittle("BMW")
                .category(auto)
                .author(jack)
                .build();

        address.setAuthor(jack);

        authorService.add(jack);
        ad.setAuthor(jack);
        matchingAd.setAuthor(jack);


        Author author = authorService.findById(1);
        ad.setAuthor(author);
        matchingAd.setAuthor(author);

        categoryService.add(car);
        categoryService.add(auto);

        ad.setCategory(car);
        ad.setCategory(auto);
        Category category = categoryService.findById(1);
        ad.setCategory(category);
        matchingAd.setCategory(auto);

        adService.add(ad);
        matAdCrudService.add(matchingAd);

        category.setName("Bike");
        categoryService.update(category);

        author.setName("John");
        authorService.update(author);

        Ad ad1 = adService.findById(1);
        ad1.setCostService(800);
        ad1.setName("Nissan");

//        adService.update(ad1);

 //       adService.delete(1);
 //       categoryService.delete(1);
//        authorService.delete(3);
//
//        adService.showAd(auto);
//       adService.showByAuthor("Mike");
//        adService.showByKeyWord("buy");
        adService.showDate(LocalDate.now());


    }
}
