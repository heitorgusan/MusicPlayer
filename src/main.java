import java.util.ArrayList;

public class main {
	private static ArrayList<Album>albuns = new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Artist a1 = new Artist("System of Down");
		Artist a2 = new Artist("AC/DC");
		Artist a3 = new Artist("Postmalone",26,"M");
		
		Album album1 = new Album("Toxicity",a1,new Song("Aerials",6.13),
				new Song("Chop Suey",3.3),new Song("Toxicity",3.39));
	}

}
