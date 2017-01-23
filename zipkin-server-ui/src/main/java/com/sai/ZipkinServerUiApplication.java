package com.sai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class ZipkinServerUiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinServerUiApplication.class, args);
	}
}
