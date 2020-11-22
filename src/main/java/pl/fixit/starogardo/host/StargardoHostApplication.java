package pl.fixit.starogardo.host;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.fixit.starogardo.host.company.*;
import pl.fixit.starogardo.host.food.FoodProductRepository;
import pl.fixit.starogardo.host.product.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.util.Collections;

@SpringBootApplication
public class StargardoHostApplication {

	public static void main(String[] args) {
		SpringApplication.run(StargardoHostApplication.class, args);
	}


	@Bean
	CommandLineRunner runner(CompanyRepository companyRepository, ProductRepository productRepository, SubCategoriesRepository subCategoriesRepository, FoodProductRepository foodProductRepository, RetailProductRepository retailProductRepository, CompanyCategoryRepository companyCategoryRepository) throws IOException {
		byte[] bytes = this.getClass().getClassLoader().getResourceAsStream("zaba.png")
					.readAllBytes();
		//"some data".getBytes();
		return args -> {
			CompanyCategory companyCategory = companyCategoryRepository.save(new CompanyCategory(1l, "Jedzenie"));
			CompanyCategory companyCategory1 = companyCategoryRepository.save(new CompanyCategory(2l, "Zakupy"));
			SubCategories subCategories = subCategoriesRepository.save(new SubCategories(0l,"sushi", companyCategory));
			SubCategories subCategories1 = subCategoriesRepository.save(new SubCategories(1l,"pizza", companyCategory));
			SubCategories subCategories2 = subCategoriesRepository.save(new SubCategories(2l,"burger", companyCategory));
			SubCategories subCategories3 = subCategoriesRepository.save(new SubCategories(3l,"chinczyk", companyCategory));
			SubCategories subCategories4 = subCategoriesRepository.save(new SubCategories(4l,"hinuds", companyCategory));
			SubCategories subCategories5 = subCategoriesRepository.save(new SubCategories(5l,"owoce morza", companyCategory));
			SubCategories subCategories6 = subCategoriesRepository.save(new SubCategories(6l,"kebab", companyCategory));
			SubCategories subCategories7 = subCategoriesRepository.save(new SubCategories(7l,"spozywcze", companyCategory));
			SubCategories subCategories8 = subCategoriesRepository.save(new SubCategories(8l,"meblowy", companyCategory1));
			SubCategories subCategories9 = subCategoriesRepository.save(new SubCategories(9l,"budowlany", companyCategory1));
			SubCategories subCategories10 = subCategoriesRepository.save(new SubCategories(10l,"sportowy", companyCategory1));
			SubCategories subCategories11= subCategoriesRepository.save(new SubCategories(11l,"ksiazki", companyCategory1));
			SubCategories subCategories12 = subCategoriesRepository.save(new SubCategories(12l,"dekoracje", companyCategory1));
			companyRepository.save(new Company(1l,"Pizzeria Paloma","332979093", companyCategory, Collections.singletonList(new SubCategories(1,"Pizza",companyCategory)), "losowy opis1", parseImage("PizzaPaloma.jpg"), "losowa ulica1","8296711906841661984","6250680088", "email@email1"));
			companyRepository.save(new Company(2l,"MoaBurger","132476083",companyCategory, Collections.singletonList(new SubCategories(2,"Burgery",companyCategory)), "losowy opis2", parseImage("MoaBurger.jpg"), "losowa ulica2","123456431907862","62213120088", "email@email2"));
			companyRepository.save(new Company(3l,"Sushi Hana","222276083",companyCategory, Collections.singletonList(new SubCategories(3,"Sushi",companyCategory)), "losowy opis3", parseImage("Sushi_Hana.jpg"), "losowa ulica3","444444444444","54523432421312", "email@email3"));
			productRepository.save(new Product(1l,"Margherita",new BigDecimal(19),"opis1", parseImage("pizza1.jpg"), Collections.singletonList(new SubCategories(4l,"hamburgery",companyCategory)), 1L));
			productRepository.save(new Product(2l,"Pepperoni",new BigDecimal(24),"opis2", parseImage("pizza2.jpg"), Collections.singletonList(new SubCategories(5l,"pizza",companyCategory)), 1L ));
			productRepository.save(new Product(3l,"Capriciosa",new BigDecimal(22),"opis3", parseImage("pizza3.jpg"), Collections.singletonList(new SubCategories(6l,"pizza",companyCategory)), 1L ));
			productRepository.save(new Product(10l,"Hawajska",new BigDecimal(25),"opis1", parseImage("pizza1.jpg"), Collections.singletonList(new SubCategories(4l,"hamburgery",companyCategory)), 1L));
			productRepository.save(new Product(11l,"Stargardzka",new BigDecimal(27),"opis2", parseImage("pizza2.jpg"), Collections.singletonList(new SubCategories(5l,"pizza",companyCategory)), 1L ));
			productRepository.save(new Product(12l,"Wiejska",new BigDecimal(28),"opis3", parseImage("pizza3.jpg"), Collections.singletonList(new SubCategories(6l,"pizza",companyCategory)), 1L ));
			subCategoriesRepository.save(subCategories);
			subCategoriesRepository.save(subCategories1);
			subCategoriesRepository.save(subCategories2);
			subCategoriesRepository.save(subCategories3);
			subCategoriesRepository.save(subCategories4);
			subCategoriesRepository.save(subCategories5);
			subCategoriesRepository.save(subCategories6);
			subCategoriesRepository.save(subCategories7);
			subCategoriesRepository.save(subCategories8);
			subCategoriesRepository.save(subCategories9);
			subCategoriesRepository.save(subCategories10);
			subCategoriesRepository.save(subCategories11);
			subCategoriesRepository.save(subCategories12);
			Product product = productRepository.save((new Product(4l,"nazwa1",new BigDecimal(1),"opis1", parseImage("pizza1.jpg"), Collections.singletonList(subCategories2), 2L)));
			Product product1 = productRepository.save((new Product(5l,"nazwa2",new BigDecimal(1),"opis2", parseImage("pizza2.jpg"), Collections.singletonList(subCategories3), 2L)));
			Product product2 = productRepository.save((new Product(6l,"nazwa3",new BigDecimal(1),"opis3", parseImage("pizza3.jpg"), Collections.singletonList(subCategories4),2L)));
			Product product3 = productRepository.save((new Product(7l,"nazwa4",new BigDecimal(1),"opis4", parseImage("pizza1.jpg"), Collections.singletonList(subCategories8),3L)));
			Product product4 = productRepository.save((new Product(8l,"nazwa5",new BigDecimal(1),"opis5", parseImage("pizza2.jpg"), Collections.singletonList(subCategories10),3L)));
			Product product5 = productRepository.save((new Product(9l,"nazwa6",new BigDecimal(1),"opis6", parseImage("pizza3.jpg"), Collections.singletonList(subCategories11),3L)));
			foodProductRepository.save(new FoodProduct(1l,product));
			foodProductRepository.save(new FoodProduct(2l,product1));
			foodProductRepository.save(new FoodProduct(3l,product2));
			retailProductRepository.save(new RetailProduct(1l,product3,2l));
			retailProductRepository.save(new RetailProduct(2l,product4,5l));
			retailProductRepository.save(new RetailProduct(3l,product5,11l));
		};
	}

	private byte[] parseImage(String name) throws IOException {
		return this.getClass().getClassLoader().getResourceAsStream(name)
				.readAllBytes();
	}
}


