/*
The goal is to build a working calculator that takes in expressions in prefix notation, 
evaluates them, and outputs the result.

> 1
1
> + 1 2
3
> + 1 * 2 3
7
> + * 1 2 3
5
> + + + 1 2 3 4
10
> + 1 + 2 + 3 4
10
> / - 15 5 - 3 1
5
*/

package Interview.Docker;

import java.util.Deque;
import java.util.ArrayDeque;

public class WorkingCalculator {
    public int evaluateExpression(String expression) {
        if (expression.isEmpty()) {
            throw new IllegalArgumentException("Expression is empty");
        }

        String trimmedExpression = expression.trim();
        if (trimmedExpression.isEmpty()) {
            throw new IllegalArgumentException("Expression is empty");
        }

        String[] tokens = trimmedExpression.split("\\s+");
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i];
            if (isOperator(token)) {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Invalid expression");
                }
                int a = stack.pop();
                int b = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(a / b);
                        break;
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }
    public static void main(String[] args) {
        WorkingCalculator calculator = new WorkingCalculator();
        System.out.println(calculator.evaluateExpression("+ 1 2"));
        System.out.println(calculator.evaluateExpression("+ 1 * 2 3"));
        System.out.println(calculator.evaluateExpression("+ * 1 2 3"));
        System.out.println(calculator.evaluateExpression("+ + + 1 2 3 4"));
        System.out.println(calculator.evaluateExpression("+ 1 + 2 + 3 4"));
        System.out.println(calculator.evaluateExpression("/ - 15 5 - 3 1"));
    }
}
