/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package madlibs;

import java.util.Objects;

/**
 *
 * @author Kevin Diehr
 */
public class DB_Sentence {
    private String sentence;
    private int index;

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return "DB_Sentence{" + "sentence=" + sentence + ", index=" + index + '}';
    }

    public DB_Sentence(String sentence, int index){
        this.sentence = sentence;
        this.index = index;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.sentence);
        hash = 83 * hash + this.index;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DB_Sentence other = (DB_Sentence) obj;
        if (this.index != other.index) {
            return false;
        }
        return true;
    }
    
}
