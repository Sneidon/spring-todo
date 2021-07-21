package za.co.mukondle.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.co.mukondle.entities.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> { }
