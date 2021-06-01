package io.celeiro.algalog.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Problem {

	private Integer status;
	private LocalDateTime dateTime;
	private String title;
	private List<Property> property;
	
	@Getter
	@AllArgsConstructor
	public static class Property {
		
		private String name;
		private String message;
	}
}
