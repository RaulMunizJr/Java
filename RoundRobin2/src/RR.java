import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class RR {

// Method to find the waiting time for all
// processes

static void calWaitingTime(int processes[], int n,
float burstTime[], float waitingTime[], float quantum) {
// Make a copy of burst times burstTime[] to store remaining
// burst times.
float rem_burstTime[] = new float[n];
for (int i = 0; i < n; i++) {
rem_burstTime[i] = burstTime[i];
}

float t = 0; // Current time

// Keep traversing processes in round robin manner
// until all of them are not done.
while (true) {
boolean done = true;

// Traverse all processes one by one repeatedly
for (int i = 0; i < n; i++) {
// If burst time of a process is greater than 0
// then only need to process further
if (rem_burstTime[i] > 0) {
done = false; // There is a pending process

if (rem_burstTime[i] > quantum) {
// Increase the value of t i.e. shows
// how much time a process has been processed
t += quantum;

// Decrease the burst_time of current process
// by quantum
rem_burstTime[i] -= quantum;
} // If burst time is smaller than or equal to
// quantum. Last cycle for this process
else {
// Increase the value of t i.e. shows
// how much time a process has been processed
t = t + rem_burstTime[i];

// Waiting time is current time minus time
// used by this process
waitingTime[i] = t - burstTime[i];

// As the process gets fully executed
// make its remaining burst time = 0
rem_burstTime[i] = 0;
}
}
}

// If all processes are done
if (done == true) {
break;
}
}
}

// Method to calculate turn around time
static void calTurnAroundTime(int processes[], int n,
float burstTime[], float waitingTime[], float tat[]) {
// calculating turnaround time by adding
// burstTime[i] + waitingTime[i]
for (int i = 0; i < n; i++) {
tat[i] = burstTime[i] + waitingTime[i];
}
}

// Method to calculate average time
static void findavgTime(int processes[], int n, float burstTime[],
int quantum) {
float waitingTime[] = new float[n], tat[] = new float[n];
float total_waitingTime = 0, total_tat = 0;

// Function to find waiting time of all processes
calWaitingTime(processes, n, burstTime, waitingTime, quantum);

// Function to find turn around time for all processes
calTurnAroundTime(processes, n, burstTime, waitingTime, tat);

// Display processes along with all details
System.out.println("Processes " + " Burst time "
+ " Waiting time " + " Turn around time");

// Calculate total waiting time and total turn
// around time
for (int i = 0; i < n; i++) {
total_waitingTime = total_waitingTime + waitingTime[i];
total_tat = total_tat + tat[i];
System.out.println(" " + (i + 1) + "\t\t" + burstTime[i] + "\t "
+ waitingTime[i] + "\t\t " + tat[i]);
}

System.out.println("Average waiting time = "
+ (float) total_waitingTime / (float) n);
System.out.println("Average turn around time = "
+ (float) total_tat / (float) n);
}

  
public static void main(String[] args) throws FileNotFoundException {
// process id's
int processes[] = {1, 2, 3};
int n = processes.length;

Scanner scanner = new Scanner(new File("test.txt"));

ArrayList<String> allData = new ArrayList<String>();

while (scanner.hasNext()) {
String data = scanner.nextLine();
allData.add(data);

}

int size = allData.size();

int[] processData1 = new int[size];//Arrays.stream(arr1).mapToInt(Integer::parseInt).toArray();

float[] burstData1 = new float[size];

// Burst time of all processes
int burst_time[] = {10, 5, 8};
int i = 0;
scanner = new Scanner(new File("test.txt"));
while (scanner.hasNext()) {
processData1[i] = scanner.nextInt();//read int value
burstData1[i] = scanner.nextFloat(); //readFlaot value directly
i++;
// System.out.println("process:" + processData1[i - 1] + "\t burst:" + burstData1[i - 1]);
}
// Time quantum
int quantum = 500;
findavgTime(processData1, size, burstData1, quantum);
}
}