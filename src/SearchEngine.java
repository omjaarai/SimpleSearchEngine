////////////////////ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
//Title:           p10 Simple Search Engine
//Files:           none
//Course:          CS 300 spring 2018
//
//Author:          Omjaa Rai
//Email:           orai@wisc.edu
//Lecturer's Name: Mouna Ayari Ben Hadj Kacem
//
////////////////////PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
//Partner Name:
//Partner Email:
//Lecturer's Name:
//
//VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//__ Write-up states that pair programming is allowed for this assignment.
//__ We have both read and understand the course Pair Programming Policy.
//__ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
//Students who get help from sources other than their partner must fully
//acknowledge and credit those sources of help here.  Instructors and TAs do
//not need to be credited here, but tutors, friends, relatives, room mates
//strangers, etc do.  If you received no outside help from either type of
//source, then please explicitly indicate NONE.
//
//Persons:         none
//Online Sources:  none
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
import java.util.ArrayList;
import java.util.Scanner;

public class SearchEngine {
    
    private WebPageNode root; // root of the BST-based search engine
    
    // creates an empty search engine
    public SearchEngine() {
            root = null;
    }
    
    
    // returns true if the search engine 
    //is empty, otherwise false
    public boolean isEmpty() {
        return root == null;
    }
                            
    
    // inserts an instance 
    // of WebPageNode with the given id and weblink into the search 
    // engine conforming to the search order property of a BST.
    // This method throws an exception if the user tries to 
    // insert an entry with a duplicate id.
    // !!!! A helper method should be used here !!!!
    // The insert method may call a private recursive 
    //      helper method to operate
    public void insert(String id, String webLink){
            root = insertKey(root, id, webLink);
    }
 
    
    // A look-up method that 
    // searches for a webPageNode with the given id in the current
    // search engine and returns the related weblink if that webPageNode 
    // is present. Otherwise, a Warning message starting with 
    // "No web link found" should be returned back, for instance: 
    // "No web link found for the web page <id>".
    // !!!! A helper method should be used here !!!!
    // The searchWebPage method may call a private recursive 
    //     helper method to operate
    public String searchWebPage(String id) {
        return findWebPage(root, id);
    }
 
    
    // returns the number of webPageNodes
    // stored in the search engine
    // !!!! A helper method should be used here !!!!
    // The getWebPageCount method should call a private recursive       
    //     helper method to operate
    public int getWebPageCount() {
        int count = 0;
        if (root != null) {
            count = webPageCounter(root);
            }
        return count;
    }
    
    
    //the recursive helper method insert uses
    private WebPageNode insertKey (WebPageNode cur, String id, String webLink){
        //sets key to root if nothing before
            if (cur == null) {
                return new WebPageNode(id, webLink);
            }
            else if (cur.getId().equals(id)) {
                throw new IllegalArgumentException();
            }
            // inserts new key to left child
            else if (id.compareTo(cur.getId()) < 0) {
                cur.setLeftChild( insertKey(cur.getLeftChild(), id, webLink) );
                return cur;
            }
            // inserts new key to left child
            else {
            cur.setRightChild( insertKey(cur.getRightChild(), id, webLink) );
            return cur;
        }
    }
 
    
    // returns an ArrayList 
    // of String that stores all the id fields of the webPageNodes
    // present in the current search engine, sorted in alphabetical 
    // order from left to right.
    // !!!! A helper method should be used here !!!!        
    // The getAllWebPages method may call a private recursive       
    //     helper method to operate
    public ArrayList<String> getAllWebPages(){
        ArrayList<String> treeWebPage = new ArrayList<String>();
        if (root != null) {
            treeWebPage = gatherAllWebPages(root, treeWebPage);
        }
        return treeWebPage;
        }
    
   
    
    //the recursive helper method for searchWebPage
    private String findWebPage(WebPageNode cur, String id) {
            if (cur==null) {
                return ("No web link found for the web page " + "<" + id + ">" + ".");
            }
            else if (cur.getId().equals(id)) {
                return (cur.getWebLink());
            }
            //checks if the key's id is less than the one in place, and returns the left child if so.
            else if (id.compareTo(cur.getId()) < 0) {
                return findWebPage(cur.getLeftChild(), id);
            }
            //checks if the key's id is greater than the one in place, and returns the right child if so.
            else {
                return findWebPage(cur.getRightChild(), id);
            }
    }
    
    //the recursive helper method for getAllWebPages. It locates all entries for web pages and 
    //returns the tree of them.
    private ArrayList<String> gatherAllWebPages(WebPageNode cur, ArrayList<String> treeWebPage){
            if (cur != null) {
                if (cur.getLeftChild()!=null) {
                    gatherAllWebPages(cur.getLeftChild(), treeWebPage);
                }
                treeWebPage.add(cur.getId());
                if (cur.getRightChild() != null) {
                    gatherAllWebPages(cur.getRightChild(), treeWebPage);
                }
            }
            return treeWebPage;
    }
    
    //the recursive helper method for getWebPageCount. It returns zero if it has no root, else,
    //it returns the count for the left and right child, plus one.
    private int webPageCounter(WebPageNode cur) {
            if (cur==null) {
                return 0;
            }
            else {
                return webPageCounter (cur.getLeftChild()) + webPageCounter (cur.getRightChild()) + 1;
            }
    }
    
  
    /*main method. This gives the user the menu
     */
    public static void main(String[] args) {
            String choice;
            String [] splitInput;
            SearchEngine search = new SearchEngine();
            Scanner scnr = new Scanner (System.in);
        System.out.println();
            do {
                System.out.println("=========================== Search Engine ============================");
                System.out.print("1. Enter 'i <id> <webLink>' to insert a web page in the search engine\n"
                        + "2. Enter 's <id>' to search a web link in the search engine\n"
                        + "3. Enter 'p' to print all the web page ids in the search engine\n"
                        + "4. Enter 'c' to get the count of all web pages in the search engine\n"
                        + "5. Enter 'q' to quit the program\n"
                        + "======================================================================\n\n"
                        + "Please enter your command:");
                choice = scnr.nextLine();
                splitInput = choice.split(" ");
                if (splitInput.length == 3) {
                    if (splitInput[0].equalsIgnoreCase("i")) {
                        try {
                            if (splitInput[1] == "" || splitInput[2] == "") {
                                System.out.println("WARNING: failed to insert web page: Id/web link can’t be blank!");
                                }
                                else
                                    search.insert(splitInput[1], splitInput[2]);
                            }
                        catch (IllegalArgumentException excpt) {
                            System.out.println("WARNING: Failed to insert duplicate web page: " + splitInput[1]);
                            }
                        }
                    else {
                        System.out.println("Warning: Unrecognized command.");
                    }
                }
                else if (splitInput.length == 2) {
                    if (splitInput[0].equalsIgnoreCase("s")) {
                        if (splitInput[0] == " ") {
                            System.out.println("WARNING: Invalid syntax for search operation: Id link can't blank!");
                        }
                        else {
                            String link;
                            link = search.searchWebPage(splitInput[1]);
                            System.out.println(splitInput[1]+ " - " + link);
                        }
                    }
                    else{
                        System.out.println("Warning: Unrecognized command.");
                    }
                }
                else if (splitInput.length==1) {
                    if (splitInput[0].equalsIgnoreCase("p")) {
                        ArrayList<String> webPageList = new ArrayList<String>();
                        webPageList = search.getAllWebPages();
                        if (search.getWebPageCount() == 0) {
                            System.out.println("Search Engine is empty.");
                        }
                        else {
                            for (int i=0; i<webPageList.size(); i++) {
                                System.out.print(webPageList.get(i));
                                if (i != webPageList.size() -1) {
                                    System.out.print(", ");
                                }
                            }
                        }
                        System.out.println();
                    }
                    else if (splitInput[0].equalsIgnoreCase("c")) {
                        System.out.println(search.getWebPageCount());

                    }
                    else if (!splitInput[0].equalsIgnoreCase("q")) {
                        System.out.println("Warning: Unrecognized command.");
                    }
                }
                else{
                    System.out.println("Warning: Unrecognized command.");
                }
                if (!(splitInput[0].equals("q"))){
                    System.out.println();
                }
            }
            while (!choice.equalsIgnoreCase("q"));
            if (splitInput[0].equals("q")) {
                System.out.print("============================== END ===================================");
            }
    }
}