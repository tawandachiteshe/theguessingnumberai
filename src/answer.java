public class answer {
    float asm = 0;
    float[] inputs = new float[100];
    answer(float a){

        float f = 0;
        for(int i = 0; i < inputs.length; i++){
            f++;
            inputs[i] = f + 1;
        }

        for(float i : inputs){
           if(i < adder(i)){
               asm = -1;
           }else {
               asm = 1;
           }
        }

        asm = a;
    }

    float adder(float x){
        return x + 1.0f;
    }
}
