package com.smartinventorymanagement.client;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class InventoryClient {
    public static void main(String[] args) throws Exception {
        String json = """
            {
                "name": "Keyboard",
                "quantity": 15,
                "price": 1200
            }
        """;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("http://localhost:8080/inventory"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Response: " + response.body());
    }
}
