package com.pranay.EcommerceChatbotApplication.Controller;

import com.pranay.EcommerceChatbotApplication.Service.ChatbotService;
import com.pranay.EcommerceChatbotApplication.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins ="http://localhost:5173")
public class ChatbotController {
    @Autowired
    private ChatbotService chatbotService;
    @GetMapping("/products/top-sold")
    public List<TopProductDTO> topSoldProducts() {
        return chatbotService.getTopSoldProducts(5);
    }

    @GetMapping("/orders/{id}/status")
    public OrderStatusDTO orderStatus(@PathVariable Long id) {
        return chatbotService.getOrderStatus(id);
    }

    @GetMapping("/inventory/stock")
    public StockDTO productStock(@RequestParam String name) {
        return chatbotService.getStockByName(name);
    }

    @PostMapping("/chat")
    public ChatResponse chatbot(@RequestBody ChatRequest request) {
        return chatbotService.chat(request);
    }
}
