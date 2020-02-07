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
public class WebPageNode{
 
    private final String id;        // The id of the web page
    private final String webLink;   // The web link of the web page
    private WebPageNode leftChild;  // The leftChild of the the current WebPageNode
    private WebPageNode rightChild; // The rightChild of the the current WebPageNode
 
 //constructor for WebPageNode
    public WebPageNode(String id, String webLink) {
            this.id = id;
            this.webLink = webLink;
    } 
    
    //returns the left child of the binary tree.
    public WebPageNode getLeftChild() {
        return this.leftChild;
    }
    //sets the left child of the binary tree.
    public void setLeftChild(WebPageNode leftChild) {
        this.leftChild = leftChild;
    }
    //returns the right child of the binary tree.
    public WebPageNode getRightChild() {
        return this.rightChild;
    }
    //sets the left child of the binary tree.
    public void setRightChild(WebPageNode rightChild) {
        this.rightChild = rightChild;
    }
    //returns the id of a given entry.
    public String getId() {
        return this.id;
    }
    //returns the web link of a given entry.
    public String getWebLink() {
        return this.webLink;
    }
}

