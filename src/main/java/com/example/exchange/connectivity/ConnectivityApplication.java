package com.example.exchange.connectivity;

import com.example.exchange.connectivity.Model.Order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;


	@SpringBootApplication
	public class ConnectivityApplication {
		private static String API_KEY = "2b6f4744-e23d-48a9-aa6a-6e08c4958c48";




		public static void main(String[] args) {

			SpringApplication.run(ConnectivityApplication.class, args);

			String base_order_url = "https://exchange.matraining.com/" + API_KEY;
			WebClient webClient = WebClient
					.builder()
					.baseUrl(base_order_url)
					.defaultHeader("Content-Type", "application/json")
					.build();


			Order Order1 = new Order("GOOGL", 1,1.5,"BUY");

			String id = webClient
					.post().uri("/order")
					.body(Mono.just(Order1), Order.class)
					.retrieve().bodyToMono(String.class).block();
			System.out.println(id);



/*
			String base_order_url = "https://exchange.matraining.com/" + API_KEY;
			WebClient webClient = WebClient
					.builder()
					.baseUrl(base_order_url)
					.defaultHeader("Content-Type", "application/json")
					.build();


			Order Order1 = new Order("AAPL", 1,1.5,"BUY");

			String id = WebClient
					.builder()
					.baseUrl(base_order_url)
					.defaultHeader("Content-Type", "application/json")
					.build()
					.post().uri(base_order_url +  "/order")
					.body(Mono.just(Order1), Order.class)
					.retrieve().bodyToMono(String.class)
					.block();
			System.out.println(id);

*/

		}

	}





