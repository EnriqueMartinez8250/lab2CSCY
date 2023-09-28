package edu.ucdenver.cscy3765_lab2.library;

public class Author {
    private final String authorName;

    public Author(String authorName) {
        this.authorName = authorName;
    }
    public String getAuthorName() {
        return authorName;
    }

    @Override
    public String toString(){
        return  authorName + " (Author)";
    }


}