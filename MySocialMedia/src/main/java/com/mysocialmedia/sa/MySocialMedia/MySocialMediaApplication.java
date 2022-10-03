package com.mysocialmedia.sa.MySocialMedia;

import com.mysocialmedia.sa.MySocialMedia.entity.User;
import com.mysocialmedia.sa.MySocialMedia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class MySocialMediaApplication {
	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(MySocialMediaApplication.class, args);
	}


}
