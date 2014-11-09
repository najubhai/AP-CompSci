// -Najm Sheikh
// -11/5/14
// -Create a...


import java.util.Scanner;
import java.io.*;

class guessGame {
    @SuppressWarnings("resource")
	public static void main(String[] args)throws IOException {
        Scanner sc = new Scanner(System.in);
        File scores = new File("Scores.txt");
        BufferedReader rd = new BufferedReader(new FileReader(scores));
        BufferedWriter rt = new BufferedWriter(new FileWriter(scores,true));
        int secret = 4, ct = 0, guess = 0, s1 = 100,s2 = 100, s3 = 100,highScore = 0;
        String name="",line;
        
        line = rd.readLine();
        if(rd.readLine() != null)
            s1 = (int)(line.indexOf(" ")+1);
        line = rd.readLine();
        if(rd.ready() == true)
            s2 = (int)(line.indexOf(" ")+1);
        line = rd.readLine();
        if(rd.ready() == true)
            s3 = (int)(line.indexOf(" ")+1);
//        highScore = Math.max(s1,Math.max(s2,s3));
        System.out.println(s1+" "+s2+" "+s3);

//        secret = (int) (Math.random() * 100 + 1);
        long startTime = System.currentTimeMillis();
        while (!(ct >= 5 || guess == secret)) {
            System.out.println("Enter your guess:");
            guess = sc.nextInt();
            ct++;

            if (guess < secret) {
                System.out.println("This is a smaller number!");
            } else {
                if (guess > secret) {
                    System.out.println("This is a bigger number!");
                }
            }
        }

        long endTime = System.currentTimeMillis();
        long time = (endTime - startTime) / 1000;
        if (ct == 5 && !(guess == secret))
            System.out.println("Game Over!");

        if (guess == secret) {
            System.out.println("You won!");
            System.out.println("It took you " + time + " secs and " + ct + " try(s) to finish!");
            highScore = (int) Math.max(highScore, time);
//            if(highScore == time)
//                System.out.println("You set a new high score!");
            if(rd.readLine() == null){
            	System.out.println("What is your name?");
            	rd.close();
            	name = sc.next();
            	rt.write(name + " " + time);
            	rt.close();
            }else{
            	rt.newLine();
            	System.out.println("What is your name?");
                rd.close();
                name = sc.next();
                rt.write(name + " " + time);
                rt.close();
            }
        }
    }
}