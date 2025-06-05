package ch.hslu.ad.D1_EX_ArrayListenQueueStack.stackmachine;

import java.util.ArrayList;
import java.util.Stack;

public class StackMachine {
    public static void main(String[] args) {
        ArrayList<String> program = new ArrayList<>();
        program.add("LOAD 3");
        program.add("LOAD 2");
        program.add("ADD");
        program.add("LOAD 4");
        program.add("MUL");
        program.add("PRINT");

        handleProgram(program);

        ArrayList<String> program2 = new ArrayList<>();
        program2.add("LOAD 5");
        program2.add("LOAD 4");
        program2.add("ADD");
        program2.add("LOAD 3");
        program2.add("LOAD 2");
        program2.add("ADD");
        program2.add("MUL");
        program2.add("PRINT");

        handleProgram(program2);

        ArrayList<String> program3 = new ArrayList<>();
        program3.add("LOAD 4");
        program3.add("LOAD 7");
        program3.add("SUB");
        program3.add("LOAD 6");
        program3.add("DIV");
        program3.add("LOAD 5");
        program3.add("MUL");
        program3.add("PRINT");

        handleProgram(program3);
    }

    public static void handleProgram(ArrayList<String> program){
        Stack<Integer> stack = new Stack<>();
        for (String command : program){
            switch (command) {
                case "ADD":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "MUL":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "DIV":
                    stack.push(stack.pop() / stack.pop());
                    break;
                case "SUB":
                    stack.push(stack.pop() - stack.pop());
                    break;
                case "PRINT":
                    System.out.println(stack.pop());
                default:
                    if (command.contains("LOAD")){
                        stack.push(Integer.parseInt(command.split(" ")[1]));
                    }
            }
        }
    }
}
