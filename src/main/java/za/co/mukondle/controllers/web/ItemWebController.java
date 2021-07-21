package za.co.mukondle.controllers.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import za.co.mukondle.entities.Item;
import za.co.mukondle.enums.Type;
import za.co.mukondle.models.ItemListViewModel;
import za.co.mukondle.models.TypeListViewModel;
import za.co.mukondle.repos.ItemRepository;

import java.util.Optional;

@Controller
public class ItemWebController {
	@Autowired
	private ItemRepository itemRepository;

	@PostMapping("/add")
	public String add(@ModelAttribute Item requestItem) {
		Item item = new Item();
		item.setTitle(requestItem.getTitle());
		item.setDescription(requestItem.getDescription());
		item.setType(requestItem.getType());
		item.setComplete(requestItem.isComplete());
		itemRepository.save(item);
		return "redirect:/";
	}

	@GetMapping("/")
	public String index(Model model) {
		Iterable<Item> list = itemRepository.findAll();
		ItemListViewModel itemViewModel = new ItemListViewModel(list);
		TypeListViewModel typesViewModel = new TypeListViewModel();

		// Better to do with a Many to one relationship entity
		typesViewModel.addType(Type.ENTERTAINMENT);
		typesViewModel.addType(Type.FAMILY);
		typesViewModel.addType(Type.SPIRITUAL);

		model.addAttribute("items", itemViewModel);
		model.addAttribute("types", typesViewModel);
		model.addAttribute("template", new Item());

		return "/index";
	}

	@GetMapping("/add")
	public String add(Model model) {
		TypeListViewModel typesViewModel = new TypeListViewModel();

		// Better to do with a Many to one relationship entity
		typesViewModel.addType(Type.ENTERTAINMENT);
		typesViewModel.addType(Type.FAMILY);
		typesViewModel.addType(Type.SPIRITUAL);

		model.addAttribute("types", typesViewModel);
		model.addAttribute("template", new Item());

		return "/add";
	}

	@PostMapping("/complete")
	public String complete(@RequestParam(value = "id", required = true) Long id) {
		Optional<Item> itemOptional = itemRepository.findById(id);
		if(itemOptional.isPresent()) {
			Item item = itemOptional.get();
			item.setComplete(true);
			itemRepository.save(item);
		}

		return "redirect:/";
	}
}
