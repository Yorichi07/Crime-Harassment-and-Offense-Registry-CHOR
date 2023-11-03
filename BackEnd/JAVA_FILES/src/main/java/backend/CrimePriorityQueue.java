package backend;

import java.util.PriorityQueue;
import java.util.Comparator; 

public class CrimePriorityQueue {

    public static void main(String[] args) {
        // Creating a Priority Queue with a custom comparator
        PriorityQueue<CrimePriority> pq = new PriorityQueue<>(new CrimePriorityComparator());

        // Adding items to the Priority Queue
        //pq.add(new CrimePriority("MURDER", 1));
        //pq.add(new CrimePriority("ATTEMPT TO MURDER", 2));
        //pq.add(new CrimePriority("CULPABLE HOMICIDE NOT AMOUNTING TO MURDER", 4));
        //pq.add(new CrimePriority("RAPE", 3));
        //pq.add(new CrimePriority("CUSTODIAL RAPE", 5));
        //pq.add(new CrimePriority("OTHER RAPE", 6));
        //pq.add(new CrimePriority("KIDNAPPING & ABDUCTION", 7));
        //pq.add(new CrimePriority("KIDNAPPING AND ABDUCTION OF WOMEN & GIRLS", 8));
        //pq.add(new CrimePriority("KIDNAPPING & ABDUCTION OF OTHERS", 9));
        //pq.add(new CrimePriority("DACOITY", 10));
        //pq.add(new CrimePriority("PREPARATION AND ASSEMBLY OF DACOITY", 11));
        //pq.add(new CrimePriority("ROBBERY", 12));
        //pq.add(new CrimePriority("BURGLARY", 13));
        //pq.add(new CrimePriority("THEFT", 14));
        //pq.add(new CrimePriority("AUTO THEFT", 15));
        //pq.add(new CrimePriority("OTHER THEFT", 16));
        //pq.add(new CrimePriority("RIOTS", 17));
        //pq.add(new CrimePriority("CRIMINAL BREACH", 4));
        //pq.add(new CrimePriority("CHEATING", 4));
        //pq.add(new CrimePriority("COUNTERFIETING", 4));
        //pq.add(new CrimePriority("ARSON", 4));
        //pq.add(new CrimePriority("HURT/CREVIOUS HURT", 4));
        //pq.add(new CrimePriority("DOWRY DEATHS", 18));
        //pq.add(new CrimePriority("ASSAULT ON WOMEN WITH INTENT TO OUTRAGE HER MODESTY", 24));
        //pq.add(new CrimePriority("INSULT TO MODESTY OF WOMEN", 25));
        //pq.add(new CrimePriority("CRUELTY BY HUSBAND OR HIS RELATIVES", 19));
        //pq.add(new CrimePriority("IMPORTATION OF GIRLS FROM FORIEGN COUNTRIES", 26));
        //pq.add(new CrimePriority("CAUSING DEATH BY NEGLIGENCE", 27));
        //pq.add(new CrimePriority("IPC CRIMES", 28));
        //pq.add(new CrimePriority("INFANTICIDE & FOETICIDE", 20));
        //pq.add(new CrimePriority("ABETMENT TO SUICIDE", 29));
        //pq.add(new CrimePriority("EXPOSURE & ABANDONMENT", 30));
        //pq.add(new CrimePriority("PROCURATION OF MINOR GIRLS", 23));
        //pq.add(new CrimePriority("BUYING & SELLING GIRLS FOR PROSTITUTION", 21));
        //pq.add(new CrimePriority("CHILD MARRIAGE", 22));

        // Printing items in priority order
        while (!pq.isEmpty()) {
            CrimePriority crime = pq.poll();
            System.out.println(crime.info + " (Priority: " + crime.priority + ")");
        }
    }

    // class to represent crime with priority
    static class CrimePriority {
        String info;
        int priority;

        public CrimePriority(String info, int priority) {
            this.info = info;
            this.priority = priority;
        }
    }

    //comparator to order crimes by priority
    static class CrimePriorityComparator implements Comparator<CrimePriority> {
        @Override
        public int compare(CrimePriority crime1, CrimePriority crime2) {
            return Integer.compare(crime1.priority, crime2.priority);
        }
    }
}
