/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Douglas Glover
 */
package ex40;
import java.util.*;
/*
Sorting records is helpful, but sometimes you need to filter down the results to find or display only what you’re looking for.

Given the following data set create a program that lets a user locate all records that match the search string by comparing the search string to the first or last name field.

First Name	        Last Name	        Position	        Separation Date
John	            Johnson	            Manager	            2016-12-31
Tou	                Xiong	            Software Engineer	2016-10-05
Michaela	        Michaelson	        District Manager	2015-12-19
Jake	            Jacobson	        Programmer
Jacquelyn	        Jackson	            DBA
Sally	            Webber	            Web Developer	    2015-12-18

Example Output

Enter a search string: Jac

Results:

Name                | Position          | Separation Date
--------------------|-------------------|----------------
Jacquelyn Jackson   | DBA               |
Jake Jacobson       | Programmer        |

Constraint

Store the data using a list of maps.

Challenges

Make the search case insensitive.
Add the option to search by position.
Add the option to find all employees where their separation date is six months ago or more.
Read in the data from a file.
 */
public class Sol40 {
    static final Sol40 app = new Sol40();
    static final Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        List<Map<Integer, String>> data = app.getData();
        String input = app.getInput();
        List<Map<Integer, String>> searchData = app.getSearchData(data, input);
        app.outputData(searchData);
    }
    String getInput()
    {
        System.out.print("Enter a search string: ");
        return in.nextLine();
    }
    List<Map<Integer, String>> getData() {
        List<Map<Integer, String>> data = new ArrayList<>();
        data.add(getPersonMap("Jacquelyn", "Jackson", "DBA", ""));
        data.add(getPersonMap("Jake", "Jacobson", "Programmer", ""));
        data.add(getPersonMap("John", "Johnson", "Manager", "2016-12-31"));
        data.add(getPersonMap("Michaela", "Michaelson", "District Manager", "2015-12-19"));
        data.add(getPersonMap("Sally", "Webber", "Web Developer", "2015-12-18"));
        data.add(getPersonMap("Tou", "Xiong", "Software Engineer", "2016-10-05"));
        return data;
    }
    Map<Integer, String> getPersonMap(String fName, String lName, String position, String date)
    {
        Map<Integer, String> personData = new HashMap<>();
        personData.put(0, fName);
        personData.put(1, lName);
        personData.put(2, position);
        personData.put(3, date);
        return personData;
    }
    List<Map<Integer, String>> getSearchData( List<Map<Integer, String>> data, String input)
    {
        List<Map<Integer, String>> searchData = new ArrayList<>();
        for (Map<Integer, String> datum : data)
            if (datum.get(0).contains(input) || datum.get(1).contains(input))
                searchData.add(datum);
        return searchData;
    }
    void outputData(List<Map<Integer, String>> data) {
        String name;
        String position;
        String date;
        System.out.print("""
        Name                | Position          | Separation Date
        --------------------|-------------------|----------------
        """);
        for (Map<Integer, String> datum : data) {
            name = datum.get(0) + " " + datum.get(1);
            position = datum.get(2);
            date = datum.get(3);
            System.out.printf("%-20s| %-18s| %-15s\n", name, position, date);
        }
    }
}
