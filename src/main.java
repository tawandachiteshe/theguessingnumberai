import org.apache.commons.io.HexDump;
import org.junit.*;
import org.slf4j.event.EventRecodingLogger;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class main {


    BASE64Encoder encoder = new BASE64Encoder();

    BASE64Decoder base64Decoder = new BASE64Decoder();
    float[] guessArray = new float[999];
    String thread_name = "";
    Thread SecondThread = null;
    @Test
    public void main() {
        perceptron p = new perceptron(3);
        float desired = 6;
//
//        try {
//
//            BASE64Decoder f = new BASE64Decoder();
//            byte[] as = f.decodeBuffer("helloo");
//            String nam = encoder.encode(" 02fc2e5ab52c89f3bfbbbd702254ab9fc7134173e5682b69bf740c3d0bf6bfc4ce"
//                    .getBytes());
//                System.out.println(as.length + " " + nam);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        float[] inputsx = new float[3];
        float[] inputsy = new float[3];
        float inputs[] = new float[3];

        SecondThread = new Thread(this::thread_num_two);
        thread_name = "thread_two";
        SecondThread.setName(thread_name);
        SecondThread.start();

        inputsx[2] = 2;
        inputsy[2] = 1;

        float f = 0;
            for(int i = 0; i < inputsx.length; i++){
                f++;
                inputsx[i] = f;
                inputsy[i] = f;

                inputs[i] = inputsx[i] + inputsy[i];
            }
            int guessInc = 0;
            float realAnswer = 0;
        int guess = 0;
        while (guess != desired){
            guess = p.feedForward(inputs);
            p.train(inputs,desired);
            guessInc++;
            if (guess == desired || p.getError() == desired){
                realAnswer = guess;
            }
          //guessArray[guessInc] = guess;

        }

        System.out.println("the correct answer is " + p.getError());
        System.out.println("times tried before an actual answer " + guessInc + "\n\n\n\n");
        System.out.println(SecondThread.getName() + ":\t" + "Thread State " + SecondThread.getStackTrace());
        try {
            Assert.assertEquals( desired,desired,9);
        } catch (Exception e) {
            System.out.println("system failed");
        }


//     for (float i: guessArray
//          ) {
//           System.out.println("times tried before an actual answer " + i);
//    }



    }
    @Test
    public void thread_num_two(){
        perceptron p = new perceptron(3);
        float desired = 999999;
        float[] inputsx = new float[3];
        float[] inputsy = new float[3];
        float inputs[] = new float[3];
       inputsx[2] = 5;
        inputsy[2] = 2;

        float f = 0;
        for(int i = 0; i < inputsx.length; i++){
            f++;
            inputsx[i] = f;
            inputsy[i] = f;

            inputs[i] = inputsx[i] + inputsy[i];
        }
        int guessInc = 0;
        float realAnswer = 0;
        int guess = 0;
        while (guess != desired){
            guess = p.feedForward(inputs);
            p.train(inputs,desired);
            guessInc++;
            if (guess == desired || p.getError() == desired){
                realAnswer = guess;

            }


//            guessArray[guessInc] = guess;

        }

        System.out.println("the correct answer is " + p.getError());
        System.out.println("times tried before an actual answer " + guessInc + "\n\n\n\n");

        try {
            Assert.assertEquals(desired,desired,9);
        } catch (Exception e) {
            System.out.println("system failed");
        }


    }



}
