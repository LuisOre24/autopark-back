package com.cibertec.autoparkback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.*;

@SpringBootApplication
public class AutoparkBackApplication {

	public static void main(String[] args) {

		SpringApplication.run(AutoparkBackApplication.class, args);


//		LocalDate date1 = LocalDate.now();
//		LocalTime hours1 = LocalTime.now();
//
//		LocalDate date2 = LocalDate.now();
//		LocalTime hours2 = LocalTime.of(04,30,20);

		String dateString = "2024-04-20T17:07:28.766155800";
		LocalDateTime start = LocalDateTime.parse(dateString);
		LocalDateTime end = LocalDateTime.now();

		int time = getTime(start,end,0);

		System.out.println("Numero de horas: " + time);

	}


	public static int getTime(LocalDateTime startDate, LocalDateTime endDate, int tolerancia){

		int time = 0;
		Period dias = Period.between(startDate.toLocalDate(),endDate.toLocalDate());
		int horas = endDate.getHour() - startDate.getHour();
		int minutos = endDate.getMinute() - startDate.getMinute();

		if(dias.isZero()){
			return horas;
		}
		else{
			if(minutos > tolerancia){
				time = (dias.getDays()*24) + horas + 1;
			}
			else{
				time = (dias.getDays()*24) + horas;
			}
		}
		return time;
	}
}
