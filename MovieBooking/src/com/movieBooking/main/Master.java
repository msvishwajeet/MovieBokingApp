package com.movieBooking.main;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import com.movieBooking.model.Address;
import com.movieBooking.model.Movie;
import com.movieBooking.model.Theatre;
import com.movieBooking.model.TimeSlot;
import com.movieBooking.model.TimeSlot.Time;
import com.movieBooking.service.AddressService;
import com.movieBooking.service.AddressServiceImpl;
import com.movieBooking.service.MovieService;
import com.movieBooking.service.MovieServiceImpl;
import com.movieBooking.service.TheatreService;
import com.movieBooking.service.TheatreServiceImpl;

public class Master {
	public final Scanner scanner = new Scanner (System.in);
	MovieService movieService;
	TheatreService theatreService;
	AddressService addressService;
	Master(){
		this.movieService=new MovieServiceImpl();
		this.theatreService=new TheatreServiceImpl();
		this.addressService = new AddressServiceImpl(theatreService);
		
	}
	public static void main(String[] args) {
		Master m=new Master();
			m.start();
	}
	private void start() {
		System.out.println("1.Release Movie");
		System.out.println("2.Create Theatre");
		System.out.println("3.Add a Movie to theatre");
		System.out.println("4.Search Movie");
		System.out.println("5.Show all Movie");
		System.out.println("6.Show all theatre");
		System.out.println("7.Show all Movie in Theatre");
		System.out.println("Enter -1 to Exit");
		System.out.print("Enter your option");
		int input=scanner.nextInt();
		while (input!=-1) {
		try {
			execute(input);
		} 
		
		catch (Exception e) {
			System.out.println("Error: "+ e.getMessage());
			return;
		}
		System.out.print("Enter Your Option:");
		input=scanner.nextInt();
		}
		System.err.println("App closed");
		return;
		
		
	}
	private void execute(int input) {
		if ((input>7)||(input<-1)) {
			System.err.println("Please select from given optins only");
			return;
		}
		switch (input) {
		case 1: releaseMovie();
		break;
		case 2: createTheatre();
		break;
		case 3: addMovie();
		break;
		case 4: searchMovie();
		break;
		case 5:	showAllMovie();
		break;
		case 6:	showAllTheatre();
		break;
		case 7:	movieinTheatre();
		break;
		default:
			System.out.println("Invalid input");
			break;
		}		
	}
	private void movieinTheatre() {
		System.out.println("Enter Theatre name:");
		scanner.nextLine();
		String thName=scanner.nextLine();
		Map<Movie, TimeSlot> m=this.theatreService.listOfMovie(thName);
		for (Movie movie : m.keySet()) {
			TimeSlot t= m.get(movie);
			Time st=t.getFrom();
			String s=st.getHour()+":" +st.getMinute();
			Time fr=t.getFrom();
			String e=fr.getHour()+":" +fr.getMinute();
			System.out.println(movie.getName()+"  Start time:"+s+"  End Time:-"+e);
		}
		start();
	}
	private void showAllTheatre() {
		Iterator<Theatre> itr= this.addressService.getTheatrelist();
		while (itr.hasNext()) {
			Theatre th=itr.next();
			String thName=th.getTheatreName();
			String ctName=th.getAddress().getCityName();
			System.out.println("-----------------------");
			System.out.println(thName+"------>City: "+ctName);
			System.out.println("-----------------------");
		}
		start();
	}
	private void addMovie() {
		scanner.nextLine();
		System.out.println("Enter a Theatre name:");
		String thName=scanner.nextLine();
		System.out.println("Enter a Released Movie name to add:");
		String movieName= scanner.nextLine();
		System.out.println("Enter a start time hour:");
		int sh=scanner.nextInt();
		System.out.println("Enter a start time minute:");
		int sm=scanner.nextInt();
		Time tf=new Time();
		tf.setHour(sh);
		tf.setMinute(sm);
		System.out.println("Enter End Time Hour");
		int eh=scanner.nextInt();
		System.out.println("Enter End Time Hour");
		int em=scanner.nextInt();
		Time tt=new Time();
		tt.setHour(eh);
		tt.setMinute(em);
		TimeSlot ts= new TimeSlot(tf,tt);
		Movie m= this.movieService.getMovieDetails(movieName);
		String s=this.theatreService.addMovie(m, thName, ts);
		System.out.println(s);
		System.err.println("Successfully Added");
		System.out.println();
		start();
	}
	private void createTheatre() {
		System.out.println("Enter a Theatre name:");
		scanner.nextLine();
		String thName=scanner.nextLine();
		System.out.println("Enter a city name:");
		String cityName=scanner.nextLine();
		System.out.println("Enter Location Details:");
		String location = scanner.nextLine();
		System.out.println("Please Enter a pinCode:");
		int pin=scanner.nextInt();
		Address add=new Address();
		add.setCityName(cityName);
		add.setLocation(location);
		add.setPin(pin);
		String success=this.theatreService.createThreatre(thName, add);
		System.out.println(success);
		start();
	}
	private void showAllMovie() {
		Iterator<Movie> it=this.movieService.allMovie();
		while (it.hasNext()) {
			Movie m=it.next();
			System.out.println("---------------");
			System.out.println(m.getName()+"----"+m.getLanguage()+"----"+m.getDoRelease());
			System.out.println("---------------");
		}
		start();
		
	}
	private void searchMovie() {
		System.out.println("Enter a Movie Name");
		String input=scanner.nextLine();
		Movie m=this.movieService.getMovieDetails(input);
		Date d=m.getDoRelease();
		System.out.println(input+" Date of release:"+d+" Language:-"+m.getLanguage());
		start();
	}
	private void releaseMovie() {
		System.out.print("Enter Name: ");
		scanner.nextLine();
		String name=scanner.nextLine();
		System.out.println("Select a language");
		System.out.println("1.Hindi");
		System.out.println("2.English");
		System.out.println("3.Bhojpuri");
		System.out.println("Enter a number from above option only");
		int input=scanner.nextInt();
		String lang="";
		switch (input) {
		case 1:
			lang="Hindi";
			break;
		case 2:
			lang="English";
			break;
		case 3:
			lang="Telgu";
			break;
		default:
			lang="ulta pulta";
			break;
		}
		String success=this.movieService.releaseMovie(name, lang);
		System.err.println(success);
		System.out.println();
		start();
	}
}
