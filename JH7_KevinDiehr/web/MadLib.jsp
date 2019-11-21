<%-- 
    Document   : MadLib
    Created on : Apr 15, 2019, 7:03:57 PM
    Author     : Kevin Diehr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Madlibs</title>
        <link href="madlibcss.css" rel="stylesheet" type="text/css" />
    </head>
    <pre>
To create a funny sentence, enter and adjective, and then a noun, and press the 'Generate Sentence' button.
To add your own sentence, use the syntax '?a' for an adjective, and '?n' for a noun, then press the 'Submit Sentence' button.
An example of this is the following:
"The ?n is very ?a. I like the ?n due to this reason."
If you don't like the sentence that is generated, press the 'Delete Sentence' button, and it will be removed.
        </pre>
    <div class="center">
    <form action="SentenceController">
        <input type="text" name="adj" /> Adjective
        <br><input type="text" name="noun" /> Noun
        <br><input type="submit" name="action" value="Generate Sentence" />
    </form>
    <hr>
    <form action="SentenceController">
        <input type="text" name="sentence" /> Add new sentence to DB
        
        
        <br><input type="submit" name="action" value="Submit Sentence" />
    <br>${sentenceGen}
    <input type="hidden" name="index" value="${(empty sentenceID) ? 0 : sentenceID}" />
    <br><br><input type="submit" name="action" value="Delete Sentence" />
    
    </form>
    
    
    </div>
    
    
</html>
