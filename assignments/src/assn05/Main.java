package assn05;


public class Main {

    public static void main(String[] args) {
        /*
        Part 1 - Write some tests to convince yourself that your code for Part 1 is working
         */

        SimpleEmergencyRoom er = new SimpleEmergencyRoom();

        er.addPatient("sussy", 3);
        er.addPatient("amongus", 2);
        er.addPatient("spongebob", 5);

        System.out.print(er.dequeue());

       /*
        Part 2 - Write some tests to convince yourself that your code for Part 2 is working
         */





        /*
        Part 3
         */
//        MinBinHeapER transfer = new MinBinHeapER(makePatients());
//        Prioritized[] arr = transfer.getAsArray();
//        for(int i = 0; i < transfer.size(); i++) {
//            System.out.println("Value: " + arr[i].getValue()
//                    + ", Priority: " + arr[i].getPriority());
//        }

    }

    public static void fillER(MinBinHeapER complexER) {
        for(int i = 0; i < 100000; i++) {
            complexER.enqueue(i);
        }
    }
    public static void fillER(SimpleEmergencyRoom simpleER) {
        for(int i = 0; i < 100000; i++) {
            simpleER.addPatient(i);
        }
    }

    public static Patient[] makePatients() {
        Patient[] patients = new Patient[10];
        for(int i = 0; i < 10; i++) {
            patients[i] = new Patient(i);
        }
        return patients;
    }
    
    public static double[] compareRuntimes() {
    	// Array which you will populate as part of Part 4
    	double[] results = new double[4];
        double tempTime;
    	
        SimpleEmergencyRoom simplePQ = new SimpleEmergencyRoom();
        fillER(simplePQ);

        // Code for (1) Here
        tempTime = System.nanoTime();
        for(int i = 0; i < 100000; i++) {
            simplePQ.dequeue();
        }
        results[0] = System.nanoTime() - tempTime;
        results[1] = results[0]/100000;

        MinBinHeapER binHeap = new MinBinHeapER();
        fillER(binHeap);

        // Code for (2) Here
        tempTime = System.nanoTime();
        for(int i = 0; i < 100000; i++) {
            binHeap.dequeue();
        }
        results[2] = System.nanoTime() - tempTime;
        results[3] = results[2]/100000;

        return results;
    }



}



