import java.util.LinkedList;
import java.util.Scanner;

public class PostfixExpression implements Expression {

  private String expression;
  //private LinkedList deque;
  //private double result;


  //TODO Detect invalid Postfix expression. The easiest way to detect invalid postfix expressions is
  // to process them in a similar way to evaluating them. But instead of actually evaluating them we
  // would look for erroneous conditions (e.g. wanting to pop two things from the stack when it does
  // not have them, etc.) as we process them.

  /**
   * Constructor that takes a postfix expression as a string as its only parameter. The string has
   * operands and operators separated by spaces, with no leading or trailing spaces. It will throw
   * an IllegalArgumentException if the provided expression is invalid.
   */
  public PostfixExpression(String expression) throws IllegalArgumentException {
    this.expression = expression;
    LinkedList stack = new LinkedList();

    //Scan the expression from left to right, one token at a time.
    Scanner s = new Scanner(this.expression);

    //Read the next token.
    while (s.hasNext()) {
      String token = s.next();

      //If the token is an operand, push it on to a stack.
      if (!("*+-/".contains(token))) {

        stack.push(token);
      }
      else if ("*".contains(token))
      {
        if (stack.size() > 1)
        {
          String operand1 = (String) (stack.pop());
          String operand2 = (String) (stack.pop());
          String result = operand1 + operand2;
          stack.push(result);
        }
        // If there aren’t two operands on the stack, report the expression as an error and exit.
        else { throw new IllegalArgumentException("1Not enough operands"); }
      }
      else if ("+".contains(token))
      {
        if (stack.size() > 1)
        {
          String operand1 = (String) (stack.pop());
          String operand2 = (String) (stack.pop());
          String result = operand1 + operand2;
          stack.push(result);
        }
        // If there aren’t two operands on the stack, report the expression as an error and exit.
        else { throw new IllegalArgumentException("2Not enough operands"); }
      }
      else if ("-".contains(token))
      {
        if (stack.size() > 1)
        {
          String operand1 = (String) (stack.pop());
          String operand2 = (String) (stack.pop());
          String result = operand2 + operand1;
          stack.push(result);
        }
        // If there aren’t two operands on the stack, report the expression as an error and exit.
        else
          {
          throw new IllegalArgumentException("3Not enough operands");
        }
      }
      else if ("/".contains(token))
      {
        if (stack.size() > 1) {
          String operand1 = (String) (stack.pop());
          String operand2 = (String) (stack.pop());
          String result = operand1 + operand2;
          stack.push(result);
        }
        else { throw new IllegalArgumentException("4Not Enough operands");}
      }
        else
          {
          throw new IllegalArgumentException("5Not enough operands");
        }
      }
    System.out.println(stack.size());
    if (stack.size() != 1) {
      throw new IllegalArgumentException("Not enough operators");
    }
    }

  //}


  /**
   * Evaluates and returns the result of a postfix expression. It will throw an ArithmeticException
   * if the expression cannot be evaluated (e.g. if its operands are algebraic letters).
   *
   * @return a double representing the result of evaluating a postfix expression.
   */
  public double evaluate() throws ArithmeticException {
    LinkedList stack = new LinkedList();

    //Scan the expression from left to right, one token at a time.
    Scanner s = new Scanner(this.expression);

    //Read the next token.
    while (s.hasNext()) {
      String token = s.next();

      //If the token is an operand, push it on to a stack.
      if ("0123456789".contains(token)) {
        double doubleToken = Double.parseDouble(token);
        stack.push(doubleToken);
        //If the token is an operator, pop the top two operands from the stack, apply this
        // operator to them and push the result back into the stack.
      } else if (token.length() > 1) {
        double doubleToken = Double.parseDouble(token);
        stack.push(doubleToken);
      } else if ("*".contains(token)) {
        if (stack.size() > 1) {
          double operand1 = (double) (stack.pop());
          double operand2 = (double) (stack.pop());
          double result = operand1 * operand2;
          stack.push(result);
        }
        // If there aren’t two operands on the stack, report the expression as an error and exit.
      } else if ("+".contains(token)) {
        if (stack.size() > 1) {
          double operand1 = (double) (stack.pop());
          double operand2 = (double) (stack.pop());
          double result = operand1 + operand2;
          stack.push(result);
        }
        // If there aren’t two operands on the stack, report the expression as an error and exit.
      } else if ("-".contains(token)) {
        if (stack.size() > 1) {
          double operand1 = (double) (stack.pop());
          double operand2 = (double) (stack.pop());
          double result = operand2 - operand1;
          stack.push(result);
        }
        // If there aren’t two operands on the stack, report the expression as an error and exit.
      } else if ("/".contains(token)) {
        if (stack.size() > 1) {
          double operand1 = (double) (stack.pop());
          double operand2 = (double) (stack.pop());
          double result = operand2 / operand1;
          stack.push(result);
        }
        // If there aren’t two operands on the stack, report the expression as an error and exit.
      } else {
        throw new ArithmeticException("Not enough operands87623487");
      }
    }
    //The evaluation is done, the answer is the only thing in the stack.
    return (double) stack.pop();
  }


  /**
   * Returns a string representation of the expression. Each operand and operator is separated by a
   * single space, with no leading or trailing spaces.
   *
   * @return a string representation of the expression.
   */
  public String toString() {
    return this.expression;
  }


}
