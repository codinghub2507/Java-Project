package com.smartinventorymanagement.controller;

import com.smartinventorymanagement.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    private final InventoryService inventoryService;

    @Autowired
    public ViewController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    // Dashboard with stats
    @GetMapping("/")
    public String dashboard(Model model) {
        model.addAttribute("totalItems", inventoryService.getTotalItems());
        model.addAttribute("lowStock", inventoryService.getLowStockItems());
        model.addAttribute("soldToday", inventoryService.getSoldToday());
        return "inventory/dashboard";
    }

    // Inventory list page
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("items", inventoryService.getAllItems());
        return "inventory/list";
    }

    // Add item page
    @GetMapping("/add")
    public String add() {
        return "inventory/add";
    }

    // Sell item page
    @GetMapping("/sell")
    public String sell(Model model) {
        model.addAttribute("items", inventoryService.getAllItems());
        return "inventory/sell";
    }

    // Restock item page
    @GetMapping("/restock")
    public String restock(Model model) {
        model.addAttribute("items", inventoryService.getAllItems());
        return "inventory/restock";
    }
}
