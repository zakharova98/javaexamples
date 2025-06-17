package org.example.classes;

public class InnerClassDemo {

    private OuterClass outerClass;

    public InnerClassDemo() {
        this.outerClass = new OuterClass();
    }

    public OuterClass getOuterClass() {
        return outerClass;
    }

    class OuterClass {
        private int outer_x;

        public OuterClass() {
            this.outer_x = 100;
        }

        void display() {
            InnerClass innerClass = new InnerClass();
            innerClass.display();
        }

        public int getOuter_x() {
            return this.outer_x;
        }

        class InnerClass {

           public InnerClass() {
           }

           void display() {
                System.out.println("display(): outer_x = " + outer_x);
            }
       }
    }
}
