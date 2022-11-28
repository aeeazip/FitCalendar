package model;

public class Fitmate {
   private int exerciser1;
   private int exerciser2;
   public Fitmate(int exerciser1, int exerciser2) {
      super();
      this.exerciser1 = exerciser1;
      this.exerciser2 = exerciser2;
   }
   public int getExerciser1() {
      return exerciser1;
   }
   public void setExerciser1(int exerciser1) {
      this.exerciser1 = exerciser1;
   }
   public int getExerciser2() {
      return exerciser2;
   }
   public void setExerciser2(int exerciser2) {
      this.exerciser2 = exerciser2;
   }
   @Override
   public String toString() {
      return "Fitmate [exerciser1=" + exerciser1 + ", exerciser2=" + exerciser2 + "]";
   }

   
}