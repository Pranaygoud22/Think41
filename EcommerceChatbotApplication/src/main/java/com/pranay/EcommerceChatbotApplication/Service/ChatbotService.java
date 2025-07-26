package com.pranay.EcommerceChatbotApplication.Service;

import com.pranay.EcommerceChatbotApplication.Model.Order;
import com.pranay.EcommerceChatbotApplication.Repository.InventoryItemRepo;
import com.pranay.EcommerceChatbotApplication.Repository.OrderItemRepo;
import com.pranay.EcommerceChatbotApplication.Repository.OrderRepo;
import com.pranay.EcommerceChatbotApplication.Repository.ProductRepo;
import com.pranay.EcommerceChatbotApplication.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ChatbotService {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private OrderItemRepo orderItemRepo;
    @Autowired
    private InventoryItemRepo inventoryItemRepo;
    @Autowired
    private OrderRepo orderRepo;

    public List<TopProductDTO> getTopSoldProducts(int limit)
    {
        List<Object[]> results = orderItemRepo.findByTopSoldProducts(limit);
        return results.stream().map(row -> new TopProductDTO((String) row[0],((Number)row[1]).intValue())).collect(Collectors.toList());

    }
    public OrderStatusDTO getOrderStatus(Long orderId)
    {
        Optional<Order> orderOpt = orderRepo.findById(orderId);
        if(orderOpt.isEmpty()){
            return new OrderStatusDTO(orderId,"order id not found");
        }
        Order order = orderOpt.get();
        return new OrderStatusDTO(order.getOrderId(),order.getStatus());
    }
    public StockDTO getStockByName(String productName) {
        int stockCount = inventoryItemRepo.countByProductNameAndSoldAtIsNull(productName);
        return new StockDTO(productName, stockCount);
    }

    public ChatResponse chat(ChatRequest request) {
        String question = request.getQuestion().toLowerCase();

        if (question.contains("top") && question.contains("sold")) {
            List<TopProductDTO> topSold = getTopSoldProducts(5);
            StringBuilder response = new StringBuilder("Top 5 most sold products:\n");
            for (TopProductDTO dto : topSold) {
                response.append(dto.getProductName())
                        .append(" - Sold: ")
                        .append(dto.getSoldCount()).append("\n");
            }
            return new ChatResponse(response.toString());
        }

        if (question.contains("status") && question.contains("order")) {
            Long orderId = extractOrderId(question);
            if (orderId != null) {
                OrderStatusDTO statusDTO = getOrderStatus(orderId);
                return new ChatResponse("Order ID " + statusDTO.getOrderId() + " status: " + statusDTO.getStatus());
            }
            return new ChatResponse("Couldn't identify Order ID.");
        }

        if (question.contains("how many") || question.contains("stock")) {
            String productName = extractProductName(question);
            if (productName != null) {
                StockDTO stockDTO = getStockByName(productName);
                return new ChatResponse("Stock left for " + stockDTO.getProductName() + ": " + stockDTO.getCount());
            }
            return new ChatResponse("Couldn't identify product name.");
        }

        return new ChatResponse("Sorry, I couldn't understand your question.");
    }

    private Long extractOrderId(String question) {
        String[] words = question.split("\\s+");
        for (String word : words) {
            try {
                return Long.parseLong(word.replaceAll("[^0-9]", ""));
            } catch (NumberFormatException ignored) {}
        }
        return null;
    }

    private String extractProductName(String question) {
        if (question.contains("classic t-shirt")) return "Classic T-Shirt";
        if (question.contains("jeans")) return "Jeans";
        return null;
    }
}
