package com.example.stream;

import java.util.List;

public class StringManipulation {
	
	String contents = "Pollution is the addition of unwanted substances into the environment"
			+ "    that can damage our Earth. There are 4 main types of Pollution; water pollution,"
			+ " air pollution, soil pollution, and noise pollution. All kinds of"
			+ " Pollution are a result of careless activities by man. "
			+ "We dump waste directly into water bodies, which results in "
			+ "water pollution. Air pollution is caused when vehicles release smoke "
			+ "into the atmosphere and make it difficult to breathe for all organisms."
			+ " Soil pollution is caused by directly dumping our waste into landfills. Noise "
			+ "pollution is not visible, but it is a dangerous form of Pollution that can damage our ears" ;
	
	
	
	void countWorks() {
		
        List<String> words = List.of(contents.split("\\PL+"));

        long count = 0;
        for (String w : words) {
            if (w.length() > 5)
                count++;
        }
        System.out.println(count);

        count = words.stream().filter(w -> w.length() > 12).count();
        System.out.println(count);

        count = words.parallelStream().filter(w -> w.length() > 12).count();
        System.out.println(count);
		
		
	}

}
