package za.co.mukondle.controllers.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.co.mukondle.controllers.dto.Response;
import za.co.mukondle.entities.Item;
import za.co.mukondle.repos.ItemRepository;

@RestController
@RequestMapping("/api")
public class ItemController {
	@Autowired
	private ItemRepository itemRepository;

	@GetMapping("/list")
	public @ResponseBody
	Iterable<Item> getAll() {
		return itemRepository.findAll();
	}

	@PostMapping("/add")
	public @ResponseBody
	Response addItem(@RequestParam Item item) {
		item = itemRepository.save(item);
		return new Response(true, item);
	}
}
