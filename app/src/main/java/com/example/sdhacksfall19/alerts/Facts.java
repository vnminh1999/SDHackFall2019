package com.example.sdhacksfall19.alerts;
import java.util.Random;

public class Facts {

    private static Random rand = new Random();
    private static String[] facts = {
            "8 billion pounds of plastic trash winds up in our oceans each year. ",

            "There is an island of garbage twice the size of Texas inside the Pacific Ocean.",

            "Ocean pollutions kills more than one million sea birds each year.",

            "It’s estimated that by the year 2050, there will be more plastic in the ocean than fish.",

            "There are about 500 dead zones in the ocean, which covers a similar size as the United Kingdom.",

            "More than 50 percent of sea turtles have consumed plastic.",

            "Over 100,000 marine animals die every year from plastic entanglement and ingestion.",

            "Animals at the top of hierarchy of food chain have contamination levels millions times higher " +
                    "than the water in which they live.",

            "80% of pollution to the marine environment comes from land.",

            "Explore and appreciate the ocean without interfering with wildlife or removing rocks and coral.",

            "Never release any aquarium fish into the ocean or other bodies of water.",

            "All life on Earth is connected to the ocean and its inhabitants. ",

            "It’s thought that between 70 and 80 per cent of the oxygen we breathe is produced by marine plants.",

            "For every species of marine life we know of, at least another three are yet to be discovered.",

            "Water takes around 1000 years to travel all the way around the whole globe.",

            "When salt water and hydrogen sulphide combine, it becomes denser than the rest of the water around it."

    };

    private static int generateRandomIndex() {

        return rand.nextInt(facts.length);

    }

    public static String generateRandomFact(){
        int randFactIndex = generateRandomIndex();
        return facts[randFactIndex];
    }


}
