// -Najm Sheikh
// -11/5/14
// -Create a guessing game that remembers and calculates high scores.

import java.util.*;
import java.io.*;
import javax.swing.*;

class guessGame {
    public static void main(String[] args)throws IOException {
    	JFrame frame = new JFrame("Input");
        File file = new File("Scores.txt");
        BufferedReader rd = new BufferedReader(new FileReader(file));
        BufferedWriter rt = new BufferedWriter(new FileWriter(file,true));
        int secret = 4, ct = 0;
        Integer guess = 0;
        String name="",line;
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<Integer> highscores = new ArrayList<Integer>();
        ArrayList<Integer> scores = new ArrayList<Integer>();
        int s1,s2,s3,z1,z2,z3;
   
//        SORTING
        while((line = rd.readLine()) != null){
        	int spc = line.indexOf(" ");
        	names.add(line.substring(0,spc));
            scores.add(Integer.parseInt(line.substring(spc+1)));
            highscores.add(Integer.parseInt(line.substring(spc+1)));
        }
        
//        HIGHSCORE
        Collections.sort(scores);
        s1 = scores.get(0);
        s2 = scores.get(1);
        s3 = scores.get(2);
        z1 = highscores.indexOf(s1);
        z2 = highscores.indexOf(s2);
        z3 = highscores.indexOf(s3);

//        SECRET NUMBER GENERATOR & HINTER
        secret = (int) (Math.random() * 100 + 1);
        long startTime = System.currentTimeMillis();
        while (!(ct >= 5 || guess == secret)) {
        	guess = Integer.parseInt(JOptionPane.showInputDialog(frame, "Guess a number"));
            ct++;

            if (guess < secret) {
                JOptionPane.showMessageDialog(frame, "Choose a number larger than " + guess);
            } else {
                if (guess > secret) {
                	JOptionPane.showMessageDialog(frame, "Choose a number smaller than " + guess);
                }
            }
        }

//        TIME CALCULATION
        long endTime = System.currentTimeMillis();
        long time = (endTime - startTime) / 1000;
        if (ct == 5 && !(guess == secret)){
        	JOptionPane.showMessageDialog(frame, "Game Over!");
        	JOptionPane.showMessageDialog(frame, "Here are the current highscores:"+"\n"+names.get(z1) + " " + s1+"\n"+names.get(z2) + " " + s2+"\n"+names.get(z3) + " " + s3);
        }
        	
//        SCORE & WIN/LOSS STATE CALCULATION
        if (guess == secret) {
        	JOptionPane.showMessageDialog(frame, "You won!");
        	JOptionPane.showMessageDialog(frame, "It took you " + time + " secs and " + ct + " try(s) to finish!");
            if((line = rd.readLine()) == null){
            	rt.newLine();
            	rd.close();
            	name = JOptionPane.showInputDialog(frame, "What is your name?");
            	rt.write(name + " " + time);
            	rt.close();
            	
            	if (time<s1){
            		JOptionPane.showMessageDialog(frame, "You set a new highscore!"+"\n"+"Here are the current highscores:"+"\n"+name + " " + time+"\n"+names.get(z1) + " " + s1+"\n"+names.get(z2) + " " + s2);
                }else{
                	JOptionPane.showMessageDialog(frame, "Here are the current highscores:"+"\n"+names.get(z1) + " " + s1+"\n"+names.get(z2) + " " + s2+"\n"+names.get(z3) + " " + s3);
                }
            }else{
            	rt.newLine();
                rd.close();
                name = JOptionPane.showInputDialog(frame, "What is your name?");
                rt.write(name + " " + time);
                rt.close();
            }
        }
     System.exit(0);
    }
}
