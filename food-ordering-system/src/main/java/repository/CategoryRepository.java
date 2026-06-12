package repository;

import entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Repository responsible for database operations
 * It related to Category entities.
 */
public interface CategoryRepository extends JpaRepository<Category,Long> {

}
