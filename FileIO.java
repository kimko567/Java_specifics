import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;



class Book implements Serializable{
	
public	String author;
public	String name;
public	boolean ava; //availability
public	int reader;
public	String returnDate;

	public Book() {
		author = null;
		name = null;
		ava = true;
		reader = 0;
		returnDate = null;
	}
	public Book(String Author, String Name,boolean Ava,int Reader,String ReturnDate ) {
		
		author = Author;
		name = Name;
		ava = Ava;
		reader = Reader;
		returnDate = ReturnDate;
	}
	public void display() {
		
		if(reader !=0)System.out.printf("%-20s|   %-20s|   %-20s|   %-20d|   %-20s\n",author,name,ava? "+":"-",reader,returnDate==null?"None":returnDate);
		else System.out.printf("%-20s|   %-20s|   %-20s|   %-20s|   %-20s\n",author,name,ava? "+":"-","None",returnDate==null?"None":returnDate);
	}
}
public class FileIO {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		
		
		/*Book b1 = new Book("Alberts Miezis","Mazā māja",true,0,null);
		Book b2 = new Book("Eto Yoshimura","Vienacainā pūce",false,191,"19/12/2021");
		Book b3 = new Book("Alberts Miezis","Pelikāns",false,9921,"1/2/3039");
		Book b4 = new Book("Xin Ape Yun","Joda svētki",true,0,null);
		Book b5 = new Book("Vilnis Kāpele","Jumts",true,0,null);
		Book b6 = new Book("Eto Yoshimura","Dieva ābols",false,13000,"7/19/2090");
		Book b7 = new Book("Anna Iecirkne","Dots pret dotu",true,0,null);
		Book b8 = new Book("Sergejs Volne","Iekāpurs",true,0,null);
		Book b9 = new Book("Juris Pilnvaris","Zemekls004",false,15,"9/9/163");
		Book b10 = new Book("Alberts Miezis","Lielā māja",true,0,null);
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("text.dat"));
			
				out.writeObject(b1);
				out.writeObject(b2);
				out.writeObject(b3);
				out.writeObject(b4);
				out.writeObject(b5);
				out.writeObject(b6);
				out.writeObject(b7);
				out.writeObject(b8);
				out.writeObject(b9);
				out.writeObject(b10);
		out.close();		
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}*/
		char ch ='0'; 
		do {
			System.out.println("\n1. Apskatīt saturu");
		    System.out.println("2. Ierakstīt jaunu grāmatu");
		    System.out.println("3. Izdzēst grāmatu");
		    System.out.println("4. Koriģēt grāmatu");
		    System.out.println("5. Sakārtot grāmatas");
		    System.out.println("6. Atrast grāmatas(pēc autora vārda)");
		    System.out.println("7. Grāmatu pieejamība");
		    System.out.println("E  Pabeigt programmu");
			ch =sc.next().charAt(0);
			sc.nextLine();
			switch(ch) {
			
			case '1': display(false,null);
			          break;
			          
			case '2': System.out.println("Autors(maks.izmērs 20): ");
			          String a = sc.nextLine();
			          if(a.length() >20) System.out.println("Nepareiza ievade(maks. izmērs 20)");
			          else { System.out.println("Nosaukums(maks.izmērs 20): ");
			                 String n = sc.nextLine();
			                 if(n.length()>20) System.out.println("Nepareiza ievade(maks. izmērs 20)");
			                 else {
			        	          Book temp = new Book(a,n,true,0,null);
			                      add(temp);
			                 }
			          }
			          break;
			          
			case '3':System.out.println("Autors: ");
	                 String a1 = sc.nextLine();
				     System.out.println("Nosaukums: ");
			         String a2 = sc.nextLine();
	                 delete(a2,a1,true);break;
			case '4':alter();
				     break;
			case '5':sort();
				     break;
			case '6':System.out.println("Autors: "); 
				     String a3= sc.nextLine();
				     find(a3);
				     break;
			case '7':parity();
				     break;
			case 'E':System.out.println("Programma izbeigta!");break;
			default: System.out.println("Nepareiza ievade!"); break;
			}
			
		}
		while(ch!='E');
	}
	public static void add(Book temp) {
		try {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("temp.dat"));
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("text.dat"));
		boolean EOF = false;
		while(!EOF)
		{
			try {
			out.writeObject((Book)in.readObject());
			}
			catch(Exception e) {EOF = true;}
		}
		out.writeObject(temp);
		out.close();
		in.close();
		out =  new ObjectOutputStream(new FileOutputStream("text.dat"));
		in = new ObjectInputStream(new FileInputStream("temp.dat"));
		
		while(EOF)
		{
			try {
			out.writeObject((Book)in.readObject());
			}
			catch(Exception e) {EOF = false;}
		}
		in.close();
		out.close();
		File nim = new File("temp.dat");
		nim.delete();
		}
		catch(Exception e) {System.out.println("temp fail");}
		System.out.println("Pievienota grāmata: "+temp.name+"");
		
	}

	public static void delete(String temp,String temp2, boolean o) {
		try {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("temp.dat"));
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("text.dat"));
		boolean EOF = false;
		Book tmp = new Book();
		while(!EOF)
		{
			try {
			tmp = (Book)in.readObject();
			if(!temp.equals(tmp.name)||!temp2.equals(tmp.author))
			out.writeObject(tmp);
			else if (o) {System.out.println("Izdzēsta grāmata: " +temp+"" );o=false;}
			}
			catch(Exception e) {EOF = true;}
		}
		out.writeObject(temp);
		out.close();
		in.close();
		out =  new ObjectOutputStream(new FileOutputStream("text.dat"));
		in = new ObjectInputStream(new FileInputStream("temp.dat"));
		
		while(EOF)
		{
			try {
			out.writeObject((Book)in.readObject());
			}
			catch(Exception e) {EOF = false;}
		}
		in.close();
		out.close();
		File nim = new File("temp.dat");
		nim.delete();
		if(o)System.out.println("Nav tādas grāmatas!");
		}
		catch(Exception e) {System.out.println("temp fail");}
		
		
	}
	public static void find(String temp) {
		display(true,temp);
		
	}
	public static String kep(String a1,String a2) {
		
		if (a1.length() <= a2.length() ) {
			
			for(int i = 0; i < a1.length();i++)
			{
				if(a1.charAt(i)>a2.charAt(i)) return a2;
				else if (a1.charAt(i)!=a2.charAt(i)) return a1;
			}
			return a1;
		}
		else {
			for(int i = 0; i < a2.length();i++)
			{
				if(a1.charAt(i)>a2.charAt(i)) return a2;
				else if (a1.charAt(i)!=a2.charAt(i)) return a1;
			}
			return a2;
		}
	}
	public static void sort() {
		try {
		ObjectOutputStream out1 = new ObjectOutputStream(new FileOutputStream("temp1.dat"));
		ObjectInputStream in1 = new ObjectInputStream(new FileInputStream("text.dat"));
		boolean EOF = false;
		Book tmp = new Book();
		int Bookcnt = 0;
		String newt=null;
		String bewt=null;
		while(!EOF)
		{
			try {
			tmp = (Book)in1.readObject();
			Bookcnt++;
			}
			catch(Exception e) {EOF = true;}
		}
		EOF = false;
		in1.close();
		
		for(;Bookcnt>0;Bookcnt--) {
		in1 = new ObjectInputStream(new FileInputStream("text.dat"));
		while(!EOF)
		{
			try {
			tmp = (Book)in1.readObject();
			if(newt == null) {newt =tmp.author;bewt=tmp.name;}
			else if (newt.equals(tmp.author)) bewt = kep(bewt,tmp.name);
			else if (!newt.equals( kep(newt,tmp.author))){newt = tmp.author;bewt =tmp.name;};
			}
			catch(Exception e) {EOF = true;}
		}
		in1.close();
		in1 = new ObjectInputStream(new FileInputStream("text.dat"));
		while(EOF)
		{
			try {
			tmp =(Book)in1.readObject();
			if(newt.equals(tmp.author)&& bewt.equals(tmp.name)) {out1.writeObject(tmp);}
			}
			catch(Exception e) {EOF = false;}
		}
		in1.close();
		delete(bewt,newt,false);
		newt =null; bewt = null;
		}
		
		in1.close();
		out1.close();
		out1 =  new ObjectOutputStream(new FileOutputStream("text.dat"));
		in1 = new ObjectInputStream(new FileInputStream("temp1.dat"));
		while(!EOF)
		{
			try {
			out1.writeObject((Book)in1.readObject());
			}
			catch(Exception e) {EOF = true;}
		}
		in1.close();
		out1.close();
		File nim = new File("temp1.dat");
		nim.delete();
		System.out.println("Sakārtots!" );
		}
		catch(Exception e) {System.out.println("Neizdevās salārtot!");}
		
		
	}
	
	public static void parity() {
		try {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("text.dat"));
		boolean EOF = false;
		int countp=0;
		int countn=0;
		Book tmp = new Book();
		while(!EOF)
		{
			try {
			tmp = (Book)in.readObject();
			if(tmp.ava)countp++;
			else countn++;
			}
			catch(Exception e) {EOF = true;}
		}
		
		in.close();
		System.out.println("Pieejamas: "+countp);
		System.out.println("Izdotas: "+countn);
		}
		catch(Exception e) {System.out.println("Neizdevās!");}
		
	}
	
	public static void alter() {
		try {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("temp.dat"));
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("text.dat"));
		boolean EOF = false;
		boolean checkBook=false;
		Book tmp = new Book();
		Scanner scan = new Scanner(System.in);
		System.out.println("Ievadiet grāmatas autoru: ");
		String auto = scan.nextLine();
		System.out.println("Ievadiet grāmatas nosaukumu: ");
		String name = scan.nextLine();
		while(!EOF)
		{
			try {
			tmp = (Book)in.readObject();
			if(name.equals(tmp.name) && auto.equals(tmp.author)) {
				checkBook =true;
				char g; // switch izveles mainigais
				String abu; //glaba scanner ievades
				do {
				System.out.println("\nGrāmata: "+ tmp.name);
				System.out.println("1.Mainīt autoru ("+tmp.author+")" );
				System.out.println("2.Mainīt nosaukumu ("+tmp.name+")" );
				System.out.println("3.Mainīt lietotāju/pieejamību ("+tmp.reader+" "+tmp.returnDate+")" );
				System.out.println("E Atgriezties" );
				g= scan.next().charAt(0);
				System.out.println(g);
				scan.nextLine();
				switch(g) {
				
				case '1':System.out.println("Ievadiet jauno/laboto autoru(maksimālais izmērs 20): "); 
				         abu=scan.nextLine();
				         if(abu.length()>20) System.out.println("Nepareiza ievade!(maksimālais izmērs 20)");
				         else tmp.author=abu;
				         break;
				         
				case '2':System.out.println("Ievadiet jauno/laboto nosaukumu(maksimālais izmērs 20): "); 
		                 abu=scan.nextLine();
		                 if(abu.length()>20) System.out.println("Nepareiza ievade!(maksimālais izmērs 20)");
		                 else tmp.name=abu;
		                 break; 
				case '3':System.out.println("Ievadiet jauno/laboto lietotāju(no 1 līdz 100000, ja nav lietotājs, tad jāraksta 0): "); 
                         if(scan.hasNextInt()) {
                        	 int user = scan.nextInt();
                        	 if(user == 0) {tmp.reader=0;tmp.ava=true;tmp.returnDate=null;}
                        	 else if (user > 100000||user < 0)System.out.println("Nepareiza ievade!(no 1 līdz 2147483647, ja nav lietotājs, tad jāraksta 0)");
                        	 else {
                        		 System.out.println("Ievadiet jauno/laboto atgriešnas datumu:\nDiena(no 1 līdz 31):") ;
                        		 if(scan.hasNextInt()) {
                        			 int day = scan.nextInt();
                        			 if(day <=0 || day >31) {System.out.println("Nepareiza ievade!(no 1 līdz 31)");}
                        			 else {
                        				      System.out.println("Mēnesis(no 1 līdz 12; 4, 6,9,11 menēsī tikai 30 dienas; 2 mēnesī tikai 29 dienas):");                        			 
                        			          if(scan.hasNextInt()) {
                            			           int month = scan.nextInt();
                            			           if(month <=0 || month >12 || (day > 29 && month==2)||(day==31 && month ==4)||(day==31 && month ==6)||(day==31 && month ==9)||(day==31 && month ==11)) 
                            			                 {System.out.println("Nepareiza ievade!(no 1 līdz 12; 4, 6,9,11 menēsī tikai 30 dienas; 2 mēnesī tikai 29 dienas)");}
                            			           else { System.out.println("Gads:");
                            			                 if(scan.hasNextInt()) {
                                			                 int year = scan.nextInt();abu = day+"/"+month+"/"+year;tmp.reader=user;tmp.returnDate=abu;tmp.ava=false;}
                            			                 else {scan.nextLine();scan.nextLine();System.out.println("Nepareiza ievade!");}
                            			           }
                        			          }  else {scan.nextLine();scan.nextLine();System.out.println("Nepareiza ievade!(no 1 līdz 31)");}
                            		 }
                        		 }
                        		 else {scan.nextLine();scan.nextLine();System.out.println("Nepareiza ievade!(no 1 līdz 31)");}
                        	 }
                         }
                         else {scan.nextLine();System.out.println("Nepareiza ievade!(no 1 līdz 100000, ja nav lietotājs, tad jāraksta 0)");}
                         break; 
				case 'E':System.out.println("Saglabātas izmaiņas: "+tmp.name); 
					     break; 
				default: System.out.println("Nepareiza ievade!");
				}
				}
				while(g !='E');
			}	
			out.writeObject(tmp);	
			
			}
			catch(Exception e) {EOF = true; if(checkBook==false)System.out.println("Nav tādas grāmatas!");}
		}
	
		out.close();
		in.close();
		if(checkBook = true) {
			out =  new ObjectOutputStream(new FileOutputStream("text.dat"));
		in = new ObjectInputStream(new FileInputStream("temp.dat"));
		
		while(EOF)
		{
			try {
			out.writeObject((Book)in.readObject());
			}
			catch(Exception e) {EOF = false;}
		}
		in.close();
		out.close();
		}
		File nim = new File("temp.dat");
		nim.delete();
		}
		catch(Exception e) {System.out.println("Kļūda!");}
		
		
	}
	public static void display(boolean o, String name)
	{
		try {
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("text.dat"));
		boolean EOF = false;
		System.out.printf("%-20s|   %-20s|   %-20s|   %-20s|   %-20s\n", "Autors", "Nosaukums", "Pieejamība","Lietotājs","Atgriešanas datums");
		System.out.printf("--------------------------------------------------------------------------------------------------------------------\n");
		if(!o) {
			while(!EOF) {
			try {
				System.out.printf("--------------------------------------------------------------------------------------------------------------------\n");
			Book temp = (Book)in.readObject();
		    temp.display();
		}
		catch(Exception e) {e.getMessage();EOF = true;}
		} 
		}
	    else {
	    	while(!EOF) {
				try {
				Book temp = (Book)in.readObject();
			   if(temp.author.equals(name)) {System.out.printf("--------------------------------------------------------------------------------------------------------------------\n");
			   temp.display();}
			   }
	    	
		catch(Exception e) {e.getMessage();EOF = true;}
		}
			System.out.printf("--------------------------------------------------------------------------------------------------------------------\n");
			
	    }
		in.close();
		
		
		}
		catch(Exception e) {e.getMessage();}
		
	}

}
