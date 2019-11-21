/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package madlibs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kevin Diehr
 */
public class SentenceCollection {
    ArrayList<DB_Sentence> sentence = new ArrayList<DB_Sentence>();
    private ConnectionPool connectionPool;
    Random rand = new Random();
        public SentenceCollection(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;

        try {

            connectionPool.CreateConnectionPool("kdiehr", "wRRBe9SY3E3g", 1, 10, true);

        } catch (SQLException ex) {
            Logger.getLogger(SentenceCollection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void removeSentence(int index){
        Connection con = null;
        Statement stmt;

        try {
            con = connectionPool.getConnection();
            stmt = con.createStatement();
            String addQuery = "delete from Sentences where sentenceID=" + index + ";";
            stmt.executeUpdate(addQuery);
        } catch (SQLException ex) {
            Logger.getLogger(SentenceCollection.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connectionPool.free(con);
        }
    }
        
        
    public void addSentence(DB_Sentence sentence){
        Connection con = null;
        Statement stmt;
        PreparedStatement safe;
        
        try{
            con = connectionPool.getConnection();
            stmt = con.createStatement();
            //String addQuery = "insert into Sentences value('0', '" + sentence.getSentence() + "')";
            String safeSQL = "insert into Sentences value ('0', ?)";
            
            safe = con.prepareStatement(safeSQL);
            safe.setString(1, sentence.getSentence());
           // stmt.executeUpdate(addQuery);
           safe.executeUpdate();
            
        }catch (SQLException ex) {
            Logger.getLogger(SentenceCollection.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connectionPool.free(con);
        }
    }
    
    public DB_Sentence generateSentence(){
        Connection con = null;
        Statement stmt;
        String newSentence = "";
        int id;
        ResultSet rs;
        DB_Sentence sentenceNew = null;
        try {
            con = connectionPool.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT COUNT(*) AS c FROM Sentences;");
            rs.next();
            int i = rs.getInt("c");
            System.out.println(i + "NUMBER OF SENTENCES");
            int j = rand.nextInt(i);
            System.out.println(j);
            
            rs = stmt.executeQuery("SELECT * FROM Sentences LIMIT " + j + ", 1;");
            rs.next();
            newSentence = rs.getString("Sentence");
            id = Integer.parseInt(rs.getString("sentenceID"));
            System.out.println(id + "< ----- ID HERE");
            sentenceNew = new DB_Sentence(newSentence, id);
            
            
        }catch (SQLException ex) {
            Logger.getLogger(SentenceCollection.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connectionPool.free(con);
     
        }
        
        return sentenceNew;
    }
}
