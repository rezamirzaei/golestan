package ir.golestan.model;

import javax.persistence.*;

/**
 * Created by Reza-PC on 6/23/2017.
 */
@Entity
public class Score {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    Course course;

    @Column
    String username;
    @Column
    int score;

    public Score(){

    }
    public Score(String username,int score){
        this.score = score;
        this.username = username;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
