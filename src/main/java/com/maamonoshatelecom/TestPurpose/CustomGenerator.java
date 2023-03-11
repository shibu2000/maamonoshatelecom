package com.maamonoshatelecom.TestPurpose;

import java.io.Serializable;
import java.util.Random;


class ElevenDigitIdGenerator {

    private static final long ELEVEN_DIGIT_NUMBER= 10000000;
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private static final int LENGTH = 3;

    public Serializable generate() {
        Random random = new Random();
        long nextLong = random.nextLong(ELEVEN_DIGIT_NUMBER) ;
        
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < LENGTH; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            sb.append(randomChar);
           
        }
        sb.append(nextLong);
//        return sb;
        return nextLong;
    }
}

public class CustomGenerator {

	public static void main(String[] args) {
		ElevenDigitIdGenerator generator=new ElevenDigitIdGenerator();
		
		System.out.println(generator.generate());

	}

}
