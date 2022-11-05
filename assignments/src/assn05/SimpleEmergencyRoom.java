package assn05;

import java.util.ArrayList;
import java.util.List;

public class SimpleEmergencyRoom {
    private List<Patient> patients;

    public SimpleEmergencyRoom() {
        patients = new ArrayList<>();
    }

    public Patient dequeue() {
    	if (patients.size() == 0) {
            return null;
        } else {
            int minIndex = 0;
            for (int i = 1; i < patients.size()-1; i++) {
                if (patients.get(i).getPriority().compareTo(patients.get(minIndex).getPriority()) < 0){
                    minIndex = i;
                }
            }
            Patient temp = patients.get(minIndex);
            patients.remove(minIndex);
            return temp;
        }
    }

    public <V, P> void addPatient(V value, P priority) {
        Patient patient = new Patient(value, (Integer) priority);
        patients.add(patient);
    }

    public <V> void addPatient(V value) {
        Patient patient = new Patient(value);
        patients.add(patient);
    }

    public List getPatients() {
        return patients;
    }

    public int size() {
        return patients.size();
    }

}
