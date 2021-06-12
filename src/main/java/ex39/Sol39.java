/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Douglas Glover
 */
package ex39;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
When you’re looking at results, you’ll want to be able to sort them so you can find what you’re looking for quickly or do some quick visual comparisons.

Given the following data set, create a program that sorts all employees by last name and prints them to the screen in a tabular format.

First Name	    Last Name	    Position	        Separation Date
John	        Johnson	        Manager	            2016-12-31              0
Tou	            Xiong	        Software Engineer	2016-10-05              1
Michaela	    Michaelson	    District Manager	2015-12-19              2
Jake	        Jacobson	    Programmer                                  3
Jacquelyn	    Jackson	        DBA                                         4
Sally	        Webber	        Web Developer	    2015-12-18              5


Example Output

Name                | Position          | Separation Date
--------------------|-------------------|----------------
Jacquelyn Jackson   | DBA               |
Jake Jacobson       | Programmer        |
John Johnson        | Manager           | 2016-12-31
Michaela Michaelson | District Manager  | 2015-12-19
Sally Weber         | Web Developer     | 2015-12-18
Tou Xiong           | Software Engineer | 2016-10-05

Constraint

Store the data using a list of maps.

Challenges

Prompt for how the records should be sorted. Allow sorting by separation date, position, or last name.
Use a database such as MySQL, or a key-value store such as Redis, to store the employee records. Retrieve the records from the data store.
 */
public class Sol39 {
    static final Sol39 app = new Sol39();
    public static void main(String[] args) {
        List<Map<Integer, String>> data = app.getData();
        app.outputData(data);
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
    void outputData(List<Map<Integer, String>> data) {
        int size = data.size();
        String name;
        String position;
        String date;
        System.out.print("""
        Name                | Position          | Separation Date
        --------------------|-------------------|----------------
        """);
        for(int i = 0; i < size; i++) {
            name = data.get(i).get(0) + " " + data.get(i).get(1);
            position = data.get(i).get(2);
            date = data.get(i).get(3);
            System.out.printf("%-20s| %-18s| %-15s\n", name, position, date);
        }
    }
}
