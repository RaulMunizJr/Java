import java.util.List;

import java.util.ArrayList;

import dlange.GraphSolver.Transition;

import dlange.GraphSolver.Goal;



public class WaterBucket {

 

   public static void main(String[] args) {

   final String Instructions = " WaterBucket [water bucket size] [water bucket size] [solution size] \n Sizes are positive values.";

   if (3 == args.length) {

   try {

   // capture the three parameters

   int sizeBucketA = Integer.parseInt(args[0]);

   int sizeBucketB = Integer.parseInt(args[1]);

   int sizeSolution = Integer.parseInt(args[2]);

   // try the problem

   System.out.println(new WaterBucket().tryToAttempt(sizeBucketA, sizeBucketB, sizeSolution));

  

   } catch (NumberFormatException ie) {

   System.out.println("Invalid bucket size or solution size:" + args[0]+" "+args[1]+" "+args[2]);

   System.out.println(Instructions);

   }

   } else {

   System.out.println("Requires 3 parameters, provided "+args.length+" parameters.");

   System.out.println(Instructions);

   }

   }

  

   public String tryToAttempt(int sizeBucketA, int sizeBucketB, int sizeSolution) {

   if (solvableOrNot(sizeBucketA, sizeBucketB, sizeSolution)) {

   return (solution(sizeBucketA, sizeBucketB, sizeSolution).verboseInstructions());

   } else {

   return("Provided bucket size and solution size is not solvable");

   }

   }


   protected boolean solvableOrNot(int sizeBucketA, int sizeBucketB, int sizeSolution) {


   if (sizeSolution > sizeBucketA && sizeSolution > sizeBucketB) {

   return false;

   }


   if (sizeBucketA < 0 || sizeBucketB < 0 || sizeSolution < 0) {

   return false;

   }


if (sizeBucketA % 2 == 0 && sizeBucketB % 2 == 0 && sizeSolution % 2 != 0) {

return false;

}


if (0 == sizeBucketA && ( (0 == sizeBucketB) || (sizeSolution % sizeBucketB != 0) ) ) {

return false;

}


if (0 == sizeBucketB && ( (0 == sizeBucketA) || (sizeSolution % sizeBucketA != 0) ) ) {

return false;

}


int gd = gcd(sizeBucketA, sizeBucketB);

if (sizeSolution % gd != 0) {

return false;

}

return true;

   }

  

protected int gcd(int a, int b) {

if (0 == b) {

return a;

}

return gcd(b, a % b);

}



   @SuppressWarnings("unchecked")

   protected ResultSolution solution(int sizeBucketA, int sizeBucketB, int sizeSolution) {

   return new ResultSolution(

   new GraphSolver().bfs(

   new BucketMix(0, 0, "Initial state"),

   new SolutionGoal(sizeSolution),

   new FindBucketStates(sizeBucketA, sizeBucketB)));

   }

  

   public class SolutionGoal implements Goal<BucketMix> {

   int sizeSolution;

   public SolutionGoal(int sizeSolution) {

   this.sizeSolution = sizeSolution;

   }

   @Override

   public boolean isGoal(BucketMix candidate) {

   if (candidate.sizeBucketA == sizeSolution || candidate.sizeBucketB == sizeSolution) {

   return true;

   }

   return false;

   }

  

   }

  

  

   public class FindBucketStates implements Transition<BucketMix> {

   private int sizeBucketA;

   private int sizeBucketB;

   public FindBucketStates(int sizeA, int sizeB) {

   this.sizeBucketA = sizeA;

   this.sizeBucketB = sizeB;

   }

   @Override

   public List<BucketMix> transitions(BucketMix currentMixture) {

   List<BucketMix> list = new ArrayList<BucketMix>();

int x = currentMixture.sizeBucketA;

int y = currentMixture.sizeBucketB;

int b1 = sizeBucketA;

int b2 = sizeBucketB;

if (x < b1 && y > 0) {

// move partial from y to x

int partial = Math.min(y, b1 - x);

String transition = "Pour "+b2+"L bucket into "+b1+"L bucket";

list.add(new BucketMix(x + partial, y - partial, transition));

}

if (y < b2 && x > 0) {

// move partial from x to y

int partial = Math.min(x, b2 - y);

String transition = "Pour "+b1+"L bucket into "+b2+"L bucket";

list.add(new BucketMix(x - partial, y + partial, transition));

}

if (x > 0) {

// empty x

String transition = "Empty "+b1+"L bucket";

list.add(new BucketMix(0, y, transition));

}

if (y > 0) {

// empty y

String transition = "Empty "+b2+"L bucket";

list.add(new BucketMix(x, 0, transition));

}

if (x < b1) {

// fill x

String transition = "Fill "+b1+"L bucket";

list.add(new BucketMix(b1, y, transition));

}

if (y < b2) {

// fill y

String transition = "Fill "+b2+"L bucket";

list.add(new BucketMix(x, b2, transition));

}

   return list;

   }

  

   }

  

   protected class ResultSolution {

   final List<BucketMix> sequence;

  

   protected ResultSolution(List<BucketMix> sequence) {

   this.sequence = sequence;

   }

  

   protected String conciseInstructions() {

   StringBuilder builder = new StringBuilder();

   for (BucketMix mixture : sequence) {

   builder.append(mixture.toString());

   builder.append("\n");

   }

   return builder.toString();

   }

   protected String verboseInstructions() {

   StringBuilder builder = new StringBuilder();

   for (BucketMix mixture : sequence) {

   builder.append(mixture.toVerboseString());

   builder.append("\n");

   }

   return builder.toString();

   }

   }

  

   protected class BucketMix {

   int sizeBucketA;

   int sizeBucketB;

   String transition;

  

   public BucketMix(int a, int b, String transition) {

   this.sizeBucketA = a;

   this.sizeBucketB = b;

   this.transition = transition;

   }

   public String toVerboseString() {

   return transition+" leaving "+toString();

   }

   public String toString() {

   return "["+sizeBucketA+","+sizeBucketB+"]";

   }

   }

}

