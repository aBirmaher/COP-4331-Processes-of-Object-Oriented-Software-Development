//Alan Birmaher
//COP 4331C
//Homework 2
//10/13/14

//Student class
public class Student {
	
	//Variables
    public String firstName= null;
    public String lastName= null;
    public int month=0;
    public int day=0;
    public int year=0;
    public int time=0;
    public int vids=0;
    
    //Student Constructor
    public Student(String name, String date, int timeSpent, int vidsWatched) {
        
    	//Additional values
    	int counter=0;
    	
    	//Set values
        time= timeSpent;
        vids= vidsWatched;
        
        //Setup string split
        String[] nameSplit = name.split("\\s");
        
        //Store first name
        firstName= nameSplit[0]; 
        
        //Store last name
        lastName= nameSplit[1];
        
        //Set up and store the date
        //If the value has a value in the 10's place, multiply by 10 and add to total.
        if(date.charAt(counter+1)!='/'){
        	
        	//If value of month is over 10 add the amount to month
        	month+=(Character.getNumericValue(date.charAt(counter)))*10;
        
        	//Increment Counter
	        counter++;
	        
        }
        
        //Adds the value in the ones place of the month
        month+=(Character.getNumericValue(date.charAt(counter)));
        
        //Increment counter
        counter++;
        counter++;
        
        //If the value has a value in the 10's place, multiply by 10 and add to total.
        if(date.charAt(counter+1)!='/'){
        	
        	//If value of day is over 10 add the amount to day
        	day+=(Character.getNumericValue(date.charAt(counter)))*10;
        
	      //Increment Counter
	        counter++;
	        
        }
        
        //Adds the value in the ones place of the day
        day+=(Character.getNumericValue(date.charAt(counter)));
        
        //Increment counter
        counter+=2;
        
        //Add thousands place to year
        year+=(Character.getNumericValue(date.charAt(counter))*1000);
        
        //Increment counter
        counter++;
        
        //Add thousands place to year
        year+=(Character.getNumericValue(date.charAt(counter))*100);
        
        //Increment counter
        counter++;
        
        //Add thousands place to year
        year+=(Character.getNumericValue(date.charAt(counter))*10);
        
        //Increment counter
        counter++;
        
        //Add thousands place to year
        year+=(Character.getNumericValue(date.charAt(counter)));
        
    }
}
