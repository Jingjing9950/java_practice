import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class GuessTheMovie{
	public String [] generateMovieList() throws Exception{
		File file = new File("movie.txt");
		Scanner scanner = new Scanner(file);
		
		ArrayList<String> movieList = new ArrayList<String>();
		while(scanner.hasNextLine()){
			String lines = scanner.nextLine();
			movieList.add(lines);

		}	
		String[] newMovieList = movieList.toArray(new String[movieList.size()]);
		return newMovieList;
	}

	public String generateRandomNumber() throws Exception{

		GuessTheMovie guessTheMovie = new GuessTheMovie();
		String[] movies = guessTheMovie.generateMovieList();
		int moviesLength = movies.length;
		int randomNumber = (int)(Math.random()*moviesLength + 1);
		String randomMovie = movies[randomNumber];
		return randomMovie;
		
	}

	public static void main(String [] args) throws Exception{
		GuessTheMovie guessMovie = new GuessTheMovie();
		String movieTarget = guessMovie.generateRandomNumber();
		int movieTargetLength =	movieTarget.length();
		
		ArrayList<String> charFill = new ArrayList<String>();
		for (int i =0; i< movieTargetLength; i++){
			charFill.add("_");
		}
		String[] charFilled = charFill.toArray(new String[charFill.size()]);
		String listString = String.join("",charFilled);

		System.out.println("You are guessing: "+ listString 
				 + "You have guessed (0) wrong letters" 
				 +"Guess a letter: ");
		
		Scanner guessLetter= new Scanner(System.in);
		String letterGuessed = guessLetter.nextLine();

		for (int j = 0; j < 10;){
			int charIndex = movieTarget.indexOf(letterGuessed);
			if(charIndex >= 0){
				while(charIndex >= 0){
					charFilled[charIndex] = letterGuessed;
					charIndex = movieTarget.indexOf(letterGuessed, charIndex+1);
				}
				listString = String.join("",charFilled);
				System.out.println("You are guessing: "+ listString 
						+ "You have guessed (" + j + ") wrong letters"
						 +"Guess a letter: ");
				if (listString.indexOf('_') < 0){
					System.out.println("You Win! You have guessed corretly!: " + listString);
					break;
				}
			}else if(charIndex < 0){
				j ++;
				System.out.println("You are guessing: "+ listString 
						+ "You have guessed (" + j + ") wrong letters" 
						 +"Guess a letter: ");
			}
			letterGuessed = guessLetter.nextLine();
		}

	}

}