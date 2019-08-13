import org.junit.Assert;

import java.util.Random;

public class perceptron {
   final float LEARNING_CONSTANT = 0.01f;
    float[] weights;
    float error;
    float desired;
    Random random;

     perceptron(int n){
        weights = new float[n];
        random = new Random(2);
        for (int i = 0;i<weights.length;i++){
            weights[i] = random.nextInt(1);
        }

    }

    void train(float[] inputs,float desired){
         int guess = feedForward(inputs);
            this.desired = desired;
          error = desired - guess;

        for (int i = 0;i<weights.length;i++){
            weights[i] += LEARNING_CONSTANT * error * inputs[i];
        }
    }

    public float getError() {
        if (error == 0){
            return desired;

        }else {
            return error;
        }
    }

    int feedForward(float[] inputs){
        int sum = 0;
        for (int i = 0;i<weights.length;i++){
           sum += weights[i] * inputs[i];
        }
        return sum;
    }

    int activate(int i){
        if (i > 0){
            return 1;
        }else{
            return -1;
        }
    }

}
