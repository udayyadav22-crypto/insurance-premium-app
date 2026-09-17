package com.insurance;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.List;

public class Application {

    public static void main(String[] args) throws IOException {

        InsurancePremiumCalculator calculator =
                new InsurancePremiumCalculator();

        double premium = calculator.calculatePremium(65, 10000);

        List<Nominee> nominees = List.of(
                new Nominee("Nominee A", 50),
                new Nominee("Nominee B", 50)
        );

        NomineeService nomineeService = new NomineeService();

        System.out.println("Insurance Premium Application Started");
        System.out.println("Premium: " + premium);
        System.out.println("Nominee Allocation Valid: "
                + nomineeService.isValidAllocation(nominees));

        // Read application port from environment variable.
        // Default port is 8080 for Production.
        int port = Integer.parseInt(
                System.getenv().getOrDefault("APP_PORT", "8080"));

        HttpServer server = HttpServer.create(
                new InetSocketAddress(port), 0);

        server.createContext("/health", exchange -> {

            String response = "OK";

            exchange.sendResponseHeaders(200, response.length());

            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }
        });

        server.createContext("/premium", exchange -> {

            String response = "Premium: " + premium;

            exchange.sendResponseHeaders(200, response.length());

            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }
        });

        server.start();

        System.out.println("HTTP Server started on port " + port);
        System.out.println(
                "Health endpoint: http://localhost:" + port + "/health");
    }
}


