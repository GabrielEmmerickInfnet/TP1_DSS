package controller;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


@RestController
public class MatchController {
	
    static class NumbersInput {
        private double num1;
        private double num2;

        public double getNum1() {
            return num1;
        }

        public void setNum1(double num1) {
            this.num1 = num1;
        }

        public double getNum2() {
            return num2;
        }

        public void setNum2(double num2) {
            this.num2 = num2;
        }
    }
    
    private List<Double> numbers = (List<Double>) Arrays.asList(10.0, 5.0);

    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public double add() {
        return numbers.get(0) + numbers.get(1);
    }

   
    @RequestMapping(value = "/subtract", method = RequestMethod.GET)
    public double subtract() {
        return numbers.get(0) - numbers.get(1);
    }

    
    @RequestMapping(value = "/multiply", method = RequestMethod.GET)
    public double multiply() {
        return numbers.get(0) * numbers.get(1);
    }

    
    @RequestMapping(value = "/divide", method = RequestMethod.GET)
    public double divide() {
        if (numbers.get(1) == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return numbers.get(0) / numbers.get(1);
    }
    
    @RequestMapping(value = "/power", method = RequestMethod.GET)
    public double power() {
        return Math.pow(numbers.get(0), numbers.get(1));
    }

    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public double add(@RequestBody NumbersInput input) {
        return input.getNum1() + input.getNum2();
    }

    @RequestMapping(value = "/subtract", method = RequestMethod.POST)
    public double subtract(@RequestBody NumbersInput input) {
        return input.getNum1() - input.getNum2();
    }

    @RequestMapping(value = "/multiply", method = RequestMethod.POST)
    public double multiply(@RequestBody NumbersInput input) {
        return input.getNum1() * input.getNum2();
    }

    @RequestMapping(value = "/divide", method = RequestMethod.POST)
    public double divide(@RequestBody NumbersInput input) {
        if (input.getNum2() == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return input.getNum1() / input.getNum2();
    }

    @RequestMapping(value = "/power", method = RequestMethod.POST)
    public double power(@RequestBody NumbersInput input) {
        return Math.pow(input.getNum1(), input.getNum2());
    }

}
