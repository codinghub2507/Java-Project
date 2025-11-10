package com.smartinventorymanagement.controller;

import com.smartinventorymanagement.model.InventoryItem;
import com.smartinventorymanagement.service.InventoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<InventoryItem> items = inventoryService.getAllItems();
        model.addAttribute("items", items);
        return "inventory/list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("item", new InventoryItem());
        return "inventory/add";
    }

    @PostMapping("/add")
    public String addItem(@ModelAttribute InventoryItem item) {
        inventoryService.addItem(item);
        return "redirect:/inventory/list";
    }

    @GetMapping("/sell")
    public String sellForm(Model model) {
        model.addAttribute("items", inventoryService.getAllItems());
        return "inventory/sell";
    }

    @PostMapping("/sell")
    public String sellItem(@RequestParam String id, @RequestParam int quantity) {
        InventoryItem item = inventoryService.getAllItems().stream()
                .filter(i -> i.getId().equals(id)).findFirst().orElse(null);
        if (item != null) item.setQuantity(item.getQuantity() - quantity);
        inventoryService.addItem(item); // save updated quantity
        return "redirect:/inventory/list";
    }

    @GetMapping("/restock")
    public String restockForm(Model model) {
        model.addAttribute("items", inventoryService.getAllItems());
        return "inventory/restock";
    }

    @PostMapping("/restock")
    public String restockItem(@RequestParam String id, @RequestParam int quantity) {
        InventoryItem item = inventoryService.getAllItems().stream()
                .filter(i -> i.getId().equals(id)).findFirst().orElse(null);
        if (item != null) item.setQuantity(item.getQuantity() + quantity);
        inventoryService.addItem(item); // save updated quantity
        return "redirect:/inventory/list";
    }

    @GetMapping("/low-stock")
    public String lowStock(Model model) {
        model.addAttribute("lowStock", inventoryService.getLowStockItems());
        return "inventory/low-stock";
    }
}
