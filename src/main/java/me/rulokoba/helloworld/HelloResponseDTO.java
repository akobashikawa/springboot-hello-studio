package me.rulokoba.helloworld;

public class HelloResponseDTO {
	private String hello;

	public HelloResponseDTO(String hello) {
		this.hello = hello;
	}

	public String getHello() {
		return hello;
	}

	public void setHello(String hello) {
		this.hello = hello;
	}
	
}
