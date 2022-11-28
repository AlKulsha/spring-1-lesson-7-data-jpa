package ru.kulsha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kulsha.model.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByTitle(String title);

    List<Product> findAllByTitleContainingIgnoreCase(String title);
    //    select*from product where title like '%ll%




//    Product findByTitleAndPrice(String title, int price);


//    @Query(value = """
//            select p.title from Product p where p.id = :id
//            """)
//    String findWithDifficultQuery(Long id);


}
