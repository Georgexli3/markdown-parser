//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinksNew(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);
            if((markdown.substring(openParen + 1 ,closeParen).startsWith("https") == false) && markdown.substring(openParen+1, closeParen).endsWith(".html") == false){
                toReturn.add(markdown.substring(openParen + 1, closeParen) + ".html");
            }
            else{
                toReturn.add(markdown.substring(openParen + 1, closeParen));
            }
            //toReturn.add(markdown.substring(openParen + 1, closeParen));
            currentIndex = closeParen + 1;
            System.out.println("hello");
        }

        return toReturn;
    }

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int openBracket = markdown.indexOf("[", currentIndex);
            System.out.println(openBracket);
            int closeBracket = markdown.indexOf("]", openBracket);
            System.out.println(closeBracket);
            int openParen = markdown.indexOf("(", closeBracket);
            System.out.println(openParen);
            int closeParen = markdown.indexOf(")", openParen);
            System.out.println(closeParen);
            toReturn.add(markdown.substring(openParen + 1, closeParen));
            currentIndex = closeParen + 1;
        }

        return toReturn;
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinksNew(content);
	    System.out.println(links);
    }
}
