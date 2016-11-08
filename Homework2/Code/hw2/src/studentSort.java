//Alan Birmaher
//COP 4331C
//Homework 2
//10/13/14

//Import Libraries
import java.util.*;
import java.io.*;

//studentSort Class 
public class studentSort {
	
	//Earliest registration dates function
	public static ArrayList<String> datesEarliest(ArrayList<Student> list, String className){
		
		//Setup array for returning
		ArrayList<String> toPrint= new ArrayList<String>();
		ArrayList<Integer> dateInt= new ArrayList<Integer>();
		ArrayList<Student> minStudents= new ArrayList<Student>();
		
		//Variables
		int temp=0, limiter= 0;
		
		//Stores in first line
		String lineOne= "\nTop 3 Earliest to Enroll in "+className;
		
		//Store first line to print
		toPrint.add(lineOne);
		
		//Get int values for dates and store into array with corresponding index
		for(int i=0; i<list.size(); i++){
			
			//generate value for comparison
			temp= (list.get(i).year*100000)+(list.get(i).month*1000)+(list.get(i).day*10)+(i);
			
			//Add value to array
			dateInt.add(temp);
			
		}
		
		//Sort array by those numbers
		Collections.sort(dateInt);
		
		//Find limiting value
		if(list.size()>2)
			limiter=3;
		
		//If the prior case is not correct do this
		else
			limiter= list.size();
		
		//Store smallest 3 into minStudents2
		for(int j=0; j<limiter; j++){
			
			//Get value of location where value comes from
			temp=dateInt.get(j)%10;
			
			//Stores student into array for printing
			minStudents.add(list.get(temp));
			
		}
		
		//If there is no one in that class
		if(limiter==0){
			
			//Return message to print
			lineOne= ("\n"+ "No one is in that class");
			toPrint.add(lineOne);
			
		}
		
		//If there are people to print
		else{
			
			//Store Values to Array for returning and printing
			for(int k=0; k<limiter; k++){
				
				//Add blank line to return array
				lineOne= " ";
				toPrint.add(lineOne);
				
				//Stores name and last name to return array
				lineOne= minStudents.get(k).firstName + " " + 
						minStudents.get(k).lastName;
				toPrint.add(lineOne);
				
				//Stores date into array for return
				lineOne= Integer.toString(minStudents.get(k).month)+"/"+
						Integer.toString(minStudents.get(k).day)+"/"+
						Integer.toString(minStudents.get(k).year);
				toPrint.add(lineOne);
				
				//Stores time into array for return
				lineOne= Integer.toString(minStudents.get(k).time);
				toPrint.add(lineOne);
				
				//Stores vids into array for return
				lineOne= Integer.toString(minStudents.get(k).vids);
				toPrint.add(lineOne);
				
			}
		}
		
		//Return
		return(toPrint);
	
}

	//Latest registration dates function
	public static ArrayList<String> datesLatest(ArrayList<Student> list, String className){
		
		//Setup array for returning
		ArrayList<String> toPrint= new ArrayList<String>();
		ArrayList<Integer> dateInt= new ArrayList<Integer>();
		ArrayList<Student> maxStudents= new ArrayList<Student>();
		
		//Variables
		int temp=0, limiter= 0;
		
		//Stores in first line
		String lineOne= "\nTop 3 Latest to Enroll in "+className;
		
		//Store first line to print
		toPrint.add(lineOne);
		
		//Get int values for dates and store into array with corresponding index
		for(int i=0; i<list.size(); i++){
			
			//generate value for comparison
			temp= (list.get(i).year*100000)+(list.get(i).month*1000)+(list.get(i).day*10)+(i);
			
			//Add value to array
			dateInt.add(temp);
			
		}
		
		//Sort array by those numbers
		Collections.sort(dateInt);
		
		//Find limiting value
		if(list.size()>2)
			limiter=3;
		
		//If the prior case is not correct do this
		else
			limiter= list.size();
		
		//Store smallest 3 into minStudents2
		for(int j=1; j<=limiter; j++){
			
			//Stores student into array for printing
			maxStudents.add(list.get(dateInt.get(dateInt.size()-j)%10));
			
		}
		
		//If there is no one in that class
		if(limiter==0){
			
			//Return message to print
			lineOne= ("\n"+ "No one is in that class");
			toPrint.add(lineOne);
			
		}
		
		//If there are people to print
		else{
			
			//Store Values to Array for returning and printing
			for(int k=0; k<limiter; k++){
				
				//Add blank line to return array
				lineOne= " ";
				toPrint.add(lineOne);
				
				//Stores name and last name to return array
				lineOne= maxStudents.get(k).firstName + " " + 
						maxStudents.get(k).lastName;
				toPrint.add(lineOne);
				
				//Stores date into array for return
				lineOne= Integer.toString(maxStudents.get(k).month)+"/"+
						Integer.toString(maxStudents.get(k).day)+"/"+
						Integer.toString(maxStudents.get(k).year);
				toPrint.add(lineOne);
				
				//Stores time into array for return
				lineOne= Integer.toString(maxStudents.get(k).time);
				toPrint.add(lineOne);
				
				//Stores vids into array for return
				lineOne= Integer.toString(maxStudents.get(k).vids);
				toPrint.add(lineOne);
				
			}
		}
		
		//Return
		return(toPrint);
		
	}
	
	//Least time spent online function
	public static ArrayList<String> timeLeast(ArrayList<Student> list, String className){
		
		//Setup array for returning
		ArrayList<String> toPrint= new ArrayList<String>();
		ArrayList<Integer> timeInt= new ArrayList<Integer>();
		ArrayList<Student> minStudents= new ArrayList<Student>();
		
		//Variables
		int limiter= 0, index= 0;
		
		//Stores in first line
		String lineOne= "\nTop 3 Least Time Spent Online in "+className;
		
		//Store first line to print
		toPrint.add(lineOne);
		
		//Get int values for dates and store into array with corresponding index
		for(int i=0; i<list.size(); i++){
			
			//Add value to array
			timeInt.add(list.get(i).time);
			
		}
		
		//Sort array by those numbers
		Collections.sort(timeInt);
		
		//Find limiting value
		if(list.size()>2)
			limiter=3;
		
		//If the prior case is not correct do this
		else
			limiter= list.size();
		
		//Store smallest 3 into minStudents2
		for(int j=0; j<limiter; j++){
			
			//Search through all entries in timeInt until we find the index for this value in list
			for(int k=0; k<list.size(); k++){
				
				//If value of lowest is same as value in list then this is out number
				if(timeInt.get(j)==list.get(k).time){
					
					//Store index value found and break out of loop
					index= k;
					break;
					
				}
				
			}
			
			//Store found value into array for printing out
			minStudents.add(list.get(index));
			
			//Remove already used student from list to combat repetition
			list.remove(index);
			
		}
		
		//If there is no one in that class
		if(limiter==0){
			
			//Return message to print
			lineOne= ("\n"+ "No one is in that class");
			toPrint.add(lineOne);
			
		}
		
		//If there are people to print
		else{
			
			//Store Values to Array for returning and printing
			for(int k=0; k<limiter; k++){
				
				//Add blank line to return array
				lineOne= " ";
				toPrint.add(lineOne);
				
				//Stores name and last name to return array
				lineOne= minStudents.get(k).firstName + " " + 
						minStudents.get(k).lastName;
				toPrint.add(lineOne);
				
				//Stores date into array for return
				lineOne= Integer.toString(minStudents.get(k).month)+"/"+
						Integer.toString(minStudents.get(k).day)+"/"+
						Integer.toString(minStudents.get(k).year);
				toPrint.add(lineOne);
				
				//Stores time into array for return
				lineOne= Integer.toString(minStudents.get(k).time);
				toPrint.add(lineOne);
				
				//Stores vids into array for return
				lineOne= Integer.toString(minStudents.get(k).vids);
				toPrint.add(lineOne);
				
			}
		}
		
		//Return
		return(toPrint);
		
	}
	
	//Most time spent function
	public static ArrayList<String> timeMost(ArrayList<Student> list, String className){
		
		//Setup array for returning
		ArrayList<String> toPrint= new ArrayList<String>();
		ArrayList<Integer> timeInt= new ArrayList<Integer>();
		ArrayList<Student> maxStudents= new ArrayList<Student>();
		
		//Variables
		int limiter= 0, index= 0;
		
		//Stores in first line
		String lineOne= "\nTop 3 Most Time Spent Online in "+className;
		
		//Store first line to print
		toPrint.add(lineOne);
		
		//Get int values for dates and store into array with corresponding index
		for(int i=0; i<list.size(); i++){
			
			//Add value to array
			timeInt.add(list.get(i).time);
			
		}
		
		//Sort array by those numbers
		Collections.sort(timeInt);
		
		//Find limiting value
		if(list.size()>2)
			limiter=3;
		
		//If the prior case is not correct do this
		else
			limiter= list.size();
		
		//Store smallest 3 into minStudents2
		for(int j=1; j<=limiter; j++){
			
			//Search through all entries in timeInt until we find the index for this value in list
			for(int k=0; k<list.size(); k++){
				
				//If value of lowest is same as value in list then this is out number
				if(timeInt.get(timeInt.size()-j)==list.get(k).time){
					
					//Store index value found and break out of loop
					index= k;
					break;
					
				}
				
			}
			
			//Store found value into array for printing out
			maxStudents.add(list.get(index));
			
			//Remove already used student from list to combat repetition
			list.remove(index);
			
		}
		
		//If there is no one in that class
		if(limiter==0){
			
			//Return message to print
			lineOne= ("\n"+ "No one is in that class");
			toPrint.add(lineOne);
			
		}
		
		//If there are people to print
		else{
			
			//Store Values to Array for returning and printing
			for(int k=0; k<limiter; k++){
				
				//Add blank line to return array
				lineOne= " ";
				toPrint.add(lineOne);
				
				//Stores name and last name to return array
				lineOne= maxStudents.get(k).firstName + " " + 
						maxStudents.get(k).lastName;
				toPrint.add(lineOne);
				
				//Stores date into array for return
				lineOne= Integer.toString(maxStudents.get(k).month)+"/"+
						Integer.toString(maxStudents.get(k).day)+"/"+
						Integer.toString(maxStudents.get(k).year);
				toPrint.add(lineOne);
				
				//Stores time into array for return
				lineOne= Integer.toString(maxStudents.get(k).time);
				toPrint.add(lineOne);
				
				//Stores vids into array for return
				lineOne= Integer.toString(maxStudents.get(k).vids);
				toPrint.add(lineOne);
				
			}
		}
		
		//Return
		return(toPrint);
		
	}
	
	//Least videos watched function
	public static ArrayList<String> videoLeast(ArrayList<Student> list, String className){
		
		//Setup array for returning
		ArrayList<String> toPrint= new ArrayList<String>();
		ArrayList<Integer> timeInt= new ArrayList<Integer>();
		ArrayList<Student> minStudents= new ArrayList<Student>();
		
		//Variables
		int limiter= 0, index= 0;
		
		//Stores in first line
		String lineOne= "\nTop 3 Least Videos Watched in "+className;
		
		//Store first line to print
		toPrint.add(lineOne);
		
		//Get int values for dates and store into array with corresponding index
		for(int i=0; i<list.size(); i++){
			
			//Add value to array
			timeInt.add(list.get(i).vids);
			
		}
		
		//Sort array by those numbers
		Collections.sort(timeInt);
		
		//Find limiting value
		if(list.size()>2)
			limiter=3;
		
		//If the prior case is not correct do this
		else
			limiter= list.size();
		
		System.out.println(timeInt.get(0)+" "+timeInt.get(1)+" "+timeInt.get(2)+" "+timeInt.get(3));
		
		//Store smallest 3 into minStudents2
		for(int j=0; j<limiter; j++){
			
			//Search through all entries in timeInt until we find the index for this value in list
			for(int k=0; k<list.size(); k++){
				
				//If value of lowest is same as value in list then this is out number
				if(timeInt.get(j)==list.get(k).vids){
					
					//Store index value found and break out of loop
					index= k;
					break;
					
				}
				
			}
			
			//Store found value into array for printing out
			minStudents.add(list.get(index));
			
			//Remove already used student from list to combat repetition
			list.remove(index);
			
		}
		
		//If there is no one in that class
		if(limiter==0){
			
			//Return message to print
			lineOne= ("\n"+ "No one is in that class");
			toPrint.add(lineOne);
			
		}
		
		//If there are people to print
		else{
			
			//Store Values to Array for returning and printing
			for(int k=0; k<limiter; k++){
				
				//Add blank line to return array
				lineOne= " ";
				toPrint.add(lineOne);
				
				//Stores name and last name to return array
				lineOne= minStudents.get(k).firstName + " " + 
						minStudents.get(k).lastName;
				toPrint.add(lineOne);
				
				//Stores date into array for return
				lineOne= Integer.toString(minStudents.get(k).month)+"/"+
						Integer.toString(minStudents.get(k).day)+"/"+
						Integer.toString(minStudents.get(k).year);
				toPrint.add(lineOne);
				
				//Stores time into array for return
				lineOne= Integer.toString(minStudents.get(k).time);
				toPrint.add(lineOne);
				
				//Stores vids into array for return
				lineOne= Integer.toString(minStudents.get(k).vids);
				toPrint.add(lineOne);
				
			}
		}
		
		//Return
		return(toPrint);
		
	}
	
	//Most videos watched function
	public static ArrayList<String> videoMost(ArrayList<Student> list, String className){
		
		//Setup array for returning
		ArrayList<String> toPrint= new ArrayList<String>();
		ArrayList<Integer> timeInt= new ArrayList<Integer>();
		ArrayList<Student> maxStudents= new ArrayList<Student>();
		
		//Variables
		int limiter= 0, index= 0;
		
		//Stores in first line
		String lineOne= "\nTop 3 Most Videos Watched in "+className;
		
		//Store first line to print
		toPrint.add(lineOne);
		
		//Get int values for dates and store into array with corresponding index
		for(int i=0; i<list.size(); i++){
			
			//Add value to array
			timeInt.add(list.get(i).vids);
			
		}
		
		//Sort array by those numbers
		Collections.sort(timeInt);
		
		//Find limiting value
		if(list.size()>2)
			limiter=3;
		
		//If the prior case is not correct do this
		else
			limiter= list.size();
		
		//Store smallest 3 into minStudents2
		for(int j=1; j<=limiter; j++){
			
			//Search through all entries in timeInt until we find the index for this value in list
			for(int k=0; k<list.size(); k++){
				
				//If value of lowest is same as value in list then this is out number
				if(timeInt.get(timeInt.size()-j)==list.get(k).vids){
					
					//Store index value found and break out of loop
					index= k;
					break;
					
				}
				
			}
			
			//Store found value into array for printing out
			maxStudents.add(list.get(index));
			
			//Remove already used student from list to combat repetition
			list.remove(index);
			
		}
		
		//If there is no one in that class
		if(limiter==0){
			
			//Return message to print
			lineOne= ("\n"+ "No one is in that class");
			toPrint.add(lineOne);
			
		}
		
		//If there are people to print
		else{
			
			//Store Values to Array for returning and printing
			for(int k=0; k<limiter; k++){
				
				//Add blank line to return array
				lineOne= " ";
				toPrint.add(lineOne);
				
				//Stores name and last name to return array
				lineOne= maxStudents.get(k).firstName + " " + 
						maxStudents.get(k).lastName;
				toPrint.add(lineOne);
				
				//Stores date into array for return
				lineOne= Integer.toString(maxStudents.get(k).month)+"/"+
						Integer.toString(maxStudents.get(k).day)+"/"+
						Integer.toString(maxStudents.get(k).year);
				toPrint.add(lineOne);
				
				//Stores time into array for return
				lineOne= Integer.toString(maxStudents.get(k).time);
				toPrint.add(lineOne);
				
				//Stores vids into array for return
				lineOne= Integer.toString(maxStudents.get(k).vids);
				toPrint.add(lineOne);
				
			}
		}
		
		//Return
		return(toPrint);
		
	}

	//Main Function
	public static void main(String[] args) throws IOException{
	
		//Variables
		int numEntries = 0, courseTime = 0, vidsWatched = 0;
		int tracker = 0, courseSelected= 0, sortSelect=0, howOut=0;
		String courseName= null, name= null, date= null, str=null;
	    ArrayList<String> lines = new ArrayList<String>();
	    ArrayList<String> classes = new ArrayList<String>();
	    ArrayList<String> toPrint = new ArrayList<String>();
	    ArrayList<Student> perClass = new ArrayList<Student>();
	    ArrayList<Student> temporary = new ArrayList<Student>();
	    
	    //Setup scanner
	    Scanner userIn = new Scanner(System.in);
		
		//Print welcome
		System.out.println("Welcome to The Student Sorter!");
		
		//Checks the file for being there before moving on, otherwise kills program
		try {
			new FileReader("input.txt");
		} catch (FileNotFoundException fnfe) {
			System.out.println("File not found, check and run program again.");
			System.exit(0);
		}
		
		//Setup bufferedReader
		BufferedReader inFile = new BufferedReader(new FileReader("input.txt"));
		
	    //Runs through the whole file reading in
	    while((str = inFile.readLine()) != null){
	        
	    	//Adds the string to the line
	    	lines.add(str);
	    
	    }
	    
	    //Close file
	    inFile.close();
	    
	    //Moves the list into an array
	    String[] linesArray = lines.toArray(new String[lines.size()]);
	    
		//Read in number of entries
		numEntries= Integer.parseInt(linesArray[tracker]);
		
		//Move the tracker along
		tracker++;

		//Read through the different entries
		for(int i=0; i<numEntries; i++){
			
			//Move Tracker along
			tracker++;
			
			//Read in name of course
			courseName= linesArray[tracker];
			
			//Stores name of course into courses array
			classes.add(courseName);
			
			//Move the tracker along
			tracker++;
			
			//Find the end of the class students
			while(((tracker<(linesArray.length)) && !linesArray[tracker+2].isEmpty())){
				
				//Move tracker along
				tracker++;
				
				//Read in name
				name= linesArray[tracker];
				
				//Move the tracker along
				tracker++;
						
				//Read in date
				date= linesArray[tracker];	
				
				//Move the tracker along
				tracker++;
				
				//Read in time spent in course
				courseTime= Integer.parseInt(linesArray[tracker]);
				
				//Move the tracker along
				tracker++;
				
				//Read in number of vids watched
				vidsWatched= Integer.parseInt(linesArray[tracker]);	
				
				//Move tracker along
				tracker++;
				
				//Create student object for this person
				Student temp = new Student(name, date, courseTime, vidsWatched);
				
				//Add student to student array for the corresponding class
				perClass.add(temp); 
				
			}
			
		}
		
		//Select course
		System.out.println("\nPlease select the course you would like sorted:");
			
		//Print course choices
		for(int j=0; j<classes.size(); j++){
			
			//Prints the course choices
			System.out.printf("%d) %s\n", j+1, classes.get(j));
			
		}
		
		//Read in selection, Check for correct selection
		do{
			
			//Prints the selection indicator
			System.out.printf("Selection: ");
			
			//Store value
			courseSelected= (userIn.nextInt());
			
			//Break out if input correct
			if(courseSelected>=1 && courseSelected<=classes.size())
				break;
			
			//Prints incorrect selection if needed
			System.out.println("\nIncorrect selection, try again!");
			
		//Do this while the correct selection is not selected	
		}while(courseSelected<1 || courseSelected>classes.size());
		
		//Makes the option coincide with its index
		courseSelected--;
		
		//Reset tracker
		tracker=0;
		
		//Find where this class is
		while(linesArray[tracker]!=classes.get(courseSelected)){
			tracker++;
		}
		
		//Increment tracker
		tracker++;

		//Find the end of the class students
		while(((tracker<(linesArray.length)) && !linesArray[tracker+2].isEmpty())){
			
			//Move tracker along
			tracker++;
			
			//Read in name
			name= linesArray[tracker];
			
			//Move the tracker along
			tracker++;
					
			//Read in date
			date= linesArray[tracker];	
			
			//Move the tracker along
			tracker++;
			
			//Read in time spent in course
			courseTime= Integer.parseInt(linesArray[tracker]);
			
			//Move the tracker along
			tracker++;
			
			//Read in number of vids watched
			vidsWatched= Integer.parseInt(linesArray[tracker]);	
			
			//Move tracker along
			tracker++;
			
			//Create student object for this person
			Student temp = new Student(name, date, courseTime, vidsWatched);
			
			//Add student to student array for the corresponding class
			temporary.add(temp); 
			
		}
			
		//Comparisons selection
		System.out.println("\nPlease select the sort method you would like:");
		System.out.println("1) Registration Date (Earliest)");
		System.out.println("2) Registration Date (Latest)");
		System.out.println("3) Time Spent (Least)");
		System.out.println("4) Time Spent (Most)");
		System.out.println("5) Videos Watched (Least)");
		System.out.println("6) Videos Watched (Most)");
		
		//Read in selection, Check for correct selection
		do{
			
			//Prints the selection indicator
			System.out.printf("Selection: ");
			
			//Store value
			sortSelect= userIn.nextInt();
			
			//Break out if input correct
			if(sortSelect>=1 && sortSelect<=6)
				break;
			
			//Prints incorrect selection if needed
			System.out.println("\nIncorrect selection, try again!");
			
		//Do this while the correct selection is not selected
		}while(sortSelect<1 || sortSelect>6);
		
		//Asks the user for output format
		System.out.println("\nPlease select the output format:");
		System.out.println("1) Print to Console");
		System.out.println("2) Print to file called out.txt");
		
		//Read in selection, Check for correct selection
		do{
			
			//Prints the selection indicator
			System.out.printf("Selection: ");
			
			//Store value
			howOut= userIn.nextInt();
			
			//Break out if input correct
			if(howOut==1 || howOut==2)
				break;
			
			//Prints incorrect selection if needed
			System.out.println("\nIncorrect selection, try again!");
			
		//Do this while the correct selection is not selected
		}while(howOut!=1 || howOut!=2);
		
		//Make comparison and store into array for later printing
		//Sort for Registration Date (Earliest)
		if(sortSelect==1)
			toPrint= datesEarliest(temporary, classes.get(courseSelected));
			
		//Sort for Registration Date (Latest)
		else if(sortSelect==2)
			toPrint= datesLatest(temporary, classes.get(courseSelected));
		
		//Sort for Time Spent (Least)
		else if(sortSelect==3)
			toPrint= timeLeast(temporary, classes.get(courseSelected));
		
		//Sort for Time Spent (Most)
		else if(sortSelect==4)
			toPrint= timeMost(temporary, classes.get(courseSelected));
		
		//Sort for Videos Watched (Least)
		else if(sortSelect==5)
			toPrint= videoLeast(temporary, classes.get(courseSelected));
		
		//Sort for Videos Watched (Most)
		else if(sortSelect==6)
			toPrint= videoMost(temporary, classes.get(courseSelected));
		
		//Print into correct format
		//Print to console
		if(howOut==1){
			
			//Print all lines to console
			for(int i=0;i<toPrint.size();i++){
				
				//Print to console line by line
				System.out.printf("%s\n", toPrint.get(i));
				
			}
			
		}
		
		//Print to file out.txt
		else if(howOut==2){
			
			//Open file
			File outFile = new File("out.txt");
			
			//Setup to print
			FileWriter fw = new FileWriter(outFile.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			
			//Print all lines to file
			for(int i=0;i<toPrint.size();i++){
				
				//Print to file line by line
				bw.write(toPrint.get(i) + "\n");
				
			}
			
			//Close file
			bw.close();
			
		}
		
		//Prints to show end of statement
		System.out.println("\nSort sucessful!");
		
	}//End Main

}